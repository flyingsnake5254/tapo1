package b.d.m.b;

import android.text.TextUtils;
import b.d.i.a.a.f;
import b.d.i.a.b.c.n;
import b.d.p.d;
import com.tplink.libtpcommonstream.stream.control.common.CommonPayload;
import com.tplink.libtpcommonstream.stream.control.common.NotificationEventType;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlNotification;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlType;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;
import com.tplink.libtpcommonstream.stream.control.request.DoStopRequest;
import com.tplink.libtpcommonstream.stream.control.response.GetDownloadResponse;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.http.HttpHeaders;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: DownloadStreamConnection.java */
/* loaded from: classes3.dex */
public class b extends f {
    private Future<Boolean> H3;
    private volatile boolean I3;
    private com.tplink.libtpstreamconnectionsocket.a J3;
    private b.d.p.a L3;
    private int M3;
    private String N3;
    private n P3;
    private final String Q3;
    private a R3;
    private a p2;
    private d p3;
    private final Object O3 = new Object();
    private String K3 = null;

    /* compiled from: DownloadStreamConnection.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b(int i);
    }

    public b(String str) {
        this.I3 = true;
        this.Q3 = str;
        this.I3 = true;
    }

    private StreamStatus o(StreamControlNotification<Object> streamControlNotification) {
        if (NotificationEventType.EVENT_TYPE_STREAM_STATUS.equals(streamControlNotification.getEventType())) {
            return (StreamStatus) streamControlNotification.getResult();
        }
        return null;
    }

    @Override // b.d.i.a.a.f
    public void f(String str) {
        if (this.J3 != null && !TextUtils.isEmpty(this.Q3)) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.K3)) {
                hashMap.put(SSLClient.X_SESSION_ID, this.K3);
            }
            this.J3.t(str, hashMap);
            synchronized (this.O3) {
                this.O3.notifyAll();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x01ba, code lost:
        if (r0 != null) goto L_0x0201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01ff, code lost:
        if (r0 == null) goto L_0x0204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0201, code lost:
        r0.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0204, code lost:
        m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0209, code lost:
        return java.lang.Boolean.TRUE;
     */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Boolean call() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 538
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.m.b.b.call():java.lang.Boolean");
    }

    protected void m() {
    }

    protected void n() throws Exception {
        b.d.p.a aVar;
        b.d.p.a aVar2;
        if (!TextUtils.isEmpty(this.Q3)) {
            d.a("DownloadStreamConnection", "requestDownload " + this.Q3);
            HashMap hashMap = new HashMap();
            hashMap.put(SSLClient.X_DATA_WINDOW_SIZE, "50");
            this.J3.t(this.Q3, hashMap);
        }
        HashMap hashMap2 = new HashMap();
        StreamStatus streamStatus = null;
        while (true) {
            while (this.I3) {
                this.J3.g();
                Map<String, String> p = this.J3.p();
                if (p.size() != 0 && p.containsKey("Content-Type")) {
                    boolean z = false;
                    if (this.y) {
                        this.y = false;
                        d dVar = this.p3;
                        if (dVar != null) {
                            dVar.r(this.f462c, this.x);
                        }
                    }
                    String str = p.get("Content-Type");
                    String str2 = p.get(SSLClient.X_SESSION_ID);
                    if (p.containsKey(SSLClient.X_IF_ENCRYPT) && "1".equals(p.get(SSLClient.X_IF_ENCRYPT))) {
                        z = true;
                    }
                    if ("image/jpeg".equals(str)) {
                        byte[] m = this.J3.m();
                        if (z && (aVar2 = this.L3) != null) {
                            m = aVar2.a(m, m.length);
                        }
                        String str3 = this.K3;
                        if (str3 != null && str3.equals(str2)) {
                            d.a("DownloadStreamConnection", "session " + str2 + " rawData " + m.length);
                            ByteBuffer byteBuffer = (ByteBuffer) hashMap2.get(this.K3);
                            if (byteBuffer == null) {
                                byteBuffer = ByteBuffer.allocate(102400);
                                hashMap2.put(this.K3, byteBuffer);
                            }
                            byteBuffer.put(m);
                        }
                    } else if (HttpHeaders.Values.APPLICATION_JSON.equals(str)) {
                        byte[] m2 = this.J3.m();
                        if (z && (aVar = this.L3) != null) {
                            m2 = aVar.a(m2, m2.length);
                        }
                        String str4 = new String(m2);
                        d.a("DownloadStreamConnection", "payload: " + str4);
                        CommonPayload commonPayload = (CommonPayload) b.d.i.a.b.b.b(str4, CommonPayload.class);
                        if (StreamControlType.NOTIFICATION.equals(commonPayload.getType())) {
                            StreamControlNotification<Object> c2 = b.d.i.a.b.b.c(commonPayload);
                            if (!(c2 == null || this.P3 == null)) {
                                d.a("DownloadStreamConnection", "event type " + c2.getEventType());
                                this.P3.a(this.f462c, c2);
                            }
                            streamStatus = o(c2);
                        } else if (StreamControlType.RESPONSE.equals(commonPayload.getType())) {
                            if (this.K3 == null) {
                                GetDownloadResponse getDownloadResponse = (GetDownloadResponse) b.d.i.a.b.b.e(commonPayload, GetDownloadResponse.class).getResult();
                                if (getDownloadResponse.getErrorCode() != 0 || TextUtils.isEmpty(getDownloadResponse.getSessionId())) {
                                    a aVar3 = this.R3;
                                    if (aVar3 != null) {
                                        aVar3.b(getDownloadResponse.getErrorCode());
                                    }
                                } else {
                                    x(getDownloadResponse.getSessionId());
                                    a aVar4 = this.R3;
                                    if (aVar4 != null) {
                                        aVar4.a();
                                    }
                                }
                            } else {
                                n nVar = this.P3;
                                if (nVar != null) {
                                    nVar.c(commonPayload);
                                }
                            }
                        }
                    }
                    String str5 = this.K3;
                    if (str5 != null && str5.equals(str2) && streamStatus != null && StreamStatus.FINISHED.equals(streamStatus.getStatus())) {
                        ByteBuffer byteBuffer2 = (ByteBuffer) hashMap2.remove(this.K3);
                        if (byteBuffer2 != null) {
                            byteBuffer2.flip();
                            byte[] bArr = new byte[byteBuffer2.limit()];
                            byteBuffer2.get(bArr);
                            a aVar5 = this.p2;
                            if (aVar5 != null) {
                                aVar5.a(this.f462c, this.N3, this.M3, bArr);
                            }
                            byteBuffer2.clear();
                        } else {
                            a aVar6 = this.p2;
                            if (aVar6 != null) {
                                aVar6.b(this.f462c, this.N3, this.M3, new Exception("image data null"));
                            }
                        }
                        synchronized (this.O3) {
                            this.O3.notifyAll();
                            this.O3.wait();
                        }
                    }
                }
            }
            return;
        }
    }

    public void p() {
        d.a("DownloadStreamConnection", "设备：" + this.f462c + "Download流被release()");
        this.I3 = false;
        synchronized (this.O3) {
            this.O3.notifyAll();
        }
        this.p2 = null;
        this.p3 = null;
        this.R3 = null;
        Future<Boolean> future = this.H3;
        if (future != null) {
            future.cancel(true);
        }
    }

    protected void q() {
        if (this.J3 != null && !TextUtils.isEmpty(this.K3)) {
            try {
                int b2 = this.P3.b();
                StreamControlRequest streamControlRequest = new StreamControlRequest(new DoStopRequest());
                streamControlRequest.setSeq(b2);
                String d2 = b.d.i.a.b.b.d(streamControlRequest);
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", HttpHeaders.Values.APPLICATION_JSON);
                hashMap.put(SSLClient.X_SESSION_ID, this.K3);
                this.J3.I(true);
                this.J3.D(hashMap, d2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void r(n nVar) {
        this.P3 = nVar;
    }

    public void s(a aVar) {
        this.R3 = aVar;
    }

    public void t(a aVar) {
        this.p2 = aVar;
    }

    public void u(int i) {
        this.M3 = i;
    }

    public void v(d dVar) {
        this.p3 = dVar;
    }

    public void w(Future<Boolean> future) {
        this.H3 = future;
    }

    public void x(String str) {
        this.K3 = str;
    }

    public void y(String str) {
        this.N3 = str;
    }

    public void z(String str) {
        this.K3 = str;
    }
}
