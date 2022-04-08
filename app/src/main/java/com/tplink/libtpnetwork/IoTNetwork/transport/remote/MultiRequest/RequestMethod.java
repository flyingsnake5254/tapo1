package com.tplink.libtpnetwork.IoTNetwork.transport.remote.MultiRequest;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RequestMethod {
    private static final List<String> a;

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f13621b;

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f13622c;

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f13623d;

    /* loaded from: classes3.dex */
    public enum RequestMethodType {
        REPLACE_DIRECT_TYPE,
        REPLACE_COMBINE_TYPE,
        NOT_REPLACE_TYPE,
        NOT_MULTI_REQUEST_TYPE
    }

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        f13621b = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        f13622c = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        f13623d = arrayList4;
        arrayList.add("get_device_info");
        arrayList.add("get_device_running_info");
        arrayList.add("get_latest_fw");
        arrayList.add("get_fw_download_state");
        arrayList.add("component_nego");
        arrayList.add("qs_component_nego");
        arrayList.add("get_device_time");
        arrayList.add("get_wireless_scan_info");
        arrayList.add("get_schedule_rules");
        arrayList.add("get_schedule_next_action");
        arrayList.add("get_schedule_day_runtime");
        arrayList.add("get_schedule_month_runtime");
        arrayList.add("get_countdown_rules");
        arrayList.add("get_antitheft_rules");
        arrayList2.add("set_device_info");
        arrayList2.add("set_device_time");
        arrayList2.add("set_schedule_all_enable");
        arrayList2.add("set_antitheft_all_enable");
        arrayList3.add("device_reset");
        arrayList3.add("device_reboot");
        arrayList3.add("fw_download");
        arrayList3.add("login_device");
        arrayList3.add("set_qs_info");
        arrayList3.add("set_wireless_info");
        arrayList3.add("add_schedule_rule");
        arrayList3.add("edit_schedule_rule");
        arrayList3.add("remove_schedule_rules");
        arrayList3.add("remove_all_schedule_runtime");
        arrayList3.add("add_countdown_rule");
        arrayList3.add("edit_countdown_rule");
        arrayList3.add("remove_countdown_rules");
        arrayList3.add("add_antitheft_rule");
        arrayList3.add("edit_antitheft _rule");
        arrayList3.add("remove_antitheft _rules");
        arrayList4.add("multipleRequest");
        arrayList4.add("device_reset");
        arrayList4.add("device_reboot");
        arrayList4.add("fw_download");
        arrayList4.add("login_device");
        arrayList4.add("set_qs_info");
        arrayList4.add("set_wireless_info");
        arrayList4.add("get_schedule_rules");
    }

    public static RequestMethodType a(String str) {
        if (a.contains(str)) {
            return RequestMethodType.REPLACE_DIRECT_TYPE;
        }
        if (f13621b.contains(str)) {
            return RequestMethodType.REPLACE_COMBINE_TYPE;
        }
        return RequestMethodType.NOT_REPLACE_TYPE;
    }

    public static boolean b(String str) {
        return !f13623d.contains(str);
    }
}
