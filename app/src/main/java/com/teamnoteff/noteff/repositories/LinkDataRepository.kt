package com.teamnoteff.noteff.repositories

import com.teamnoteff.noteff.db.LinkDataSegmentDao
import com.teamnoteff.noteff.db.NoteCategoryDao
import com.teamnoteff.noteff.entities.LinkDataSegment
import com.teamnoteff.noteff.entities.NoteCategory

class LinkDataRepository (private val dao: LinkDataSegmentDao) {

    val linkData = dao.getAllLinkDataSegments()

    suspend fun insert(linkData: LinkDataSegment): Long {
        return dao.insertLinkDataSegment(linkData)
    }

    suspend fun update(linkData: LinkDataSegment): Int{
        return dao.updateLinkDataSegment(linkData)
    }

    suspend fun delete(linkData: LinkDataSegment): Int{
        return dao.deleteLinkDataSegment(linkData)
    }

    suspend fun deleteAll(linkData: LinkDataSegment):Int {
        return dao.deleteAll()
    }

}