package com.tplink.iot.view.home.f0.c;

import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.home.f0.b.b;

/* compiled from: AppMarketingStrategy.java */
/* loaded from: classes2.dex */
public class a implements b {
    private MutableLiveData<Boolean> a;

    public a(MutableLiveData<Boolean> mutableLiveData) {
        this.a = mutableLiveData;
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public int a() {
        return 1100;
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public String b() {
        return "dialog_in_app_marketing";
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
