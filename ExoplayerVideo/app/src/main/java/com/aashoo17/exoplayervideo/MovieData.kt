package com.aashoo17.exoplayervideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_data)

        GlobalScope.launch {
            withContext(Dispatchers.Default){
                //lauch the go-peerflix executable
                Runtime.getRuntime().exec("./go-peerflix")
            }
        }
    }
}