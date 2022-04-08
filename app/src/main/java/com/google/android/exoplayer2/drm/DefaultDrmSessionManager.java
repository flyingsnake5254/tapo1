package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.e0;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.drm.x;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.j3;
import com.google.common.collect.u2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@RequiresApi(18)
/* loaded from: classes.dex */
public class DefaultDrmSessionManager implements x {

    /* renamed from: c  reason: collision with root package name */
    private final UUID f2188c;

    /* renamed from: d  reason: collision with root package name */
    private final e0.c f2189d;

    /* renamed from: e  reason: collision with root package name */
    private final i0 f2190e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, String> f2191f;
    private final boolean g;
    private final int[] h;
    private final boolean i;
    private final f j;
    private final x k;
    private final g l;
    private final long m;
    private final List<DefaultDrmSession> n;
    private final Set<e> o;
    private final Set<DefaultDrmSession> p;
    private int q;
    @Nullable
    private e0 r;
    @Nullable
    private DefaultDrmSession s;
    @Nullable
    private DefaultDrmSession t;
    private Looper u;
    private Handler v;
    private int w;
    @Nullable
    private byte[] x;
    @Nullable
    volatile d y;

    /* loaded from: classes.dex */
    public static final class MissingSchemeDataException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private MissingSchemeDataException(java.util.UUID r3) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                int r0 = r0 + 29
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                java.lang.String r0 = "Media does not support uuid: "
                r1.append(r0)
                r1.append(r3)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MissingSchemeDataException.<init>(java.util.UUID):void");
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: d  reason: collision with root package name */
        private boolean f2194d;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2196f;
        private final HashMap<String, String> a = new HashMap<>();

        /* renamed from: b  reason: collision with root package name */
        private UUID f2192b = w0.f4083d;

        /* renamed from: c  reason: collision with root package name */
        private e0.c f2193c = g0.a;
        private x g = new t();

        /* renamed from: e  reason: collision with root package name */
        private int[] f2195e = new int[0];
        private long h = 300000;

        public DefaultDrmSessionManager a(i0 i0Var) {
            return new DefaultDrmSessionManager(this.f2192b, this.f2193c, i0Var, this.a, this.f2194d, this.f2195e, this.f2196f, this.g, this.h);
        }

        public b b(boolean z) {
            this.f2194d = z;
            return this;
        }

        public b c(boolean z) {
            this.f2196f = z;
            return this;
        }

