package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

/* compiled from: CryptoInfo.java */
/* loaded from: classes.dex */
public final class b {
    @Nullable
    public byte[] a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public byte[] f2155b;

    /* renamed from: c  reason: collision with root package name */
    public int f2156c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public int[] f2157d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public int[] f2158e;

    /* renamed from: f  reason: collision with root package name */
    public int f2159f;
    public int g;
    public int h;
    private final MediaCodec.CryptoInfo i;
    @Nullable
    private final C0074b j;

    /* compiled from: CryptoInfo.java */
    @RequiresApi(24)
    /* renamed from: com.google.android.exoplayer2.decoder.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0074b {
        private final MediaCodec.CryptoInfo a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f2160b;

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, int i2) {
            this.f2160b.set(i, i2);
            this.a.setPattern(this.f2160b);
        }

        private C0074b(MediaCodec.CryptoInfo cryptoInfo) {
            this.a = cryptoInfo;
            this.f2160b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public b() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.i = cryptoInfo;
        this.j = o0.a >= 24 ? new C0074b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.i;
    }

    public void b(int i) {
        if (i != 0) {
            if (this.f2157d == null) {
                int[] iArr = new int[1];
                this.f2157d = iArr;
                this.i.numBytesOfClearData = iArr;
            }
            int[] iArr2 = this.f2157d;
            iArr2[0] = iArr2[0] + i;
        }
    }

    public void c(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.f2159f = i;
        this.f2157d = iArr;
        this.f2158e = iArr2;
        this.f2155b = bArr;
        this.a = bArr2;
        this.f2156c = i2;
        this.g = i3;
        this.h = i4;
        MediaCodec.CryptoInfo cryptoInfo = this.i;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (o0.a >= 24) {
            ((C0074b) g.e(this.j)).b(i3, i4);
        }
    }
}
