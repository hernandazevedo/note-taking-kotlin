package com.devskiller.notepadplus.domain.usecase

import com.devskiller.notepadplus.data.datasource.NoteRepositoryImpl
import com.devskiller.notepadplus.domain.Note
import com.devskiller.notepadplus.domain.repository.NoteRepository

class GetNotesUseCase(private val noteRepository: NoteRepository = NoteRepositoryImpl()) {
    suspend operator fun invoke(): List<Note> {
        return noteRepository.getNotes()
    }
}