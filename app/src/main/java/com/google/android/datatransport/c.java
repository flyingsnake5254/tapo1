package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* compiled from: Event.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class c<T> {
    public static <T> c<T> d(T t) {
        return new a(null, t, Priority.DEFAULT);
    }

    public static <T> c<T> e(T t) {
        return new a(null, t, Priority.VERY_LOW);
    }

    public static <T> c<T> f(T t) {
        return new a(null, t, Priority.HIGHEST);
    }

    @Nullable
    public abstract Integer a();

    public abstract T b();

    public abstract Priority c();
}
