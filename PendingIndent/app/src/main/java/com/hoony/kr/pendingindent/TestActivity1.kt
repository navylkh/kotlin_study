package com.hoony.kr.pendingindent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.pendingindent.databinding.ActivityTest1Binding

class TestActivity1 : AppCompatActivity() {
    private lateinit var binding : ActivityTest1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTest1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var data1 = intent.getStringExtra("data1")
        var data2 = intent.getIntExtra("data2", 0)

        binding.textView.text = "data1: ${data1}\n"
        binding.textView.append("data2: ${data2}");
    }
}