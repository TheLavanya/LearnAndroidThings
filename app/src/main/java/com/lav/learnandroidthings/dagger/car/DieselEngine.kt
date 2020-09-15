package com.lav.learnandroidthings.dagger.car

import android.util.Log
import javax.inject.Inject

class DieselEngine @Inject constructor(/*horsePower: Int*/) : Engine {

    //var horsePower: Int = horsePower

    override fun start() {
        Log.d(TAG, "Diesel Engine started. HorsePower : horsePower")
    }
}