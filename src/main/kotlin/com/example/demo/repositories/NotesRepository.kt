package com.example.demo.repositories

import com.example.demo.exceptions.NotFoundException
import com.example.demo.models.Note
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class NotesRepository {

    private var allNotes = mutableListOf<Note>()

    init {
        allNotes.add(Note(UUID.randomUUID(), "first note"))
        allNotes.add(Note(UUID.randomUUID(), "second note"))
        allNotes.add(Note(UUID.randomUUID(), "third note"))
        allNotes.add(Note(UUID.randomUUID(), "forth note"))
    }

    fun findAll() = allNotes.toList()

    fun findById(id: UUID) = allNotes.find { it.id == id } ?: throw NotFoundException("not found")

    fun existsById(id: UUID) = allNotes.any { it.id == id }

    fun save(text: String) = save(Note(null, text))

    fun save(note: Note) =
        when {
            note.id != null -> {
                val findNote = findById(note.id)
                findNote.text = note.text
                findNote
            }
            else -> {
                val newNote = Note(UUID.randomUUID(), note.text)
                allNotes.add(newNote)
                newNote
            }
        }

    fun deleteById(id: UUID) = when {
        existsById(id) -> allNotes.removeIf { it.id == id }
        else -> throw NotFoundException("not found")
    }
}