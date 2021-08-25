package com.hoony.kr.pendingindent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.pendingindent.databinding.ActivityMainBinding
import com.hoony.kr.pendingindent.databinding.ActivityTest2Binding

class TestActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityTest2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTest2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var data1 = intent.getStringExtra("data1")
        var data2 = intent.getIntExtra("data2", 0)

        binding.textView2.text = "data1 : ${data1}\n"
        binding.textView2.append("data2 : ${data2}")
    }
}