package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.e0;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: Access modifiers changed from: package-private */
@RequiresApi(18)
/* loaded from: classes.dex */
public class DefaultDrmSession implements DrmSession {
    @Nullable
    public final List<DrmInitData.SchemeData> a;

    /* renamed from: b  reason: collision with root package name */
    private final e0 f2178b;

    /* renamed from: c  reason: collision with root package name */
    private final a f2179c;

    /* renamed from: d  reason: collision with root package name */
    private final b f2180d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2181e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f2182f;
    private final boolean g;
    private final HashMap<String, String> h;
    private final m<v.a> i;
    private final x j;
    final i0 k;
    final UUID l;
    final e m;
    private int n;
    private int o;
    @Nullable
    private HandlerThread p;
    @Nullable
    private c q;
    @Nullable
    private d0 r;
    @Nullable
    private DrmSession.DrmSessionException s;
    @Nullable
    private byte[] t;
    private byte[] u;
    @Nullable
    private e0.a v;
    @Nullable
    private e0.d w;

    /* loaded from: classes.dex */
    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(Exception exc, boolean z);

        void b(DefaultDrmSession defaultDrmSession);

        void c();
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(DefaultDrmSession defaultDrmSession, int i);

        void b(DefaultDrmSession defaultDrmSession, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class c extends Handler {
        @GuardedBy("this")
        private boolean a;

        public c(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            IOException iOException;
            d dVar = (d) message.obj;
            if (!dVar.f2184b) {
                return false;
            }
            int i = dVar.f2187e + 1;
            dVar.f2187e = i;
            if (i > DefaultDrmSession.this.j.b(3)) {
                return false;
            }
            com.google.android.exoplayer2.source.x xVar = new com.google.android.exoplayer2.source.x(dVar.a, mediaDrmCallbackException.dataSpec, mediaDrmCallbackException.uriAfterRedirects, mediaDrmCallbackException.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.f2185c, mediaDrmCallbackException.bytesLoaded);
            a0 a0Var = new a0(3);
            if (mediaDrmCallbackException.getCause() instanceof IOException) {
                iOException = (IOException) mediaDrmCallbackException.getCause();
            } else {
                iOException = new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause());
            }
            long a = DefaultDrmSession.this.j.a(new x.c(xVar, a0Var, iOException, dVar.f2187e));
            if (a == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                if (this.a) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), a);
                return true;
            }
        }

        void b(int i, Object obj, boolean z) {
            obtainMessage(i, new d(com.google.android.exoplayer2.source.x.a(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.a = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Throwable, java.lang.Exception] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r6.obj
                com.google.android.exoplayer2.drm.DefaultDrmSession$d r0 = (com.google.android.exoplayer2.drm.DefaultDrmSession.d) r0
                int r1 = r6.what     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                if (r1 == 0) goto L_0x0020
                r2 = 1
                if (r1 != r2) goto L_0x001a
                com.google.android.exoplayer2.drm.DefaultDrmSession r1 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                com.google.android.exoplayer2.drm.i0 r2 = r1.k     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                java.util.UUID r1 = r1.l     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                java.lang.Object r3 = r0.f2186d     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                com.google.android.exoplayer2.drm.e0$a r3 = (com.google.android.exoplayer2.drm.e0.a) r3     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                byte[] r1 = r2.b(r1, r3)     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                goto L_0x0040
            L_0x001a:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                r1.<init>()     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                throw r1     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
            L_0x0020:
                com.google.android.exoplayer2.drm.DefaultDrmSession r1 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                com.google.android.exoplayer2.drm.i0 r2 = r1.k     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                java.util.UUID r1 = r1.l     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                java.lang.Object r3 = r0.f2186d     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                com.google.android.exoplayer2.drm.e0$d r3 = (com.google.android.exoplayer2.drm.e0.d) r3     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                byte[] r1 = r2.a(r1, r3)     // Catch: Exception -> 0x002f, MediaDrmCallbackException -> 0x0038
                goto L_0x0040
            L_0x002f:
                r1 = move-exception
                java.lang.String r2 = "DefaultDrmSession"
                java.lang.String r3 = "Key/provisioning request produced an unexpected exception. Not retrying."
                com.google.android.exoplayer2.util.u.i(r2, r3, r1)
                goto L_0x0040
            L_0x0038:
                r1 = move-exception
                boolean r2 = r5.a(r6, r1)
                if (r2 == 0) goto L_0x0040
                return
            L_0x0040:
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this
                com.google.android.exoplayer2.upstream.x r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.j(r2)
                long r3 = r0.a
                r2.d(r3)
                monitor-enter(r5)
                boolean r2 = r5.a     // Catch: all -> 0x0065
                if (r2 != 0) goto L_0x0063
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch: all -> 0x0065
                com.google.android.exoplayer2.drm.DefaultDrmSession$e r2 = r2.m     // Catch: all -> 0x0065
                int r6 = r6.what     // Catch: all -> 0x0065
                java.lang.Object r0 = r0.f2186d     // Catch: all -> 0x0065
                android.util.Pair r0 = android.util.Pair.create(r0, r1)     // Catch: all -> 0x0065
                android.os.Message r6 = r2.obtainMessage(r6, r0)     // Catch: all -> 0x0065
                r6.sendToTarget()     // Catch: all -> 0x0065
            L_0x0063:
                monitor-exit(r5)     // Catch: all -> 0x0065
                return
            L_0x0065:
                r6 = move-exception
                monitor-exit(r5)     // Catch: all -> 0x0065
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DefaultDrmSession.c.handleMessage(android.os.Message):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {
        public final long a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f2184b;

        /* renamed from: c  reason: collision with root package name */
        public final long f2185c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f2186d;

        /* renamed from: e  reason: collision with root package name */
        public int f2187e;

        public d(long j, boolean z, long j2, Object obj) {
            this.a = j;
            this.f2184b = z;
            this.f2185c = j2;
            this.f2186d = obj;
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    private class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                DefaultDrmSession.this.y(obj, obj2);
            } else if (i == 1) {
                DefaultDrmSession.this.s(obj, obj2);
            }
        }
    }

    public DefaultDrmSession(UUID uuid, e0 e0Var, a aVar, b bVar, @Nullable List<DrmInitData.SchemeData> list, int i, boolean z, boolean z2, @Nullable byte[] bArr, HashMap<String, String> hashMap, i0 i0Var, Looper looper, x xVar) {
        if (i == 1 || i == 3) {
            g.e(bArr);
        }
        this.l = uuid;
        this.f2179c = aVar;
        this.f2180d = bVar;
        this.f2178b = e0Var;
        this.f2181e = i;
        this.f2182f = z;
        this.g = z2;
        if (bArr != null) {
            this.u = bArr;
            this.a = null;
        } else {
            this.a = Collections.unmodifiableList((List) g.e(list));
        }
        this.h = hashMap;
        this.k = i0Var;
        this.i = new m<>();
        this.j = xVar;
        this.n = 2;
        this.m = new e(looper);
    }

    private void A(byte[] bArr, int i, boolean z) {
        try {
            this.v = this.f2178b.k(bArr, this.a, i, this.h);
            ((c) o0.i(this.q)).b(1, g.e(this.v), z);
        } catch (Exception e2) {
            t(e2, true);
        }
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    private boolean C() {
        try {
            this.f2178b.f(this.t, this.u);
            return true;
        } catch (Exception e2) {
            r(e2, 1);
            return false;
        }
    }

    private void k(l<v.a> lVar) {
        for (v.a aVar : this.i.elementSet()) {
            lVar.accept(aVar);
        }
    }

    @RequiresNonNull({"sessionId"})
    private void l(boolean z) {
        if (!this.g) {
            byte[] bArr = (byte[]) o0.i(this.t);
            int i = this.f2181e;
            if (i == 0 || i == 1) {
                if (this.u == null) {
                    A(bArr, 1, z);
                } else if (this.n == 4 || C()) {
                    long m = m();
                    if (this.f2181e == 0 && m <= 60) {
                        StringBuilder sb = new StringBuilder(88);
                        sb.append("Offline license has expired or will expire soon. Remaining seconds: ");
                        sb.append(m);
                        u.b("DefaultDrmSession", sb.toString());
                        A(bArr, 2, z);
                    } else if (m <= 0) {
                        r(new KeysExpiredException(), 2);
                    } else {
                        this.n = 4;
                        k(q.a);
                    }
                }
            } else if (i != 2) {
                if (i == 3) {
                    g.e(this.u);
                    g.e(this.t);
                    A(this.u, 3, z);
                }
            } else if (this.u == null || C()) {
                A(bArr, 2, z);
            }
        }
    }

    private long m() {
        if (!w0.f4083d.equals(this.l)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) g.e(k0.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean o() {
        int i = this.n;
        return i == 3 || i == 4;
    }

    private void r(final Exception exc, int i) {
        this.s = new DrmSession.DrmSessionException(exc, a0.a(exc, i));
        u.d("DefaultDrmSession", "DRM session error", exc);
        k(new l() { // from class: com.google.android.exoplayer2.drm.b
            @Override // com.google.android.exoplayer2.util.l
            public final void accept(Object obj) {
                ((v.a) obj).f(exc);
            }
        });
        if (this.n != 4) {
            this.n = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Object obj, Object obj2) {
        if (obj == this.v && o()) {
            this.v = null;
            if (obj2 instanceof Exception) {
                t((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f2181e == 3) {
                    this.f2178b.j((byte[]) o0.i(this.u), bArr);
                    k(a.a);
                    return;
                }
                byte[] j = this.f2178b.j(this.t, bArr);
                int i = this.f2181e;
                if (!((i != 2 && (i != 0 || this.u == null)) || j == null || j.length == 0)) {
                    this.u = j;
                }
                this.n = 4;
                k(p.a);
            } catch (Exception e2) {
                t(e2, true);
            }
        }
    }

    private void t(Exception exc, boolean z) {
        if (exc instanceof NotProvisionedException) {
            this.f2179c.b(this);
        } else {
            r(exc, z ? 1 : 2);
        }
    }

    private void u() {
        if (this.f2181e == 0 && this.n == 4) {
            o0.i(this.t);
            l(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Object obj, Object obj2) {
        if (obj != this.w) {
            return;
        }
        if (this.n == 2 || o()) {
            this.w = null;
            if (obj2 instanceof Exception) {
                this.f2179c.a((Exception) obj2, false);
                return;
            }
            try {
                this.f2178b.h((byte[]) obj2);
                this.f2179c.c();
            } catch (Exception e2) {
                this.f2179c.a(e2, true);
            }
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean z() {
        if (o()) {
            return true;
        }
        try {
            byte[] e2 = this.f2178b.e();
            this.t = e2;
            this.r = this.f2178b.c(e2);
            this.n = 3;
            k(new l() { // from class: com.google.android.exoplayer2.drm.c
                @Override // com.google.android.exoplayer2.util.l
                public final void accept(Object obj) {
                    ((v.a) obj).e(r1);
                }
            });
            g.e(this.t);
            return true;
        } catch (NotProvisionedException unused) {
            this.f2179c.b(this);
            return false;
        } catch (Exception e3) {
            r(e3, 1);
            return false;
        }
    }

    public void B() {
        this.w = this.f2178b.d();
        ((c) o0.i(this.q)).b(0, g.e(this.w), true);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(@Nullable v.a aVar) {
        boolean z = false;
        g.g(this.o >= 0);
        if (aVar != null) {
            this.i.a(aVar);
        }
        int i = this.o + 1;
        this.o = i;
        if (i == 1) {
            if (this.n == 2) {
                z = true;
            }
            g.g(z);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.p = handlerThread;
            handlerThread.start();
            this.q = new c(this.p.getLooper());
            if (z()) {
                l(true);
            }
        } else if (aVar != null && o() && this.i.count(aVar) == 1) {
            aVar.e(this.n);
        }
        this.f2180d.a(this, this.o);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void b(@Nullable v.a aVar) {
        g.g(this.o > 0);
        int i = this.o - 1;
        this.o = i;
        if (i == 0) {
            this.n = 0;
            ((e) o0.i(this.m)).removeCallbacksAndMessages(null);
            ((c) o0.i(this.q)).c();
            this.q = null;
            ((HandlerThread) o0.i(this.p)).quit();
            this.p = null;
            this.r = null;
            this.s = null;
            this.v = null;
            this.w = null;
            byte[] bArr = this.t;
            if (bArr != null) {
                this.f2178b.i(bArr);
                this.t = null;
            }
        }
        if (aVar != null) {
            this.i.b(aVar);
            if (this.i.count(aVar) == 0) {
                aVar.g();
            }
        }
        this.f2180d.b(this, this.o);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID c() {
        return this.l;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean d() {
        return this.f2182f;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final d0 e() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final DrmSession.DrmSessionException f() {
        if (this.n == 1) {
            return this.s;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public Map<String, String> g() {
        byte[] bArr = this.t;
        if (bArr == null) {
            return null;
        }
        return this.f2178b.b(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.n;
    }

    public boolean n(byte[] bArr) {
        return Arrays.equals(this.t, bArr);
    }

    public void v(int i) {
        if (i == 2) {
            u();
        }
    }

    public void w() {
        if (z()) {
            l(true);
        }
    }

    public void x(Exception exc, boolean z) {
        r(exc, z ? 1 : 3);
    }
}
