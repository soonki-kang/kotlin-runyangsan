package com.example.runyangsan.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit


fun scheduleWork(applicationContext: Context) {
    val now = LocalDateTime.now()
    val constraints =
        Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED) // 네트워크 연결 필요 시 추가
            .build()
    val weekday: Data = Data.Builder().putString("Week", "W").build()
    val holiday: Data = Data.Builder().putString("Week", "H").build()

    // 월~금 8:58 AM
//    val weekdays858 = PeriodicWorkRequestBuilder<RunWorker>(
////        1, TimeUnit.WEEKS,
//        7, TimeUnit.DAYS // flexInterval
//    )
//        .setConstraints(constraints)
//        .setInitialDelay(calculateInitialDelay
//            (now, DayOfWeek.MONDAY, 8, 58),
//            TimeUnit.MILLISECONDS)
//        .setInputData(weekday)
//        .build()


//    for (dayOfWeek in DayOfWeek.MONDAY..DayOfWeek.FRIDAY) {

//    val weekdays = listOf(DayOfWeek.MONDAY,DayOfWeek.THURSDAY,DayOfWeek.WEDNESDAY,DayOfWeek.TUESDAY,DayOfWeek.FRIDAY)
//    for (day in weekdays){
//        println(day)
//    }
//

    Log.d("HelloWorker", "scheduleWork: start.................")

    // 월 ~ 금요일 08:59
    for (dayOfWeek in enumValues<DayOfWeek>().filter {
        it.value <= DayOfWeek.FRIDAY.value
    }) {
        val workRequest = OneTimeWorkRequestBuilder<RunWorker>()
            .setConstraints(constraints)
            .setInitialDelay(calculateInitialDelay(now, dayOfWeek, 8, 59), TimeUnit.MILLISECONDS)
            .setInputData(weekday)
            .build()

        WorkManager.getInstance(applicationContext).enqueueUniqueWork(
            "daily_work_${dayOfWeek.name}",
            ExistingWorkPolicy.REPLACE,
            workRequest
        )
    }

    // 수 9:59 AM
    val wednesday959 =
        OneTimeWorkRequestBuilder<RunWorker>()
            .setConstraints(constraints)
            .setInitialDelay(
                calculateInitialDelay(now, DayOfWeek.WEDNESDAY, 9, 59), TimeUnit.MILLISECONDS
            ).setInputData(holiday)
            .build()

    //Test용
    val testWorker20 = PeriodicWorkRequestBuilder<RunWorker>(
        20, TimeUnit.MINUTES
    ).setConstraints(constraints).setInputData(weekday)
        .build()

    val testWorker17 = PeriodicWorkRequestBuilder<RunWorker>(
        17, TimeUnit.MINUTES
    ).setConstraints(constraints).setInputData(weekday)
        .build()


//    WorkManager.getInstance(applicationContext)
//        .enqueueUniquePeriodicWork(
//            "weekdays_858_work",
//            ExistingPeriodicWorkPolicy.UPDATE,
//            weekdays858
//        )
    //기존에 등록된 job를 취소함.
//    WorkManager.getInstance(applicationContext).cancelUniqueWork("run 5 Min work")
//    WorkManager.getInstance(applicationContext).cancelAllWork()


    WorkManager.getInstance(applicationContext).enqueueUniqueWork(
        "wednesday_958_work", ExistingWorkPolicy.REPLACE, wednesday959
    )

    WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
        "run 17 Min work", ExistingPeriodicWorkPolicy.UPDATE, testWorker17
//        "run 17 Min work", ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE, testWorker17
//        "run 20 Min work", ExistingPeriodicWorkPolicy.UPDATE, testWorker20
    )

}
