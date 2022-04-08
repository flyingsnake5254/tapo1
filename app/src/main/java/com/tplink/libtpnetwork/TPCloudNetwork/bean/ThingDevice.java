package com.tplink.libtpnetwork.TPCloudNetwork.bean;

import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.common.ThingShadowState;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ThingDevice implements Serializable {
    private ThingInfo mThingInfo;
    private ThingSetting mThingSetting;
    private ThingShadow mThingShadow;

    public ThingDevice(ThingInfo thingInfo) {
        this.mThingInfo = thingInfo;
    }

    public String getCategory() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getCategory();
        }
        return null;
    }

    public String getDeviceType() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getDeviceType();
        }
        return null;
    }

    public String getEdgeThingName() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getEdgeThingName();
        }
        return null;
    }

    public String getFamilyId() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getFamilyId();
        }
        return null;
    }

    public String getLang() {
        ThingSetting thingSetting = this.mThingSetting;
        if (thingSetting != null) {
            return thingSetting.getLang();
        }
        return null;
    }

    public String getMac() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getMac();
        }
        return null;
    }

    public String getModel() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getModel();
        }
        return null;
    }

    public String getNickname() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getNickname();
        }
        return null;
    }

    public int getOnBoardingTime() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getOnboardingTime();
        }
        return 0;
    }

    public String getRoomId() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getRoomId();
        }
        return null;
    }

    public String getThingGatewayUrl() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getCloudGatewayUrl();
        }
        return null;
    }

    public String getThingGatewayUrlV2() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getCloudGatewayUrlV2();
        }
        return null;
    }

    public ThingInfo getThingInfo() {
        return this.mThingInfo;
    }

    public String getThingModelId() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getThingModelId();
        }
        return null;
    }

    public String getThingName() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getThingName();
        }
        return null;
    }

    public ThingSetting getThingSetting() {
        return this.mThingSetting;
    }

    public ThingShadow getThingShadow() {
        return this.mThingShadow;
    }

    public String getThingUrl() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.getAppServerUrl();
        }
        return null;
    }

    public boolean isCamera() {
        return EnumDeviceType.CAMERA == EnumDeviceType.fromType(getDeviceType());
    }

    public boolean isCommonDevice() {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            return thingInfo.isCommonDevice();
        }
        return true;
    }

    public boolean isHasThingInfo() {
        return this.mThingInfo != null;
    }

    public boolean isSubThing() {
        ThingInfo thingInfo = this.mThingInfo;
        return thingInfo != null && thingInfo.isSubThing();
    }

    public boolean isThingOnline() {
        ThingInfo thingInfo = this.mThingInfo;
        return thingInfo != null && thingInfo.getStatus() == 1;
    }

    public void setCommonDevice(boolean z) {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            thingInfo.setCommonDevice(z);
        }
    }

    public void setFamilyId(String str) {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            thingInfo.setFamilyId(str);
        }
    }

    public void setRoomId(String str) {
        ThingInfo thingInfo = this.mThingInfo;
        if (thingInfo != null) {
            thingInfo.setFamilyId(str);
        }
    }

    public void setThingInfo(ThingInfo thingInfo) {
        this.mThingInfo = thingInfo;
    }

    public void setThingSetting(ThingSetting thingSetting) {
        this.mThingSetting = thingSetting;
    }

    public void setThingShadow(ThingShadow thingShadow) {
        this.mThingShadow = thingShadow;
    }

    public void updateThingShadow(long j, Map<String, Object> map, Map<String, Object> map2) {
        ThingShadow thingShadow = this.mThingShadow;
        if (thingShadow == null) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            this.mThingShadow = new ThingShadow(j, new ThingShadowState(map, map2));
        } else if (j >= thingShadow.getVersion()) {
            this.mThingShadow.setVersion(j);
            if (map != null) {
                Map<String, Object> desired = this.mThingShadow.getState().getDesired();
                if (desired == null) {
                    this.mThingShadow.getState().setDesired(new HashMap(map));
                } else {
                    desired.putAll(map);
                }
            }
            if (map2 != null) {
                Map<String, Object> reported = this.mThingShadow.getState().getReported();
                if (reported == null) {
                    this.mThingShadow.getState().setReported(new HashMap(map2));
                    return;
                }
                reported.putAll(map2);
            }
        }
    }
}
