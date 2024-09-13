package com.example.runyangsan.runmacro

import android.content.Context
import com.example.runyangsan.db.User

fun selectUser(context: Context): User? {
    val contentResolverHelper = ContentResolverHelper(context)
    val user: User? = contentResolverHelper.getUser(0)
    return user
}