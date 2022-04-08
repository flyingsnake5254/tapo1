package b.d.s.b;

import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IoTNetworkDefine.java */
/* loaded from: classes3.dex */
public class a {
    public static final Map<Integer, String> a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Boolean> f710b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, Boolean> f711c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, String> f712d;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, String> f713e;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(0, "ERR_SUCCESS");
        hashMap.put(-1, "ERR_COMMON_FAILED");
        hashMap.put(9999, "ERR_SESSION_TIMEOUT");
        hashMap.put(1000, "ERR_NULL_TRANSPORT");
        hashMap.put(1001, "ERR_CMD_COMMAND_CANCEL");
        hashMap.put(1002, "ERR_TRANSPORT_NOT_AVAILABLE");
        hashMap.put(1100, "ERR_HAND_SHAKE_FAILED");
        hashMap.put(1111, "ERR_LOGIN_FAILED");
        hashMap.put(1112, "ERR_HTTP_TRANSPORT_FAILED");
        hashMap.put(1200, "ERR_MULTI_REQUEST_FAILED");
        hashMap.put(Integer.valueOf((int) FirmwareDownloadState.UPGRADE_STATE_DOWNLOAD_FAIL), "ERR_UNSPECIFIC");
        hashMap.put(Integer.valueOf((int) FirmwareDownloadState.UPGRADE_STATE_CHECK_FAIL), "ERR_UNKNOWN_METHOD");
        hashMap.put(Integer.valueOf((int) FirmwareDownloadState.UPGRADE_STATE_TRANSFER_FAIL), "ERR_JSON_DECODE_FAIL");
        hashMap.put(-1004, "ERR_JSON_ENCODE_FAIL");
        hashMap.put(-1005, "ERR_AES_DECODE_FAIL");
        hashMap.put(-1006, "ERR_REQUEST_LEN_ERROR");
        hashMap.put(-1007, "ERR_CLOUD_FAILED");
        hashMap.put(-1008, "ERR_PARAMS");
        hashMap.put(-1101, "ERR_SESSION_PARAM");
        hashMap.put(-1201, "ERR_QUICK_SETUP");
        hashMap.put(-1301, "ERR_DEVICE");
        hashMap.put(-1302, "ERR_DEVICE_NEXT_EVENT");
        hashMap.put(-1401, "ERR_FIRMWARE");
        hashMap.put(-1402, "ERR_FIRMWARE_VER_ERROR");
        hashMap.put(-1501, "ERR_LOGIN");
        hashMap.put(-1601, "ERR_TIME");
        hashMap.put(-1602, "ERR_TIME_SYS");
        hashMap.put(-1603, "ERR_TIME_SAVE");
        hashMap.put(-1701, "ERR_WIRELESS");
        hashMap.put(-1702, "ERR_WIRELESS_UNSUPPORTED");
        hashMap.put(-1801, "ERR_SCHEDULE");
        hashMap.put(-1802, "ERR_SCHEDULE_FULL");
        hashMap.put(-1803, "ERR_SCHEDULE_CONFLICT");
        hashMap.put(-1804, "ERR_SCHEDULE_SAVE");
        hashMap.put(-1805, "ERR_SCHEDULE_INDEX");
        hashMap.put(-1901, "ERR_COUNTDOWN");
        hashMap.put(-1902, "ERR_COUNTDOWN_CONFLICT");
        hashMap.put(-1903, "ERR_COUNTDOWN_SAVE");
        hashMap.put(-2001, "ERR_ANTITHEFT");
        hashMap.put(-2002, "ERR_ANTITHEFT_CONFLICT");
        hashMap.put(-2003, "ERR_ANTITHEFT_SAVE");
        hashMap.put(-2101, "ERR_ACCOUNT");
        hashMap.put(-2201, "ERR_STAT");
        hashMap.put(-2202, "ERR_STAT_SAVE");
        hashMap.put(-2301, "ERR_DST");
        hashMap.put(-2302, "ERR_DST_SAVE");
        HashMap hashMap2 = new HashMap();
        f710b = hashMap2;
        HashMap hashMap3 = new HashMap();
        f711c = hashMap3;
        HashMap hashMap4 = new HashMap();
        f712d = hashMap4;
        HashMap hashMap5 = new HashMap();
        f713e = hashMap5;
        Boolean bool = Boolean.TRUE;
        hashMap2.put("get_device_info", bool);
        hashMap3.put("set_device_info", bool);
        hashMap4.put("get_device_infoset_device_info", "set_device_info");
        hashMap5.put("set_device_infoget_device_info", "get_device_info");
        hashMap2.put("get_device_running_info", bool);
        hashMap3.put("set_device_info", bool);
        hashMap4.put("get_device_running_infoset_device_info", "set_device_info");
        hashMap5.put("set_device_infoget_device_running_info", "get_device_running_info");
        hashMap2.put("get_device_time", bool);
        hashMap3.put("set_device_time", bool);
        hashMap4.put("get_device_timeset_device_time", "set_device_time");
        hashMap5.put("set_device_timeget_device_time", "get_device_time");
        hashMap2.put("get_schedule_rules", bool);
        hashMap3.put("add_schedule_rule", bool);
        hashMap4.put("get_schedule_rulesadd_schedule_rule", "add_schedule_rule");
        hashMap5.put("add_schedule_ruleget_schedule_rules", "get_schedule_rules");
        hashMap2.put("get_schedule_rules", bool);
        hashMap3.put("edit_schedule_rule", bool);
        hashMap4.put("get_schedule_rulesedit_schedule_rule", "edit_schedule_rule");
        hashMap5.put("edit_schedule_ruleget_schedule_rules", "get_schedule_rules");
        hashMap2.put("get_early_start", bool);
        hashMap3.put("set_early_start", bool);
        hashMap4.put("get_early_startset_early_start", "set_early_start");
        hashMap5.put("set_early_startget_early_start", "get_early_start");
        hashMap2.put("get_schedule_rules", bool);
        hashMap3.put("remove_schedule_rules", bool);
        hashMap4.put("get_schedule_rulesremove_schedule_rules", "remove_schedule_rules");
        hashMap5.put("remove_schedule_rulesget_schedule_rules", "get_schedule_rules");
        hashMap2.put("get_countdown_rules", bool);
        hashMap3.put("add_countdown_rule", bool);
        hashMap4.put("get_countdown_rulesadd_countdown_rule", "add_countdown_rule");
        hashMap5.put("add_countdown_ruleget_countdown_rules", "get_countdown_rules");
        hashMap2.put("get_countdown_rules", bool);
        hashMap3.put("edit_countdown_rule", bool);
        hashMap4.put("get_countdown_rulesedit_countdown_rule", "edit_countdown_rule");
        hashMap5.put("edit_countdown_ruleget_countdown_rules", "get_countdown_rules");
        hashMap2.put("get_countdown_rules", bool);
        hashMap3.put("remove_countdown_rules", bool);
        hashMap4.put("get_countdown_rulesremove_countdown_rules", "remove_countdown_rules");
        hashMap5.put("remove_countdown_rulesget_countdown_rules", "get_countdown_rules");
        hashMap2.put("get_antitheft_rules", bool);
        hashMap3.put("add_antitheft_rule", bool);
        hashMap4.put("get_antitheft_rulesadd_antitheft_rule", "add_antitheft_rule");
        hashMap5.put("add_antitheft_ruleget_antitheft_rules", "get_antitheft_rules");
        hashMap2.put("get_antitheft_rules", bool);
        hashMap3.put("edit_antitheft_rule", bool);
        hashMap4.put("get_antitheft_rulesedit_antitheft_rule", "edit_antitheft_rule");
        hashMap5.put("edit_antitheft_ruleget_antitheft_rules", "get_antitheft_rules");
        hashMap2.put("get_led_info", bool);
        hashMap3.put("set_led_info", bool);
        hashMap4.put("get_led_infoset_led_info", "set_led_info");
        hashMap5.put("set_led_infoget_led_info", "get_led_info");
        hashMap3.put("set_dynamic_light_effect_rule_enable", bool);
        hashMap4.put("get_device_running_infoset_dynamic_light_effect_rule_enable", "set_dynamic_light_effect_rule_enable");
        hashMap3.put("set_guard_mode", bool);
        hashMap4.put("get_device_running_infoset_guard_mode", "set_guard_mode");
    }
}
