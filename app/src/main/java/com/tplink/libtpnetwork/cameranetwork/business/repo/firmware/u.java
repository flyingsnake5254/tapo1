package com.tplink.libtpnetwork.cameranetwork.business.repo.firmware;

import android.text.TextUtils;

/* compiled from: FirmwareInfo.java */
/* loaded from: classes3.dex */
public class u {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f14430b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14431c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14432d;

    /* renamed from: e  reason: collision with root package name */
    private FirmwareUpdateLevel f14433e;

    private int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public String a() {
        return this.f14430b;
    }

    public FirmwareUpdateLevel b() {
        return this.f14433e;
    }

    public String d() {
        return this.a;
    }

    public boolean e() {
        return (this.a == null || this.f14430b == null) ? false : true;
    }

    public boolean f() {
        return this.f14431c;
    }

    public void g(String str) {
        this.f14430b = str;
    }

    public void h(String str) {
        this.f14433e = FirmwareUpdateLevel.makeFirmwareUpdateLevel(c(str));
    }

    public void i(String str) {
        this.a = str;
    }

    public void j(boolean z) {
        this.f14431c = z;
    }

    public void k(boolean z) {
        this.f14432d = z;
    }
}
