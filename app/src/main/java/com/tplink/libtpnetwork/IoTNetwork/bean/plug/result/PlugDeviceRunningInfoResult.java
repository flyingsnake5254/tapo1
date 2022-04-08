package com.tplink.libtpnetwork.IoTNetwork.bean.plug.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingProperty;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.Utils.i;

/* loaded from: classes3.dex */
public class PlugDeviceRunningInfoResult extends DeviceRunningInfoResult {
    @c("led_enable")
    @Deprecated
    private boolean ledEnable;
    @c("time_usage_past30")
    private int timeUsagePast30;
    @c("time_usage_past7")
    private int timeUsagePast7;
    @c("time_usage_today")
    private int timeUsageToday;

    public PlugDeviceRunningInfoResult(ThingDetail thingDetail, ThingSetting thingSetting, ThingShadowResult thingShadowResult, ThingModel thingModel) {
        ThingProperty thingProperty;
        this.fwVer = thingDetail.getFwVer();
        this.ip = thingDetail.getIp();
        this.nickname = thingSetting.getNickname();
        this.avatar = thingSetting.getAvatarUrl();
        this.longitude = thingSetting.getLongitude();
        Integer latitude = thingSetting.getLatitude();
        this.latitude = latitude;
        Integer num = this.longitude;
        boolean z = true;
        this.hasSetLocationInfo = num != null && latitude != null && Math.abs(num.intValue()) <= 1800000 && Math.abs(this.latitude.intValue()) <= 900000;
        this.defaultStates = (DefaultStatesBean) i.a(thingSetting.getDefaultStates(), DefaultStatesBean.class);
        if (thingModel != null && (thingProperty = thingModel.getThingProperty("on")) != null) {
            Object reportedValue = thingShadowResult.getReportedValue(thingProperty);
            this.deviceOn = (!(reportedValue instanceof Boolean) || !((Boolean) reportedValue).booleanValue()) ? false : z;
        }
    }

    public int getTimeUsagePast30() {
        return this.timeUsagePast30;
    }

    public int getTimeUsagePast7() {
        return this.timeUsagePast7;
    }

    public int getTimeUsageToday() {
        return this.timeUsageToday;
    }

    public boolean isLedEnable() {
        return this.ledEnable;
    }

    public void setLedEnable(boolean z) {
        this.ledEnable = z;
    }

    public void setTimeUsagePast30(int i) {
        this.timeUsagePast30 = i;
    }

    public void setTimeUsagePast7(int i) {
        this.timeUsagePast7 = i;
    }

    public void setTimeUsageToday(int i) {
        this.timeUsageToday = i;
    }
}
