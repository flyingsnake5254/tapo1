package com.tplink.iot.viewmodel.ipcamera.play;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class y2 implements Observer {
    public final /* synthetic */ MediatorLiveData a;

    public /* synthetic */ y2(MediatorLiveData mediatorLiveData) {
        this.a = mediatorLiveData;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.a.setValue((Boolean) obj);
    }
}
