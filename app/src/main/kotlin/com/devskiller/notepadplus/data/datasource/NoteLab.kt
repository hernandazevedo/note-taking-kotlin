package com.devskiller.notepadplus.data.datasource

import androidx.annotation.VisibleForTesting
import com.devskiller.notepadplus.domain.Note
import java.util.UUID

object NoteLab {

    private val mNotes = mutableListOf<Note>()

    val notes: List<Note>
        get() = mNotes

    fun addNote(note: Note) {
        mNotes.add(note)
    }

    fun getNote(uuid: UUID): Note? = mNotes.firstOrNull { note ->
        note.id == uuid
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal fun clear() = mNotes.clear()
}
