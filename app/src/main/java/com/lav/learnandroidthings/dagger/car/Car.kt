package com.lav.learnandroidthings.dagger.car

import android.util.Log
import javax.inject.Inject

const val TAG = "Car"

class Car @Inject constructor(engine: Engine, wheels: Wheels) {

    private val engine: Engine = engine
    private val wheel: Wheels = wheels

    fun drive() {
        engine.start()
        Log.d(TAG, "driving..")
    }

    @Inject
    fun enableRemote(remote: Remote) {
        remote.setListener(this)
    }

}