package b.d.d0;

import b.d.d0.e2;
import b.d.d0.f2.c;
import b.d.d0.f2.e;
import b.d.d0.g2.d;
import b.d.d0.i2.a;
import com.tplink.tmp.enumerate.EnumTMPBusinessLayerStatus;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.g0.j;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TMPAbstractBusinessLayer.java */
/* loaded from: classes3.dex */
public abstract class x1 implements e2.c {
    private byte a;

    /* renamed from: b  reason: collision with root package name */
    private byte f365b;

    /* renamed from: c  reason: collision with root package name */
    private e2 f366c;

    /* renamed from: d  reason: collision with root package name */
    protected EnumTMPBusinessLayerStatus f367d = EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_IDLE;

    /* renamed from: e  reason: collision with root package name */
    protected g<Boolean> f368e = io.reactivex.m0.b.n1().l1();

    /* renamed from: f  reason: collision with root package name */
    protected g<Boolean> f369f = io.reactivex.m0.b.n1().l1();
    protected b.d.d0.i2.b g = new b.d.d0.i2.b(-1);
    private final List<b> h = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TMPAbstractBusinessLayer.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumTMPBusinessLayerStatus.values().length];
            a = iArr;
            try {
                iArr[EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: TMPAbstractBusinessLayer.java */
    /* loaded from: classes3.dex */
    public interface b {
        void d(b.d.d0.i2.b bVar, x1 x1Var);

        void f(x1 x1Var);

        void g(x1 x1Var);
    }

    public x1(byte b2, byte b3, e2 e2Var) {
        this.a = b2;
        this.f365b = b3;
        this.f366c = e2Var;
        e2Var.T(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ t e(d dVar, Boolean bool) throws Exception {
        return this.f366c.e0(new b.d.d0.g2.g(null, dVar.c()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ b.d.d0.i2.a g(b.d.d0.i2.a aVar) throws Exception {
        if (aVar.a() != 0) {
            return new b.d.d0.i2.a(aVar.a());
        }
        b.d.d0.g2.g gVar = (b.d.d0.g2.g) aVar.e();
        b.d.d0.i2.a aVar2 = new b.d.d0.i2.a(aVar.a(), aVar.b());
        if (gVar.a() == null || gVar.a().length < 2) {
            aVar2.c(-1214);
            aVar2.d(c.g.get(-1214));
            return aVar2;
        }
        b.d.d0.g2.c cVar = new b.d.d0.g2.c(gVar.a());
        if (this.a != cVar.a()) {
            aVar2.c(-1212);
            aVar2.d(c.g.get(-1212));
            m(aVar2);
            return aVar2;
        } else if (this.f365b != cVar.b()) {
            aVar2.c(-1213);
            aVar2.d(c.g.get(-1213));
            m(aVar2);
            return aVar2;
        } else {
            d dVar = new d(gVar.a());
            if (gVar.a().length > 2) {
                int length = gVar.a().length - 2;
                byte[] bArr = new byte[length];
                System.arraycopy(gVar.a(), 2, bArr, 0, length);
                dVar.e(bArr);
            }
            aVar2.f(dVar);
            return aVar2;
        }
    }

    private void o() {
        synchronized (this.h) {
            for (b bVar : this.h) {
                p(bVar);
            }
        }
    }

    private void p(b bVar) {
        int i = a.a[this.f367d.ordinal()];
        if (i == 1) {
            bVar.f(this);
        } else if (i == 2) {
            bVar.g(this);
        } else if (i == 3) {
            bVar.d(this.g, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f366c = null;
        this.f368e = null;
        this.f369f = null;
        synchronized (this.h) {
            this.h.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract q<b.d.d0.i2.b> b();

    @Override // b.d.d0.e2.c
    public void c(b.d.d0.i2.b bVar, e2 e2Var) {
        g<Boolean> gVar = this.f368e;
        if (gVar != null && !gVar.k1() && !this.f368e.j1()) {
            this.f368e.onError(new TPGeneralNetworkException(bVar.a(), bVar.b()));
        }
        this.g = bVar;
        this.f367d = EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED;
    }

    @Override // b.d.d0.e2.c
    public void h(e2 e2Var) {
    }

    @Override // b.d.d0.e2.c
    public void i(e2 e2Var) {
        this.f368e.onNext(Boolean.TRUE);
    }

    public void j(b bVar) {
        synchronized (this.h) {
            if (!this.h.contains(bVar)) {
                this.h.add(bVar);
            }
        }
        p(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        int value = this.f367d.getValue();
        EnumTMPBusinessLayerStatus enumTMPBusinessLayerStatus = EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_CONNECTED;
        if (value < enumTMPBusinessLayerStatus.getValue()) {
            this.f367d = enumTMPBusinessLayerStatus;
            o();
            this.f369f.onNext(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        int value = this.f367d.getValue();
        EnumTMPBusinessLayerStatus enumTMPBusinessLayerStatus = EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_CONNECTING;
        if (value < enumTMPBusinessLayerStatus.getValue()) {
            this.f367d = enumTMPBusinessLayerStatus;
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(b.d.d0.i2.b bVar) {
        int value = this.f367d.getValue();
        EnumTMPBusinessLayerStatus enumTMPBusinessLayerStatus = EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED;
        if (value < enumTMPBusinessLayerStatus.getValue()) {
            this.f367d = enumTMPBusinessLayerStatus;
            this.g = bVar;
            o();
            g<Boolean> gVar = this.f369f;
            if (gVar != null && !gVar.k1() && !this.f369f.j1()) {
                this.f369f.onError(new TPGeneralNetworkException(bVar.a(), bVar.b()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract q<e> n(b.d.d0.f2.d dVar);

    public q<b.d.d0.i2.a<d>> q(final d dVar) {
        if (this.f367d == EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
            return q.f0(new b.d.d0.i2.a(this.g.a(), this.g.b()));
        }
        if (this.f366c == null) {
            return q.f0(new b.d.d0.i2.a(-1011));
        }
        if (dVar.a() == null) {
            dVar.d(new b.d.d0.g2.c(this.a, this.f365b));
        }
        return this.f368e.Q0(1L).N(new j() { // from class: b.d.d0.k
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return x1.this.e(dVar, (Boolean) obj);
            }
        }).g0(new j() { // from class: b.d.d0.j
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return x1.this.g((a) obj);
            }
        });
    }
}
