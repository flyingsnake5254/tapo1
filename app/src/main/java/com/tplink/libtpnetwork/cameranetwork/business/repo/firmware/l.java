package com.tplink.libtpnetwork.cameranetwork.business.repo.firmware;

import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class l implements io.reactivex.g0.l {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ l f14422c = new l();

    private /* synthetic */ l() {
    }

    @Override // io.reactivex.g0.l
    public final boolean test(Object obj) {
        boolean hasComponent;
        hasComponent = ((CameraComponent) obj).hasComponent(ComponentType.FIRMWARE);
        return hasComponent;
    }
}
