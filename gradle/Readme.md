# Running Gradle Builds

# Android specific topics
[configure build process](https://developer.android.com/studio/build)
**how android app is compiled**  
**project, module and sourcesets**  
look at figure 2 inside this link to understand project, module, sourceset  

project = entire app  
module = small-small units making the entire app even one is capable to produce entire android app  
sourcesets = structure how your code and resources are kept in folder this helps in compilation
**settings.gradle**  
**explain build.gradle file of android - project level & module levels**  
**gradle.properties** 
**local.properties**  

**add dependency**
**configure build variants**  
**inspect your .apk using apkanalyzer**  

[android app basics](https://developer.android.com/studio/projects)  
**explain the simple app directories**  
**android modules**

## groovy basics
[basics of groovy language](https://medium.com/@andrewMacmurray/a-beginners-guide-to-gradle-26212ddcafa8)

android-studio => tools => groovy console  
we can use it to test groovy code  

```groovy
//variable
def a = 10  //dynamic type can be changed from int to any other type
int b = 10  //type is given and fixed
x = 10  //TODO: I think this can also be done for variable but check

//function and closure 
//function without type we just expect correct type is given or can be checked to run code if type is correct  
def call(cl){
    cl()
}
//function with types
void call2(Closure cl){
    cl()    
}         

//these functions call will work on call2() also
call({print("Hello")})      //passing closure
call {print("Hello")}         //  closure but call's () is ommited for any function we can omit this in groovy
call {print "Hello"}         //print function () is also omitted

call2({print("Hello")})      //passing closure
call2 {print("Hello")}         //  closure but call's () is ommited for any function we can omit this in groovy
call2 {print "Hello"}         //print function () is also omitted

//closure
//can be defined inside {} and called like finction with ()
//TODO: what about .call() syntax over closure

//putting variable value inside string
int c = 10
String d = "hello$x"    //value is put using $ before name as $x
```

## compilation in android app

[figure 1 explains the compilation process out od code+res etc](https://developer.android.com/studio/build)

## gradle.settings file
all module dependencies are described here say we have 2 module app(default one) and player  
then we say  
include ":app", ":player"

or seperately
include ":app"
include ":player"

## build.gradle
this file used by gradle to run tasks to do some thing  
at min we have 2 build.gradle file
1. for project
2. for default module called app

if we add more module we will get more build.gradle files

### project/top level build.gradle
buildScript = gradle doesn't have capability to compile android app or kotlin/java code at base level    
so we need plugins that is described inside this block as well as from where they can be downloaded

ext (called as extra) block = set up variables etc which can be used in anywhere such as project/modules
```groovy
ext {
    // The following are only a few examples of the types of properties you can define.
    compileSdkVersion = 28
    // You can also create properties to specify versions for dependencies.
    // Having consistent versions between modules can avoid conflicts with behavior.
    supportLibVersion = "28.0.0"
}

```

allProjects = this configures dependencies and remote server for downloading them for all modules
[gradle buildScript vs allProjects](https://stackoverflow.com/questions/30158971/whats-the-difference-between-buildscript-and-allprojects-in-build-gradle)

### module level build.gradle
plugins = which defines plugins to be used with id block

id 'com.android.application' = this tells to use application plugin which will in turn provide many blocks to setup like android block

android block = set up android specific settings  
buildTypes = configure/apply these settings when debug/release kind of build happening
```groovy
buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
```

productFlavors = here we can specify different apks such as free/paid and others and specify settings  
flavorDimensions = TODO: why it is required when productFlavors is used
```groovy
//TODO: find out about flavorDimensions
flavorDimensions "tier"
  productFlavors {
    free {
      dimension "tier"
      applicationId 'com.example.myapp.free'
    }

    paid {
      dimension "tier"
      applicationId 'com.example.myapp.paid'
    }
  }

```

dependencies = specify all dependencies your module depends upon

```groovy
dependencies {
    // Dependency on a local library module
    implementation project(":mylibrary")

    // Dependency on local binaries
    implementation fileTree(dir: 'libs', include: ['*.jar'])

    // Dependency on a remote binary
    implementation 'com.example.android:app-magic:12.3'
}

```

## gradle.properties and local.properties
gradle.properties = settings related to gradle itself like heap size etc  
local.properties = local env properties such as sdk/ndk/cmake locations

## File => Project Structure
so what happens we have to remember all the blocks name and then type of settings we can give the most important ones can be given using GUI  
from File => Project Structure

Project = specify gradle version etc
SDK Location = as the name suggests location of SDK
Variables = create variables
Modules = module specific settings
Dependencies = can search for dependecies here and attach in gradle file
Build Variants = productFlavor concept is setup here

## gradle android plugin

[build and run android app](https://developer.android.com/studio/run)  
[configure android build](https://developer.android.com/studio/build)

[gradle android plugin api](https://developer.android.com/reference/tools/gradle-api/7.0/classes)  
**from this learn all possible syntax we can use in android{} block**  



# General gradle topics

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

## gradle wrapper
gradlew and gradlew.bat files  
[gradle wrapper explained](https://docs.gradle.org/current/userguide/gradle_wrapper.html)  


