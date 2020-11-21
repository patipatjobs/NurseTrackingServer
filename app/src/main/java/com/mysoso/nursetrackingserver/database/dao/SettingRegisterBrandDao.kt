package com.mysoso.nursetrackingserver.database.dao

import androidx.room.*
import com.mysoso.nursetrackingserver.database.entity.SettingRegisterBrand

@Dao
interface SettingRegisterBrandDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(settingregisterbrand: kotlin.collections.List<com.mysoso.nursetrackingserver.database.entity.SettingRegisterBrand>)


//    suspend fun addBrand(brandModel: setting_register_brand)
//
//    @Query("SELECT * FROM setting_register_brand WHERE setting_register_brand_id = :Id")
//    fun getBrand(Id: Int): List<setting_register_brand>

//    @Query("SELECT * FROM setting_register_brand ORDER BY setting_register_brand_id ASC")
//    fun readBrandAll(): LiveData<List<setting_register_brand>>

//    @Update()
//    fun updateBrand( update_brands: setting_register_brand  )
}