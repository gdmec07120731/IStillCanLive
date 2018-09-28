package com.ppjun.android.istillcanlive.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.ppjun.android.istillcanlive.PixelActivity
import com.ppjun.android.istillcanlive.manager.KeepLiveManager


/**
 * Created by ppjun on 2018/09/27.
 * 一像素广播
 */
class ScreenLockReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {
        val action = intent.action
        when (action) {
            Intent.ACTION_SCREEN_OFF -> {
                //锁屏的时候
                PixelActivity.showPixelActivity(requireNotNull(context))
            }
            Intent.ACTION_SCREEN_ON, Intent.ACTION_USER_PRESENT -> {
                //解锁的时候
                PixelActivity.destroyPixelActivity()
            }
        }
    }
}