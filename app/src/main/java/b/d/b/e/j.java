package b.d.b.e;

import b.d.b.e.j;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.define.CloudException;
import e.b.a;
import io.reactivex.b0;
import io.reactivex.c0;
import io.reactivex.e;
import io.reactivex.f;
import io.reactivex.h;
import io.reactivex.l;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.p;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import io.reactivex.x;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.adapter.rxjava2.g;
import retrofit2.c;
import retrofit2.r;

/* compiled from: CloudCallAdapterFactory.java */
/* loaded from: classes2.dex */
public final class j extends c.a {
    private final g a;

    /* renamed from: b  reason: collision with root package name */
    private final b f95b;

    /* compiled from: CloudCallAdapterFactory.java */
    /* loaded from: classes2.dex */
    final class a<R> implements c<R, Object> {
        private final c<R, Object> a;

        a(c<R, Object> cVar) {
            this.a = cVar;
        }

        private f c() {
            return new f() { // from class: b.d.b.e.a
                @Override // io.reactivex.f
                public final e a(io.reactivex.a aVar) {
                    return j.a.this.i(aVar);
                }
            };
        }

        private l<Object, Object> d() {
            return new l() { // from class: b.d.b.e.d
                @Override // io.reactivex.l
                public final a a(h hVar) {
                    return j.a.this.k(hVar);
                }
            };
        }

        private p<Object, Object> e() {
            return new p() { // from class: b.d.b.e.e
                @Override // io.reactivex.p
                public final o a(m mVar) {
                    return j.a.this.m(mVar);
                }
            };
        }

        private u<Object, Object> f() {
            return new u() { // from class: b.d.b.e.b
                @Override // io.reactivex.u
                public final t a(q qVar) {
                    return j.a.this.o(qVar);
                }
            };
        }

        private c0<Object, Object> g() {
            return new c0() { // from class: b.d.b.e.c
                @Override // io.reactivex.c0
                public final b0 a(x xVar) {
                    return j.a.this.q(xVar);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h */
        public /* synthetic */ e i(io.reactivex.a aVar) {
            return aVar.j(w());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: j */
        public /* synthetic */ e.b.a k(h hVar) {
            return hVar.p(v()).k(w());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: l */
        public /* synthetic */ o m(m mVar) {
            return mVar.i(v()).e(w());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n */
        public /* synthetic */ t o(q qVar) {
            return qVar.L(v()).C(w());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ b0 q(x xVar) {
            return xVar.i(v()).q().f(w());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: r */
        public /* synthetic */ boolean s(Object obj) throws Exception {
            if (j.this.f95b != null) {
                j.this.f95b.D0();
            }
            if (!(obj instanceof CloudResult)) {
                return true;
            }
            CloudResult cloudResult = (CloudResult) obj;
            if (cloudResult.getErrorCode() == 0) {
                return true;
            }
            throw new CloudException(cloudResult.getErrorCode(), cloudResult.getMsg());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: t */
        public /* synthetic */ void u(Throwable th) throws Exception {
            if (j.this.f95b != null) {
                j.this.f95b.r(th);
            }
        }

        private io.reactivex.g0.l<Object> v() {
            return new io.reactivex.g0.l() { // from class: b.d.b.e.g
                @Override // io.reactivex.g0.l
                public final boolean test(Object obj) {
                    return j.a.this.s(obj);
                }
            };
        }

        private io.reactivex.g0.g<Throwable> w() {
            return new io.reactivex.g0.g() { // from class: b.d.b.e.f
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    j.a.this.u((Throwable) obj);
                }
            };
        }

        @Override // retrofit2.c
        public Type a() {
            return this.a.a();
        }

        @Override // retrofit2.c
        public Object b(retrofit2.b<R> bVar) {
            Object b2 = this.a.b(bVar);
            if (b2 instanceof q) {
                return ((q) b2).i(f());
            }
            if (b2 instanceof h) {
                return ((h) b2).d(d());
            }
            if (b2 instanceof x) {
                return ((x) b2).d(g());
            }
            if (b2 instanceof m) {
                return ((m) b2).c(e());
            }
            return b2 instanceof io.reactivex.a ? ((io.reactivex.a) b2).f(c()) : b2;
        }
    }

    /* compiled from: CloudCallAdapterFactory.java */
    /* loaded from: classes2.dex */
    public interface b {
        void D0();

        void r(Throwable th);
    }

    public j(b bVar) {
        this(g.d(), bVar);
    }

    @Override // retrofit2.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, r rVar) {
        return new a(this.a.a(type, annotationArr, rVar));
    }

    public j(g gVar, b bVar) {
        this.a = gVar;
        this.f95b = bVar;
    }
}
