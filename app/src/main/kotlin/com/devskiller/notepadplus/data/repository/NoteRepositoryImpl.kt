package com.devskiller.notepadplus.data.datasource

import com.devskiller.notepadplus.domain.Note
import com.devskiller.notepadplus.domain.repository.NoteRepository


class NoteRepositoryImpl(val noteDatasource: NoteLab = NoteLab): NoteRepository {
    override suspend fun addNote(note: Note): Boolean {
        noteDatasource.addNote(note)
        return true
    }

    override suspend fun getNotes(): List<Note> {
        return noteDatasource.notes
    }
}