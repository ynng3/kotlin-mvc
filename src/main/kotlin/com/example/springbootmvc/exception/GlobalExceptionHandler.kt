package com.example.springbootmvc.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleNotFound(ex: ResourceNotFoundException): ResponseEntity<Map<String, Any>> {
        val body = mapOf("status" to HttpStatus.NOT_FOUND.value(), "message" to ex.message)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(ex: IllegalArgumentException): ResponseEntity<Map<String, Any>> {
        val body = mapOf("status" to HttpStatus.BAD_REQUEST.value(), "message" to ex.message)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, Any>> {
        val errors = mutableMapOf<String, String?>()
        for (fieldError: FieldError in ex.bindingResult.fieldErrors) {
            errors[fieldError.field] = fieldError.defaultMessage
        }
        val body = mapOf("status" to HttpStatus.BAD_REQUEST.value(), "message" to "Validation failed.", "errors" to errors)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body)
    }
}
