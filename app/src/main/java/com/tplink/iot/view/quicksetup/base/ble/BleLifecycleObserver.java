package com.tplink.iot.view.quicksetup.base.ble;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/* loaded from: classes2.dex */
public interface BleLifecycleObserver extends LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(@NonNull LifecycleOwner lifecycleOwner);

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume(@NonNull LifecycleOwner lifecycleOwner);
}
