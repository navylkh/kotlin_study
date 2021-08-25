package com.hoony.kr.progressbar

import com.hoony.kr.progressbar.databinding.ActivityMainBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener { view ->
            binding.progressBar4.incrementProgressBy(5)
        }

        binding.button2.setOnClickListener { view ->
            binding.progressBar4.incrementProgressBy(-5)
        }

        binding.button3.setOnClickListener { view ->
            binding.progressBar4.progress = 50
        }
    }
}