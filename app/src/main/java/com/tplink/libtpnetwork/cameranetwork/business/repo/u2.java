package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.model.ImageFlip;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class u2 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ u2 f14606c = new u2();

    private /* synthetic */ u2() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Boolean valueOf;
        valueOf = Boolean.valueOf("on".equals(((ImageFlip) obj).getLdc()));
        return valueOf;
    }
}
