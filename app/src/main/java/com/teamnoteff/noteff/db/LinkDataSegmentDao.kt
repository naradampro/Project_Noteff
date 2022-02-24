package com.teamnoteff.noteff.db

import androidx.room.*
import com.teamnoteff.noteff.entities.LinkDataSegment
import kotlinx.coroutines.flow.Flow

@Dao
interface LinkDataSegmentDao {
    @Insert
    suspend fun insertLinkDataSegment(linkDataSegment: LinkDataSegment):Long

    @Update
    suspend fun updateLinkDataSegment(linkDataSegment: LinkDataSegment):Int

    @Delete
    suspend fun deleteLinkDataSegment(linkDataSegment: LinkDataSegment):Int

    @Query("DELETE FROM link_data_segment_table")
    suspend fun deleteAll():Int

    @Query("SELECT*FROM link_data_segment_table")
    fun getAllLinkDataSegments():Flow<List<LinkDataSegment>>

    @Query("SELECT*FROM link_data_segment_table WHERE note_id=:noteId")
    fun getDSListByNoteId(noteId: Int): Flow<List<LinkDataSegment>>
}