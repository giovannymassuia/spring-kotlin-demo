package com.example.demo.controllers

import com.example.demo.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandlerController : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(NotFoundException::class)])
    fun handleNotFoundException(ex: NotFoundException) = ResponseEntity(mapOf("message" to ex.message), HttpStatus.NOT_FOUND)

}