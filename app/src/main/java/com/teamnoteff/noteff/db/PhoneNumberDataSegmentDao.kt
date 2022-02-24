package com.teamnoteff.noteff.db

import androidx.room.*
import com.teamnoteff.noteff.entities.PhoneNumberDataSegment
import kotlinx.coroutines.flow.Flow

@Dao
interface PhoneNumberDataSegmentDao {

    @Insert
    suspend fun insertPhoneNumberDataSegment(phoneNumberDataSegment: PhoneNumberDataSegment):Long

    @Update
    suspend fun updatePhoneNumberDataSegment(phoneNumberDataSegment: PhoneNumberDataSegment):Int

    @Delete
    suspend fun deletePhoneNumberDataSegment(phoneNumberDataSegment: PhoneNumberDataSegment):Int

    @Query("DELETE FROM phonenumber_data_segment_table")
    suspend fun deleteAll():Int

    @Query("SELECT * FROM phonenumber_data_segment_table")
    fun getAllPhoneNumberDataSegments():Flow<List<PhoneNumberDataSegment>>

    @Query("SELECT * FROM phonenumber_data_segment_table WHERE note_id=:noteId")
    fun getDSListByNoteId(noteId: Int): Flow<List<PhoneNumberDataSegment>>
}