package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;

/* compiled from: MediaLoadData.java */
/* loaded from: classes.dex */
public final class a0 {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3164b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Format f3165c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3166d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Object f3167e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3168f;
    public final long g;

    public a0(int i) {
        this(i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public a0(int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2) {
        this.a = i;
        this.f3164b = i2;
        this.f3165c = format;
        this.f3166d = i3;
        this.f3167e = obj;
        this.f3168f = j;
        this.g = j2;
    }
}
