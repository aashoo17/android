package com.aashoo17.mylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val btn = Button(this)
        btn.apply {
            text = "start"
        }

        val layout = ConstraintLayout(this)
        val id = View.generateViewId()
        layout.addView(btn)
        layout.id = id

        //get the layout params
        val params = btn.layoutParams as? ConstraintLayout.LayoutParams
        params?.apply {
            leftToLeft = id
            rightToRight = id
            topToTop = id
            bottomToBottom = id
        }

        setContentView(layout)
    }
}