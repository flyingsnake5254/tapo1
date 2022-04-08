package com.tplink.iab;

import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class SingleLiveEvent<T> extends MutableLiveData<T> {
    private final AtomicBoolean a = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(Observer observer, Object obj) {
        if (this.a.compareAndSet(true, false)) {
            observer.onChanged(obj);
        }
    }

    @Override // androidx.lifecycle.LiveData
    @MainThread
    public void observe(LifecycleOwner lifecycleOwner, final Observer<? super T> observer) {
        if (hasActiveObservers()) {
            Log.w("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(lifecycleOwner, new Observer() { // from class: com.tplink.iab.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SingleLiveEvent.this.b(observer, obj);
            }
        });
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    @MainThread
    public void setValue(@Nullable T t) {
        this.a.set(true);
        super.setValue(t);
    }
}
