package com.tplink.libtpnetwork.IoTNetwork.repository.kb;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.d;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;

/* compiled from: IoTDeviceRepositoryProviders.java */
/* loaded from: classes3.dex */
public class e {
    public static <T extends c> T a(@NonNull ThingContext thingContext, @NonNull Class<T> cls) {
        return (T) f(thingContext).a(thingContext, cls);
    }

    public static <T extends c> T b(@NonNull TPCameraDeviceContext tPCameraDeviceContext, @NonNull Class<T> cls) {
        return (T) f(tPCameraDeviceContext).a(tPCameraDeviceContext, cls);
    }

    public static <T extends c> T c(@NonNull String str, @NonNull Class<T> cls) {
        return (T) b(TPIoTClientManager.K1(str), cls);
    }

    public static <T extends c> T d(@NonNull String str, @NonNull Class<T> cls) {
        return (T) a(TPIoTClientManager.k2(str), cls);
    }

    public static void e(TPBaseDeviceContext tPBaseDeviceContext) {
        if (tPBaseDeviceContext instanceof g) {
            ((g) tPBaseDeviceContext).a().a();
        }
        a.c(tPBaseDeviceContext);
    }

    public static d f(@NonNull TPBaseDeviceContext tPBaseDeviceContext) {
        return new d(new d.b(), h.a(tPBaseDeviceContext));
    }
}
