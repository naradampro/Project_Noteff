package com.teamnoteff.noteff.ui.create

import androidx.lifecycle.*
import com.teamnoteff.noteff.entities.*
import com.teamnoteff.noteff.repositories.NoteCreationRepository
import kotlinx.coroutines.launch

class CreateNoteViewModel(
    private val repository: NoteCreationRepository
    ) : ViewModel() {

    //data segment list
    val datasegments = MutableLiveData<ArrayList<DataSegment>>(arrayListOf())

    fun getAllExistingCategories(): LiveData<List<NoteCategory>> {
        return repository.categories.asLiveData()
    }

    fun insertDataSegment(segment: DataSegment){
        datasegments.value?.add(segment)
    }

    fun removeDataSegment(segment: DataSegment){
        datasegments.value?.remove(segment)
    }

    private fun saveAllDataSegments(noteId:Int){
        datasegments.observeForever { dsList ->
            dsList.forEach { ds ->
                saveADataSegment(noteId,ds,dsList.indexOf(ds))
            }
        }
    }

    private fun saveADataSegment(noteId: Int, ds: DataSegment, indexOfDsList: Int){
        ds.noteId = noteId
        ds.order = indexOfDsList
        viewModelScope.launch {
            when (ds) {
                is PlainTextDataSegment -> {
                    repository.insertPlainTextDS(ds)
                }
                is ImportantTextDataSegment -> {
                    repository.insertImportantTextDS(ds)
                }
                is PhoneNumberDataSegment -> {
                    repository.insertPhoneNumberDS(ds)
                }
                is LinkDataSegment -> {
                    repository.insertLinkDS(ds)
                }
                is ImageDataSegment -> {
                    repository.insertImageDS(ds)
                }
            }
        }
    }


    fun saveNoteWithNewCategory(title: String, displaytext: String, categoryName: String) {
        viewModelScope.launch {
            val catId:Int = repository.insertCategory(NoteCategory(0,categoryName)).toInt()
            val noteId:Int = repository.insertNote(Note(catId,title,displaytext)).toInt()
            saveAllDataSegments(noteId)
        }
    }

    fun saveNoteWithExistingCategory(title: String, displaytext: String, catId: Int) {
        viewModelScope.launch {
            val noteId:Int = repository.insertNote(Note(catId,title,displaytext)).toInt()
            saveAllDataSegments(noteId)
        }
    }

    fun saveNoteUncategorized(title: String, displaytext: String) {
        viewModelScope.launch {
            val noteId:Int = repository.insertNote(Note(title,displaytext)).toInt()
            saveAllDataSegments(noteId)
        }
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
