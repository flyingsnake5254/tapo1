package kotlin.jvm.internal;

import kotlin.reflect.f;
import kotlin.reflect.j;

/* loaded from: classes4.dex */
public abstract class MutablePropertyReference extends PropertyReference implements j {
    public MutablePropertyReference() {
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public abstract /* synthetic */ j.a<V> getGetter();

    public abstract /* synthetic */ f<V> getSetter();

    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
