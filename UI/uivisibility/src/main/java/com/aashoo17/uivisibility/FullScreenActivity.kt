package com.aashoo17.uivisibility

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FullScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)

        /*
        Possible full screen options:
        Lean Back: SYSTEM_UI_FLAG_FULLSCREEN and SYSTEM_UI_FLAG_HIDE_NAVIGATION
        Immersive: SYSTEM_UI_FLAG_IMMERSIVE flag in conjunction with SYSTEM_UI_FLAG_FULLSCREEN and SYSTEM_UI_FLAG_HIDE_NAVIGATION.
        Sticky Immersive: SYSTEM_UI_FLAG_IMMERSIVE_STICKY flag in conjunction with SYSTEM_UI_FLAG_FULLSCREEN and SYSTEM_UI_FLAG_HIDE_NAVIGATION
         */

        //TODO: what to use and/or
        //android example used or here
        //https://developer.android.com/training/system-ui/immersive
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }
}