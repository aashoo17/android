# Android Library

[android library basics](https://developer.android.com/studio/projects/android-library)

## jar vs aar
jar = .class files zipped together 
TODO: jar command line basics 
aar = android activity, servies, layouts zipped together

## create module
create as new android library in android studio

## import module
local import =  
from jcenter/maven =  
adding exoplayer in mylibrary = this is like adding aar files of android

## add configurations to use library

inside settings.gradle
include ':app', ':mylibrary'

inside build.gradle  
if we have launcher activity inside library then with this we can even directly launch it in our main project without adding any activity/layout
dependencies {
   implementation project(":mylibrary")
}

