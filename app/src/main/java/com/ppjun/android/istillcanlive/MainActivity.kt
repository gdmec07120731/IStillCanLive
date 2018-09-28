package com.ppjun.android.istillcanlive

import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ppjun.android.istillcanlive.manager.KeepLiveManager
import com.ppjun.android.istillcanlive.receiver.ScreenLockReceiver

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KeepLiveManager().registerBroadcast(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        KeepLiveManager().unRegisterBroadcast(this)
    }
}
