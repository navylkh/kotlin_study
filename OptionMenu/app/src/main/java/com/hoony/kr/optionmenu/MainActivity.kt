package com.hoony.kr.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.hoony.kr.optionmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //menuInflater.inflate(R.menu.option_menu, menu)

        menu?.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "코드메뉴1")
        menu?.add(Menu.NONE, Menu.FIRST + 2, Menu.NONE, "코드메뉴2")

        var sub:Menu? = menu?.addSubMenu("메뉴3")
        sub?.add(Menu.NONE, Menu.FIRST + 3, Menu.NONE, "코드메뉴3-1")
        sub?.add(Menu.NONE, Menu.FIRST + 4, Menu.NONE, "코드메뉴3-2")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /*
        when(item.itemId) {
            R.id.item1 ->
                binding.textView.text = "메뉴1을 눌렀습니다"
            R.id.item2_1 ->
                binding.textView.text = "메뉴2-1을 눌렀습니다"
            R.id.item2_2 ->
                binding.textView.text = "메뉴2-2을 눌렀습니다"
            R.id.item2_3 ->
                binding.textView.text = "메뉴2-3을 눌렀습니다"
            R.id.item3 ->
                binding.textView.text = "메뉴3을 눌렀습니다"
        }
         */

        when(item.itemId) {
            Menu.FIRST + 1 ->
                binding.textView.text = "코드메뉴1을 눌렀습니다."
            Menu.FIRST + 2 ->
                binding.textView.text = "코드메뉴2을 눌렀습니다"
            Menu.FIRST + 3 ->
                binding.textView.text = "코드메뉴3-1을 눌렀습니다"
            Menu.FIRST + 4 ->
                binding.textView.text = "코드메뉴3-2을 눌렀습니다"
        }
        return super.onOptionsItemSelected(item)
    }

}