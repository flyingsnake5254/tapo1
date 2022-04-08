package com.tplink.iot.view.deviceshare;

import android.app.Activity;
import android.text.TextUtils;
import b.d.b.f.b;
import com.tplink.iot.R;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCDeviceRepository;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.List;

/* compiled from: DeviceShareUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static String a(Activity activity, String str) {
        int d2 = d(str);
        if (str == null || EnumDeviceType.CAMERA != EnumDeviceType.fromType(str)) {
            return activity.getString(R.string.share_device_share_device_limit_new, new Object[]{d2 + ""});
        }
        return activity.getString(R.string.share_device_share_device_limit_camera, new Object[]{d2 + ""});
    }

    public static String b(Activity activity, List<BaseALIoTDevice> list) {
        boolean z = false;
        boolean z2 = false;
        for (BaseALIoTDevice baseALIoTDevice : list) {
            if (baseALIoTDevice.getDeviceType() == null || EnumDeviceType.CAMERA != EnumDeviceType.fromType(baseALIoTDevice.getDeviceType())) {
                z2 = true;
            } else {
                z = true;
            }
        }
        int d2 = d(null);
        int d3 = d(EnumDeviceType.CAMERA.getDeviceType());
        if (z && z2) {
            return activity.getString(R.string.share_device_share_devices_cameras_follow_limit, new Object[]{d3 + "", d2 + ""});
        } else if (z) {
            return activity.getString(R.string.share_device_share_cameras_follow_limit, new Object[]{d3 + ""});
        } else {
            return activity.getString(R.string.share_device_share_devices_follow_limit, new Object[]{d2 + ""});
        }
    }

    public static String c(TCDeviceUserInfoBean tCDeviceUserInfoBean) {
        if (!TextUtils.isEmpty(tCDeviceUserInfoBean.getNickname())) {
            return tCDeviceUserInfoBean.getNickname();
        }
        String cloudUserName = tCDeviceUserInfoBean.getCloudUserName();
        if (TextUtils.isEmpty(cloudUserName)) {
            return "";
        }
        int indexOf = cloudUserName.indexOf("@");
        return indexOf == -1 ? cloudUserName : cloudUserName.substring(0, indexOf);
    }

    public static int d(String str) {
        return ((TCDeviceRepository) b.a(b.d.s.a.a.f(), TCDeviceRepository.class)).F(str);
    }
}
