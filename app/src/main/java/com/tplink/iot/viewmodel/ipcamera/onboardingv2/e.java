package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import b.d.w.c.a;
import io.reactivex.g0.g;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class e implements g {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ e f10443c = new e();

    private /* synthetic */ e() {
    }

    @Override // io.reactivex.g0.g
    public final void accept(Object obj) {
        Throwable th = (Throwable) obj;
        a.c("CameraInstallPreview", "setImageFlipStatus2--" + th.getMessage());
    }
}
