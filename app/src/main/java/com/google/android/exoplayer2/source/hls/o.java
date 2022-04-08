package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.drm.x;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.f;
import com.google.android.exoplayer2.source.hls.q;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.source.o0;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.y;
import com.google.common.primitives.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: HlsMediaPeriod.java */
/* loaded from: classes.dex */
public final class o implements b0, q.b, HlsPlaylistTracker.b {
    private final r H3;
    private final boolean I3;
    private final int J3;
    private final boolean K3;
    @Nullable
    private b0.a L3;
    private int M3;
    private TrackGroupArray N3;
    private int R3;
    private o0 S3;

    /* renamed from: c  reason: collision with root package name */
    private final k f3269c;

    /* renamed from: d  reason: collision with root package name */
    private final HlsPlaylistTracker f3270d;

    /* renamed from: f  reason: collision with root package name */
    private final j f3271f;
    private final f0.a p0;
    private final e p1;
    @Nullable
    private final a0 q;
    private final x x;
    private final v.a y;
    private final com.google.android.exoplayer2.upstream.x z;
    private final IdentityHashMap<n0, Integer> p2 = new IdentityHashMap<>();
    private final r p3 = new r();
    private q[] O3 = new q[0];
    private q[] P3 = new q[0];
    private int[][] Q3 = new int[0];

    public o(k kVar, HlsPlaylistTracker hlsPlaylistTracker, j jVar, @Nullable a0 a0Var, x xVar, v.a aVar, com.google.android.exoplayer2.upstream.x xVar2, f0.a aVar2, e eVar, r rVar, boolean z, int i, boolean z2) {
        this.f3269c = kVar;
        this.f3270d = hlsPlaylistTracker;
        this.f3271f = jVar;
        this.q = a0Var;
        this.x = xVar;
        this.y = aVar;
        this.z = xVar2;
        this.p0 = aVar2;
        this.p1 = eVar;
        this.H3 = rVar;
        this.I3 = z;
        this.J3 = i;
        this.K3 = z2;
        this.S3 = rVar.a(new o0[0]);
    }

