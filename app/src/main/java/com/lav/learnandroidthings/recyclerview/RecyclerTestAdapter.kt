package com.lav.learnandroidthings.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lav.learnandroidthings.R
import kotlinx.android.synthetic.main.recycler_item_spinner_view.view.*
import kotlinx.android.synthetic.main.recycler_item_view.view.*

class RecyclerTestAdapter(private val list: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class ItemType {
        ITEM_TYPE_SIMPLE, ITEM_TYPE_SPINNER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ItemType.ITEM_TYPE_SIMPLE.ordinal)
            SimpleViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.recycler_item_view,
                    parent,
                    false
                )
            )
        else SpinnerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_item_spinner_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        if (position % 2 == 0)
            return ItemType.ITEM_TYPE_SIMPLE.ordinal
        return ItemType.ITEM_TYPE_SPINNER.ordinal
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SimpleViewHolder) {
            val text = list[position]
            holder.bind(text)
        } else if (holder is SpinnerViewHolder) {
            holder.bind()
        }
    }

    class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(text: String) {
            itemView.id_tv.text = text
        }
    }

    inner class SpinnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind() {
            ArrayAdapter.createFromResource(
                itemView.context,
                R.array.planets_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                itemView.id_spinner.adapter = adapter
            }
        }
    }

}