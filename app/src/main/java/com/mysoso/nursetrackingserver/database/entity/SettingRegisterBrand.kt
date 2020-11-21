package com.mysoso.nursetrackingserver.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "setting_register_brand")
data class SettingRegisterBrand (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "setting_register_brand_id")
    var setting_register_brand_id: Int,

    @ColumnInfo(name = "setting_register_brand_title")
    var setting_register_brand_title : String,

    @ColumnInfo(name = "setting_register_brand_distance")
    var setting_register_brand_distance : Int,

    @ColumnInfo(name = "updated_at")
    var updated_at: Long = System.currentTimeMillis()

)
