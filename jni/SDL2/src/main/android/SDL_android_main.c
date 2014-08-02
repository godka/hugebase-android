
#include "SDL_config.h"
#ifdef __ANDROID__

/* Include the SDL main definition header */
#include "SDL_main.h"
/*******************************************************************************
                 Functions called by JNI
*******************************************************************************/
#include <jni.h>
//extern char* m_ip;
//extern char* m_tag;
//extern int m_cameraid;
//extern int playctl;
//int capture();
/* Called before SDL_main() to initialize JNI bindings in SDL library */
extern void SDL_Android_Init(JNIEnv* env, jclass cls);

#include <android/log.h>

#define LOG_TAG "org.app.sdl"

#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

/* Start up the SDL app */
void Java_org_libsdl_app_SDLActivity_nativeInit(JNIEnv* env, jclass cls, jobject obj)
{
    /* This interface could expand with ABI negotiation, calbacks, etc. */
    SDL_Android_Init(env, cls);

    SDL_SetMainReady();

    /* Run the application code! */
    int status;
    char *argv[2];
    argv[0] = SDL_strdup("mythkast.sdl2");
    argv[1] = NULL;
    status = SDL_main(1, argv);

    /* Do not issue an exit or the whole application will terminate instead of just the SDL thread */
    /* exit(status); */
}
#endif /* __ANDROID__ */

/* vi: set ts=4 sw=4 expandtab: */
