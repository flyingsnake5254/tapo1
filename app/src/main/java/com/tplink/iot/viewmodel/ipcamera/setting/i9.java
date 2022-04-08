package com.tplink.iot.viewmodel.ipcamera.setting;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i9 implements Observer {
    public final /* synthetic */ MediatorLiveData a;

    public /* synthetic */ i9(MediatorLiveData mediatorLiveData) {
        this.a = mediatorLiveData;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.a.setValue((Boolean) obj);
    }
}
