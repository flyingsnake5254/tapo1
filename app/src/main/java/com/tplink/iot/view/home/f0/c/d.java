package com.tplink.iot.view.home.f0.c;

import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.home.f0.b.b;

/* compiled from: TapoCareDowngradeStrategy.java */
/* loaded from: classes2.dex */
public class d implements b {
    private MutableLiveData<com.tplink.iot.model.home.d> a;

    /* renamed from: b  reason: collision with root package name */
    private com.tplink.iot.model.home.d f8540b;

    public d(MutableLiveData<com.tplink.iot.model.home.d> mutableLiveData, com.tplink.iot.model.home.d dVar) {
        this.a = mutableLiveData;
        this.f8540b = dVar;
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public int a() {
        return 1300;
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public String b() {
        return "dialog_flag_tapo_care_downgrade";
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public void clear() {
    }

    @Override // com.tplink.iot.view.home.f0.b.b
    public void show() {
        this.a.postValue(this.f8540b);
    }
}
