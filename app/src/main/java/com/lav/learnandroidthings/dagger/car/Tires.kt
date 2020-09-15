package com.lav.learnandroidthings.dagger.car

import android.util.Log

class Tires {

    //Suppose we don't own this class so we can't annotate it with @Inject

    fun inflate() {
        Log.d(TAG, "Tires inflated")
    }
}