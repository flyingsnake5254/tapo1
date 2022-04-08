package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.j1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: HlsMediaPlaylist.java */
/* loaded from: classes.dex */
public final class g extends h {

    /* renamed from: d  reason: collision with root package name */
    public final int f3302d;

    /* renamed from: e  reason: collision with root package name */
    public final long f3303e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3304f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public final int j;
    public final long k;
    public final int l;
    public final long m;
    public final long n;
    public final boolean o;
    public final boolean p;
    @Nullable
    public final DrmInitData q;
    public final List<d> r;
    public final List<b> s;
    public final Map<Uri, c> t;
    public final long u;
    public final f v;

    /* compiled from: HlsMediaPlaylist.java */
    /* loaded from: classes.dex */
    public static final class b extends e {
        public final boolean H3;
        public final boolean I3;

        public b(String str, @Nullable d dVar, long j, int i, long j2, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j3, long j4, boolean z, boolean z2, boolean z3) {
            super(str, dVar, j, i, j2, drmInitData, str2, str3, j3, j4, z);
            this.H3 = z2;
            this.I3 = z3;
        }

        public b b(long j, int i) {
            return new b(this.f3307c, this.f3308d, this.f3309f, i, j, this.y, this.z, this.p0, this.p1, this.p2, this.p3, this.H3, this.I3);
        }
    }

    /* compiled from: HlsMediaPlaylist.java */
    /* loaded from: classes.dex */
    public static final class c {
        public final Uri a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3305b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3306c;

        public c(Uri uri, long j, int i) {
            this.a = uri;
            this.f3305b = j;
            this.f3306c = i;
        }
    }

    /* compiled from: HlsMediaPlaylist.java */
    /* loaded from: classes.dex */
    public static class e implements Comparable<Long> {

        /* renamed from: c  reason: collision with root package name */
        public final String f3307c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final d f3308d;

        /* renamed from: f  reason: collision with root package name */
        public final long f3309f;
        @Nullable
        public final String p0;
        public final long p1;
        public final long p2;
        public final boolean p3;
        public final int q;
        public final long x;
        @Nullable
        public final DrmInitData y;
        @Nullable
        public final String z;

        /* renamed from: a */
        public int compareTo(Long l) {
            if (this.x > l.longValue()) {
                return 1;
            }
            return this.x < l.longValue() ? -1 : 0;
        }

        private e(String str, @Nullable d dVar, long j, int i, long j2, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j3, long j4, boolean z) {
            this.f3307c = str;
            this.f3308d = dVar;
            this.f3309f = j;
            this.q = i;
            this.x = j2;
            this.y = drmInitData;
            this.z = str2;
            this.p0 = str3;
            this.p1 = j3;
            this.p2 = j4;
            this.p3 = z;
        }
    }

    /* compiled from: HlsMediaPlaylist.java */
    /* loaded from: classes.dex */
    public static final class f {
        public final long a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3310b;

        /* renamed from: c  reason: collision with root package name */
        public final long f3311c;

        /* renamed from: d  reason: collision with root package name */
        public final long f3312d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f3313e;

        public f(long j, boolean z, long j2, long j3, boolean z2) {
            this.a = j;
            this.f3310b = z;
            this.f3311c = j2;
            this.f3312d = j3;
            this.f3313e = z2;
        }
    }

    public g(int i, String str, List<String> list, long j, boolean z, long j2, boolean z2, int i2, long j3, int i3, long j4, long j5, boolean z3, boolean z4, boolean z5, @Nullable DrmInitData drmInitData, List<d> list2, List<b> list3, f fVar, Map<Uri, c> map) {
        super(str, list, z3);
        this.f3302d = i;
        this.h = j2;
        this.g = z;
        this.i = z2;
        this.j = i2;
        this.k = j3;
        this.l = i3;
        this.m = j4;
        this.n = j5;
        this.o = z4;
        this.p = z5;
        this.q = drmInitData;
        this.r = ImmutableList.copyOf((Collection) list2);
        this.s = ImmutableList.copyOf((Collection) list3);
        this.t = ImmutableMap.copyOf(map);
        if (!list3.isEmpty()) {
            b bVar = (b) j1.f(list3);
            this.u = bVar.x + bVar.f3309f;
        } else if (!list2.isEmpty()) {
            d dVar = (d) j1.f(list2);
            this.u = dVar.x + dVar.f3309f;
        } else {
            this.u = 0L;
        }
        long j6 = -9223372036854775807L;
        if (j != -9223372036854775807L) {
            if (j >= 0) {
                j6 = Math.min(this.u, j);
            } else {
                j6 = Math.max(0L, this.u + j);
            }
        }
        this.f3303e = j6;
        this.f3304f = j >= 0;
        this.v = fVar;
    }

    /* renamed from: b */
    public g a(List<StreamKey> list) {
        return this;
    }

    public g c(long j, int i) {
        return new g(this.f3302d, this.a, this.f3314b, this.f3303e, this.g, j, true, i, this.k, this.l, this.m, this.n, this.f3315c, this.o, this.p, this.q, this.r, this.s, this.v, this.t);
    }

    public g d() {
        if (this.o) {
            return this;
        }
        return new g(this.f3302d, this.a, this.f3314b, this.f3303e, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.f3315c, true, this.p, this.q, this.r, this.s, this.v, this.t);
    }

    public long e() {
        return this.h + this.u;
    }

    public boolean f(@Nullable g gVar) {
        if (gVar == null) {
            return true;
        }
        long j = this.k;
        long j2 = gVar.k;
        if (j > j2) {
            return true;
        }
        if (j < j2) {
            return false;
        }
        int size = this.r.size() - gVar.r.size();
        if (size != 0) {
            return size > 0;
        }
        int size2 = this.s.size();
        int size3 = gVar.s.size();
        if (size2 <= size3) {
            return size2 == size3 && this.o && !gVar.o;
        }
        return true;
    }

    /* compiled from: HlsMediaPlaylist.java */
    /* loaded from: classes.dex */
    public static final class d extends e {
        public final String H3;
        public final List<b> I3;

        public d(String str, long j, long j2, @Nullable String str2, @Nullable String str3) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, str2, str3, j, j2, false, ImmutableList.of());
        }

        public d b(long j, int i) {
            ArrayList arrayList = new ArrayList();
            long j2 = j;
            for (int i2 = 0; i2 < this.I3.size(); i2++) {
                b bVar = this.I3.get(i2);
                arrayList.add(bVar.b(j2, i));
                j2 += bVar.f3309f;
            }
            return new d(this.f3307c, this.f3308d, this.H3, this.f3309f, i, j, this.y, this.z, this.p0, this.p1, this.p2, this.p3, arrayList);
        }

        public d(String str, @Nullable d dVar, String str2, long j, int i, long j2, @Nullable DrmInitData drmInitData, @Nullable String str3, @Nullable String str4, long j3, long j4, boolean z, List<b> list) {
            super(str, dVar, j, i, j2, drmInitData, str3, str4, j3, j4, z);
            this.H3 = str2;
            this.I3 = ImmutableList.copyOf((Collection) list);
        }
    }
}
