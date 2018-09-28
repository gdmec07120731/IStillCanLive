package com.ppjun.android.istillcanlive.manager

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.ppjun.android.istillcanlive.service.KeepLiveService
import com.ppjun.android.istillcanlive.receiver.ScreenLockReceiver


/**
 * Created by ppjun on 2018/09/28.
 * 一像素广播管理类
 */
class KeepLiveManager {

    private var mScreenLockReceiver: ScreenLockReceiver? = null

    fun registerBroadcast(context: Context) {
        mScreenLockReceiver = ScreenLockReceiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.SCREEN_OFF")
        intentFilter.addAction("android.intent.action.SCREEN_ON")
        intentFilter.addAction("android.intent.action.USER_PRESENT")
        context.registerReceiver(mScreenLockReceiver, intentFilter)
        //启动notification
        context.startService(Intent(context, KeepLiveService::class.java))
    }

    fun unRegisterBroadcast(context: Context) {
        mScreenLockReceiver.let {
            context.unregisterReceiver(it)
        }
    }
}