package com.aashoo17.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //these properties are made inside activity for all func to have access
    val notificationId = 0     //id of the notification which is being sent,
    lateinit var notificationManager: NotificationManager;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //get the button from the resource id
        val sendNotificationButton = findViewById<Button>(R.id.button)
        //attach a click listener
        sendNotificationButton.setOnClickListener{
            //send notifications: call this user defined function to send notifications
            sendNotification()
        }
        val cancelNotificationButton = findViewById<Button>(R.id.button3)
        cancelNotificationButton.setOnClickListener{
            cancelNotification()
        }

        val updateNotificationButton = findViewById<Button>(R.id.button2)
        updateNotificationButton.setOnClickListener{
            updateNotification()
        }
    }
    //write notifications sending function

    fun sendNotification(){
        //notification channel
        //so an app can send notifications over variuos channels: say i can name them channel_1, channel_2 or something random like important_channel
        //all the notifications on one particular channel can be made to have same properties:
        //TODO: give some of those properties names

        //notification is a service continuously running in android
        //getSystemService comes from Activity and cast it as generic service is emitted by this function
        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        //create notification channel
        val channelId = "10"
        val channel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(channelId,"notification_1",NotificationManager.IMPORTANCE_HIGH).apply {
                enableLights(true)
                lightColor = Color.RED
                enableVibration(true)
                description = "from channel 1"
            }
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        //create notification channel using this call
        notificationManager.createNotificationChannel(channel)

        //create notification, customize it to your liking here
        val notificationBuilder = Notification.Builder(this,channelId).apply {
            setContentTitle("You have been notified")
            setContentText("This is your notification text")
            setSmallIcon(R.drawable.ic_stat_name)
        }
        //send notification

        notificationManager.notify(notificationId,notificationBuilder.build())
    }
    //TODO: implement logic that update and cancel notification button are disabled until notification is sent earlier
    //implement notification updation logic for a previously sent notification
    fun updateNotification(){
        val channel_id = "10"
        val notificationBuilder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this,channel_id).apply {
                setContentTitle("You have been re-notified")
                setContentText("This is your updated text")
                setSmallIcon(R.drawable.ic_stat_name)
            }
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        notificationManager.notify(notificationId,notificationBuilder.build())
    }
    //cancel the sent notification
    fun cancelNotification(){
        notificationManager.cancel(notificationId)
    }

}

