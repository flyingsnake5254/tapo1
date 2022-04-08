package com.tplink.libtpnetwork.IoTNetwork.repository;

import androidx.arch.core.util.Function;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.BrightnessPresetsBean;
import com.tplink.libtpnetwork.Utils.c;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Function {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return c.a((BrightnessPresetsBean) obj);
    }
}
