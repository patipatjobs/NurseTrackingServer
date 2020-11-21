package com.mysoso.nursetrackingserver.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.format.DateTimeFormatter

@Entity
data class setting_register_version(

    @PrimaryKey(autoGenerate = true)
    val setting_register_version_id: Int,

    @ColumnInfo(name = "setting_register_version_title")
    var setting_register_version_title: String,

    @ColumnInfo(name = "setting_register_version_number")
    var setting_register_version_number: String,

    @ColumnInfo(name = "updated_at")
    val updated_at: String
)