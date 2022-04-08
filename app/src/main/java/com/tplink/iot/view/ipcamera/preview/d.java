package com.tplink.iot.view.ipcamera.preview;

import kotlin.jvm.internal.j;

/* compiled from: CameraPreviewActivity.kt */
/* loaded from: classes2.dex */
public final class d {
    private CameraPreviewInfo a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9055b;

    public d(CameraPreviewInfo info, boolean z) {
        j.e(info, "info");
        this.a = info;
        this.f9055b = z;
    }

    public final CameraPreviewInfo a() {
        return this.a;
    }

    public final boolean b() {
        return this.f9055b;
    }

    public final boolean c() {
        return this.f9055b;
    }

    public final CameraPreviewInfo d() {
        return this.a;
    }

    public final void e(boolean z) {
        this.f9055b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return j.a(this.a, dVar.a) && this.f9055b == dVar.f9055b;
    }

    public final void f(CameraPreviewInfo cameraPreviewInfo) {
        j.e(cameraPreviewInfo, "<set-?>");
        this.a = cameraPreviewInfo;
    }

    public int hashCode() {
        CameraPreviewInfo cameraPreviewInfo = this.a;
        int hashCode = (cameraPreviewInfo != null ? cameraPreviewInfo.hashCode() : 0) * 31;
        boolean z = this.f9055b;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    public String toString() {
        return "CameraPreviewInfoWithConnectionError(info=" + this.a + ", connectionError=" + this.f9055b + ")";
    }
}
