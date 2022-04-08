package com.tplink.libmediaapi.common.apicallback;

import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpcommonstream.stream.control.notification.MotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;

/* loaded from: classes3.dex */
public interface StreamNotificationCallback {
    void onReceiveDeviceLockedInfo(String str, DeviceLockedInfo deviceLockedInfo);

    void onReceiveLensMaskInfo(String str, boolean z);

    void onReceiveMotorStatus(String str, MotorStatus motorStatus);

    void onReceiveStreamFinish(String str, String str2);

    void onReceiveStreamStatus(String str, StreamStatus streamStatus);
}
