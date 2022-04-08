package com.tplink.cloud.bean.tool.params;

import java.util.List;

/* loaded from: classes2.dex */
public class LookupMacVendorParams {
    private List<String> ouis;

    public LookupMacVendorParams() {
    }

    public List<String> getOuis() {
        return this.ouis;
    }

    public void setOuis(List<String> list) {
        this.ouis = list;
    }

    public LookupMacVendorParams(List<String> list) {
        this.ouis = list;
    }
}
