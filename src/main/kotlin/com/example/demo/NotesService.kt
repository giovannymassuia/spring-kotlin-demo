package com.example.demo

import com.example.demo.models.Note
import com.example.demo.models.dtos.NoteRequest
import com.example.demo.repositories.NotesRepository
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.*

@Service
class NotesService(val repository: NotesRepository) {
    
    fun findAll() = repository.findAll()
    
    fun findById(id: UUID) = repository.findById(id)
    
    fun create(request: NoteRequest) = repository.save(request.text)

    fun update(request: NoteRequest) = when {
        request.id != null -> repository.save(Note(request.id, request.text))
        else -> throw IllegalArgumentException("missing id")
    }

    fun deleteById(id: UUID) = repository.deleteById(id)
}