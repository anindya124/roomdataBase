package com.zubet.challengeroom1anin.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class tbsiswa (
        @PrimaryKey
        val nis : Int,
        val nama : String,
        val kelas : String,
        val alamat : String
)