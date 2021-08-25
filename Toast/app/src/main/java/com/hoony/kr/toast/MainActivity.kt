package com.hoony.kr.toast

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.hoony.kr.toast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var t1 = Toast.makeText(this, "토스트 메시지 입니다", Toast.LENGTH_SHORT)
            t1.show()
        }

        binding.button2.setOnClickListener {
            var v2 = layoutInflater.inflate(R.layout.custom_toast, null)
            v2?.setBackgroundResource(android.R.drawable.toast_frame)

            var image_view: ImageView? = v2.findViewById<ImageView>(R.id.imageView)
            image_view?.setImageResource(R.drawable.img_andorid)

            var text_view:TextView? = v2.findViewById<TextView>(R.id.textView)
            text_view?.text = "토스트 메시지 입니다"
            text_view?.setTextColor(Color.BLUE)

            var t2 = Toast(this)
            t2.view = v2

            t2.setGravity(Gravity.CENTER, 0, 200)

            t2.show()
        }
    }
}