package com.google.gson.internal.k;

import com.google.gson.internal.d;
import java.lang.reflect.AccessibleObject;

/* compiled from: ReflectionAccessor.java */
/* loaded from: classes2.dex */
public abstract class b {
    private static final b a;

    static {
        a = d.c() < 9 ? new a() : new c();
    }

    public static b a() {
        return a;
    }

    public abstract void b(AccessibleObject accessibleObject);
}
