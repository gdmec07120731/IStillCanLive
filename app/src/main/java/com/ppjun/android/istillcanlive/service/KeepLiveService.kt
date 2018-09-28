package com.ppjun.android.istillcanlive.service

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import com.ppjun.android.istillcanlive.R


/**
 * Created by ppjun on 2018/09/28.
 * 设置前台服务，提升进程优先级
 */
class KeepLiveService : Service() {

    private val foregroundPushId = 1

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            startForeground(foregroundPushId, Notification())
        } else {
            val builder = Notification.Builder(this)
            builder.setSmallIcon(R.mipmap.ic_launcher)
            builder.setContentTitle("Live正在后台运行")
            builder.setContentText("Live")
            startForeground(foregroundPushId, builder.build())
            //用相同的notificationid可以取消自己在前台的显示
            startService(Intent(this, NotifyService::class.java))

        }
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}