package com.aashoo17.exoplayervideo

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.HttpDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var playerView: PlayerView
    private lateinit var player: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //access the playerview where media will be displayed
        playerView = findViewById(R.id.playerView)
        //create an exoplayer instance
        player = SimpleExoPlayer.Builder(this).build()
        //bind the player to the view
        playerView.setPlayer(player)
    }


    override fun onStart() {
        super.onStart()
        //add media for playing
        //MediaSource is used in exoplayer
        //[DefaultDataSource api reference](https://exoplayer.dev/doc/reference/com/google/android/exoplayer2/upstream/DefaultDataSource.html)
        val dataSourceFactory = DefaultDataSourceFactory(this,"exoplayer-ashu")

        //get the uri of which is stored as string
        val uri = Uri.parse(getString(R.string.localhost))
        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)

        //prepare the player by passing mediaSource to be played
        player.prepare(mediaSource)
        //play when ready
        player.playWhenReady
    }

    override fun onStop() {
        super.onStop()
        //release the resourses associated with player
        player.release()
    }
}

