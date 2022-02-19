package com.teamnoteff.noteff.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "category_id")
    val categoryId: Int?,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "display_text")
    val displaytext: String
){
    constructor(categoryId: Int?,title:String,displaytext:String):this(0,categoryId,title,displaytext)
    constructor(title:String,displaytext:String):this(0,null,title,displaytext)
    //val dataSegments:List<DataSegment>()
}