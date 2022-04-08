package kotlin.jvm.internal;

import kotlin.reflect.c;
import kotlin.reflect.d;

/* loaded from: classes4.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(d dVar, String str, String str2) {
        super(((c) dVar).a(), str, str2, !(dVar instanceof c) ? 1 : 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference2
    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }

    public PropertyReference2Impl(Class cls, String str, String str2, int i) {
        super(cls, str, str2, i);
    }
}
