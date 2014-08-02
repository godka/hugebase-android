LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := bass
LOCAL_SRC_FILES := libbass.so
include $(PREBUILT_SHARED_LIBRARY)
