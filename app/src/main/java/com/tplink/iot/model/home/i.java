package com.tplink.iot.model.home;

import com.tplink.iot.cloud.bean.smart.common.SmartInfo;

/* compiled from: HomeShortcutAdapterBean.java */
/* loaded from: classes2.dex */
public class i {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private SmartInfo f8156b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8157c;

    public i() {
    }

    public int a() {
        return this.a;
    }

    public SmartInfo b() {
        return this.f8156b;
    }

    public boolean c() {
        return this.f8157c;
    }

    public void d(boolean z) {
        this.f8157c = z;
    }

    public void e(int i) {
        this.a = i;
    }

    public void f(SmartInfo smartInfo) {
        this.f8156b = smartInfo;
    }

    public i(int i, SmartInfo smartInfo, boolean z) {
        this.a = i;
        this.f8156b = smartInfo;
        this.f8157c = z;
    }
}
