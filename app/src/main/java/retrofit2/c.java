package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: CallAdapter.java */
/* loaded from: classes4.dex */
public interface c<R, T> {

    /* compiled from: CallAdapter.java */
    /* loaded from: classes4.dex */
    public static abstract class a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static Type b(int i, ParameterizedType parameterizedType) {
            return v.h(i, parameterizedType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static Class<?> c(Type type) {
            return v.i(type);
        }

        @Nullable
        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, r rVar);
    }

    Type a();

    T b(b<R> bVar);
}
