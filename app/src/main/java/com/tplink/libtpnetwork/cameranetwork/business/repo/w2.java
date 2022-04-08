package com.tplink.libtpnetwork.cameranetwork.business.repo;

import io.reactivex.g0.g;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class w2 implements g {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LiveVideoRepository f14629c;

    public /* synthetic */ w2(LiveVideoRepository liveVideoRepository) {
        this.f14629c = liveVideoRepository;
    }

    @Override // io.reactivex.g0.g
    public final void accept(Object obj) {
        this.f14629c.u((Throwable) obj);
    }
}
