package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.model.Response;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ a f14331c = new a();

    private /* synthetic */ a() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        return Boolean.valueOf(((Response) obj).isSuccess());
    }
}
