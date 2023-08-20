package com.devskiller.notepadplus.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.devskiller.notepadplus.R
import com.devskiller.notepadplus.databinding.ActivityMainBinding
import com.devskiller.notepadplus.domain.Note


class MainActivity : BaseActivity() {
    val viewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(ActivityMainBinding.inflate(layoutInflater).root)

        // START YOUR CHANGE
        handleFragmentChange()

        // END YOUR CHANGE
    }

    private fun handleFragmentChange() {
        viewModel.viewModelState.observe(this) {
            when (it) {
                is NotesViewModelState.WelcomeState -> {
                    replaceFragment(R.id.fl_fragment_container,
                        WelcomeFragment.newInstance(),
                        "WelcomeFragment")
                }
                NotesViewModelState.ListState -> {
                    replaceFragment(R.id.fl_fragment_container,
                        NoteListFragment.newInstance(),
                        "NoteListFragment")
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.menu, menu)

        //* `welcome_fragment` with `welcome_message` and `CreateNoteButton()` are displayed if there aren’t any other notes visible.
        //TODO understand better this logic, because if there are notes, should I make the button invisible?
//        val item = menu.findItem(R.id.create_note)
//        item.isVisible = NoteLab.notes.isEmpty()

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.create_note -> {
            // START YOUR CHANGE
            val note = Note()
            viewModel.addNote(note)
            startActivity(ChangeNoteActivity.newIntent(this, note.id))
            // END YOUR CHANGE
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
