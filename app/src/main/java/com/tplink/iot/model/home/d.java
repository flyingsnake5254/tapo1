package com.tplink.iot.model.home;

import com.tplink.iot.cloud.bean.cloudvideo.common.RemovedDevice;
import com.tplink.iot.cloud.bean.cloudvideo.result.DowngradeInfoResult;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DowngradeInfoBean.java */
/* loaded from: classes2.dex */
public class d {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private String f8150b;

    /* renamed from: c  reason: collision with root package name */
    private int f8151c;

    /* renamed from: d  reason: collision with root package name */
    private long f8152d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f8153e;

    public static d a(DowngradeInfoResult downgradeInfoResult) {
        if (downgradeInfoResult == null) {
            return null;
        }
        if (downgradeInfoResult.getDowngradeHandled() != null) {
            d dVar = new d();
            dVar.h(true);
            dVar.k(downgradeInfoResult.getDowngradeHandled().getSubscriptionId());
            dVar.i(downgradeInfoResult.getDowngradeHandled().getNewDeviceNum());
            dVar.g(downgradeInfoResult.getDowngradeHandled().getDeviceRemovalTime());
            ArrayList arrayList = new ArrayList();
            if (downgradeInfoResult.getDowngradeHandled().getRemovedDeviceList() != null) {
                for (RemovedDevice removedDevice : downgradeInfoResult.getDowngradeHandled().getRemovedDeviceList()) {
                    arrayList.add(removedDevice.getDeviceId());
                }
            }
            dVar.j(arrayList);
            return dVar;
        } else if (downgradeInfoResult.getDowngradeToHandle() == null) {
            return null;
        } else {
            d dVar2 = new d();
            dVar2.h(false);
            dVar2.k(downgradeInfoResult.getDowngradeToHandle().getSubscriptionId());
            dVar2.i(downgradeInfoResult.getDowngradeToHandle().getNewDeviceNum());
            return dVar2;
        }
    }

    public long b() {
        return this.f8152d;
    }

    public int c() {
        return this.f8151c;
    }

    public List<String> d() {
        return this.f8153e;
    }

    public String e() {
        return this.f8150b;
    }

    public boolean f() {
        return this.a;
    }

    public void g(long j) {
        this.f8152d = j;
    }

    public void h(boolean z) {
        this.a = z;
    }

    public void i(int i) {
        this.f8151c = i;
    }

    public void j(List<String> list) {
        this.f8153e = list;
    }

    public void k(String str) {
        this.f8150b = str;
    }
}
