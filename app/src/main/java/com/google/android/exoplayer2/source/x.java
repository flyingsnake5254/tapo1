package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.n;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: LoadEventInfo.java */
/* loaded from: classes.dex */
public final class x {
    private static final AtomicLong a = new AtomicLong();

    /* renamed from: b  reason: collision with root package name */
    public final long f3424b;

    /* renamed from: c  reason: collision with root package name */
    public final n f3425c;

    /* renamed from: d  reason: collision with root package name */
    public final Uri f3426d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, List<String>> f3427e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3428f;
    public final long g;
    public final long h;

    public x(long j, n nVar, long j2) {
        this(j, nVar, nVar.a, Collections.emptyMap(), j2, 0L, 0L);
    }

    public static long a() {
        return a.getAndIncrement();
    }

    public x(long j, n nVar, Uri uri, Map<String, List<String>> map, long j2, long j3, long j4) {
        this.f3424b = j;
        this.f3425c = nVar;
        this.f3426d = uri;
        this.f3427e = map;
        this.f3428f = j2;
        this.g = j3;
        this.h = j4;
    }
}
