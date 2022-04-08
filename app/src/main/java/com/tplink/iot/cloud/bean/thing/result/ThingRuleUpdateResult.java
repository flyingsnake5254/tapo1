package com.tplink.iot.cloud.bean.thing.result;

import com.google.gson.q.c;

/* loaded from: classes2.dex */
public class ThingRuleUpdateResult {
    @c("conflict_id")
    private String conflictId;
    @c("end_min")
    private int endMin;
    private String id;
    @c(alternate = {"s_min"}, value = "start_min")
    private int startMin;

    public String getConflictId() {
        return this.conflictId;
    }

    public int getEndMin() {
        return this.endMin;
    }

    public String getId() {
        return this.id;
    }

    public int getStartMin() {
        return this.startMin;
    }

    public void setConflictId(String str) {
        this.conflictId = str;
    }

    public void setEndMin(int i) {
        this.endMin = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setStartMin(int i) {
        this.startMin = i;
    }
}
