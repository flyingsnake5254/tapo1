package com.tplink.libtpcontrols.treerecyclerview;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;

/* loaded from: classes3.dex */
public class TreeDiffCallback extends DiffUtil.Callback {
    private List<a> a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f12461b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        return this.a.get(i).equals(this.f12461b.get(i2));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        a aVar = this.a.get(i);
        a aVar2 = this.f12461b.get(i2);
        if (aVar.b() != aVar2.b() || ((aVar.a() == null && aVar2.a() == null) || aVar.a() == null || aVar2.a() == null)) {
            return false;
        }
        return aVar.a().equals(aVar2.a());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.f12461b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.a.size();
    }
}
