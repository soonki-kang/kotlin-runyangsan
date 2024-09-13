package com.example.runyangsan.runmacro

import android.net.Uri

object ScdlContract {
    const val TABLE_NAME = "Scdl"
    const val AUTHORITY = "com.example.yangsan.db.RsrvContentProvider"
    const val URI_STRING = "content://$AUTHORITY/$TABLE_NAME"
    val CONTENT_URI: Uri = Uri.parse(URI_STRING)
}