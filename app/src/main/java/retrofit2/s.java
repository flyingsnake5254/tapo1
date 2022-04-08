package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServiceMethod.java */
/* loaded from: classes4.dex */
public abstract class s<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> s<T> b(r rVar, Method method) {
        p b2 = p.b(rVar, method);
        Type genericReturnType = method.getGenericReturnType();
        if (v.k(genericReturnType)) {
            throw v.n(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        } else if (genericReturnType != Void.TYPE) {
            return h.f(rVar, method, b2);
        } else {
            throw v.n(method, "Service methods cannot return void.", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public abstract T a(Object[] objArr);
}
