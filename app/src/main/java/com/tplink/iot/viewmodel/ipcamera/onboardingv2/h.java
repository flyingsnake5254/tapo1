package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import b.d.w.c.a;
import io.reactivex.g0.g;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class h implements g {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ h f10452c = new h();

    private /* synthetic */ h() {
    }

    @Override // io.reactivex.g0.g
    public final void accept(Object obj) {
        Throwable th = (Throwable) obj;
        a.c("CameraInstallPreview", "setImageFlipStatus1--" + th.getMessage());
    }
}
