package b.d.d0;

import b.d.a.s;
import b.d.d0.h2.b.a;
import b.d.d0.i2.b;
import com.tplink.ata.common.ATAException;
import com.tplink.ata.result.ATABaseResult;
import com.tplink.cloud.define.CloudException;
import com.tplink.tmp.enumerate.EnumTMPTransportStatus;
import com.tplink.tmp.enumerate.EnumTMPTransportType;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;

/* compiled from: ATATransport.java */
/* loaded from: classes3.dex */
public class u1 extends y1 implements s.a {
    private s i;

    /* JADX INFO: Access modifiers changed from: protected */
    public u1(a aVar) {
        super(EnumTMPTransportType.TRANSPORT_TYPE_ATA, aVar);
        this.i = new s(aVar.d(), aVar.e(), aVar.c(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ b w(ATABaseResult aTABaseResult) throws Exception {
        s(EnumTMPTransportStatus.TMP_TRANSPORT_STATUS_CONNECTED);
        return new b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(c cVar) throws Exception {
        s(EnumTMPTransportStatus.TMP_TRANSPORT_STATUS_CONNECTING);
    }

    @Override // b.d.a.s.a
    public void b(Throwable th) {
        int i = -1300;
        if (th instanceof CloudException) {
            i = ((CloudException) th).getErrCode();
        } else if (th instanceof ATAException) {
            int errorCode = ((ATAException) th).getErrorCode();
            if (errorCode == 1) {
                i = -1301;
            } else if (errorCode == 2) {
                i = -1302;
            } else if (errorCode == 3) {
                i = -1303;
            } else if (errorCode == 4) {
                i = -1304;
            } else if (errorCode == 5) {
                i = -1305;
            }
        }
        t(new b(i), EnumTMPTransportStatus.TMP_TRANSPORT_STATUS_DISCONNECTED);
    }

    @Override // b.d.a.s.a
    public void f(byte[] bArr) {
        r(bArr);
    }

    @Override // b.d.d0.y1
    public void g() {
        this.i.e();
        super.g();
    }

    @Override // b.d.d0.y1
    public q<b> h() {
        return this.i.f().g0(new j() { // from class: b.d.d0.b
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return u1.this.w((ATABaseResult) obj);
            }
        }).q0(new b(-1)).F(new g() { // from class: b.d.d0.a
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                u1.this.y((c) obj);
            }
        });
    }

    @Override // b.d.d0.y1
    public q<b> u(byte[] bArr) {
        this.i.V(bArr);
        return q.f0(new b(0));
    }

    public void z() {
        this.i.d();
    }
}
