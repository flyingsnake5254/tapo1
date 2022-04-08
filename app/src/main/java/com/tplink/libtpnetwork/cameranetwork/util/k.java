package com.tplink.libtpnetwork.cameranetwork.util;

import android.util.Base64;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EncryptUtils.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class k {
    private static final char[] a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f15016b = "\n    MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4D6i0oD/Ga5qb//RfSe8MrPVI\n    rMIGecCxkcGWGj9kxxk74qQNq8XUuXoy2PczQ30BpiRHrlkbtBEPeWLpq85tfubT\n    UjhBz1NPNvWrC88uaYVGvzNpgzZOqDC35961uPTuvdUa8vztcUQjEZy16WbmetRj\n    URFIiWJgFCmemyYVbQIDAQAB\n    ";

    /* renamed from: c  reason: collision with root package name */
    private static final PublicKey f15017c;

    /* compiled from: EncryptUtils.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<PublicKey> {

        /* renamed from: c  reason: collision with root package name */
        public static final a f15018c = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final PublicKey invoke() {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(k.f15016b, 0)));
        }
    }

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        j.d(charArray, "(this as java.lang.String).toCharArray()");
        a = charArray;
        PublicKey invoke = a.f15018c.invoke();
        j.d(invoke, "{\n    val keyBytes = Bas…ublic(keySpec)\n}.invoke()");
        f15017c = invoke;
    }

    public static final String b(String cameraMD5) {
        j.e(cameraMD5, "$this$cameraMD5");
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = cameraMD5.getBytes(d.a);
            j.d(bytes, "(this as java.lang.String).getBytes(charset)");
            instance.update(bytes);
            byte[] messageDigest = instance.digest();
            j.d(messageDigest, "messageDigest");
            return j.f(messageDigest);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static final String c(String decodeUrlComponent) {
        j.e(decodeUrlComponent, "$this$decodeUrlComponent");
        String decode = URLDecoder.decode(decodeUrlComponent, "UTF-8");
        j.d(decode, "URLDecoder.decode(this, \"UTF-8\")");
        return decode;
    }

    public static final String d(String encodeUrlComponent) {
        j.e(encodeUrlComponent, "$this$encodeUrlComponent");
        String encode = URLEncoder.encode(encodeUrlComponent, "UTF-8");
        j.d(encode, "URLEncoder.encode(this, \"UTF-8\")");
        return encode;
    }

    public static final String e(String encrypt) {
        j.e(encrypt, "$this$encrypt");
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, f15017c);
        Charset charset = d.a;
        byte[] bytes = encrypt.getBytes(charset);
        j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] base64 = Base64.encode(instance.doFinal(bytes), 2);
        j.d(base64, "base64");
        return new String(base64, charset);
    }

    public static final String f(byte[] toHex) {
        j.e(toHex, "$this$toHex");
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : toHex) {
            int i = b2 & BinaryMemcacheOpcodes.PREPEND;
            char[] cArr = a;
            stringBuffer.append(cArr[(b2 & 240) >>> 4]);
            stringBuffer.append(cArr[i]);
        }
        String stringBuffer2 = stringBuffer.toString();
        j.d(stringBuffer2, "result.toString()");
        return stringBuffer2;
    }
}
