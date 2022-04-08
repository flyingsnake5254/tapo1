package com.tplink.iot.adapter.databinding;

import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.DiffUtil;
import b.d.w.c.a;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.i;
import kotlin.jvm.internal.j;

/* compiled from: DiffCallBack.kt */
/* loaded from: classes2.dex */
public final class DiffCallBack extends DiffUtil.Callback {
    private final String a = DiffCallBack.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private int f5437b;

    /* renamed from: c  reason: collision with root package name */
    private int f5438c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<?> f5439d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<?> f5440e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f5441f;
    private final ArrayList<?> g;
    private final int[] h;

    public DiffCallBack(ArrayList<?> oldData, ArrayList<?> newData, int[] identifyIdsIndex) {
        boolean i;
        j.e(oldData, "oldData");
        j.e(newData, "newData");
        j.e(identifyIdsIndex, "identifyIdsIndex");
        this.g = newData;
        this.h = identifyIdsIndex;
        ArrayList<?> arrayList = new ArrayList<>();
        this.f5439d = arrayList;
        g.f(oldData, arrayList);
        ArrayList<?> arrayList2 = new ArrayList<>();
        this.f5440e = arrayList2;
        g.f(newData, arrayList2);
        Iterator<?> it = arrayList.iterator();
        while (it.hasNext()) {
            int d2 = g.d(it.next());
            if (d2 > this.f5437b) {
                this.f5437b = d2;
            }
        }
        Iterator<?> it2 = this.f5440e.iterator();
        while (it2.hasNext()) {
            int d3 = g.d(it2.next());
            if (d3 > this.f5438c) {
                this.f5438c = d3;
            }
        }
        int[] iArr = new int[this.f5440e.size() - this.h.length];
        this.f5441f = iArr;
        if (!(iArr.length == 0)) {
            int size = this.f5440e.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i = i.i(this.h, i3);
                if (!i) {
                    i2++;
                    this.f5441f[i2] = i3;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        int[] iArr;
        if (i != i2) {
            return false;
        }
        for (int i3 : this.f5441f) {
            Object obj = this.f5439d.get(i3);
            if (true ^ j.a(g.c(this.f5440e.get(i3), i2), g.c(obj, i))) {
                a.c(this.a, "areContentsTheSame(" + i + ", " + i2 + "):false");
                return false;
            }
        }
        a.c(this.a, "areContentsTheSame(" + i + ", " + i2 + "):true");
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        int[] iArr;
        for (int i3 : this.h) {
            Object obj = this.f5439d.get(i3);
            if (true ^ j.a(g.c(this.f5440e.get(i3), i2), g.c(obj, i))) {
                a.c(this.a, "areItemsTheSame(" + i + ", " + i2 + "):false");
                return false;
            }
        }
        a.c(this.a, "areItemsTheSame(" + i + ", " + i2 + "):true");
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public Object getChangePayload(int i, int i2) {
        int[] iArr;
        ArrayMap arrayMap = new ArrayMap();
        DataBindingListAdapter.a aVar = DataBindingListAdapter.f5433c;
        if (!(aVar.a() == -1 || i == i2)) {
            arrayMap.put(Integer.valueOf(aVar.a()), Boolean.TRUE);
        }
        for (int i3 : this.f5441f) {
            Object obj = this.f5439d.get(i3);
            Object obj2 = this.f5440e.get(i3);
            if (!j.a(g.c(obj2, i2), g.c(obj, i))) {
                arrayMap.put(Integer.valueOf(i3), Boolean.TRUE);
            }
        }
        return arrayMap;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.f5438c;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.f5437b;
    }
}
