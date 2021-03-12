#include <jni.h>
#include <cstring>

extern "C"
JNIEXPORT jint JNICALL
Java_com_aashoo17_jnibasics_MainActivity_myFunction(JNIEnv *env, jobject thiz) {
    return 10;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_aashoo17_jnibasics_MainActivity_passingReturningPrimitive(JNIEnv *env, jobject thiz,
                                                                   jint a) {
    //do something with jint a
    a = 10;
    //return a jint i am just returning a as being jint, could be simple like this return 10;
    return a;
}

/*
 * String:
 * so i understood this when converting java string(jstring) to char* we have to release it explcitly otherwise that memory will be lying somewhere
 * TODO: how to get the char* in place of const char* from jstring
 * when converting char* to jstring which UTF 8/16/32 is received
 * TODO: So which UTF type UTF 8/16/32 char* gets converted
 */


//this will change the java string type to c string and vice versa
//for cpp string we can get c string by calling string.c_str() function and the use the same thing
extern "C"
JNIEXPORT jstring JNICALL
Java_com_aashoo17_jnibasics_MainActivity_sayHello(JNIEnv *env, jobject thiz, jstring msg) {
    //doing something with java/kotlin string passed as jstring msg
   const char *a = env->GetStringUTFChars(msg,nullptr);

   //release resources memory associated with char*
   env->ReleaseStringUTFChars(msg,a);
    char b[] = "This is native string";
   //now get jstring from b to be returned
   return env->NewStringUTF(b);
}


//this shows the conversion of java array to c/cpp array and vice-versa
//this is valid for other array types too
extern "C"
JNIEXPORT jintArray JNICALL
Java_com_aashoo17_jnibasics_MainActivity_workWithPrimitiveArray(JNIEnv *env, jobject thiz,
                                                                jintArray a) {

    //get the pointer to array and lengh that's it you can do anything like normal array as you want
    int *arr = env->GetIntArrayElements(a, nullptr);
    env->GetArrayLength(a);
    //once pointer to array and length is receieved do anything with it

    //release memory
    env->ReleaseIntArrayElements(a,arr,0);

    //how to create java array from native arrays
    int newArr[] = {10,20,30,40,50};

    //new java array which will be initialised by
    jintArray JavaArray = nullptr;
    env->SetIntArrayRegion(JavaArray,0,sizeof(newArr),newArr);

    return JavaArray;
}