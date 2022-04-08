package com.tplink.libtpnetwork.IoTNetwork;

import io.reactivex.g0.c;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class n implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ n f12849c = new n();

    private /* synthetic */ n() {
    }

    @Override // io.reactivex.g0.c
    public final Object apply(Object obj, Object obj2) {
        com.tplink.libtpnetwork.IoTNetwork.repository.kb.c cVar = (com.tplink.libtpnetwork.IoTNetwork.repository.kb.c) obj;
        TPIoTClientManager.P2(cVar, (Long) obj2);
        return cVar;
    }
}
