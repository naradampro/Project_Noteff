package com.teamnoteff.noteff.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phonenumber_data_segment_table")
class PhoneNumberDataSegment(
    @PrimaryKey(autoGenerate = true)
    override val id: Int,

    @ColumnInfo(name = "note_id")
    override val noteId: Int,

    @ColumnInfo(name = "content")
    val content:String
) : DataSegment