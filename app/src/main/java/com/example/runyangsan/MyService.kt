package com.example.runyangsan


// AndroidManifest.xml에  .MainActivity를 .MyServices 수정해야 한다.
//<manifest ...>
//<application ...>
//<service android:name=".MyService" />
//</application>
//</manifest>


import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.runyangsan.workmanager.scheduleWork

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        scheduleWork(applicationContext)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY // 서비스가 시스템에 의해 종료되면 자동으로 재시작
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null // 바인딩을 제공하지 않음
    }
}


/**
 * 3. MainActivity 수정: MainActivity는 더 이상 필요하지 않으므로 삭제하거나
 * 빈 액티비티로 남겨둘 수 있습니다.
 * 만약 빈 액티비티로 남겨둔다면, onCreate() 함수에서 finish() 메서드를 호출하여 액티비티를
 * 즉시 종료하도록 수정해야 합니다.
 * 4. 앱 실행:
 * 이제 앱을 실행하면 MyService가 시작되고 백그라운드에서 WorkManager 작업이 예약됩니다.
 * 화면에는 아무것도 표시되지 않습니다.
 * 추가 설명:
 * START_STICKY 플래그는 서비스가 시스템에 의해 종료되면 자동으로 재시작되도록 지정합니다.
 * onBind() 메서드는 바인딩을 제공하지 않기 때문에 null을 반환합니다.
 * 앱을 종료하려면 stopService() 메서드를 호출해야 합니다.
 * 사용자가 앱을 직접 종료할 수 있는 방법을 제공해야 합니다.
 * 예를 들어, 알림을 통해 앱 종료 기능을 제공할 수 있습니다.
 */