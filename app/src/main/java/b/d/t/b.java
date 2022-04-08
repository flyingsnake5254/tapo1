package b.d.t;

import android.os.Build;
import android.text.TextUtils;
import b.d.d.d.c;
import b.d.d.m.a;
import b.d.d.m.h;
import b.d.t.e.d;
import com.tplink.libmediakit.jniinterface.RemoteConnection;
import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import com.tplink.libtpstreampreconnect.bean.TalkMode;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: NatUtils.java */
/* loaded from: classes3.dex */
public class b {
    public static void a(int i, DeviceModel deviceModel) {
        RemoteConnection.d().a(i);
    }

    public static int b(BaseConnection baseConnection, int i) {
        return RemoteConnection.d().e(i);
    }

    private static int c(BaseConnection baseConnection) {
        String str;
        String str2;
        TPMediaDevice c2 = c.c(baseConnection.getDeviceIdMD5());
        if (c2 == null) {
            return -1;
        }
        String str3 = "TP-Link_Tapo_Android Android " + a.a();
        String deviceId = c2.getDeviceId();
        String deviceMac = c2.getDeviceMac();
        String a = b.d.d.a.a.a();
        String c3 = b.d.d.a.a.c();
        if (baseConnection.getConnectionType() == 0 && c2.isUserRoleTypeDevice()) {
            c3 = b.d.d.a.a.c() + "; tokenType=appSlaveToken";
        }
        String a2 = h.a();
        String str4 = Build.MODEL;
        int e2 = e(baseConnection.getConnectionType());
        int h = h(baseConnection.getMediaType());
        int g = g(baseConnection.getBitStreamType());
        String e3 = b.d.d.a.a.e();
        if (c2.isSupportIoTCloud()) {
            str = c2.getIotThingUrl();
        } else {
            str = c2.getAppServerUrl();
        }
        String b2 = d.b(e3, str);
        String str5 = b2 + ":80";
        r15 = b2 + ":443";
        String k = k(d.c(e3, str));
        boolean isSupportIoTCloud = c2.isSupportIoTCloud();
        String format = String.format("app:%1$s:%2$s", "TP-Link_Tapo_Android", b.d.d.j.b.f195b.getUuid());
        String str6 = "";
        if (baseConnection.getConnectionType() == 0) {
            str2 = "--client-stream-boundary--";
        } else {
            str2 = str6;
            str5 = k;
        }
        return RemoteConnection.d().c(b.d.t.e.c.b(deviceMac, str3, deviceId, a, c3, a2, str4, e2, h, g, str5, str6, str2, isSupportIoTCloud, format));
    }

    private static int d(BaseConnection baseConnection, int i) {
        String str;
        TPMediaDevice c2 = c.c(baseConnection.getDeviceIdMD5());
        if (c2 == null) {
            return -1;
        }
        String deviceId = c2.getDeviceId();
        int e2 = e(baseConnection.getConnectionType());
        int h = h(baseConnection.getMediaType());
        int g = g(baseConnection.getBitStreamType());
        long startTime = baseConnection.getStartTime();
        long endTime = baseConnection.getEndTime();
        int i2 = i(baseConnection.getTalkMode());
        String d2 = b.d.d.a.a.d();
        if (c2.isSupportIoTCloud()) {
            str = c2.getIotThingUrl();
        } else {
            str = c2.getAppServerUrl();
        }
        str.replace(SSLClient.HTTP_PREFIX, "").replace(SSLClient.HTTPS_PREFIX, "");
        return RemoteConnection.d().b(i, b.d.t.e.c.a(deviceId, e2, h, g, startTime, endTime, i2, "admin", d2, str, str, 30000));
    }

    private static int e(int i) {
        return i == 16 ? 0 : 1;
    }

    public static int f(BaseConnection baseConnection, int i) {
        return d(baseConnection, i);
    }

    private static int g(BitStreamType bitStreamType) {
        return (bitStreamType == null || !bitStreamType.equals(BitStreamType.MAIN_HD)) ? 1 : 0;
    }

    private static int h(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }

    public static int i(String str) {
        return TalkMode.AEC.equals(str) ? 2 : 0;
    }

    public static int j(BaseConnection baseConnection) {
        if (TextUtils.isEmpty(b.d.d.a.a.c())) {
            return -1;
        }
        return c(baseConnection);
    }

    private static String k(String str) {
        try {
            String hostAddress = InetAddress.getByName(str).getHostAddress();
            b.d.p.d.a("NatUtils", "ip " + hostAddress);
            return hostAddress;
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
            return d.a(str);
        }
    }
}
