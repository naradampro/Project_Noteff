package com.teamnoteff.noteff.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_config_table")
class UserConfig (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "property")
    val property: String,

    @ColumnInfo(name = "value")
    val value: String?
)