package com.aashoo17.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver : BroadcastReceiver() {
    //onReceive() will run when any broadcast is received but has to finsih the code in 16 mS otherwise code will not complete
    //so don't write big tasks here directly 
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("ashu", intent.getBooleanExtra("state",false).toString())
    }
}