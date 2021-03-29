package com.aashoo17.uivisibility

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HideNavigation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hide_navigation)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }
}