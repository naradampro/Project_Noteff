package com.teamnoteff.noteff.ui.updateview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.repositories.NoteViewUpdateRepository

class UpdateViewViewModelFactory(
    private val noteViewUpdateRepository: NoteViewUpdateRepository,
    private val noteId:Int
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UpdateViewViewModel::class.java)){
            return UpdateViewViewModel(noteViewUpdateRepository,noteId) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}