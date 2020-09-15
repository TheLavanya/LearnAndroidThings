package com.lav.learnandroidthings.exitreasons

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lav.learnandroidthings.R

class HistoricalExitReasons : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exit_reasons)
    }

   /* private fun getExitReasonsList() {
        if (Build.VERSION >= Build.VERSION_CODES.O)
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager
        val exitList = activityManager?.getHistoricalProcessExitReasons(packageName, 0, 1)
    }*/
}