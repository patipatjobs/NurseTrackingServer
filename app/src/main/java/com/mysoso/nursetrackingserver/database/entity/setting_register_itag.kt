package com.mysoso.nursetrackingserver.database.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class setting_register_itag(
    @PrimaryKey(autoGenerate = true)
    val setting_register_itag_id: Int,
    @NonNull
    @ColumnInfo(name = "setting_register_brand_id")
    val setting_register_brand_id: String?,
    @NonNull
    @ColumnInfo(name = "setting_register_itag_mac_address")
    val setting_register_itag_mac_address: String,
    @ColumnInfo(name = "setting_register_itag_title")
    val setting_register_itag_title: String?,

    @ColumnInfo(name = "isActive")
    val isActive: Int = 1,
    @ColumnInfo(name = "updated_at")
    val updated_at: String?
)