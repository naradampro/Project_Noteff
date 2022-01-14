package com.teamnoteff.noteff.ui.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.teamnoteff.noteff.entities.Note
import com.teamnoteff.noteff.repositories.NoteRepository

class NotesViewModel(val noteRepository: NoteRepository) : ViewModel() {
    val allNotes: LiveData<List<Note>>
        get() = noteRepository.notes.asLiveData()
}