package com.aashoo17.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.sync.Mutex

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val linearLayout =  LinearLayout(this)
        textView = TextView(this).apply {
            text = "Hello World"
        }

        linearLayout.addView(textView)
        setContentView(linearLayout)
    }

    override fun onStart() {
        super.onStart()

        //create a coroutine scope
        val scope = CoroutineScope(Dispatchers.IO)
        //launch a coroutine
        scope.launch {
            textView.text = "updated here"
        }
        //cancel all the coroutines in this scope
        scope.cancel(null)
    }

    override fun onResume() {
        super.onResume()

        //show the channel
        val channel = Channel<Int>()
        GlobalScope.launch{
            //this will wait on the channel to receive data which was sent from second coroutine below
            //so in turn it ensures that 2nd coroutine is finished before 1st printing the text
            channel.receive()
            //this should printed 2nd
            Log.d("mainActivity","message from 1st coroutines")
        }
        GlobalScope.launch {
            //this should get printd first
            Log.d("mainActivity","message from 2nd coroutines")
            channel.send(10)
        }

        //mutex
        val mux = Mutex()
        //shared varible modified by multiple coroutines
        var i = 0
        repeat(1000){
            GlobalScope.launch {
                mux.lock()
                i++
                mux.unlock()
            }
            Log.d("mainActivity",i.toString())
        }

    }
}
