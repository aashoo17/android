package com.aashoo17.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        //get the AlarmManager Service
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        //create an intent to invoke SecondActivity
        val intent = Intent(this,SecondActivity::class.java)

        //TODO: learn more about pending intent
        val pendingIntent = PendingIntent.getActivity(this,10,intent,PendingIntent.FLAG_UPDATE_CURRENT)

        //trigger pending intent after 5 second
        alarmManager.set(AlarmManager.ELAPSED_REALTIME,5000,pendingIntent)


    }
}