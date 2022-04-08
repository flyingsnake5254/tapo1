package com.tplink.libtpanalytics.utils.l;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: HmacSHA1Utils.java */
/* loaded from: classes3.dex */
public class b {
    public static String a(String str, String str2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "HmacSHA1");
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(secretKeySpec);
        return b(instance.doFinal(str.getBytes("UTF-8"))).toString().toLowerCase();
    }

    public static StringBuilder b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return sb;
    }
}
