package com.tplink.iot.view.ipcamera.base;

import androidx.annotation.ColorRes;
import b.d.w.h.b;
import com.tplink.iot.R;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

/* compiled from: DeviceModelUtil.java */
/* loaded from: classes2.dex */
public class c {
    public static int a(DeviceModel deviceModel) {
        return t(deviceModel) ? R.drawable.c100_complete : u(deviceModel) ? R.drawable.c200_complete : R.drawable.c310_complete;
    }

    public static int b(DeviceModel deviceModel) {
        return t(deviceModel) ? R.drawable.detect_offline_c100 : u(deviceModel) ? R.drawable.detect_offline_c200 : R.drawable.detect_offline_c310;
    }

    public static int c(DeviceModel deviceModel) {
        return t(deviceModel) ? R.drawable.check_camera_status_c100 : u(deviceModel) ? R.drawable.check_camera_status : R.drawable.check_camera_status_c310;
    }

    public static int d(DeviceModel deviceModel) {
        return R.drawable.c310_connect_router;
    }

    public static int e(DeviceModel deviceModel) {
        return t(deviceModel) ? R.drawable.c100_animate : u(deviceModel) ? R.drawable.camera_c200_animate : R.drawable.camera_c310_animate;
    }

    public static int f(DeviceModel deviceModel) {
        return t(deviceModel) ? R.drawable.c100_list : u(deviceModel) ? R.drawable.c200_list : R.drawable.c310_list;
    }

    public static int g(DeviceModel deviceModel, String str) {
        return s(deviceModel, str) ? R.string.offline_troubleshooting_led_blink_green_slowly : R.string.offline_troubleshooting_led_blink_red_slowly;
    }

    @ColorRes
    public static int h(DeviceModel deviceModel, String str) {
        return s(deviceModel, str) ? R.color.led_green : R.color.led_red;
    }

    public static int i(DeviceModel deviceModel, String str) {
        return s(deviceModel, str) ? R.string.offline_troubleshooting_led_green : R.string.offline_troubleshooting_led_green_or_amber;
    }

    public static int j(DeviceModel deviceModel, String str) {
        return s(deviceModel, str) ? R.string.camera_onboarding_pair_failed_hint1 : R.string.camera_onboarding_pair_failed_hint1_new_led;
    }

    public static int k(DeviceModel deviceModel, String str) {
        return s(deviceModel, str) ? R.string.camera_onboarding_pair_failed_hint3_v2 : R.string.camera_onboarding_pair_failed_hint3_new_led;
    }

    public static int l(DeviceModel deviceModel, String str, boolean z) {
        return s(deviceModel, str) ? z ? R.string.camera_onboarding_pair_failed_hint2_v2 : R.string.camera_onboarding_pair_failed_wpa3 : z ? R.string.camera_onboarding_pair_failed_hint2_v3 : R.string.camera_onboarding_pair_failed_wpa3_c310;
    }

    public static int m(DeviceModel deviceModel) {
        return t(deviceModel) ? R.drawable.reset_camera_c100 : u(deviceModel) ? R.drawable.reset_camera : R.drawable.reset_camera_c310;
    }

    public static int n(DeviceModel deviceModel) {
        return (DeviceModel.CAMERA_C110 == deviceModel || DeviceModel.CAMERA_C210 == deviceModel || DeviceModel.CAMERA_C320WS == deviceModel) ? 256 : 128;
    }

    public static int o(DeviceModel deviceModel) {
        return t(deviceModel) ? R.mipmap.c100_sd : u(deviceModel) ? R.mipmap.c200_sd : R.mipmap.c310_sd;
    }

    public static int p(DeviceModel deviceModel) {
        return t(deviceModel) ? R.string.onboarding_new_ipc_reset_the_camera_tips : u(deviceModel) ? R.string.camera_onboarding_c100_reset : R.string.cmaera_onboarding_wired_reset_the_camera_tips;
    }

    public static int q(DeviceModel deviceModel) {
        return t(deviceModel) ? R.drawable.c100_reset_ts : u(deviceModel) ? R.drawable.c200_reset_ts : R.drawable.c310_reset_ts;
    }

    public static int r(DeviceModel deviceModel) {
        return R.drawable.c310_complete;
    }

    private static boolean s(DeviceModel deviceModel, String str) {
        return !b.d(str) && str.startsWith("1.0") && (deviceModel == DeviceModel.CAMERA_C100 || deviceModel == DeviceModel.CAMERA_C200 || deviceModel == DeviceModel.CAMERA_TC60 || deviceModel == DeviceModel.CAMERA_TC70);
    }

    public static boolean t(DeviceModel deviceModel) {
        return deviceModel == DeviceModel.CAMERA_C100 || deviceModel == DeviceModel.CAMERA_TC60 || deviceModel == DeviceModel.CAMERA_C110;
    }

    public static boolean u(DeviceModel deviceModel) {
        return deviceModel == DeviceModel.CAMERA_C200 || deviceModel == DeviceModel.CAMERA_TC70 || deviceModel == DeviceModel.CAMERA_C210;
    }

    public static boolean v(DeviceModel deviceModel) {
        return deviceModel == DeviceModel.CAMERA_C310 || deviceModel == DeviceModel.CAMERA_TC65 || deviceModel == DeviceModel.CAMERA_C320WS;
    }

    public static boolean w(DeviceModel deviceModel) {
        return DeviceModel.CAMERA_C310 == deviceModel || DeviceModel.CAMERA_C320WS == deviceModel || DeviceModel.CAMERA_TC65 == deviceModel;
    }
}
