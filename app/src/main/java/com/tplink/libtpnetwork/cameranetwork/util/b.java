package com.tplink.libtpnetwork.cameranetwork.util;

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

/* compiled from: Aes.java */
/* loaded from: classes3.dex */
public class b {
    private Cipher a;

    /* renamed from: b  reason: collision with root package name */
    private Cipher f14996b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f14997c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Object f14998d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private SecretKey f14999e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f15000f;

    public b() {
        this.a = null;
        this.f14996b = null;
        this.f14999e = null;
        this.f15000f = null;
        try {
            this.a = Cipher.getInstance("AES/CBC/PKCS7Padding");
            this.f14996b = Cipher.getInstance("AES/CBC/PKCS7Padding");
            this.f14999e = b();
            this.f15000f = new SecureRandom().generateSeed(16);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(this.f15000f);
            this.a.init(1, this.f14999e, ivParameterSpec);
            this.f14996b.init(2, this.f14999e, ivParameterSpec);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private SecretKey b() throws Exception {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(128);
        return instance.generateKey();
    }

    public int a(byte[] bArr, byte[] bArr2, int i) throws Exception {
        int doFinal;
        synchronized (this.f14998d) {
            doFinal = this.f14996b.doFinal(bArr, 0, i, bArr2);
        }
        return doFinal;
    }

    public void c(byte[] bArr, byte[] bArr2) throws InvalidAlgorithmParameterException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        this.a.init(1, secretKeySpec, ivParameterSpec);
        this.f14996b.init(2, secretKeySpec, ivParameterSpec);
    }
}
