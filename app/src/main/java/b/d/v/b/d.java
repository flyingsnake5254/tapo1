package b.d.v.b;

import android.text.TextUtils;
import b.d.i.a.a.e;
import b.d.i.a.a.f;
import b.d.i.a.b.b;
import b.d.i.a.b.c.n;
import com.tplink.libmediakit.jniinterface.GenKey;
import com.tplink.libtpcommonstream.stream.control.common.CommonPayload;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlNotification;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlType;
import com.tplink.libtpcommonstream.stream.control.request.DoStopRequest;
import com.tplink.libtpcommonstream.stream.control.response.GetTalkResponse;
import com.tplink.libtpmediastatistics.ConnectionInfoVO;
import com.tplink.libtpmediastatistics.OnceConnectionVO;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpmediastatistics.StatisticsManager;
import com.tplink.libtpmediastatistics.StatisticsStreamType;
import com.tplink.libtpmediastatistics.StopReason;
import com.tplink.libtpstreampreconnect.bean.TalkMode;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: DoubleTalkStreamConnection.java */
/* loaded from: classes3.dex */
public class d extends f {
    private Future<Boolean> H3;
    private volatile boolean I3;
    private com.tplink.libtpstreamconnectionsocket.a J3;
    private String K3 = null;
    private b.d.p.a L3;
    private n M3;
    private final String N3;
    private String O3;
    private long P3;
    private a Q3;
    private c p2;
    private e p3;

