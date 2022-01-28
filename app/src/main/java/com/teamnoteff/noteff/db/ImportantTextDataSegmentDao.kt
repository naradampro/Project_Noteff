package com.teamnoteff.noteff.db

import androidx.room.*
import com.teamnoteff.noteff.entities.ImportantTextDataSegment
import kotlinx.coroutines.flow.Flow

@Dao
interface ImportantTextDataSegmentDao {

    @Insert
    suspend fun insertImportantTextDataSegment(importantTextDataSegment: ImportantTextDataSegment):Long

    @Update
    suspend fun updateImportantTextDataSegment(importantTextDataSegment: ImportantTextDataSegment):Int

    @Delete
    suspend fun deleteImportantTextDataSegment(importantTextDataSegment: ImportantTextDataSegment):Int

    @Query("DELETE FROM importanttext_data_segment_table")
    suspend fun deleteAll():Int

    @Query("SELECT * FROM importanttext_data_segment_table")
    fun getAllImportantTextDataSegments():Flow<List<ImportantTextDataSegment>>
}