package com.teamnoteff.noteff.repositories

import com.teamnoteff.noteff.db.*
import com.teamnoteff.noteff.entities.Note
import com.teamnoteff.noteff.entities.NoteCategory
import kotlinx.coroutines.flow.Flow

class NoteViewUpdateRepository(
    private val noteDao: NoteDao,
    private val categoryDao: NoteCategoryDao,
    private val plainTextDataSegmentDao: PlainTextDataSegmentDao,
    private val importantTextDataSegmentDao: ImportantTextDataSegmentDao,
    private val phoneNumberDataSegmentDao: PhoneNumberDataSegmentDao,
    private val linkDataSegmentDao: LinkDataSegmentDao,
    private val imageDataSegmentDao: ImageDataSegmentDao
) {
    fun getDataSegments(noteID: Any) {
        //TODO()
    }

    fun getNoteDataCore(noteId:Int): Flow<List<Note>> {
        return noteDao.getNoteById(noteId)
    }

    fun getCategoryById(catId:Int): Flow<List<NoteCategory>> {
        return categoryDao.getCategoryById(catId)
    }
}