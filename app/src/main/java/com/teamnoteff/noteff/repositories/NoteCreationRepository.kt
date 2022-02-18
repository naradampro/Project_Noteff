package com.teamnoteff.noteff.repositories

import com.teamnoteff.noteff.db.NoteCategoryDao
import com.teamnoteff.noteff.db.NoteDao
import com.teamnoteff.noteff.entities.Note
import com.teamnoteff.noteff.entities.NoteCategory

class NoteCreationRepository(private val noteDao: NoteDao, private val categoryDao: NoteCategoryDao) {

    val notes = noteDao.getAllNotes()

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
}