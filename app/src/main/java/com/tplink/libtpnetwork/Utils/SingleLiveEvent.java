package com.tplink.libtpnetwork.Utils;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class SingleLiveEvent<T> extends MediatorLiveData<T> {
    private final AtomicBoolean a = new AtomicBoolean(false);

    /* loaded from: classes3.dex */
    class a implements Observer<T> {
        final /* synthetic */ Observer a;

        a(Observer observer) {
            this.a = observer;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable T t) {
            if (SingleLiveEvent.this.a.compareAndSet(true, false)) {
                this.a.onChanged(t);
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    @MainThread
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        if (hasActiveObservers()) {
            b.d.w.c.a.n("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(lifecycleOwner, new a(observer));
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    @MainThread
    public void setValue(@Nullable T t) {
        this.a.set(true);
        super.setValue(t);
    }
}
