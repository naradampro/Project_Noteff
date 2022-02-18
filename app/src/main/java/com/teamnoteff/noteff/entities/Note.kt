package com.teamnoteff.noteff.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "display_text")
    val displaytext: String
){
    constructor(title:String,displaytext:String):this(0,title,displaytext)

    //val dataSegments:List<DataSegment>()
}