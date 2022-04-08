package com.tplink.libtpstreamclientmanager;

import androidx.annotation.NonNull;
import b.d.d.b.a;
import b.d.d.b.c;
import b.d.d.b.e;
import b.d.o.a.f;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class TPStreamConnectionManager extends a {
    private final Map<String, TPMediaDevice> a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, TPMediaDeviceContext> f15066b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, ?> f15067c = new ConcurrentHashMap();

    public TPStreamConnectionManager(c cVar) {
        super(cVar);
    }

    public static TPMediaDevice a(@NonNull String str) {
        return ((TPStreamConnectionManager) e.a(b.d.d.c.a.b(), TPStreamConnectionManager.class)).c(str);
    }

    public static TPMediaDeviceContext b(@NonNull String str) {
        return ((TPStreamConnectionManager) e.a(b.d.d.c.a.b(), TPStreamConnectionManager.class)).d(str);
    }

    private TPMediaDeviceContext d(String str) {
        TPMediaDeviceContext tPMediaDeviceContext = this.f15066b.get(str);
        TPMediaDevice tPMediaDevice = this.a.get(str);
        if (tPMediaDeviceContext == null) {
            if (tPMediaDevice != null) {
                tPMediaDeviceContext = new TPMediaDeviceContext(tPMediaDevice, this.mAccountContext);
            } else {
                tPMediaDeviceContext = new TPMediaDeviceContext(str, this.mAccountContext);
            }
            this.f15066b.put(str, tPMediaDeviceContext);
        } else if (tPMediaDevice != null) {
            tPMediaDeviceContext.setDevice(tPMediaDevice);
        }
        return tPMediaDeviceContext;
    }

    public TPMediaDevice c(@NonNull String str) {
        return this.a.get(str);
    }

    public q<List<TPMediaDeviceContext>> refreshDeviceList(List<TPMediaDevice> list) {
        f.m().q(list);
        HashSet<String> hashSet = new HashSet(this.a.keySet());
        if (list != null && !list.isEmpty()) {
            for (TPMediaDevice tPMediaDevice : list) {
                String b2 = b.d.p.c.b(tPMediaDevice.getDeviceId());
                this.a.put(b2, tPMediaDevice);
                hashSet.remove(b2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str : hashSet) {
            this.a.remove(str);
            this.f15067c.remove(str);
            arrayList.add(this.f15066b.remove(str));
        }
        return q.f0(arrayList);
    }
}
