package com.tplink.libtputility.security;

import android.util.Base64;
import b.d.w.h.b;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESEncrypter.java */
/* loaded from: classes3.dex */
public class a {
    private final Object a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f15131b;

    /* renamed from: c  reason: collision with root package name */
    private Cipher f15132c;

    /* renamed from: d  reason: collision with root package name */
    private Cipher f15133d;

    /* renamed from: e  reason: collision with root package name */
    private SecretKey f15134e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f15135f;

    public a() {
        this(null, new SecureRandom().generateSeed(16), "AES/CBC/PKCS7Padding");
    }

    public String a(String str) throws Exception {
        byte[] doFinal;
        if (b.d(str)) {
            return "";
        }
        synchronized (this.f15131b) {
            doFinal = this.f15133d.doFinal(Base64.decode(str.getBytes("utf-8"), 0));
        }
        return new String(doFinal);
    }

    public byte[] b(byte[] bArr) throws Exception {
        byte[] doFinal;
        synchronized (this.f15131b) {
            doFinal = this.f15133d.doFinal(bArr);
        }
        return doFinal;
    }

    public String c(String str) throws Exception {
        byte[] doFinal;
        if (b.d(str)) {
            return "";
        }
        synchronized (this.a) {
            doFinal = this.f15132c.doFinal(str.getBytes());
        }
        return Base64.encodeToString(doFinal, 0);
    }

    public byte[] d(byte[] bArr) throws Exception {
        byte[] doFinal;
        synchronized (this.a) {
            doFinal = this.f15132c.doFinal(bArr);
        }
        return doFinal;
    }

    public SecretKey e() throws NoSuchAlgorithmException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(256);
        return instance.generateKey();
    }

    public byte[] f() {
        return this.f15134e.getEncoded();
    }

    public String g() {
        return Base64.encodeToString(this.f15135f, 0);
    }

    public String h() {
        return Base64.encodeToString(this.f15134e.getEncoded(), 0);
    }

    public void i(SecretKey secretKey) throws InvalidKeyException {
        this.f15134e = secretKey;
        this.f15132c.init(1, secretKey);
        this.f15133d.init(2, secretKey);
    }

    public a(String str) {
        this(null, null, str);
    }

    public a(String str, String str2) {
        this(Base64.decode(str, 0), Base64.decode(str2, 0));
    }

    public a(byte[] bArr, byte[] bArr2) {
        this(bArr, bArr2, "AES/CBC/PKCS7Padding");
    }

    public a(byte[] bArr, byte[] bArr2, String str) {
        this.a = new Object();
        this.f15131b = new Object();
        this.f15132c = null;
        this.f15133d = null;
        this.f15134e = null;
        this.f15135f = null;
        try {
            if (bArr == null) {
                this.f15134e = e();
            } else {
                this.f15134e = new SecretKeySpec(bArr, "AES");
            }
            this.f15132c = Cipher.getInstance(str);
            this.f15133d = Cipher.getInstance(str);
            if (bArr2 == null) {
                this.f15132c.init(1, this.f15134e);
                this.f15133d.init(2, this.f15134e);
                return;
            }
            this.f15135f = bArr2;
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            this.f15132c.init(1, this.f15134e, ivParameterSpec);
            this.f15133d.init(2, this.f15134e, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e2) {
            b.d.w.c.a.g(e2, a.class.getSimpleName(), new Object[0]);
        }
    }
}
