package com.aashoo17.gradle

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        val view = TextView(this)
        view.text = "Hello World from Ashu"

        layout.addView(view)
        setContentView(layout)
    }
}