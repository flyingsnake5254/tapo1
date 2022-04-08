package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.i;
import kotlin.reflect.m;

/* loaded from: classes4.dex */
public abstract class MutablePropertyReference2 extends MutablePropertyReference implements i {
    public MutablePropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected b computeReflected() {
        return m.f(this);
    }

    public abstract /* synthetic */ V get(D d2, E e2);

    @Override // kotlin.reflect.m
    public Object getDelegate(Object obj, Object obj2) {
        return ((i) getReflected()).getDelegate(obj, obj2);
    }

    @Override // kotlin.jvm.b.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public abstract /* synthetic */ void set(D d2, E e2, V v);

    public MutablePropertyReference2(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public m.a getGetter() {
        return ((i) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.reflect.g
    public i.a getSetter() {
        return ((i) getReflected()).getSetter();
    }
}
