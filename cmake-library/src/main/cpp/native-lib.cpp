#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jstring JNICALL
Java_com_yghysdr_cmakelib_HelloCMake_getNativeString(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("this is from cmake native");
}