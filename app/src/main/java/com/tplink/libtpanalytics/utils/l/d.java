package com.tplink.libtpanalytics.utils.l;

import android.util.Base64;
import android.util.Log;
import b.d.c.c.c;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* compiled from: RsaEncrypter.java */
/* loaded from: classes3.dex */
public class d implements c {
    private static final String a = "d";

    /* renamed from: b  reason: collision with root package name */
    private int f12014b;

    /* renamed from: c  reason: collision with root package name */
    private int f12015c;

    /* renamed from: d  reason: collision with root package name */
    private int f12016d;

    /* renamed from: e  reason: collision with root package name */
    private PrivateKey f12017e;

    /* renamed from: f  reason: collision with root package name */
    private PublicKey f12018f;
    private String g;
    private Cipher h;
    private Cipher i;

    /* compiled from: RsaEncrypter.java */
    /* loaded from: classes3.dex */
    public static class b {
        private PublicKey a;

        /* renamed from: b  reason: collision with root package name */
        private PrivateKey f12019b;

        /* renamed from: c  reason: collision with root package name */
        private String f12020c;

        /* renamed from: d  reason: collision with root package name */
        private int f12021d;

        /* renamed from: e  reason: collision with root package name */
        private int f12022e;

        /* renamed from: f  reason: collision with root package name */
        private int f12023f;

        private int b(PrivateKey privateKey) {
            int i = 1024;
            try {
                i = ((RSAPrivateKey) privateKey).getModulus().bitLength();
                String str = d.a;
                Log.d(str, "From private keylength is:" + i);
                return i;
            } catch (Exception e2) {
                e2.printStackTrace();
                return i;
            }
        }

        private int c(PublicKey publicKey) {
            int i = 1024;
            try {
                i = ((RSAPublicKey) publicKey).getModulus().bitLength();
                String str = d.a;
                Log.d(str, "keylength is:" + i);
                return i;
            } catch (Exception e2) {
                e2.printStackTrace();
                return i;
            }
        }

