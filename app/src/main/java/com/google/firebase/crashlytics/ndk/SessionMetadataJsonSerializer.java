package com.google.firebase.crashlytics.ndk;

import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class SessionMetadataJsonSerializer {
    private SessionMetadataJsonSerializer() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String serializeBeginSession(String str, String str2, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("session_id", str);
        hashMap.put("generator", str2);
        hashMap.put("started_at_seconds", Long.valueOf(j));
        return new JSONObject(hashMap).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String serializeSessionApp(String str, String str2, String str3, String str4, int i, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_identifier", str);
        hashMap.put("version_code", str2);
        hashMap.put("version_name", str3);
        hashMap.put("install_uuid", str4);
        hashMap.put("delivery_mechanism", Integer.valueOf(i));
        hashMap.put("unity_version", str5);
        return new JSONObject(hashMap).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String serializeSessionDevice(int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("arch", Integer.valueOf(i));
        hashMap.put("build_model", str);
        hashMap.put("available_processors", Integer.valueOf(i2));
        hashMap.put("total_ram", Long.valueOf(j));
        hashMap.put("disk_space", Long.valueOf(j2));
        hashMap.put("is_emulator", Boolean.valueOf(z));
        hashMap.put(DefaultStatesBean.KEY_STATE, Integer.valueOf(i3));
        hashMap.put("build_manufacturer", str2);
        hashMap.put("build_product", str3);
        return new JSONObject(hashMap).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String serializeSessionOs(String str, String str2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("version", str);
        hashMap.put("build_version", str2);
        hashMap.put("is_rooted", Boolean.valueOf(z));
        return new JSONObject(hashMap).toString();
    }
}
