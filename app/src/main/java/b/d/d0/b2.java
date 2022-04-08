package b.d.d0;

import b.d.d0.f2.e;
import b.d.d0.g2.d;
import b.d.d0.i2.a;
import b.d.d0.i2.b;
import com.tplink.tmp.enumerate.EnumTMPBusinessLayerStatus;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;

/* compiled from: TMPAppV3BusinessLayer.java */
/* loaded from: classes3.dex */
public class b2 extends x1 {
    public b2(e2 e2Var) {
        super((byte) 1, (byte) 3, e2Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ e B(a aVar) throws Exception {
        return new e(aVar.a(), aVar.b(), aVar.a() == 0 ? ((d) aVar.e()).b() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(c cVar) throws Exception {
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
        d dVar2 = new d(new b.d.d0.g2.c((byte) 1, (byte) 3), null);
        dVar2.e(dVar.b());
        return q(dVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.d.d0.x1
    public q<b> b() {
        if (this.f367d != EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
            return q.f0(new b()).F(new g() { // from class: b.d.d0.h0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    b2.this.s((c) obj);
                }
            }).E(new g() { // from class: b.d.d0.e0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    b2.this.u((b) obj);
                }
            }).C(new g() { // from class: b.d.d0.g0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    b2.this.w((Throwable) obj);
                }
            });
        }
        throw new RuntimeException("BusinessLayer can't be recycled!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.d.d0.x1
    public q<e> n(final b.d.d0.f2.d dVar) {
        if (this.f367d == EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
            return q.f0(new e(this.g.a(), this.g.b()));
        }
        return this.f368e.Q0(1L).N(new j() { // from class: b.d.d0.i0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return b2.this.y((Boolean) obj);
            }
        }).N(new j() { // from class: b.d.d0.j0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return b2.this.A(dVar, (Boolean) obj);
            }
        }).g0(f0.f257c).L0(io.reactivex.l0.a.c());
    }
}
