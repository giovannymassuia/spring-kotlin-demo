package com.example.demo.controllers

import com.example.demo.NotesService
import com.example.demo.models.dtos.NoteRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("notes")
class NotesController(val service: NotesService) {

    @GetMapping
    fun findAll() = ResponseEntity.ok(service.findAll())

    @GetMapping("{id}")
    fun findById(@PathVariable id: UUID) = ResponseEntity
        .ok(service.findById(id))

    @PostMapping
    fun create(@Validated @RequestBody request: NoteRequest) = ResponseEntity
        .status(HttpStatus.CREATED)
        .body(service.create(request))

    @PutMapping
    fun update(@Validated @RequestBody request: NoteRequest) = ResponseEntity
        .ok(service.update(request))

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: UUID) = ResponseEntity
        .ok(service.deleteById(id))
}