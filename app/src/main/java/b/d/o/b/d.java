package b.d.o.b;

import android.text.TextUtils;
import b.d.i.a.a.e;
import b.d.i.a.a.f;
import b.d.i.a.b.b;
import b.d.i.a.b.c.n;
import com.tplink.libmediakit.jniinterface.GenKey;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpappcommonmedia.exception.CameraException;
import com.tplink.libtpcommonstream.stream.control.common.CommonPayload;
import com.tplink.libtpcommonstream.stream.control.common.NotificationEventType;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlNotification;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlType;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelMotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.MotorStatus;
import com.tplink.libtpcommonstream.stream.control.request.DoStopRequest;
import com.tplink.libtpcommonstream.stream.control.response.GetPreviewResponse;
import com.tplink.libtpmediastatistics.ConnectionInfoVO;
import com.tplink.libtpmediastatistics.OnceConnectionVO;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpmediastatistics.StatisticsManager;
import com.tplink.libtpmediastatistics.StatisticsStreamType;
import com.tplink.libtpmediastatistics.StopReason;
import com.tplink.libtpstreamconnectionsocket.EncryptException;
import com.tplink.libtpstreamconnectionsocket.a;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: LiveStreamConnection.java */
/* loaded from: classes3.dex */
public class d extends f {
    protected f H3;
    protected n I3;
    protected Future<Boolean> J3;
    protected a K3;
    protected b.d.p.a N3;
    protected final String O3;
    protected final String P3;
    protected long R3;
    protected long S3;
    protected boolean T3;
    protected c p3;
    private String p2 = "LiveStreamConnection";
    protected volatile boolean M3 = true;
    protected String L3 = null;
    protected boolean Q3 = true;

    public d(String str, String str2) {
        this.O3 = str;
        this.P3 = str2;
    }

