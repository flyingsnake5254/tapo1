package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.o0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* compiled from: DefaultExtractorInput.java */
/* loaded from: classes.dex */
public final class g implements k {

    /* renamed from: c  reason: collision with root package name */
    private final i f2692c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2693d;

    /* renamed from: e  reason: collision with root package name */
    private long f2694e;
    private int g;
    private int h;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f2695f = new byte[65536];

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f2691b = new byte[4096];

    public g(i iVar, long j, long j2) {
        this.f2692c = iVar;
        this.f2694e = j;
        this.f2693d = j2;
    }

    private void o(int i) {
        if (i != -1) {
            this.f2694e += i;
        }
    }

    private void p(int i) {
        int i2 = this.g + i;
        byte[] bArr = this.f2695f;
        if (i2 > bArr.length) {
            this.f2695f = Arrays.copyOf(this.f2695f, o0.p(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int q(byte[] bArr, int i, int i2) {
        int i3 = this.h;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.f2695f, 0, bArr, i, min);
        u(min);
        return min;
    }

    private int r(byte[] bArr, int i, int i2, int i3, boolean z) throws IOException {
        if (!Thread.interrupted()) {
            int read = this.f2692c.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    private int s(int i) {
        int min = Math.min(this.h, i);
        u(min);
        return min;
    }

    private void u(int i) {
        int i2 = this.h - i;
        this.h = i2;
        this.g = 0;
        byte[] bArr = this.f2695f;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.f2695f = bArr2;
    }

    @Override // com.google.android.exoplayer2.o2.k
    public long a() {
        return this.f2693d;
    }

    @Override // com.google.android.exoplayer2.o2.k
    public boolean c(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (!m(i2, z)) {
            return false;
        }
        System.arraycopy(this.f2695f, this.g - i2, bArr, i, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.o2.k
    public void e() {
        this.g = 0;
    }

    @Override // com.google.android.exoplayer2.o2.k
    public boolean f(byte[] bArr, int i, int i2, boolean z) throws IOException {
        int q = q(bArr, i, i2);
        while (q < i2 && q != -1) {
            q = r(bArr, i, i2, q, z);
        }
        o(q);
        return q != -1;
    }

    @Override // com.google.android.exoplayer2.o2.k
    public long g() {
        return this.f2694e + this.g;
    }

    @Override // com.google.android.exoplayer2.o2.k
    public long getPosition() {
        return this.f2694e;
    }

    @Override // com.google.android.exoplayer2.o2.k
    public void h(int i) throws IOException {
        m(i, false);
    }

    @Override // com.google.android.exoplayer2.o2.k
    public int i(int i) throws IOException {
        int s = s(i);
        if (s == 0) {
            byte[] bArr = this.f2691b;
            s = r(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        o(s);
        return s;
    }

    @Override // com.google.android.exoplayer2.o2.k
    public int k(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        p(i2);
        int i4 = this.h;
        int i5 = this.g;
        int i6 = i4 - i5;
        if (i6 == 0) {
            i3 = r(this.f2695f, i5, i2, 0, true);
            if (i3 == -1) {
                return -1;
            }
            this.h += i3;
        } else {
            i3 = Math.min(i2, i6);
        }
        System.arraycopy(this.f2695f, this.g, bArr, i, i3);
        this.g += i3;
        return i3;
    }

    @Override // com.google.android.exoplayer2.o2.k
    public void l(int i) throws IOException {
        t(i, false);
    }

    @Override // com.google.android.exoplayer2.o2.k
    public boolean m(int i, boolean z) throws IOException {
        p(i);
        int i2 = this.h - this.g;
        while (i2 < i) {
            i2 = r(this.f2695f, this.g, i, i2, z);
            if (i2 == -1) {
                return false;
            }
            this.h = this.g + i2;
        }
        this.g += i;
        return true;
    }

    @Override // com.google.android.exoplayer2.o2.k
    public void n(byte[] bArr, int i, int i2) throws IOException {
        c(bArr, i, i2, false);
    }

    @Override // com.google.android.exoplayer2.o2.k, com.google.android.exoplayer2.upstream.i
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int q = q(bArr, i, i2);
        if (q == 0) {
            q = r(bArr, i, i2, 0, true);
        }
        o(q);
        return q;
    }

    @Override // com.google.android.exoplayer2.o2.k
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        f(bArr, i, i2, false);
    }

    public boolean t(int i, boolean z) throws IOException {
        int s = s(i);
        while (s < i && s != -1) {
            s = r(this.f2691b, -s, Math.min(i, this.f2691b.length + s), s, z);
        }
        o(s);
        return s != -1;
    }
}
