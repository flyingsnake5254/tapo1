package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.AudioInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class n1 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ n1 f14792c = new n1();

    private /* synthetic */ n1() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(AudioInfo.Companion.fromResponse((Response<Wrappers>) obj));
        return repack;
    }
}
