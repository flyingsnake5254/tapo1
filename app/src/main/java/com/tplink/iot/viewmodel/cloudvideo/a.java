package com.tplink.iot.viewmodel.cloudvideo;

import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ a f9928c = new a();

    private /* synthetic */ a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return CloudVideoViewModel.r0((OrderInfo) obj, (OrderInfo) obj2);
    }
}
