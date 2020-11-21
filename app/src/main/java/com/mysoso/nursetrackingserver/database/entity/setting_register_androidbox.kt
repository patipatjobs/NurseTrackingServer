package com.mysoso.nursetrackingserver.database.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class setting_register_androidbox(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "setting_register_androidbox_device_id")
    val setting_register_androidbox_device_id: String,

    @NonNull
    @ColumnInfo(name = "setting_register_androidbox_type")
    val setting_register_androidbox_type: String,

    @ColumnInfo(name = "isActive")
    val isActive: Int = 1,

    @ColumnInfo(name = "updated_at")
    val updated_at: String?
)