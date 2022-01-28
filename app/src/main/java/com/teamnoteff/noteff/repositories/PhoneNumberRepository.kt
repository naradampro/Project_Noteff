package com.teamnoteff.noteff.repositories

import android.provider.ContactsContract
import com.teamnoteff.noteff.db.NoteCategoryDao
import com.teamnoteff.noteff.db.PhoneNumberDataSegmentDao
import com.teamnoteff.noteff.entities.NoteCategory
import com.teamnoteff.noteff.entities.PhoneNumberDataSegment

class PhoneNumberRepository (private val dao: PhoneNumberDataSegmentDao) {

    val phoneNumber = dao.getAllPhoneNumberDataSegments()

    suspend fun insert(phoneNumber: PhoneNumberDataSegment): Long {
        return dao.insertPhoneNumberDataSegment(phoneNumber)
    }

    suspend fun update(phoneNumber: PhoneNumberDataSegment): Int{
        return dao.updatePhoneNumberDataSegment(phoneNumber)
    }

    suspend fun delete(phoneNumber: PhoneNumberDataSegment): Int{
        return dao.deletePhoneNumberDataSegment(phoneNumber)
    }

    suspend fun deleteAll(phoneNumber: PhoneNumberDataSegment):Int {
        return dao.deleteAll()
    }

}