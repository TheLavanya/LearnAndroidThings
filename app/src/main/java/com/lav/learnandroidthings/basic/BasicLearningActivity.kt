package com.lav.learnandroidthings.basic

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.ArrayMap
import androidx.appcompat.app.AppCompatActivity
import com.lav.learnandroidthings.R

class BasicLearningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_learning)
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val intent = Intent(this, Test1Activity::class.java)
                startActivity(intent)
            },
            3000
        )
        val map = ArrayMap<String, String>()
    }
}
