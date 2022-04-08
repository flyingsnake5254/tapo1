package com.tplink.iot.viewmodel.home;

import com.tplink.iot.model.home.k;
import java.util.Comparator;
import java.util.List;

/* compiled from: HomeOnlineDeviceListComparator.java */
/* loaded from: classes2.dex */
public class x implements Comparator<k> {
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f10147c;

    public x(List<String> list) {
        this.f10147c = list;
    }

    /* renamed from: a */
    public int compare(k kVar, k kVar2) {
        int m = kVar.m();
        int m2 = kVar2.m();
        if (m != 0 && m2 != 0) {
            int indexOf = this.f10147c.indexOf(kVar.l());
            int indexOf2 = this.f10147c.indexOf(kVar2.l());
            if (indexOf != -1 && indexOf2 != -1) {
                return indexOf - indexOf2;
            }
            if (indexOf != -1) {
                return Integer.MAX_VALUE;
            }
            if (indexOf2 != -1) {
                return Integer.MIN_VALUE;
            }
            return m2 - m;
        } else if (m != 0) {
            return Integer.MIN_VALUE;
        } else {
            if (m2 != 0) {
                return Integer.MAX_VALUE;
            }
            String deviceName = kVar.g().getDeviceName();
            String deviceName2 = kVar2.g().getDeviceName();
            if (deviceName.isEmpty() && deviceName2.isEmpty()) {
                return 0;
            }
            if (deviceName.isEmpty()) {
                return Integer.MAX_VALUE;
            }
            if (deviceName2.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return deviceName.compareToIgnoreCase(deviceName2);
        }
    }
}
