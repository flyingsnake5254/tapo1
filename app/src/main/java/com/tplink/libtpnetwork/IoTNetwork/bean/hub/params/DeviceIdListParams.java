package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

import com.google.gson.q.c;
import java.util.List;

/* loaded from: classes3.dex */
public class DeviceIdListParams {
    @c("child_device_list")
    private List<DeviceIdBean> childDeviceList;

    public DeviceIdListParams() {
    }

    public List<DeviceIdBean> getChildDeviceList() {
        return this.childDeviceList;
    }

    public void setChildDeviceList(List<DeviceIdBean> list) {
        this.childDeviceList = list;
    }

    public DeviceIdListParams(List<DeviceIdBean> list) {
        this.childDeviceList = list;
    }
}
