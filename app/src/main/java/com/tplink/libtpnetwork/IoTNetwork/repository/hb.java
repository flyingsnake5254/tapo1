package com.tplink.libtpnetwork.IoTNetwork.repository;

import io.reactivex.g0.g;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class hb implements g {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AbstractSubThingRepository f13269c;

    public /* synthetic */ hb(AbstractSubThingRepository abstractSubThingRepository) {
        this.f13269c = abstractSubThingRepository;
    }

    @Override // io.reactivex.g0.g
    public final void accept(Object obj) {
        this.f13269c.S3((Throwable) obj);
    }
}
