package com.google.android.datatransport.runtime.backends;

import androidx.annotation.Nullable;
import com.google.android.datatransport.h.i;
import com.google.android.datatransport.runtime.backends.a;
import com.google.auto.value.AutoValue;

/* compiled from: BackendRequest.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class f {

    /* compiled from: BackendRequest.java */
    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract f a();

        public abstract a b(Iterable<i> iterable);

        public abstract a c(@Nullable byte[] bArr);
    }

    public static a a() {
        return new a.b();
    }

    public abstract Iterable<i> b();

    @Nullable
    public abstract byte[] c();
}
