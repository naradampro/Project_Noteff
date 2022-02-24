package com.teamnoteff.noteff.repositories

import com.teamnoteff.noteff.db.ImportantTextDataSegmentDao
import com.teamnoteff.noteff.db.NoteCategoryDao
import com.teamnoteff.noteff.entities.ImportantTextDataSegment
import com.teamnoteff.noteff.entities.NoteCategory

class ImportantTextDataRepository (private val dao: ImportantTextDataSegmentDao) {

    val importantTextData = dao.getAllImportantTextDataSegments()

    suspend fun insert(importantTextData: ImportantTextDataSegment): Long {
        return dao.insertImportantTextDataSegment(importantTextData)
    }

    suspend fun update(importantTextData: ImportantTextDataSegment): Int{
        return dao.updateImportantTextDataSegment(importantTextData)
    }

    suspend fun delete(importantTextData: ImportantTextDataSegment): Int{
        return dao.deleteImportantTextDataSegment(importantTextData)
    }

    suspend fun deleteAll(importantTextData: ImportantTextDataSegment):Int {
        return dao.deleteAll()
    }

}