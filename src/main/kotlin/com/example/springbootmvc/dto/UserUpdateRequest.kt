package com.example.springbootmvc.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UserUpdateRequest(
    @field:NotBlank @field:Size(min = 4, max = 50) val username: String,
    @field:NotBlank @field:Email @field:Size(max = 100) val email: String
)
