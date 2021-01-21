package com.lav.learnandroidthings.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.lav.learnandroidthings.R
import kotlinx.android.synthetic.main.activity_live_data_test.*

class LiveDataTestActivity : AppCompatActivity() {

    val liveData: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_test)
        liveData.observe(this, Observer {
            text_view.text = it
        })
        btn.setOnClickListener {
            liveData.postValue("someNewData")
            liveData.value = "againNewData"
        }
    }
}