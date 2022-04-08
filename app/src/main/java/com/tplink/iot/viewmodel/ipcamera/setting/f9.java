package com.tplink.iot.viewmodel.ipcamera.setting;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class f9 implements Observer {
    public final /* synthetic */ MutableLiveData a;

    public /* synthetic */ f9(MutableLiveData mutableLiveData) {
        this.a = mutableLiveData;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.a.setValue((Boolean) obj);
    }
}
