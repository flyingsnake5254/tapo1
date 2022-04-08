package com.tplink.iot.model.firmware;

import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.concurrent.TimeUnit;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class f implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ f f8094c = new f();

    private /* synthetic */ f() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        t o;
        o = ((q) obj).o(60L, TimeUnit.SECONDS);
        return o;
    }
}
