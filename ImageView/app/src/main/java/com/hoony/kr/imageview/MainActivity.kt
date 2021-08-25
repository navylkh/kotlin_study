package com.hoony.kr.imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoony.kr.imageview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //binding.imageView4.setImageResource(R.drawable.avatars)
    }
}