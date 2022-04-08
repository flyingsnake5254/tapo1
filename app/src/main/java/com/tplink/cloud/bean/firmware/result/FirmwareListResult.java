package com.tplink.cloud.bean.firmware.result;

import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FirmwareListResult {
    @c(alternate = {"fwVersions"}, value = "fwList")
    private List<FirmwareInfoResult> fwList = new ArrayList();

    public List<FirmwareInfoResult> getFwList() {
        return this.fwList;
    }

    public void setFwList(List<FirmwareInfoResult> list) {
        this.fwList = list;
    }
}