    private void r(long j, List<f.a> list, List<q> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).f3296d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z = true;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (com.google.android.exoplayer2.util.o0.b(str, list.get(i2).f3296d)) {
                        f.a aVar = list.get(i2);
                        arrayList3.add(Integer.valueOf(i2));
                        arrayList.add(aVar.a);
                        arrayList2.add(aVar.f3294b);
                        z &= com.google.android.exoplayer2.util.o0.F(aVar.f3294b.p1, 1) == 1;
                    }
                }
                q w = w(1, (Uri[]) arrayList.toArray((Uri[]) com.google.android.exoplayer2.util.o0.j(new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), null, Collections.emptyList(), map, j);
                list3.add(d.j(arrayList3));
                list2.add(w);
                if (this.I3 && z) {
                    w.c0(new TrackGroup[]{new TrackGroup((Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void t(com.google.android.exoplayer2.source.hls.playlist.f r20, long r21, java.util.List<com.google.android.exoplayer2.source.hls.q> r23, java.util.List<int[]> r24, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> r25) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.o.t(com.google.android.exoplayer2.source.hls.playlist.f, long, java.util.List, java.util.List, java.util.Map):void");
    }

    private void v(long j) {
        Map<String, DrmInitData> map;
        f fVar = (f) g.e(this.f3270d.e());
        if (this.K3) {
            map = y(fVar.n);
        } else {
            map = Collections.emptyMap();
        }
        boolean z = !fVar.f3293f.isEmpty();
        List<f.a> list = fVar.h;
        List<f.a> list2 = fVar.i;
        this.M3 = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            t(fVar, j, arrayList, arrayList2, map);
        }
        r(j, list, arrayList, arrayList2, map);
        this.R3 = arrayList.size();
        for (int i = 0; i < list2.size(); i++) {
            f.a aVar = list2.get(i);
            q w = w(3, new Uri[]{aVar.a}, new Format[]{aVar.f3294b}, null, Collections.emptyList(), map, j);
            arrayList2.add(new int[]{i});
            arrayList.add(w);
            w.c0(new TrackGroup[]{new TrackGroup(aVar.f3294b)}, 0, new int[0]);
        }
        this.O3 = (q[]) arrayList.toArray(new q[0]);
        this.Q3 = (int[][]) arrayList2.toArray(new int[0]);
        q[] qVarArr = this.O3;
        this.M3 = qVarArr.length;
        qVarArr[0].l0(true);
        for (q qVar : this.O3) {
            qVar.z();
        }
        this.P3 = this.O3;
    }

    private q w(int i, Uri[] uriArr, Format[] formatArr, @Nullable Format format, @Nullable List<Format> list, Map<String, DrmInitData> map, long j) {
        return new q(i, this, new i(this.f3269c, this.f3270d, uriArr, formatArr, this.f3271f, this.q, this.p3, list), map, this.p1, j, format, this.x, this.y, this.z, this.p0, this.J3);
    }

    private static Format x(Format format, @Nullable Format format2, boolean z) {
        String str;
        int i;
        String str2;
        int i2;
        int i3;
        Metadata metadata;
        String str3;
        int i4 = -1;
        if (format2 != null) {
            str3 = format2.p1;
            metadata = format2.p2;
            int i5 = format2.U3;
            i2 = format2.q;
            int i6 = format2.x;
            String str4 = format2.f2006f;
            str = format2.f2005d;
            i = i5;
            i3 = i6;
            str2 = str4;
        } else {
            String G = com.google.android.exoplayer2.util.o0.G(format.p1, 1);
            Metadata metadata2 = format.p2;
            if (z) {
                int i7 = format.U3;
                int i8 = format.q;
                int i9 = format.x;
                str2 = format.f2006f;
                str3 = G;
                str = format.f2005d;
                i = i7;
                i2 = i8;
                metadata = metadata2;
                i3 = i9;
            } else {
                str2 = null;
                metadata = metadata2;
                i3 = 0;
                i2 = 0;
                i = -1;
                str3 = G;
                str = null;
            }
        }
        String g = y.g(str3);
        int i10 = z ? format.y : -1;
        if (z) {
            i4 = format.z;
        }
        return new Format.b().S(format.f2004c).U(str).K(format.p3).e0(g).I(str3).X(metadata).G(i10).Z(i4).H(i).g0(i2).c0(i3).V(str2).E();
    }

    private static Map<String, DrmInitData> y(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < arrayList.size()) {
            DrmInitData drmInitData = list.get(i);
            String str = drmInitData.f2204f;
            i++;
            int i2 = i;
            while (i2 < arrayList.size()) {
                DrmInitData drmInitData2 = (DrmInitData) arrayList.get(i2);
                if (TextUtils.equals(drmInitData2.f2204f, str)) {
                    drmInitData = drmInitData.f(drmInitData2);
                    arrayList.remove(i2);
                } else {
                    i2++;
                }
            }
            hashMap.put(str, drmInitData);
        }
        return hashMap;
    }

    private static Format z(Format format) {
        String G = com.google.android.exoplayer2.util.o0.G(format.p1, 2);
        return new Format.b().S(format.f2004c).U(format.f2005d).K(format.p3).e0(y.g(G)).I(G).X(format.p2).G(format.y).Z(format.z).j0(format.M3).Q(format.N3).P(format.O3).g0(format.q).c0(format.x).E();
    }

    /* renamed from: A */
    public void n(q qVar) {
        this.L3.n(this);
    }

    public void B() {
        this.f3270d.a(this);
        for (q qVar : this.O3) {
            qVar.e0();
        }
        this.L3 = null;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public long a() {
        return this.S3.a();
    }

    @Override // com.google.android.exoplayer2.source.hls.q.b
    public void b() {
        q[] qVarArr;
        int i = this.M3 - 1;
        this.M3 = i;
        if (i <= 0) {
            int i2 = 0;
            for (q qVar : this.O3) {
                i2 += qVar.s().f3161d;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i2];
            int i3 = 0;
            for (q qVar2 : this.O3) {
                int i4 = qVar2.s().f3161d;
                for (int i5 = 0; i5 < i4; i5++) {
                    i3++;
                    trackGroupArr[i3] = qVar2.s().a(i5);
                }
            }
            this.N3 = new TrackGroupArray(trackGroupArr);
            this.L3.p(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public boolean c() {
        return this.S3.c();
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public boolean d(long j) {
        if (this.N3 != null) {
            return this.S3.d(j);
        }
        for (q qVar : this.O3) {
            qVar.z();
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public long e() {
        return this.S3.e();
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public void f(long j) {
        this.S3.f(j);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void g() {
        for (q qVar : this.O3) {
            qVar.a0();
        }
        this.L3.n(this);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public boolean h(Uri uri, x.c cVar, boolean z) {
        boolean z2 = true;
        for (q qVar : this.O3) {
            z2 &= qVar.Z(uri, cVar, z);
        }
        this.L3.n(this);
        return z2;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long i(long j) {
        q[] qVarArr = this.P3;
        if (qVarArr.length > 0) {
            boolean h0 = qVarArr[0].h0(j, false);
            int i = 1;
            while (true) {
                q[] qVarArr2 = this.P3;
                if (i >= qVarArr2.length) {
                    break;
                }
                qVarArr2[i].h0(j, h0);
                i++;
            }
            if (h0) {
                this.p3.b();
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long j(long j, g2 g2Var) {
        return j;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long k() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void l(b0.a aVar, long j) {
        this.L3 = aVar;
        this.f3270d.g(this);
        v(j);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long m(com.google.android.exoplayer2.trackselection.g[] gVarArr, boolean[] zArr, n0[] n0VarArr, boolean[] zArr2, long j) {
        boolean z;
        n0[] n0VarArr2 = n0VarArr;
        int[] iArr = new int[gVarArr.length];
        int[] iArr2 = new int[gVarArr.length];
        for (int i = 0; i < gVarArr.length; i++) {
            iArr[i] = n0VarArr2[i] == null ? -1 : this.p2.get(n0VarArr2[i]).intValue();
            iArr2[i] = -1;
            if (gVarArr[i] != null) {
                TrackGroup m = gVarArr[i].m();
                int i2 = 0;
                while (true) {
                    q[] qVarArr = this.O3;
                    if (i2 >= qVarArr.length) {
                        break;
                    } else if (qVarArr[i2].s().b(m) != -1) {
                        iArr2[i] = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        this.p2.clear();
        int length = gVarArr.length;
        n0[] n0VarArr3 = new n0[length];
        n0[] n0VarArr4 = new n0[gVarArr.length];
        com.google.android.exoplayer2.trackselection.g[] gVarArr2 = new com.google.android.exoplayer2.trackselection.g[gVarArr.length];
        q[] qVarArr2 = new q[this.O3.length];
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        while (i4 < this.O3.length) {
            for (int i5 = 0; i5 < gVarArr.length; i5++) {
                com.google.android.exoplayer2.trackselection.g gVar = null;
                n0VarArr4[i5] = iArr[i5] == i4 ? n0VarArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    gVar = gVarArr[i5];
                }
                gVarArr2[i5] = gVar;
            }
            q qVar = this.O3[i4];
            boolean i0 = qVar.i0(gVarArr2, zArr, n0VarArr4, zArr2, j, z2);
            int i6 = 0;
            boolean z3 = false;
            while (true) {
                z = true;
                if (i6 >= gVarArr.length) {
                    break;
                }
                n0 n0Var = n0VarArr4[i6];
                if (iArr2[i6] == i4) {
                    g.e(n0Var);
                    n0VarArr3[i6] = n0Var;
                    this.p2.put(n0Var, Integer.valueOf(i4));
                    z3 = true;
                } else if (iArr[i6] == i4) {
                    if (n0Var != null) {
                        z = false;
                    }
                    g.g(z);
                }
                i6++;
            }
            if (z3) {
                qVarArr2[i3] = qVar;
                i3++;
                if (i3 == 0) {
                    qVar.l0(true);
                    if (!i0) {
                        q[] qVarArr3 = this.P3;
                        if (qVarArr3.length != 0 && qVar == qVarArr3[0]) {
                        }
                    }
                    this.p3.b();
                    z2 = true;
                } else {
                    if (i4 >= this.R3) {
                        z = false;
                    }
                    qVar.l0(z);
                }
            } else {
                i3 = i3;
            }
            i4++;
            qVarArr2 = qVarArr2;
            length = length;
            gVarArr2 = gVarArr2;
            n0VarArr2 = n0VarArr;
        }
        System.arraycopy(n0VarArr3, 0, n0VarArr2, 0, length);
        q[] qVarArr4 = (q[]) com.google.android.exoplayer2.util.o0.w0(qVarArr2, i3);
        this.P3 = qVarArr4;
        this.S3 = this.H3.a(qVarArr4);
        return j;
    }

    @Override // com.google.android.exoplayer2.source.hls.q.b
    public void o(Uri uri) {
        this.f3270d.f(uri);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void q() throws IOException {
        for (q qVar : this.O3) {
            qVar.q();
        }
    }

    @Override // com.google.android.exoplayer2.source.b0
    public TrackGroupArray s() {
        return (TrackGroupArray) g.e(this.N3);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void u(long j, boolean z) {
        for (q qVar : this.P3) {
            qVar.u(j, z);
        }
    }
}
