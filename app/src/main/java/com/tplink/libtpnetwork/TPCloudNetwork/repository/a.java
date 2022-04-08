package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import com.tplink.iot.cloud.bean.billing.result.ProductListResult;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ a f13947c = new a();

    private /* synthetic */ a() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        return ((ProductListResult) obj).getProductList();
    }
}
