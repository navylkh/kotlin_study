package com.hoony.kr.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.hoony.kr.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var data1 = arrayOf("스피너1-1", "스피너1-2", "스피너1-3", "스피너1-4", "스피너1-5")
    var data2 = arrayOf("스피너2-1", "스피너2-2", "스피너2-3", "스피너2-4", "스피너2-5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)
        var adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data2)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = adapter1
        binding.spinner2.adapter = adapter2

        var listener = SpinnerListener()
        binding.spinner.onItemSelectedListener = listener

        binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                binding.textView.text = data2[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.button.setOnClickListener { view->
            binding.textView.text = data1[binding.spinner.selectedItemPosition] + "\n"
            binding.textView.append(data2[binding.spinner2.selectedItemPosition])
        }
    }

    inner class SpinnerListener : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            binding.textView.text = data1[position]
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            TODO("Not yet implemented")
        }
    }
}