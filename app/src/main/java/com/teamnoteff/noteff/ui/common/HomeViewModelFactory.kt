package com.teamnoteff.noteff.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.repositories.CategoryRepository
import com.teamnoteff.noteff.repositories.NoteRepository

class HomeViewModelFactory(
    private val noteRepository: NoteRepository,
    private val categoryRepository: CategoryRepository
    ): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(noteRepository,categoryRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}