package com.tplink.iot.viewmodel.home;

import android.text.TextUtils;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.g;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: HomeDeviceSortUtils.java */
/* loaded from: classes2.dex */
public class t {
    private static Comparator<k> a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static Comparator<BaseALIoTDevice> f10131b = new v();

    /* renamed from: c  reason: collision with root package name */
    private static Comparator<k> f10132c = new b();

    /* compiled from: HomeDeviceSortUtils.java */
    /* loaded from: classes2.dex */
    static class a implements Comparator<k> {
        a() {
        }

        /* renamed from: a */
        public int compare(k kVar, k kVar2) {
            String c2 = t.c(kVar);
            String c3 = t.c(kVar2);
            if (t.b(c2) < t.b(c3)) {
                return -1;
            }
            if (t.b(c2) <= t.b(c3) && kVar.g() != null && !TextUtils.isEmpty(kVar.g().getDeviceName()) && kVar2.g() != null && !TextUtils.isEmpty(kVar2.g().getDeviceName())) {
                return kVar.g().getDeviceName().compareToIgnoreCase(kVar2.g().getDeviceName());
            }
            return 1;
        }
    }

    /* compiled from: HomeDeviceSortUtils.java */
    /* loaded from: classes2.dex */
    static class b implements Comparator<k> {
        b() {
        }

        /* renamed from: a */
        public int compare(k kVar, k kVar2) {
            if (kVar.n() < kVar2.n()) {
                return -1;
            }
            if (kVar.n() != kVar2.n() || kVar.g() == null || TextUtils.isEmpty(kVar.g().getDeviceName()) || kVar2.g() == null || TextUtils.isEmpty(kVar2.g().getDeviceName())) {
                return 1;
            }
            return kVar.g().getDeviceName().compareToIgnoreCase(kVar2.g().getDeviceName());
        }
    }

    /* compiled from: HomeDeviceSortUtils.java */
    /* loaded from: classes2.dex */
    static class c implements Comparator<g> {
        c() {
        }

        /* renamed from: a */
        public int compare(g gVar, g gVar2) {
            long j = 0;
            long createTime = gVar.h() == null ? 0L : gVar.h().getCreateTime();
            if (gVar2.h() != null) {
                j = gVar2.h().getCreateTime();
            }
            int i = (createTime > j ? 1 : (createTime == j ? 0 : -1));
            if (i < 0) {
                return 1;
            }
            return i > 0 ? -1 : 0;
        }
    }

    /* compiled from: HomeDeviceSortUtils.java */
    /* loaded from: classes2.dex */
    static class d implements Comparator<GroupInfo> {
        d() {
        }

        /* renamed from: a */
        public int compare(GroupInfo groupInfo, GroupInfo groupInfo2) {
            long j;
            long j2 = 0;
            if (groupInfo == null || groupInfo.getCtime() == null) {
                j = 0;
            } else {
                j = groupInfo.getCtime().longValue();
            }
            if (!(groupInfo2 == null || groupInfo2.getCtime() == null)) {
                j2 = groupInfo2.getCtime().longValue();
            }
            int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            if (i < 0) {
                return 1;
            }
            return i > 0 ? -1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(String str) {
        EnumDeviceType fromType = EnumDeviceType.fromType(str);
        if (fromType == null) {
            return EnumDeviceType.values().length;
        }
        return fromType.ordinal();
    }

    public static String c(k kVar) {
        return r.j(kVar.g()) ? EnumDeviceType.SWITCH.getDeviceType() : kVar.g().getDeviceType();
    }

    public static void d(List<GroupInfo> list) {
        Collections.sort(list, new d());
    }

    public static void e(List<k> list) {
        Collections.sort(list, a);
    }

    public static void f(List<g> list) {
        Collections.sort(list, new c());
    }

    public static void g(List<k> list) {
        Collections.sort(list, a);
    }

    public static void h(List<BaseALIoTDevice> list) {
        Collections.sort(list, f10131b);
    }

    public static void i(List<e> list, List<String> list2) {
        Collections.sort(list, new w(list2));
    }

    public static void j(List<k> list, List<String> list2) {
        b.d.w.c.a.n("HomeSort", "HomeDeviceSortUtils.sortHomeOnlineDeviceList DefaultOrder");
        Collections.sort(list, new x(list2));
    }
}