    /* compiled from: DoubleTalkStreamConnection.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b(int i);
    }

    public d(String str) {
        this.N3 = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n() {
        b.d.p.d.a("DoubleTalkStreamConnection", "设备：" + this.f462c + "语音流被release()");
        s();
        com.tplink.libtpstreamconnectionsocket.a aVar = this.J3;
        if (aVar != null) {
            aVar.f();
        }
    }

    private void o() throws Exception {
        b.d.p.a aVar;
        boolean z = true;
        while (z) {
            this.J3.g();
            Map<String, String> p = this.J3.p();
            if (p.size() != 0 && p.containsKey("Content-Type")) {
                String str = p.get("Content-Type");
                boolean z2 = p.containsKey(SSLClient.X_IF_ENCRYPT) && "1".equals(p.get(SSLClient.X_IF_ENCRYPT));
                if (!"video/mp2t".equals(str) && HttpHeaders.Values.APPLICATION_JSON.equals(str)) {
                    byte[] m = this.J3.m();
                    if (z2 && (aVar = this.L3) != null) {
                        m = aVar.a(m, m.length);
                    }
                    String str2 = new String(m);
                    b.d.p.d.a("DoubleTalkStreamConnection", "payload: " + str2);
                    CommonPayload commonPayload = (CommonPayload) b.b(str2, CommonPayload.class);
                    if (StreamControlType.NOTIFICATION.equals(commonPayload.getType())) {
                        StreamControlNotification<Object> c2 = b.c(commonPayload);
                        if (!(c2 == null || this.M3 == null)) {
                            b.d.p.d.a("DoubleTalkStreamConnection", "event type " + c2.getEventType());
                            this.M3.a(this.f462c, c2);
                        }
                    } else if (StreamControlType.RESPONSE.equals(commonPayload.getType())) {
                        if (this.K3 == null) {
                            GetTalkResponse getTalkResponse = (GetTalkResponse) b.e(commonPayload, GetTalkResponse.class).getResult();
                            if (getTalkResponse.getErrorCode() != 0 || getTalkResponse.getSessionId() == null) {
                                a aVar2 = this.Q3;
                                if (aVar2 != null) {
                                    aVar2.b(getTalkResponse.getErrorCode());
                                }
                            } else {
                                y(getTalkResponse.getSessionId());
                                a aVar3 = this.Q3;
                                if (aVar3 != null) {
                                    aVar3.a();
                                }
                            }
                        } else {
                            n nVar = this.M3;
                            if (nVar != null) {
                                nVar.c(commonPayload);
                            }
                        }
                        z = false;
                    }
                }
            }
        }
    }

    private void q() {
        StatisticsManager instance = StatisticsManager.getInstance();
        String str = this.f462c;
        StatisticsStreamType statisticsStreamType = StatisticsStreamType.DOUBLE_TALK;
        String onceConnectionCacheKey = instance.getOnceConnectionCacheKey(str, statisticsStreamType, this.x);
        OnceConnectionVO andRemoveOnceConnectionVO = StatisticsManager.getInstance().getAndRemoveOnceConnectionVO(onceConnectionCacheKey);
        if (andRemoveOnceConnectionVO != null) {
            andRemoveOnceConnectionVO.setStopReason(StopReason.USER_CLOSE.value());
            StatisticsManager.getInstance().insertOnceConnectionVO(onceConnectionCacheKey, andRemoveOnceConnectionVO);
        } else {
            andRemoveOnceConnectionVO = new OnceConnectionVO();
        }
        String connectionInfoCacheKey = StatisticsManager.getInstance().getConnectionInfoCacheKey(this.f462c, statisticsStreamType);
        ConnectionInfoVO connectionInfoVO = StatisticsManager.getInstance().getConnectionInfoVO(connectionInfoCacheKey);
        if (connectionInfoVO == null) {
            connectionInfoVO = new ConnectionInfoVO();
            StatisticsManager.getInstance().insertConnectionInfoVO(connectionInfoCacheKey, connectionInfoVO);
        }
        int i = this.x;
        if (i == 16) {
            connectionInfoVO.getP2pConnectionVO().addData(andRemoveOnceConnectionVO);
        } else if (i == 0) {
            connectionInfoVO.getRelayConnectionVO().addData(andRemoveOnceConnectionVO);
        } else if (i == 256) {
            connectionInfoVO.getLocalConnectionVO().addData(andRemoveOnceConnectionVO);
        }
    }

    private void r(byte[] bArr) {
        if (this.J3 != null && bArr != null && bArr.length > 0) {
            try {
                if (this.L3 != null) {
                    b.d.p.d.a("DoubleTalkStreamConnection", "send encrypt data");
                    byte[] b2 = this.L3.b(bArr);
                    this.J3.I(true);
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "audio/mp2t");
                    hashMap.put(SSLClient.X_IF_ENCRYPT, "1");
                    hashMap.put(SSLClient.X_SESSION_ID, this.K3);
                    this.J3.E(hashMap, b2);
                } else {
                    b.d.p.d.a("DoubleTalkStreamConnection", "send plain data");
                    this.J3.I(true);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("Content-Type", "audio/mp2t");
                    hashMap2.put(SSLClient.X_SESSION_ID, this.K3);
                    this.J3.E(hashMap2, bArr);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                c cVar = this.p2;
                if (cVar != null) {
                    cVar.onDoubleTalkSendDataFailure(this.f462c, -1, e2);
                }
                b.d.p.d.a("DoubleTalkStreamConnection", "" + e2.toString());
            }
        }
    }

    private void s() {
        if (this.J3 != null && !TextUtils.isEmpty(this.K3)) {
            try {
                int b2 = this.M3.b();
                StreamControlRequest streamControlRequest = new StreamControlRequest(new DoStopRequest());
                streamControlRequest.setSeq(b2);
                String d2 = b.d(streamControlRequest);
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

    public void A(String str) {
        this.O3 = str;
    }

    public void B() {
        this.P3 = System.currentTimeMillis();
    }

    public void C() {
        int round = Math.round(((float) (System.currentTimeMillis() - this.P3)) / 1000.0f);
        String onceConnectionCacheKey = StatisticsManager.getInstance().getOnceConnectionCacheKey(this.f462c, StatisticsStreamType.DOUBLE_TALK, this.x);
        OnceConnectionVO onceConnectionVO = StatisticsManager.getInstance().getOnceConnectionVO(onceConnectionCacheKey);
        if (onceConnectionVO != null) {
            onceConnectionVO.addUsageTime(round);
            StatisticsManager.getInstance().insertOnceConnectionVO(onceConnectionCacheKey, onceConnectionVO);
        }
    }

    @Override // b.d.i.a.a.f
    public void f(String str) {
        if (this.J3 != null && !TextUtils.isEmpty(this.N3)) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.K3)) {
                hashMap.put(SSLClient.X_SESSION_ID, this.K3);
            }
            this.J3.t(str, hashMap);
            if (this.J3.s()) {
                this.J3.I(false);
            }
            try {
                o();
            } catch (Exception e2) {
                this.p2.onDoubleTalkSendDataFailure(this.f462c, -1, e2);
            }
        }
    }

    /* renamed from: l */
    public Boolean call() throws Exception {
        String str;
        e eVar;
        boolean z = true;
        this.I3 = true;
        String d2 = b.d.d.a.a.d();
        if (TextUtils.isEmpty(d2)) {
            d2 = GenKey.a();
        }
        b.d.p.d.a("DoubleTalkStreamConnection", "设备建立语音流：账号：admin 密码：" + d2);
        if (e()) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "multipart/mixed; boundary=--client-stream-boundary--");
            str = b.d.i.a.c.a.a().c(com.tplink.libtpstreamconnectionsocket.a.o(this.f463d, this.f464f), "admin", d2, SSLClient.HTTP_POST, hashMap);
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str) || !e()) {
            try {
                com.tplink.libtpstreamconnectionsocket.a aVar = new com.tplink.libtpstreamconnectionsocket.a(this.f463d, this.f464f);
                this.J3 = aVar;
                aVar.F(30000);
                this.J3.H(15000);
                this.J3.G(SSLClient.HTTP_POST);
                if (17 == a()) {
                    this.J3.e(this.f462c);
                } else {
                    this.J3.d();
                }
                if (a() != 0) {
                    z = false;
                }
                int q = this.J3.q(str, z);
                if (q == 200) {
                    Map<String, String> p = this.J3.p();
                    if (p.containsKey(SSLClient.KEY_EXCHANGE)) {
                        String str2 = p.get(SSLClient.KEY_EXCHANGE);
                        b.d.p.d.a("DoubleTalkStreamConnection", "" + str2);
                        this.L3 = e.b(str2, d2);
                    }
                }
                if (q == 200 || q == 204) {
                    b.d.p.d.a("DoubleTalkStreamConnection", "设备：" + this.f462c + "ConnectType " + a() + " 双向语音连接成功");
                    if (!TextUtils.isEmpty(this.N3)) {
                        b.d.p.d.a("DoubleTalkStreamConnection", "requestTalk " + this.N3);
                        this.J3.t(this.N3, null);
                    }
                    o();
                    e eVar2 = this.p3;
                    if (eVar2 != null) {
                        eVar2.o(this.f462c, a());
                    }
                    return Boolean.TRUE;
                }
                b.d.p.d.a("DoubleTalkStreamConnection", "设备：" + this.f462c + "LiveStream连接失败，errorCode：" + q);
                if (q == 401) {
                    c cVar = this.p2;
                    if (cVar != null) {
                        cVar.onDoubleTalkCreateFailure(this.f462c, 2);
                    }
                    com.tplink.libtpstreamconnectionsocket.a aVar2 = this.J3;
                    if (aVar2 != null) {
                        aVar2.f();
                    }
                    return Boolean.FALSE;
                }
                throw new IOException();
            } catch (Exception e2) {
                e2.printStackTrace();
                c cVar2 = this.p2;
                if (cVar2 != null) {
                    cVar2.onDoubleTalkCreateFailure(this.f462c, 2);
                }
                if ((e2 instanceof SocketTimeoutException) && (eVar = this.p3) != null) {
                    eVar.g(this.f462c, a(), e2);
                }
                return Boolean.FALSE;
            }
        } else {
            c cVar3 = this.p2;
            if (cVar3 != null) {
                cVar3.onDoubleTalkCreateFailure(this.f462c, 2);
            }
            return Boolean.TRUE;
        }
    }

    public void p() {
        this.I3 = false;
        this.p2 = null;
        this.p3 = null;
        this.Q3 = null;
        new Thread(new Runnable() { // from class: b.d.v.b.a
            @Override // java.lang.Runnable
            public final void run() {
                d.this.n();
            }
        }).start();
        q();
        if (TalkMode.AEC.equalsIgnoreCase(this.O3)) {
            C();
        }
    }

    public void t(byte[] bArr) {
        if (this.I3) {
            r(bArr);
        }
    }

    public void u(a aVar) {
        this.Q3 = aVar;
    }

    public void v(c cVar) {
        this.p2 = cVar;
    }

    public void w(e eVar) {
        this.p3 = eVar;
    }

    public void x(Future<Boolean> future) {
        this.H3 = future;
    }

    public void y(String str) {
        this.K3 = str;
    }

    public void z(n nVar) {
        this.M3 = nVar;
    }
}
