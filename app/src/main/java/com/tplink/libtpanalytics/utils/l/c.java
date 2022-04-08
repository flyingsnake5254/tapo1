package com.tplink.libtpanalytics.utils.l;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5Utils.java */
/* loaded from: classes3.dex */
public class c {
    public static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static byte[] b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return c(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] c(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("报错内容", e2);
        }
    }

    public static String d(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i = b2 & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString().toLowerCase();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String e(String str) throws Exception {
        if (str == null) {
            return null;
        }
        return a(b(str));
    }
}
