package com.tplink.iot.viewmodel.home;

import b.d.w.c.a;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.g;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyCommonSortBean;
import com.tplink.libtpnetwork.Utils.i;
import java.util.Comparator;
import java.util.List;

/* compiled from: HomeOnlineDeviceGroupSortListComparator.java */
/* loaded from: classes2.dex */
public class w implements Comparator<e> {

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f10146c;

    public w(List<String> list) {
        a.n("HomeSort", "HomeOnlineDeviceGroupSortListComparator currentFamilyCommonSortList: " + i.j(list));
        this.f10146c = list;
    }

    private int b(e eVar, e eVar2) {
        String f2 = eVar.f();
        String f3 = eVar2.f();
        if (f2.isEmpty() && f3.isEmpty()) {
            return 0;
        }
        if (f2.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        if (f3.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return f2.compareToIgnoreCase(f3);
    }

    private int c(e eVar) {
        if (eVar instanceof k) {
            return this.f10146c.indexOf(FamilyCommonSortBean.PREFIX_DEVICE + eVar.d());
        } else if (!(eVar instanceof g)) {
            return -1;
        } else {
            return this.f10146c.indexOf(FamilyCommonSortBean.PREFIX_GROUP + eVar.d());
        }
    }

    /* renamed from: a */
    public int compare(e eVar, e eVar2) {
        int c2 = c(eVar);
        int c3 = c(eVar2);
        if (c2 != -1 && c3 != -1) {
            return c2 - c3;
        }
        if (c2 != -1) {
            return Integer.MIN_VALUE;
        }
        if (c3 != -1) {
            return Integer.MAX_VALUE;
        }
        return b(eVar, eVar2);
    }
}
