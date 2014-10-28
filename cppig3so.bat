copy ..\develop\bin\libkys*.so jni\kys_pig3\
copy ..\develop\bin\libkys*.so libs\armeabi\
del *.apk
move bin\SDLActivity.apk SDLActivity.apk
dir /w
