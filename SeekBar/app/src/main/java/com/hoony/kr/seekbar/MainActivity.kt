package com.hoony.kr.seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.hoony.kr.seekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener { view ->
            binding.textView.text = "seek1 : " + binding.seekBar.progress
            binding.textView2.text = "seek2 : " + binding.seekBar2.progress
        }

        binding.button2.setOnClickListener { view ->
            binding.seekBar.incrementProgressBy(1)
            binding.seekBar2.incrementProgressBy(1)
        }

        binding.button3.setOnClickListener { view ->
            binding.seekBar.incrementProgressBy(-1)
            binding.seekBar2.incrementProgressBy(-1)
        }

        var listener = SeekListener()
        binding.seekBar.setOnSeekBarChangeListener(listener)

        // 익명 중첩 클래스
        binding.seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textView2.text = "seek2 : " + progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    inner class SeekListener: SeekBar.OnSeekBarChangeListener{
        // SeekBar의 값이 변경되었을 때
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            binding.textView.text = "seek1 : " + progress
        }

        // 값을 변경하기 위해 사용자가 터치했을 때
        override fun onStartTrackingTouch(seekBar: SeekBar?) {
        }

        // 값을 변경한 후 터치를 때었을 때
        override fun onStopTrackingTouch(seekBar: SeekBar?) {
        }
    }
}