package com.example.springbootmvc.dto

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val userId: Long? = null,
    val username: String? = null
) {
    companion object {
        fun success(userId: Long, username: String) = LoginResponse(true, "Login successful.", userId, username)
        fun fail(message: String) = LoginResponse(false, message, null, null)
    }
}
