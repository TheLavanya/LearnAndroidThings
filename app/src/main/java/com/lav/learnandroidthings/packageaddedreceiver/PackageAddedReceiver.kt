package com.lav.learnandroidthings.packageaddedreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class PackageAddedReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        val action = p1?.action
        Log.i("PACKAGECHANGED>>>", "PackageAddedReceiver.onReceive()")
        Toast.makeText(p0, action, Toast.LENGTH_SHORT).show()
    }
}