package com.tplink.iot.cloud.bean.family.params;

import java.util.List;

/* loaded from: classes2.dex */
public class ThingFamilyParams {
    private String familyId;
    private String roomId;
    private List<String> thingNames;

    public ThingFamilyParams() {
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public List<String> getThingNames() {
        return this.thingNames;
    }

    public void setFamilyId(String str) {
        this.familyId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setThingNames(List<String> list) {
        this.thingNames = list;
    }

    public ThingFamilyParams(String str, List<String> list) {
        this.familyId = str;
        this.thingNames = list;
    }

    public ThingFamilyParams(String str, String str2, List<String> list) {
        this.familyId = str;
        this.roomId = str2;
        this.thingNames = list;
    }
}
