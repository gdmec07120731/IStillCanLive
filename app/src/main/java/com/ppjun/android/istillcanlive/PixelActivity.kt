package com.ppjun.android.istillcanlive

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity


/**
 * Created by ppjun on 2018/09/27.
 * 1像素页面
 */
class PixelActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPixelActivity = this
        val window = window
        window.setGravity(Gravity.LEFT or Gravity.TOP)
        val params = window.attributes
        params.height = 1
        params.width = 1
        params.x = 0
        params.y = 0
        window.attributes = params
    }

    companion object {
        var mPixelActivity: PixelActivity? = null

        fun showPixelActivity(context: Context) {
            Log.i("ppjun=", "showPixelActivity")
            val intent = Intent(context, PixelActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }

        fun destroyPixelActivity() {
            Log.i("ppjun=", "destroyPixelActivity")
            mPixelActivity?.finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPixelActivity = null
    }

}