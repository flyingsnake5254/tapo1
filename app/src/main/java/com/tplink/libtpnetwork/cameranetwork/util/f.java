package com.tplink.libtpnetwork.cameranetwork.util;

import com.tplink.libtpmediastatistics.SSLClient;
import java.util.Locale;
import org.apache.commons.lang.e;

/* compiled from: NetworkUtils.java */
/* loaded from: classes3.dex */
public class f {
    public static String a(String str) {
        if (e.a(str)) {
            return "";
        }
        if (str.contains(SSLClient.COLON)) {
            return str.replaceAll(SSLClient.COLON, "").toUpperCase(Locale.getDefault());
        }
        if (str.contains("-")) {
            return str.replaceAll("-", "").toUpperCase(Locale.getDefault());
        }
        return str.toUpperCase(Locale.getDefault());
    }
}
