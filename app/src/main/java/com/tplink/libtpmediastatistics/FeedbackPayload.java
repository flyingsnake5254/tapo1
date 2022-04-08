package com.tplink.libtpmediastatistics;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class FeedbackPayload {
    private Map<String, Object> data = new HashMap();
    private String type;
    private String version;

    public void addData(String str, Object obj) {
        this.data.put(str, obj);
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public String getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public void setData(Map<String, Object> map) {
        this.data = map;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return MediaJsonUtils.toJSON(this);
    }
}
