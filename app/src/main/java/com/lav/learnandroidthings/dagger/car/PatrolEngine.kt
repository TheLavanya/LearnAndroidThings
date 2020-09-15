package com.lav.learnandroidthings.dagger.car

import android.util.Log
import javax.inject.Inject

class PatrolEngine @Inject constructor() : Engine {

    override fun start() {
        Log.d(TAG, "Patrol Engine started..")
    }
}