package com.teamnoteff.noteff.ui.startup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teamnoteff.noteff.repositories.StartUpRepository


class StartUpViewModelFactory (
    private val startUpRepository: StartUpRepository
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StartUpViewModel::class.java)){
            return StartUpViewModel(startUpRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}