package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.o;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* compiled from: DefaultLoadControl.java */
/* loaded from: classes.dex */
public class a1 implements k1 {
    private final o a;

    /* renamed from: b  reason: collision with root package name */
    private final long f2013b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2014c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2015d;

    /* renamed from: e  reason: collision with root package name */
    private final long f2016e;

    /* renamed from: f  reason: collision with root package name */
    private final int f2017f;
    private final boolean g;
    private final long h;
    private final boolean i;
    private int j;
    private boolean k;

    public a1() {
        this(new o(true, 65536), 50000, 50000, 2500, DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT, -1, false, 0, false);
    }

    private static void a(int i, int i2, String str, String str2) {
        boolean z = i >= i2;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" cannot be less than ");
        sb.append(str2);
        g.b(z, sb.toString());
    }

    private static int k(int i) {
        if (i == 0) {
            return 144310272;
        }
        if (i == 1) {
            return 13107200;
        }
        if (i == 2) {
            return 131072000;
        }
        if (i == 3 || i == 5 || i == 6) {
            return 131072;
        }
        if (i == 7) {
            return 0;
        }
        throw new IllegalArgumentException();
    }

    private void l(boolean z) {
        int i = this.f2017f;
        if (i == -1) {
            i = 13107200;
        }
        this.j = i;
        this.k = false;
        if (z) {
            this.a.g();
        }
    }

    @Override // com.google.android.exoplayer2.k1
    public void b() {
        l(false);
    }

    @Override // com.google.android.exoplayer2.k1
    public boolean c() {
        return this.i;
    }

    @Override // com.google.android.exoplayer2.k1
    public long d() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.k1
    public void e(b2[] b2VarArr, TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.g[] gVarArr) {
        int i = this.f2017f;
        if (i == -1) {
            i = j(b2VarArr, gVarArr);
        }
        this.j = i;
        this.a.h(i);
    }

    @Override // com.google.android.exoplayer2.k1
    public boolean f(long j, float f2, boolean z, long j2) {
        long X = o0.X(j, f2);
        long j3 = z ? this.f2016e : this.f2015d;
        if (j2 != -9223372036854775807L) {
            j3 = Math.min(j2 / 2, j3);
        }
        return j3 <= 0 || X >= j3 || (!this.g && this.a.f() >= this.j);
    }

    @Override // com.google.android.exoplayer2.k1
    public void g() {
        l(true);
    }

    @Override // com.google.android.exoplayer2.k1
    public e getAllocator() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.k1
    public void h() {
        l(true);
    }

    @Override // com.google.android.exoplayer2.k1
    public boolean i(long j, long j2, float f2) {
        boolean z = true;
        boolean z2 = this.a.f() >= this.j;
        long j3 = this.f2013b;
        if (f2 > 1.0f) {
            j3 = Math.min(o0.S(j3, f2), this.f2014c);
        }
        if (j2 < Math.max(j3, 500000L)) {
            if (!this.g && z2) {
                z = false;
            }
            this.k = z;
            if (!z && j2 < 500000) {
                u.h("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.f2014c || z2) {
            this.k = false;
        }
        return this.k;
    }

    protected int j(b2[] b2VarArr, com.google.android.exoplayer2.trackselection.g[] gVarArr) {
        int i = 0;
        for (int i2 = 0; i2 < b2VarArr.length; i2++) {
            if (gVarArr[i2] != null) {
                i += k(b2VarArr[i2].f());
            }
        }
        return Math.max(13107200, i);
    }

    protected a1(o oVar, int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        a(i3, 0, "bufferForPlaybackMs", "0");
        a(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(i, i3, "minBufferMs", "bufferForPlaybackMs");
        a(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(i2, i, "maxBufferMs", "minBufferMs");
        a(i6, 0, "backBufferDurationMs", "0");
        this.a = oVar;
        this.f2013b = w0.d(i);
        this.f2014c = w0.d(i2);
        this.f2015d = w0.d(i3);
        this.f2016e = w0.d(i4);
        this.f2017f = i5;
        this.j = i5 == -1 ? 13107200 : i5;
        this.g = z;
        this.h = w0.d(i6);
        this.i = z2;
    }
}
