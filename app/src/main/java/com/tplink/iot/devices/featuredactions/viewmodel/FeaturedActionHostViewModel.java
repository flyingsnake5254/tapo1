package com.tplink.iot.devices.featuredactions.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;
import kotlin.t.c;

/* compiled from: FeaturedActionHostViewModel.kt */
/* loaded from: classes2.dex */
public final class FeaturedActionHostViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] a = {m.h(new PropertyReference1Impl(FeaturedActionHostViewModel.class, "baseALIoTDeviceLiveData", "getBaseALIoTDeviceLiveData()Landroidx/lifecycle/LiveData;", 0))};

    /* renamed from: b  reason: collision with root package name */
    private final c f7462b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeaturedActionHostViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        this.f7462b = com.tplink.iot.Utils.extension.c.a(iotDeviceContext);
    }
}
