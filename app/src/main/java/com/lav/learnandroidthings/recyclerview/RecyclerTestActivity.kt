package com.lav.learnandroidthings.recyclerview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.lav.learnandroidthings.R
import kotlinx.android.synthetic.main.activity_recycler.*
import kotlinx.android.synthetic.main.recycler_item_view.view.*

class RecyclerTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val list = ArrayList<String>()

        for (i in 1..40) {
            list.add("A$i")
        }

        val adapter = RecyclerTestAdapter(list)
        val layoutManager = LinearLayoutManager(this)
        id_recylcer_view.layoutManager = layoutManager
        id_recylcer_view.adapter = adapter

        id_button.setOnClickListener {
            val view = id_recylcer_view.get(4)
            view.id_view_layout.visibility= View.GONE
        }
    }
}