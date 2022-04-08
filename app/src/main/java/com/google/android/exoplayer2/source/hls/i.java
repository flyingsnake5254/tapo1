package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.g;
import com.google.android.exoplayer2.trackselection.g;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.j1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: HlsChunkSource.java */
/* loaded from: classes.dex */
class i {
    private final k a;

    /* renamed from: b  reason: collision with root package name */
    private final l f3256b;

    /* renamed from: c  reason: collision with root package name */
    private final l f3257c;

    /* renamed from: d  reason: collision with root package name */
    private final r f3258d;

    /* renamed from: e  reason: collision with root package name */
    private final Uri[] f3259e;

    /* renamed from: f  reason: collision with root package name */
    private final Format[] f3260f;
    private final HlsPlaylistTracker g;
    private final TrackGroup h;
    @Nullable
    private final List<Format> i;
    private boolean k;
    @Nullable
    private IOException m;
    @Nullable
    private Uri n;
    private boolean o;
    private g p;
    private boolean r;
    private final h j = new h(4);
    private byte[] l = o0.f3937f;
    private long q = -9223372036854775807L;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HlsChunkSource.java */
    /* loaded from: classes.dex */
    public static final class a extends com.google.android.exoplayer2.source.u0.c {
        private byte[] l;

        public a(l lVar, n nVar, Format format, int i, @Nullable Object obj, byte[] bArr) {
            super(lVar, nVar, 3, format, i, obj, bArr);
        }

        @Override // com.google.android.exoplayer2.source.u0.c
        protected void g(byte[] bArr, int i) {
            this.l = Arrays.copyOf(bArr, i);
        }

        @Nullable
        public byte[] j() {
            return this.l;
        }
    }

    /* compiled from: HlsChunkSource.java */
    /* loaded from: classes.dex */
    public static final class b {
        @Nullable
        public com.google.android.exoplayer2.source.u0.b a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3261b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public Uri f3262c;

        public b() {
            a();
        }

