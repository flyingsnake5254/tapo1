package b.d.d0;

import androidx.core.app.NotificationManagerCompat;
import b.d.d0.e2;
import b.d.d0.g2.e;
import b.d.d0.h2.a.c;
import b.d.d0.h2.a.d;
import b.d.d0.x1;
import b.d.d0.y1;
import com.tplink.tmp.enumerate.EnumTMPClientStatus;
import com.tplink.tmp.enumerate.EnumTMPTransportType;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.g0.j;
import io.reactivex.m0.b;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TMPClient.java */
/* loaded from: classes3.dex */
public class c2 implements y1.b, e2.c, x1.b {

    /* renamed from: b  reason: collision with root package name */
    private d2 f237b;

    /* renamed from: c  reason: collision with root package name */
    private x1 f238c;

    /* renamed from: d  reason: collision with root package name */
    private y1 f239d;

    /* renamed from: e  reason: collision with root package name */
    private c f240e;

    /* renamed from: f  reason: collision with root package name */
    private e2 f241f;
    private EnumTMPClientStatus a = EnumTMPClientStatus.TMPCLIENT_STATUS_IDLE;
    private g<Boolean> g = b.n1().l1();
    private b.d.d0.i2.b h = new b.d.d0.i2.b(-1);
    private final AtomicInteger i = new AtomicInteger(0);
    private io.reactivex.e0.b j = new io.reactivex.e0.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TMPClient.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f242b;

