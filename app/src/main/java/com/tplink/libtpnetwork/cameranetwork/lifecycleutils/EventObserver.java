package com.tplink.libtpnetwork.cameranetwork.lifecycleutils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

/* loaded from: classes3.dex */
public class EventObserver<T> implements Observer<a<T>> {
    @NonNull
    private final Observer<T> a;

    public EventObserver(@NonNull Observer<T> observer) {
        this.a = observer;
    }

    /* renamed from: a */
    public void onChanged(@Nullable a<T> aVar) {
        T a;
        if (aVar != null && (a = aVar.a()) != null) {
            this.a.onChanged(a);
        }
    }
}
