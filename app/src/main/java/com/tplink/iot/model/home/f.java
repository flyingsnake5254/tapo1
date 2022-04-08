package com.tplink.iot.model.home;

import java.util.ArrayList;
import java.util.List;

/* compiled from: HomeCacheListBean.java */
/* loaded from: classes2.dex */
public class f {
    private List<HomeCacheBean> a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8154b;

    public f(List<HomeCacheBean> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.clear();
        this.a.addAll(list);
        this.f8154b = z;
    }

    public List<HomeCacheBean> a() {
        return this.a;
    }

    public boolean b() {
        return this.f8154b;
    }
}
