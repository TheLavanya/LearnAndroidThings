package com.lav.learnandroidthings.launchmodes

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lav.learnandroidthings.R
import kotlinx.android.synthetic.main.activity_button.*

class ActivityD : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        id_tv.text = "Activity D"
        id_btn.visibility = View.VISIBLE
        id_btn.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
            startActivity(intent)
        }
    }
}