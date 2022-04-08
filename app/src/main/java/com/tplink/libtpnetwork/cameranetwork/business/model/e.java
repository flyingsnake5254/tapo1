package com.tplink.libtpnetwork.cameranetwork.business.model;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CoverConfigSetting.java */
/* loaded from: classes3.dex */
public class e {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private List<d> f14126b = new ArrayList();

    public List<d> a() {
        return this.f14126b;
    }

    public boolean b() {
        return this.a;
    }

    public void c(boolean z) {
        this.a = z;
    }

    public void d(List<d> list) {
        this.f14126b.clear();
        this.f14126b.addAll(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return eVar.a == this.a && eVar.f14126b.equals(this.f14126b);
    }
}
