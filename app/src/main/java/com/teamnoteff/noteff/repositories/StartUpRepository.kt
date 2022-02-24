package com.teamnoteff.noteff.repositories

import com.teamnoteff.noteff.db.NoteCategoryDao
import com.teamnoteff.noteff.db.UserConfigDao
import com.teamnoteff.noteff.entities.Note
import com.teamnoteff.noteff.entities.NoteCategory
import com.teamnoteff.noteff.entities.UserConfig

class StartUpRepository(private val userConfigDao: UserConfigDao, private val noteCategoryDao: NoteCategoryDao) {

    val userConfigs = userConfigDao.getAllUserConfigs()

    suspend fun insert(userConfig: UserConfig): Long {
        return userConfigDao.insertUserConfig(userConfig)
    }

    suspend fun update(userConfig: UserConfig): Int{
        return userConfigDao.updateUserConfig(userConfig)
    }

    suspend fun delete(userConfig: UserConfig): Int{
        return userConfigDao.deleteUserConfig(userConfig)
    }

    suspend fun deleteAll(userConfig: UserConfig):Int {
        return userConfigDao.deleteAll()
    }

    suspend fun insert(category: NoteCategory): Long {
        return noteCategoryDao.insertCategory(category)
    }
}