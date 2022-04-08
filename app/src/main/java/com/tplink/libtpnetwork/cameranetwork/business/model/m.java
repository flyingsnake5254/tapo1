package com.tplink.libtpnetwork.cameranetwork.business.model;

import com.tplink.libtpnetwork.cameranetwork.model.DailyPlaybackItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PlaybackDailyRecord.java */
/* loaded from: classes3.dex */
public class m {
    private List<DailyPlaybackItem> a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14147b;

    /* renamed from: c  reason: collision with root package name */
    private int f14148c;

    /* renamed from: d  reason: collision with root package name */
    private int f14149d;

    /* renamed from: e  reason: collision with root package name */
    private int f14150e;

    /* renamed from: f  reason: collision with root package name */
    private long f14151f;

    public m() {
        this.a = new ArrayList();
        this.f14147b = false;
        this.f14148c = 0;
        this.f14149d = 0;
    }

    public long a() {
        return this.f14151f;
    }

    public int b() {
        return this.f14150e;
    }

    public int c() {
        return this.f14148c;
    }

    public int d() {
        return this.f14149d;
    }

    public List<DailyPlaybackItem> e() {
        return this.a;
    }

    public boolean f() {
        return this.f14147b;
    }

    public m(List<DailyPlaybackItem> list, boolean z, int i, int i2, int i3, long j) {
        this.a = list;
        this.f14147b = z;
        this.f14148c = i;
        this.f14149d = i2;
        this.f14150e = i3;
        this.f14151f = j;
    }
}
