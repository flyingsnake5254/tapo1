package com.tplink.iot.cloud.bean.thing.params;

import com.google.gson.q.c;
import java.util.List;

/* loaded from: classes2.dex */
public class SubThingAddListParams {
    @c("child_device_list")
    private List<SubThingAddParams> childDeviceList;

    public SubThingAddListParams() {
    }

    public List<SubThingAddParams> getChildDeviceList() {
        return this.childDeviceList;
    }

    public void setChildDeviceList(List<SubThingAddParams> list) {
        this.childDeviceList = list;
    }

    public SubThingAddListParams(List<SubThingAddParams> list) {
        this.childDeviceList = list;
    }
}
