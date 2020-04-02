package com.yghysdr.cmakelib;

/**
 * Created by yghysdr@163.com on 2020-04-02
 * description:
 */
public class HelloCMake {

    static {
        System.loadLibrary("cmake-lib");
    }

    public String getString() {
        return "java return 123";
    }

    public native String getNativeString();

}
