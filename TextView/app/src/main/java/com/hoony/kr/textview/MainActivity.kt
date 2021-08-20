package com.hoony.kr.textview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var text2: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text2 = findViewById<TextView>(R.id.textView2)
        text2?.text = "문자열2"
        text2?.setText("문자열10")

        //textView3.text = "문자열3"
    }
}