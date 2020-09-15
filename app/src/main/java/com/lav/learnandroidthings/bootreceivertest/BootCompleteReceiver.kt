package com.lav.learnandroidthings.bootreceivertest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BootCompleteReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Boot complete", Toast.LENGTH_LONG).show()
        Log.i("Boot-Receiver-test", "Boot complete")
    }
}