        private void d(d dVar) {
            PublicKey publicKey = this.a;
            if (publicKey != null) {
                this.f12021d = c(publicKey);
            } else {
                this.f12021d = b(this.f12019b);
            }
            String str = this.f12020c;
            if (str == null || str.equals("")) {
                this.f12020c = "RSA/ECB/PKCS1Padding";
                this.f12022e = (this.f12021d / 8) - 11;
            } else {
                g(this.f12020c);
            }
            this.f12023f = this.f12021d / 8;
            dVar.f12018f = this.a;
            dVar.f12017e = this.f12019b;
            dVar.f12014b = this.f12021d;
            dVar.f12015c = this.f12022e;
            dVar.f12016d = this.f12023f;
            dVar.g = this.f12020c;
            try {
                PublicKey publicKey2 = this.a;
                if (publicKey2 != null && !publicKey2.equals("")) {
                    dVar.h = Cipher.getInstance(this.f12020c);
                    f(dVar.h, this.a);
                }
                PrivateKey privateKey = this.f12019b;
                if (privateKey != null && !privateKey.equals("")) {
                    if (!this.f12020c.equals("RSA/ECB/NoPadding") && !this.f12020c.equals("RSA/NONE/NoPadding")) {
                        dVar.i = Cipher.getInstance(this.f12020c);
                        e(dVar.i, this.f12019b);
                        return;
                    }
                    dVar.i = Cipher.getInstance("RSA");
                    e(dVar.i, this.f12019b);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        private void e(Cipher cipher, PrivateKey privateKey) throws Exception {
            if (this.f12020c.equals("RSA/ECB/PKCS1Padding") || this.f12020c.equals("RSA/ECB/OAEPPadding") || this.f12020c.equals("RSA/ECB/NoPadding") || this.f12020c.equals("RSA/NONE/PKCS1Padding") || this.f12020c.equals("RSA/NONE/OAEPPadding") || this.f12020c.equals("RSA/NONE/NoPadding")) {
                cipher.init(2, privateKey);
            } else if (this.f12020c.equals("RSA/ECB/OAEPWithSHA-256AndMGF1Padding") || this.f12020c.equals("RSA/NONE/OAEPWithSHA-256AndMGF1Padding")) {
                cipher.init(2, privateKey, new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
            } else if (this.f12020c.equals("RSA/ECB/OAEPWithSHA-1AndMGF1Padding") || this.f12020c.equals("RSA/NONE/OAEPWithSHA-1AndMGF1Padding")) {
                cipher.init(2, privateKey);
            }
        }

        private void f(Cipher cipher, PublicKey publicKey) throws Exception {
            if (this.f12020c.equals("RSA/ECB/PKCS1Padding") || this.f12020c.equals("RSA/ECB/OAEPPadding") || this.f12020c.equals("RSA/ECB/NoPadding") || this.f12020c.equals("RSA/NONE/PKCS1Padding") || this.f12020c.equals("RSA/NONE/OAEPPadding") || this.f12020c.equals("RSA/NONE/NoPadding")) {
                cipher.init(1, publicKey);
            } else if (this.f12020c.equals("RSA/ECB/OAEPWithSHA-256AndMGF1Padding") || this.f12020c.equals("RSA/NONE/OAEPWithSHA-256AndMGF1Padding")) {
                cipher.init(1, publicKey, new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
            } else if (this.f12020c.equals("RSA/ECB/OAEPWithSHA-1AndMGF1Padding") || this.f12020c.equals("RSA/NONE/OAEPWithSHA-1AndMGF1Padding")) {
                cipher.init(1, publicKey);
            }
        }

        private void g(String str) {
            String[] split = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            if (split.length != 3) {
                return;
            }
            if (split[2].equals("PKCS1Padding")) {
                this.f12022e = (this.f12021d / 8) - 11;
            } else if (split[2].equals("OAEPPadding") || split[2].equals("OAEPWithSHA-1AndMGF1Padding")) {
                this.f12022e = (this.f12021d / 8) - 42;
            } else if (split[2].equals("OAEPWithSHA-256AndMGF1Padding")) {
                this.f12022e = (this.f12021d / 8) - 66;
            } else if (split[2].equals("NoPadding")) {
                this.f12022e = (this.f12021d / 8) - 11;
            }
        }

        public d a() {
            d dVar = new d();
            d(dVar);
            return dVar;
        }

        public b h(PrivateKey privateKey) {
            this.f12019b = privateKey;
            return this;
        }

        public b i(PublicKey publicKey) {
            this.a = publicKey;
            return this;
        }
    }

    private byte[] m(byte[] bArr, Cipher cipher) throws Exception {
        return cipher.doFinal(bArr);
    }

    @Override // b.d.c.c.c
    public String a(String str) {
        try {
            return o(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public synchronized byte[] n(byte[] bArr) throws Exception {
        int length = bArr.length;
        if (length <= this.f12015c) {
            return m(bArr, this.h);
        }
        ArrayList<Byte> arrayList = new ArrayList(2048);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i2;
            if (i3 <= 0) {
                break;
            }
            int i4 = this.f12015c;
            if (i3 > i4) {
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i2, bArr2, 0, i4);
                for (byte b2 : m(bArr2, this.h)) {
                    arrayList.add(Byte.valueOf(b2));
                }
            } else {
                byte[] bArr3 = new byte[i3];
                System.arraycopy(bArr, i2, bArr3, 0, i3);
                for (byte b3 : m(bArr3, this.h)) {
                    arrayList.add(Byte.valueOf(b3));
                }
            }
            i2 += this.f12015c;
        }
        byte[] bArr4 = new byte[arrayList.size()];
        for (Byte b4 : arrayList) {
            i++;
            bArr4[i] = b4.byteValue();
        }
        return bArr4;
    }

    public synchronized String o(String str) throws Exception {
        byte[] bytes = str.getBytes("UTF8");
        int length = bytes.length;
        if (length <= this.f12015c) {
            return Base64.encodeToString(m(bytes, this.h), 2);
        }
        ArrayList<Byte> arrayList = new ArrayList(2048);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i2;
            if (i3 <= 0) {
                break;
            }
            int i4 = this.f12015c;
            if (i3 > i4) {
                byte[] bArr = new byte[i4];
                System.arraycopy(bytes, i2, bArr, 0, i4);
                for (byte b2 : m(bArr, this.h)) {
                    arrayList.add(Byte.valueOf(b2));
                }
            } else {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bytes, i2, bArr2, 0, i3);
                for (byte b3 : m(bArr2, this.h)) {
                    arrayList.add(Byte.valueOf(b3));
                }
            }
            i2 += this.f12015c;
        }
        byte[] bArr3 = new byte[arrayList.size()];
        for (Byte b4 : arrayList) {
            i++;
            bArr3[i] = b4.byteValue();
        }
        return Base64.encodeToString(bArr3, 2);
    }

    private d() {
    }
}
