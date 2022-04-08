package com.tplink.libtpinappmessaging.model;

/* compiled from: WebMessage.java */
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: e  reason: collision with root package name */
    private String f12553e;

    public e() {
        this.a = "inner web's url";
    }

    public String g() {
        return this.f12553e;
    }

    public void h(String str) {
        this.f12553e = str;
    }

    public String toString() {
        return "WebMessage{webUrl='" + this.f12553e + "', description='" + this.a + "'}";
    }
}
