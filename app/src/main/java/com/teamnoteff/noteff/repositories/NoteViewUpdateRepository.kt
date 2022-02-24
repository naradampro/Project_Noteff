package com.teamnoteff.noteff.repositories

import com.teamnoteff.noteff.db.*
import com.teamnoteff.noteff.entities.*
import kotlinx.coroutines.flow.*

class NoteViewUpdateRepository(
    private val noteDao: NoteDao,
    private val categoryDao: NoteCategoryDao,
    private val plainTextDataSegmentDao: PlainTextDataSegmentDao,
    private val importantTextDataSegmentDao: ImportantTextDataSegmentDao,
    private val phoneNumberDataSegmentDao: PhoneNumberDataSegmentDao,
    private val linkDataSegmentDao: LinkDataSegmentDao,
    private val imageDataSegmentDao: ImageDataSegmentDao
) {
    val categories = categoryDao.getAllCategories()

    fun getNoteDataCore(noteId:Int): Flow<List<Note>> {
        return noteDao.getNoteById(noteId)
    }

    fun getCategoryById(catId:Int): Flow<List<NoteCategory>> {
        return categoryDao.getCategoryById(catId)
    }

    fun getPlainTextDSList(noteId:Int): Flow<List<DataSegment>> {
        return plainTextDataSegmentDao.getDSListByNoteId(noteId)
    }

    fun getImportantTextDSList(noteId:Int): Flow<List<DataSegment>> {
        return importantTextDataSegmentDao.getDSListByNoteId(noteId)
    }

    fun getPhoneNUmberDSList(noteId:Int): Flow<List<DataSegment>> {
        return phoneNumberDataSegmentDao.getDSListByNoteId(noteId)
    }

    fun getLinkDSList(noteId:Int): Flow<List<DataSegment>> {
        return linkDataSegmentDao.getDSListByNoteId(noteId)
    }

    fun getImageDSList(noteId:Int): Flow<List<DataSegment>> {
        return imageDataSegmentDao.getDSListByNoteId(noteId)
    }

    suspend fun insertNote(note: Note): Long {
        return noteDao.insertNote(note)
    }

    suspend fun insertCategory(category: NoteCategory): Long{
        return categoryDao.insertCategory(category)
    }

    suspend fun update(note: Note): Int{
        return noteDao.updateNote(note)
    }

    suspend fun delete(note: Note): Int{
        return noteDao.deleteNote(note)
    }

    suspend fun deleteAll(note: Note):Int {
        return noteDao.deleteAll()
    }

    suspend fun insertPlainTextDS(ds: PlainTextDataSegment):Long{
        return plainTextDataSegmentDao.insertPlainTextDataSegment(ds)
    }

    suspend fun insertImportantTextDS(ds: ImportantTextDataSegment):Long{
        return importantTextDataSegmentDao.insertImportantTextDataSegment(ds)
    }

    suspend fun insertPhoneNumberDS(ds: PhoneNumberDataSegment):Long{
        return phoneNumberDataSegmentDao.insertPhoneNumberDataSegment(ds)
    }

    suspend fun insertLinkDS(ds: LinkDataSegment):Long{
        return linkDataSegmentDao.insertLinkDataSegment(ds)
    }

    suspend fun insertImageDS(ds: ImageDataSegment):Long{
        return imageDataSegmentDao.insertImageDataSegment(ds)
    }
}