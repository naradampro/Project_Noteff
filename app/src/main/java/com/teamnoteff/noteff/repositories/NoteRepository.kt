package com.teamnoteff.noteff.repositories

import com.teamnoteff.noteff.db.NoteDao
import com.teamnoteff.noteff.entities.Note

class NoteRepository(private val dao: NoteDao) {

    val notes = dao.getAllNotes()

    suspend fun insert(note: Note): Long {
        return dao.insertNote(note)
    }

    suspend fun update(note: Note): Int{
        return dao.updateNote(note)
    }

    suspend fun delete(note: Note): Int{
        return dao.deleteNote(note)
    }

    suspend fun deleteAll(note: Note):Int {
        return dao.deleteAll()
    }
}