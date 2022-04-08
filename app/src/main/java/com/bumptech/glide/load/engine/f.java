package com.bumptech.glide.load.engine;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;

/* compiled from: DataFetcherGenerator.java */
/* loaded from: classes.dex */
interface f {

    /* compiled from: DataFetcherGenerator.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar, Exception exc, d<?> dVar, DataSource dataSource);

        void c();

        void e(c cVar, @Nullable Object obj, d<?> dVar, DataSource dataSource, c cVar2);
    }

    boolean b();

    void cancel();
}
