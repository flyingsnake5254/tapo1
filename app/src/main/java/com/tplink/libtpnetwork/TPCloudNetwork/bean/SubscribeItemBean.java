package com.tplink.libtpnetwork.TPCloudNetwork.bean;

import android.text.TextUtils;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumMsgSubscribeType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class SubscribeItemBean implements Serializable {
    private static final int BIT_CAMERA_MOTION = 1;
    private static HashMap<EnumMsgSubscribeType, Integer> subscribeTypeBitMap;
    private String deviceId;
    private int deviceSubscribeOffBit;
    @Deprecated
    private int subscribeBit;

    static {
        HashMap<EnumMsgSubscribeType, Integer> hashMap = new HashMap<>();
        subscribeTypeBitMap = hashMap;
        hashMap.put(EnumMsgSubscribeType.CAMERA_MOTION, 1);
    }

    public SubscribeItemBean(String str) {
        this.deviceId = str;
    }

    private boolean isDeviceSubscribeByType(EnumMsgSubscribeType enumMsgSubscribeType) {
        Integer num;
        if (enumMsgSubscribeType == null || (num = subscribeTypeBitMap.get(enumMsgSubscribeType)) == null) {
            return false;
        }
        return (num.intValue() & this.deviceSubscribeOffBit) == 0;
    }

    public void addSubscribeFunc(EnumMsgSubscribeType enumMsgSubscribeType) {
        Integer num;
        if (enumMsgSubscribeType != null && (num = subscribeTypeBitMap.get(enumMsgSubscribeType)) != null) {
            int intValue = this.deviceSubscribeOffBit | num.intValue();
            this.deviceSubscribeOffBit = intValue;
            this.deviceSubscribeOffBit = num.intValue() ^ intValue;
        }
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getDeviceSubscribeOffBit() {
        return this.deviceSubscribeOffBit;
    }

    @Deprecated
    public int getSubscribeBit() {
        return this.subscribeBit;
    }

    public boolean isSubscribeCameraMotion() {
        return isDeviceSubscribeByType(EnumMsgSubscribeType.CAMERA_MOTION);
    }

    @Deprecated
    public boolean isSubscribeCameraMotionOld() {
        return (this.subscribeBit & 4) == 4;
    }

    @Deprecated
    public boolean isSubscribeNewFirmwareOld() {
        return (this.subscribeBit & 1) == 1;
    }

    public void removeSubscribeFunc(EnumMsgSubscribeType enumMsgSubscribeType) {
        Integer num;
        if (enumMsgSubscribeType != null && (num = subscribeTypeBitMap.get(enumMsgSubscribeType)) != null) {
            this.deviceSubscribeOffBit = num.intValue() | this.deviceSubscribeOffBit;
        }
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceSubscribeOffBit(int i) {
        this.deviceSubscribeOffBit = i;
    }

    @Deprecated
    public void setSubscribeBit(int i) {
        this.subscribeBit = i;
    }

    public List<String> toSubscribeList(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.deviceId)) {
            boolean b0 = o.h0().b0();
            boolean e0 = o.h0().e0();
            EnumDeviceType fromType = TextUtils.isEmpty(str) ? EnumDeviceType.UNKNOWN : EnumDeviceType.fromType(str);
            EnumDeviceType enumDeviceType = EnumDeviceType.CAMERA;
            if (fromType == enumDeviceType && b0 && e0 && this.deviceSubscribeOffBit == 0) {
                arrayList.add(EnumMsgSubscribeType.ALL.getName());
            } else if (!b0 || this.deviceSubscribeOffBit != 0) {
                if (b0) {
                    arrayList.add(EnumMsgSubscribeType.NEW_FIRMWARE.getName());
                }
                if (fromType == enumDeviceType) {
                    if (e0) {
                        arrayList.add(EnumMsgSubscribeType.CAMERA_SD_NEED_INITIALIZATION.getName());
                        arrayList.add(EnumMsgSubscribeType.CAMERA_SD_INSUFFICIENT_STORAGE.getName());
                    }
                    if (isSubscribeCameraMotion()) {
                        arrayList.add(EnumMsgSubscribeType.CAMERA_MOTION.getName());
                        arrayList.add(EnumMsgSubscribeType.CAMERA_AREA_INTRUSION_DETECTION.getName());
                        arrayList.add(EnumMsgSubscribeType.CAMERA_LINE_CROSSING_DETECTION.getName());
                        arrayList.add(EnumMsgSubscribeType.CAMERA_TAMPERING.getName());
                        arrayList.add(EnumMsgSubscribeType.CAMERA_PERSON_DETECTED.getName());
                        arrayList.add(EnumMsgSubscribeType.CAMERA_PERSON_ENHANCED.getName());
                        arrayList.add(EnumMsgSubscribeType.CAMERA_CRYING.getName());
                    }
                } else if (fromType == EnumDeviceType.PLUG) {
                    if (isSubscribeCameraMotion()) {
                        arrayList.add(EnumMsgSubscribeType.DEVICE_ACTIVITY.getName());
                    }
                } else if (fromType == EnumDeviceType.HUB) {
                    if (isSubscribeCameraMotion()) {
                        arrayList.add(EnumMsgSubscribeType.TAPO_HUB_TRIGGERED.getName());
                    }
                } else if (fromType == EnumDeviceType.SWITCH) {
                    if (isSubscribeCameraMotion()) {
                        arrayList.add(EnumMsgSubscribeType.TAPO_SMART_SWITCH_TRIGGERED.getName());
                    }
                    arrayList.add(EnumMsgSubscribeType.TAPO_DEVICE_LOW_BATTERY.getName());
                } else if (fromType == EnumDeviceType.SENSOR) {
                    if (isSubscribeCameraMotion()) {
                        arrayList.add(EnumMsgSubscribeType.TAPO_MOTION_SENSOR_TRIGGERED.getName());
                        arrayList.add(EnumMsgSubscribeType.TAPO_CONTACT_SENSOR_TRIGGERED.getName());
                        arrayList.add(EnumMsgSubscribeType.TAPO_SMART_BUTTON_TRIGGERED.getName());
                    }
                    arrayList.add(EnumMsgSubscribeType.TAPO_DEVICE_LOW_BATTERY.getName());
                    arrayList.add(EnumMsgSubscribeType.TAPO_SENSOR_FREQUENTLY_TRIGGERED.getName());
                } else if (fromType == EnumDeviceType.ENERGY && isSubscribeCameraMotion()) {
                    arrayList.add(EnumMsgSubscribeType.TAPO_THERMOSTAT_RADIATOR_VALVE.getName());
                }
            } else {
                arrayList.add(EnumMsgSubscribeType.ALL.getName());
            }
        }
        return arrayList;
    }

    public SubscribeItemBean(String str, int i) {
        this.deviceId = str;
        this.deviceSubscribeOffBit = i;
    }
}
