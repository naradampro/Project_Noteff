package com.teamnoteff.noteff.ui.updateview

import androidx.lifecycle.*
import com.teamnoteff.noteff.entities.DataSegment
import com.teamnoteff.noteff.entities.Note
import com.teamnoteff.noteff.entities.NoteCategory
import com.teamnoteff.noteff.repositories.NoteViewUpdateRepository
import kotlinx.coroutines.launch

class UpdateViewViewModel(
    private val repository: NoteViewUpdateRepository,
    private val noteId: Int
): ViewModel() {
    //data segment list
    var dataSegments = MutableLiveData<ArrayList<DataSegment>>(arrayListOf())

    private fun initDataSegments() {
        viewModelScope.launch {
            dataSegments =
                repository.getDataSegments(noteId) as MutableLiveData<ArrayList<DataSegment>>
        }
    }

    fun getNoteId(): Int {
        return noteId
    }

    fun getNoteById(noteId: Int): LiveData<List<Note>> {
        return repository.getNoteDataCore(noteId).asLiveData()
    }

    fun getCategoryById(catId: Int): LiveData<List<NoteCategory>> {
        return repository.getCategoryById(catId).asLiveData()
    }
}