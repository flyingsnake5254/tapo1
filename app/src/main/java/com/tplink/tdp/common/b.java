package com.tplink.tdp.common;

import b.d.w.e.a;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.zip.CRC32;

/* compiled from: TDPPacket.java */
/* loaded from: classes3.dex */
public class b {
    private byte a;

    /* renamed from: b  reason: collision with root package name */
    private byte f15210b;

    /* renamed from: c  reason: collision with root package name */
    private short f15211c;

    /* renamed from: d  reason: collision with root package name */
    private short f15212d;

    /* renamed from: e  reason: collision with root package name */
    private byte f15213e;

    /* renamed from: f  reason: collision with root package name */
    private byte f15214f;
    private int g;
    private int h;
    protected byte[] i;

    public b(byte b2, short s, byte b3, String str) {
        byte[] bArr;
        this.i = new byte[0];
        this.a = b2;
        this.f15210b = (byte) 0;
        this.f15211c = s;
        if (str != null) {
            bArr = str.getBytes();
            this.f15212d = (short) bArr.length;
        } else {
            this.f15212d = (short) 0;
            bArr = null;
        }
        this.f15213e = b3;
        this.f15214f = (byte) 0;
        this.g = c();
        this.h = 1516993677;
        this.i = new byte[this.f15212d + 16];
        b();
        if (bArr != null) {
            System.arraycopy(bArr, 0, this.i, 16, this.f15212d);
        }
        a();
    }

    private void a() {
        CRC32 crc32 = new CRC32();
        crc32.update(this.i);
        int value = (int) crc32.getValue();
        this.h = value;
        System.arraycopy(a.c(value), 0, this.i, 12, 4);
    }

    private void b() {
        byte[] bArr = this.i;
        byte[] bArr2 = new byte[1];
        bArr2[0] = this.a;
        System.arraycopy(bArr2, 0, bArr, 0, 1);
        bArr2[0] = this.f15210b;
        System.arraycopy(bArr2, 0, bArr, 1, 1);
        System.arraycopy(a.d(this.f15211c), 0, bArr, 2, 2);
        byte[] d2 = a.d(this.f15212d);
        System.arraycopy(d2, 0, bArr, 4, 2);
        d2[0] = this.f15213e;
        System.arraycopy(d2, 0, bArr, 6, 1);
        d2[0] = this.f15214f;
        System.arraycopy(d2, 0, bArr, 7, 1);
        System.arraycopy(a.c(this.g), 0, bArr, 8, 4);
        System.arraycopy(a.c(1516993677), 0, bArr, 12, 4);
    }

    private int c() {
        return new Random().nextInt(268435456) + 0;
    }

    public static int j(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return a.g(bArr);
    }

    public static short k(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        return a.h(bArr);
    }

    public int d() {
        return this.h;
    }

    public byte[] e() {
        return this.i;
    }

    public short f() {
        return this.f15212d;
    }

    public byte g() {
        return this.f15214f;
    }

    public int h() {
        return this.g;
    }

    public byte i() {
        return this.a;
    }

    public b(ByteBuffer byteBuffer) {
        this.i = new byte[0];
        this.a = byteBuffer.get();
        this.f15210b = byteBuffer.get();
        this.f15211c = k(byteBuffer);
        this.f15212d = k(byteBuffer);
        this.f15213e = byteBuffer.get();
        this.f15214f = byteBuffer.get();
        this.g = j(byteBuffer);
        this.h = j(byteBuffer);
    }
}
