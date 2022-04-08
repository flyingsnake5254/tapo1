package com.tplink.libtpnetwork.IoTNetwork.y.c;

import android.annotation.SuppressLint;
import b.d.d0.c2;
import b.d.d0.d2;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTRequest;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTResponse;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.tmp.enumerate.EnumTMPClientStatus;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: IoTBLETransport.java */
/* loaded from: classes3.dex */
public class a extends com.tplink.libtpnetwork.IoTNetwork.y.a implements d2 {

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Long, r<TPIoTResponse>> f13670b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private c f13671c;

    /* renamed from: d  reason: collision with root package name */
    private c2 f13672d;

    /* renamed from: e  reason: collision with root package name */
    private b f13673e;
    private volatile boolean g;

    /* renamed from: f  reason: collision with root package name */
    private final List<TPIoTRequest> f13674f = Collections.synchronizedList(new ArrayList());
    private ExecutorService h = Executors.newSingleThreadExecutor();

    /* compiled from: IoTBLETransport.java */
    /* renamed from: com.tplink.libtpnetwork.IoTNetwork.y.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0268a implements s<TPIoTResponse> {
        final /* synthetic */ TPIoTRequest a;

        C0268a(TPIoTRequest tPIoTRequest) {
            this.a = tPIoTRequest;
        }

        @Override // io.reactivex.s
        public void subscribe(r<TPIoTResponse> rVar) throws Exception {
            a.f13670b.put(Long.valueOf(this.a.getRequestID()), rVar);
            a.this.q(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTBLETransport.java */
    /* loaded from: classes3.dex */
    public class b implements g<TPIoTResponse> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TPIoTRequest f13676c;

        b(TPIoTRequest tPIoTRequest) {
            this.f13676c = tPIoTRequest;
        }

        /* renamed from: a */
        public void accept(TPIoTResponse tPIoTResponse) throws Exception {
            r rVar = (r) a.f13670b.remove(Long.valueOf(this.f13676c.getRequestID()));
            if (rVar != null) {
                rVar.onNext(tPIoTResponse);
                rVar.onComplete();
            }
            a.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTBLETransport.java */
    /* loaded from: classes3.dex */
    public class c implements g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TPIoTRequest f13678c;

        c(TPIoTRequest tPIoTRequest) {
            this.f13678c = tPIoTRequest;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            r rVar = (r) a.f13670b.remove(Long.valueOf(this.f13678c.getRequestID()));
            if (rVar != null) {
                rVar.onError(th);
            }
            a.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTBLETransport.java */
    /* loaded from: classes3.dex */
    public class d implements j<b.d.d0.f2.e, TPIoTResponse> {
        d() {
        }

        /* renamed from: a */
        public TPIoTResponse apply(b.d.d0.f2.e eVar) throws Exception {
            TPIoTResponse tPIoTResponse = new TPIoTResponse();
            tPIoTResponse.setErrorCode(eVar.a());
            tPIoTResponse.setErrorMsg(eVar.b());
            if (eVar.c() != null) {
                tPIoTResponse.setResult(new String(eVar.c()));
            }
            return tPIoTResponse;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoTBLETransport.java */
    /* loaded from: classes3.dex */
    public class e implements io.reactivex.g0.a {
        e() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            a.this.g = false;
            a.this.n();
        }
    }

    public a(c cVar) {
        this.f13671c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void m() {
        io.reactivex.a.e().C(io.reactivex.l0.a.b(this.h)).z(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        synchronized (this.f13674f) {
            if (!this.f13674f.isEmpty()) {
                TPIoTRequest remove = this.f13674f.remove(0);
                if (remove != null) {
                    r(remove);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void q(TPIoTRequest tPIoTRequest) {
        if (this.f13672d == null || !d()) {
            r<TPIoTResponse> remove = f13670b.remove(Long.valueOf(tPIoTRequest.getRequestID()));
            if (remove != null) {
                TPIoTResponse tPIoTResponse = new TPIoTResponse();
                tPIoTResponse.setErrorCode(1);
                remove.onNext(tPIoTResponse);
                remove.onComplete();
                return;
            }
            return;
        }
        this.f13674f.add(tPIoTRequest);
        if (!this.g) {
            n();
        }
    }

    @SuppressLint({"CheckResult"})
    private void r(TPIoTRequest tPIoTRequest) {
        if (this.f13672d == null) {
            this.g = false;
            return;
        }
        this.g = true;
        this.f13672d.V(new b.d.d0.f2.d((short) 0, i.g(tPIoTRequest, TPIoTRequest.class).getBytes())).g0(new d()).H0(new b(tPIoTRequest), new c(tPIoTRequest));
    }

    @Override // b.d.d0.d2
    public void a(b.d.d0.i2.b bVar, c2 c2Var) {
        b bVar2 = this.f13673e;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
        for (r<TPIoTResponse> rVar : f13670b.values()) {
            rVar.onError(new TPGeneralNetworkException(bVar.a(), bVar.b()));
        }
        f13670b.clear();
        o();
    }

    @Override // b.d.d0.d2
    public void b(c2 c2Var) {
    }

    @Override // b.d.d0.d2
    public void c(c2 c2Var) {
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.y.a
    public void e() {
        super.e();
        this.f13671c = null;
        o();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.y.a
    public <P> q<TPIoTResponse> f(TPIoTRequest<P> tPIoTRequest) {
        return q.m(new C0268a(tPIoTRequest)).L0(io.reactivex.l0.a.b(this.h));
    }

    public void o() {
        c2 c2Var = this.f13672d;
        if (c2Var != null) {
            c2Var.k();
            this.f13672d = null;
        }
    }

    public boolean p() {
        c2 c2Var = this.f13672d;
        return c2Var != null && c2Var.n() == EnumTMPClientStatus.TMPCLIENT_STATUS_CONNECTED;
    }

    public void s(b bVar) {
        this.f13673e = bVar;
    }

    public void t(c2 c2Var) {
        this.f13672d = c2Var;
        if (c2Var != null) {
            c2Var.X(this);
        }
    }

    public void u(c cVar) {
        this.f13671c = cVar;
    }
}
