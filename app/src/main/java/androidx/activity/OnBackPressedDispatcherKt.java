package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: OnBackPressedDispatcher.kt */
/* loaded from: classes.dex */
public final class OnBackPressedDispatcherKt {
    public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher addCallback, LifecycleOwner lifecycleOwner, final boolean z, final l<? super OnBackPressedCallback, p> onBackPressed) {
        j.f(addCallback, "$this$addCallback");
        j.f(onBackPressed, "onBackPressed");
        OnBackPressedCallback onBackPressedDispatcherKt$addCallback$callback$1 = new OnBackPressedCallback(z) { // from class: androidx.activity.OnBackPressedDispatcherKt$addCallback$callback$1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                l.this.invoke(this);
            }
        };
        if (lifecycleOwner != null) {
            addCallback.addCallback(lifecycleOwner, onBackPressedDispatcherKt$addCallback$callback$1);
        } else {
            addCallback.addCallback(onBackPressedDispatcherKt$addCallback$callback$1);
        }
        return onBackPressedDispatcherKt$addCallback$callback$1;
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return addCallback(onBackPressedDispatcher, lifecycleOwner, z, lVar);
    }
}
