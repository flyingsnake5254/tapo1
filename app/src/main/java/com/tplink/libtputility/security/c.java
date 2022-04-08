package com.tplink.libtputility.security;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* compiled from: RSAEncrypter.java */
/* loaded from: classes3.dex */
public class c {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f15138b;

    /* renamed from: c  reason: collision with root package name */
    private int f15139c;

    /* renamed from: d  reason: collision with root package name */
    private PrivateKey f15140d;

    /* renamed from: e  reason: collision with root package name */
    private PublicKey f15141e;

    /* renamed from: f  reason: collision with root package name */
    private String f15142f;
    private Cipher g;
    private Cipher h;

    /* compiled from: RSAEncrypter.java */
    /* loaded from: classes3.dex */
    public static class b {
        private c a = new c();

        public c a() {
            this.a.c();
            return this.a;
        }

        public b b(PublicKey publicKey) {
            this.a.f15141e = publicKey;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        PublicKey publicKey = this.f15141e;
        if (publicKey != null) {
            this.a = ((RSAPublicKey) publicKey).getModulus().bitLength();
        } else {
            this.a = ((RSAPrivateKey) this.f15140d).getModulus().bitLength();
        }
        this.f15139c = this.a / 8;
        String str = this.f15142f;
        if (str == null || str.equals("")) {
            this.f15142f = "RSA/ECB/PKCS1Padding";
            this.f15138b = (this.a / 8) - 11;
        } else {
            String[] split = this.f15142f.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            if (split.length == 3) {
                if (split[2].equals("PKCS1Padding")) {
                    this.f15138b = (this.a / 8) - 11;
                } else if (split[2].equals("OAEPPadding") || split[2].equals("OAEPWithSHA-1AndMGF1Padding")) {
                    this.f15138b = (this.a / 8) - 42;
                } else if (split[2].equals("OAEPWithSHA-256AndMGF1Padding")) {
                    this.f15138b = (this.a / 8) - 66;
                } else if (split[2].equals("NoPadding")) {
                    this.f15138b = (this.a / 8) - 11;
                }
            }
        }
        try {
            if (this.f15141e != null) {
                Cipher instance = Cipher.getInstance(this.f15142f);
                this.g = instance;
                f(instance, 1, this.f15142f, this.f15141e);
            }
            if (this.f15140d != null) {
                if (!this.f15142f.equals("RSA/ECB/NoPadding") && !this.f15142f.equals("RSA/NONE/NoPadding")) {
                    this.h = Cipher.getInstance(this.f15142f);
                    f(this.h, 2, this.f15142f, this.f15140d);
                }
                this.h = Cipher.getInstance("RSA");
                f(this.h, 2, this.f15142f, this.f15140d);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e2) {
            b.d.w.c.a.g(e2, c.class.getSimpleName(), new Object[0]);
        }
    }

    private void f(Cipher cipher, int i, String str, Key key) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (str.equals("RSA/ECB/PKCS1Padding") || str.equals("RSA/ECB/OAEPPadding") || str.equals("RSA/ECB/NoPadding") || str.equals("RSA/NONE/PKCS1Padding") || str.equals("RSA/NONE/OAEPPadding") || str.equals("RSA/NONE/NoPadding")) {
            cipher.init(i, key);
        } else if (str.equals("RSA/ECB/OAEPWithSHA-256AndMGF1Padding") || str.equals("RSA/NONE/OAEPWithSHA-256AndMGF1Padding")) {
            cipher.init(i, key, new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        } else if (str.equals("RSA/ECB/OAEPWithSHA-1AndMGF1Padding") || str.equals("RSA/NONE/OAEPWithSHA-1AndMGF1Padding")) {
            cipher.init(i, key);
        }
    }

    public synchronized byte[] d(String str) throws Exception {
        return e(str.getBytes("UTF8"));
    }

    public synchronized byte[] e(byte[] bArr) throws Exception {
        byte[] bArr2;
        int length = bArr.length;
        if (length <= this.f15138b) {
            return this.g.doFinal(bArr);
        }
        ArrayList<Byte> arrayList = new ArrayList(2048);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i2;
            if (i3 <= 0) {
                break;
            }
            int i4 = this.f15138b;
            if (i3 > i4) {
                bArr2 = new byte[i4];
                System.arraycopy(bArr, i2, bArr2, 0, i4);
            } else {
                byte[] bArr3 = new byte[i3];
                System.arraycopy(bArr, i2, bArr3, 0, i3);
                bArr2 = bArr3;
            }
            for (byte b2 : this.g.doFinal(bArr2)) {
                arrayList.add(Byte.valueOf(b2));
            }
            i2 += this.f15138b;
        }
        byte[] bArr4 = new byte[arrayList.size()];
        for (Byte b3 : arrayList) {
            i++;
            bArr4[i] = b3.byteValue();
        }
        return bArr4;
    }

    private c() {
    }
}
