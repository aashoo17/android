package com.aashoo17.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/*
[Activity lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle)

showing the what lifecycle methods will be called when these things happen
1. activity launched and running
2. small portion of activity is not visible and something else came there
3. activity not at all visible and comes in foreground when user navigates to it
4. activity was killed by system and you navigates to it. TODO: how we can create this situation

Just log the name of the lifecycle method when that particular method is called see logcat

Launching other activities using explicit intent
Tasks and Backstacks of activities
Parcelables and Bundles - for storing simple data
show bundle use
 */
class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        Log.d("MainActivity","onCreate")

//        val button = findViewById<Button>(R.id.button)
//        val intent = Intent(this,IntentActivity::class.java)
//
//        //add something extra data with intent
//        intent.putExtra("intValue",10)
//        button.setOnClickListener {
//            v: View -> startActivity(intent)
//        }
//        //using Bundle to save value
//        savedInstanceState?.putString("value","10")
//        val textView = findViewById<TextView>(R.id.textView2)
//        if(savedInstanceState != null){
//            textView.text = savedInstanceState.get("value") as CharSequence?
//        }else{
//            textView.text = "10"
//        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity","onRestart")
    }
}