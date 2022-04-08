package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.SettingComposite;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c7 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ c7 f14367c = new c7();

    private /* synthetic */ c7() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        return (SettingComposite) ((Response) obj).getResult();
    }
}
