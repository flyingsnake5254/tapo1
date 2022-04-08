package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.HashMap;

@KeepForSdk
/* loaded from: classes.dex */
public class MapUtils {
    @KeepForSdk
    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> hashMap) {
        sb.append("{");
        boolean z = true;
        for (String str : hashMap.keySet()) {
            if (!z) {
                sb.append(SSLClient.COMMA);
            } else {
                z = false;
            }
            String str2 = hashMap.get(str);
            sb.append(SSLClient.DOUBLE_QUOTATION);
            sb.append(str);
            sb.append("\":");
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(SSLClient.DOUBLE_QUOTATION);
                sb.append(str2);
                sb.append(SSLClient.DOUBLE_QUOTATION);
            }
        }
        sb.append("}");
    }
}
