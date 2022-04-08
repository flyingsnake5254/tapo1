package com.tplink.iot.model.billing;

/* compiled from: Receipt.java */
/* loaded from: classes2.dex */
public class h0 {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f8044b;

    /* renamed from: c  reason: collision with root package name */
    public String f8045c;

    /* renamed from: d  reason: collision with root package name */
    public String f8046d;

    public h0() {
    }

    public String toString() {
        return "purchaseToken: " + this.a + " accountId: " + this.f8044b + " packageName: " + this.f8045c + " sku: " + this.f8046d;
    }

    public h0(String str, String str2, String str3, String str4) {
        this.a = str;
        this.f8044b = str2;
        this.f8045c = str3;
        this.f8046d = str4;
    }
}
