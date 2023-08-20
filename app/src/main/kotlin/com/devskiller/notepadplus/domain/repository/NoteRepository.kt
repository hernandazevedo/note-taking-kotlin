package com.devskiller.notepadplus.domain.repository

import com.devskiller.notepadplus.domain.Note

interface NoteRepository {
    suspend fun addNote(note: Note): Boolean
    suspend fun getNotes(): List<Note>
}