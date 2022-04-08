package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.SettingCompositeV2;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class g7 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ g7 f14448c = new g7();

    private /* synthetic */ g7() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        return (SettingCompositeV2) ((Response) obj).getResult();
    }
}
