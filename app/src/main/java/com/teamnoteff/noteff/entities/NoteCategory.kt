package com.teamnoteff.noteff.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
class NoteCategory (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "category_name")
    val name: String,

)