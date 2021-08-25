package com.hoony.kr.notificationbasic

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.hoony.kr.notificationbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var builder = getNotificationBuilder("channel1", "첫 번째 채널")
            builder.setTicker("Ticker")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)
            builder.setNumber(100)
            builder.setAutoCancel(true)
            builder.setContentTitle("Content Title")
            builder.setContentText("Content Text")

            var notication = builder.build()

            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mng.notify(10, notication)
        }

        binding.button2.setOnClickListener {
            var builder = getNotificationBuilder("channel1", "첫 번째 채널")
            builder.setTicker("Ticker")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)
            builder.setNumber(100)
            builder.setAutoCancel(true)
            builder.setContentTitle("Content Title 2")
            builder.setContentText("Content Text 2")

            var notication = builder.build()

            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mng.notify(20, notication)
        }

        binding.button3.setOnClickListener {
            var builder = getNotificationBuilder("channel2", "두 번째 채널")
            builder.setTicker("Ticker")
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            var bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)
            builder.setNumber(100)
            builder.setAutoCancel(true)
            builder.setContentTitle("Content Title 3")
            builder.setContentText("Content Text 3")

            var notication = builder.build()

            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mng.notify(30, notication)
        }
    }

    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder {
        var builder:NotificationCompat.Builder? = null
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, id)

        } else {
            builder = NotificationCompat.Builder(this)
        }

        return builder
    }
}