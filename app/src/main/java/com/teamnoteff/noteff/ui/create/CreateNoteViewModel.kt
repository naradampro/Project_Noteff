package com.teamnoteff.noteff.ui.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teamnoteff.noteff.repositories.NoteRepository

class CreateNoteViewModel(
    private val noteRepository: NoteRepository
    ) : ViewModel() {

    var name:String = "Narada"

}