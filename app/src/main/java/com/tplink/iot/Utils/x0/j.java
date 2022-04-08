package com.tplink.iot.Utils.x0;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelStreamStatus;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

/* compiled from: DeviceFireBaseUtils.java */
/* loaded from: classes2.dex */
public class j {
    public static void a(String str, long j, boolean z) {
        BaseALIoTDevice I1 = TPIoTClientManager.I1(str);
        boolean z2 = I1 == null || I1.getTDPIoTDevice() == null;
        l[] lVarArr = new l[3];
        lVarArr[0] = new l("loading_time", Long.valueOf(j));
        lVarArr[1] = new l("final_status", z ? "online" : ChannelStreamStatus.PlaybackStreamStatus.OFFLINE);
        lVarArr[2] = new l("connect_type", z2 ? "remote" : ImagesContract.LOCAL);
        h.g("device", "device_loading_time", str, lVarArr);
    }

    public static void b(String str, boolean z) {
        BaseALIoTDevice I1 = TPIoTClientManager.I1(str);
        boolean z2 = I1 == null || I1.getTDPIoTDevice() == null;
        l[] lVarArr = new l[2];
        lVarArr[0] = new l("final_status", z ? "online" : ChannelStreamStatus.PlaybackStreamStatus.OFFLINE);
        lVarArr[1] = new l("connect_type", z2 ? "remote" : ImagesContract.LOCAL);
        h.g("device", "device_status_change", str, lVarArr);
    }

    public static void c(String str, long j, boolean z) {
        BaseALIoTDevice I1 = TPIoTClientManager.I1(str);
        boolean z2 = I1 == null || I1.getTDPIoTDevice() == null;
        l[] lVarArr = new l[4];
        lVarArr[0] = new l("request_time", Long.valueOf(j));
        lVarArr[1] = new l("request_method", "on_off");
        lVarArr[2] = new l(ThingModelDefine.Service.OUTPUT_PARAMS_RESULT, z ? FirebaseAnalytics.Param.SUCCESS : "failed");
        lVarArr[3] = new l("connect_type", z2 ? "remote" : ImagesContract.LOCAL);
        h.g("device", "device_request_time", str, lVarArr);
    }
}
