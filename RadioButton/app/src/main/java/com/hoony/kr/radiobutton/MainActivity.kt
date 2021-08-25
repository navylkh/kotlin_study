package com.hoony.kr.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.RadioGroup
import com.hoony.kr.radiobutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener { view ->
            when(binding.group1.checkedRadioButtonId) {
                R.id.radioButton ->
                    binding.textView.text = "라디오 1-1이 선택되었습니다"
                R.id.radioButton2 ->
                    binding.textView.text = "라디오 1-2가 선택되었습니다"
                R.id.radioButton3 ->
                    binding.textView.text = "라디오 1-3가 선택되었습니다"
            }

            when(binding.group2.checkedRadioButtonId) {
                R.id.radioButton4 ->
                    binding.textView2.text = "라디오 2-1이 선택되었습니다."
                R.id.radioButton5 ->
                    binding.textView2.text = "라디오 2-2이 선택되었습니다."
                R.id.radioButton6 ->
                    binding.textView2.text = "라디오 2-3이 선택되었습니다."
            }
        }

        /*
        var listener = RadioListener()
        binding.group1.setOnCheckedChangeListener(listener)
        binding.group2.setOnCheckedChangeListener(listener)
         */

        binding.group1.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.radioButton ->
                    binding.textView.text = "체크 이벤트 : 라디오 1-1 체크"
                R.id.radioButton2 ->
                    binding.textView.text = "체크 이벤트 : 라디오 1-2 체크"
                R.id.radioButton3 ->
                    binding.textView.text = "체크 이벤트 : 라디오 1-3 체크"
            }
        }

        binding.group2.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.radioButton4 ->
                    binding.textView2.text = "체크 이벤트 : 라디오 2-1 체크"
                R.id.radioButton5 ->
                    binding.textView2.text = "체크 이벤트 : 라디오 2-2 체크"
                R.id.radioButton6 ->
                    binding.textView2.text = "체크 이벤트 : 라디오 2-3 체크"

            }
        }

        binding.button2.setOnClickListener { view ->
            binding.radioButton3.isChecked = true
            binding.radioButton6.isChecked = true
        }
    }

    inner class RadioListener: RadioGroup.OnCheckedChangeListener {
        override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
            when(group?.id) {
                R.id.group1 ->
                    when(checkedId) {
                        R.id.radioButton ->
                            binding.textView.text = "체크 이벤트 : 라디오 1-1 체크"
                        R.id.radioButton2 ->
                            binding.textView.text = "체크 이벤트 : 라디오 1-2 체크"
                        R.id.radioButton3 ->
                            binding.textView.text = "체크 이벤트 : 라디오 1-3 체크"
                    }
                R.id.group2 ->
                    when(checkedId) {
                        R.id.radioButton4 ->
                            binding.textView2.text = "체크 이벤트 : 라디오 2-1 체크"
                        R.id.radioButton5 ->
                            binding.textView2.text = "체크 이벤트 : 라디오 2-2 체크"
                        R.id.radioButton6 ->
                            binding.textView2.text = "체크 이벤트 : 라디오 2-3 체크"
                    }
            }
        }
    }
}