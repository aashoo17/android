package com.aashoo17.customedittext

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val customEditText = CustomEditText(this).apply {
            minWidth = MATCH_PARENT
            minHeight = WRAP_CONTENT
        }

        val id = View.generateViewId()
        val layout = ConstraintLayout(this).apply {
            addView(customEditText)
            this.id = id
        }


        val params = customEditText.layoutParams as ConstraintLayout.LayoutParams

        params.apply {
            leftToLeft = id
            rightToRight = id
            topToTop = id
            bottomToBottom = id
        }
        setContentView(layout)
    }
}


class CustomEditText(ctx: Context): EditText(ctx){

}