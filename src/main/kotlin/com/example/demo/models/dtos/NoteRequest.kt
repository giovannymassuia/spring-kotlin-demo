package com.example.demo.models.dtos

import java.util.*
import javax.validation.constraints.NotEmpty

data class NoteRequest(
    val id: UUID?, 
    @field:NotEmpty val text: String)
