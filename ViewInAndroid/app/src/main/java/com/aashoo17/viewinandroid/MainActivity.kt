package com.aashoo17.viewinandroid

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(CustomView(this))
    }
}

//custom view class
class CustomView(ctx: Context): View(ctx) {


    //rectangle which is commonaly used during drawing creation
    val rectF = RectF(0f,0f,800f,400f)
    //paint which will be used to define color and other properties
    val paint = Paint().apply {
        color = Color.WHITE
    }
    //path can be used to generate custom shapes
    val path = Path().apply {
        addArc(rectF,0f,90f)
        quadTo(100f,100f,1000f,1000f)
    }
    //bitmap can be used
    val bitmap = BitmapFactory.decodeResource(resources,R.drawable.bitmap)
    //override onDraw() to have custom drawing
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //go crazy with canvas, paint etc
        canvas?.drawBitmap(bitmap,100f,100f,paint)
    }
}