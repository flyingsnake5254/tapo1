package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.j;

/* compiled from: NightVisionModeActivity.kt */
/* loaded from: classes2.dex */
public final class b5 {
    public static final void a(Context context, String deviceIdMD5) {
        j.e(context, "context");
        j.e(deviceIdMD5, "deviceIdMD5");
        context.startActivity(new Intent(context, NightVisionModeActivity.class).putExtra("device_id_md5", deviceIdMD5));
    }
}
