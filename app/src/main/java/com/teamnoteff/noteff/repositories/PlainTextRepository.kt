package com.teamnoteff.noteff.repositories

import com.teamnoteff.noteff.db.NoteCategoryDao
import com.teamnoteff.noteff.db.PlainTextDataSegmentDao
import com.teamnoteff.noteff.entities.NoteCategory
import com.teamnoteff.noteff.entities.PlainTextDataSegment

class PlainTextRepository (private val dao: PlainTextDataSegmentDao) {

    val plainText = dao.getAllPlainTextDataSegments()

    suspend fun insert(plainText: PlainTextDataSegment): Long {
        return dao.insertPlainTextDataSegment(plainText)
    }

    suspend fun update(plainText: PlainTextDataSegment): Int{
        return dao.updatePlainTextDataSegment(plainText)
    }

    suspend fun delete(plainText: PlainTextDataSegment): Int{
        return dao.deletePlainTextDataSegment(plainText)
    }

    suspend fun deleteAll(plainText: PlainTextDataSegment):Int {
        return dao.deleteAll()
    }

}