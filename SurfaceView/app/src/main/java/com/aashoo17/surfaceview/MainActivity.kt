/*
create Custom SurfaceView and update the underlying surface from other thread IO/Default
 */

package com.aashoo17.surfaceview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Bundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    //create a CustomSurface class
    private lateinit var customSurface: CustomSurface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initialize
        customSurface = CustomSurface(this)
        //request full screen
        //FIXME: this call is deprecated find the new way
        customSurface.setSystemUiVisibility(SYSTEM_UI_FLAG_FULLSCREEN)
        //display the surface on screen
        setContentView(customSurface)
    }
}
//custom surface class inheriting from SurfaceView
@SuppressLint("ViewConstructor")
/*
finding that when surface is available to be drawn is daunting process
android system provided you SurfaceHolder.Callback interface which will invoke its functions for surface creation,change & destruction
when surface is available
*/
class CustomSurface(ctx: Context): SurfaceView(ctx),SurfaceHolder.Callback{
    lateinit var scope: CoroutineScope
    init{
        //add the callback to be invoked when surface to be drawn upon is available, changed, destroyed
        holder.addCallback(this)
    }
    //call when surface is created
    override fun surfaceCreated(holder: SurfaceHolder) {
        //FIXME: this code when getting executed after activity comes back from background does not give the same effect
        //FIXME: i was hoping scope will be reassigned and launch the coroutines again
        scope = CoroutineScope(Dispatchers.Default)
        //do things in Default thread
        scope.launch(Dispatchers.Default) {
            drawFromBackgroundOnSurface(holder)
        }
        //FIXME: this log show that when activity comes from background surfaceCreated() is called so problem in coroutine somehow
        Log.d("mainActivity","surface created")
    }
    //call when suface changes (in size etc)
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }
    //call when surface destroyed
    override fun surfaceDestroyed(holder: SurfaceHolder) {
        scope.cancel(null)
        Log.d("mainActivity","surface destroyed")
    }
}

suspend fun drawFromBackgroundOnSurface(holder: SurfaceHolder){
    //a simple rectangle
    val rectF = RectF(0f,0f,500f,500f)
    //paint describing how Rect when drawn will look
    val paint = Paint().apply {
        setColor(Color.WHITE)
    }
    val canvas = holder.lockCanvas()
    canvas.drawRect(rectF,paint)
    holder.unlockCanvasAndPost(canvas)
}

