package com.teamnoteff.noteff.repositories

import com.teamnoteff.noteff.db.*
import com.teamnoteff.noteff.entities.*

class NoteCreationRepository(
    private val noteDao: NoteDao,
    private val categoryDao: NoteCategoryDao,
    private val plainTextDataSegmentDao: PlainTextDataSegmentDao,
    private val importantTextDataSegmentDao: ImportantTextDataSegmentDao,
    private val phoneNumberDataSegmentDao: PhoneNumberDataSegmentDao,
    private val linkDataSegmentDao: LinkDataSegmentDao,
    private val imageDataSegmentDao: ImageDataSegmentDao
) {

    val notes = noteDao.getAllNotes()
    val categories = categoryDao.getAllCategories()

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