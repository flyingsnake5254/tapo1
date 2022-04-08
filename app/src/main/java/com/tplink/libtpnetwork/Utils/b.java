package com.tplink.libtpnetwork.Utils;

import android.content.Context;
import b.d.w.h.a;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESEncryptor.java */
/* loaded from: classes3.dex */
public class b {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14069b = "0123456789ABCDEF";

    public b(String str) {
        this.a = null;
        this.a = str;
    }

    private void a(StringBuffer stringBuffer, byte b2) {
        stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b2 & BinaryMemcacheOpcodes.PREPEND));
    }

    public byte[] b(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    public String c(String str, Context context) throws Exception {
        String str2 = this.a;
        return str2 != null ? d(str, context, str2) : str;
    }

    public String d(String str, Context context, String str2) throws Exception {
        return new String(b(a.f(str2.getBytes("utf-8")), h(str)));
    }

    public byte[] e(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    public String f(String str, Context context) throws Exception {
        String str2 = this.a;
        return str2 != null ? g(str, context, str2) : str;
    }

    public String g(String str, Context context, String str2) throws Exception {
        return i(e(a.f(str2.getBytes("utf-8")), str.getBytes()));
    }

    public byte[] h(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public String i(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            a(stringBuffer, b2);
        }
        return stringBuffer.toString();
    }
}