        public void a() {
            this.a = null;
            this.f3261b = false;
            this.f3262c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HlsChunkSource.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class c extends com.google.android.exoplayer2.source.u0.a {

        /* renamed from: e  reason: collision with root package name */
        private final List<g.e> f3263e;

        /* renamed from: f  reason: collision with root package name */
        private final long f3264f;
        private final String g;

        public c(String str, long j, List<g.e> list) {
            super(0L, list.size() - 1);
            this.g = str;
            this.f3264f = j;
            this.f3263e = list;
        }

        @Override // com.google.android.exoplayer2.source.u0.e
        public long a() {
            c();
            return this.f3264f + this.f3263e.get((int) d()).x;
        }

        @Override // com.google.android.exoplayer2.source.u0.e
        public long b() {
            c();
            g.e eVar = this.f3263e.get((int) d());
            return this.f3264f + eVar.x + eVar.f3309f;
        }
    }

    /* compiled from: HlsChunkSource.java */
    /* loaded from: classes.dex */
    private static final class d extends com.google.android.exoplayer2.trackselection.e {
        private int h;

        public d(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.h = p(trackGroup.a(iArr[0]));
        }

        @Override // com.google.android.exoplayer2.trackselection.g
        public int d() {
            return this.h;
        }

        @Override // com.google.android.exoplayer2.trackselection.g
        @Nullable
        public Object j() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.g
        public void q(long j, long j2, long j3, List<? extends com.google.android.exoplayer2.source.u0.d> list, com.google.android.exoplayer2.source.u0.e[] eVarArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (f(this.h, elapsedRealtime)) {
                for (int i = this.f3636b - 1; i >= 0; i--) {
                    if (!f(i, elapsedRealtime)) {
                        this.h = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.g
        public int t() {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HlsChunkSource.java */
    /* loaded from: classes.dex */
    public static final class e {
        public final g.e a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3265b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3266c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f3267d;

        public e(g.e eVar, long j, int i) {
            this.a = eVar;
            this.f3265b = j;
            this.f3266c = i;
            this.f3267d = (eVar instanceof g.b) && ((g.b) eVar).I3;
        }
    }

    public i(k kVar, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, j jVar, @Nullable a0 a0Var, r rVar, @Nullable List<Format> list) {
        this.a = kVar;
        this.g = hlsPlaylistTracker;
        this.f3259e = uriArr;
        this.f3260f = formatArr;
        this.f3258d = rVar;
        this.i = list;
        l a2 = jVar.a(1);
        this.f3256b = a2;
        if (a0Var != null) {
            a2.b(a0Var);
        }
        this.f3257c = jVar.a(3);
        this.h = new TrackGroup(formatArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((formatArr[i].x & 16384) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.p = new d(this.h, com.google.common.primitives.d.j(arrayList));
    }

    @Nullable
    private static Uri c(com.google.android.exoplayer2.source.hls.playlist.g gVar, @Nullable g.e eVar) {
        String str;
        if (eVar == null || (str = eVar.z) == null) {
            return null;
        }
        return n0.d(gVar.a, str);
    }

    private Pair<Long, Integer> e(@Nullable m mVar, boolean z, com.google.android.exoplayer2.source.hls.playlist.g gVar, long j, long j2) {
        List<g.b> list;
        long j3;
        int i = -1;
        if (mVar == null || z) {
            long j4 = gVar.u + j;
            if (mVar != null && !this.o) {
                j2 = mVar.g;
            }
            if (!gVar.o && j2 >= j4) {
                return new Pair<>(Long.valueOf(gVar.k + gVar.r.size()), -1);
            }
            long j5 = j2 - j;
            int i2 = 0;
            int f2 = o0.f(gVar.r, Long.valueOf(j5), true, !this.g.j() || mVar == null);
            long j6 = f2 + gVar.k;
            if (f2 >= 0) {
                g.d dVar = gVar.r.get(f2);
                if (j5 < dVar.x + dVar.f3309f) {
                    list = dVar.I3;
                } else {
                    list = gVar.s;
                }
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    }
                    g.b bVar = list.get(i2);
                    if (j5 >= bVar.x + bVar.f3309f) {
                        i2++;
                    } else if (bVar.H3) {
                        j6 += list == gVar.s ? 1L : 0L;
                        i = i2;
                    }
                }
            }
            return new Pair<>(Long.valueOf(j6), Integer.valueOf(i));
        } else if (!mVar.p()) {
            return new Pair<>(Long.valueOf(mVar.j), Integer.valueOf(mVar.p));
        } else {
            if (mVar.p == -1) {
                j3 = mVar.g();
            } else {
                j3 = mVar.j;
            }
            Long valueOf = Long.valueOf(j3);
            int i3 = mVar.p;
            if (i3 != -1) {
                i = i3 + 1;
            }
            return new Pair<>(valueOf, Integer.valueOf(i));
        }
    }

    @Nullable
    private static e f(com.google.android.exoplayer2.source.hls.playlist.g gVar, long j, int i) {
        int i2 = (int) (j - gVar.k);
        if (i2 == gVar.r.size()) {
            if (i == -1) {
                i = 0;
            }
            if (i < gVar.s.size()) {
                return new e(gVar.s.get(i), j, i);
            }
            return null;
        }
        g.d dVar = gVar.r.get(i2);
        if (i == -1) {
            return new e(dVar, j, -1);
        }
        if (i < dVar.I3.size()) {
            return new e(dVar.I3.get(i), j, i);
        }
        int i3 = i2 + 1;
        if (i3 < gVar.r.size()) {
            return new e(gVar.r.get(i3), j + 1, -1);
        }
        if (!gVar.s.isEmpty()) {
            return new e(gVar.s.get(0), j + 1, 0);
        }
        return null;
    }

    @VisibleForTesting
    static List<g.e> h(com.google.android.exoplayer2.source.hls.playlist.g gVar, long j, int i) {
        int i2 = (int) (j - gVar.k);
        if (i2 < 0 || gVar.r.size() < i2) {
            return ImmutableList.of();
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (i2 < gVar.r.size()) {
            if (i != -1) {
                g.d dVar = gVar.r.get(i2);
                if (i == 0) {
                    arrayList.add(dVar);
                } else if (i < dVar.I3.size()) {
                    List<g.b> list = dVar.I3;
                    arrayList.addAll(list.subList(i, list.size()));
                }
                i2++;
            }
            List<g.d> list2 = gVar.r;
            arrayList.addAll(list2.subList(i2, list2.size()));
            i = 0;
        }
        if (gVar.n != -9223372036854775807L) {
            if (i != -1) {
                i3 = i;
            }
            if (i3 < gVar.s.size()) {
                List<g.b> list3 = gVar.s;
                arrayList.addAll(list3.subList(i3, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    private com.google.android.exoplayer2.source.u0.b k(@Nullable Uri uri, int i) {
        if (uri == null) {
            return null;
        }
        byte[] c2 = this.j.c(uri);
        if (c2 != null) {
            this.j.b(uri, c2);
            return null;
        }
        return new a(this.f3257c, new n.b().i(uri).b(1).a(), this.f3260f[i], this.p.t(), this.p.j(), this.l);
    }

    private long r(long j) {
        long j2 = this.q;
        if (j2 != -9223372036854775807L) {
            return j2 - j;
        }
        return -9223372036854775807L;
    }

    private void v(com.google.android.exoplayer2.source.hls.playlist.g gVar) {
        this.q = gVar.o ? -9223372036854775807L : gVar.e() - this.g.d();
    }

    public com.google.android.exoplayer2.source.u0.e[] a(@Nullable m mVar, long j) {
        int i;
        int b2 = mVar == null ? -1 : this.h.b(mVar.f3415d);
        int length = this.p.length();
        com.google.android.exoplayer2.source.u0.e[] eVarArr = new com.google.android.exoplayer2.source.u0.e[length];
        boolean z = false;
        int i2 = 0;
        while (i2 < length) {
            int h = this.p.h(i2);
            Uri uri = this.f3259e[h];
            if (!this.g.i(uri)) {
                eVarArr[i2] = com.google.android.exoplayer2.source.u0.e.a;
                i = i2;
            } else {
                com.google.android.exoplayer2.source.hls.playlist.g o = this.g.o(uri, z);
                com.google.android.exoplayer2.util.g.e(o);
                long d2 = o.h - this.g.d();
                i = i2;
                Pair<Long, Integer> e2 = e(mVar, h != b2, o, d2, j);
                eVarArr[i] = new c(o.a, d2, h(o, ((Long) e2.first).longValue(), ((Integer) e2.second).intValue()));
            }
            i2 = i + 1;
            z = false;
        }
        return eVarArr;
    }

    public int b(m mVar) {
        List<g.b> list;
        if (mVar.p == -1) {
            return 1;
        }
        com.google.android.exoplayer2.source.hls.playlist.g gVar = (com.google.android.exoplayer2.source.hls.playlist.g) com.google.android.exoplayer2.util.g.e(this.g.o(this.f3259e[this.h.b(mVar.f3415d)], false));
        int i = (int) (mVar.j - gVar.k);
        if (i < 0) {
            return 1;
        }
        if (i < gVar.r.size()) {
            list = gVar.r.get(i).I3;
        } else {
            list = gVar.s;
        }
        if (mVar.p >= list.size()) {
            return 2;
        }
        g.b bVar = list.get(mVar.p);
        if (bVar.I3) {
            return 0;
        }
        return o0.b(Uri.parse(n0.c(gVar.a, bVar.f3307c)), mVar.f3413b.a) ? 1 : 2;
    }

    public void d(long j, long j2, List<m> list, boolean z, b bVar) {
        long j3;
        Uri uri;
        com.google.android.exoplayer2.source.hls.playlist.g gVar;
        int i;
        m mVar = list.isEmpty() ? null : (m) j1.f(list);
        int b2 = mVar == null ? -1 : this.h.b(mVar.f3415d);
        long j4 = j2 - j;
        long r = r(j);
        if (mVar != null && !this.o) {
            long d2 = mVar.d();
            j4 = Math.max(0L, j4 - d2);
            if (r != -9223372036854775807L) {
                r = Math.max(0L, r - d2);
            }
        }
        this.p.q(j, j4, r, list, a(mVar, j2));
        int r2 = this.p.r();
        boolean z2 = b2 != r2;
        Uri uri2 = this.f3259e[r2];
        if (!this.g.i(uri2)) {
            bVar.f3262c = uri2;
            this.r &= uri2.equals(this.n);
            this.n = uri2;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.g o = this.g.o(uri2, true);
        com.google.android.exoplayer2.util.g.e(o);
        this.o = o.f3315c;
        v(o);
        long d3 = o.h - this.g.d();
        Pair<Long, Integer> e2 = e(mVar, z2, o, d3, j2);
        long longValue = ((Long) e2.first).longValue();
        int intValue = ((Integer) e2.second).intValue();
        if (longValue >= o.k || mVar == null || !z2) {
            gVar = o;
            j3 = d3;
            uri = uri2;
            i = r2;
        } else {
            Uri uri3 = this.f3259e[b2];
            com.google.android.exoplayer2.source.hls.playlist.g o2 = this.g.o(uri3, true);
            com.google.android.exoplayer2.util.g.e(o2);
            j3 = o2.h - this.g.d();
            Pair<Long, Integer> e3 = e(mVar, false, o2, j3, j2);
            longValue = ((Long) e3.first).longValue();
            intValue = ((Integer) e3.second).intValue();
            i = b2;
            uri = uri3;
            gVar = o2;
        }
        if (longValue < gVar.k) {
            this.m = new BehindLiveWindowException();
            return;
        }
        e f2 = f(gVar, longValue, intValue);
        if (f2 == null) {
            if (!gVar.o) {
                bVar.f3262c = uri;
                this.r &= uri.equals(this.n);
                this.n = uri;
                return;
            } else if (z || gVar.r.isEmpty()) {
                bVar.f3261b = true;
                return;
            } else {
                f2 = new e((g.e) j1.f(gVar.r), (gVar.k + gVar.r.size()) - 1, -1);
            }
        }
        this.r = false;
        this.n = null;
        Uri c2 = c(gVar, f2.a.f3308d);
        com.google.android.exoplayer2.source.u0.b k = k(c2, i);
        bVar.a = k;
        if (k == null) {
            Uri c3 = c(gVar, f2.a);
            com.google.android.exoplayer2.source.u0.b k2 = k(c3, i);
            bVar.a = k2;
            if (k2 == null) {
                boolean w = m.w(mVar, uri, gVar, f2, j3);
                if (!w || !f2.f3267d) {
                    bVar.a = m.i(this.a, this.f3256b, this.f3260f[i], j3, gVar, f2, uri, this.i, this.p.t(), this.p.j(), this.k, this.f3258d, mVar, this.j.a(c3), this.j.a(c2), w);
                }
            }
        }
    }

    public int g(long j, List<? extends com.google.android.exoplayer2.source.u0.d> list) {
        if (this.m != null || this.p.length() < 2) {
            return list.size();
        }
        return this.p.o(j, list);
    }

    public TrackGroup i() {
        return this.h;
    }

    public com.google.android.exoplayer2.trackselection.g j() {
        return this.p;
    }

    public boolean l(com.google.android.exoplayer2.source.u0.b bVar, long j) {
        com.google.android.exoplayer2.trackselection.g gVar = this.p;
        return gVar.e(gVar.l(this.h.b(bVar.f3415d)), j);
    }

    public void m() throws IOException {
        IOException iOException = this.m;
        if (iOException == null) {
            Uri uri = this.n;
            if (uri != null && this.r) {
                this.g.c(uri);
                return;
            }
            return;
        }
        throw iOException;
    }

    public boolean n(Uri uri) {
        return o0.r(this.f3259e, uri);
    }

    public void o(com.google.android.exoplayer2.source.u0.b bVar) {
        if (bVar instanceof a) {
            a aVar = (a) bVar;
            this.l = aVar.h();
            this.j.b(aVar.f3413b.a, (byte[]) com.google.android.exoplayer2.util.g.e(aVar.j()));
        }
    }

    public boolean p(Uri uri, long j) {
        int l;
        int i = 0;
        while (true) {
            Uri[] uriArr = this.f3259e;
            if (i >= uriArr.length) {
                i = -1;
                break;
            } else if (uriArr[i].equals(uri)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1 || (l = this.p.l(i)) == -1) {
            return true;
        }
        this.r |= uri.equals(this.n);
        return j == -9223372036854775807L || (this.p.e(l, j) && this.g.k(uri, j));
    }

    public void q() {
        this.m = null;
    }

    public void s(boolean z) {
        this.k = z;
    }

    public void t(com.google.android.exoplayer2.trackselection.g gVar) {
        this.p = gVar;
    }

    public boolean u(long j, com.google.android.exoplayer2.source.u0.b bVar, List<? extends com.google.android.exoplayer2.source.u0.d> list) {
        if (this.m != null) {
            return false;
        }
        return this.p.g(j, bVar, list);
    }
}
