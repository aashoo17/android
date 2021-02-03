# JNI Basics

## when JNI is required
when we want to use native functions from c/cpp we will use JNI to call those methods from java/kotlin

## where to add our c/cpp code

in Android mode click on java folder and right click, select the option add c++ to module  
one more cpp folder is now visible in Android mode  

**cpp folder breakdown**
includes = this folder shows all the header files from c/cpp available to us for use this folder is never modified by us  
since these header files are already available to us we don't have to write anything explicit in CmakeLists.txt file to find headers. nice!

CMakeLists.txt = this is where we write logic for c/cpp code compilation, library creation etc  
in android this is not very complex and no need to know cmake in advance  

these 5 lines are generally used in cmake in android 

```cmake
# this well the minimum cmake required version for compilation 3.10.2 is currently being used by android
cmake_minimum_required(VERSION 3.10.2)
# give a name to your native code called as project here it is given as jnibasics.
project(jnibasics)
# this will create native-lib.so library from native-lib.cpp 
add_library(native-lib SHARED native-lib.cpp )
# find the existing log library and name it a variable log-lib
find_library(log-lib log )
# this tells at the time of native-lib.so creation also link/add the found log library to it so that all functions
# used from log.h used in native-lib.cpp will work
target_link_libraries(native-lib ${log-lib} )
```

## what changed in gradle when native code (c/cpp) is being used and learn all possible syntax in gradle

this line was added in gradle which points to CMakeLists.txt

externalNativeBuild {
        cmake {
            path file('src/main/cpp/CMakeLists.txt')
        }
    }

TODO: look for other options which can be used

## writing native code and calling in java (in android mostly in activity)

**setting things in java (in activity in android)**

loading the native library created by cmake - here native-lib.so file  

this is the preffered way in android  
```kotlin
class MainActivity : AppCompatActivity() {
    companion object{
        init{
            //load the native library
            System.loadLibrary("native-lib.so")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
``` 

another way to load the library  

```kotlin
class MainActivity : AppCompatActivity() {
    init{
        //load the library
        System.loadLibrary("native-lib.so")
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
```

TODO: I am not sure what is the benefit of loading the library in companion object vs Activity constructor itself  


**writing native code**
so now inside native-lib.cpp we can write all the c/cpp code as usual  

**native code which is to be called java side (Activity side usually)**
this will be a litte different in android  
the code/method which you want to call in android side has to be given some specific names  

simple way to do it is  

let say in java side your function should be like this  

fun myFunction(): Int     => this means function name is myFunction and returns int and takes no arguments  

in Activity of android write this  

external fun myFunction(): Int  

and go to native-lib.cpp file and just type first word of the function which is m here and you will see a hint which looks like  
MainActivity.myFunction() tab/enter on it and it will automatically write the required signature at native side  

I got this
```cpp
#include <jni.h>

extern "C"
JNIEXPORT jint JNICALL
Java_com_aashoo17_jnibasics_MainActivity_myFunction(JNIEnv *env, jobject thiz) {
    // TODO: implement myFunction()
}
```

weird signature of this function nonetheless anyway, lol  


## understand (JNIEnv *env, jobject thiz) part  and passing arguments and returning from function for uses in java side

[Learn this article to understand these topic](https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaNativeInterface.html)  

what is JNIEnv and jobject  

what's up with jint, jfloat etc  
Java Primitives: jint, jbyte, jshort, jlong, jfloat, jdouble, jchar, jboolean for Java Primitive of int, byte, short, long, float, double,
char and boolean, respectively.  

Java Reference Types: jobject for java.lang.Object.  
It also defines the following sub-types:  
jclass for java.lang.Class.
jstring for java.lang.String.
jthrowable for java.lang.Throwable.
jarray for Java array. Java array is a reference type with eight primitive array and one Object array.
 Hence, there are eight array of primitives jintArray, jbyteArray, jshortArray, jlongArray, jfloatArray, jdoubleArray, jcharArray and jbooleanArray;
and one object array jobjectArray.  

 
returning/passing as arguments these types - int, float, char, string, array etc   
The native functions receives argument in the above JNI types and returns a value in the JNI type (such as jstring, jintArray). 
However, native functions operate on their own native types (such as C-string, C's int[]). Hence, there is a need to convert (or transform)
between JNI types and the native types.  

The native programs:

1. Receive the arguments in JNI type (passed over by the Java program).
2. For reference JNI type, convert or copy the arguments to local native types, e.g., jstring to a C-string,
jintArray to C's int[], and so on. Primitive JNI types such as jint and jdouble do not need conversion and can be operated directly.
3. Perform its operations, in local native type.
4. Create the returned object in JNI type, and copy the result into the returned object.
5. Return.

**Passing Primitives like jint, jdouble**
just use them like normal int, double etc in c/cpp  
see the external fun passingReturningPrimitive(a: Int): Int inside MainActivity class

**Passing Strings**
see this private native String sayHello(String msg); in MainActivity  

Passing strings is more complicated than passing primitives, as Java's String is an object (reference type), 
while C-string is a NULL-terminated char array. You need to convert between Java String (represented as JNI jstring) and C-string (char*).

The JNI Environment (accessed via the argument JNIEnv*) provides functions for the conversion:
1. To get a C-string (char*) from JNI string (jstring), invoke method const char* GetStringUTFChars(JNIEnv*, jstring, jboolean*).
2. To get a JNI string (jstring) from a C-string (char*), invoke method jstring NewStringUTF(JNIEnv*, char*).

**passing arrays**

see the external fun workWithPrimitiveArray(a: IntArray): IntArray  
conversion from java array to c array => jintarray to int[]  
consersion from c array to java array => int[] to jintarray

so ultimately i understand what from these?  
JNIEnv provides all helper functions to covert to/from java types to native types   
what is the use of implicit jobject though ?




