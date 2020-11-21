package com.mysoso.nursetrackingserver.database.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class setting_register_nurse(
    @PrimaryKey(autoGenerate = true)
    val setting_register_nurse_id: Int,
    @NonNull
    @ColumnInfo(name = "setting_register_nurse_emp_id")
    val setting_register_nurse_emp_id: String,
    @NonNull
    @ColumnInfo(name = "setting_register_nurse_name")
    val setting_register_nurse_name: String,
    @ColumnInfo(name = "setting_register_itag_id")
    val setting_register_itag_id: String?,

    @ColumnInfo(name = "isActive")
    val isActive: Int = 1,
    @ColumnInfo(name = "datetime")
    val datetime: String?
)