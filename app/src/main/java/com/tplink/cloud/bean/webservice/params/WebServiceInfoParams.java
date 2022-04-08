package com.tplink.cloud.bean.webservice.params;

import java.util.List;

/* loaded from: classes2.dex */
public class WebServiceInfoParams {
    private List<String> serviceIds;

    public WebServiceInfoParams() {
    }

    public List<String> getServiceIds() {
        return this.serviceIds;
    }

    public void setServiceIds(List<String> list) {
        this.serviceIds = list;
    }

    public WebServiceInfoParams(List<String> list) {
        this.serviceIds = list;
    }
}
