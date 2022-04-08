package com.tplink.cloud.bean.device.result;

import com.google.gson.i;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class DeviceFeatureResult {
    private Map<String, i> featureInfo = new HashMap();

    public Map<String, i> getFeatureInfo() {
        return this.featureInfo;
    }

    public void setFeatureInfo(Map<String, i> map) {
        this.featureInfo = map;
    }
}
