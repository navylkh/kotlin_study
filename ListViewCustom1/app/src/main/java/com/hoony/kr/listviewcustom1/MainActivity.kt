package com.hoony.kr.listviewcustom1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.hoony.kr.listviewcustom1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var data = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5", "데이터6")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        var adapter = ArrayAdapter(this, R.layout.row1, R.id.textView2, data)
        binding.listview.adapter = adapter
        
        binding.listview.setOnItemClickListener { parent, view, position, id ->
            binding.textView.text = data[position]
        }
    }
}