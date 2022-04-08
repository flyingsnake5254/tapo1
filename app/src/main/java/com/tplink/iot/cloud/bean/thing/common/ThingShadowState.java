package com.tplink.iot.cloud.bean.thing.common;

import androidx.annotation.NonNull;
import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import java.util.Map;

/* loaded from: classes2.dex */
public class ThingShadowState {
    @b(MapJsonAdapter.class)
    private Map<String, Object> desired;
    @b(MapJsonAdapter.class)
    private Map<String, Object> reported;

    public ThingShadowState() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0203, code lost:
        if (r12.getWhiteList().l(new com.google.gson.m(r11)) == false) goto L_0x0205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x026e, code lost:
        if (r12.getWhiteList().l(new com.google.gson.m(r11)) == false) goto L_0x0270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0190, code lost:
        if (r12.getWhiteList().l(new com.google.gson.m(r11)) == false) goto L_0x0192;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object getFormattedValue(java.util.Map<java.lang.String, java.lang.Object> r11, @androidx.annotation.NonNull com.tplink.iot.cloud.bean.thing.common.ThingProperty r12) {
        /*
            Method dump skipped, instructions count: 746
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.cloud.bean.thing.common.ThingShadowState.getFormattedValue(java.util.Map, com.tplink.iot.cloud.bean.thing.common.ThingProperty):java.lang.Object");
    }

    public Map<String, Object> getDesired() {
        return this.desired;
    }

    public Object getDesiredValue(@NonNull ThingProperty thingProperty) {
        return getFormattedValue(this.desired, thingProperty);
    }

    public Map<String, Object> getReported() {
        return this.reported;
    }

    public Object getReportedValue(@NonNull ThingProperty thingProperty) {
        return getFormattedValue(this.reported, thingProperty);
    }

    public void setDesired(Map<String, Object> map) {
        this.desired = map;
    }

    public void setReported(Map<String, Object> map) {
        this.reported = map;
    }

    public ThingShadowState(Map<String, Object> map) {
        this.desired = map;
    }

    public ThingShadowState(Map<String, Object> map, Map<String, Object> map2) {
        this.desired = map;
        this.reported = map2;
    }
}
