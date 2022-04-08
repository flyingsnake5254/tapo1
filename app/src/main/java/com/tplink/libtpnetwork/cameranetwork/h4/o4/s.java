package com.tplink.libtpnetwork.cameranetwork.h4.o4;

import android.text.TextUtils;
import com.tplink.libtpnetwork.cameranetwork.business.model.CameraErrorCode;
import com.tplink.libtpnetwork.cameranetwork.common.a;
import com.tplink.libtpnetwork.cameranetwork.h4.h4;
import com.tplink.libtpnetwork.cameranetwork.h4.j4;
import com.tplink.libtpnetwork.cameranetwork.model.Account;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/* compiled from: LocalCameraTransport.java */
/* loaded from: classes3.dex */
public class s extends h4 {

    /* renamed from: c  reason: collision with root package name */
    private u f14829c;

    /* renamed from: d  reason: collision with root package name */
    private String f14830d;

    /* renamed from: e  reason: collision with root package name */
    private t f14831e;

    /* renamed from: f  reason: collision with root package name */
    private Account f14832f;
    private volatile boolean g;
    private volatile long h;
    private volatile boolean i;
    private g<com.tplink.libtpnetwork.cameranetwork.common.a<String>> j = io.reactivex.m0.b.n1().l1();
    private final Object k = new Object();
    private io.reactivex.e0.b l = new io.reactivex.e0.b();
    private q<String> m = new a();
    private q<String> n;
    private q<String> o;

    /* compiled from: LocalCameraTransport.java */
    /* loaded from: classes3.dex */
    class a extends q<String> {
        a() {
        }

        @Override // io.reactivex.q
        protected void K0(v<? super String> vVar) {
            vVar.onNext(s.this.f14830d);
            vVar.onComplete();
        }
    }

    /* compiled from: LocalCameraTransport.java */
    /* loaded from: classes3.dex */
    class b implements j<Integer, t<String>> {
        b() {
        }

        /* renamed from: a */
        public t<String> apply(Integer num) throws Exception {
            if (s.this.i) {
                throw new Exception("needSyncPassword");
            } else if (s.this.f14832f != null && s.this.f14831e != null) {
                return s.this.f14831e.c(s.this.f14832f).g0(b.f14812c);
            } else {
                throw new Exception("param is null");
            }
        }
    }

