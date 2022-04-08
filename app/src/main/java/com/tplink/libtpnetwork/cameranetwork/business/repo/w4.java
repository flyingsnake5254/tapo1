package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.model.Response;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class w4 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ w4 f14631c = new w4();

    private /* synthetic */ w4() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response response = (Response) obj;
        PlayBackRepository.Y0(response);
        return response;
    }
}
