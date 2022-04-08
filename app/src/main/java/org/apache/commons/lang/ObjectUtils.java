package org.apache.commons.lang;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes4.dex */
public class ObjectUtils {
    public static final Null a = new Null();

    /* loaded from: classes4.dex */
    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        Null() {
        }

        private Object readResolve() {
            return ObjectUtils.a;
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static int b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static void c(StringBuffer stringBuffer, Object obj) {
        Objects.requireNonNull(obj, "Cannot get the toString of a null identity");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append('@');
        stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static boolean d(Object obj, Object obj2) {
        return !a(obj, obj2);
    }
}
