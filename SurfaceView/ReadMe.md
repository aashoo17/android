# SurfaceView

[Surfaceview android reference](https://developer.android.com/reference/kotlin/android/view/SurfaceView)
[SurfaceHolder.Callback android reference](https://developer.android.com/reference/kotlin/android/view/SurfaceHolder.Callback)

I think screen/window is made of lot of surface (can be even one to fill the whole screen), 

TODO: show diagramatically how display screen and surfaces look together

so how to get/create of your own surface to fill it with what you want  
we have been given SurfaceView in android to do that   

SurfaceView -> SurfaceHolder -> Canvas -> Surface

so creating SurfaceView creates SurfaceHolder, Canvas & Surface by itself (easy for you ahaan)  
to change Surafce we will be needing SurfaceHolder and using Canvas we will paint the Surface  

## SurfaceView drawing from another thread

so generally all the rendering/drawing on the surface happens from the main thread  
but with SurfaceView we can drawn on another thread so avoiding us performance bottlnecks as main thread has to do lot of works  

TODO: use the coroutines to drawn from another thread on the surface and since surface is being drawn from another thread do pause & resume the  
updation work when activity is going in background and coming. Since other thread will bypass the Main thread then where activity lies



## availability of surface in SurfaceView before drawing

SurfaceView creates Suface and then destroys it so before drawing something on the surface do check if the  
surface is really available to drawn upon

SurfaceHolder.CallBack makes that easy for you this will give you three functions to be run when 

surface is
1. created
2. destroyed
3. changed




