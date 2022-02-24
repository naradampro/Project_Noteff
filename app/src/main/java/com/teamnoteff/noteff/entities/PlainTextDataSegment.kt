package com.teamnoteff.noteff.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.nio.ByteOrder

@Entity(tableName = "plaintext_data_segment_table")
class PlainTextDataSegment(
    @PrimaryKey(autoGenerate = true)
    override val id: Int,

    @ColumnInfo(name = "note_id")
    override var noteId: Int,

    @ColumnInfo(name = "order")
    override var order: Int,

    @ColumnInfo(name = "content")
    var content:String
) : DataSegment{
    constructor(content: String) : this(0,0,0,content)
}