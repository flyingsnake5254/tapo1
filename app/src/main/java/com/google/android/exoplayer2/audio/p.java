package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.v0;

/* compiled from: AudioAttributes.java */
/* loaded from: classes.dex */
public final class p {
    public static final p a = new b().a();

    /* renamed from: b  reason: collision with root package name */
    public static final v0<p> f2107b = a.a;

    /* renamed from: c  reason: collision with root package name */
    public final int f2108c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2109d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2110e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2111f;
    @Nullable
    private AudioAttributes g;

    /* compiled from: AudioAttributes.java */
    /* loaded from: classes.dex */
    public static final class b {
        private int a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f2112b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f2113c = 1;

        /* renamed from: d  reason: collision with root package name */
        private int f2114d = 1;

        public p a() {
            return new p(this.a, this.f2112b, this.f2113c, this.f2114d);
        }
    }

    @RequiresApi(21)
    public AudioAttributes a() {
        if (this.g == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f2108c).setFlags(this.f2109d).setUsage(this.f2110e);
            if (o0.a >= 29) {
                usage.setAllowedCapturePolicy(this.f2111f);
            }
            this.g = usage.build();
        }
        return this.g;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.f2108c == pVar.f2108c && this.f2109d == pVar.f2109d && this.f2110e == pVar.f2110e && this.f2111f == pVar.f2111f;
    }

    public int hashCode() {
        return ((((((527 + this.f2108c) * 31) + this.f2109d) * 31) + this.f2110e) * 31) + this.f2111f;
    }

    private p(int i, int i2, int i3, int i4) {
        this.f2108c = i;
        this.f2109d = i2;
        this.f2110e = i3;
        this.f2111f = i4;
    }
}
