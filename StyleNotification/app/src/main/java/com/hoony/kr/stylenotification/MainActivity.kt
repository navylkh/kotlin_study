package com.hoony.kr.stylenotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.hoony.kr.stylenotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var builder = getNotificationBuilder("style", "style Notification")
            builder.setContentTitle("Big Picture")
            builder.setContentText("Big Picture Notification")
            builder.setSmallIcon(android.R.drawable.ic_media_next)

            var big = NotificationCompat.BigPictureStyle(builder)
            var bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_andorid)
            big.bigPicture(bitmap)
            big.setBigContentTitle("Big Content Title")

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        binding.button2.setOnClickListener {
            var builder = getNotificationBuilder("style", "style Notification")
            builder.setContentTitle("Big Text")
            builder.setContentText("Big Text Notification")
            builder.setSmallIcon(android.R.drawable.ic_media_next)

            var big = NotificationCompat.BigTextStyle(builder)
            big.setSummaryText("Summary Text")
            big.setBigContentTitle("Big content Title")
            big.bigText("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세")
            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }

        binding.button3.setOnClickListener {
            var builder = getNotificationBuilder("style", "style Notification")
            builder.setContentTitle("InBox")
            builder.setContentText("InBox Notification")
            builder.setSmallIcon(android.R.drawable.ic_media_next)

            var inbox = NotificationCompat.InboxStyle(builder)
            inbox.setSummaryText("Summary Text")

            inbox.addLine("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
            inbox.addLine("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB")
            inbox.addLine("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC")
            inbox.addLine("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD")


            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }
    }

    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder {
        var builder: NotificationCompat.Builder? = null

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