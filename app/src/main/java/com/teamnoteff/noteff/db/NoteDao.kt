package com.teamnoteff.noteff.db

import androidx.room.*
import com.teamnoteff.noteff.entities.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(note: Note):Long

    @Update
    suspend fun updateNote(note: Note):Int

    @Delete
    suspend fun deleteNote(note: Note):Int

    @Query("DELETE FROM note_table")
    suspend fun deleteAll():Int

    @Query("SELECT * FROM note_table")
    fun getAllNotes():Flow<List<Note>>
}