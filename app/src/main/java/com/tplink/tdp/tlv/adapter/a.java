package com.tplink.tdp.tlv.adapter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes3.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.tplink.tdp.tlv.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0277a implements b<T> {
        final /* synthetic */ Constructor a;

        C0277a(Constructor constructor) {
            this.a = constructor;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
        @Override // com.tplink.tdp.tlv.adapter.b
        public T a() {
            Object[] objArr = null;
            try {
                int length = this.a.getParameterTypes().length;
                if (length > 0) {
                    objArr = new Object[length];
                }
                return this.a.newInstance(objArr);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e4.getTargetException());
            }
        }
    }

    private <T> b<T> b(Class<? super T> cls) {
        Constructor<?> constructor;
        Constructor<?>[] declaredConstructors;
        try {
            constructor = cls.getDeclaredConstructor(new Class[0]);
        } catch (NoSuchMethodException unused) {
            constructor = null;
        }
        if (constructor == null && (declaredConstructors = cls.getDeclaredConstructors()) != null && declaredConstructors.length > 0) {
            constructor = declaredConstructors[0];
        }
        if (constructor == null) {
            return null;
        }
        return new C0277a(constructor);
    }

    public <T> b<T> a(e<T> eVar) {
        b<T> b2 = b(eVar.a());
        if (b2 != null) {
            return b2;
        }
        return null;
    }
}
