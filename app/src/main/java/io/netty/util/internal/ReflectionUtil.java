package io.netty.util.internal;

import java.lang.reflect.AccessibleObject;

/* loaded from: classes3.dex */
public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    private static RuntimeException handleInaccessibleObjectException(RuntimeException runtimeException) {
        if ("java.lang.reflect.InaccessibleObjectException".equals(runtimeException.getClass().getName())) {
            return runtimeException;
        }
        throw runtimeException;
    }

    public static Throwable trySetAccessible(AccessibleObject accessibleObject, boolean z) {
        if (z && !PlatformDependent0.isExplicitTryReflectionSetAccessible()) {
            return new UnsupportedOperationException("Reflective setAccessible(true) disabled");
        }
        try {
            accessibleObject.setAccessible(true);
            return null;
        } catch (SecurityException e2) {
            return e2;
        } catch (RuntimeException e3) {
            return handleInaccessibleObjectException(e3);
        }
    }
}