    @Override // b.d.i.a.a.f
    public void f(String str) {
        if (this.K3 != null && !TextUtils.isEmpty(this.O3)) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.L3)) {
                hashMap.put(SSLClient.X_SESSION_ID, this.L3);
            }
            this.K3.t(str, hashMap);
        }
    }

    /* renamed from: l */
    public Boolean call() {
        String str;
        StringBuilder sb;
        String str2;
        int q;
        String str3 = this.p2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("设备：");
        sb2.append(this.f462c);
        sb2.append("尝试连接LiveStream连接， URL");
        sb2.append(this.f463d);
        sb2.append(" contype ");
        sb2.append(a());
        b.d.p.d.a(str3, sb2.toString());
        m();
        String d2 = b.d.d.a.a.d();
        if (TextUtils.isEmpty(d2)) {
            d2 = GenKey.a();
        }
        String str4 = this.p2;
        b.d.p.d.a(str4, "设备建立直播流：账号：admin 密码：" + d2 + " contype " + a());
        if (e()) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "multipart/mixed; boundary=--client-stream-boundary--");
            str = b.d.i.a.c.a.a().c(a.o(this.f463d, this.f464f), "admin", d2, SSLClient.HTTP_POST, hashMap);
        } else {
            str = "";
        }
        String str5 = this.p2;
        b.d.p.d.a(str5, "auth " + str + " contype " + a());
        if (!TextUtils.isEmpty(str) || !e()) {
            try {
                try {
                    a aVar = new a(this.f463d, this.f464f);
                    this.K3 = aVar;
                    aVar.F(30000);
                    this.K3.H(15000);
                    this.K3.G(SSLClient.HTTP_POST);
                    if (17 == a()) {
                        this.K3.e(this.f462c);
                    } else {
                        this.K3.d();
                    }
                    boolean z = a() == 0;
                    String str6 = this.p2;
                    b.d.p.d.a(str6, "skipRespond " + z + " contype " + a());
                    q = this.K3.q(str, z);
                    String str7 = this.p2;
                    b.d.p.d.a(str7, "code " + q + " contype " + a());
                    if (q == 200) {
                        Map<String, String> p = this.K3.p();
                        if (p.containsKey(SSLClient.KEY_EXCHANGE)) {
                            String str8 = p.get(SSLClient.KEY_EXCHANGE);
                            String str9 = this.p2;
                            b.d.p.d.a(str9, "" + str8);
                            this.N3 = e.b(str8, d2);
                            this.T3 = true;
                        }
                    }
                } catch (MalformedURLException e2) {
                    String str10 = this.p2;
                    b.d.p.d.a(str10, "设备：" + this.f462c + "LiveStream连接异常,发生严重错误，终止播放 " + e2.toString() + " contype " + a());
                    c cVar = this.p3;
                    if (cVar != null) {
                        cVar.b(this.f462c, e2);
                    }
                    f fVar = this.H3;
                    if (fVar != null) {
                        fVar.t(this.f462c, this.x, false, e2);
                    }
                    str2 = this.p2;
                    sb = new StringBuilder();
                } catch (Exception e3) {
                    String str11 = this.p2;
                    b.d.p.d.c(str11, "设备：" + this.f462c + "LiveStream连接异常 Exception " + e3.toString() + " contype " + a());
                    if (e3.getMessage() == null || !e3.getMessage().contains("connection abort")) {
                        f fVar2 = this.H3;
                        if (fVar2 != null) {
                            fVar2.t(this.f462c, this.x, true, e3);
                        }
                    } else {
                        c cVar2 = this.p3;
                        if (cVar2 != null) {
                            cVar2.b(this.f462c, e3);
                        }
                    }
                    str2 = this.p2;
                    sb = new StringBuilder();
                }
                if (q == 200 || q == 204) {
                    String str12 = this.p2;
                    b.d.p.d.a(str12, "设备：" + this.f462c + " LiveStream连接成功，开始获取直播流数据 contype " + a());
                    o();
                    str2 = this.p2;
                    sb = new StringBuilder();
                    sb.append("设备：");
                    sb.append(this.f462c);
                    sb.append("LiveStream连接终止！ contype ");
                    sb.append(a());
                    b.d.p.d.a(str2, sb.toString());
                    this.M3 = false;
                    r();
                    q();
                    n();
                    return Boolean.TRUE;
                }
                String str13 = this.p2;
                b.d.p.d.a(str13, "设备：" + this.f462c + "LiveStream连接失败，errorCode：" + q + " contype " + a());
                if (q == 401) {
                    if (256 == a()) {
                        c cVar3 = this.p3;
                        if (cVar3 != null) {
                            cVar3.b(this.f462c, new Exception(String.valueOf(q)));
                        }
                    } else {
                        c cVar4 = this.p3;
                        if (cVar4 != null) {
                            cVar4.b(this.f462c, new EncryptException("psw is error"));
                        }
                    }
                    f fVar3 = this.H3;
                    if (fVar3 != null) {
                        fVar3.t(this.f462c, this.x, false, new Exception());
                    }
                    a aVar2 = this.K3;
                    if (aVar2 != null) {
                        aVar2.f();
                    }
                    return Boolean.FALSE;
                }
                throw new IOException();
            } finally {
                String str14 = this.p2;
                b.d.p.d.a(str14, "设备：" + this.f462c + "LiveStream连接终止！ contype " + a());
                this.M3 = false;
                r();
                q();
                n();
            }
        } else {
            if (!(this.p3 == null || this.x == 17)) {
                List<Exception> b2 = b.d.i.a.c.a.a().b();
                if (!b2.isEmpty()) {
                    this.p3.b(this.f462c, b2.get(b2.size() - 1));
                } else {
                    this.p3.b(this.f462c, new Exception("Digest Failed"));
                }
            }
            f fVar4 = this.H3;
            if (fVar4 != null) {
                fVar4.t(this.f462c, this.x, false, new Exception());
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        this.T3 = false;
        this.R3 = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        StatisticsStreamType statisticsStreamType;
        if (256 != this.x) {
            long currentTimeMillis = System.currentTimeMillis();
            this.S3 = currentTimeMillis;
            int i = this.q;
            if (i == 1) {
                statisticsStreamType = StatisticsStreamType.MIXED;
            } else if (i == 3) {
                statisticsStreamType = StatisticsStreamType.VIDEO;
            } else {
                statisticsStreamType = StatisticsStreamType.AUDIO;
            }
            int round = Math.round(((float) (currentTimeMillis - this.R3)) / 1000.0f);
            OnceConnectionVO andRemoveOnceConnectionVO = StatisticsManager.getInstance().getAndRemoveOnceConnectionVO(StatisticsManager.getInstance().getOnceConnectionCacheKey(this.f462c, statisticsStreamType, this.x));
            andRemoveOnceConnectionVO.setFlowUsed(this.K3.j());
            andRemoveOnceConnectionVO.setWatchTime(round);
            if (round > 7140) {
                andRemoveOnceConnectionVO.setStopReason(StopReason.RELAY_TIME_LIMIT.value());
            }
            String connectionInfoCacheKey = StatisticsManager.getInstance().getConnectionInfoCacheKey(this.f462c, statisticsStreamType);
            ConnectionInfoVO connectionInfoVO = StatisticsManager.getInstance().getConnectionInfoVO(connectionInfoCacheKey);
            if (connectionInfoVO == null) {
                connectionInfoVO = new ConnectionInfoVO();
                StatisticsManager.getInstance().insertConnectionInfoVO(connectionInfoCacheKey, connectionInfoVO);
            }
            int i2 = this.x;
            if (i2 == 16) {
                connectionInfoVO.getP2pConnectionVO().addData(andRemoveOnceConnectionVO);
            } else if (i2 == 0) {
                connectionInfoVO.getRelayConnectionVO().addData(andRemoveOnceConnectionVO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() throws Exception {
        c cVar;
        b.d.p.a aVar;
        List<String> status;
        b.d.p.a aVar2;
        if (!TextUtils.isEmpty(this.O3)) {
            String str = this.p2;
            b.d.p.d.a(str, "requestPreview " + this.O3 + " contentType " + a());
            this.K3.t(this.O3, null);
        }
        while (this.M3) {
            this.K3.g();
            Map<String, String> p = this.K3.p();
            if (p.size() != 0) {
                if (this.y && this.p1) {
                    this.z = true;
                    this.y = false;
                    if (this.H3 != null) {
                        String str2 = this.p2;
                        b.d.p.d.a(str2, "liveStreamConnectionSuccess  contype " + a());
                        this.H3.a(this.f462c, c(), a());
                    }
                    c cVar2 = this.p3;
                    if (cVar2 != null) {
                        cVar2.a(this.f462c, a());
                    }
                }
                if (p.containsKey("Content-Type")) {
                    String str3 = p.get("Content-Type");
                    p.get(SSLClient.X_SESSION_ID);
                    boolean z = p.containsKey(SSLClient.X_IF_ENCRYPT) && "1".equals(p.get(SSLClient.X_IF_ENCRYPT));
                    if ("video/mp2t".equals(str3)) {
                        this.p1 = true;
                        byte[] m = this.K3.m();
                        if (z && (aVar = this.N3) != null) {
                            m = aVar.a(m, m.length);
                        }
                        if (!(this.L3 == null || (cVar = this.p3) == null)) {
                            cVar.c(this.f462c, m);
                        }
                    } else if (HttpHeaders.Values.APPLICATION_JSON.equals(str3)) {
                        byte[] m2 = this.K3.m();
                        if (z && (aVar2 = this.N3) != null) {
                            m2 = aVar2.a(m2, m2.length);
                        }
                        String str4 = new String(m2);
                        String str5 = this.p2;
                        b.d.p.d.a(str5, "payload: " + str4);
                        CommonPayload commonPayload = (CommonPayload) b.b(str4, CommonPayload.class);
                        if (StreamControlType.NOTIFICATION.equals(commonPayload.getType())) {
                            StreamControlNotification<Object> c2 = b.c(commonPayload);
                            if (!(c2 == null || this.I3 == null)) {
                                String str6 = this.p2;
                                b.d.p.d.a(str6, "event type " + c2.getEventType());
                                this.I3.a(this.f462c, c2);
                            }
                            if (c2 != null && NotificationEventType.EVENT_TYPE_MOTOR_STATUS.equals(c2.getEventType()) && (status = ((ChannelMotorStatus) c2.getResult()).getStatus()) != null && !status.isEmpty()) {
                                this.p3.e(this.f462c, MotorStatus.MOVING.getValue().equals(status.get(0)));
                            }
                        } else if (StreamControlType.RESPONSE.equals(commonPayload.getType())) {
                            if (this.L3 == null) {
                                GetPreviewResponse getPreviewResponse = (GetPreviewResponse) b.e(commonPayload, GetPreviewResponse.class).getResult();
                                if (getPreviewResponse.getErrorCode() == 0 && !TextUtils.isEmpty(getPreviewResponse.getSessionId())) {
                                    w(getPreviewResponse.getSessionId());
                                } else if (getPreviewResponse.getErrorCode() == -52405) {
                                    if (!this.Q3 || TextUtils.isEmpty(this.P3)) {
                                        c cVar3 = this.p3;
                                        if (cVar3 != null) {
                                            cVar3.b(this.f462c, new CameraException(-52405, "need too try use vga"));
                                        }
                                    } else {
                                        this.Q3 = false;
                                        this.K3.t(this.P3, null);
                                        c cVar4 = this.p3;
                                        if (cVar4 != null) {
                                            cVar4.d(this.f462c, BitStreamType.MINOR_VGA);
                                        }
                                    }
                                } else if (getPreviewResponse.getErrorCode() == -52419) {
                                    f fVar = this.H3;
                                    if (fVar != null) {
                                        fVar.t(this.f462c, this.x, false, new Exception());
                                    }
                                } else {
                                    c cVar5 = this.p3;
                                    if (cVar5 != null) {
                                        cVar5.b(this.f462c, new Exception("Live Stream Connected session callback error"));
                                    }
                                }
                            } else {
                                n nVar = this.I3;
                                if (nVar != null) {
                                    nVar.c(commonPayload);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void p() {
        String str = this.p2;
        b.d.p.d.a(str, "设备：" + this.f462c + "直播流被release()");
        this.M3 = false;
        this.p3 = null;
        this.H3 = null;
        Future<Boolean> future = this.J3;
        if (future != null) {
            future.cancel(true);
            this.J3 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        a aVar = this.K3;
        if (aVar != null) {
            aVar.f();
        }
        this.N3 = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        if (this.K3 != null && !TextUtils.isEmpty(this.L3)) {
            try {
                int b2 = this.I3.b();
                StreamControlRequest streamControlRequest = new StreamControlRequest(new DoStopRequest());
                streamControlRequest.setSeq(b2);
                String d2 = b.d(streamControlRequest);
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", HttpHeaders.Values.APPLICATION_JSON);
                hashMap.put(SSLClient.X_SESSION_ID, this.L3);
                this.K3.I(true);
                this.K3.D(hashMap, d2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void s(c cVar) {
        this.p3 = cVar;
    }

    public void t(f fVar) {
        this.H3 = fVar;
    }

    public void u(n nVar) {
        this.I3 = nVar;
    }

    public void v(Future<Boolean> future) {
        this.J3 = future;
    }

    public void w(String str) {
        this.L3 = str;
        String str2 = this.p2;
        b.d.p.d.a(str2, "sessionId " + str);
    }
}
