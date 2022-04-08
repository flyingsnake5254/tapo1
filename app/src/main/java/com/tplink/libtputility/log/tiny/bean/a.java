package com.tplink.libtputility.log.tiny.bean;

import android.util.Base64;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import b.d.w.b.b;
import com.tplink.libtputility.security.PlainEncryptKeyDelegate;
import com.tplink.libtputility.security.c;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* compiled from: LogEncryptBlockBean.java */
/* loaded from: classes3.dex */
public class a {
    private static volatile com.tplink.libtputility.security.a a = new com.tplink.libtputility.security.a("AES/ECB/PKCS7Padding");

    /* renamed from: b  reason: collision with root package name */
    private static final c f15117b = new c.b().b(PlainEncryptKeyDelegate.e()).a();

    /* renamed from: c  reason: collision with root package name */
    private String f15118c;

    /* renamed from: d  reason: collision with root package name */
    private String f15119d;

    /* renamed from: e  reason: collision with root package name */
    private int f15120e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f15121f;

    public a(String str, String str2, int i, byte[] bArr) {
        this.f15118c = str;
        this.f15119d = str2;
        this.f15120e = i;
        this.f15121f = bArr;
    }

    private static int a(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return 0;
        }
        return (bArr[3] & 255) | ((bArr[0] << 32) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[1] << BinaryMemcacheOpcodes.STAT) & 16711680) | ((bArr[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private byte[] b(byte[] bArr) throws Exception {
        if (a == null) {
            return null;
        }
        a.i(a.e());
        return a.d(bArr);
    }

    private String c(byte[] bArr) throws Exception {
        c cVar = f15117b;
        return cVar != null ? new String(Base64.encode(cVar.e(bArr), 2), "UTF-8") : "";
    }

    public static a d(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[(int) file.length()];
            byte[] bArr2 = new byte[1024];
            int i = 0;
            while (true) {
                int read = fileInputStream.read(bArr2);
                if (read != -1) {
                    System.arraycopy(bArr2, 0, bArr, i, read);
                    i += read;
                } else {
                    fileInputStream.close();
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(bArr, 0, bArr3, 0, 4);
                    int a2 = a(bArr3);
                    byte[] bArr4 = new byte[a2];
                    System.arraycopy(bArr, 4, bArr4, 0, a2);
                    String str = new String(bArr4, "UTF-8");
                    int length = (int) ((file.length() - a2) - 4);
                    byte[] bArr5 = new byte[length];
                    System.arraycopy(bArr, a2 + 4, bArr5, 0, length);
                    a aVar = new a(file.getName(), str, length, bArr5);
                    fileInputStream.close();
                    return aVar;
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[] i(int i) {
        return new byte[]{(byte) ((i >> 32) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public String e() {
        return this.f15119d;
    }

    public String f() {
        return this.f15118c;
    }

    public int g() {
        return this.f15120e;
    }

    public byte[] h() {
        return this.f15121f;
    }

    public void j(String str) {
        b.d(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str, this.f15118c));
            byte[] bytes = this.f15119d.getBytes("UTF-8");
            int length = bytes.length;
            int length2 = this.f15121f.length;
            int i = length + 4;
            byte[] bArr = new byte[i + length2];
            System.arraycopy(i(length), 0, bArr, 0, 4);
            System.arraycopy(bytes, 0, bArr, 4, length);
            System.arraycopy(this.f15121f, 0, bArr, i, length2);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }

    public a(String str) throws Exception {
        this.f15121f = b(b.d.w.h.a.d(str.getBytes("UTF-8")));
        this.f15119d = c(a.f());
        byte[] bArr = this.f15121f;
        if (bArr != null) {
            this.f15120e = bArr.length;
        }
        this.f15118c = "block_" + System.currentTimeMillis() + ".dat";
    }
}
