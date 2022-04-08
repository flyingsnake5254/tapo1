package com.tplink.iot.cloud.bean.cloudvideo.result;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceVideoDateResult<T> {
    private List<T> dateList = new ArrayList();

    public List<T> getDateList() {
        return this.dateList;
    }

    public void setDateList(List<T> list) {
        this.dateList = list;
    }
}
