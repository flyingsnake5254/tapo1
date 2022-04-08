package kotlin.reflect;

import kotlin.reflect.j;

/* compiled from: KProperty.kt */
/* loaded from: classes4.dex */
public interface l<T, V> extends j<V>, kotlin.jvm.b.l<T, V> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes4.dex */
    public interface a<T, V> extends j.a<V>, kotlin.jvm.b.l<T, V> {
    }

    Object getDelegate(T t);

    a<T, V> getGetter();
}
