package com.aashoo17.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    //create receiver
    val br = MyReceiver()
    //create intent filter
    val fltr = IntentFilter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        //add action for events which we want to capture
        fltr.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        //register with android system
        registerReceiver(br,fltr)
    }
    override fun onStop() {
        super.onStop()
        //stop listening for broadcast when in background
        unregisterReceiver(br)
    }

}