package com.lav.learnandroidthings.dagger.car

import android.util.Log
import javax.inject.Inject

class Remote @Inject constructor() {    //constructor injection

    fun setListener(car: Car) {
        Log.d(TAG, "Remote connected..")
    }

}