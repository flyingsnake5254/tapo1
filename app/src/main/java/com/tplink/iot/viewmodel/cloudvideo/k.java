package com.tplink.iot.viewmodel.cloudvideo;

import com.tplink.iot.cloud.bean.cloudvideo.common.HasVideoTime;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class k implements Comparator {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ k f9941c = new k();

    private /* synthetic */ k() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return CloudVideoViewModel.s0((HasVideoTime) obj, (HasVideoTime) obj2);
    }
}
