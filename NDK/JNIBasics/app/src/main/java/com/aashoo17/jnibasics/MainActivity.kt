package com.aashoo17.jnibasics

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //TODO: why object library is to be loaded in companion object rather than Activity constructor any benefits
    companion object{
        init{
            System.loadLibrary("native-lib")
        }
    }
    //most of the time we will be working with primitives like int,double then string and array
    external fun myFunction(): Int
    //write a jni function which takes jint as arg and returns jint
    external fun passingReturningPrimitive(a: Int): Int
    //jni function which is operating on string
    external fun sayHello(msg: String): String?
    //work with array types
    external fun workWithPrimitiveArray(a: IntArray): IntArray
    //TODO: work with class/object passed as argument

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //set the textView value with return value from native function call
        val textView = findViewById<TextView>(R.id.textView)
        //set the text
        textView.text = sayHello("This is my string")
    }
}