package com.teamnoteff.noteff.entities

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_data_segment_table")
class ImageDataSegment(
    @PrimaryKey(autoGenerate = true)
    override val id: Int,

    @ColumnInfo(name = "note_id")
    override var noteId: Int,

    @ColumnInfo(name = "order")
    override var order: Int,

    @ColumnInfo(name = "content")
    val content: String,
) : DataSegment{
    constructor(content: String) : this(0,0,0,content)
}