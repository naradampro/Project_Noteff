package com.teamnoteff.noteff.repositories

import com.teamnoteff.noteff.db.DataSegmentTypeDao
import com.teamnoteff.noteff.entities.DataSegmentType


class DataSegmentTypeRepository(private val dao: DataSegmentTypeDao) {

    val dataSegmentTypes = dao.getAllDataSegmentTypes()

    suspend fun insert(dataSegmentType: DataSegmentType):Long{
        return dao.insertDataSegmentType(dataSegmentType)
    }

    suspend fun update(dataSegmentType: DataSegmentType):Int{
        return dao.updateDataSegmentType(dataSegmentType)
    }

    suspend fun delete(dataSegmentType: DataSegmentType):Int{
        return dao.deleteDataSegmentType(dataSegmentType)
    }

    suspend fun deleteAll(dataSegmentType: DataSegmentType):Int{
        return dao.deleteAll()
    }
}