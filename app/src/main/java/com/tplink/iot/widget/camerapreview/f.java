package com.tplink.iot.widget.camerapreview;

import b.d.b.f.b;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareUpdateLevel;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.u;
import io.reactivex.g0.j;
import io.reactivex.q;

/* compiled from: FirmwareEngine.kt */
/* loaded from: classes3.dex */
public final class f {
    private final FirmwareManager a;

    /* compiled from: FirmwareEngine.kt */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements j<u, e> {

        /* renamed from: c  reason: collision with root package name */
        public static final a f11715c = new a();

        a() {
        }

        /* renamed from: a */
        public final e apply(u it) {
            kotlin.jvm.internal.j.e(it, "it");
            if (!it.f()) {
                return e.a.n().B("Updating");
            }
            if (FirmwareUpdateLevel.LEVEL4 == it.b()) {
                return e.a.c().B("Force update");
            }
            return e.a.g().B("No update");
        }
    }

    public f() {
        b.d.b.f.a a2 = b.a(b.d.s.a.a.f(), FirmwareManager.class);
        kotlin.jvm.internal.j.d(a2, "CloudRepositoryProviders…Manager::class.java\n    )");
        this.a = (FirmwareManager) a2;
    }

    public final q<e> a(String deviceIdMD5) {
        kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
        q<u> h = this.a.h(deviceIdMD5);
        u g = this.a.g(deviceIdMD5);
        if (g == null) {
            g = new u();
        }
        q g0 = h.E0(g).g0(a.f11715c);
        kotlin.jvm.internal.j.d(g0, "firmwareManager\n        …          }\n            }");
        return g0;
    }
}
