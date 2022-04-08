package kotlin.t;

import kotlin.reflect.j;

/* compiled from: ObservableProperty.kt */
/* loaded from: classes4.dex */
public abstract class b<V> implements d<Object, V> {
    private V a;

    public b(V v) {
        this.a = v;
    }

    @Override // kotlin.t.d
    public void a(Object obj, j<?> property, V v) {
        kotlin.jvm.internal.j.e(property, "property");
        V v2 = this.a;
        if (d(property, v2, v)) {
            this.a = v;
            c(property, v2, v);
        }
    }

    @Override // kotlin.t.c
    public V b(Object obj, j<?> property) {
        kotlin.jvm.internal.j.e(property, "property");
        return this.a;
    }

    protected abstract void c(j<?> jVar, V v, V v2);

    protected boolean d(j<?> property, V v, V v2) {
        kotlin.jvm.internal.j.e(property, "property");
        return true;
    }
}
