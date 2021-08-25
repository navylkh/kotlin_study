package com.hoony.kr.twolinelistview

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import com.hoony.kr.twolinelistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var data1 = arrayOf("문자열1", "문자열2", "문자열3", "문자열4", "문자열5", "문자열6")
    var data2 = arrayOf("String1", "String2", "String3", "String4", "String5", "String6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var list = ArrayList<HashMap<String, String>>()

        var idx = 0
        while( idx < data1.size) {
            var map = HashMap<String, String>()
            map.put("str1", data1[idx])
            map.put("str2", data2[idx])
            list.add(map)

            idx++
        }

        var key = arrayOf("str1", "str2")
        var ids = intArrayOf(android.R.id.text1, android.R.id.text2)
        var adapter = SimpleAdapter(this, list, R.layout.simple_expandable_list_item_2, key, ids)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            binding.textView.text = data1[position]
        }

    }
}