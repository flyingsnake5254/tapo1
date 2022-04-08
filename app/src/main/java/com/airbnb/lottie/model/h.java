package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.tplink.libtpmediastatistics.SSLClient;

/* compiled from: MutablePair.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class h<T> {
    @Nullable
    T a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    T f1020b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t, T t2) {
        this.a = t;
        this.f1020b = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return a(pair.first, this.a) && a(pair.second, this.f1020b);
    }

    public int hashCode() {
        T t = this.a;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f1020b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.a) + SSLClient.WHITE_SPACE + String.valueOf(this.f1020b) + "}";
    }
}
