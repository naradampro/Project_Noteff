package com.teamnoteff.noteff.ui.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teamnoteff.noteff.entities.*
import com.teamnoteff.noteff.repositories.NoteRepository

class CreateNoteViewModel(
    private val noteRepository: NoteRepository
    ) : ViewModel() {

    //data segment list
    val datasegments = MutableLiveData<ArrayList<DataSegment>>(arrayListOf())

    fun insertDataSegment(segment: DataSegment){
        datasegments.value?.add(segment)
    }

    fun removeDataSegment(segment: DataSegment){
        datasegments.value?.remove(segment)
    }

    fun updateDataSegment(index:Int,content: String){
        when(val listItem = datasegments.value?.get(index)){
            is PlainTextDataSegment -> {
                listItem.content = content
                listItem.let { datasegments.value?.set(index, it) }
            }
            is ImportantTextDataSegment -> {
                listItem.content = content
                listItem.let { datasegments.value?.set(index, it) }
            }
            is LinkDataSegment -> {
                listItem.content = content
                listItem.let { datasegments.value?.set(index, it) }
            }
            is PhoneNumberDataSegment -> {
                listItem.content = content
                listItem.let { datasegments.value?.set(index, it) }
            }
        }

    }

}
