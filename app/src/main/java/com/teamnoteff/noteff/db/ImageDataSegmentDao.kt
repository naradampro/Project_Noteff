package com.teamnoteff.noteff.db

import androidx.room.*
import com.teamnoteff.noteff.entities.ImageDataSegment
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDataSegmentDao {

    @Insert
    suspend fun insertImageDataSegment(imageDataSegment: ImageDataSegment):Long

    @Update
    suspend fun updateImageDataSegment(imageDataSegment: ImageDataSegment):Int

    @Delete
    suspend fun deleteImageDataSegment(imageDataSegment: ImageDataSegment):Int

    @Query("DELETE FROM image_data_segment_table")
    suspend fun deleteAll():Int

    @Query("SELECT * FROM image_data_segment_table")
    fun getAllImageDataSegments():Flow<List<ImageDataSegment>>
}