package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.source.hls.j;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.hls.playlist.f;
import com.google.android.exoplayer2.source.hls.playlist.g;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.upstream.y;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.j1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DefaultHlsPlaylistTracker.java */
/* loaded from: classes.dex */
public final class d implements HlsPlaylistTracker, Loader.b<y<h>> {

    /* renamed from: c  reason: collision with root package name */
    public static final HlsPlaylistTracker.a f3283c = b.a;
    @Nullable
    private f H3;
    @Nullable
    private Uri I3;
    @Nullable
    private g J3;
    private boolean K3;
    private long L3;

    /* renamed from: d  reason: collision with root package name */
    private final j f3284d;

    /* renamed from: f  reason: collision with root package name */
    private final i f3285f;
    @Nullable
    private f0.a p0;
    @Nullable
    private Loader p1;
    @Nullable
    private Handler p2;
    @Nullable
    private HlsPlaylistTracker.c p3;
    private final x q;
    private final HashMap<Uri, c> x;
    private final CopyOnWriteArrayList<HlsPlaylistTracker.b> y;
    private final double z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultHlsPlaylistTracker.java */
    /* loaded from: classes.dex */
    public class b implements HlsPlaylistTracker.b {
        private b() {
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
        public void g() {
            d.this.y.remove(this);
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
        public boolean h(Uri uri, x.c cVar, boolean z) {
            c cVar2;
            if (d.this.J3 == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                List<f.b> list = ((f) o0.i(d.this.H3)).f3293f;
                int i = 0;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    c cVar3 = (c) d.this.x.get(list.get(i2).a);
                    if (cVar3 != null && elapsedRealtime < cVar3.p0) {
                        i++;
                    }
                }
                x.b c2 = d.this.q.c(new x.a(1, 0, d.this.H3.f3293f.size(), i), cVar);
                if (!(c2 == null || c2.a != 2 || (cVar2 = (c) d.this.x.get(uri)) == null)) {
                    cVar2.i(c2.f3868b);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultHlsPlaylistTracker.java */
    /* loaded from: classes.dex */
    public final class c implements Loader.b<y<h>> {

        /* renamed from: c  reason: collision with root package name */
        private final Uri f3287c;

        /* renamed from: d  reason: collision with root package name */
        private final Loader f3288d = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: f  reason: collision with root package name */
        private final l f3289f;
        private long p0;
        private boolean p1;
        @Nullable
        private IOException p2;
        @Nullable
        private g q;
        private long x;
        private long y;
        private long z;

        public c(Uri uri) {
            this.f3287c = uri;
            this.f3289f = d.this.f3284d.a(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean i(long j) {
            this.p0 = SystemClock.elapsedRealtime() + j;
            return this.f3287c.equals(d.this.I3) && !d.this.L();
        }

        private Uri j() {
            g gVar = this.q;
            if (gVar != null) {
                g.f fVar = gVar.v;
                if (fVar.a != -9223372036854775807L || fVar.f3313e) {
                    Uri.Builder buildUpon = this.f3287c.buildUpon();
                    g gVar2 = this.q;
                    if (gVar2.v.f3313e) {
                        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(gVar2.k + gVar2.r.size()));
                        g gVar3 = this.q;
                        if (gVar3.n != -9223372036854775807L) {
                            List<g.b> list = gVar3.s;
                            int size = list.size();
                            if (!list.isEmpty() && ((g.b) j1.f(list)).I3) {
                                size--;
                            }
                            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    g.f fVar2 = this.q.v;
                    if (fVar2.a != -9223372036854775807L) {
                        buildUpon.appendQueryParameter("_HLS_skip", fVar2.f3310b ? "v2" : "YES");
                    }
                    return buildUpon.build();
                }
            }
            return this.f3287c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: m */
        public /* synthetic */ void o(Uri uri) {
            this.p1 = false;
            q(uri);
        }

        private void q(Uri uri) {
            y yVar = new y(this.f3289f, uri, 4, d.this.f3285f.a(d.this.H3, this.q));
            d.this.p0.z(new com.google.android.exoplayer2.source.x(yVar.a, yVar.f3872b, this.f3288d.n(yVar, this, d.this.q.b(yVar.f3873c))), yVar.f3873c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(final Uri uri) {
            this.p0 = 0L;
            if (!this.p1 && !this.f3288d.i() && !this.f3288d.h()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.z) {
                    this.p1 = true;
                    d.this.p2.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.source.hls.playlist.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.c.this.o(uri);
                        }
                    }, this.z - elapsedRealtime);
                    return;
                }
                q(uri);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(g gVar, com.google.android.exoplayer2.source.x xVar) {
            boolean z;
            g gVar2 = this.q;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.x = elapsedRealtime;
            g G = d.this.G(gVar2, gVar);
            this.q = G;
            boolean z2 = false;
            IOException iOException = null;
            if (G != gVar2) {
                this.p2 = null;
                this.y = elapsedRealtime;
                d.this.R(this.f3287c, G);
            } else if (!G.o) {
                g gVar3 = this.q;
                if (gVar.k + gVar.r.size() < gVar3.k) {
                    iOException = new HlsPlaylistTracker.PlaylistResetException(this.f3287c);
                    z = true;
                } else {
                    if (elapsedRealtime - this.y > w0.e(gVar3.m) * d.this.z) {
                        iOException = new HlsPlaylistTracker.PlaylistStuckException(this.f3287c);
                    }
                    z = false;
                }
                if (iOException != null) {
                    this.p2 = iOException;
                    d.this.N(this.f3287c, new x.c(xVar, new a0(4), iOException, 1), z);
                }
            }
            long j = 0;
            g gVar4 = this.q;
            if (!gVar4.v.f3313e) {
                if (gVar4 != gVar2) {
                    j = gVar4.m;
                } else {
                    j = gVar4.m / 2;
                }
            }
            this.z = elapsedRealtime + w0.e(j);
            if (this.q.n != -9223372036854775807L || this.f3287c.equals(d.this.I3)) {
                z2 = true;
            }
            if (z2 && !this.q.o) {
                r(j());
            }
        }

        @Nullable
        public g k() {
            return this.q;
        }

        public boolean l() {
            int i;
            if (this.q == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000L, w0.e(this.q.u));
            g gVar = this.q;
            return gVar.o || (i = gVar.f3302d) == 2 || i == 1 || this.x + max > elapsedRealtime;
        }

        public void p() {
            r(this.f3287c);
        }

        public void s() throws IOException {
            this.f3288d.j();
            IOException iOException = this.p2;
            if (iOException != null) {
                throw iOException;
            }
        }

        /* renamed from: t */
        public void b(y<h> yVar, long j, long j2, boolean z) {
            com.google.android.exoplayer2.source.x xVar = new com.google.android.exoplayer2.source.x(yVar.a, yVar.f3872b, yVar.f(), yVar.d(), j, j2, yVar.b());
            d.this.q.d(yVar.a);
            d.this.p0.q(xVar, 4);
        }

        /* renamed from: u */
        public void h(y<h> yVar, long j, long j2) {
            h e2 = yVar.e();
            com.google.android.exoplayer2.source.x xVar = new com.google.android.exoplayer2.source.x(yVar.a, yVar.f3872b, yVar.f(), yVar.d(), j, j2, yVar.b());
            if (e2 instanceof g) {
                w((g) e2, xVar);
                d.this.p0.t(xVar, 4);
            } else {
                this.p2 = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", null);
                d.this.p0.x(xVar, 4, this.p2, true);
            }
            d.this.q.d(yVar.a);
        }

        /* renamed from: v */
        public Loader.c n(y<h> yVar, long j, long j2, IOException iOException, int i) {
            Loader.c cVar;
            com.google.android.exoplayer2.source.x xVar = new com.google.android.exoplayer2.source.x(yVar.a, yVar.f3872b, yVar.f(), yVar.d(), j, j2, yVar.b());
            boolean z = iOException instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((yVar.f().getQueryParameter("_HLS_msn") != null) || z) {
                int i2 = Integer.MAX_VALUE;
                if (iOException instanceof HttpDataSource.InvalidResponseCodeException) {
                    i2 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
                }
                if (z || i2 == 400 || i2 == 503) {
                    this.z = SystemClock.elapsedRealtime();
                    p();
                    ((f0.a) o0.i(d.this.p0)).x(xVar, yVar.f3873c, iOException, true);
                    return Loader.f3801c;
                }
            }
            x.c cVar2 = new x.c(xVar, new a0(yVar.f3873c), iOException, i);
            if (d.this.N(this.f3287c, cVar2, false)) {
                long a = d.this.q.a(cVar2);
                if (a != -9223372036854775807L) {
                    cVar = Loader.g(false, a);
                } else {
                    cVar = Loader.f3802d;
                }
            } else {
                cVar = Loader.f3801c;
            }
            boolean c2 = true ^ cVar.c();
            d.this.p0.x(xVar, yVar.f3873c, iOException, c2);
            if (c2) {
                d.this.q.d(yVar.a);
            }
            return cVar;
        }

        public void x() {
            this.f3288d.l();
        }
    }

    public d(j jVar, x xVar, i iVar) {
        this(jVar, xVar, iVar, 3.5d);
    }

    private void E(List<Uri> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Uri uri = list.get(i);
            this.x.put(uri, new c(uri));
        }
    }

    private static g.d F(g gVar, g gVar2) {
        int i = (int) (gVar2.k - gVar.k);
        List<g.d> list = gVar.r;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g G(@Nullable g gVar, g gVar2) {
        if (!gVar2.f(gVar)) {
            return gVar2.o ? gVar.d() : gVar;
        }
        return gVar2.c(I(gVar, gVar2), H(gVar, gVar2));
    }

    private int H(@Nullable g gVar, g gVar2) {
        g.d F;
        if (gVar2.i) {
            return gVar2.j;
        }
        g gVar3 = this.J3;
        int i = gVar3 != null ? gVar3.j : 0;
        return (gVar == null || (F = F(gVar, gVar2)) == null) ? i : (gVar.j + F.q) - gVar2.r.get(0).q;
    }

    private long I(@Nullable g gVar, g gVar2) {
        if (gVar2.p) {
            return gVar2.h;
        }
        g gVar3 = this.J3;
        long j = gVar3 != null ? gVar3.h : 0L;
        if (gVar == null) {
            return j;
        }
        int size = gVar.r.size();
        g.d F = F(gVar, gVar2);
        if (F != null) {
            return gVar.h + F.x;
        }
        return ((long) size) == gVar2.k - gVar.k ? gVar.e() : j;
    }

    private Uri J(Uri uri) {
        g.c cVar;
        g gVar = this.J3;
        if (gVar == null || !gVar.v.f3313e || (cVar = gVar.t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(cVar.f3305b));
        int i = cVar.f3306c;
        if (i != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i));
        }
        return buildUpon.build();
    }

    private boolean K(Uri uri) {
        List<f.b> list = this.H3.f3293f;
        for (int i = 0; i < list.size(); i++) {
            if (uri.equals(list.get(i).a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        List<f.b> list = this.H3.f3293f;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            c cVar = (c) com.google.android.exoplayer2.util.g.e(this.x.get(list.get(i).a));
            if (elapsedRealtime > cVar.p0) {
                Uri uri = cVar.f3287c;
                this.I3 = uri;
                cVar.r(J(uri));
                return true;
            }
        }
        return false;
    }

    private void M(Uri uri) {
        if (!uri.equals(this.I3) && K(uri)) {
            g gVar = this.J3;
            if (gVar == null || !gVar.o) {
                this.I3 = uri;
                c cVar = this.x.get(uri);
                g gVar2 = cVar.q;
                if (gVar2 == null || !gVar2.o) {
                    cVar.r(J(uri));
                    return;
                }
                this.J3 = gVar2;
                this.p3.c(gVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N(Uri uri, x.c cVar, boolean z) {
        Iterator<HlsPlaylistTracker.b> it = this.y.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= !it.next().h(uri, cVar, z);
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Uri uri, g gVar) {
        if (uri.equals(this.I3)) {
            if (this.J3 == null) {
                this.K3 = !gVar.o;
                this.L3 = gVar.h;
            }
            this.J3 = gVar;
            this.p3.c(gVar);
        }
        Iterator<HlsPlaylistTracker.b> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    /* renamed from: O */
    public void b(y<h> yVar, long j, long j2, boolean z) {
        com.google.android.exoplayer2.source.x xVar = new com.google.android.exoplayer2.source.x(yVar.a, yVar.f3872b, yVar.f(), yVar.d(), j, j2, yVar.b());
        this.q.d(yVar.a);
        this.p0.q(xVar, 4);
    }

    /* renamed from: P */
    public void h(y<h> yVar, long j, long j2) {
        f fVar;
        h e2 = yVar.e();
        boolean z = e2 instanceof g;
        if (z) {
            fVar = f.e(e2.a);
        } else {
            fVar = (f) e2;
        }
        this.H3 = fVar;
        this.I3 = fVar.f3293f.get(0).a;
        this.y.add(new b());
        E(fVar.f3292e);
        com.google.android.exoplayer2.source.x xVar = new com.google.android.exoplayer2.source.x(yVar.a, yVar.f3872b, yVar.f(), yVar.d(), j, j2, yVar.b());
        c cVar = this.x.get(this.I3);
        if (z) {
            cVar.w((g) e2, xVar);
        } else {
            cVar.p();
        }
        this.q.d(yVar.a);
        this.p0.t(xVar, 4);
    }

    /* renamed from: Q */
    public Loader.c n(y<h> yVar, long j, long j2, IOException iOException, int i) {
        com.google.android.exoplayer2.source.x xVar = new com.google.android.exoplayer2.source.x(yVar.a, yVar.f3872b, yVar.f(), yVar.d(), j, j2, yVar.b());
        long a2 = this.q.a(new x.c(xVar, new a0(yVar.f3873c), iOException, i));
        boolean z = a2 == -9223372036854775807L;
        this.p0.x(xVar, yVar.f3873c, iOException, z);
        if (z) {
            this.q.d(yVar.a);
        }
        if (z) {
            return Loader.f3802d;
        }
        return Loader.g(false, a2);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void a(HlsPlaylistTracker.b bVar) {
        this.y.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void c(Uri uri) throws IOException {
        this.x.get(uri).s();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long d() {
        return this.L3;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public f e() {
        return this.H3;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void f(Uri uri) {
        this.x.get(uri).p();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void g(HlsPlaylistTracker.b bVar) {
        com.google.android.exoplayer2.util.g.e(bVar);
        this.y.add(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean i(Uri uri) {
        return this.x.get(uri).l();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean j() {
        return this.K3;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean k(Uri uri, long j) {
        c cVar = this.x.get(uri);
        if (cVar != null) {
            return !cVar.i(j);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void l(Uri uri, f0.a aVar, HlsPlaylistTracker.c cVar) {
        this.p2 = o0.v();
        this.p0 = aVar;
        this.p3 = cVar;
        y yVar = new y(this.f3284d.a(4), uri, 4, this.f3285f.b());
        com.google.android.exoplayer2.util.g.g(this.p1 == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.p1 = loader;
        aVar.z(new com.google.android.exoplayer2.source.x(yVar.a, yVar.f3872b, loader.n(yVar, this, this.q.b(yVar.f3873c))), yVar.f3873c);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void m() throws IOException {
        Loader loader = this.p1;
        if (loader != null) {
            loader.j();
        }
        Uri uri = this.I3;
        if (uri != null) {
            c(uri);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public g o(Uri uri, boolean z) {
        g k = this.x.get(uri).k();
        if (k != null && z) {
            M(uri);
        }
        return k;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.I3 = null;
        this.J3 = null;
        this.H3 = null;
        this.L3 = -9223372036854775807L;
        this.p1.l();
        this.p1 = null;
        for (c cVar : this.x.values()) {
            cVar.x();
        }
        this.p2.removeCallbacksAndMessages(null);
        this.p2 = null;
        this.x.clear();
    }

    public d(j jVar, x xVar, i iVar, double d2) {
        this.f3284d = jVar;
        this.f3285f = iVar;
        this.q = xVar;
        this.z = d2;
        this.y = new CopyOnWriteArrayList<>();
        this.x = new HashMap<>();
        this.L3 = -9223372036854775807L;
    }
}
