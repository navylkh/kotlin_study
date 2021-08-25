package com.hoony.kr.contextmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.hoony.kr.contextmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var data = arrayOf("리스트1", "리스트2", "리스트3", "리스트4", "리스트5")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            binding.textView.text = "${position} 번째 항목을 터치했습니다"
        }

        registerForContextMenu(binding.textView)
        registerForContextMenu(binding.listView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        when(v?.id) {
            R.id.textView -> {
                menu?.setHeaderTitle("텍스트뷰의 메뉴")
                menuInflater.inflate(R.menu.textview_menu, menu)
            }
            R.id.listView -> {
                menu?.setHeaderTitle("리스트뷰의 메뉴")
                menuInflater.inflate(R.menu.listview_menu, menu)
                var info = menuInfo as AdapterView.AdapterContextMenuInfo
                if(info.position %2 == 0) {
                    menu?.add(Menu.NONE, Menu.FIRST + 100, Menu.NONE, "리스트뷰 메뉴3")
                }
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.textview_item1 ->
                binding.textView.text = "텍스트뷰의 컨텍스트 메뉴1"
            R.id.textview_item2 ->
                binding.textView.text = "텍스트뷰의 컨텍스트 메뉴2"
            R.id.listview_item1 -> {
                binding.textView.text = "리스트뷰의 컨텍스트 메뉴1\n"

                var info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
                binding.textView.append("${info.position} 번째 항목")
            }
            R.id.listview_item2 -> {
                binding.textView.text = "리스트뷰의 컨텍스트 메뉴2\n"

                var info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
                binding.textView.append("${info.position} 번째 항목")
            }

        }

        return super.onContextItemSelected(item)
    }
}