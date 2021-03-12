package com.aashoo17.imagesandgraphics

import android.graphics.*
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class CustomDrawable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imageView = ImageView(this).apply {
            //use the Drawable to fill the imageView
            setImageDrawable(MyDrawable())

            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val constraintLayout = ConstraintLayout(this).apply {
            addView(imageView)
        }
        setContentView(constraintLayout)
    }
}

//custom drawables

class MyDrawable: Drawable(){
    override fun draw(canvas: Canvas) {
        //create a paint
        val paint = Paint().apply {
            color = Color.WHITE
        }

        //get the rectangle bounds of the drawable
        val width = bounds.width()
        val height = bounds.height()

        canvas.drawRect(RectF(0f,0f, width.toFloat(),height.toFloat()),paint)

    }

    override fun setAlpha(alpha: Int) {
        TODO("Not yet implemented")
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        TODO("Not yet implemented")
    }

    override fun getOpacity(): Int {
        return PixelFormat.OPAQUE
    }

}