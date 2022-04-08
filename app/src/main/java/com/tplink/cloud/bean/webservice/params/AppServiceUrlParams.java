package com.tplink.cloud.bean.webservice.params;

import java.util.List;

/* loaded from: classes2.dex */
public class AppServiceUrlParams {
    private List<String> serviceIds;

    public AppServiceUrlParams() {
    }

    public List<String> getServiceIds() {
        return this.serviceIds;
    }

    public void setServiceIds(List<String> list) {
        this.serviceIds = list;
    }

    public AppServiceUrlParams(List<String> list) {
        this.serviceIds = list;
    }
}
