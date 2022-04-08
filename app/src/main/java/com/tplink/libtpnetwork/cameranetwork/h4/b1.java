package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.SettingComposite;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b1 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ b1 f14722c = new b1();

    private /* synthetic */ b1() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(SettingComposite.Companion.fromMultipleResponse((MultipleResponse) ((Response) obj).getResult()));
        return repack;
    }
}
