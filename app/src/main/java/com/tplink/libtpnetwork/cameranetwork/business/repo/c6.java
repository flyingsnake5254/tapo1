package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.model.RecordAudioInfo;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c6 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ c6 f14366c = new c6();

    private /* synthetic */ c6() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Boolean valueOf;
        valueOf = Boolean.valueOf("on".equals(((RecordAudioInfo) obj).getEnabled()));
        return valueOf;
    }
}
