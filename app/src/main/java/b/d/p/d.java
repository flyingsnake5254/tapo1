package b.d.p;

import b.c.a.g;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TMLog.java */
/* loaded from: classes3.dex */
public class d {
    private static boolean a = false;

    public static void a(String str, String str2) {
        g.f(str).c(str2);
    }

    public static void b(String str) {
        g.c(str, new Object[0]);
    }

    public static void c(String str, String str2) {
        g.f(str).f(str2, new Object[0]);
    }

    public static void d(boolean z) {
        a = z;
    }

    public static void e(String str, String str2) {
        g.f(str).a(str2);
    }

    public static void f(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < stackTrace.length; i++) {
            try {
                jSONObject.put(i + "", stackTrace[i].toString());
            } catch (JSONException e2) {
                b(e2.toString());
            }
        }
        e(str, jSONObject.toString());
    }
}
