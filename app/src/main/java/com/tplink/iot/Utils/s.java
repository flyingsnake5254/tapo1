package com.tplink.iot.Utils;

import com.tplink.iot.model.home.HomeCacheBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ListUtils.java */
/* loaded from: classes2.dex */
public class s {
    public static List<HomeCacheBean> a(List<HomeCacheBean> list) {
        ArrayList arrayList = new ArrayList();
        for (HomeCacheBean homeCacheBean : list) {
            HomeCacheBean homeCacheBean2 = new HomeCacheBean();
            homeCacheBean2.cloneHomeCacheBean(homeCacheBean);
            arrayList.add(homeCacheBean2);
        }
        return arrayList;
    }

    public static boolean b(List list) {
        return list == null || list.isEmpty();
    }
}
