package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;

/* loaded from: classes2.dex */
public class ThingInfo {
    private String appServerUrl;
    private String avatarUrl;
    private String category;
    private String cloudGatewayUrl;
    private String cloudGatewayUrlV2;
    private boolean commonDevice;
    private String deviceType;
    private String edgeThingName;
    private String familyId;
    private boolean isSubThing;
    private String mac;
    private String model;
    @b(Base64TypeAdapter.class)
    private String nickname;
    private int onboardingTime;
    private String originalThingName;
    private int position;
    private String region;
    private int role;
    private String roomId;
    private int slotNumber;
    private int status;
    private String thingModelId;
    private String thingName;

    public String getAppServerUrl() {
        return this.appServerUrl;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCloudGatewayUrl() {
        return this.cloudGatewayUrl;
    }

    public String getCloudGatewayUrlV2() {
        return this.cloudGatewayUrlV2;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getEdgeThingName() {
        return this.edgeThingName;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String getMac() {
        return this.mac;
    }

    public String getModel() {
        return this.model;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getOnboardingTime() {
        return this.onboardingTime;
    }

    public String getOriginalThingName() {
        return this.originalThingName;
    }

    public int getPosition() {
        return this.position;
    }

    public String getRegion() {
        return this.region;
    }

    public int getRole() {
        return this.role;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public int getSlotNumber() {
        return this.slotNumber;
    }

    public int getStatus() {
        return this.status;
    }

    public String getThingModelId() {
        return this.thingModelId;
    }

    public String getThingName() {
        return this.thingName;
    }

    public boolean isCommonDevice() {
        return this.commonDevice;
    }

    public boolean isSubThing() {
        return this.isSubThing;
    }

    public void setAppServerUrl(String str) {
        this.appServerUrl = str;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCloudGatewayUrl(String str) {
        this.cloudGatewayUrl = str;
    }

    public void setCloudGatewayUrlV2(String str) {
        this.cloudGatewayUrlV2 = str;
    }

    public void setCommonDevice(boolean z) {
        this.commonDevice = z;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setEdgeThingName(String str) {
        this.edgeThingName = str;
    }

    public void setFamilyId(String str) {
        this.familyId = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOnboardingTime(int i) {
        this.onboardingTime = i;
    }

    public void setOriginalThingName(String str) {
        this.originalThingName = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setRole(int i) {
        this.role = i;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setSlotNumber(int i) {
        this.slotNumber = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setSubThing(boolean z) {
        this.isSubThing = z;
    }

    public void setThingModelId(String str) {
        this.thingModelId = str;
    }

    public void setThingName(String str) {
        this.thingName = str;
    }
}
