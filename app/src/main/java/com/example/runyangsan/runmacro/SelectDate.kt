package com.example.runyangsan.runmacro

import android.content.Context
import android.util.Log
import com.example.runyangsan.db.Scdl
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

fun selectDate(context: Context, runWeekDay: String): Scdl? {
    val contentResolverHelper = ContentResolverHelper(context)

    var runDate = LocalDateTime.now()
    var runDate1 = LocalDateTime.now()
    var runDateMills: Long = 0L
    var runDateMills1: Long = 0L
    val scdl:Scdl?

    Log.d("HelloWorker", "selectDate: runWeekDay $runWeekDay")

    if (runWeekDay == "W") {
        runDate = runDate.plusDays(14).truncatedTo(ChronoUnit.DAYS)
        runDateMills = runDate.atZone(ZoneId.systemDefault()).toInstant()?.toEpochMilli() ?: 0
        scdl = contentResolverHelper.getScdl(runDateMills)
    } else {
        runDate = runDate.plusDays(17).truncatedTo(ChronoUnit.DAYS)
        runDate1 = runDate.plusDays(18).truncatedTo(ChronoUnit.DAYS)
        runDateMills = runDate.atZone(ZoneId.systemDefault()).toInstant()?.toEpochMilli() ?: 0
        runDateMills1 = runDate1.atZone(ZoneId.systemDefault()).toInstant()?.toEpochMilli() ?: 0
        scdl = contentResolverHelper.getScdls(runDateMills, runDateMills1)
    }

    return scdl

}