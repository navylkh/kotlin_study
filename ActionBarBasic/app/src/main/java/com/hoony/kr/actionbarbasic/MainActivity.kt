package com.hoony.kr.actionbarbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import com.hoony.kr.actionbarbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        var search_item:MenuItem? = menu?.findItem(R.id.item5)
        var search_view: SearchView = search_item?.actionView as SearchView

        search_view.queryHint = "검색어를 입력해주세요"

        search_view.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                binding.textView.text = newText
                // true or false에 대해 키보드 동작에 별 차이가 없음.
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.textView2.text = query
                // true를 넘기는 경우 키보드가 내려가지 않음.
                return false
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item1 ->
                binding.textView.text = "메뉴1을 눌렀습니다"
            R.id.item2 ->
                binding.textView.text = "메뉴2을 눌렀습니다"
            R.id.item3 ->
                binding.textView.text = "메뉴3을 눌렀습니다"
            R.id.item4 ->
                binding.textView.text = "메뉴4을 눌렀습니다"
            R.id.item5 ->
                binding.textView.text = "메뉴5을 눌렀습니다"
        }
        return super.onOptionsItemSelected(item)
    }
}