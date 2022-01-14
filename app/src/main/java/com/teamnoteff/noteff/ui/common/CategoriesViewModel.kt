package com.teamnoteff.noteff.ui.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.teamnoteff.noteff.entities.NoteCategory
import com.teamnoteff.noteff.repositories.CategoryRepository

class CategoriesViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {
    val allCategories: LiveData<List<NoteCategory>>
        get() = categoryRepository.categories.asLiveData()
}