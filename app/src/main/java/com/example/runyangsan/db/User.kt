package com.example.runyangsan.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(

    val user_id: String,
    val user_password: String,

//    @PrimaryKey(autoGenerate = true)
    @PrimaryKey()
//    val id: Int
    val id: Int = 0
)

