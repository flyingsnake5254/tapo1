package com.tplink.iot.Utils.x0;

import com.tplink.libtpnetwork.Utils.o;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: OtherFireBaseUtils.java */
/* loaded from: classes2.dex */
public class s {
    public static void a(boolean z) {
        if (z && !o.h0().L()) {
            h.i(RtspHeaders.Values.TIME, "different_client_region", new l("isDifferent", Boolean.valueOf(z)));
            o.h0().R0();
        }
    }

    public static void b(String str) {
        h.g("other", "sunrise_sunset_dialog", str, new l[0]);
    }
}
