package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.util.k.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeJob.java */
/* loaded from: classes.dex */
class h<R> implements f.a, Runnable, Comparable<h<?>>, a.f {
    private int H3;
    private int I3;
    private j J3;
    private com.bumptech.glide.load.f K3;
    private b<R> L3;
    private int M3;
    private EnumC0051h N3;
    private g O3;
    private long P3;
    private boolean Q3;
    private Object R3;
    private Thread S3;
    private com.bumptech.glide.load.c T3;
    private com.bumptech.glide.load.c U3;
    private Object V3;
    private DataSource W3;
    private com.bumptech.glide.load.data.d<?> X3;
    private volatile f Y3;
    private volatile boolean Z3;
    private volatile boolean a4;
    private boolean b4;
    private com.bumptech.glide.e p0;
    private com.bumptech.glide.load.c p1;
    private Priority p2;
    private n p3;
    private final e q;
    private final Pools.Pool<h<?>> x;

    /* renamed from: c  reason: collision with root package name */
    private final g<R> f1439c = new g<>();

    /* renamed from: d  reason: collision with root package name */
    private final List<Throwable> f1440d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.util.k.c f1441f = com.bumptech.glide.util.k.c.a();
    private final d<?> y = new d<>();
    private final f z = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1442b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f1443c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f1443c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1443c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC0051h.values().length];
            f1442b = iArr2;
            try {
                iArr2[EnumC0051h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1442b[EnumC0051h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1442b[EnumC0051h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1442b[EnumC0051h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1442b[EnumC0051h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public interface b<R> {
        void b(u<R> uVar, DataSource dataSource, boolean z);

        void c(GlideException glideException);

        void e(h<?> hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public final class c<Z> implements i.a<Z> {
        private final DataSource a;

        c(DataSource dataSource) {
            this.a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.i.a
        @NonNull
        public u<Z> a(@NonNull u<Z> uVar) {
            return h.this.v(this.a, uVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public static class d<Z> {
        private com.bumptech.glide.load.c a;

        /* renamed from: b  reason: collision with root package name */
        private com.bumptech.glide.load.h<Z> f1445b;

        /* renamed from: c  reason: collision with root package name */
        private t<Z> f1446c;

        d() {
        }

        void a() {
            this.a = null;
            this.f1445b = null;
            this.f1446c = null;
        }

        void b(e eVar, com.bumptech.glide.load.f fVar) {
            com.bumptech.glide.util.k.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.a, new e(this.f1445b, this.f1446c, fVar));
            } finally {
                this.f1446c.h();
                com.bumptech.glide.util.k.b.d();
            }
        }

        boolean c() {
            return this.f1446c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void d(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.h<X> hVar, t<X> tVar) {
            this.a = cVar;
            this.f1445b = hVar;
            this.f1446c = tVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public interface e {
        com.bumptech.glide.load.engine.a0.a a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public static class f {
        private boolean a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1447b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1448c;

        f() {
        }

        private boolean a(boolean z) {
            return (this.f1448c || z || this.f1447b) && this.a;
        }

        synchronized boolean b() {
            this.f1447b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f1448c = true;
            return a(false);
        }

        synchronized boolean d(boolean z) {
            this.a = true;
            return a(z);
        }

        synchronized void e() {
            this.f1447b = false;
            this.a = false;
            this.f1448c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0051h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, Pools.Pool<h<?>> pool) {
        this.q = eVar;
        this.x = pool;
    }

    private void A() {
        int i = a.a[this.O3.ordinal()];
        if (i == 1) {
            this.N3 = k(EnumC0051h.INITIALIZE);
            this.Y3 = j();
            y();
        } else if (i == 2) {
            y();
        } else if (i == 3) {
            i();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.O3);
        }
    }

    private void B() {
        Throwable th;
        this.f1441f.c();
        if (this.Z3) {
            if (this.f1440d.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f1440d;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.Z3 = true;
    }

    private <Data> u<R> g(com.bumptech.glide.load.data.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long b2 = com.bumptech.glide.util.e.b();
            u<R> h = h(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                o("Decoded result " + h, b2);
            }
            return h;
        } finally {
            dVar.b();
        }
    }

    private <Data> u<R> h(Data data, DataSource dataSource) throws GlideException {
        return z(data, dataSource, (s<Data, ?, R>) this.f1439c.h(data.getClass()));
    }

    private void i() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j = this.P3;
            p("Retrieved data", j, "data: " + this.V3 + ", cache key: " + this.T3 + ", fetcher: " + this.X3);
        }
        u<R> uVar = null;
        try {
            uVar = g(this.X3, this.V3, this.W3);
        } catch (GlideException e2) {
            e2.setLoggingDetails(this.U3, this.W3);
            this.f1440d.add(e2);
        }
        if (uVar != null) {
            r(uVar, this.W3, this.b4);
        } else {
            y();
        }
    }

    private f j() {
        int i = a.f1442b[this.N3.ordinal()];
        if (i == 1) {
            return new v(this.f1439c, this);
        }
        if (i == 2) {
            return new c(this.f1439c, this);
        }
        if (i == 3) {
            return new y(this.f1439c, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.N3);
    }

    private EnumC0051h k(EnumC0051h hVar) {
        int i = a.f1442b[hVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return this.Q3 ? EnumC0051h.FINISHED : EnumC0051h.SOURCE;
            }
            if (i == 3 || i == 4) {
                return EnumC0051h.FINISHED;
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unrecognized stage: " + hVar);
            } else if (this.J3.b()) {
                return EnumC0051h.RESOURCE_CACHE;
            } else {
                return k(EnumC0051h.RESOURCE_CACHE);
            }
        } else if (this.J3.a()) {
            return EnumC0051h.DATA_CACHE;
        } else {
            return k(EnumC0051h.DATA_CACHE);
        }
    }

    @NonNull
    private com.bumptech.glide.load.f l(DataSource dataSource) {
        com.bumptech.glide.load.f fVar = this.K3;
        if (Build.VERSION.SDK_INT < 26) {
            return fVar;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f1439c.w();
        com.bumptech.glide.load.e<Boolean> eVar = k.f1639e;
        Boolean bool = (Boolean) fVar.c(eVar);
        if (bool != null && (!bool.booleanValue() || z)) {
            return fVar;
        }
        com.bumptech.glide.load.f fVar2 = new com.bumptech.glide.load.f();
        fVar2.d(this.K3);
        fVar2.e(eVar, Boolean.valueOf(z));
        return fVar2;
    }

    private int m() {
        return this.p2.ordinal();
    }

    private void o(String str, long j) {
        p(str, j, null);
    }

    private void p(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.util.e.a(j));
        sb.append(", load key: ");
        sb.append(this.p3);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void q(u<R> uVar, DataSource dataSource, boolean z) {
        B();
        this.L3.b(uVar, dataSource, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r(u<R> uVar, DataSource dataSource, boolean z) {
        if (uVar instanceof q) {
            ((q) uVar).b();
        }
        t tVar = 0;
        if (this.y.c()) {
            uVar = t.f(uVar);
            tVar = uVar;
        }
        q(uVar, dataSource, z);
        this.N3 = EnumC0051h.ENCODE;
        try {
            if (this.y.c()) {
                this.y.b(this.q, this.K3);
            }
            t();
        } finally {
            if (tVar != 0) {
                tVar.h();
            }
        }
    }

    private void s() {
        B();
        this.L3.c(new GlideException("Failed to load resource", new ArrayList(this.f1440d)));
        u();
    }

    private void t() {
        if (this.z.b()) {
            x();
        }
    }

    private void u() {
        if (this.z.c()) {
            x();
        }
    }

    private void x() {
        this.z.e();
        this.y.a();
        this.f1439c.a();
        this.Z3 = false;
        this.p0 = null;
        this.p1 = null;
        this.K3 = null;
        this.p2 = null;
        this.p3 = null;
        this.L3 = null;
        this.N3 = null;
        this.Y3 = null;
        this.S3 = null;
        this.T3 = null;
        this.V3 = null;
        this.W3 = null;
        this.X3 = null;
        this.P3 = 0L;
        this.a4 = false;
        this.R3 = null;
        this.f1440d.clear();
        this.x.release(this);
    }

    private void y() {
        this.S3 = Thread.currentThread();
        this.P3 = com.bumptech.glide.util.e.b();
        boolean z = false;
        while (!this.a4 && this.Y3 != null && !(z = this.Y3.b())) {
            this.N3 = k(this.N3);
            this.Y3 = j();
            if (this.N3 == EnumC0051h.SOURCE) {
                c();
                return;
            }
        }
        if ((this.N3 == EnumC0051h.FINISHED || this.a4) && !z) {
            s();
        }
    }

    private <Data, ResourceType> u<R> z(Data data, DataSource dataSource, s<Data, ResourceType, R> sVar) throws GlideException {
        com.bumptech.glide.load.f l = l(dataSource);
        com.bumptech.glide.load.data.e<Data> l2 = this.p0.i().l(data);
        try {
            return sVar.a(l2, l, this.H3, this.I3, new c(dataSource));
        } finally {
            l2.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        EnumC0051h k = k(EnumC0051h.INITIALIZE);
        return k == EnumC0051h.RESOURCE_CACHE || k == EnumC0051h.DATA_CACHE;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(cVar, dataSource, dVar.a());
        this.f1440d.add(glideException);
        if (Thread.currentThread() != this.S3) {
            this.O3 = g.SWITCH_TO_SOURCE_SERVICE;
            this.L3.e(this);
            return;
        }
        y();
    }

    public void b() {
        this.a4 = true;
        f fVar = this.Y3;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void c() {
        this.O3 = g.SWITCH_TO_SOURCE_SERVICE;
        this.L3.e(this);
    }

    @Override // com.bumptech.glide.util.k.a.f
    @NonNull
    public com.bumptech.glide.util.k.c d() {
        return this.f1441f;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void e(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.T3 = cVar;
        this.V3 = obj;
        this.X3 = dVar;
        this.W3 = dataSource;
        this.U3 = cVar2;
        boolean z = false;
        if (cVar != this.f1439c.c().get(0)) {
            z = true;
        }
        this.b4 = z;
        if (Thread.currentThread() != this.S3) {
            this.O3 = g.DECODE_DATA;
            this.L3.e(this);
            return;
        }
        com.bumptech.glide.util.k.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            i();
        } finally {
            com.bumptech.glide.util.k.b.d();
        }
    }

    /* renamed from: f */
    public int compareTo(@NonNull h<?> hVar) {
        int m = m() - hVar.m();
        return m == 0 ? this.M3 - hVar.M3 : m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h<R> n(com.bumptech.glide.e eVar, Object obj, n nVar, com.bumptech.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, j jVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.f fVar, b<R> bVar, int i3) {
        this.f1439c.u(eVar, obj, cVar, i, i2, jVar, cls, cls2, priority, fVar, map, z, z2, this.q);
        this.p0 = eVar;
        this.p1 = cVar;
        this.p2 = priority;
        this.p3 = nVar;
        this.H3 = i;
        this.I3 = i2;
        this.J3 = jVar;
        this.Q3 = z3;
        this.K3 = fVar;
        this.L3 = bVar;
        this.M3 = i3;
        this.O3 = g.INITIALIZE;
        this.R3 = obj;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.util.k.b.b("DecodeJob#run(model=%s)", this.R3);
        com.bumptech.glide.load.data.d<?> dVar = this.X3;
        try {
            try {
                if (this.a4) {
                    s();
                    if (dVar != null) {
                        dVar.b();
                    }
                    com.bumptech.glide.util.k.b.d();
                    return;
                }
                A();
                if (dVar != null) {
                    dVar.b();
                }
                com.bumptech.glide.util.k.b.d();
            } catch (b e2) {
                throw e2;
            }
        }
    }

    @NonNull
    <Z> u<Z> v(DataSource dataSource, @NonNull u<Z> uVar) {
        com.bumptech.glide.load.i<Z> iVar;
        u<Z> uVar2;
        EncodeStrategy encodeStrategy;
        com.bumptech.glide.load.c cVar;
        Class<?> cls = uVar.get().getClass();
        com.bumptech.glide.load.h hVar = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.i<Z> r = this.f1439c.r(cls);
            uVar2 = r.a(this.p0, uVar, this.H3, this.I3);
            iVar = r;
        } else {
            uVar2 = uVar;
            iVar = null;
        }
        if (!uVar.equals(uVar2)) {
            uVar.c();
        }
        if (this.f1439c.v(uVar2)) {
            hVar = this.f1439c.n(uVar2);
            encodeStrategy = hVar.b(this.K3);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        if (!this.J3.d(!this.f1439c.x(this.T3), dataSource, encodeStrategy)) {
            return uVar2;
        }
        if (hVar != null) {
            int i = a.f1443c[encodeStrategy.ordinal()];
            if (i == 1) {
                cVar = new d(this.T3, this.p1);
            } else if (i == 2) {
                cVar = new w(this.f1439c.b(), this.T3, this.p1, this.H3, this.I3, iVar, cls, this.K3);
            } else {
                throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
            }
            t f2 = t.f(uVar2);
            this.y.d(cVar, hVar, f2);
            return f2;
        }
        throw new Registry.NoResultEncoderAvailableException(uVar2.get().getClass());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(boolean z) {
        if (this.z.d(z)) {
            x();
        }
    }
}
