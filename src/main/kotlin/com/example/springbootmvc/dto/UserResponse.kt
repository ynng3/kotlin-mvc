package com.example.springbootmvc.dto

import com.example.springbootmvc.domain.user.User
import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val username: String,
    val email: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun from(user: User) = UserResponse(
            user.id!!,
            user.username,
            user.email,
            user.createdAt!!,
            user.updatedAt!!
        )
    }
}
