package com.tplink.iot.cloud.bean.group.params;

import java.util.List;

/* loaded from: classes2.dex */
public class GroupThingGroupListParams {
    private List<String> groupIds;
    private List<String> thingNames;

    public GroupThingGroupListParams() {
    }

    public List<String> getGroupIds() {
        return this.groupIds;
    }

    public List<String> getThingNames() {
        return this.thingNames;
    }

    public void setGroupIds(List<String> list) {
        this.groupIds = list;
    }

    public void setThingNames(List<String> list) {
        this.thingNames = list;
    }

    public GroupThingGroupListParams(List<String> list, List<String> list2) {
        this.thingNames = list;
        this.groupIds = list2;
    }
}
