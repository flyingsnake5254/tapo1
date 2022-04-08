package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.model.ConnectStatus;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class e7 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ e7 f14389c = new e7();

    private /* synthetic */ e7() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        return (ConnectStatus) ((Response) obj).getResult();
    }
}
