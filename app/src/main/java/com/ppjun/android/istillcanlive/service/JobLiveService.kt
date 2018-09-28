package com.ppjun.android.istillcanlive.service

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Build
import android.support.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
/**
 * Created by ppjun on 2018/09/27.
 *
 */
class JobLiveService : JobService() {
    override fun onStopJob(params: JobParameters?): Boolean {

        return true
    }

    override fun onStartJob(params: JobParameters?): Boolean {

        return true
    }
}