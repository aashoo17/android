# ExoPlayer
[exoplayer docs from their website](https://exoplayer.dev/)
[exoplayer api reference](https://exoplayer.dev/doc/reference/overview-summary.html)

- basic steps in running exoplayer

## creating the UI view

## getting the player instance and attaching to player UI view

## MediaSource
[MediaSource api reference](https://exoplayer.dev/doc/reference/com/google/android/exoplayer2/source/MediaSource.html)
player always needs MediaSource to play
MediaItem = it is abstraction over any playable content in exoplayer
so we need to convert MediaItem to MediaSource most often
ProgressiveMediaSource = this is actually representing any regular files as MediaSource such as mp4,mkv,mp3 etc
and we will generally work with ProgressiveMediaSource
TODO: what is DefaultDataSourceFactory used for
[DefaultDataSource api reference](https://exoplayer.dev/doc/reference/com/google/android/exoplayer2/upstream/DefaultDataSource.html)
A DataSource supports multiple URI schemes like file:,http:,udp:,content: etc
so we can use DefaultDataSource by calling DefaultDataSourceFactory() there are other classes for handling different Uri but
DefaultDataSource can invoke whichever is appropriate so we do not need to explicitly call that DataSource
so we can say loosely DefaultDataSource is for parsing different Uri which can converted to ProgressiveMediaSource

### getting ProgressiveMediaSource from Uri
```kotlin
    val dataSourceFactory = DefaultDataSourceFactory(this,"ashu")   //this is Context

    //get the uri of which is stored as string in resources file
    val uri = Uri.parse(getString(R.string.link))
    val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
```

## prepare the player using media source

## play when ready

## releasing the player resources when activity destroyed

TODO:
- handling screen rotations
- playing ads before any media
- remembering the last played location for local mediaSource


## others
1. I forgot to add internet permission in manifest file and when player was run later by adding internet
permission in emulator it was throwing socket error which got resolved by uninstalling the app and running again

2. running content from localhost  
generall it is not allowed 
[how to run from localhost](https://codelabs.developers.google.com/codelabs/android-network-security-config/index.html#0)

3. Running native executable in android
my torrent client is written in go which downloads data and serve over localhost this code is cross compiled for  
adroid and arm64 architecture i need a way to invoke this executable and close when required
[Running native executable in android](http://gimite.net/en/index.php?Run%20native%20executable%20in%20Android%20App)

4. working with android shell using adb
had issue with permission denied similar to following stack issue
[adb shell permission denied](https://stackoverflow.com/questions/7399028/android-adb-permission-denied)
TODO: still issue is not resolved for me

[locations which are executable in android](https://stackoverflow.com/questions/13690419/writeable-and-executable-location-on-android)
we have to keep the executable here to be able to execute

for testing using adb =  /data/local/tmp
for real application = "/data/data/" +  packageName + "/files"


