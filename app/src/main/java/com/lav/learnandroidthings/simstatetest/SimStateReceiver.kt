package com.lav.learnandroidthings.simstatetest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class SimStateReceiver : BroadcastReceiver() {

    private val EXTRA_SIM_STATE = "ss"

    override fun onReceive(context: Context?, intent: Intent?) {
        /*val action = intent?.action
        val state = intent?.extras?.getString(EXTRA_SIM_STATE)
        Log.i("Sim-Log", "Sim State Receiver $action")*/
        Toast.makeText(context, "Sim State receiver called", Toast.LENGTH_LONG).show()

        if (context != null)
            findSimState(context)
    }

    private fun findSimState(context: Context) {
        val telephonyManager =
            context.getSystemService(Context.TELEPHONY_SERVICE) as? TelephonyManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                val sim1State = telephonyManager?.getSimState(0)
                val sim2State = telephonyManager?.getSimState(1)

                if (sim1State != null) getSimState(sim1State)
                if (sim2State != null) getSimState(sim2State)

            } catch (exception: Exception) {
            }
        } else {

        }
    }

    private fun getSimState(state: Int) {
        when (state) {
            TelephonyManager.SIM_STATE_ABSENT -> {
                Log.i("Sim-Log", "Sim State ABSENT")
            }
            TelephonyManager.SIM_STATE_NETWORK_LOCKED -> {
                Log.i("Sim-Log", "Sim State NETWORK LOCKED")
            }
            TelephonyManager.SIM_STATE_PIN_REQUIRED -> {
                Log.i("Sim-Log", "Sim State PIN REQUIRED")
            }
            TelephonyManager.SIM_STATE_PUK_REQUIRED -> {
                Log.i("Sim-Log", "Sim State PUK REQUIRED")
            }
            TelephonyManager.SIM_STATE_READY -> {
                Log.i("Sim-Log", "Sim State READY")
            }
            TelephonyManager.SIM_STATE_NOT_READY -> {
                Log.i("Sim-Log", "Sim State NOT READY")
            }
            TelephonyManager.SIM_STATE_UNKNOWN -> {
                Log.i("Sim-Log", "Sim State UNKNOWN")
            }
        }
    }
}