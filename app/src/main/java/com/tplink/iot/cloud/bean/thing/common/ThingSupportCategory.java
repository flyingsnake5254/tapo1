package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.c;
import java.util.List;

/* loaded from: classes2.dex */
public class ThingSupportCategory {
    @c("device_category_list")
    private List<SubThingCategoryBean> deviceCategoryList;

    public List<SubThingCategoryBean> getDeviceCategoryList() {
        return this.deviceCategoryList;
    }

    public void setDeviceCategoryList(List<SubThingCategoryBean> list) {
        this.deviceCategoryList = list;
    }
}
