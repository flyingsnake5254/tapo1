package com.tplink.libtpnetwork.cameranetwork.h4.p4;

import com.tplink.cloud.context.a;
import com.tplink.libtpnetwork.cameranetwork.h4.i4;

/* compiled from: RemoteTransportParams.java */
/* loaded from: classes3.dex */
public class g extends i4 {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f14854b;

    /* renamed from: c  reason: collision with root package name */
    private a f14855c;

    /* renamed from: d  reason: collision with root package name */
    private String f14856d;

    public g(String str, String str2, a aVar, String str3) {
        this.a = str;
        this.f14854b = str2;
        this.f14855c = aVar;
        this.f14856d = str3;
    }

    public a a() {
        return this.f14855c;
    }

    public String b() {
        return this.f14854b;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.f14856d;
    }

    public void e(a aVar) {
        this.f14855c = aVar;
    }

    public void f(String str) {
        this.f14856d = str;
    }
}
