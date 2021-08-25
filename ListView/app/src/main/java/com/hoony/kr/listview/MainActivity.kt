package com.hoony.kr.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.hoony.kr.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var data = arrayOf("리스트1", "리스트2", "리스트3", "리스트4", "리스트5", "리스트6",
            "리스트7", "리스트8", "리스트9", "리스트10", "리스트11", "리스트12")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        binding.listview.adapter = adapter

        /*
        var listener = listlistener()
        binding.listview.setOnItemClickListener(listener)
         */

        binding.listview.setOnItemClickListener { parent, view, position, id ->
            binding.textView.text = data[position]
        }
    }

    inner class listlistener : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            binding.textView.text = data[position]
        }
    }
}