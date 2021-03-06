package com.teamnoteff.noteff.ui.updateview

import androidx.lifecycle.*
import com.teamnoteff.noteff.entities.*
import com.teamnoteff.noteff.repositories.NoteViewUpdateRepository
import kotlinx.coroutines.launch

class UpdateViewViewModel(
    private val repository: NoteViewUpdateRepository,
    private val noteId: Int
): ViewModel() {
    //data segment list
    val datasegments = MediatorLiveData<ArrayList<DataSegment>>()

    fun sortDSList(){
        datasegments.value?.sortBy { it.order }
    }

    fun setDSList(){
        datasegments.apply {
            addSource(viewPlainTextDS()){
                this.value = it as ArrayList<DataSegment>?
            }
            addSource(viewImportantTextDS()){
                this.value = it as ArrayList<DataSegment>?
            }
            addSource(viewPhoneNumberDS()){
                this.value = it as ArrayList<DataSegment>?
            }
            addSource(viewLinkDS()){
                this.value = it as ArrayList<DataSegment>?
            }
            addSource(viewImageDS()){
                this.value = it as ArrayList<DataSegment>?
            }
        }
        println("View Model data set size ${datasegments.value?.size}")
    }

    fun clearDSList(){
        datasegments.value?.clear()
    }

    fun getDataSegments(): MutableLiveData<ArrayList<DataSegment>> {
        return datasegments
    }

    private fun viewPlainTextDS(): LiveData<List<DataSegment>> {
        return repository.getPlainTextDSList(noteId).asLiveData()
    }

    private fun viewImportantTextDS(): LiveData<List<DataSegment>> {
        return repository.getImportantTextDSList(noteId).asLiveData()
    }

    private fun viewPhoneNumberDS(): LiveData<List<DataSegment>> {
        return repository.getPhoneNUmberDSList(noteId).asLiveData()
    }

    private fun viewLinkDS(): LiveData<List<DataSegment>> {
        return repository.getLinkDSList(noteId).asLiveData()
    }

    private fun viewImageDS(): LiveData<List<DataSegment>> {
        return repository.getImageDSList(noteId).asLiveData()
    }

    fun getNoteById(): LiveData<List<Note>> {
        return repository.getNoteDataCore(noteId).asLiveData()
    }

    fun getCategoryById(catId: Int): LiveData<List<NoteCategory>> {
        return repository.getCategoryById(catId).asLiveData()
    }

    fun getAllExistingCategories(): LiveData<List<NoteCategory>> {
        return repository.categories.asLiveData()
    }

    fun insertDataSegment(segment: DataSegment){
        datasegments.value?.add(segment)
    }

    fun removeDataSegment(segment: DataSegment){
        datasegments.value!!.remove(segment)
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