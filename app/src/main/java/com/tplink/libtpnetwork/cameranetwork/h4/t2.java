package com.tplink.libtpnetwork.cameranetwork.h4;

import com.tplink.libtpnetwork.cameranetwork.model.Model;
import com.tplink.libtpnetwork.cameranetwork.model.Module;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Section;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.g0.j;
import java.util.List;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class t2 implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ t2 f14875c = new t2();

    private /* synthetic */ t2() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        Response repack;
        repack = r1.repack(Model.extractMapList((List) Model.typeCast((Wrappers) ((Response) obj).getResult(), Module.PLAYBACK, Section.PLAYBACK_DAILY)));
        return repack;
    }
}
