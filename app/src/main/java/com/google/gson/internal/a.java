package com.google.gson.internal;

import java.util.Objects;

/* compiled from: $Gson$Preconditions.java */
/* loaded from: classes2.dex */
public final class a {
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T b(T t) {
        Objects.requireNonNull(t);
        return t;
    }
}
