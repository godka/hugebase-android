LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := lua

LOCAL_SRC_FILES := \
	$(subst $(LOCAL_PATH)/,, \
	$(wildcard $(LOCAL_PATH)/*.c))


LOCAL_CFLAGS += -DGL_GLEXT_PROTOTYPES
LOCAL_LDLIBS := -ldl -lGLESv1_CM -lGLESv2 -llog

include $(BUILD_SHARED_LIBRARY)