        static {
            int[] iArr = new int[EnumTMPClientStatus.values().length];
            f242b = iArr;
            try {
                iArr[EnumTMPClientStatus.TMPCLIENT_STATUS_CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f242b[EnumTMPClientStatus.TMPCLIENT_STATUS_CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f242b[EnumTMPClientStatus.TMPCLIENT_STATUS_DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[EnumTMPTransportType.values().length];
            a = iArr2;
            try {
                iArr2[EnumTMPTransportType.TRANSPORT_TYPE_ATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumTMPTransportType.TRANSPORT_TYPE_BLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public c2(c cVar) {
        this.f240e = cVar;
        int i = a.a[cVar.e().ordinal()];
        if (i == 1) {
            b.d.d0.h2.a.a aVar = (b.d.d0.h2.a.a) cVar;
            b.d.d0.h2.b.a aVar2 = new b.d.d0.h2.b.a(aVar.m(), aVar.n(), aVar.l());
            aVar2.b(cVar.b());
            this.f239d = new u1(aVar2);
        } else if (i != 2) {
            b.d.d0.h2.b.c cVar2 = new b.d.d0.h2.b.c((d) cVar);
            cVar2.b(cVar.b());
            this.f239d = new w1(cVar.e(), cVar2);
        } else {
            b.d.d0.h2.a.b bVar = (b.d.d0.h2.a.b) cVar;
            b.d.d0.h2.b.b bVar2 = new b.d.d0.h2.b.b(bVar.l(), bVar.o(), bVar.n(), bVar.p(), bVar.m());
            bVar2.b(cVar.b());
            this.f239d = new v1(cVar.e(), bVar2);
        }
        this.f241f = new e2(cVar.c(), cVar.d(), this.f239d);
        byte a2 = cVar.a();
        if (a2 == 1) {
            this.f238c = new z1(this.f241f);
        } else if (a2 == 2) {
            this.f238c = new a2(this.f241f);
        } else if (a2 == 3) {
            this.f238c = new b2(this.f241f);
        } else {
            throw new UnsupportedOperationException(String.format("Business Version %d is not supported yet.", Byte.valueOf(cVar.a())));
        }
        this.f239d.n(this);
        this.f241f.T(this);
        this.f238c.j(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C(Long l) throws Exception {
        o().F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E(io.reactivex.e0.c cVar) throws Exception {
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ t G(byte b2, Boolean bool) throws Exception {
        return this.f241f.c0(new b.d.d0.g2.g(), b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ t J(byte b2, Boolean bool) throws Exception {
        return this.f241f.d0(new b.d.d0.g2.g(new e(this.f241f.o(), this.f241f.p(), b2, (byte) 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ t M(b.d.d0.f2.d dVar, Boolean bool) throws Exception {
        return this.f238c.n(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void O(io.reactivex.e0.c cVar) throws Exception {
        p();
    }

    private q<Boolean> S(byte b2) {
        e2 e2Var;
        if (this.a == EnumTMPClientStatus.TMPCLIENT_STATUS_DISCONNECTED || this.g == null || (e2Var = this.f241f) == null) {
            return q.f0(Boolean.FALSE);
        }
        return e2Var.p() == 0 ? T(b2) : U(b2);
    }

    private q<Boolean> T(final byte b2) {
        return this.g.Q0(1L).N(new j() { // from class: b.d.d0.v0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return c2.this.G(b2, (Boolean) obj);
            }
        }).g0(s0.f347c).q0(Boolean.FALSE);
    }

    private q<Boolean> U(final byte b2) {
        return this.g.Q0(1L).N(new j() { // from class: b.d.d0.u0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return c2.this.J(b2, (Boolean) obj);
            }
        }).g0(k0.f321c).q0(Boolean.FALSE);
    }

    private void W() {
        if (this.f237b != null) {
            int i = a.f242b[this.a.ordinal()];
            if (i == 1) {
                this.f237b.c(this);
            } else if (i == 2) {
                this.f237b.b(this);
            } else if (i == 3) {
                this.f237b.a(this.h, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.i.decrementAndGet() <= 0) {
            y1 y1Var = this.f239d;
            if (y1Var instanceof u1) {
                ((u1) y1Var).z();
            }
            y1 y1Var2 = this.f239d;
            if (y1Var2 != null && y1Var2.i() >= 0) {
                this.j.b(q.W0(this.f239d.i(), TimeUnit.MILLISECONDS).G0(new io.reactivex.g0.g() { // from class: b.d.d0.x0
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        c2.this.C((Long) obj);
                    }
                }));
            }
        }
    }

    private void p() {
        this.i.incrementAndGet();
        if (this.j.f() > 0) {
            this.j.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ t s(b.d.d0.i2.b bVar) throws Exception {
        if (bVar.a() == 0) {
            return this.f241f.n();
        }
        R(bVar);
        return q.f0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ t u(b.d.d0.i2.b bVar) throws Exception {
        if (bVar.a() == 0) {
            return this.f238c.b();
        }
        R(bVar);
        return q.f0(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w(b.d.d0.i2.b bVar) throws Exception {
        if (bVar.a() == 0) {
            P();
        } else {
            R(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(Throwable th) throws Exception {
        if (th instanceof TPGeneralNetworkException) {
            TPGeneralNetworkException tPGeneralNetworkException = (TPGeneralNetworkException) th;
            R(new b.d.d0.i2.b(tPGeneralNetworkException.getErrCode(), tPGeneralNetworkException.getErrMsg()));
            return;
        }
        R(new b.d.d0.i2.b(-1, th.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(io.reactivex.e0.c cVar) throws Exception {
        Q();
    }

    protected void P() {
        int value = this.a.getValue();
        EnumTMPClientStatus enumTMPClientStatus = EnumTMPClientStatus.TMPCLIENT_STATUS_CONNECTED;
        if (value < enumTMPClientStatus.getValue()) {
            this.a = enumTMPClientStatus;
            W();
            this.g.onNext(Boolean.TRUE);
        }
    }

    protected void Q() {
        int value = this.a.getValue();
        EnumTMPClientStatus enumTMPClientStatus = EnumTMPClientStatus.TMPCLIENT_STATUS_CONNECTING;
        if (value < enumTMPClientStatus.getValue()) {
            this.a = enumTMPClientStatus;
            W();
        }
    }

    protected void R(b.d.d0.i2.b bVar) {
        int value = this.a.getValue();
        EnumTMPClientStatus enumTMPClientStatus = EnumTMPClientStatus.TMPCLIENT_STATUS_DISCONNECTED;
        if (value < enumTMPClientStatus.getValue()) {
            this.a = enumTMPClientStatus;
            this.h = bVar;
            W();
            g<Boolean> gVar = this.g;
            if (gVar != null && !gVar.k1() && !this.g.j1()) {
                this.g.onError(new TPGeneralNetworkException(bVar.a(), bVar.b()));
            }
            j();
        }
    }

    public q<b.d.d0.f2.e> V(final b.d.d0.f2.d dVar) {
        if (this.a == EnumTMPClientStatus.TMPCLIENT_STATUS_DISCONNECTED) {
            return q.f0(new b.d.d0.f2.e(this.h.a(), this.h.b()));
        }
        if (this.f238c == null) {
            return q.f0(new b.d.d0.f2.e(-1009));
        }
        return this.g.Q0(1L).N(new j() { // from class: b.d.d0.q0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return c2.this.M(dVar, (Boolean) obj);
            }
        }).y(new o0(this)).F(new io.reactivex.g0.g() { // from class: b.d.d0.p0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                c2.this.O((io.reactivex.e0.c) obj);
            }
        });
    }

    public void X(d2 d2Var) {
        this.f237b = d2Var;
    }

    @Override // b.d.d0.y1.b
    public void a(y1 y1Var) {
    }

    @Override // b.d.d0.y1.b
    public void b(b.d.d0.i2.b bVar, y1 y1Var) {
        R(bVar);
    }

    @Override // b.d.d0.e2.c
    public void c(b.d.d0.i2.b bVar, e2 e2Var) {
        R(bVar);
    }

    @Override // b.d.d0.x1.b
    public void d(b.d.d0.i2.b bVar, x1 x1Var) {
        R(bVar);
    }

    @Override // b.d.d0.y1.b
    public void e(y1 y1Var) {
    }

    @Override // b.d.d0.x1.b
    public void f(x1 x1Var) {
    }

    @Override // b.d.d0.x1.b
    public void g(x1 x1Var) {
    }

    @Override // b.d.d0.e2.c
    public void h(e2 e2Var) {
    }

    @Override // b.d.d0.e2.c
    public void i(e2 e2Var) {
    }

    public void j() {
        this.f237b = null;
        this.g = null;
        y1 y1Var = this.f239d;
        if (y1Var != null) {
            y1Var.g();
            this.f239d = null;
        }
        e2 e2Var = this.f241f;
        if (e2Var != null) {
            e2Var.m();
            this.f241f = null;
        }
        x1 x1Var = this.f238c;
        if (x1Var != null) {
            x1Var.a();
            this.f238c = null;
        }
    }

    public void k() {
        g<Boolean> gVar = this.g;
        if (gVar != null && !gVar.k1() && !this.g.j1()) {
            this.g.onError(new TPGeneralNetworkException(-1013));
        }
        R(new b.d.d0.i2.b(-1013));
        j();
    }

    public q<b.d.d0.i2.b> l() {
        if (EnumTMPClientStatus.TMPCLIENT_STATUS_DISCONNECTED != this.a) {
            c cVar = this.f240e;
            if (cVar == null) {
                b.d.d0.i2.b bVar = new b.d.d0.i2.b(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
                R(bVar);
                return q.f0(bVar);
            } else if (cVar.e() == null) {
                b.d.d0.i2.b bVar2 = new b.d.d0.i2.b(-1007);
                R(bVar2);
                return q.f0(bVar2);
            } else {
                b.d.d0.i2.b f2 = this.f240e.f();
                if (f2.a() == 0) {
                    return this.f239d.h().N(new j() { // from class: b.d.d0.l0
                        @Override // io.reactivex.g0.j
                        public final Object apply(Object obj) {
                            return c2.this.s((b.d.d0.i2.b) obj);
                        }
                    }).N(new j() { // from class: b.d.d0.r0
                        @Override // io.reactivex.g0.j
                        public final Object apply(Object obj) {
                            return c2.this.u((b.d.d0.i2.b) obj);
                        }
                    }).E(new io.reactivex.g0.g() { // from class: b.d.d0.m0
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            c2.this.w((b.d.d0.i2.b) obj);
                        }
                    }).C(new io.reactivex.g0.g() { // from class: b.d.d0.t0
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            c2.this.y((Throwable) obj);
                        }
                    }).F(new io.reactivex.g0.g() { // from class: b.d.d0.w0
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            c2.this.A((io.reactivex.e0.c) obj);
                        }
                    });
                }
                R(f2);
                return q.f0(f2);
            }
        } else {
            throw new RuntimeException("TMPClient can't be recycled!");
        }
    }

    public EnumTMPClientStatus n() {
        return this.a;
    }

    public q<Boolean> o() {
        return S((byte) 4).y(new o0(this)).F(new io.reactivex.g0.g() { // from class: b.d.d0.n0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                c2.this.E((io.reactivex.e0.c) obj);
            }
        });
    }
}
