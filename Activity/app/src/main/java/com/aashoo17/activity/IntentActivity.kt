package com.aashoo17.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val intent = Intent(this,BundleActivity::class.java)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            startActivity(intent)
        }

        //sending data to next activity with intent
        val intentWithData = Intent(this,BundleActivity::class.java)
        intentWithData.putExtra("myData","SimpleStringData")
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            startActivity(intentWithData)
        }

        //launch the activity to receive the result
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            startActivityForResult(intentWithData,10)
        }
    }
}