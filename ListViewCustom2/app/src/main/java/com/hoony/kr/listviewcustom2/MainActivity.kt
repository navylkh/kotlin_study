package com.hoony.kr.listviewcustom2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import com.hoony.kr.listviewcustom2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var imgRes = intArrayOf(R.drawable.belgium, R.drawable.brazil, R.drawable.denmark, R.drawable.egypt,
                            R.drawable.finland, R.drawable.germany, R.drawable.uk, R.drawable.usa)

    var data1 = arrayOf("벨기에", "브라질", "덴마크", "이집트",
                         "핀란드", "독일", "영국", "미국")
    var data2 = arrayOf("belgium", "brazil", "denmark", "egypt",
                          "finland", "germany", "uk", "usa")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var list = ArrayList<HashMap<String, Any>>()

        var idx = 0
        while(idx < data1.size) {
            var map = HashMap<String, Any>()

            map.put("flag", imgRes[idx])
            map.put("data1", data1[idx])
            map.put("data2", data2[idx])

            list.add(map)
            idx++
        }

        var keys = arrayOf("flag", "data1", "data2")
        var ids = intArrayOf(R.id.imageView, R.id.textView2, R.id.textView3)

        var adapter = SimpleAdapter(this, list, R.layout.row, keys, ids)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            binding.textView.text = data1[position]
        }
    }
}