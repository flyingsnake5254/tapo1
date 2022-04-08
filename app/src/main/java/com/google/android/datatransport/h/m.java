package com.google.android.datatransport.h;

import com.google.android.datatransport.b;
import com.google.android.datatransport.c;
import com.google.android.datatransport.d;
import com.google.android.datatransport.h.c;
import com.google.auto.value.AutoValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendRequest.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class m {

    /* compiled from: SendRequest.java */
    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract m a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a b(b bVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a c(c<?> cVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a d(d<?, byte[]> dVar);

        public abstract a e(n nVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new c.b();
    }

    public abstract b b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract com.google.android.datatransport.c<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract d<?, byte[]> e();

    public abstract n f();

    public abstract String g();
}
