package com.tplink.libmediakit.media.audioprocess;

import java.nio.ByteBuffer;

/* compiled from: AudioFrame.java */
/* loaded from: classes3.dex */
public class a implements d {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f11929b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11930c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f11931d;

    /* renamed from: e  reason: collision with root package name */
    public ByteBuffer f11932e;

    /* renamed from: f  reason: collision with root package name */
    private int f11933f;
    private int g;
    private String h;

    public a() {
        this.f11933f = 8000;
        this.g = 16;
        this.a = 0L;
        this.f11929b = 0L;
        this.f11930c = true;
        this.f11931d = null;
    }

    @Override // com.tplink.libmediakit.media.audioprocess.d
    public void a(boolean z) {
        this.f11930c = z;
    }

    @Override // com.tplink.libmediakit.media.audioprocess.d
    public void b(long j) {
        this.f11929b = j;
    }

    @Override // com.tplink.libmediakit.media.audioprocess.d
    public int c() {
        return this.g;
    }

    @Override // com.tplink.libmediakit.media.audioprocess.d
    public int d() {
        return this.f11933f;
    }

    @Override // com.tplink.libmediakit.media.audioprocess.d
    public long e() {
        return this.f11929b;
    }

    @Override // com.tplink.libmediakit.media.audioprocess.d
    public ByteBuffer f() {
        if (this.f11932e == null) {
            byte[] bArr = this.f11931d;
            if (bArr == null) {
                return null;
            }
            this.f11932e = ByteBuffer.wrap(bArr);
        }
        return this.f11932e;
    }

    @Override // com.tplink.libmediakit.media.audioprocess.d
    public void g(ByteBuffer byteBuffer) {
        this.f11932e = byteBuffer;
        this.f11931d = byteBuffer.array();
    }

    @Override // com.tplink.libmediakit.media.audioprocess.d
    public void h(long j) {
        this.a = j;
    }

    @Override // com.tplink.libmediakit.media.audioprocess.d
    public long j() {
        return this.a;
    }

    /* renamed from: k */
    public a clone() {
        a aVar = new a();
        aVar.a = this.a;
        aVar.f11929b = this.f11929b;
        aVar.f11930c = this.f11930c;
        byte[] bArr = this.f11931d;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f11931d = bArr2;
        }
        aVar.g = this.g;
        aVar.f11933f = this.f11933f;
        aVar.h = this.h;
        return aVar;
    }

    /* renamed from: l */
    public a i() {
        a aVar = new a();
        aVar.a = this.a;
        aVar.f11929b = this.f11929b;
        aVar.f11930c = this.f11930c;
        aVar.g = this.g;
        aVar.f11933f = this.f11933f;
        aVar.h = this.h;
        return aVar;
    }

    public int m() {
        return n(this.f11933f, this.g);
    }

    public int n(int i, int i2) {
        return r() / p(i, i2);
    }

    public String o() {
        return this.h;
    }

    public int p(int i, int i2) {
        return (i * (i2 / 8)) / 1000;
    }

    public void q(String str) {
        this.h = str;
    }

    public int r() {
        byte[] bArr = this.f11931d;
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    public a(String str, long j, byte[] bArr) {
        this.f11933f = 8000;
        this.g = 16;
        this.h = str;
        this.a = j;
        this.f11931d = bArr;
        this.f11930c = true;
    }

    public a(String str, long j, ByteBuffer byteBuffer) {
        this.f11933f = 8000;
        this.g = 16;
        this.h = str;
        this.a = j;
        this.f11932e = byteBuffer;
        this.f11931d = byteBuffer.array();
        this.f11930c = true;
    }
}
