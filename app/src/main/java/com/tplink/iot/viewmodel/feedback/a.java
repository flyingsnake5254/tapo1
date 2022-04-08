package com.tplink.iot.viewmodel.feedback;

import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ a f9999c = new a();

    private /* synthetic */ a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return SelectFeedbackDeviceViewModel.k((BaseALIoTDevice) obj, (BaseALIoTDevice) obj2);
    }
}
