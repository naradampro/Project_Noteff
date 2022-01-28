package com.teamnoteff.noteff.repositories

import com.teamnoteff.noteff.db.ImageDataSegmentDao
import com.teamnoteff.noteff.db.NoteCategoryDao
import com.teamnoteff.noteff.entities.ImageDataSegment
import com.teamnoteff.noteff.entities.NoteCategory

class ImageDataRepository(private val dao: ImageDataSegmentDao) {

    val imageData = dao.getAllImageDataSegments()

    suspend fun insert(imageData: ImageDataSegment): Long {
        return dao.insertImageDataSegment(imageData)
    }

    suspend fun update(imageData: ImageDataSegment): Int{
        return dao.updateImageDataSegment(imageData)
    }

    suspend fun delete(imageData: ImageDataSegment): Int{
        return dao.deleteImageDataSegment(imageData)
    }

    suspend fun deleteAll(imageData: ImageDataSegment):Int {
        return dao.deleteAll()
    }

}