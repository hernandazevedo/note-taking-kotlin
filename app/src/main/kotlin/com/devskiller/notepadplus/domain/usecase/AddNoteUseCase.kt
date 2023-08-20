package com.devskiller.notepadplus.domain.usecase

import com.devskiller.notepadplus.data.datasource.NoteRepositoryImpl
import com.devskiller.notepadplus.domain.Note
import com.devskiller.notepadplus.domain.repository.NoteRepository

class AddNoteUseCase(private val noteRepository: NoteRepository = NoteRepositoryImpl()) {
    suspend operator fun invoke(note: Note): Boolean {
        return noteRepository.addNote(note)
    }
}