    public s(u uVar) {
        q<String> N = q.f0(0).N(new b());
        this.n = N;
        this.o = q.j(this.m, N).L(f.f14816c).M().p();
        this.f14829c = uVar;
        this.f14832f = new Account("admin", uVar.c(), false);
        this.f14831e = new j4(null).a(uVar.d(), null, null, uVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A4 */
    public /* synthetic */ void B4(c cVar) throws Exception {
        V4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C4 */
    public /* synthetic */ t D4(Request request, com.tplink.libtpnetwork.cameranetwork.common.a aVar) throws Exception {
        if (aVar.a() == null) {
            return q.J(aVar.b());
        }
        return this.f14831e.d((String) aVar.a(), request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E4 */
    public /* synthetic */ void F4(Throwable th) throws Exception {
        th.printStackTrace();
        l4(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G4 */
    public /* synthetic */ void H4(c cVar) throws Exception {
        V4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I4 */
    public /* synthetic */ t J4(Request request, com.tplink.libtpnetwork.cameranetwork.common.a aVar) throws Exception {
        if (aVar.a() == null) {
            return q.J(aVar.b());
        }
        return this.f14831e.e((String) aVar.a(), request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K4 */
    public /* synthetic */ void L4(Throwable th) throws Exception {
        th.printStackTrace();
        l4(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M4 */
    public /* synthetic */ void N4() throws Exception {
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O4 */
    public /* synthetic */ void P4(String str) throws Exception {
        this.i = false;
        this.f14830d = str;
        this.h = System.currentTimeMillis();
        this.j.onNext(new com.tplink.libtpnetwork.cameranetwork.common.a<>(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q4 */
    public /* synthetic */ void R4(Throwable th) throws Exception {
        this.f14830d = null;
        this.j.onNext(new com.tplink.libtpnetwork.cameranetwork.common.a<>(th));
        th.printStackTrace();
        if ((th instanceof CameraException) && CameraErrorCode.SESSION_EXPIRED.isEqual(((CameraException) th).getErrorCode())) {
            this.i = true;
            o3(false);
        }
    }

    private void V4() {
        if (TextUtils.isEmpty(this.f14830d)) {
            synchronized (this.k) {
                if (!this.g || TextUtils.isEmpty(this.f14830d)) {
                    this.g = true;
                    this.l.b(this.o.y(new io.reactivex.g0.a() { // from class: com.tplink.libtpnetwork.cameranetwork.h4.o4.h
                        @Override // io.reactivex.g0.a
                        public final void run() {
                            s.this.N4();
                        }
                    }).H0(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.h4.o4.d
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            s.this.P4((String) obj);
                        }
                    }, new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.h4.o4.k
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            s.this.R4((Throwable) obj);
                        }
                    }));
                }
            }
            return;
        }
        this.j.onNext(new com.tplink.libtpnetwork.cameranetwork.common.a<>(this.f14830d));
    }

    private void l4(Throwable th) {
        if (q4(th)) {
            o3(false);
        }
    }

    private boolean o4() {
        return System.currentTimeMillis() - this.h <= 5000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p4(Throwable th) {
        if (th instanceof CameraException) {
            CameraException cameraException = (CameraException) th;
            if (CameraErrorCode.SESSION_EXPIRED.isEqual(cameraException.getErrorCode())) {
                if (!this.g && !o4()) {
                    this.f14830d = null;
                    this.f14832f = new Account("admin", this.f14829c.c(), false);
                }
                return true;
            } else if (CameraErrorCode.FFS_NONE_PWD.isEqual(cameraException.getErrorCode())) {
                if (!this.g && !o4()) {
                    this.f14830d = null;
                    this.f14832f = new Account("admin", this.f14829c.b(), false);
                }
                return true;
            }
        }
        return false;
    }

    private boolean q4(Throwable th) {
        return (th instanceof ProtocolException) || (th instanceof UnknownHostException) || (th instanceof ConnectException) || (th instanceof SocketException) || (th instanceof SocketTimeoutException) || ((th instanceof HttpException) && ((HttpException) th).code() >= 300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r4 */
    public /* synthetic */ void s4(c cVar) throws Exception {
        V4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t4 */
    public /* synthetic */ t u4(com.tplink.libtpnetwork.cameranetwork.common.a aVar) throws Exception {
        if (aVar.a() == null) {
            return q.J(aVar.b());
        }
        return this.f14831e.a((String) aVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v4 */
    public /* synthetic */ void w4(c cVar) throws Exception {
        V4();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ t x4(com.tplink.libtpnetwork.cameranetwork.common.a aVar) throws Exception {
        if (aVar.a() == null) {
            return q.J(aVar.b());
        }
        return q.f0(aVar.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean y4(String str) throws Exception {
        return !TextUtils.isEmpty(str);
    }

    public q<String> S4(Account account) {
        if (account != null) {
            if (this.f14832f == null) {
                this.f14832f = account;
            } else if (!account.getPassword().equals(this.f14832f.getPassword())) {
                this.f14832f = account;
            }
        }
        return this.j.Q0(1L).F(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.h4.o4.i
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.w4((c) obj);
            }
        }).N(a.f14811c);
    }

    public boolean T4() {
        return this.i;
    }

    public void U4() {
        this.i = false;
        o3(true);
    }

    public void W4(u uVar) {
        if (!TextUtils.equals(this.f14829c.d(), uVar.d())) {
            this.f14831e = new j4(null).a(uVar.d(), null, null, uVar.a());
        }
        if (!TextUtils.equals(this.f14829c.c(), uVar.c())) {
            this.f14832f = new Account("admin", uVar.c(), false);
        }
        this.f14829c = uVar;
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.h4.h4
    protected q<Response<Wrappers>> c3(final Request<MultipleRequest> request) {
        return this.j.Q0(1L).F(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.h4.o4.o
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.B4((c) obj);
            }
        }).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.h4.o4.l
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return s.this.D4(request, (a) obj);
            }
        }).v0(1L, new p(this)).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.h4.o4.n
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.F4((Throwable) obj);
            }
        });
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.h4.h4
    protected q<Response<MultipleResponse>> d3(final Request<MultipleRequest> request) {
        return this.j.Q0(1L).F(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.h4.o4.e
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.H4((c) obj);
            }
        }).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.h4.o4.m
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return s.this.J4(request, (a) obj);
            }
        }).v0(1L, new p(this)).C(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.h4.o4.j
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.L4((Throwable) obj);
            }
        });
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.h4.h4
    protected q<Response<Wrappers>> e3(Request request) {
        return this.f14831e.f(request);
    }

    public q<ResponseBody> m4() {
        return this.j.Q0(1L).F(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.h4.o4.g
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.s4((c) obj);
            }
        }).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.h4.o4.c
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return s.this.u4((a) obj);
            }
        });
    }

    public u n4() {
        return this.f14829c;
    }
}
