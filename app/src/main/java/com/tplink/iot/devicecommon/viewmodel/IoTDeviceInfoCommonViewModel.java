package com.tplink.iot.devicecommon.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;
import kotlin.t.c;

/* compiled from: IoTDeviceInfoCommonViewModel.kt */
/* loaded from: classes2.dex */
public final class IoTDeviceInfoCommonViewModel extends AndroidViewModel {
    static final /* synthetic */ j[] a = {m.h(new PropertyReference1Impl(IoTDeviceInfoCommonViewModel.class, "alIoTDeviceLiveData", "getAlIoTDeviceLiveData()Landroidx/lifecycle/LiveData;", 0))};

    /* renamed from: b  reason: collision with root package name */
    private final c f7420b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IoTDeviceInfoCommonViewModel(Application application, ThingContext iotDeviceContext) {
        super(application);
        kotlin.jvm.internal.j.e(application, "application");
        kotlin.jvm.internal.j.e(iotDeviceContext, "iotDeviceContext");
        this.f7420b = com.tplink.iot.Utils.extension.c.a(iotDeviceContext);
    }

    public final LiveData<BaseALIoTDevice<?>> f() {
        return (LiveData) this.f7420b.b(this, a[0]);
    }
}
