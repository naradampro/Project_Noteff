package com.teamnoteff.noteff.repositories

import com.teamnoteff.noteff.db.NoteCategoryDao
import com.teamnoteff.noteff.entities.NoteCategory

class CategoryRepository(private val dao: NoteCategoryDao) {

    val notes = dao.getAllCategories()

    suspend fun insert(category: NoteCategory): Long {
        return dao.insertCategory(category)
    }

    suspend fun update(category: NoteCategory): Int{
        return dao.updateCategory(category)
    }

    suspend fun delete(category: NoteCategory): Int{
        return dao.deleteCategory(category)
    }

    suspend fun deleteAll(category: NoteCategory):Int {
        return dao.deleteAll()
    }

}