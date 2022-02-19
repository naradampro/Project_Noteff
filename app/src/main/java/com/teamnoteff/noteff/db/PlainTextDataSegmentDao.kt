package com.teamnoteff.noteff.db

import androidx.room.*
import com.teamnoteff.noteff.entities.PlainTextDataSegment
import kotlinx.coroutines.flow.Flow

@Dao
interface PlainTextDataSegmentDao {

    @Insert
    suspend fun insertPlainTextDataSegment(plainTextDataSegment: PlainTextDataSegment):Long

    @Update
    suspend fun updatePlainTextDataSegment(plainTextDataSegment: PlainTextDataSegment):Int

    @Delete
    suspend fun deletePlainTextDataSegment(plainTextDataSegment: PlainTextDataSegment):Int

    @Query("DELETE FROM plaintext_data_segment_table")
    suspend fun deleteAll():Int

    @Query("SELECT * FROM plaintext_data_segment_table")
    fun getAllPlainTextDataSegments():Flow<List<PlainTextDataSegment>>

    @Query("SELECT * FROM plaintext_data_segment_table WHERE note_id =:noteId")
    fun getDSByNoteId(noteId:Int):Flow<List<PlainTextDataSegment>>
}