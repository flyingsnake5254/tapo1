package com.tplink.libtpdemux.tsdemux.common;

/* compiled from: ESAudioParam.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    int f12506d;

    /* renamed from: e  reason: collision with root package name */
    int f12507e;
    long g;
    EnumTSAudioEncodeType a = EnumTSAudioEncodeType.TS_AUDIO_ENCODE_TYPE_INVALID;

    /* renamed from: b  reason: collision with root package name */
    int f12504b = 1;

    /* renamed from: c  reason: collision with root package name */
    int f12505c = 8000;

    /* renamed from: f  reason: collision with root package name */
    long f12508f = 0;

    public EnumTSAudioEncodeType a() {
        return this.a;
    }

    public int b() {
        return this.f12507e;
    }

    public int c() {
        return this.f12504b;
    }

    public long d() {
        return this.f12508f;
    }

    public int e() {
        return this.f12505c;
    }

    public long f() {
        return this.g;
    }

    public void g(EnumTSAudioEncodeType enumTSAudioEncodeType) {
        this.a = enumTSAudioEncodeType;
    }

    public void h(int i) {
        this.f12507e = i;
    }

    public void i(int i) {
        this.f12504b = i;
    }

    public void j(int i) {
        this.f12506d = i;
    }

    public void k(long j) {
        this.f12508f = j;
    }

    public void l(int i) {
        this.f12505c = i;
    }

    public void m(long j) {
        this.g = j;
    }
}
