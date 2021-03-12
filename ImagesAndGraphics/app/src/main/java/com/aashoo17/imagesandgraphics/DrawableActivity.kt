package com.aashoo17.imagesandgraphics

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

/*
Drawable Resource:
aapt tool compiles the drawable resources in res/drawable directory and gives them an id
R.drawable.<id_name>
so many places we can use this id itself
apart from that some places it will be required to actually pass the Drawable type we can use these to get them
ResourcesCompat.getDrawable() and
ContextCompat.getDrawable()
 */

class DrawableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //create an imageView and set the image using bitmap(drawable) resource saved in res/drawable directory
        val imageView = ImageView(this).apply {
            //set the image as bitmap resource
            setImageResource(R.drawable.cat)

            //or we could use the Drawable directly instead of its Resource id
            //setImageDrawable(accessDrawable())

            //TODO: explain this layoutparams
            //this can be used to force the width,height of View to match/wrap with layout/ViewGroup
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

    //accessing resource as Drawable rather than by its id
    fun accessDrawable(): Drawable? {
        val myDrawable = ResourcesCompat.getDrawable(resources,R.drawable.cat,null)
        //or use the ContextCompat
        val myDrawable2 = ContextCompat.getDrawable(applicationContext,R.drawable.cat)
        return myDrawable
    }
}








