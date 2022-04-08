package com.google.common.collect;

import com.google.common.base.n;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Collections2.java */
/* loaded from: classes2.dex */
public final class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder c(int i) {
        v.b(i, "size");
        return new StringBuilder((int) Math.min(i * 8, 1073741824L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Collection<?> collection, @NullableDecl Object obj) {
        n.o(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Collection<?> collection, @NullableDecl Object obj) {
        n.o(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f(Collection<?> collection) {
        StringBuilder c2 = c(collection.size());
        c2.append('[');
        boolean z = true;
        for (Object obj : collection) {
            if (!z) {
                c2.append(", ");
            }
            z = false;
            if (obj == collection) {
                c2.append("(this Collection)");
            } else {
                c2.append(obj);
            }
        }
        c2.append(']');
        return c2.toString();
    }
}
