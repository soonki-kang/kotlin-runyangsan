package com.example.runyangsan.runmacro

import android.content.ContentResolver
import android.content.Context
import android.util.Log
import com.example.runyangsan.db.Scdl
import com.example.runyangsan.db.User

class ContentResolverHelper(private var mContext: Context) {
    private var contentResolver: ContentResolver = mContext.contentResolver

    fun getUser(id: Long): User? {
        val cursor =
            contentResolver.query(UserContract.CONTENT_URI, null, "id", arrayOf("$id"), null)

        cursor?.use {//try-with-resources를 사용하여 자동으로 Cursor를 닫는다.
            if (it.moveToFirst()) {
                val userIdIndex = cursor.getColumnIndex("user_id")
                val userPasswordIndex = cursor.getColumnIndex("user_password")

                val userId = cursor.getString(userIdIndex)
                val userPassword = cursor.getString(userPasswordIndex)

                Log.d(
                    "RUNMACRO",
                    "getItem: user id: $userId   user password : $ userPassword      "
                )
                return User(userId, userPassword, id.toInt())
            }
        }
        return null
    }

    fun getScdl(runDate: Long): Scdl? {
        val cursor =
            contentResolver.query(ScdlContract.CONTENT_URI, null, "scdl_date", arrayOf("$runDate"), null)

        cursor?.use {//try-with-resources를 사용하여 자동으로 Cursor를 닫는다.
            if (it.moveToFirst()) {
                val scdlTypeIndex = cursor.getColumnIndex("scdl_type")
                val scdlDateIndex = cursor.getColumnIndex("scdl_date")
                val scdlTimeIndex = cursor.getColumnIndex("scdl_time")

                val scdlType = cursor.getInt(scdlTypeIndex)
                val scdlDate = cursor.getLong(scdlDateIndex)
                val scdlTime = cursor.getInt(scdlTimeIndex)

                Log.d(
                    "RUNMACRO",
                    "getItem: scdlType: $scdlType   scdlDate : $scdlDate  scdlTime : $scdlTime     "
                )
                return Scdl(scdlType, scdlDate, scdlTime, 0 )
            }
        }
        return null
    }


    fun getScdls(runDate: Long, runDate1: Long): Scdl? {
        val cursor =
            contentResolver.query(ScdlContract.CONTENT_URI, null, "scdl_date", arrayOf("$runDate","$runDate1"), null)

        cursor?.use {//try-with-resources를 사용하여 자동으로 Cursor를 닫는다.
            if (it.moveToFirst()) {
                val scdlTypeIndex = cursor.getColumnIndex("scdl_type")
                val scdlDateIndex = cursor.getColumnIndex("scdl_date")
                val scdlTimeIndex = cursor.getColumnIndex("scdl_time")

                val scdlType = cursor.getInt(scdlTypeIndex)
                val scdlDate = cursor.getLong(scdlDateIndex)
                val scdlTime = cursor.getInt(scdlTimeIndex)

                Log.d(
                    "RUNMACRO",
                    "getItem: scdlType: $scdlType   scdlDate : $scdlDate  scdlTime : $scdlTime     "
                )
                return Scdl(scdlType, scdlDate, scdlTime, 0 )
            }
        }
        return null
    }




}


//        if (cursor != null && cursor.count > 0) {
//            while(cursor.moveToNext()) {
//                val userIdIndex = cursor.getColumnIndex("user_id")
//                val userPasswordIndex = cursor.getColumnIndex("user_password")
//
//                val userId = cursor.getString(userIdIndex)
//                val userPassword = cursor.getString(userPasswordIndex)
//
//                Log.d("RUNMACRO", "getItem: user id: $userId   user password : $ userPassword      ")
//            }
//        }
