package kotlin.reflect;

import kotlin.jvm.b.p;
import kotlin.reflect.j;

/* compiled from: KProperty.kt */
/* loaded from: classes4.dex */
public interface m<D, E, V> extends j<V>, p<D, E, V> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes4.dex */
    public interface a<D, E, V> extends j.a<V>, p<D, E, V> {
    }

    Object getDelegate(D d2, E e2);

    a<D, E, V> getGetter();
}
