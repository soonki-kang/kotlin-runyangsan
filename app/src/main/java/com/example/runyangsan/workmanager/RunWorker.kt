package com.example.runyangsan.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.runyangsan.db.Scdl
import com.example.runyangsan.runmacro.selectDate
import com.example.runyangsan.runmacro.selectUser
import java.time.LocalDateTime


class RunWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

//    private lateinit var webDriver: WebDriver

    override fun doWork(): Result {

//        webDriver = createWebDriver()
        try {
            //예약 날자가 없으면 종료
            val runWeekDay = inputData.getString("Week")!!
//            var scdl: Scdl? =     selectDate(applicationContext, runWeekDay)

            // 사용자 가져옴
            val readingUser = selectUser(applicationContext)

            //get Url to Login Page
            //Login 실패시 종료
            //        if (userLogin(webDriver, readingUser)) return Result.failure()

            // macro execute
            //        executeMacro()

            if (readingUser != null) {
                Log.d("HelloWorker", "user id : ${readingUser.user_id}  user password : ${readingUser.user_password}")
            }
            return Result.success()
        } finally {
                Log.d("HelloWorker", "doWork finish")
//            webDriver.quit()
        }
    }

//    private fun createWebDriver(): WebDriver{
//
//    }
}