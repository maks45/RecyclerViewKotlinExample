package com.durov.recyclerviewkotlin_01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*

class MyItemViewAdapter(
    private val items:ArrayList<String>,
    private val context: Context,
    private val itemClick: (String) -> Unit
)
    :RecyclerView.Adapter<MyItemViewAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false),
            itemClick
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindModel(items[position])

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View,
        val itemClick:(String)->Unit): RecyclerView.ViewHolder(itemView){
        fun bindModel(model: String) {
            with(model) {
                itemView.setOnClickListener { itemClick(this) }
                itemView.textView.text = this
            }
        }
    }
}