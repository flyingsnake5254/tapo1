package kotlin.jvm.internal;

import kotlin.reflect.c;
import kotlin.reflect.d;
import kotlin.reflect.e;
import kotlin.reflect.g;
import kotlin.reflect.h;
import kotlin.reflect.i;
import kotlin.reflect.k;
import kotlin.reflect.l;

/* compiled from: Reflection.java */
/* loaded from: classes4.dex */
public class m {
    private static final n a;

    /* renamed from: b  reason: collision with root package name */
    private static final c[] f16350b;

    static {
        n nVar = null;
        try {
            nVar = (n) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (nVar == null) {
            nVar = new n();
        }
        a = nVar;
        f16350b = new c[0];
    }

    public static e a(FunctionReference functionReference) {
        return a.a(functionReference);
    }

    public static c b(Class cls) {
        return a.b(cls);
    }

    public static d c(Class cls) {
        return a.c(cls, "");
    }

    public static g d(MutablePropertyReference0 mutablePropertyReference0) {
        return a.d(mutablePropertyReference0);
    }

    public static h e(MutablePropertyReference1 mutablePropertyReference1) {
        return a.e(mutablePropertyReference1);
    }

    public static i f(MutablePropertyReference2 mutablePropertyReference2) {
        return a.f(mutablePropertyReference2);
    }

    public static k g(PropertyReference0 propertyReference0) {
        return a.g(propertyReference0);
    }

    public static l h(PropertyReference1 propertyReference1) {
        return a.h(propertyReference1);
    }

    public static kotlin.reflect.m i(PropertyReference2 propertyReference2) {
        return a.i(propertyReference2);
    }

    public static String j(h hVar) {
        return a.j(hVar);
    }

    public static String k(Lambda lambda) {
        return a.k(lambda);
    }
}
