package com.example.springbootmvc.service

import com.example.springbootmvc.domain.user.User
import com.example.springbootmvc.domain.user.UserRepository
import com.example.springbootmvc.dto.*
import com.example.springbootmvc.exception.ResourceNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : UserService {

    override fun create(request: UserCreateRequest): UserResponse {
        if (userRepository.existsByUsername(request.username)) {
            throw IllegalArgumentException("Username is already in use.")
        }
        if (userRepository.existsByEmail(request.email)) {
            throw IllegalArgumentException("Email is already in use.")
        }

        val encoded = passwordEncoder.encode(request.password)
        val saved = userRepository.save(User(request.username, encoded, request.email))
        return UserResponse.from(saved)
    }

    override fun update(id: Long, request: UserUpdateRequest): UserResponse {
        val user = userRepository.findById(id).orElseThrow { ResourceNotFoundException("User not found. id=$id") }

        if (userRepository.existsByUsernameAndIdNot(request.username, id)) {
            throw IllegalArgumentException("Username is already in use.")
        }
        if (userRepository.existsByEmailAndIdNot(request.email, id)) {
            throw IllegalArgumentException("Email is already in use.")
        }

        user.username = request.username
        user.email = request.email

        return UserResponse.from(user)
    }

    override fun delete(id: Long) {
        val user = userRepository.findById(id).orElseThrow { ResourceNotFoundException("User not found. id=$id") }
        userRepository.delete(user)
    }

    @Transactional(readOnly = true)
    override fun getById(id: Long): UserResponse {
        val user = userRepository.findById(id).orElseThrow { ResourceNotFoundException("User not found. id=$id") }
        return UserResponse.from(user)
    }

    @Transactional(readOnly = true)
    override fun login(request: LoginRequest): LoginResponse {
        val opt = userRepository.findByUsername(request.username)
        return opt.map { user ->
            if (passwordEncoder.matches(request.password, user.password)) {
                LoginResponse.success(user.id!!, user.username)
            } else {
                LoginResponse.fail("Invalid password.")
            }
        }.orElseGet { LoginResponse.fail("User does not exist.") }
    }
}
