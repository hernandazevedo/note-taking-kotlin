package com.devskiller.notepadplus.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devskiller.notepadplus.domain.Note
import com.devskiller.notepadplus.domain.usecase.AddNoteUseCase
import com.devskiller.notepadplus.domain.usecase.GetNotesUseCase
import kotlinx.coroutines.launch

sealed class NotesViewModelState {
    object WelcomeState : NotesViewModelState()
    object ListState : NotesViewModelState()
}

class NotesViewModel(
    private val addNoteUseCase: AddNoteUseCase = AddNoteUseCase(),
    private val getNoteUseCase: GetNotesUseCase = GetNotesUseCase(),
) : ViewModel() {
    private val _viewModelState = MutableLiveData<NotesViewModelState>()
    val viewModelState: LiveData<NotesViewModelState>
        get() = _viewModelState

    init {
        changeViewModelState()
    }

    private fun changeViewModelState() {
        viewModelScope.launch(CoroutineDispatchers.backgroundThread) {
            if (getNoteUseCase().isEmpty()) {
                _viewModelState.postValue(NotesViewModelState.WelcomeState)
            } else {
                if (_viewModelState.value != NotesViewModelState.ListState)
                    _viewModelState.postValue(NotesViewModelState.ListState)
            }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch(CoroutineDispatchers.backgroundThread) {
        if (addNoteUseCase(note = note))
            changeViewModelState()
    }

}