package com.teamnoteff.noteff.db

import androidx.room.*
import com.teamnoteff.noteff.entities.DataSegmentType
import kotlinx.coroutines.flow.Flow

@Dao
interface DataSegmentTypeDao {

    @Insert
    suspend fun insertDataSegmentType(dataSegmentType: DataSegmentType):Long

    @Update
    suspend fun updateDataSegmentType(dataSegmentType: DataSegmentType):Int

    @Delete
    suspend fun deleteDataSegmentType(dataSegmentType: DataSegmentType):Int

    @Query("DELETE FROM data_segment_type_table")
    suspend fun deleteAll():Int

    @Query("SELECT*FROM data_segment_type_table")
    fun getAllDataSegmentTypes():Flow<List<DataSegmentType>>
}