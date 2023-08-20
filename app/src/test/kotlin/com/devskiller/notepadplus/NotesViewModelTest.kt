package com.devskiller.notepadplus

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.devskiller.notepadplus.data.datasource.NoteLab
import com.devskiller.notepadplus.domain.Note
import com.devskiller.notepadplus.domain.usecase.AddNoteUseCase
import com.devskiller.notepadplus.domain.usecase.GetNotesUseCase
import com.devskiller.notepadplus.presentation.NotesViewModel
import com.devskiller.notepadplus.presentation.NotesViewModelState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
@OptIn(ExperimentalCoroutinesApi::class)
class NotesViewModelTest {
    val addNoteUseCase: AddNoteUseCase = mockk()
    val getNotesUseCase: GetNotesUseCase = mockk()
    val note = Note()
    val notesList = listOf(note)
    lateinit var viewModel: NotesViewModel

    @get:Rule
    val instantExecutorRule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        coEvery { addNoteUseCase.invoke(any()) } returns true
        coEvery { getNotesUseCase.invoke() } returns notesList
        viewModel = NotesViewModel(addNoteUseCase = addNoteUseCase, getNoteUseCase = getNotesUseCase)
        NoteLab.clear()
    }


    @Test
    fun shouldAddNote() = runBlockingTest {

        val expectedResult: MutableLiveData<NotesViewModelState> = MutableLiveData()
        expectedResult.value = NotesViewModelState.ListState
        viewModel.addNote(note)

        Assert.assertEquals(expectedResult.value, viewModel.viewModelState.value)
    }
}