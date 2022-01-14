package com.teamnoteff.noteff.ui.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.repositories.CategoryRepository

class CategoriesViewModelFactory(
    private val categoryRepository: CategoryRepository
    ): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CategoriesViewModel::class.java)){
            return CategoriesViewModel(categoryRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}