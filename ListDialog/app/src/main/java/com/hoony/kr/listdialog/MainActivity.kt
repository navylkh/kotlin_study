package com.hoony.kr.listdialog

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.hoony.kr.listdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5", "항목6")
    var data2 = arrayOf("벨기에", "브라질", "덴마크", "이집트", "핀란드", "독일", "영국", "미국")
    var data3 = intArrayOf(R.drawable.belgium, R.drawable.brazil, R.drawable.denmark, R.drawable.egypt,
        R.drawable.finland, R.drawable.germany, R.drawable.uk, R.drawable.usa)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("리스트 다이얼로그")
            builder.setNegativeButton("취소", null)

            // listener를 어디에 셋팅하느냐에 따라 witch에 들어오는 값이 리스트항목이 들어올 수도 있고
            // 버튼 항목이 들어올수도 있다.
            var listener = object:DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    binding.textView.text = "기본 리스트 다이얼로그 : ${data1[which]}"
                }
            }

            builder.setItems(data1, listener)
            builder.show()
        }

        binding.button2.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 리스트 다이얼로그")

            var list = ArrayList<HashMap<String, Any>>()

            var idx = 0
            while(idx < data2.size) {
                var map = HashMap<String, Any>()
                map.put("data2", data2[idx])
                map.put("data3", data3[idx])

                list.add(map)
                idx++
            }

            var keys = arrayOf("data2", "data3")
            var ids = intArrayOf(R.id.textView2, R.id.imageView)

            var adapter = SimpleAdapter(this, list, R.layout.custom_dialog, keys, ids)

            var listener = object:DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    binding.textView.text = "커스텀 리스트 다이얼로그 : ${data2[which]}"
                }
            }

            builder.setAdapter(adapter, listener)

            builder.setNegativeButton("취소", null)
            builder.show()
        }
   }
}