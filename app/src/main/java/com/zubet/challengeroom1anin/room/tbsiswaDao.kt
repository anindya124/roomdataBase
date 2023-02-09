package com.zubet.challengeroom1anin.room

import androidx.room.*

@Dao
interface tbsiswaDao{
    @Insert
   fun addtbsiswa(tbsis: tbsiswa)
    @Update
   fun updateSiswa(tbsis: tbsiswa)
    @Delete
   fun deleteSiswa(tbsis: tbsiswa)
    @Query("SELECT * FROM tbsiswa")
    fun tampilsemua(): List<tbsiswa>
    @Query("SELECT *FROM tbsiswa WHERE nis=:tbsiswa_nis")
    fun tampilid(tbsiswa_nis: Int): List<tbsiswa>
     
}