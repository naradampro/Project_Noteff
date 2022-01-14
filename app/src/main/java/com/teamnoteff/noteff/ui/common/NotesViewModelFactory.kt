package com.teamnoteff.noteff.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.repositories.NoteRepository

class NotesViewModelFactory(
    private val noteRepository: NoteRepository
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NotesViewModel::class.java)){
            return NotesViewModel(noteRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}