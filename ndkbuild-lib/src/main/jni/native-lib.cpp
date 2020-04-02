#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jstring JNICALL
Java_com_tal_ndkbuild_HelloNdkBuild_getNativeString(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("this is Java_com_tal_ndkbuild_HelloNdkBuild_getNativeString");
}