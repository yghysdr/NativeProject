#include <jni.h>
#include <string>
#include "libs/child-lib.h"

extern "C"
JNIEXPORT jstring JNICALL
Java_com_yghysdr_cmakelib_HelloCMake_getNativeString(JNIEnv *env, jobject thiz) {
    Child child;
    return env->NewStringUTF(child.getKey().c_str());
}