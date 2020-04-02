package com.tal.ndkbuild;

/**
 * Created by yghysdr@163.com on 2020-04-02
 * description:
 */
public class HelloNdkBuild {

    static {
        System.loadLibrary("ndk-lib");
    }

    public native String getNativeString();
}
