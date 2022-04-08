package com.samskivert.mustache;

import com.samskivert.mustache.f;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: DefaultCollector.java */
/* loaded from: classes2.dex */
public class b extends a {

    /* compiled from: DefaultCollector.java */
    /* loaded from: classes2.dex */
    class a implements f.v {
        final /* synthetic */ Method a;

        a(Method method) {
            this.a = method;
        }

        @Override // com.samskivert.mustache.f.v
        public Object a(Object obj, String str) throws Exception {
            return this.a.invoke(obj, new Object[0]);
        }
    }

    /* compiled from: DefaultCollector.java */
    /* renamed from: com.samskivert.mustache.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0185b implements f.v {
        final /* synthetic */ Field a;

        C0185b(Field field) {
            this.a = field;
        }

        @Override // com.samskivert.mustache.f.v
        public Object a(Object obj, String str) throws Exception {
            return this.a.get(obj);
        }
    }

    /* compiled from: DefaultCollector.java */
    /* loaded from: classes2.dex */
    class c implements f.v {
        final /* synthetic */ Method a;

        c(Method method) {
            this.a = method;
        }

        @Override // com.samskivert.mustache.f.v
        public Object a(Object obj, String str) throws Exception {
            return this.a.invoke(obj, new Object[0]);
        }
    }

    private void e(Set<Class<?>> set, Class<?> cls, boolean z) {
        if (z) {
            set.add(cls);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            e(set, cls2, true);
        }
    }

    private Method j(Method method) {
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        return method;
    }

    @Override // com.samskivert.mustache.f.e
    public <K, V> Map<K, V> b() {
        return new ConcurrentHashMap();
    }

    @Override // com.samskivert.mustache.a, com.samskivert.mustache.f.e
    public f.v c(Object obj, String str) {
        f.v c2 = super.c(obj, str);
        if (c2 != null) {
            return c2;
        }
        Class<?> cls = obj.getClass();
        Method h = h(cls, str);
        if (h != null) {
            return new a(h);
        }
        Field f2 = f(cls, str);
        if (f2 != null) {
            return new C0185b(f2);
        }
        Method g = g(cls, str);
        if (g != null) {
            return new c(g);
        }
        return null;
    }

    protected Field f(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (Exception unused) {
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass == Object.class || superclass == null) {
                return null;
            }
            return f(cls.getSuperclass(), str);
        }
    }

    protected Method g(Class<?> cls, String str) {
        LinkedHashSet<Class<?>> linkedHashSet = new LinkedHashSet();
        while (cls != null && cls != Object.class) {
            e(linkedHashSet, cls, false);
            cls = cls.getSuperclass();
        }
        for (Class<?> cls2 : linkedHashSet) {
            Method i = i(cls2, str);
            if (i != null) {
                return i;
            }
        }
        return null;
    }

    protected Method h(Class<?> cls, String str) {
        while (cls != null && cls != Object.class) {
            Method i = i(cls, str);
            if (i != null) {
                return i;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    protected Method i(Class<?> cls, String str) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            if (!declaredMethod.getReturnType().equals(Void.TYPE)) {
                return j(declaredMethod);
            }
        } catch (Exception unused) {
        }
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        try {
            Method declaredMethod2 = cls.getDeclaredMethod("get" + str2, new Class[0]);
            if (!declaredMethod2.getReturnType().equals(Void.TYPE)) {
                return j(declaredMethod2);
            }
        } catch (Exception unused2) {
        }
        try {
            Method declaredMethod3 = cls.getDeclaredMethod("is" + str2, new Class[0]);
            if (declaredMethod3.getReturnType().equals(Boolean.TYPE) || declaredMethod3.getReturnType().equals(Boolean.class)) {
                return j(declaredMethod3);
            }
            return null;
        } catch (Exception unused3) {
            return null;
        }
    }
}
