package b.d.d0;

import androidx.annotation.NonNull;
import b.d.d0.e2;
import b.d.d0.g2.e;
import b.d.d0.g2.f;
import b.d.d0.i2.b;
import b.d.d0.y1;
import com.tplink.tmp.enumerate.EnumTMPLayerStatus;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.CRC32;

/* compiled from: TMPLayer.java */
/* loaded from: classes3.dex */
public class e2 implements y1.b {
    private byte a;

    /* renamed from: b  reason: collision with root package name */
    private byte f249b;

    /* renamed from: c  reason: collision with root package name */
    private y1 f250c;

    /* renamed from: d  reason: collision with root package name */
    private int f251d = 1;

    /* renamed from: e  reason: collision with root package name */
    private EnumTMPLayerStatus f252e = EnumTMPLayerStatus.TMP_LAYER_STATUS_IDLE;

    /* renamed from: f  reason: collision with root package name */
    private g<b.d.d0.g2.g> f253f = io.reactivex.m0.b.n1().l1();
    private ExecutorService g = Executors.newSingleThreadExecutor();
    private ExecutorService h = Executors.newFixedThreadPool(4);
    private g<Boolean> i = io.reactivex.m0.b.n1().l1();
    private g<Boolean> j = io.reactivex.m0.b.n1().l1();
    private final List<c> k = new ArrayList();
    private b.d.d0.i2.b l = new b.d.d0.i2.b(-1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TMPLayer.java */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        boolean f254c = true;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(b.d.d0.g2.g gVar) {
            e2.this.a0(gVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ t d(Boolean bool) throws Exception {
            return e2.this.f249b == 0 ? e2.this.Y() : e2.this.Z();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f(final b.d.d0.g2.g gVar) throws Exception {
            if (e2.this.h != null) {
                e2.this.h.execute(new Runnable() { // from class: b.d.d0.a1
                    @Override // java.lang.Runnable
                    public final void run() {
                        e2.a.this.b(gVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g */
        public /* synthetic */ void h(Throwable th) throws Exception {
            e2.this.b0(th);
            this.f254c = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (this.f254c && e2.this.i != null) {
                e2.this.i.Q0(1L).N(new j() { // from class: b.d.d0.y0
                    @Override // io.reactivex.g0.j
                    public final Object apply(Object obj) {
                        return e2.a.this.d((Boolean) obj);
                    }
                }).H0(new io.reactivex.g0.g() { // from class: b.d.d0.b1
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        e2.a.this.f((b.d.d0.g2.g) obj);
                    }
                }, new io.reactivex.g0.g() { // from class: b.d.d0.z0
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        e2.a.this.h((Throwable) obj);
                    }
                });
            }
            e2.this.i0();
            e2.this.f253f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TMPLayer.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumTMPLayerStatus.values().length];
            a = iArr;
            try {
                iArr[EnumTMPLayerStatus.TMP_LAYER_STATUS_CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumTMPLayerStatus.TMP_LAYER_STATUS_CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumTMPLayerStatus.TMP_LAYER_STATUS_DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: TMPLayer.java */
    /* loaded from: classes3.dex */
    public interface c {
        void c(b.d.d0.i2.b bVar, e2 e2Var);

        void h(e2 e2Var);

        void i(e2 e2Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e2(byte b2, byte b3, @NonNull y1 y1Var) {
        this.a = b2;
        this.f249b = b3;
        this.f250c = y1Var;
        y1Var.n(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ t B(Boolean bool) throws Exception {
        return this.j.Q0(1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ t D(b.d.d0.g2.g gVar, Boolean bool) throws Exception {
        y1 y1Var = this.f250c;
        if (y1Var != null) {
            return y1Var.u(gVar.d());
        }
        throw new TPGeneralNetworkException(-1201);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ t F(b.d.d0.i2.b bVar) throws Exception {
        if (bVar.a() == 0) {
            return this.f253f;
        }
        throw new TPGeneralNetworkException(bVar.a(), bVar.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean G(b.d.d0.g2.g gVar, b.d.d0.g2.g gVar2) throws Exception {
        return gVar.b().a() == gVar2.b().a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b.d.d0.i2.b H(b.d.d0.g2.g gVar) throws Exception {
        return new b.d.d0.i2.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b.d.d0.i2.a I(Throwable th) throws Exception {
        if (!(th instanceof TPGeneralNetworkException)) {
            return new b.d.d0.i2.a(-1);
        }
        TPGeneralNetworkException tPGeneralNetworkException = (TPGeneralNetworkException) th;
        return new b.d.d0.i2.a(tPGeneralNetworkException.getErrCode(), tPGeneralNetworkException.getErrMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ t K(b.d.d0.g2.g gVar, Boolean bool) throws Exception {
        y1 y1Var = this.f250c;
        if (y1Var != null) {
            return y1Var.u(gVar.d());
        }
        throw new TPGeneralNetworkException(-1201);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void M(b.d.d0.i2.b bVar) throws Exception {
        if (bVar.a() == 0) {
            U();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b.d.d0.i2.a N(Throwable th) throws Exception {
        if (!(th instanceof TPGeneralNetworkException)) {
            return new b.d.d0.i2.a(-1234);
        }
        TPGeneralNetworkException tPGeneralNetworkException = (TPGeneralNetworkException) th;
        return new b.d.d0.i2.a(tPGeneralNetworkException.getErrCode(), tPGeneralNetworkException.getErrMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public /* synthetic */ t P(b.d.d0.i2.b bVar) throws Exception {
        if (bVar.a() == 0) {
            return this.f253f;
        }
        throw new TPGeneralNetworkException(bVar.a(), bVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public /* synthetic */ t S(b.d.d0.g2.g gVar) throws Exception {
        if (gVar.b().a() == 2) {
            return f0();
        }
        if (gVar.b().a() == 3) {
            return q.f0(new b.d.d0.i2.b(-1233));
        }
        return q.f0(new b.d.d0.i2.b(-1234));
    }

    private void W() {
        synchronized (this.k) {
            for (c cVar : this.k) {
                X(cVar);
            }
        }
    }

    private void X(c cVar) {
        int i = b.a[this.f252e.ordinal()];
        if (i == 1) {
            cVar.h(this);
        } else if (i == 2) {
            cVar.i(this);
        } else if (i == 3) {
            cVar.c(this.l, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q<b.d.d0.g2.g> Y() throws TPGeneralNetworkException {
        b.d.d0.g2.g gVar;
        y1 y1Var = this.f250c;
        if (y1Var != null) {
            byte[] c2 = y1Var.q(2).c();
            if (this.a != c2[0]) {
                V(new b.d.d0.i2.b(-1202));
                throw new TPGeneralNetworkException(-1201);
            } else if (this.f249b == c2[1]) {
                byte[] c3 = this.f250c.q(2).c();
                if (6 != c3[0]) {
                    if (5 == c3[0] || 4 == c3[0]) {
                        f fVar = new f(this.a, this.f249b, c3[0], c3[1], this.f250c.q(12).c());
                        byte[] bArr = null;
                        if (fVar.e() > 0) {
                            bArr = this.f250c.q(fVar.e()).c();
                        }
                        b.d.d0.g2.g gVar2 = new b.d.d0.g2.g(fVar, bArr);
                        int c4 = fVar.c();
                        fVar.g(1516993677);
                        byte[] d2 = gVar2.d();
                        CRC32 crc32 = new CRC32();
                        crc32.update(d2);
                        if (c4 == ((int) crc32.getValue())) {
                            fVar.g(c4);
                            gVar = gVar2;
                        } else {
                            TPGeneralNetworkException tPGeneralNetworkException = new TPGeneralNetworkException(-1211);
                            V(new b.d.d0.i2.b(tPGeneralNetworkException.getErrCode(), tPGeneralNetworkException.getErrMsg()));
                            throw tPGeneralNetworkException;
                        }
                    } else {
                        gVar = new b.d.d0.g2.g(new e(this.a, this.f249b, c3[0], c3[1]));
                    }
                    return q.f0(gVar);
                }
                TPGeneralNetworkException b2 = b.d.d0.f2.b.b(new f(this.a, this.f249b, c3[0], c3[1], this.f250c.q(12).c()).d());
                V(new b.d.d0.i2.b(b2.getErrCode(), b2.getErrMsg()));
                throw b2;
            } else {
                V(new b.d.d0.i2.b(-1203));
                throw new TPGeneralNetworkException(-1201);
            }
        } else {
            throw new TPGeneralNetworkException(-1201);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q<b.d.d0.g2.g> Z() throws TPGeneralNetworkException {
        b.d.d0.g2.g gVar;
        y1 y1Var = this.f250c;
        if (y1Var != null) {
            byte[] c2 = y1Var.q(2).c();
            if (this.a != c2[0]) {
                V(new b.d.d0.i2.b(-1202));
                throw new TPGeneralNetworkException(-1201);
            } else if (this.f249b == c2[1]) {
                byte[] c3 = this.f250c.q(2).c();
                if (6 != c3[0]) {
                    e eVar = new e(this.a, this.f249b, c3[0], c3[1]);
                    if (5 != c3[0]) {
                        gVar = new b.d.d0.g2.g(eVar);
                    } else {
                        f fVar = new f(this.a, this.f249b, c3[0], c3[1], this.f250c.q(12).c());
                        byte[] bArr = null;
                        if (fVar.e() > 0) {
                            bArr = this.f250c.q(fVar.e()).c();
                        }
                        b.d.d0.g2.g gVar2 = new b.d.d0.g2.g(fVar, bArr);
                        int c4 = fVar.c();
                        fVar.g(1516993677);
                        byte[] d2 = gVar2.d();
                        CRC32 crc32 = new CRC32();
                        crc32.update(d2);
                        if (c4 == ((int) crc32.getValue())) {
                            fVar.g(c4);
                            gVar = gVar2;
                        } else {
                            TPGeneralNetworkException tPGeneralNetworkException = new TPGeneralNetworkException(-1211);
                            V(new b.d.d0.i2.b(tPGeneralNetworkException.getErrCode(), tPGeneralNetworkException.getErrMsg()));
                            throw tPGeneralNetworkException;
                        }
                    }
                    return q.f0(gVar);
                }
                TPGeneralNetworkException c5 = b.d.d0.f2.b.c(c3[1]);
                V(new b.d.d0.i2.b(c5.getErrCode(), c5.getErrMsg()));
                throw c5;
            } else {
                V(new b.d.d0.i2.b(-1203));
                throw new TPGeneralNetworkException(-1201);
            }
        } else {
            throw new TPGeneralNetworkException(-1201);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(b.d.d0.g2.g gVar) {
        g<b.d.d0.g2.g> gVar2 = this.f253f;
        if (gVar2 != null && !gVar2.j1() && !this.f253f.k1()) {
            this.f253f.onNext(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(Throwable th) {
        g<b.d.d0.g2.g> gVar = this.f253f;
        if (gVar != null && !gVar.j1() && !this.f253f.k1()) {
            this.f253f.onError(th);
        }
    }

    private q<b.d.d0.i2.b> f0() {
        return g0(new b.d.d0.g2.g(new e(this.a, this.f249b, (byte) 2, (byte) 0)));
    }

    private q<b.d.d0.i2.b> g0(final b.d.d0.g2.g gVar) {
        return this.i.Q0(1L).N(new j() { // from class: b.d.d0.o1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return e2.this.K(gVar, (Boolean) obj);
            }
        });
    }

    private q<b.d.d0.i2.b> h0() {
        return g0(new b.d.d0.g2.g(new e(this.a, this.f249b, (byte) 1, (byte) 0))).N(new j() { // from class: b.d.d0.c1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return e2.this.P((b) obj);
            }
        }).L(s1.f348c).Q0(1L).N(new j() { // from class: b.d.d0.q1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return e2.this.S((b.d.d0.g2.g) obj);
            }
        }).E(new io.reactivex.g0.g() { // from class: b.d.d0.d1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                e2.this.M((b) obj);
            }
        }).p0(j1.f318c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        ExecutorService executorService = this.h;
        if (executorService != null) {
            executorService.shutdown();
            this.h = null;
        }
    }

    private void j0() {
        ExecutorService executorService = this.g;
        if (executorService != null) {
            executorService.shutdown();
            this.g = null;
        }
    }

    private void k0() {
        this.g.execute(new a());
    }

    private int q() {
        int i;
        synchronized (this) {
            i = this.f251d;
            this.f251d = i + 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ t s(Boolean bool) throws Exception {
        return this.j.Q0(1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ t u(b.d.d0.g2.g gVar, Boolean bool) throws Exception {
        if (this.f250c != null) {
            byte[] d2 = gVar.d();
            CRC32 crc32 = new CRC32();
            crc32.update(d2);
            System.arraycopy(b.d.d0.f2.a.a((int) crc32.getValue()), 0, d2, 12, 4);
            return this.f250c.u(d2);
        }
        throw new TPGeneralNetworkException(-1201);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ t w(b.d.d0.i2.b bVar) throws Exception {
        return this.f253f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean x(int i, b.d.d0.g2.g gVar) throws Exception {
        return (gVar.b() instanceof f) && i == ((f) gVar.b()).f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b.d.d0.i2.a y(b.d.d0.g2.g gVar) throws Exception {
        b.d.d0.i2.b bVar = new b.d.d0.i2.b(((f) gVar.b()).d());
        if (bVar.a() != 0) {
            return new b.d.d0.i2.a(bVar.a(), bVar.b());
        }
        return new b.d.d0.i2.a(gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b.d.d0.i2.a z(Throwable th) throws Exception {
        if (!(th instanceof TPGeneralNetworkException)) {
            return new b.d.d0.i2.a(-1);
        }
        TPGeneralNetworkException tPGeneralNetworkException = (TPGeneralNetworkException) th;
        return new b.d.d0.i2.a(tPGeneralNetworkException.getErrCode(), tPGeneralNetworkException.getErrMsg());
    }

    public void T(c cVar) {
        synchronized (this.k) {
            if (!this.k.contains(cVar)) {
                this.k.add(cVar);
            }
        }
        X(cVar);
    }

    protected void U() {
        int value = this.f252e.getValue();
        EnumTMPLayerStatus enumTMPLayerStatus = EnumTMPLayerStatus.TMP_LAYER_STATUS_CONNECTED;
        if (value <= enumTMPLayerStatus.getValue()) {
            this.f252e = enumTMPLayerStatus;
            W();
            this.j.onNext(Boolean.TRUE);
        }
    }

    protected void V(b.d.d0.i2.b bVar) {
        int value = this.f252e.getValue();
        EnumTMPLayerStatus enumTMPLayerStatus = EnumTMPLayerStatus.TMP_LAYER_STATUS_DISCONNECTED;
        if (value <= enumTMPLayerStatus.getValue()) {
            this.f252e = enumTMPLayerStatus;
            this.l = bVar;
            W();
            g<Boolean> gVar = this.j;
            if (gVar != null && !gVar.k1() && !this.j.j1()) {
                this.j.onError(new TPGeneralNetworkException(bVar.a(), bVar.b()));
            }
        }
    }

    @Override // b.d.d0.y1.b
    public void a(y1 y1Var) {
    }

    @Override // b.d.d0.y1.b
    public void b(b.d.d0.i2.b bVar, y1 y1Var) {
        TPGeneralNetworkException tPGeneralNetworkException = new TPGeneralNetworkException(bVar.a(), bVar.b());
        g<Boolean> gVar = this.i;
        if (gVar != null && !gVar.j1() && !this.i.k1()) {
            this.i.onError(tPGeneralNetworkException);
        }
        b0(tPGeneralNetworkException);
        this.l = bVar;
        this.f252e = EnumTMPLayerStatus.TMP_LAYER_STATUS_DISCONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q<b.d.d0.i2.a<b.d.d0.g2.g>> c0(final b.d.d0.g2.g gVar, byte b2) {
        if (this.f252e == EnumTMPLayerStatus.TMP_LAYER_STATUS_DISCONNECTED) {
            return q.f0(new b.d.d0.i2.a(this.l.a(), this.l.b()));
        }
        final int q = q();
        gVar.e(new f(this.a, this.f249b, b2, (byte) 0, gVar.c(), (byte) 0, (byte) 0, q, 1516993677));
        return this.i.Q0(1L).N(new j() { // from class: b.d.d0.f1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return e2.this.s((Boolean) obj);
            }
        }).N(new j() { // from class: b.d.d0.g1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return e2.this.u(gVar, (Boolean) obj);
            }
        }).N(new j() { // from class: b.d.d0.k1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return e2.this.w((b) obj);
            }
        }).L(new l() { // from class: b.d.d0.h1
            @Override // io.reactivex.g0.l
            public final boolean test(Object obj) {
                return e2.x(q, (b.d.d0.g2.g) obj);
            }
        }).Q0(1L).g0(e1.f248c).p0(n1.f331c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q<b.d.d0.i2.b> d0(final b.d.d0.g2.g gVar) {
        return this.i.Q0(1L).N(new j() { // from class: b.d.d0.r1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return e2.this.B((Boolean) obj);
            }
        }).N(new j() { // from class: b.d.d0.t1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return e2.this.D(gVar, (Boolean) obj);
            }
        }).N(new j() { // from class: b.d.d0.l1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return e2.this.F((b) obj);
            }
        }).L(new l() { // from class: b.d.d0.p1
            @Override // io.reactivex.g0.l
            public final boolean test(Object obj) {
                return e2.G(b.d.d0.g2.g.this, (b.d.d0.g2.g) obj);
            }
        }).Q0(1L).g0(i1.f312c).p0(m1.f328c);
    }

    @Override // b.d.d0.y1.b
    public void e(y1 y1Var) {
        this.i.onNext(Boolean.TRUE);
        k0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q<b.d.d0.i2.a<b.d.d0.g2.g>> e0(b.d.d0.g2.g gVar) {
        return c0(gVar, (byte) 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        j0();
        i0();
        synchronized (this.k) {
            this.k.clear();
        }
        this.f250c = null;
        this.j = null;
        this.i = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q<b.d.d0.i2.b> n() {
        if (this.f249b == 0) {
            return h0();
        }
        U();
        return q.f0(new b.d.d0.i2.b());
    }

    public byte o() {
        return this.a;
    }

    public byte p() {
        return this.f249b;
    }
}
