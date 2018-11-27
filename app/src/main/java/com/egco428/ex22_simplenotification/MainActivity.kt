package com.egco428.ex22_simplenotification

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationBtn.setOnClickListener {
            val intent = Intent(this@MainActivity,CallActivity::class.java)
            val pIntent = PendingIntent.getActivity(this@MainActivity,System.currentTimeMillis().toInt(),intent,0)
            val intent2 = Intent(this@MainActivity,SettingActivity::class.java)
            val pIntent2 = PendingIntent.getActivity(this@MainActivity,System.currentTimeMillis().toInt(),intent2,0)
            val intent3 = Intent(this@MainActivity,WarningActivity::class.java)
            val pIntent3 = PendingIntent.getActivity(this@MainActivity,System.currentTimeMillis().toInt(),intent3,0)

            val callAction = NotificationCompat.Action.Builder(R.drawable.star,"Call",pIntent).build()
            val settingAction = NotificationCompat.Action.Builder(R.drawable.star,"Setting",pIntent2).build()
            val warningAction = NotificationCompat.Action.Builder(R.drawable.star,"Warning",pIntent3).build()

            val notiBuilder = NotificationCompat.Builder(this@MainActivity)
            notiBuilder.setSmallIcon(R.drawable.star)
            notiBuilder.setContentTitle("New message from test@egco428.com")
            notiBuilder.setContentText("This  is a test message sending from Android")
            notiBuilder.addAction(callAction)
            notiBuilder.addAction(settingAction)
            notiBuilder.addAction(warningAction)
            notiBuilder.setWhen(System.currentTimeMillis()+10000)

            val notiManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notiManager.notify(0, notiBuilder.build())
        }
    }
}
