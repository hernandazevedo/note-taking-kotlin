package com.devskiller.notepadplus.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.devskiller.notepadplus.data.datasource.NoteLab
import com.devskiller.notepadplus.R
import com.devskiller.notepadplus.databinding.ActivityChangeNoteBinding
import java.util.UUID

class ChangeNoteActivity : BaseActivity() {

    companion object {

        private const val EXTRA_NOTE_ID = "com.devskiller.intent.note_id"

        fun newIntent(
            context: Context,
            uuid: UUID
        ): Intent = Intent(context, ChangeNoteActivity::class.java)
                .putExtra(EXTRA_NOTE_ID, uuid)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding = ActivityChangeNoteBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        // START YOUR CHANGE

        val editTextDescription = viewBinding.etDescription
        val editTextTitle = viewBinding.etTitle

        val noteID = intent.extras?.get(EXTRA_NOTE_ID) as UUID
        val note = NoteLab.getNote(noteID)
        if (note != null) {
            editTextDescription.setText(note.description)
            editTextTitle.setText(note.title)
        }

        viewBinding.bSave.setOnClickListener {
            val description = editTextDescription.text.toString()
            val title: String = editTextTitle.text.toString()

            if (title.isEmpty()) {
                editTextTitle.error = getString(R.string.field_not_be_empty_error)
                return@setOnClickListener
            }

            if (note != null) {
                note.title = title
                note.description = description
            }
            finish()
        }
        // END YOUR CHANGE
    }
}
