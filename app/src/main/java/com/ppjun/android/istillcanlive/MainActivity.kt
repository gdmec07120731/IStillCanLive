package com.ppjun.android.istillcanlive

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ppjun.android.istillcanlive.manager.KeepLiveManager
import com.ppjun.android.istillcanlive.receiver.ScreenLockReceiver
import com.ppjun.android.istillcanlive.util.AutoStartUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KeepLiveManager().registerBroadcast(this)
        mHellWorld.setOnClickListener {
            val dialofBuilder = AlertDialog.Builder(this)
            dialofBuilder.setTitle("提示")
            dialofBuilder.setMessage("为了您获取更好的用户体验，请将应用加入到系统白名单")
            dialofBuilder.setNegativeButton("取消") { dialog, _ -> dialog?.dismiss() }
            dialofBuilder.setPositiveButton("好的") { dialog, _ ->
                AutoStartUtils.enterAutoStartUtils(this)
                dialog?.dismiss()
            }
            dialofBuilder.create().show()
        }
    }

    override fun onDestroy() {
        KeepLiveManager().unRegisterBroadcast(this)
        super.onDestroy()
    }
}
