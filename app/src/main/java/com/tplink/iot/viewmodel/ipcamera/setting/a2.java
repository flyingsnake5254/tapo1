package com.tplink.iot.viewmodel.ipcamera.setting;

import androidx.lifecycle.Observer;
import com.tplink.libtpnetwork.cameranetwork.business.model.b;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a2 implements Observer {
    public static final /* synthetic */ a2 a = new a2();

    private /* synthetic */ a2() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        DeviceSettingNewViewModel.U0((b) obj);
    }
}
