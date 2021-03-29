package com.aashoo17.uivisibility

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DimSystemBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Dim the system bars
        //TODO: why decorView ?
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE
    }
}