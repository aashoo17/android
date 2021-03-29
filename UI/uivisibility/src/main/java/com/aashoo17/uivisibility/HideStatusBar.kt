package com.aashoo17.uivisibility

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HideStatusBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hide_status_bar)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //FIXME: this is not hiding actionBar/appbar
        //I had to do it directly from theme by using NoActionBar
//        actionBar?.hide()
    }
}