package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: LiveData.kt */
/* loaded from: classes.dex */
public final class LiveDataKt {
    @MainThread
    public static final <T> Observer<T> observe(LiveData<T> observe, LifecycleOwner owner, final l<? super T, p> onChanged) {
        j.f(observe, "$this$observe");
        j.f(owner, "owner");
        j.f(onChanged, "onChanged");
        Observer<T> liveDataKt$observe$wrappedObserver$1 = new Observer<T>() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                l.this.invoke(t);
            }
        };
        observe.observe(owner, liveDataKt$observe$wrappedObserver$1);
        return liveDataKt$observe$wrappedObserver$1;
    }
}
