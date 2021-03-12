package com.aashoo17.gradle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = ConstraintLayout(this)
        val view = TextView(this)
        view.text = "Hello World from Ashu"

        layout.addView(view)
        setContentView(layout)
    }
}