package com.tplink.libtpnetwork.enumerate;

import com.tplink.cloud.bean.push.NotificationMsgBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum EnumNotificationMsgType {
    SHARE_LAUNCH(NotificationMsgBean.MsgType.SHARE_LAUNCH),
    NEW_FIRMWARE(NotificationMsgBean.MsgType.NEW_FIRMWARE),
    MOTION("Motion"),
    AUDIO(NotificationMsgBean.MsgType.AUDIO),
    CRYING(NotificationMsgBean.MsgType.CRYING),
    FFS_NEW_DEVICE_FOUND("tapoFfsNewDeviceFound"),
    DEVICE_ACTIVITY("smartTapoDeviceActivity"),
    PERSON_DETECTED("PersonDetected"),
    PERSON_ENHANCED(NotificationMsgBean.MsgType.PERSON_ENHANCED),
    SD_NEED_INITIALIZATION(ThingModelDefine.Event.EVENT_CAMERA_SD_NEED_INITIALIZATION),
    SD_INSUFFICIENT_STORAGE(ThingModelDefine.Event.EVENT_CAMERA_SD_INSUFFICIENT_STORAGE),
    AREA_INTRUSION_DETECTION(ThingModelDefine.Event.EVENT_CAMERA_AREA_INTRUSION_DETECTION),
    LINE_CROSSING_DETECTION(ThingModelDefine.Event.EVENT_CAMERA_LINE_CROSSING_DETECTION),
    CAMERA_TAMPERING(ThingModelDefine.Event.EVENT_CAMERA_CAMERA_TAMPERING),
    TAPO_CARE_TRIAL_EXPIRING_IN_3_DAYS("TAPO_CARE_TRIAL_EXPIRING_IN_3_DAYS"),
    TAPO_CARE_TRIAL_EXPIRED("TAPO_CARE_TRIAL_EXPIRED"),
    TAPO_CARE_SUBSCRIPTION_EXPIRING_IN_3_DAYS("TAPO_CARE_SUBSCRIPTION_EXPIRING_IN_3_DAYS"),
    TAPO_CARE_SUBSCRIPTION_EXPIRED("TAPO_CARE_SUBSCRIPTION_EXPIRED"),
    TAPO_CARE_SUBSCRIPTION_PAYMENT_FAILED("TAPO_CARE_SUBSCRIPTION_PAYMENT_FAILED"),
    TAPO_HUB_TRIGGERED("tapoHubTriggered"),
    TAPO_CONTACT_SENSOR_TRIGGERED("tapoContactSensorTriggered"),
    TAPO_MOTION_SENSOR_TRIGGERED("tapoMotionSensorTriggered"),
    TAPO_SMART_BUTTON_TRIGGERED("tapoSmartButtonTriggered"),
    TAPO_SMART_SWITCH_TRIGGERED("tapoSmartSwitchTriggered"),
    TAPO_THERMOSTAT_RADIATOR_VALVE("tapoThermostatRadiatorValve"),
    TAPO_DEVICE_LOW_BATTERY("tapoDeviceLowBattery"),
    TAPO_SENSOR_FREQUENTLY_TRIGGERED("tapoSensorFrequentlyTriggered"),
    BRAND_PROMOTION("brandPromotion"),
    MARKET_PROMOTION("marketPromotion"),
    ANNOUNCEMENT("announcement"),
    USER_RESEARCH("userResearch"),
    TAPO_DAILY_SUMMARY_CREATED("videosummaryGenerated"),
    TAPO_DAILY_SUMMARY_CAN_CREATE("videosummaryCanCreateFromClips"),
    OTHER("other");
    
    private static Map<String, EnumNotificationMsgType> typeMap = new HashMap();
    private String name;

    static {
        EnumNotificationMsgType[] values;
        for (EnumNotificationMsgType enumNotificationMsgType : values()) {
            typeMap.put(enumNotificationMsgType.name, enumNotificationMsgType);
        }
    }

    EnumNotificationMsgType(String str) {
        this.name = str;
    }

    public static EnumNotificationMsgType fromString(String str) {
        return typeMap.get(str);
    }

    public String getName() {
        return this.name;
    }
}
