package com.tplink.nbu.b;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.d;
import com.tplink.nbu.b.l;
import com.tplink.nbu.exception.NbuCloudException;
import io.reactivex.a;
import io.reactivex.b0;
import io.reactivex.c0;
import io.reactivex.e;
import io.reactivex.f;
import io.reactivex.g0.j;
import io.reactivex.h;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.p;
import io.reactivex.t;
import io.reactivex.u;
import io.reactivex.x;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.adapter.rxjava2.g;
import retrofit2.b;
import retrofit2.c;
import retrofit2.q;
import retrofit2.r;

/* compiled from: NbuCloudCallAdapterFactory.java */
/* loaded from: classes3.dex */
public final class l extends c.a {
    private static final Gson a = new d().c().b();

    /* renamed from: b  reason: collision with root package name */
    private final g f15159b;

    /* compiled from: NbuCloudCallAdapterFactory.java */
    /* loaded from: classes3.dex */
    static final class a<R> implements c<R, Object> {
        private final c<R, Object> a;

        a(c<R, Object> cVar) {
            this.a = cVar;
        }

        private Throwable B(Throwable th) {
            if (th instanceof HttpException) {
                q<?> response = ((HttpException) th).response();
                ResponseBody responseBody = null;
                if (response != null) {
                    responseBody = response.d();
                }
                if (responseBody != null) {
                    try {
                        NbuCloudException nbuCloudException = (NbuCloudException) l.a.j(responseBody.charStream(), NbuCloudException.class);
                        return nbuCloudException == null ? th : nbuCloudException;
                    } catch (JsonSyntaxException unused) {
                    }
                }
            }
            return th;
        }

        private f c() {
            return new f() { // from class: com.tplink.nbu.b.d
                @Override // io.reactivex.f
                public final e a(a aVar) {
                    return l.a.this.k(aVar);
                }
            };
        }

        private <T> io.reactivex.l<T, T> d() {
            return new io.reactivex.l() { // from class: com.tplink.nbu.b.a
                @Override // io.reactivex.l
                public final e.b.a a(h hVar) {
                    return l.a.this.o(hVar);
                }
            };
        }

        private <T> p<T, T> e() {
            return new p() { // from class: com.tplink.nbu.b.f
                @Override // io.reactivex.p
                public final o a(m mVar) {
                    return l.a.this.s(mVar);
                }
            };
        }

        private <T> u<T, T> f() {
            return new u() { // from class: com.tplink.nbu.b.g
                @Override // io.reactivex.u
                public final t a(io.reactivex.q qVar) {
                    return l.a.this.w(qVar);
                }
            };
        }

        private <T> c0<T, T> g() {
            return new c0() { // from class: com.tplink.nbu.b.j
                @Override // io.reactivex.c0
                public final b0 a(x xVar) {
                    return l.a.this.A(xVar);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h */
        public /* synthetic */ e i(Throwable th) throws Exception {
            return io.reactivex.a.m(B(th));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: j */
        public /* synthetic */ e k(io.reactivex.a aVar) {
            return aVar.u(new j() { // from class: com.tplink.nbu.b.b
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return l.a.this.i((Throwable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: l */
        public /* synthetic */ e.b.a m(Throwable th) throws Exception {
            return h.n(B(th));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n */
        public /* synthetic */ e.b.a o(h hVar) {
            return hVar.C(new j() { // from class: com.tplink.nbu.b.e
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return l.a.this.m((Throwable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ o q(Throwable th) throws Exception {
            return m.h(B(th));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: r */
        public /* synthetic */ o s(m mVar) {
            return mVar.k(new j() { // from class: com.tplink.nbu.b.c
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return l.a.this.q((Throwable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: t */
        public /* synthetic */ t u(Throwable th) throws Exception {
            return io.reactivex.q.J(B(th));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: v */
        public /* synthetic */ t w(io.reactivex.q qVar) {
            return qVar.o0(new j() { // from class: com.tplink.nbu.b.i
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return l.a.this.u((Throwable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: x */
        public /* synthetic */ b0 y(Throwable th) throws Exception {
            return x.g(B(th));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: z */
        public /* synthetic */ b0 A(x xVar) {
            return xVar.k(new j() { // from class: com.tplink.nbu.b.h
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return l.a.this.y((Throwable) obj);
                }
            });
        }

        @Override // retrofit2.c
        public Type a() {
            return this.a.a();
        }

        @Override // retrofit2.c
        public Object b(b<R> bVar) {
            Object b2 = this.a.b(bVar);
            if (b2 instanceof io.reactivex.q) {
                return ((io.reactivex.q) b2).i(f());
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

    public l() {
        this(g.d());
    }

    @Override // retrofit2.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, r rVar) {
        return new a(this.f15159b.a(type, annotationArr, rVar));
    }

    public l(g gVar) {
        this.f15159b = gVar;
    }
}
