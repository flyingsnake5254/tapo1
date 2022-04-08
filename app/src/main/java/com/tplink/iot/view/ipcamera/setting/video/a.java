package com.tplink.iot.view.ipcamera.setting.video;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.j;

/* compiled from: VideoQualityActivity.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final void a(Context context, String deviceIdMD5) {
        j.e(context, "context");
        j.e(deviceIdMD5, "deviceIdMD5");
        context.startActivity(new Intent(context, VideoQualityActivity.class).putExtra("device_id_md5", deviceIdMD5));
    }
}
