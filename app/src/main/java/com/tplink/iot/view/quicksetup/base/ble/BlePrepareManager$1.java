package com.tplink.iot.view.quicksetup.base.ble;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes2.dex */
class BlePrepareManager$1 implements BleLifecycleObserver {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ c f9517c;

    @Override // com.tplink.iot.view.quicksetup.base.ble.BleLifecycleObserver
    public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
        c.b(this.f9517c);
    }

    @Override // com.tplink.iot.view.quicksetup.base.ble.BleLifecycleObserver
    public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
        c.a(this.f9517c);
    }
}
