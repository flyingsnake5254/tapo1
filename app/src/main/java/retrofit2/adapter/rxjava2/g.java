package retrofit2.adapter.rxjava2;

import io.reactivex.a;
import io.reactivex.h;
import io.reactivex.m;
import io.reactivex.q;
import io.reactivex.w;
import io.reactivex.x;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.c;
import retrofit2.r;

/* compiled from: RxJava2CallAdapterFactory.java */
/* loaded from: classes4.dex */
public final class g extends c.a {
    @Nullable
    private final w a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17565b;

    private g(@Nullable w wVar, boolean z) {
        this.a = wVar;
        this.f17565b = z;
    }

    public static g d() {
        return new g(null, false);
    }

    public static g e() {
        return new g(null, true);
    }

    @Override // retrofit2.c.a
    @Nullable
    public c<?, ?> a(Type type, Annotation[] annotationArr, r rVar) {
        boolean z;
        boolean z2;
        Type type2;
        Class<?> c2 = c.a.c(type);
        if (c2 == a.class) {
            return new f(Void.class, this.a, this.f17565b, false, true, false, false, false, true);
        }
        boolean z3 = c2 == h.class;
        boolean z4 = c2 == x.class;
        boolean z5 = c2 == m.class;
        if (c2 != q.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type b2 = c.a.b(0, (ParameterizedType) type);
        Class<?> c3 = c.a.c(b2);
        if (c3 == retrofit2.q.class) {
            if (b2 instanceof ParameterizedType) {
                type2 = c.a.b(0, (ParameterizedType) b2);
                z2 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (c3 != d.class) {
            type2 = b2;
            z2 = false;
            z = true;
            return new f(type2, this.a, this.f17565b, z2, z, z3, z4, z5, false);
        } else if (b2 instanceof ParameterizedType) {
            type2 = c.a.b(0, (ParameterizedType) b2);
            z2 = true;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        z = false;
        return new f(type2, this.a, this.f17565b, z2, z, z3, z4, z5, false);
    }
}
