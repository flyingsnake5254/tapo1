package com.tplink.libtpnetwork.cameranetwork.business.model;

import androidx.exifinterface.media.ExifInterface;
import com.tplink.libtpnetwork.cameranetwork.model.TamperDetectConfig;

/* compiled from: TamperSetting.java */
/* loaded from: classes3.dex */
public class p {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private String f14156b;

    /* renamed from: c  reason: collision with root package name */
    private String f14157c;

    public p a() {
        p pVar = new p();
        pVar.f14157c = this.f14157c;
        pVar.a = this.a;
        pVar.f14156b = this.f14156b;
        return pVar;
    }

    public String b() {
        return this.f14156b;
    }

    public boolean c() {
        return this.a;
    }

    public void d(String str) {
        this.f14157c = str;
    }

    public void e(boolean z) {
        this.a = z;
    }

    public void f(String str) {
        this.f14156b = str;
    }

    public TamperDetectConfig g() {
        Integer.valueOf(ExifInterface.GPS_MEASUREMENT_2D).intValue();
        return new TamperDetectConfig(this.f14157c, this.a ? "on" : "off", this.f14156b);
    }

    public String toString() {
        return "TamperSetting{enabled=" + this.a + ", sensitivity='" + this.f14156b + "', digitalSensitivity=" + this.f14157c + '}';
    }
}
