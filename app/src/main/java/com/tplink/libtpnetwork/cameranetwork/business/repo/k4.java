package com.tplink.libtpnetwork.cameranetwork.business.repo;

import io.reactivex.g0.c;
import java.util.List;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class k4 implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ k4 f14489c = new k4();

    private /* synthetic */ k4() {
    }

    @Override // io.reactivex.g0.c
    public final Object apply(Object obj, Object obj2) {
        List list = (List) obj;
        list.addAll((List) obj2);
        return list;
    }
}
