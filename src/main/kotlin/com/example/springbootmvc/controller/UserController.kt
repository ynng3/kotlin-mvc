package com.example.springbootmvc.controller

import com.example.springbootmvc.dto.UserCreateRequest
import com.example.springbootmvc.dto.UserResponse
import com.example.springbootmvc.dto.UserUpdateRequest
import com.example.springbootmvc.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/users"], produces = [MediaType.APPLICATION_JSON_VALUE])
class UserController(private val userService: UserService) {

    @PostMapping
    fun create(@Valid @RequestBody request: UserCreateRequest): ResponseEntity<UserResponse> {
        val response = userService.create(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody request: UserUpdateRequest): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userService.update(id, request))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        userService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<UserResponse> {
        return ResponseEntity.ok(userService.getById(id))
    }
}
