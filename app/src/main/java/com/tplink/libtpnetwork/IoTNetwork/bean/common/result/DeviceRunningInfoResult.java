package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.util.Base64TypeAdapter;

/* loaded from: classes3.dex */
public class DeviceRunningInfoResult {
    protected String avatar;
    @c("default_states")
    protected DefaultStatesBean defaultStates;
    @c("device_on")
    protected boolean deviceOn;
    @c("fw_ver")
    protected String fwVer;
    @c("has_set_location_info")
    protected boolean hasSetLocationInfo;
    protected String ip;
    protected String lang;
    protected Integer latitude;
    @Deprecated
    protected String location;
    protected Integer longitude;
    @b(Base64TypeAdapter.class)
    protected String nickname;
    @c("on_time")
    @Deprecated
    protected long onTime;
    @c("overheated")
    protected boolean overheated;
    protected Integer rssi;
    @c("signal_level")
    protected int signalLevel;

    public String getAvatar() {
        return this.avatar;
    }

    public DefaultStatesBean getDefaultStates() {
        return this.defaultStates;
    }

    public String getFwVer() {
        return this.fwVer;
    }

    public String getIp() {
        return this.ip;
    }

    public String getLang() {
        return this.lang;
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

    public long getOnTime() {
        return this.onTime;
    }

    public Integer getRssi() {
        return this.rssi;
    }

    public int getSignalLevel() {
        return this.signalLevel;
    }

    public boolean isDeviceOn() {
        return this.deviceOn;
    }

    public boolean isHasSetLocationInfo() {
        Integer num;
        return this.hasSetLocationInfo && (num = this.longitude) != null && this.latitude != null && Math.abs(num.intValue()) <= 1800000 && Math.abs(this.latitude.intValue()) <= 900000;
    }

    public boolean isOverheated() {
        return this.overheated;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setDefaultStates(DefaultStatesBean defaultStatesBean) {
        this.defaultStates = defaultStatesBean;
    }

    public void setDeviceOn(boolean z) {
        this.deviceOn = z;
    }

    public void setFwVer(String str) {
        this.fwVer = str;
    }

    public void setHasSetLocationInfo(boolean z) {
        this.hasSetLocationInfo = z;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setLang(String str) {
        this.lang = str;
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

    public void setOnTime(long j) {
        this.onTime = j;
    }

    public void setOverheated(boolean z) {
        this.overheated = z;
    }

    public void setRssi(Integer num) {
        this.rssi = num;
    }

    public void setSignalLevel(int i) {
        this.signalLevel = i;
    }
}
