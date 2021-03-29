package com.aashoo17.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BundleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bundle)

        val textView = findViewById<TextView>(R.id.textView2)
        if(intent.getStringExtra("myData") != null){
            textView.text = intent.getStringExtra("myData")
        }

        //TODO: send the result back when activity started with startActivityForResult()
        savedInstanceState?.putString("bundleData","BundleDataFilledConfigChange")
        if(savedInstanceState != null){
            val textView3 = findViewById<TextView>(R.id.textView3)
            textView3.text = savedInstanceState.getString("bundleData")
        }

    }
}