package b.d.d0;

import b.d.d0.h2.b.c;
import b.d.d0.i2.b;
import com.tplink.ssh2.EnumSSH2Status;
import com.tplink.ssh2.a0;
import com.tplink.ssh2.w;
import com.tplink.ssh2.x;
import com.tplink.tmp.enumerate.EnumTMPTransportStatus;
import com.tplink.tmp.enumerate.EnumTMPTransportType;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;

/* compiled from: SSH2Transport.java */
/* loaded from: classes3.dex */
public class w1 extends y1 implements w {
    private x i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w1(EnumTMPTransportType enumTMPTransportType, c cVar) {
        super(enumTMPTransportType, cVar);
        this.i = new x(cVar.h(), cVar.c(), cVar.f(), cVar.g(), cVar.e(), this, cVar.d());
    }

    private int B(int i) {
        switch (i) {
            case 1:
                return -1400;
            case 2:
                return -1401;
            case 3:
                return -1402;
            case 4:
                return -1403;
            case 5:
                return -1404;
            case 6:
                return -1405;
            case 7:
                return -1406;
            case 8:
                return -1407;
            case 9:
                return -1408;
            case 10:
                return -1409;
            case 11:
                return -1410;
            case 12:
                return -1411;
            case 13:
                return -1412;
            default:
                return i;
        }
    }

    private b C(a0 a0Var) {
        return new b(B(a0Var.a()), a0Var.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ b w(a0 a0Var) throws Exception {
        b C = C(a0Var);
        if (a0Var.a() == 0) {
            s(EnumTMPTransportStatus.TMP_TRANSPORT_STATUS_CONNECTED);
        } else {
            t(C, EnumTMPTransportStatus.TMP_TRANSPORT_STATUS_DISCONNECTED);
            g();
        }
        return C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(io.reactivex.e0.c cVar) throws Exception {
        s(EnumTMPTransportStatus.TMP_TRANSPORT_STATUS_CONNECTING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ b A(a0 a0Var) throws Exception {
        b C = C(a0Var);
        if (a0Var.a() != 0) {
            t(C, EnumTMPTransportStatus.TMP_TRANSPORT_STATUS_DISCONNECTED);
        }
        return C;
    }

    @Override // com.tplink.ssh2.w
    public void c(byte[] bArr) {
        r(bArr);
    }

    @Override // com.tplink.ssh2.w
    public void d(a0 a0Var, EnumSSH2Status enumSSH2Status) {
        if (enumSSH2Status == EnumSSH2Status.SSH2_STATUS_DISCONNECTED) {
            t(C(a0Var), EnumTMPTransportStatus.TMP_TRANSPORT_STATUS_DISCONNECTED);
        }
    }

    @Override // b.d.d0.y1
    public void g() {
        super.g();
        this.i.a();
    }

    @Override // b.d.d0.y1
    public q<b> h() {
        return this.i.b().g0(new j() { // from class: b.d.d0.g
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return w1.this.w((a0) obj);
            }
        }).F(new g() { // from class: b.d.d0.h
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                w1.this.y((io.reactivex.e0.c) obj);
            }
        });
    }

    @Override // b.d.d0.y1
    public q<b> u(byte[] bArr) {
        return this.i.l(bArr).g0(new j() { // from class: b.d.d0.i
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return w1.this.A((a0) obj);
            }
        });
    }
}
