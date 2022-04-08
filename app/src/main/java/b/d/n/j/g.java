package b.d.n.j;

import android.text.TextUtils;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RemoteMessageParser.java */
/* loaded from: classes3.dex */
public class g {
    private static String a(Map<String, String> map, String str, String str2) {
        String str3;
        return (map == null || map.size() <= 0 || !map.containsKey(str) || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    public static String b(RemoteMessage remoteMessage) {
        String a = a(remoteMessage.getData(), "iac", "");
        if (TextUtils.isEmpty(a)) {
            return "";
        }
        try {
            return new JSONObject(a).optString("msgType", "");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c(RemoteMessage remoteMessage) {
        String a = a(remoteMessage.getData(), "iac", "");
        String b2 = b(remoteMessage);
        if (TextUtils.isEmpty(a) || !"pushWithTaskId".equals(b2)) {
            return "";
        }
        try {
            return new JSONObject(a).optString("taskId", "");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
