package com.ppjun.android.istillcanlive.service

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.ppjun.android.istillcanlive.R


/**
 * Created by ppjun on 2018/09/28.
 *
 */

class NotifyService : Service() {
    private val foregroundPushId = 1
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //用相同的notificationid可以取消自己在前台的显示
        val builder = Notification.Builder(this)
        builder.setSmallIcon(R.mipmap.ic_launcher)
        builder.setContentTitle("Live2正在后台运行")
        builder.setContentText("Live2")
        startForeground(foregroundPushId, builder.build())
        stopSelf()
        return super.onStartCommand(intent, flags, startId);
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}