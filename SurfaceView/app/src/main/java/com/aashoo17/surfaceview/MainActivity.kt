package com.aashoo17.surfaceview

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var customSurface: CustomSurface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        customSurface = CustomSurface(this)
        //request full screen
        customSurface.setSystemUiVisibility(SYSTEM_UI_FLAG_FULLSCREEN)

        //add the callback to be invoked when surface to be drawn upon is available, changed, destroyed
        customSurface.holder.addCallback(MyCallback())
        //display the surface on screen
        setContentView(customSurface)
    }
}
//custom surface class inheriting from SurfaceView
class CustomSurface(ctx: Context): SurfaceView(ctx){

}

//callbacks which are run when surface to be drawn upon is available, changed, destroyed
class MyCallback: SurfaceHolder.Callback{
    //a simple rectangle
    val rectF = RectF(0f,0f,500f,500f)
    //paint describing how Rect when drawn will look
    val paint = Paint().apply {
        setColor(Color.WHITE)
    }
    //call when surface is created
    override fun surfaceCreated(holder: SurfaceHolder) {
        //lock canvas so that other threads can not update the canvas
        val canvas = holder.lockCanvas()
        //check if lock was succesful and canvas is not null
        if(canvas != null){
            //drawn the rect
            canvas.drawRect(rectF,paint)
            //unlock the canvas and draw things mentioned
            holder.unlockCanvasAndPost(canvas)
        }
    }
    //call when suface changes (in size etc)
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }
    //call when surface destroyed
    override fun surfaceDestroyed(holder: SurfaceHolder) {

    }

}

