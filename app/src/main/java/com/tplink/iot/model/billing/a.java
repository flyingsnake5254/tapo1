package com.tplink.iot.model.billing;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.g0.g;
import java.util.List;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements g {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MutableLiveData f8029c;

    public /* synthetic */ a(MutableLiveData mutableLiveData) {
        this.f8029c = mutableLiveData;
    }

    @Override // io.reactivex.g0.g
    public final void accept(Object obj) {
        this.f8029c.postValue((List) obj);
    }
}
