package com.teamnoteff.noteff.ui.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teamnoteff.noteff.entities.DataSegment
import com.teamnoteff.noteff.entities.ImportantTextDataSegment
import com.teamnoteff.noteff.repositories.NoteRepository

class CreateNoteViewModel(
    private val noteRepository: NoteRepository
    ) : ViewModel() {

    //data segment list
    val datasegments = MutableLiveData<ArrayList<DataSegment>>(arrayListOf())

    fun insertDataSegment(segment: DataSegment){
        datasegments.value?.add(segment)
    }
}
