package com.teamnoteff.noteff.ui.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teamnoteff.noteff.entities.DataSegment
import com.teamnoteff.noteff.entities.PlainTextDataSegment
import com.teamnoteff.noteff.repositories.NoteRepository

class CreateNoteViewModel(
    private val noteRepository: NoteRepository
    ) : ViewModel() {

    //data segment list
    private val datasegments = MutableLiveData<ArrayList<DataSegment>>()

    fun insertDataSegment(segment: DataSegment){
        datasegments.value?.apply{
            add(segment)
        }
    }
}