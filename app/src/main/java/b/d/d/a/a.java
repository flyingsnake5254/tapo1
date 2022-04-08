package b.d.d.a;

import android.text.TextUtils;
import b.d.d.j.b;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: AccountMediaUtils.java */
/* loaded from: classes3.dex */
public class a {
    public static String a() {
        String b2 = b();
        return !TextUtils.isEmpty(b2) ? b2 : RtspHeaders.Names.PUBLIC;
    }

    public static String b() {
        String loginCloudUserName = b.f195b.getLoginCloudUserName();
        return loginCloudUserName == null ? "" : loginCloudUserName;
    }

    public static String c() {
        String loginToken = b.f195b.getLoginToken();
        return loginToken == null ? "" : loginToken;
    }

    public static String d() {
        String mediaLoginPassword = b.f195b.getMediaLoginPassword();
        return mediaLoginPassword == null ? "" : mediaLoginPassword;
    }

    public static String e() {
        String serverUrl = b.f195b.getServerUrl();
        return serverUrl == null ? "" : serverUrl;
    }

    public static boolean f() {
        return true;
    }

    public static boolean g() {
        return true;
    }

    public static boolean h() {
        return true;
    }

    public static boolean i() {
        return true;
    }

    public static boolean j() {
        return true;
    }

    public static boolean k() {
        return true;
    }

    public static boolean l() {
        return true;
    }

    public static boolean m() {
        return true;
    }

    public static boolean n() {
        return true;
    }
}
