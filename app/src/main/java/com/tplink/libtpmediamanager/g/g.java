package com.tplink.libtpmediamanager.g;

import androidx.annotation.NonNull;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;

/* compiled from: MediaRepositoryStores.java */
/* loaded from: classes3.dex */
public class g {
    @NonNull
    public static e a(@NonNull TPMediaDeviceContext tPMediaDeviceContext) {
        if (tPMediaDeviceContext instanceof f) {
            return ((f) tPMediaDeviceContext).a();
        }
        return a.d(tPMediaDeviceContext).a();
    }
}
