package com.tplink.iot.viewmodel.ipcamera.setting;

import androidx.lifecycle.Observer;
import com.tplink.libtpnetwork.cameranetwork.business.model.o;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class j3 implements Observer {
    public static final /* synthetic */ j3 a = new j3();

    private /* synthetic */ j3() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        DeviceSettingNewViewModel.V0((o) obj);
    }
}
