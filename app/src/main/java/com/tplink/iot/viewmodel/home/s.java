package com.tplink.iot.viewmodel.home;

import android.text.TextUtils;
import b.d.w.h.a;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.model.home.HomeCacheBean;
import com.tplink.iot.model.home.g;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: HomeDataCombineUtils.java */
/* loaded from: classes2.dex */
public class s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Map<String, k> map, List<BaseALIoTDevice> list) {
        if (list == null || list.isEmpty()) {
            map.clear();
        } else if (map.isEmpty()) {
            for (BaseALIoTDevice baseALIoTDevice : list) {
                map.put(baseALIoTDevice.getDeviceIdMD5(), new k(baseALIoTDevice));
            }
        } else {
            HashSet<String> hashSet = new HashSet(map.keySet());
            for (BaseALIoTDevice baseALIoTDevice2 : list) {
                k kVar = map.get(baseALIoTDevice2.getDeviceIdMD5());
                if (kVar != null) {
                    kVar.x(baseALIoTDevice2);
                } else {
                    k kVar2 = new k(baseALIoTDevice2);
                    kVar2.C(Integer.MIN_VALUE);
                    map.put(baseALIoTDevice2.getDeviceIdMD5(), kVar2);
                }
                hashSet.remove(baseALIoTDevice2.getDeviceIdMD5());
            }
            for (String str : hashSet) {
                map.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Map<String, g> map, List<GroupInfo> list) {
        if (list == null || list.isEmpty()) {
            map.clear();
        } else if (map.isEmpty()) {
            for (GroupInfo groupInfo : list) {
                String g = a.g(groupInfo.getId());
                if (!TextUtils.isEmpty(g)) {
                    map.put(g, new g(new GroupBean(groupInfo)));
                }
            }
        } else {
            HashSet<String> hashSet = new HashSet(map.keySet());
            for (GroupInfo groupInfo2 : list) {
                String g2 = a.g(groupInfo2.getId());
                g gVar = map.get(g2);
                if (gVar != null) {
                    gVar.l(groupInfo2);
                } else {
                    map.put(g2, new g(new GroupBean(groupInfo2)));
                }
                hashSet.remove(g2);
            }
            for (String str : hashSet) {
                map.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Map<String, k> map, List<HomeCacheBean> list) {
        if (!(list == null || list.isEmpty())) {
            if (map.isEmpty()) {
                for (HomeCacheBean homeCacheBean : list) {
                    map.put(homeCacheBean.getDeviceIdMD5(), new k(homeCacheBean));
                }
                return;
            }
            for (HomeCacheBean homeCacheBean2 : list) {
                k kVar = map.get(homeCacheBean2.getDeviceIdMD5());
                if (kVar != null) {
                    kVar.z(homeCacheBean2);
                } else {
                    map.put(homeCacheBean2.getDeviceIdMD5(), new k(homeCacheBean2));
                }
            }
        }
    }
}
