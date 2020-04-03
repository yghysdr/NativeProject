> 在 Android 项目中使用jni有两种编译方案，一种是传统的ndkbuild，一种是当前推荐使用的 cmake；两者最后都是通过make调用编译器去生成代码。

## CMke
在ndk-build中，采用Android.mk+Application.mk+src的方式。ndk-build 脚本使用 NDK 的基于 Make 的编译系统构建项目
### cmake方式项目gradle配置
```
android {
    defaultConfig {
        //用于设置ExternalNativeNdkBuildOptions，如abiFilters、cppFlags等；
        externalNativeBuild {
            cmake {
                abiFilters "armeabi-v7a"
                cppFlags ""
            }
        }
    }
    externalNativeBuild {
        cmake {
            path "src/main/cpp/CMakeLists.txt"
            version "3.10.2"
        }
    }
}
```
### CMakeLists配置
```
# 设置构建本机库所需的CMake最低版本。
cmake_minimum_required(VERSION 3.4.1)

# 设置编译名称，每一个add_library代表一个so库
add_library(＃设置库的名称。 需要打包
        cmake-lib
        ＃设置库为共享库。
        SHARED
        # 提供源文件的相对路径。可以是多个文件
        native-lib.cpp  libs/child-lib.cpp)
        
add_library(＃设置库的名称。 需要打包
        aaa-lib
        ＃设置库为共享库。
        SHARED
        # 提供源文件的相对路径。可以是多个文件
        aaa.cpp)

# 搜索预建库并将路径存储为变量
find_library(
        ＃设置变量
        log-lib 
        # 搜索库的名称
        log)

# 指定库CMake应该链接到您的目标库。可以链接多个库 
target_link_libraries( 
        # 最终打包的库
        cmake-lib
        aaa-lib
        # 将日志库链接到cmake-lib里面
        ${log-lib})
```


## NDK-Build
在camke中，采用CmakeLists.txt+src的方式
### ndk-build方式项目gradle配置
```
android {

    defaultConfig {
        //用于设置NDKOption，如abiFilters等；
        ndk{
            abiFilters "armeabi-v7a"
        }
    }

    externalNativeBuild {
        ndkBuild {
            //配置文件的地址
            path "src/main/jni/Android.mk"
        }
    }
}
```
### Android.mk配置
```
//单个so库多个文件
# so库名字
LOCAL_MODULE    := nn_sample
# 打包原文件 多个文件用\分开
LOCAL_SRC_FILES := $(JNI_SRC_PATH)/nn_sample.cpp \
                   $(JNI_SRC_PATH)/simple_model.cpp

```
### 编译方式
- 通过ndk-build直接编译（进入到jni目录下，直接运行ndk-build）
- 通过Android studio编译。


### 参考
- [google ndk-samples](https://github.com/android/ndk-samples)

