package com.teamnoteff.noteff.ui.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamnoteff.noteff.entities.*
import com.teamnoteff.noteff.repositories.NoteCreationRepository
import com.teamnoteff.noteff.repositories.NoteRepository
import kotlinx.coroutines.launch

class CreateNoteViewModel(
    private val repository: NoteCreationRepository
    ) : ViewModel() {

    //data segment list
    val datasegments = MutableLiveData<ArrayList<DataSegment>>(arrayListOf())

    fun insertDataSegment(segment: DataSegment){
        datasegments.value?.add(segment)
    }

    fun removeDataSegment(segment: DataSegment){
        datasegments.value?.remove(segment)
    }

    fun saveNote(note: Note) = viewModelScope.launch {
        repository.insertNote(note)
    }

    fun saveCategory(category: NoteCategory) = viewModelScope.launch {
        repository.insertCategory(category)
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
