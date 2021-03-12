# What is most important
this is what we will be usually needing - this covers most things

groovy basics - java code, function call, closure uses  
understand why 2 build.gradle file - what they do, can even there be more  
android {} block configuration using project structure  
setting.gradle use case  
[building app](https://developer.android.com/studio/run)
[configuring app basics](https://developer.android.com/studio/build)




# Running Gradle Builds

## groovy basics
[basics of groovy language](https://medium.com/@andrewMacmurray/a-beginners-guide-to-gradle-26212ddcafa8)

only three key takeaways :
1. valid java is valid groovy
2. function call don't need ()
3. closure can be passed as {}

## build properties

[Build Environment official groovy docs](https://docs.gradle.org/current/userguide/build_environment.html)  
modify the gradle itself  
precedence order is like this one which is first overrides other  
1. command-line flags 2. system properties 3. gradle properties 4. environment variables

**gradle.properties** file  
out of the above 4 options this will be used generally  
kept in the root directory

## gradle daemon
[gradle daemon](https://docs.gradle.org/current/userguide/gradle_daemon.html)
it is on by default  
why it is used and its benefits  
how to disable  
get the list of running daemons  

## multi project build
[multi project gradle](https://docs.gradle.org/current/userguide/intro_multi_project_builds.html)  
android apps are split into multiple projects  
**gradle -q projects**  
if we run this command we see by default android has atleast 2 gradle projects  
TIP: if we want to run gradle -q projects in android-studio terminal after writing the command instead of enter hit ctrl + enter  

root directories with  
**settings.gradle**    
settings.gradle file tells gradle how the project and subprojects are structured  
running **gradle projects** can tell you the project structure don't need to explore settings.gradle file to know about project structure  
[gradle settings class all methods](https://docs.gradle.org/current/javadoc/org/gradle/api/initialization/Settings.html)  
above link shows all things that can be used in settings.gradle file  
android uses atleast these include, rootProject.name, rootProject.name find out what they mean  

settings.gradle  
[buildCache](https://docs.gradle.org/current/userguide/build_cache.html)

**build.gradle**  
The root build.gradle is used to share common configuration between the child projects  
build files might not be called build.gradle. Many projects will name the build files after the subproject names, such as api.gradle and services.gradle, interesting

child directories => *.gradle
## scan builds

## optimize build times


# Authoring gradle builds

## project and tasks

something which has to be done is given a name and is called task  
pieces of code which is given a name and called by gradle  
multiple tasks combine themselves to make a project in whole  
written in build.gradle file

-q flag in gradle invokation will suppress any gradle specific logs  
it may be useful if we want to see only results

TODO:
write a task named task 1 which will do something say print "hello world"

dependency of one task on other task

Default tasks

[basic project properties](https://docs.gradle.org/current/userguide/writing_build_scripts.html)

## dependency management
[dependency management in gradle](https://docs.gradle.org/current/userguide/core_dependency_management.html)


## plugins

gradle init plugin  
init is a plugin which is already available in gradle

initialize project folder with gradle specific files  
[gradle init official docs](https://docs.gradle.org/5.0/userguide/build_init_plugin.html)
[gradle plugins](https://docs.gradle.org/current/userguide/plugins.html)

normally all the tasks for a typical project is defined and we only have to call it by knowing which task is to be called when

TODO: working with java/kotlin and android plugins

gradle init flags  
--type  
basic build init type => if not specified any

--dsl
kotlin dsl
groovy dsl

--project-name

# Logging
[logging from gradle](https://docs.gradle.org/current/userguide/logging.html)

# References:

[benefits of kotlin over groovy in gradle](https://blog.gradle.org/kotlin-meets-gradle)  
also you don't have to learn a new language if you are developing android etc in kotlin  
[When to use gradle.properties vs. settings.gradle?](https://stackoverflow.com/questions/45387971/when-to-use-gradle-properties-vs-settings-gradle)  
[gradle samples using kotlin](https://github.com/gradle/kotlin-dsl-samples/tree/master/samples)

learn about kotlin DSL used in gradle   
[DSL in kotlin part 1](https://proandroiddev.com/writing-dsls-in-kotlin-part-1-7f5d2193f277)  
[DSL in kotlin part 2](https://proandroiddev.com/writing-dsls-in-kotlin-part-2-cd9dcd0c4715)


## gradle android plugin

[build and run android app](https://developer.android.com/studio/run)  
[configure android build](https://developer.android.com/studio/build)