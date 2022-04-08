package com.tplink.libtpcommonstream.stream.control.notification;

/* loaded from: classes3.dex */
public interface StreamNotificationCallback {
    void onReceiveDeviceLockedInfo(String str, DeviceLockedInfo deviceLockedInfo);

    void onReceiveLensMaskInfo(String str, boolean z);

    void onReceiveMotorStatus(String str, MotorStatus motorStatus);

    void onReceiveStreamFinish(String str, String str2);

    void onReceiveStreamStatus(String str, StreamStatus streamStatus);
}
