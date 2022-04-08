package b.d.a;

import androidx.annotation.NonNull;
import b.d.b.c.g;
import com.google.gson.Gson;
import com.tplink.ata.common.ATAException;
import com.tplink.ata.params.ATAConnectParams;
import com.tplink.ata.params.ATATransferParams;
import com.tplink.ata.result.ATABaseResult;
import com.tplink.ata.result.ATATransferResult;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.passthrough.params.PassThroughParams;
import com.tplink.cloud.bean.passthrough.result.PassThroughResult;
import com.tplink.cloud.define.CloudException;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.e;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.m0.d;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ATAClient.java */
/* loaded from: classes2.dex */
public class s {
    private static final Gson a = new Gson();

    /* renamed from: b  reason: collision with root package name */
    private String f59b;

    /* renamed from: c  reason: collision with root package name */
    private String f60c;

    /* renamed from: d  reason: collision with root package name */
    private String f61d;

    /* renamed from: e  reason: collision with root package name */
    private g f62e;

    /* renamed from: f  reason: collision with root package name */
    private a f63f;
    private long h;
    private io.reactivex.m0.g<byte[]> i = d.n1().l1();
    private b j = new b();
    private b k = new b();
    private AtomicLong l = new AtomicLong(0);
    private ReentrantLock m = new ReentrantLock();
    private AtomicBoolean n = new AtomicBoolean(true);
    private io.reactivex.m0.g<Boolean> o = d.n1().l1();
    private AtomicLong p = new AtomicLong(-1);
    private AtomicLong q = new AtomicLong(0);
    private long g = 1;

    /* compiled from: ATAClient.java */
    /* loaded from: classes2.dex */
    public interface a {
        void b(Throwable th);

        void f(byte[] bArr);
    }

