package com.teamnoteff.noteff.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.repositories.NoteRepository

class HomeViewModelFactory(
    private val noteRepository: NoteRepository
    ): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(noteRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}