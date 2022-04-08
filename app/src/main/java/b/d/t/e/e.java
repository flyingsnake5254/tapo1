package b.d.t.e;

import android.text.TextUtils;
import b.d.d.j.b;
import b.d.p.d;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpstreampreconnect.bean.Status;
import io.reactivex.g0.g;
import io.reactivex.l0.a;
import io.reactivex.q;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UpnpUtils.java */
/* loaded from: classes3.dex */
public class e {
    public static Status a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "multipart/mixed; boundary=--client-stream-boundary--");
        String d2 = d(str);
        int e2 = e(str);
        d.a("UpnpUtils", "ip " + d2 + " ---------port " + e2);
        if (TextUtils.isEmpty(d2) || e2 < 0) {
            return Status.unknown;
        }
        int m = m(c(d2, e2), SSLClient.HTTP_POST, hashMap);
        d.a("UpnpUtils", "is connection success " + m);
        if (m == 0) {
            return Status.success;
        }
        if (m == 1) {
            return Status.failed;
        }
        if (m != 2) {
            return Status.unknown;
        }
        return Status.unknown;
    }

    public static void b(final String str, final Runnable runnable) {
        if (!TextUtils.isEmpty(str)) {
            q.f0(1).E(new g() { // from class: b.d.t.e.a
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    e.j(str, runnable, (Integer) obj);
                }
            }).C(b.f729c).L0(a.c()).F0();
        }
    }

    private static String c(String str, int i) {
        return SSLClient.HTTP_PREFIX + str + SSLClient.COLON + i + "/stream";
    }

    public static String d(String str) {
        if (str == null) {
            return "";
        }
        String upnpIp = b.f195b.getUpnpIp(str);
        return (TextUtils.isEmpty(upnpIp) || "null".equals(upnpIp)) ? "" : upnpIp;
    }

    public static int e(String str) {
        if (str == null) {
            return -1;
        }
        return b.f195b.getUpnpPort(str);
    }

    public static int f(String str) {
        return b.f195b.getUpnpTimestamp(str);
    }

    public static boolean g(String str) {
        if (str == null) {
            return false;
        }
        return b.f195b.isUpnpEnabled(str);
    }

    public static boolean h(String str) {
        if (str == null) {
            return false;
        }
        return Status.success.name().equals(b.f195b.getUpnpStatus(str));
    }

    public static boolean i(String str) {
        if (str == null) {
            return false;
        }
        return Status.unknown.name().equals(b.f195b.getUpnpStatus(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(String str, Runnable runnable, Integer num) throws Exception {
        Status a = a(str);
        if (a != Status.unknown) {
            l(str, a);
        }
        if (a == Status.success) {
            runnable.run();
        }
    }

    public static q k(String str) {
        return b.f195b.renewUpnpPsk(str);
    }

    public static void l(String str, Status status) {
        if (status != null) {
            b.f195b.updateUpnpCommStatus(str, status.name());
        }
    }

    private static int m(String str, String str2, Map<String, String> map) {
        Throwable th;
        SocketTimeoutException e2;
        IOException e3;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SocketTimeoutException e4) {
            e2 = e4;
        } catch (IOException e5) {
            e3 = e5;
        }
        try {
            httpURLConnection.setRequestMethod(str2);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(15000);
            if (map != null && !map.isEmpty()) {
                for (String str3 : map.keySet()) {
                    httpURLConnection.setRequestProperty(str3, map.get(str3));
                }
            }
            httpURLConnection.connect();
            httpURLConnection.disconnect();
            return 0;
        } catch (SocketTimeoutException e6) {
            e2 = e6;
            httpURLConnection2 = httpURLConnection;
            d.a("UpnpUtils", "is connection SocketTimeoutException " + e2.getMessage());
            if (httpURLConnection2 == null) {
                return 1;
            }
            httpURLConnection2.disconnect();
            return 1;
        } catch (IOException e7) {
            e3 = e7;
            httpURLConnection2 = httpURLConnection;
            d.a("UpnpUtils", "is connection IOException " + e3.getMessage());
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return 2;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }
}
