package com.durov.recyclerviewkotlin_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list: ArrayList<String> = ArrayList()
    private lateinit var myItemViewAdapter: MyItemViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initList()
        recyclerView.layoutManager = LinearLayoutManager(this)
        myItemViewAdapter = MyItemViewAdapter(list,this
        ) { itemClick->Unit
            Toast.makeText(this,itemClick,Toast.LENGTH_SHORT).show()}
        recyclerView.adapter = myItemViewAdapter
    }

    private fun initList(){
        for(i in 0..100){
            list.add("Item number $i")
        }
    }
}
