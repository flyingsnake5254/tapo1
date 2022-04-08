package com.tplink.iot.view.home.f0.c;

import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.home.f0.b.b;

/* compiled from: UserRateDialogStrategy.java */
/* loaded from: classes2.dex */
public class e implements b {
    private MutableLiveData<Boolean> a;

    public e(MutableLiveData<Boolean> mutableLiveData) {
        this.a = mutableLiveData;
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public int a() {
        return 0;
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public String b() {
        return "dialog_flag_user_rate";
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public void clear() {
        this.a.postValue(null);
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public void show() {
        this.a.postValue(Boolean.TRUE);
    }
}
