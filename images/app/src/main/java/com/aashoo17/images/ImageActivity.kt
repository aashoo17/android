package com.aashoo17.images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

/*
ImageView:
do positioning and all in xml
try to change size later in code from what declared
 */

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val imageView = findViewById<ImageView>(R.id.imageView2).apply {
            //this adjustViewBounds required for changing size of image again
            adjustViewBounds = true
            //change size now
            maxWidth = 700
            //TODO: I am able to make it smaller than original size but not bigger using ScaleType
            maxHeight = 700
            scaleType = ImageView.ScaleType.CENTER_CROP
        }
    }
}