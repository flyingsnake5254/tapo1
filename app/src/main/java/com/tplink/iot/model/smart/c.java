package com.tplink.iot.model.smart;

import com.tplink.iot.cloud.bean.smart.common.SmartInfo;

/* compiled from: SmartActionEntityBean.java */
/* loaded from: classes2.dex */
public class c extends b {

    /* renamed from: b  reason: collision with root package name */
    private SmartInfo f8195b;

    /* renamed from: c  reason: collision with root package name */
    private int f8196c = 0;

    public c(SmartInfo smartInfo) {
        b(1);
        this.f8195b = smartInfo;
    }

    public SmartInfo c() {
        return this.f8195b;
    }

    public int d() {
        return this.f8196c;
    }

    public void e(int i) {
        this.f8196c = i;
    }
}
