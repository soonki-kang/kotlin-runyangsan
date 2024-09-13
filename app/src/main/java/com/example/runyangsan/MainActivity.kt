package com.example.runyangsan

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.runyangsan.runmacro.ContentResolverHelper
import com.example.runyangsan.workmanager.scheduleWork

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentResolverHelper = ContentResolverHelper(this)
        scheduleWork(applicationContext)
        finish()
    }
}


/**
 * onStartCommand() 메서드와 START_STICKY 플래그는 Service
 * 클래스에서만 사용 가능한 기능입니다.
 * Activity 클래스에는 해당 기능이 제공되지 않습니다.
 * Activity는 사용자와 상호 작용하는 화면을 담당하는 컴포넌트이고,
 * 시스템에 의해 종료될 수 있는 특성을 가지고 있습니다.
 * 따라서, Activity가 시스템에 의해 종료되면 자동으로 재시작되는 기능은
 * 제공되지 않습니다.
 * 만약 MainActivity가 종료된 후에도 앱이 백그라운드에서 계속 실행되도록 하려면,
 * 위에서 설명드린 것처럼 Service를 사용하는 것이 적합합니다.
 * Service는 화면 없이 백그라운드에서 작업을 수행할 수 있으며,
 * 시스템에 의해 종료되더라도 START_STICKY 플래그를 사용하여 자동으로 재시작될 수 있습니다.
 */