        public b d(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (!(i == 2 || i == 1)) {
                    z = false;
                }
                com.google.android.exoplayer2.util.g.a(z);
            }
            this.f2195e = (int[]) iArr.clone();
            return this;
        }

        public b e(UUID uuid, e0.c cVar) {
            this.f2192b = (UUID) com.google.android.exoplayer2.util.g.e(uuid);
            this.f2193c = (e0.c) com.google.android.exoplayer2.util.g.e(cVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    private class c implements e0.b {
        private c() {
        }

        @Override // com.google.android.exoplayer2.drm.e0.b
        public void a(e0 e0Var, @Nullable byte[] bArr, int i, int i2, @Nullable byte[] bArr2) {
            ((d) com.google.android.exoplayer2.util.g.e(DefaultDrmSessionManager.this.y)).obtainMessage(i, bArr).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.n) {
                    if (defaultDrmSession.n(bArr)) {
                        defaultDrmSession.v(message.what);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements x.b {
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final v.a f2197b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private DrmSession f2198c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2199d;

        public e(@Nullable v.a aVar) {
            this.f2197b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void c(Format format) {
            if (DefaultDrmSessionManager.this.q != 0 && !this.f2199d) {
                DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
                this.f2198c = defaultDrmSessionManager.r((Looper) com.google.android.exoplayer2.util.g.e(defaultDrmSessionManager.u), this.f2197b, format, false);
                DefaultDrmSessionManager.this.o.add(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void e() {
            if (!this.f2199d) {
                DrmSession drmSession = this.f2198c;
                if (drmSession != null) {
                    drmSession.b(this.f2197b);
                }
                DefaultDrmSessionManager.this.o.remove(this);
                this.f2199d = true;
            }
        }

        public void a(final Format format) {
            ((Handler) com.google.android.exoplayer2.util.g.e(DefaultDrmSessionManager.this.v)).post(new Runnable() { // from class: com.google.android.exoplayer2.drm.e
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDrmSessionManager.e.this.c(format);
                }
            });
        }

        @Override // com.google.android.exoplayer2.drm.x.b
        public void release() {
            o0.z0((Handler) com.google.android.exoplayer2.util.g.e(DefaultDrmSessionManager.this.v), new Runnable() { // from class: com.google.android.exoplayer2.drm.d
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDrmSessionManager.e.this.e();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements DefaultDrmSession.a {
        private final Set<DefaultDrmSession> a = new HashSet();
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private DefaultDrmSession f2201b;

        public f(DefaultDrmSessionManager defaultDrmSessionManager) {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void a(Exception exc, boolean z) {
            this.f2201b = null;
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.a);
            this.a.clear();
            j3 it = copyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).x(exc, z);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void b(DefaultDrmSession defaultDrmSession) {
            this.a.add(defaultDrmSession);
            if (this.f2201b == null) {
                this.f2201b = defaultDrmSession;
                defaultDrmSession.B();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void c() {
            this.f2201b = null;
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.a);
            this.a.clear();
            j3 it = copyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).w();
            }
        }

        public void d(DefaultDrmSession defaultDrmSession) {
            this.a.remove(defaultDrmSession);
            if (this.f2201b == defaultDrmSession) {
                this.f2201b = null;
                if (!this.a.isEmpty()) {
                    DefaultDrmSession next = this.a.iterator().next();
                    this.f2201b = next;
                    next.B();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g implements DefaultDrmSession.b {
        private g() {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void a(DefaultDrmSession defaultDrmSession, int i) {
            if (DefaultDrmSessionManager.this.m != -9223372036854775807L) {
                DefaultDrmSessionManager.this.p.remove(defaultDrmSession);
                ((Handler) com.google.android.exoplayer2.util.g.e(DefaultDrmSessionManager.this.v)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void b(final DefaultDrmSession defaultDrmSession, int i) {
            if (i == 1 && DefaultDrmSessionManager.this.q > 0 && DefaultDrmSessionManager.this.m != -9223372036854775807L) {
                DefaultDrmSessionManager.this.p.add(defaultDrmSession);
                ((Handler) com.google.android.exoplayer2.util.g.e(DefaultDrmSessionManager.this.v)).postAtTime(new Runnable() { // from class: com.google.android.exoplayer2.drm.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultDrmSession.this.b(null);
                    }
                }, defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.m);
            } else if (i == 0) {
                DefaultDrmSessionManager.this.n.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.s == defaultDrmSession) {
                    DefaultDrmSessionManager.this.s = null;
                }
                if (DefaultDrmSessionManager.this.t == defaultDrmSession) {
                    DefaultDrmSessionManager.this.t = null;
                }
                DefaultDrmSessionManager.this.j.d(defaultDrmSession);
                if (DefaultDrmSessionManager.this.m != -9223372036854775807L) {
                    ((Handler) com.google.android.exoplayer2.util.g.e(DefaultDrmSessionManager.this.v)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.p.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.r != null && this.q == 0 && this.n.isEmpty() && this.o.isEmpty()) {
            ((e0) com.google.android.exoplayer2.util.g.e(this.r)).release();
            this.r = null;
        }
    }

    private void B() {
        j3 it = ImmutableSet.copyOf((Collection) this.o).iterator();
        while (it.hasNext()) {
            ((e) it.next()).release();
        }
    }

    private void D(DrmSession drmSession, @Nullable v.a aVar) {
        drmSession.b(aVar);
        if (this.m != -9223372036854775807L) {
            drmSession.b(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public DrmSession r(Looper looper, @Nullable v.a aVar, Format format, boolean z) {
        List<DrmInitData.SchemeData> list;
        z(looper);
        DrmInitData drmInitData = format.K3;
        if (drmInitData == null) {
            return y(y.k(format.H3), z);
        }
        DefaultDrmSession defaultDrmSession = null;
        if (this.x == null) {
            list = w((DrmInitData) com.google.android.exoplayer2.util.g.e(drmInitData), this.f2188c, false);
            if (list.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f2188c);
                u.d("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.f(missingSchemeDataException);
                }
                return new c0(new DrmSession.DrmSessionException(missingSchemeDataException, PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR));
            }
        } else {
            list = null;
        }
        if (this.g) {
            Iterator<DefaultDrmSession> it = this.n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it.next();
                if (o0.b(next.a, list)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.t;
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = v(list, false, aVar, z);
            if (!this.g) {
                this.t = defaultDrmSession;
            }
            this.n.add(defaultDrmSession);
        } else {
            defaultDrmSession.a(aVar);
        }
        return defaultDrmSession;
    }

    private static boolean s(DrmSession drmSession) {
        return drmSession.getState() == 1 && (o0.a < 19 || (((DrmSession.DrmSessionException) com.google.android.exoplayer2.util.g.e(drmSession.f())).getCause() instanceof ResourceBusyException));
    }

    private boolean t(DrmInitData drmInitData) {
        if (this.x != null) {
            return true;
        }
        if (w(drmInitData, this.f2188c, true).isEmpty()) {
            if (drmInitData.q != 1 || !drmInitData.e(0).c(w0.f4081b)) {
                return false;
            }
            String valueOf = String.valueOf(this.f2188c);
            StringBuilder sb = new StringBuilder(valueOf.length() + 72);
            sb.append("DrmInitData only contains common PSSH SchemeData. Assuming support for: ");
            sb.append(valueOf);
            u.h("DefaultDrmSessionMgr", sb.toString());
        }
        String str = drmInitData.f2204f;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return "cbcs".equals(str) ? o0.a >= 25 : !"cbc1".equals(str) && !"cens".equals(str);
    }

    private DefaultDrmSession u(@Nullable List<DrmInitData.SchemeData> list, boolean z, @Nullable v.a aVar) {
        com.google.android.exoplayer2.util.g.e(this.r);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f2188c, this.r, this.j, this.l, list, this.w, this.i | z, z, this.x, this.f2191f, this.f2190e, (Looper) com.google.android.exoplayer2.util.g.e(this.u), this.k);
        defaultDrmSession.a(aVar);
        if (this.m != -9223372036854775807L) {
            defaultDrmSession.a(null);
        }
        return defaultDrmSession;
    }

    private DefaultDrmSession v(@Nullable List<DrmInitData.SchemeData> list, boolean z, @Nullable v.a aVar, boolean z2) {
        DefaultDrmSession u = u(list, z, aVar);
        if (s(u) && !this.p.isEmpty()) {
            j3 it = ImmutableSet.copyOf((Collection) this.p).iterator();
            while (it.hasNext()) {
                ((DrmSession) it.next()).b(null);
            }
            D(u, aVar);
            u = u(list, z, aVar);
        }
        if (!s(u) || !z2 || this.o.isEmpty()) {
            return u;
        }
        B();
        D(u, aVar);
        return u(list, z, aVar);
    }

    private static List<DrmInitData.SchemeData> w(DrmInitData drmInitData, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.q);
        for (int i = 0; i < drmInitData.q; i++) {
            DrmInitData.SchemeData e2 = drmInitData.e(i);
            if ((e2.c(uuid) || (w0.f4082c.equals(uuid) && e2.c(w0.f4081b))) && (e2.x != null || z)) {
                arrayList.add(e2);
            }
        }
        return arrayList;
    }

    @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
    private synchronized void x(Looper looper) {
        Looper looper2 = this.u;
        if (looper2 == null) {
            this.u = looper;
            this.v = new Handler(looper);
        } else {
            com.google.android.exoplayer2.util.g.g(looper2 == looper);
            com.google.android.exoplayer2.util.g.e(this.v);
        }
    }

    @Nullable
    private DrmSession y(int i, boolean z) {
        e0 e0Var = (e0) com.google.android.exoplayer2.util.g.e(this.r);
        if ((f0.class.equals(e0Var.a()) && f0.a) || o0.p0(this.h, i) == -1 || j0.class.equals(e0Var.a())) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.s;
        if (defaultDrmSession == null) {
            DefaultDrmSession v = v(ImmutableList.of(), true, null, z);
            this.n.add(v);
            this.s = v;
        } else {
            defaultDrmSession.a(null);
        }
        return this.s;
    }

    private void z(Looper looper) {
        if (this.y == null) {
            this.y = new d(looper);
        }
    }

    public void C(int i, @Nullable byte[] bArr) {
        com.google.android.exoplayer2.util.g.g(this.n.isEmpty());
        if (i == 1 || i == 3) {
            com.google.android.exoplayer2.util.g.e(bArr);
        }
        this.w = i;
        this.x = bArr;
    }

    @Override // com.google.android.exoplayer2.drm.x
    @Nullable
    public DrmSession a(Looper looper, @Nullable v.a aVar, Format format) {
        com.google.android.exoplayer2.util.g.g(this.q > 0);
        x(looper);
        return r(looper, aVar, format, true);
    }

    @Override // com.google.android.exoplayer2.drm.x
    public x.b b(Looper looper, @Nullable v.a aVar, Format format) {
        com.google.android.exoplayer2.util.g.g(this.q > 0);
        x(looper);
        e eVar = new e(aVar);
        eVar.a(format);
        return eVar;
    }

    @Override // com.google.android.exoplayer2.drm.x
    @Nullable
    public Class<? extends d0> c(Format format) {
        Class<? extends d0> a2 = ((e0) com.google.android.exoplayer2.util.g.e(this.r)).a();
        DrmInitData drmInitData = format.K3;
        if (drmInitData != null) {
            return t(drmInitData) ? a2 : j0.class;
        }
        if (o0.p0(this.h, y.k(format.H3)) != -1) {
            return a2;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.x
    public final void prepare() {
        int i = this.q;
        this.q = i + 1;
        if (i == 0) {
            if (this.r == null) {
                e0 a2 = this.f2189d.a(this.f2188c);
                this.r = a2;
                a2.g(new c());
            } else if (this.m != -9223372036854775807L) {
                for (int i2 = 0; i2 < this.n.size(); i2++) {
                    this.n.get(i2).a(null);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.x
    public final void release() {
        int i = this.q - 1;
        this.q = i;
        if (i == 0) {
            if (this.m != -9223372036854775807L) {
                ArrayList arrayList = new ArrayList(this.n);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ((DefaultDrmSession) arrayList.get(i2)).b(null);
                }
            }
            B();
            A();
        }
    }

    private DefaultDrmSessionManager(UUID uuid, e0.c cVar, i0 i0Var, HashMap<String, String> hashMap, boolean z, int[] iArr, boolean z2, com.google.android.exoplayer2.upstream.x xVar, long j) {
        com.google.android.exoplayer2.util.g.e(uuid);
        com.google.android.exoplayer2.util.g.b(!w0.f4081b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f2188c = uuid;
        this.f2189d = cVar;
        this.f2190e = i0Var;
        this.f2191f = hashMap;
        this.g = z;
        this.h = iArr;
        this.i = z2;
        this.k = xVar;
        this.j = new f(this);
        this.l = new g();
        this.w = 0;
        this.n = new ArrayList();
        this.o = u2.f();
        this.p = u2.f();
        this.m = j;
    }
}
