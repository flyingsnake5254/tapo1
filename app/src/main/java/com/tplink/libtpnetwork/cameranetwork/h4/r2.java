package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.DetectionSetting;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class r2 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ r2 f14865c = new r2();

    private /* synthetic */ r2() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(DetectionSetting.Companion.fromMultipleResponse((MultipleResponse) ((Response) obj).getResult()));
        return repack;
    }
}
