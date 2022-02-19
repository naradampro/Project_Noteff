package com.teamnoteff.noteff.db

import androidx.room.*
import com.teamnoteff.noteff.entities.NoteCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteCategoryDao {

    @Insert
    suspend fun insertCategory(category: NoteCategory):Long

    @Update
    suspend fun updateCategory(category: NoteCategory):Int

    @Delete
    suspend fun deleteCategory(category: NoteCategory):Int

    @Query("DELETE FROM category_table")
    suspend fun deleteAll():Int

    @Query("SELECT * FROM category_table")
    fun getAllCategories():Flow<List<NoteCategory>>

    @Query("SELECT * FROM category_table WHERE id=:id")
    fun getCategoryById(id: Int): Flow<List<NoteCategory>>
}