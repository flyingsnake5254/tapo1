package com.tplink.iot.viewmodel.billing;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.g0.g;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a0 implements g {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MutableLiveData f9854c;

    public /* synthetic */ a0(MutableLiveData mutableLiveData) {
        this.f9854c = mutableLiveData;
    }

    @Override // io.reactivex.g0.g
    public final void accept(Object obj) {
        this.f9854c.postValue((Integer) obj);
    }
}
