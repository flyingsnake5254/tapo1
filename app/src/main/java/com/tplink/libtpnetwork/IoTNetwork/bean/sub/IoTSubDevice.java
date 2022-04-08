package com.tplink.libtpnetwork.IoTNetwork.bean.sub;

import android.text.TextUtils;
import b.d.w.c.a;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingProperty;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.SubDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.SubDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.enumerate.EnumTRVState;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class IoTSubDevice extends LocalIoTBaseDevice {
    private transient boolean atLowBattery;
    @c("bind_count")
    private int bindCount;
    private String category;
    @c(ThingModelDefine.Property.PROPERTY_CURRENT_TEMP)
    private float currentTemp;
    @c(ThingModelDefine.Property.PROPERTY_FROST_PROTECTION_ON)
    private boolean frostProtectionOn;
    private transient long latestLogTimestamp;
    @c(ThingModelDefine.Property.PROPERTY_MAX_CONTROL_TEMP)
    private int maxControlTemp;
    @c(ThingModelDefine.Property.PROPERTY_MIN_CONTROL_TEMP)
    private int minControlTemp;
    @c("original_device_id")
    private String originalDeviceId;
    private int position;
    @c("slot_number")
    private int slotNumber;
    private String status;
    @c(ThingModelDefine.Property.PROPERTY_TARGET_TEMP)
    private int targetTemp;
    @c(ThingModelDefine.Property.PROPERTY_TEMP_OFFSET)
    private int tempOffset;
    @c(ThingModelDefine.Property.PROPERTY_TEMP_UNIT)
    private String tempUnit;
    @c(ThingModelDefine.Property.PROPERTY_TRV_STATES)
    private List<EnumTRVState> trvStates;

    public IoTSubDevice() {
        this.latestLogTimestamp = -1L;
        this.atLowBattery = false;
    }

    public int getBindCount() {
        return this.bindCount;
    }

    public String getCategory() {
        return this.category;
    }

    public float getCurrentTemp() {
        return this.currentTemp;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice
    public DeviceInfoParams getDeviceInfoParams() {
        SubDeviceInfoParams subDeviceInfoParams = new SubDeviceInfoParams();
        subDeviceInfoParams.setNickname(this.nickname);
        subDeviceInfoParams.setAvatar(this.avatar);
        subDeviceInfoParams.setDeviceOn(Boolean.valueOf(this.deviceOn));
        subDeviceInfoParams.setLongitude(this.longitude);
        subDeviceInfoParams.setLatitude(this.latitude);
        subDeviceInfoParams.setTempUnit(this.tempUnit);
        subDeviceInfoParams.setTargetTemp(Integer.valueOf(this.targetTemp));
        subDeviceInfoParams.setTempOffset(Integer.valueOf(this.tempOffset));
        subDeviceInfoParams.setFrostProtectionOn(Boolean.valueOf(this.frostProtectionOn));
        subDeviceInfoParams.setMinControlTemp(Integer.valueOf(this.minControlTemp));
        subDeviceInfoParams.setMaxControlTemp(Integer.valueOf(this.maxControlTemp));
        return subDeviceInfoParams;
    }

    public EnumTemperatureUnit getEnumTempUnit() {
        return EnumTemperatureUnit.fromString(getTempUnit());
    }

    public long getLatestLogTimestamp() {
        return this.latestLogTimestamp;
    }

    public int getMaxControlTemp() {
        return this.maxControlTemp;
    }

    public int getMinControlTemp() {
        return this.minControlTemp;
    }

    public String getOriginalDeviceId() {
        return this.originalDeviceId;
    }

    public int getPosition() {
        return this.position;
    }

    public int getSlotNumber() {
        return this.slotNumber;
    }

    public String getStatus() {
        return this.status;
    }

    public int getTargetTemp() {
        return this.targetTemp;
    }

    public int getTempOffset() {
        return this.tempOffset;
    }

    public String getTempUnit() {
        return this.tempUnit;
    }

    public List<EnumTRVState> getTrvStates() {
        return this.trvStates;
    }

    public boolean isAtLowBattery() {
        return this.atLowBattery;
    }

    public boolean isFrostProtectionOn() {
        return this.frostProtectionOn;
    }

    public void setAtLowBattery(boolean z) {
        this.atLowBattery = z;
    }

    public void setBindCount(int i) {
        this.bindCount = i;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCurrentTemp(float f2) {
        this.currentTemp = f2;
    }

    public void setFrostProtectionOn(boolean z) {
        this.frostProtectionOn = z;
    }

    public void setLatestLogTimestamp(long j) {
        this.latestLogTimestamp = j;
    }

    public void setMaxControlTemp(int i) {
        this.maxControlTemp = i;
    }

    public void setMinControlTemp(int i) {
        this.minControlTemp = i;
    }

    public void setOriginalDeviceId(String str) {
        this.originalDeviceId = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setSlotNumber(int i) {
        this.slotNumber = i;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTargetTemp(int i) {
        this.targetTemp = i;
    }

    public void setTempOffset(int i) {
        this.tempOffset = i;
    }

    public void setTempUnit(String str) {
        this.tempUnit = str;
    }

    public void setTrvStates(List<EnumTRVState> list) {
        this.trvStates = list;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice
    public void updateDeviceInfoParam(DeviceInfoParams deviceInfoParams) {
        super.updateDeviceInfoParam(deviceInfoParams);
        if (deviceInfoParams instanceof SubDeviceInfoParams) {
            SubDeviceInfoParams subDeviceInfoParams = (SubDeviceInfoParams) deviceInfoParams;
            if (subDeviceInfoParams.getTempUnit() != null) {
                this.tempUnit = subDeviceInfoParams.getTempUnit();
            }
            if (subDeviceInfoParams.getTargetTemp() != null) {
                this.targetTemp = subDeviceInfoParams.getTargetTemp().intValue();
            }
            if (subDeviceInfoParams.getTempOffset() != null) {
                this.tempOffset = subDeviceInfoParams.getTempOffset().intValue();
            }
            if (subDeviceInfoParams.getFrostProtectionOn() != null) {
                this.frostProtectionOn = subDeviceInfoParams.getFrostProtectionOn().booleanValue();
            }
            if (subDeviceInfoParams.getMinControlTemp() != null) {
                this.minControlTemp = subDeviceInfoParams.getMinControlTemp().intValue();
            }
            if (subDeviceInfoParams.getMaxControlTemp() != null) {
                this.maxControlTemp = subDeviceInfoParams.getMaxControlTemp().intValue();
            }
        }
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice
    public void updateDeviceRunningInfo(DeviceRunningInfoResult deviceRunningInfoResult, boolean z) {
        if (deviceRunningInfoResult != null) {
            if (!TextUtils.isEmpty(deviceRunningInfoResult.getFwVer())) {
                this.fwVer = deviceRunningInfoResult.getFwVer();
            }
            this.nickname = deviceRunningInfoResult.getNickname();
            this.avatar = deviceRunningInfoResult.getAvatar();
            this.deviceOn = deviceRunningInfoResult.isDeviceOn();
            this.overheated = deviceRunningInfoResult.isOverheated();
            this.hasSetLocationInfo = deviceRunningInfoResult.isHasSetLocationInfo();
            if (!(deviceRunningInfoResult.getLongitude() == null || deviceRunningInfoResult.getLatitude() == null)) {
                this.longitude = deviceRunningInfoResult.getLongitude();
                this.latitude = deviceRunningInfoResult.getLatitude();
            }
            this.lang = deviceRunningInfoResult.getLang();
            this.defaultStates = deviceRunningInfoResult.getDefaultStates();
        }
        if (deviceRunningInfoResult instanceof SubDeviceRunningInfoResult) {
            SubDeviceRunningInfoResult subDeviceRunningInfoResult = (SubDeviceRunningInfoResult) deviceRunningInfoResult;
            if (z) {
                this.atLowBattery = subDeviceRunningInfoResult.isAtLowBattery();
            }
            if (!TextUtils.isEmpty(subDeviceRunningInfoResult.getStatus())) {
                this.status = subDeviceRunningInfoResult.getStatus();
            }
            this.bindCount = subDeviceRunningInfoResult.getBindCount();
            this.tempUnit = subDeviceRunningInfoResult.getTempUnit();
            this.currentTemp = subDeviceRunningInfoResult.getCurrentTemp();
            this.targetTemp = subDeviceRunningInfoResult.getTargetTemp();
            this.minControlTemp = subDeviceRunningInfoResult.getMinControlTemp();
            this.maxControlTemp = subDeviceRunningInfoResult.getMaxControlTemp();
            this.tempOffset = subDeviceRunningInfoResult.getTempOffset();
            this.frostProtectionOn = subDeviceRunningInfoResult.isFrostProtectionOn();
            this.trvStates = subDeviceRunningInfoResult.getTrvStates();
        }
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice
    public void updateDeviceShadow(Map<String, Object> map) {
        super.updateDeviceShadow(map);
        if (map != null) {
            boolean z = true;
            if (map.containsKey("on")) {
                Object obj = map.get("on");
                this.deviceOn = (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_AT_LOW_BATTERY)) {
                Object obj2 = map.get(ThingModelDefine.Property.PROPERTY_AT_LOW_BATTERY);
                this.atLowBattery = (obj2 instanceof Boolean) && ((Boolean) obj2).booleanValue();
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_TEMP_UNIT)) {
                Object obj3 = map.get(ThingModelDefine.Property.PROPERTY_TEMP_UNIT);
                this.tempUnit = obj3 instanceof String ? (String) obj3 : "celsius";
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_CURRENT_TEMP)) {
                Object obj4 = map.get(ThingModelDefine.Property.PROPERTY_CURRENT_TEMP);
                this.currentTemp = obj4 instanceof Number ? ((Number) obj4).floatValue() : 0.0f;
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_TARGET_TEMP)) {
                Object obj5 = map.get(ThingModelDefine.Property.PROPERTY_TARGET_TEMP);
                this.targetTemp = obj5 instanceof Number ? ((Number) obj5).intValue() : 0;
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_TEMP_OFFSET)) {
                Object obj6 = map.get(ThingModelDefine.Property.PROPERTY_TEMP_OFFSET);
                this.tempOffset = obj6 instanceof Number ? ((Number) obj6).intValue() : 0;
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_MIN_CONTROL_TEMP)) {
                Object obj7 = map.get(ThingModelDefine.Property.PROPERTY_MIN_CONTROL_TEMP);
                this.minControlTemp = obj7 instanceof Number ? ((Number) obj7).intValue() : 0;
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_MAX_CONTROL_TEMP)) {
                Object obj8 = map.get(ThingModelDefine.Property.PROPERTY_MAX_CONTROL_TEMP);
                this.maxControlTemp = obj8 instanceof Number ? ((Number) obj8).intValue() : 0;
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_FROST_PROTECTION_ON)) {
                Object obj9 = map.get(ThingModelDefine.Property.PROPERTY_FROST_PROTECTION_ON);
                if (!(obj9 instanceof Boolean) || !((Boolean) obj9).booleanValue()) {
                    z = false;
                }
                this.frostProtectionOn = z;
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_TRV_STATES)) {
                Object obj10 = map.get(ThingModelDefine.Property.PROPERTY_TRV_STATES);
                ArrayList arrayList = new ArrayList();
                ArrayList<String> arrayList2 = new ArrayList();
                if (obj10 instanceof String[]) {
                    arrayList2.addAll(Arrays.asList((String[]) obj10));
                } else if (obj10 instanceof List) {
                    for (Object obj11 : (List) obj10) {
                        if (obj11 instanceof String) {
                            arrayList2.add((String) obj11);
                        }
                    }
                }
                for (String str : arrayList2) {
                    EnumTRVState fromString = EnumTRVState.fromString(str);
                    if (fromString != null) {
                        arrayList.add(fromString);
                    }
                }
                this.trvStates = arrayList;
                a.n("TRV", "enumTrvStates: " + i.j(arrayList));
            }
        }
    }

    public IoTSubDevice(ThingDetail thingDetail, ThingSetting thingSetting, ThingShadowResult thingShadowResult, ThingModel thingModel) {
        this.latestLogTimestamp = -1L;
        this.atLowBattery = false;
        this.deviceId = thingShadowResult.getThingName();
        this.type = thingDetail.getDeviceType();
        this.model = thingDetail.getModel();
        this.mac = thingDetail.getMac();
        this.hwVer = thingDetail.getHwVer();
        this.hwId = thingDetail.getHwId();
        this.fwVer = thingDetail.getFwVer();
        this.fwId = thingDetail.getFwId();
        this.oemId = thingDetail.getOemId();
        this.originalDeviceId = thingDetail.getOriginalThingName();
        this.slotNumber = thingDetail.getSlotNumber();
        this.position = thingDetail.getPosition();
        this.nickname = thingSetting.getNickname();
        this.avatar = thingSetting.getAvatarUrl();
        this.longitude = thingSetting.getLongitude();
        Integer latitude = thingSetting.getLatitude();
        this.latitude = latitude;
        Integer num = this.longitude;
        boolean z = true;
        this.hasSetLocationInfo = num != null && latitude != null && Math.abs(num.intValue()) <= 1800000 && Math.abs(this.latitude.intValue()) <= 900000;
        this.timeDiff = thingSetting.getTimeDiff().intValue();
        this.region = thingSetting.getRegion();
        this.lang = thingSetting.getLang();
        if (thingModel != null) {
            ThingProperty thingProperty = thingModel.getThingProperty("on");
            if (thingProperty != null) {
                Object reportedValue = thingShadowResult.getReportedValue(thingProperty);
                this.deviceOn = (reportedValue instanceof Boolean) && ((Boolean) reportedValue).booleanValue();
            }
            ThingProperty thingProperty2 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_AT_LOW_BATTERY);
            if (thingProperty2 != null) {
                Object reportedValue2 = thingShadowResult.getReportedValue(thingProperty2);
                this.atLowBattery = (reportedValue2 instanceof Boolean) && ((Boolean) reportedValue2).booleanValue();
            }
            ThingProperty thingProperty3 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_TEMP_UNIT);
            if (thingProperty3 != null) {
                Object reportedValue3 = thingShadowResult.getReportedValue(thingProperty3);
                this.tempUnit = reportedValue3 instanceof String ? (String) reportedValue3 : "celsius";
            }
            ThingProperty thingProperty4 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_CURRENT_TEMP);
            if (thingProperty4 != null) {
                Object reportedValue4 = thingShadowResult.getReportedValue(thingProperty4);
                this.currentTemp = reportedValue4 instanceof Number ? ((Number) reportedValue4).floatValue() : 0.0f;
            }
            ThingProperty thingProperty5 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_TARGET_TEMP);
            if (thingProperty5 != null) {
                Object reportedValue5 = thingShadowResult.getReportedValue(thingProperty5);
                this.targetTemp = reportedValue5 instanceof Number ? ((Number) reportedValue5).intValue() : 0;
            }
            ThingProperty thingProperty6 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_MIN_CONTROL_TEMP);
            if (thingProperty6 != null) {
                Object reportedValue6 = thingShadowResult.getReportedValue(thingProperty6);
                this.minControlTemp = reportedValue6 instanceof Number ? ((Number) reportedValue6).intValue() : 0;
            }
            ThingProperty thingProperty7 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_MAX_CONTROL_TEMP);
            if (thingProperty7 != null) {
                Object reportedValue7 = thingShadowResult.getReportedValue(thingProperty7);
                this.maxControlTemp = reportedValue7 instanceof Number ? ((Number) reportedValue7).intValue() : 0;
            }
            ThingProperty thingProperty8 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_TEMP_OFFSET);
            if (thingProperty8 != null) {
                Object reportedValue8 = thingShadowResult.getReportedValue(thingProperty8);
                this.tempOffset = reportedValue8 instanceof Number ? ((Number) reportedValue8).intValue() : 0;
            }
            ThingProperty thingProperty9 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_FROST_PROTECTION_ON);
            if (thingProperty9 != null) {
                Object reportedValue9 = thingShadowResult.getReportedValue(thingProperty9);
                this.frostProtectionOn = (!(reportedValue9 instanceof Boolean) || !((Boolean) reportedValue9).booleanValue()) ? false : z;
            }
            ThingProperty thingProperty10 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_TRV_STATES);
            if (thingProperty10 != null) {
                Object reportedValue10 = thingShadowResult.getReportedValue(thingProperty10);
                ArrayList arrayList = new ArrayList();
                if (reportedValue10 instanceof String[]) {
                    for (String str : (String[]) reportedValue10) {
                        EnumTRVState fromString = EnumTRVState.fromString(str);
                        if (fromString != null) {
                            arrayList.add(fromString);
                        }
                    }
                }
                a.n("TRV", "enumTrvStates: " + i.j(arrayList));
                this.trvStates = arrayList;
            }
        }
    }
}
