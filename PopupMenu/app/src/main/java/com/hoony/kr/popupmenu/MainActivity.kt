package com.hoony.kr.popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import com.hoony.kr.popupmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener { view ->
            var pop = PopupMenu(this, binding.textView)

            menuInflater.inflate(R.menu.popup_menu, pop.menu)
            //var listener = PopupListener()
            //pop.setOnMenuItemClickListener(listener)

            pop.setOnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.item1 ->
                        binding.textView.text = "메뉴 1번을 눌렀습니다"
                    R.id.item2 ->
                        binding.textView.text = "메뉴 2번을 눌렀습니다"
                    R.id.item3 ->
                        binding.textView.text = "메뉴 3번을 눌렀습니다"
                }
                false
            }

            pop.show()
        }
    }

    inner class PopupListener : PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when(item?.itemId) {
                R.id.item1 ->
                    binding.textView.text = "메뉴 1번을 눌렀습니다"
                R.id.item2 ->
                    binding.textView.text = "메뉴 2번을 눌렀습니다"
                R.id.item3 ->
                    binding.textView.text = "메뉴 3번을 눌렀습니다"
            }

            return false
        }
    }
}