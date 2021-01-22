# Gradle for Android
[android app basics](https://developer.android.com/studio/projects)  
[configure build process](https://developer.android.com/studio/build)

## groovy basics
variable  
def x = 10  //dynmaic type can be changed from int to any other type
int x = 10  //type is given and fixed
x = 10  //TODO: I think this can also br done but check

function  
def call(cl){
    cl()
}       //function without type we just expect correct type is given or can be checked to run code if type is correct   
void call(Closure cl){
    cl()    
}       //function with types  

call({print("Hello")})      //passing closure
call{print("Hello)}         //passing closure but call's () is ommited for any function we can omit this in groovy
call{print "Hello"}         //print function () is also omitted

closure
can be defined inside {} and called like finction with ()

putting variable value inside string
int x = 10
String y = "hello$x"    //value is put using $ before name as $x

## project, module, sourcesets

[look at fugure 2 inside this link to understand project, module, sourceset](https://developer.android.com/studio/build)

project = entire app  
module = small-small units making the entire app even one is capable to produce entire android app  
sourcesets = structure how your code and resources are kept in folder this helps in compilation  

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

ext block = set up variables etc which can be used in anywhere such as project/modules  
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


