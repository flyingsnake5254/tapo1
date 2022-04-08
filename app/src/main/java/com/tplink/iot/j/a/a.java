package com.tplink.iot.j.a;

import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.DeviceBean;
import java.util.List;

/* compiled from: GroupDeviceListBean.java */
/* loaded from: classes2.dex */
public class a {
    private List<DeviceBean> a;

    /* renamed from: b  reason: collision with root package name */
    private List<GroupInfo> f7998b;

    public a() {
    }

    public int a() {
        List<DeviceBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<DeviceBean> b() {
        return this.a;
    }

    public List<GroupInfo> c() {
        return this.f7998b;
    }

    public int d() {
        List<GroupInfo> list = this.f7998b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int e() {
        return a() + d();
    }

    public a(List<DeviceBean> list, List<GroupInfo> list2) {
        this.a = list;
        this.f7998b = list2;
    }
}
