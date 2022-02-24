package com.teamnoteff.noteff.db

import androidx.room.*
import com.teamnoteff.noteff.entities.UserConfig
import kotlinx.coroutines.flow.Flow

@Dao
interface UserConfigDao {

    @Insert
    suspend fun insertUserConfig(userConfig: UserConfig):Long

    @Update
    suspend fun updateUserConfig(userConfig: UserConfig):Int

    @Delete
    suspend fun deleteUserConfig(userConfig: UserConfig):Int

    @Query("DELETE FROM user_config_table")
    suspend fun deleteAll():Int

    @Query("SELECT * FROM user_config_table")
    fun getAllUserConfigs():Flow<List<UserConfig>>
}