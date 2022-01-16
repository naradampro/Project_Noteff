package com.teamnoteff.noteff.ui.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.repositories.NoteRepository

class CreateNoteViewModelFactory(
    private val noteRepository: NoteRepository
    ):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CreateNoteViewModel::class.java)){
            return CreateNoteViewModel(noteRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}