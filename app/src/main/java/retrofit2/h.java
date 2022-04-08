package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpServiceMethod.java */
/* loaded from: classes4.dex */
public abstract class h<ResponseT, ReturnT> extends s<ReturnT> {
    private final p a;

    /* renamed from: b  reason: collision with root package name */
    private final Call.Factory f17584b;

    /* renamed from: c  reason: collision with root package name */
    private final f<ResponseBody, ResponseT> f17585c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpServiceMethod.java */
    /* loaded from: classes4.dex */
    public static final class a<ResponseT, ReturnT> extends h<ResponseT, ReturnT> {

        /* renamed from: d  reason: collision with root package name */
        private final c<ResponseT, ReturnT> f17586d;

        a(p pVar, Call.Factory factory, f<ResponseBody, ResponseT> fVar, c<ResponseT, ReturnT> cVar) {
            super(pVar, factory, fVar);
            this.f17586d = cVar;
        }

        @Override // retrofit2.h
        protected ReturnT c(b<ResponseT> bVar, Object[] objArr) {
            return this.f17586d.b(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpServiceMethod.java */
    /* loaded from: classes4.dex */
    public static final class b<ResponseT> extends h<ResponseT, Object> {

        /* renamed from: d  reason: collision with root package name */
        private final c<ResponseT, b<ResponseT>> f17587d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f17588e;

        b(p pVar, Call.Factory factory, f<ResponseBody, ResponseT> fVar, c<ResponseT, b<ResponseT>> cVar, boolean z) {
            super(pVar, factory, fVar);
            this.f17587d = cVar;
            this.f17588e = z;
        }

        @Override // retrofit2.h
        protected Object c(b<ResponseT> bVar, Object[] objArr) {
            b<ResponseT> b2 = this.f17587d.b(bVar);
            kotlin.coroutines.c cVar = (kotlin.coroutines.c) objArr[objArr.length - 1];
            try {
                if (this.f17588e) {
                    return j.b(b2, cVar);
                }
                return j.a(b2, cVar);
            } catch (Exception e2) {
                return j.d(e2, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpServiceMethod.java */
    /* loaded from: classes4.dex */
    public static final class c<ResponseT> extends h<ResponseT, Object> {

        /* renamed from: d  reason: collision with root package name */
        private final c<ResponseT, b<ResponseT>> f17589d;

        c(p pVar, Call.Factory factory, f<ResponseBody, ResponseT> fVar, c<ResponseT, b<ResponseT>> cVar) {
            super(pVar, factory, fVar);
            this.f17589d = cVar;
        }

        @Override // retrofit2.h
        protected Object c(b<ResponseT> bVar, Object[] objArr) {
            b<ResponseT> b2 = this.f17589d.b(bVar);
            kotlin.coroutines.c cVar = (kotlin.coroutines.c) objArr[objArr.length - 1];
            try {
                return j.c(b2, cVar);
            } catch (Exception e2) {
                return j.d(e2, cVar);
            }
        }
    }

    h(p pVar, Call.Factory factory, f<ResponseBody, ResponseT> fVar) {
        this.a = pVar;
        this.f17584b = factory;
        this.f17585c = fVar;
    }

    private static <ResponseT, ReturnT> c<ResponseT, ReturnT> d(r rVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (c<ResponseT, ReturnT>) rVar.a(type, annotationArr);
        } catch (RuntimeException e2) {
            throw v.o(method, e2, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> f<ResponseBody, ResponseT> e(r rVar, Method method, Type type) {
        try {
            return rVar.i(type, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw v.o(method, e2, "Unable to create converter for %s", type);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <ResponseT, ReturnT> h<ResponseT, ReturnT> f(r rVar, Method method, p pVar) {
        Type type;
        boolean z;
        boolean z2 = pVar.k;
        Annotation[] annotations = method.getAnnotations();
        if (z2) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type g = v.g(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (v.i(g) != q.class || !(g instanceof ParameterizedType)) {
                z = false;
            } else {
                g = v.h(0, (ParameterizedType) g);
                z = true;
            }
            type = new v.b(null, b.class, g);
            annotations = u.a(annotations);
        } else {
            type = method.getGenericReturnType();
            z = false;
        }
        c d2 = d(rVar, method, type, annotations);
        Type a2 = d2.a();
        if (a2 == Response.class) {
            throw v.n(method, "'" + v.i(a2).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        } else if (a2 == q.class) {
            throw v.n(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        } else if (!pVar.f17648c.equals("HEAD") || Void.class.equals(a2)) {
            f e2 = e(rVar, method, a2);
            Call.Factory factory = rVar.f17659b;
            if (!z2) {
                return new a(pVar, factory, e2, d2);
            }
            if (z) {
                return new c(pVar, factory, e2, d2);
            }
            return new b(pVar, factory, e2, d2, false);
        } else {
            throw v.n(method, "HEAD method must use Void as response type.", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // retrofit2.s
    @Nullable
    public final ReturnT a(Object[] objArr) {
        return c(new k(this.a, objArr, this.f17584b, this.f17585c), objArr);
    }

    @Nullable
    protected abstract ReturnT c(b<ResponseT> bVar, Object[] objArr);
}
