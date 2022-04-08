package com.tplink.libtpnetwork.enumerate;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.os.EnvironmentCompat;
import com.tplink.cloud.bean.push.NotificationMsgBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum EnumMsgSubscribeType {
    ALL(1, "all"),
    NEW_FIRMWARE(1, NotificationMsgBean.MsgType.NEW_FIRMWARE),
    DEVICE_SHARE(2, NotificationMsgBean.MsgType.SHARE_LAUNCH),
    CAMERA_MOTION(3, "Motion"),
    CAMERA_AUDIO(4, NotificationMsgBean.MsgType.AUDIO),
    CAMERA_CRYING(5, NotificationMsgBean.MsgType.CRYING),
    IN_APP_MARKETING(6, "in_app_marketing"),
    FFS_NEW_DEVICE_FOUND(7, "tapoFfsNewDeviceFound"),
    DEVICE_ACTIVITY(8, "smartTapoDeviceActivity"),
    CAMERA_SD_NEED_INITIALIZATION(9, ThingModelDefine.Event.EVENT_CAMERA_SD_NEED_INITIALIZATION),
    CAMERA_SD_INSUFFICIENT_STORAGE(10, ThingModelDefine.Event.EVENT_CAMERA_SD_INSUFFICIENT_STORAGE),
    CAMERA_AREA_INTRUSION_DETECTION(11, ThingModelDefine.Event.EVENT_CAMERA_AREA_INTRUSION_DETECTION),
    CAMERA_LINE_CROSSING_DETECTION(12, ThingModelDefine.Event.EVENT_CAMERA_LINE_CROSSING_DETECTION),
    CAMERA_TAMPERING(13, ThingModelDefine.Event.EVENT_CAMERA_CAMERA_TAMPERING),
    CAMERA_PERSON_DETECTED(11, "PersonDetected"),
    CAMERA_PERSON_ENHANCED(12, NotificationMsgBean.MsgType.PERSON_ENHANCED),
    TAPO_CARE_TRIAL_EXPIRING_IN_3_DAYS(13, "TAPO_CARE_TRIAL_EXPIRING_IN_3_DAYS"),
    TAPO_CARE_TRIAL_EXPIRED(14, "TAPO_CARE_TRIAL_EXPIRED"),
    TAPO_CARE_SUBSCRIPTION_EXPIRING_IN_3_DAYS(15, "TAPO_CARE_SUBSCRIPTION_EXPIRING_IN_3_DAYS"),
    TAPO_CARE_SUBSCRIPTION_EXPIRED(16, "TAPO_CARE_SUBSCRIPTION_EXPIRED"),
    TAPO_CARE_SUBSCRIPTION_PAYMENT_FAILED(17, "TAPO_CARE_SUBSCRIPTION_PAYMENT_FAILED"),
    TAPO_CARE_DOWNGRADE_TO_HANDLE(18, "tapoCareSubscriptionDowngradePreference"),
    TAPO_CARE_DOWNGRADE_HANDLED(19, "tapoCareSubscriptionDowngradeActivated"),
    IAC_PUSH_TASK_ID(20, "pushWithTaskId"),
    TAPO_HUB_TRIGGERED(21, "tapoHubTriggered"),
    TAPO_CONTACT_SENSOR_TRIGGERED(22, "tapoContactSensorTriggered"),
    TAPO_MOTION_SENSOR_TRIGGERED(23, "tapoMotionSensorTriggered"),
    TAPO_SMART_BUTTON_TRIGGERED(24, "tapoSmartButtonTriggered"),
    TAPO_SMART_SWITCH_TRIGGERED(25, "tapoSmartSwitchTriggered"),
    TAPO_THERMOSTAT_RADIATOR_VALVE(26, "tapoThermostatRadiatorValve"),
    TAPO_DEVICE_LOW_BATTERY(27, "tapoDeviceLowBattery"),
    TAPO_SENSOR_FREQUENTLY_TRIGGERED(28, "tapoSensorFrequentlyTriggered"),
    TAPO_DAILY_SUMMARY_CREATED(29, "videosummaryGenerated"),
    TAPO_DAILY_SUMMARY_CAN_CREATE(30, "videosummaryCanCreateFromClips"),
    UNKNOWN(100, EnvironmentCompat.MEDIA_UNKNOWN);
    
    private static Map<String, EnumMsgSubscribeType> stringToEnum = new HashMap();
    private String name;
    private int value;

    static {
        EnumMsgSubscribeType[] values;
        for (EnumMsgSubscribeType enumMsgSubscribeType : values()) {
            stringToEnum.put(enumMsgSubscribeType.getName(), enumMsgSubscribeType);
        }
    }

    EnumMsgSubscribeType(int i, String str) {
        this.value = i;
        this.name = str;
    }

    public static EnumMsgSubscribeType fromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        return stringToEnum.get(str) == null ? UNKNOWN : stringToEnum.get(str);
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return getName();
    }
}
