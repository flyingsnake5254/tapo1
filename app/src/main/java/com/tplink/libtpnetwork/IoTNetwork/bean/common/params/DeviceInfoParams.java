package com.tplink.libtpnetwork.IoTNetwork.bean.common.params;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class DeviceInfoParams {
    private String avatar;
    @c("default_states")
    private DefaultStatesBean defaultStates;
    @c("device_on")
    private Boolean deviceOn;
    private Integer latitude;
    @Deprecated
    private String location;
    private Integer longitude;
    @b(Base64TypeAdapter.class)
    private String nickname;

    public DeviceInfoParams() {
    }

    public String getAvatar() {
        return this.avatar;
    }

    public DefaultStatesBean getDefaultStates() {
        return this.defaultStates;
    }

    public Boolean getDeviceOn() {
        return this.deviceOn;
    }

    public Integer getLatitude() {
        return this.latitude;
    }

    public String getLocation() {
        return this.location;
    }

    public Integer getLongitude() {
        return this.longitude;
    }

    public String getNickname() {
        return this.nickname;
    }

    public boolean isMatchThingModel(ThingModel thingModel) {
        return (thingModel == null || thingModel.getThingProperty("on") == null) ? false : true;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setDefaultStates(DefaultStatesBean defaultStatesBean) {
        this.defaultStates = defaultStatesBean;
    }

    public void setDeviceOn(Boolean bool) {
        this.deviceOn = bool;
    }

    public void setLatitude(Integer num) {
        this.latitude = num;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setLongitude(Integer num) {
        this.longitude = num;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public Map<String, Object> toMap() {
        return toMap(null);
    }

    public ThingSetting toThingSetting() {
        ThingSetting thingSetting = new ThingSetting();
        thingSetting.setNickname(this.nickname);
        thingSetting.setAvatarUrl(this.avatar);
        thingSetting.setLongitude(this.longitude);
        thingSetting.setLatitude(this.latitude);
        return thingSetting;
    }

    public DeviceInfoParams(String str, String str2) {
        this.nickname = str;
        this.avatar = str2;
    }

    public Map<String, Object> toMap(Map<String, Object> map) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        Boolean bool = this.deviceOn;
        if (bool != null) {
            hashMap.put("on", bool);
        }
        return hashMap;
    }

    public DeviceInfoParams(Integer num, Integer num2) {
        this.longitude = num;
        this.latitude = num2;
    }
}
