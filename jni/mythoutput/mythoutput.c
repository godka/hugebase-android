#include "mythoutput.h"
#include <jni.h>
#include <android/log.h>

#define LOG_TAG "org.app.sdl"

#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)
int mythoutput(const char* str){
	LOGE("%s",str);
	return 0;
}
