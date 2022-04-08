package com.tplink.iot.view.quicksetup.base.wifi;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes2.dex */
class WiFiPrepareManager$1 implements WiFiLifecycleObserver {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ c f9538c;

    @Override // com.tplink.iot.view.quicksetup.base.wifi.WiFiLifecycleObserver
    public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
        c.b(this.f9538c);
    }

    @Override // com.tplink.iot.view.quicksetup.base.wifi.WiFiLifecycleObserver
    public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
        c.a(this.f9538c);
    }
}
