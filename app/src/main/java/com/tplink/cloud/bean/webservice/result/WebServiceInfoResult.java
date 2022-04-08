package com.tplink.cloud.bean.webservice.result;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class WebServiceInfoResult {
    private Map<String, String> serviceUrls = new HashMap();

    public Map<String, String> getServiceUrls() {
        return this.serviceUrls;
    }

    public void setServiceUrls(Map<String, String> map) {
        this.serviceUrls = map;
    }
}