    public s(@NonNull String str, @NonNull String str2, @NonNull com.tplink.cloud.context.b bVar, @NonNull a aVar) {
        this.f59b = str;
        this.f60c = str2;
        this.f61d = bVar.c().getToken() + "-" + new Random().nextInt(16);
        this.f62e = bVar.d();
        this.f63f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C(Throwable th) throws Exception {
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E() throws Exception {
        W();
        if (!this.n.get()) {
            R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean F(List list) throws Exception {
        return !list.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ t H(final List list) throws Exception {
        return Q(h(), O(list)).D(new io.reactivex.g0.g() { // from class: b.d.a.b
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.q(list, (c) obj);
            }
        }, new g(this)).C(new io.reactivex.g0.g() { // from class: b.d.a.e
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.s((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void J(ATATransferResult aTATransferResult) throws Exception {
        W();
        if (aTATransferResult.getRawData() != null && aTATransferResult.getRawData().length > 0) {
            this.f63f.f(aTATransferResult.getRawData());
        }
        if (this.l.get() <= 0) {
            S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ boolean L() throws Exception {
        boolean z = this.q.get() <= 0;
        if (z) {
            this.p.set(-1L);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public /* synthetic */ void N(Long l) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.p.get();
        long j2 = this.q.get();
        if (currentTimeMillis - j >= 150) {
            this.p.compareAndSet(j, currentTimeMillis);
            this.q.compareAndSet(j2, 0L);
            this.o.onNext(Boolean.TRUE);
        }
    }

    private byte[] O(List<byte[]> list) {
        byte[] bArr;
        if (list.size() == 1) {
            bArr = list.get(0);
        } else {
            int i = 0;
            for (byte[] bArr2 : list) {
                i += bArr2.length;
            }
            byte[] bArr3 = new byte[i];
            int i2 = 0;
            for (byte[] bArr4 : list) {
                System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
                i2 += bArr4.length;
            }
            bArr = bArr3;
        }
        this.q.addAndGet(-bArr.length);
        return bArr;
    }

    private q<ATABaseResult> P() {
        return this.f62e.k0(this.f60c, new CloudParams<>("passthrough", b())).i(a(ATABaseResult.class));
    }

    private q<ATATransferResult> Q(long j, byte[] bArr) {
        return this.f62e.k0(this.f60c, new CloudParams<>("passthrough", c(j, bArr))).i(a(ATATransferResult.class));
    }

    private void R() {
        this.k.b(q.W0(g(), TimeUnit.MILLISECONDS).L(new l() { // from class: b.d.a.a
            @Override // io.reactivex.g0.l
            public final boolean test(Object obj) {
                return s.this.w((Long) obj);
            }
        }).N(new j() { // from class: b.d.a.m
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return s.this.y((Long) obj);
            }
        }).l0(io.reactivex.l0.a.e()).A(new g(this)).I0(new io.reactivex.g0.g() { // from class: b.d.a.n
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.A((ATATransferResult) obj);
            }
        }, new io.reactivex.g0.g() { // from class: b.d.a.j
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.C((Throwable) obj);
            }
        }, new io.reactivex.g0.a() { // from class: b.d.a.c
            @Override // io.reactivex.g0.a
            public final void run() {
                s.this.E();
            }
        }));
    }

    private void S() {
        this.k.d();
        R();
    }

    private void T() {
        this.j.b(this.i.b(this.o).L(q.f57c).l0(io.reactivex.l0.a.c()).N(new j() { // from class: b.d.a.p
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return s.this.H((List) obj);
            }
        }).G0(new io.reactivex.g0.g() { // from class: b.d.a.h
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.J((ATATransferResult) obj);
            }
        }));
    }

    private void U() {
        this.j.b(q.W0(150L, TimeUnit.MILLISECONDS).s0(new e() { // from class: b.d.a.d
            @Override // io.reactivex.g0.e
            public final boolean a() {
                return s.this.L();
            }
        }).G0(new io.reactivex.g0.g() { // from class: b.d.a.k
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.N((Long) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        if (this.m.isHeldByCurrentThread()) {
            this.m.unlock();
        }
    }

    private <T extends ATABaseResult> u<CloudResult<PassThroughResult>, T> a(final Class<T> cls) {
        return new u() { // from class: b.d.a.f
            @Override // io.reactivex.u
            public final t a(q qVar) {
                return s.this.m(cls, qVar);
            }
        };
    }

    private PassThroughParams b() {
        return new PassThroughParams(this.f59b, new ATAConnectParams(this.f61d));
    }

    private PassThroughParams c(long j, byte[] bArr) {
        return new PassThroughParams(this.f59b, new ATATransferParams(this.f61d, j, bArr));
    }

    private long g() {
        if (this.l.get() > 0 || this.m.isLocked()) {
            return AbstractTrafficShapingHandler.DEFAULT_MAX_TIME;
        }
        long j = this.h;
        if (j <= 1) {
            return 500L;
        }
        if (j <= 3) {
            return 1000L;
        }
        if (j <= 6) {
            return j * 500;
        }
        long j2 = 3000 * (j - 5);
        return j2 > AbstractTrafficShapingHandler.DEFAULT_MAX_TIME ? AbstractTrafficShapingHandler.DEFAULT_MAX_TIME : j2;
    }

    private long h() {
        long j = this.g;
        this.g = 1 + j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Throwable th) {
        e();
        this.f63f.b(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ t m(final Class cls, q qVar) {
        return qVar.g0(new j() { // from class: b.d.a.r
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return s.t(cls, (CloudResult) obj);
            }
        }).v0(1L, o.f55c).C(new io.reactivex.g0.g() { // from class: b.d.a.l
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.i((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(ATABaseResult aTABaseResult) throws Exception {
        this.n.set(false);
        T();
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void q(List list, c cVar) throws Exception {
        this.m.lock();
        this.h = 0L;
        this.n.set(false);
        this.l.addAndGet(-list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(Throwable th) throws Exception {
        W();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ATABaseResult t(Class cls, CloudResult cloudResult) throws Exception {
        ATABaseResult aTABaseResult = (ATABaseResult) a.g(((PassThroughResult) cloudResult.getResult()).getResponseData(), cls);
        if (aTABaseResult != null) {
            int errCode = aTABaseResult.getErrCode();
            if (errCode == 0 || errCode == 1) {
                return aTABaseResult;
            }
            throw new ATAException(errCode);
        }
        throw new ATAException(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean u(Throwable th) throws Exception {
        return (th instanceof CloudException) && ((CloudException) th).getErrCode() == -20002;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ boolean w(Long l) throws Exception {
        return this.l.get() <= 0 && this.m.tryLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ q y(Long l) throws Exception {
        return Q(h(), new byte[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(ATATransferResult aTATransferResult) throws Exception {
        if (aTATransferResult.getRawData() == null || aTATransferResult.getRawData().length <= 0) {
            this.h++;
            return;
        }
        this.h = 0L;
        W();
        this.f63f.f(aTATransferResult.getRawData());
    }

    public int V(byte[] bArr) {
        if (this.p.get() == -1) {
            this.p.set(System.currentTimeMillis());
            U();
        }
        long length = this.q.get() + bArr.length;
        if (((long) Math.ceil(length / 3.0d)) * 4 > 30720) {
            this.q.compareAndSet(length - bArr.length, 0L);
            this.p.set(System.currentTimeMillis());
            this.o.onNext(Boolean.TRUE);
        } else {
            this.q.addAndGet(bArr.length);
        }
        this.l.incrementAndGet();
        this.i.onNext(bArr);
        return bArr.length;
    }

    public void d() {
        this.n.compareAndSet(false, true);
    }

    public void e() {
        this.n.set(true);
        this.j.d();
        this.k.d();
        if (!this.i.j1() && !this.i.k1()) {
            this.i.onComplete();
        }
        if (!this.o.j1() && !this.o.k1()) {
            this.o.onComplete();
        }
    }

    public q<ATABaseResult> f() {
        return P().E(new io.reactivex.g0.g() { // from class: b.d.a.i
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                s.this.o((ATABaseResult) obj);
            }
        });
    }
}
