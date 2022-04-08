package kotlin.jvm.internal;

import kotlin.reflect.b;
import kotlin.reflect.h;
import kotlin.reflect.l;

/* loaded from: classes4.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements h {
    public MutablePropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected b computeReflected() {
        return m.e(this);
    }

    public abstract /* synthetic */ V get(T t);

    @Override // kotlin.reflect.l
    public Object getDelegate(Object obj) {
        return ((h) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.jvm.b.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public abstract /* synthetic */ void set(T t, V v);

    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public l.a getGetter() {
        return ((h) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.reflect.g
    public h.a getSetter() {
        return ((h) getReflected()).getSetter();
    }

    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
