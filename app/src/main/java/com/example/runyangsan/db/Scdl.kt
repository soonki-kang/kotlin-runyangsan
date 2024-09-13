package com.example.runyangsan.db

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

//import java.time.Instant

@Entity(indices = [Index(value = ["scdl_date"], unique = true)])
data class Scdl(

    val scdl_type: Int,
    val scdl_date: Long,
    val scdl_time: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
