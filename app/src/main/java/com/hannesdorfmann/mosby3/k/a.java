package com.hannesdorfmann.mosby3.k;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.hannesdorfmann.mosby3.k.b;

/* compiled from: MvpPresenter.java */
/* loaded from: classes2.dex */
public interface a<V extends b> {
    @UiThread
    void a(@NonNull V v);

    @UiThread
    void b();

    @UiThread
    void destroy();
}
