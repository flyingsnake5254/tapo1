package com.google.android.exoplayer2.source.u0;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.g;
import java.util.List;
import java.util.Map;

/* compiled from: Chunk.java */
/* loaded from: classes.dex */
public abstract class b implements Loader.e {
    public final long a = x.a();

    /* renamed from: b  reason: collision with root package name */
    public final n f3413b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3414c;

    /* renamed from: d  reason: collision with root package name */
    public final Format f3415d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3416e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final Object f3417f;
    public final long g;
    public final long h;
    protected final z i;

    public b(l lVar, n nVar, int i, Format format, int i2, @Nullable Object obj, long j, long j2) {
        this.i = new z(lVar);
        this.f3413b = (n) g.e(nVar);
        this.f3414c = i;
        this.f3415d = format;
        this.f3416e = i2;
        this.f3417f = obj;
        this.g = j;
        this.h = j2;
    }

    public final long b() {
        return this.i.o();
    }

    public final long d() {
        return this.h - this.g;
    }

    public final Map<String, List<String>> e() {
        return this.i.q();
    }

    public final Uri f() {
        return this.i.p();
    }
}
