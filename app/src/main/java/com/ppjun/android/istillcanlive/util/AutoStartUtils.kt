package com.ppjun.android.istillcanlive.util

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.provider.Settings


/**
 * Created by ppjun on 2018/09/28.
 * 自启动就是被杀后，将会再次拉起进程
 */
class AutoStartUtils {

    companion object {
        fun enterAutoStartUtils(context: Context) {
            try {
                context.startActivity(getAutoStartIntent())
            } catch (e: Exception) {
                context.startActivity(Intent(Settings.ACTION_SETTINGS))
            } finally {
            }
        }

        private fun getAutoStartIntent(): Intent {
            var componentName: ComponentName? = null
            val band = android.os.Build.BRAND.toLowerCase()
            when (band) {
                "samsung" -> {
                    componentName = ComponentName("com.samsung.android.sm", "com.samsung.android.sm.app.dashboard.SmartManagerDashBoardActivity")
                }
                "huawei" -> {
                    componentName = ComponentName("com.huawei.systemmanager",
                            "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity")

                }
                "xiaomi" -> {
                    componentName = ComponentName("com.miui.securitycenter",
                            "com.miui.permcenter.autostart.AutoStartManagementActivity")


                }
                "vivo" -> {
                    componentName = ComponentName("com.iqoo.secure",
                            "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity")
                }
                "oppo" -> {
                    componentName = ComponentName("com.coloros.oppoguardelf",
                            "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity")
                }
                "360" -> {
                    componentName = ComponentName("com.yulong.android.coolsafe",
                            "com.yulong.android.coolsafe.ui.activity.autorun.AutoRunListActivity")
                }
                "meizu" -> {
                    componentName = ComponentName("com.meizu.safe",
                            "com.meizu.safe.permission.SmartBGActivity")
                }
                "oneplus" -> {
                    componentName = ComponentName("com.oneplus.security",
                            "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity")
                }

            }
            val intent = Intent()
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            if (componentName != null) {
                intent.component = componentName
            } else {
                intent.action = Settings.ACTION_SETTINGS
            }
            return intent
        }


    }

}