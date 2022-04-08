package com.tplink.libtpdemux.tsdemux.common;

/* compiled from: ESVideoParam.java */
/* loaded from: classes3.dex */
public class c {
    EnumTSVideoEncodeType a = EnumTSVideoEncodeType.TS_VIDEO_ENCODE_TYPE_INVALID;

    /* renamed from: b  reason: collision with root package name */
    boolean f12511b = false;

    /* renamed from: c  reason: collision with root package name */
    long f12512c = 0;

    /* renamed from: d  reason: collision with root package name */
    long f12513d = 0;

    /* renamed from: e  reason: collision with root package name */
    EnumESFrameType f12514e = EnumESFrameType.TS_ES_FRAME_TYPE_INVALID;

    /* renamed from: f  reason: collision with root package name */
    long f12515f;

    public EnumESFrameType a() {
        return this.f12514e;
    }

    public long b() {
        return this.f12512c;
    }

    public long c() {
        return this.f12515f;
    }

    public boolean d() {
        return this.f12511b;
    }

    public void e(long j) {
        this.f12513d = j;
    }

    public void f(EnumESFrameType enumESFrameType) {
        this.f12514e = enumESFrameType;
    }

    public void g(boolean z) {
        this.f12511b = z;
    }

    public void h(long j) {
        this.f12512c = j;
    }

    public void i(long j) {
        this.f12515f = j;
    }

    public void j(EnumTSVideoEncodeType enumTSVideoEncodeType) {
        this.a = enumTSVideoEncodeType;
    }
}
