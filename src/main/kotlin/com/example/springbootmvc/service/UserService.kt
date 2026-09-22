package com.example.springbootmvc.service

import com.example.springbootmvc.dto.*

interface UserService {
    fun create(request: UserCreateRequest): UserResponse
    fun update(id: Long, request: UserUpdateRequest): UserResponse
    fun delete(id: Long)
    fun getById(id: Long): UserResponse
    fun login(request: LoginRequest): LoginResponse
}
