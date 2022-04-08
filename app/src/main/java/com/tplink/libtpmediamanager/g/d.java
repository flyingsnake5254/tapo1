package com.tplink.libtpmediamanager.g;

import androidx.annotation.NonNull;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import com.tplink.libtpmediamanager.g.c;
import com.tplink.libtpstreamclientmanager.TPStreamConnectionManager;

/* compiled from: MediaRepositoryProviders.java */
/* loaded from: classes3.dex */
public class d {
    public static <T extends b> T a(@NonNull TPMediaDeviceContext tPMediaDeviceContext, @NonNull Class<T> cls) {
        return (T) d(tPMediaDeviceContext).a(tPMediaDeviceContext, cls);
    }

    public static <T extends b> T b(@NonNull String str, @NonNull Class<T> cls) {
        return (T) a(TPStreamConnectionManager.b(str), cls);
    }

    public static void c(TPMediaDeviceContext tPMediaDeviceContext) {
        if (tPMediaDeviceContext instanceof f) {
            ((f) tPMediaDeviceContext).a().a();
        }
        a.c(tPMediaDeviceContext);
    }

    public static c d(@NonNull TPMediaDeviceContext tPMediaDeviceContext) {
        return new c(new c.b(), g.a(tPMediaDeviceContext));
    }
}
