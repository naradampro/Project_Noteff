package com.teamnoteff.noteff.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "link_data_segment_table")
class LinkDataSegment(
    @PrimaryKey(autoGenerate = true)
    override val id: Int,

    @ColumnInfo(name = "note_id")
    override val noteId: Int,

    @ColumnInfo(name = "content")
    var content:String
) : DataSegment{
    constructor(content: String) : this(0,0,content)
}