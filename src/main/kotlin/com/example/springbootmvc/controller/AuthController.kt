package com.example.springbootmvc.controller

import com.example.springbootmvc.dto.LoginRequest
import com.example.springbootmvc.dto.LoginResponse
import com.example.springbootmvc.service.UserService
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/auth"], produces = [MediaType.APPLICATION_JSON_VALUE])
class AuthController(private val userService: UserService) {

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        return ResponseEntity.ok(userService.login(request))
    }
}
