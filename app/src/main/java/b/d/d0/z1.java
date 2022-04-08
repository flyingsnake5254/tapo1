package b.d.d0;

import b.d.d0.f2.c;
import b.d.d0.f2.e;
import b.d.d0.g2.d;
import b.d.d0.i2.a;
import b.d.d0.i2.b;
import com.tplink.tmp.enumerate.EnumTMPBusinessLayerStatus;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;

/* compiled from: TMPAppV1BusinessLayer.java */
/* loaded from: classes3.dex */
public class z1 extends x1 {
    public z1(e2 e2Var) {
        super((byte) 1, (byte) 1, e2Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ e B(a aVar) throws Exception {
        return new e(aVar.a(), aVar.b(), aVar.a() == 0 ? ((d) aVar.e()).b() : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ a C(a aVar) throws Exception {
        if (aVar.a() != 0) {
            return new a(aVar.a());
        }
        d dVar = (d) aVar.e();
        a aVar2 = new a(aVar.a(), aVar.b());
        if (dVar.b() == null || dVar.b().length < 6) {
            aVar2.c(-1217);
            aVar2.d(c.g.get(-1217));
            return aVar2;
        }
        b.d.d0.g2.a aVar3 = new b.d.d0.g2.a(dVar.a(), dVar.b());
        b a = b.d.d0.f2.b.a(aVar3.d());
        if (a.a() != 0) {
            return new a(a.a());
        }
        d dVar2 = new d(aVar3, null);
        if (dVar.b().length > 6) {
            int length = dVar.b().length - 6;
            byte[] bArr = new byte[length];
            System.arraycopy(dVar.b(), 6, bArr, 0, length);
            dVar2.e(bArr);
        }
        aVar2.f(dVar2);
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(io.reactivex.e0.c cVar) throws Exception {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void u(b bVar) throws Exception {
        if (bVar.a() == 0) {
            k();
        } else {
            m(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w(Throwable th) throws Exception {
        if (th instanceof TPGeneralNetworkException) {
            TPGeneralNetworkException tPGeneralNetworkException = (TPGeneralNetworkException) th;
            m(new b(tPGeneralNetworkException.getErrCode(), tPGeneralNetworkException.getErrMsg()));
            return;
        }
        m(new b(-1, th.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ t y(Boolean bool) throws Exception {
        return this.f369f.Q0(1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ t A(b.d.d0.f2.d dVar, Boolean bool) throws Exception {
        return q(new d(new b.d.d0.g2.a((byte) 1, (byte) 1, dVar.a(), (byte) 0), dVar.b()));
    }

    @Override // b.d.d0.x1
    public q<b> b() {
        if (this.f367d != EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
            return q.f0(new b()).F(new g() { // from class: b.d.d0.p
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    z1.this.s((io.reactivex.e0.c) obj);
                }
            }).E(new g() { // from class: b.d.d0.n
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    z1.this.u((b) obj);
                }
            }).C(new g() { // from class: b.d.d0.r
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    z1.this.w((Throwable) obj);
                }
            });
        }
        throw new RuntimeException("BusinessLayer can't be recycled!");
    }

    @Override // b.d.d0.x1
    public q<e> n(final b.d.d0.f2.d dVar) {
        if (this.f367d == EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
            return q.f0(new e(this.g.a(), this.g.b()));
        }
        return this.f368e.Q0(1L).N(new j() { // from class: b.d.d0.o
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return z1.this.y((Boolean) obj);
            }
        }).N(new j() { // from class: b.d.d0.s
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return z1.this.A(dVar, (Boolean) obj);
            }
        }).g0(q.f338c).L0(io.reactivex.l0.a.c());
    }

    @Override // b.d.d0.x1
    public q<a<d>> q(d dVar) {
        return super.q(dVar).g0(t.f349c);
    }
}
