package com.tplink.iot.cloud.bean.thing.params;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.SubThingCategoryBean;
import java.util.List;

/* loaded from: classes2.dex */
public class SubThingCategoryScanParams {
    @c("scan_list")
    private List<SubThingCategoryBean> scanList;

    public List<SubThingCategoryBean> getScanList() {
        return this.scanList;
    }

    public void setScanList(List<SubThingCategoryBean> list) {
        this.scanList = list;
    }
}
