package b.d.i.a.b.c;

import b.d.i.a.a.f;
import b.d.i.a.b.b;
import b.d.p.d;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.common.CommonPayload;
import com.tplink.libtpcommonstream.stream.control.common.NotificationEventType;
import com.tplink.libtpcommonstream.stream.control.common.PreviewAudio;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlNotification;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlResponse;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlType;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelLensMaskInfo;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelMotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpcommonstream.stream.control.notification.MotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.StreamFinish;
import com.tplink.libtpcommonstream.stream.control.notification.StreamNotificationCallback;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;
import com.tplink.libtpcommonstream.stream.control.request.DoChangeResolutionsRequest;
import com.tplink.libtpcommonstream.stream.control.request.DoPlayParams;
import com.tplink.libtpcommonstream.stream.control.request.DoPlayRequest;
import com.tplink.libtpcommonstream.stream.control.request.GetDownloadRequest;
import com.tplink.libtpcommonstream.stream.control.request.param.GetDownloadParams;
import com.tplink.libtpcommonstream.stream.control.request.param.GetPreviewParams;
import com.tplink.libtpcommonstream.stream.control.response.DoPlayResponse;
import com.tplink.libtpcommonstream.stream.control.response.GetDownloadResponse;
import com.tplink.libtpcommonstream.stream.control.response.GetPreviewResponse;
import com.tplink.libtpcommonstream.stream.control.response.Response;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.l0.a;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.t;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: StreamControlClient.java */
/* loaded from: classes3.dex */
public class o implements n {
    private static int a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, r<CommonPayload>> f488b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private StreamNotificationCallback f489c;

    public o() {
        E();
    }

    private <T, R> q<StreamControlResponse<R>> B(StreamControlRequest<T> streamControlRequest, final Class<R> cls, String str, f fVar, String str2) {
        return (q<R>) D(streamControlRequest, str, fVar, str2, 15L).N(new j() { // from class: b.d.i.a.b.c.f
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t f0;
                f0 = q.f0(b.e((CommonPayload) obj, cls));
                return f0;
            }
        }).L0(a.c());
    }

    private <T, R> q<StreamControlResponse<R>> C(StreamControlRequest<T> streamControlRequest, final Class<R> cls, String str, f fVar, String str2, int i) {
        return (q<R>) D(streamControlRequest, str, fVar, str2, i).N(new j() { // from class: b.d.i.a.b.c.h
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t f0;
                f0 = q.f0(b.e((CommonPayload) obj, cls));
                return f0;
            }
        }).L0(a.c());
    }

    private q<CommonPayload> D(StreamControlRequest streamControlRequest, String str, final f fVar, String str2, long j) {
        return q.f0(streamControlRequest).g0(new j() { // from class: b.d.i.a.b.c.d
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return o.this.w(fVar, (StreamControlRequest) obj);
            }
        }).N(new j() { // from class: b.d.i.a.b.c.j
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return o.this.A((String) obj);
            }
        }).U0(j, TimeUnit.SECONDS, q.f0(f()));
    }

    private CommonPayload f() {
        CommonPayload commonPayload = new CommonPayload();
        commonPayload.setType(StreamControlType.RESPONSE);
        Response response = new Response();
        response.setErrorCode(-2);
        commonPayload.setParams(b.f().A(response));
        return commonPayload;
    }

    private int g() {
        int i = a;
        a = i + 1;
        return i;
    }

    private void h(final String str, final StreamControlNotification<Object> streamControlNotification) {
        String eventType = streamControlNotification.getEventType();
        if (this.f489c != null) {
            eventType.hashCode();
            char c2 = 65535;
            switch (eventType.hashCode()) {
                case -1172151021:
                    if (eventType.equals(NotificationEventType.EVENT_TYPE_DEVICE_LOCKED)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -255557448:
                    if (eventType.equals(NotificationEventType.EVENT_TYPE_MOTOR_STATUS)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 242469426:
                    if (eventType.equals(NotificationEventType.EVENT_TYPE_STREAM_FINISH)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 624430481:
                    if (eventType.equals(NotificationEventType.EVENT_TYPE_STREAM_STATUS)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1267100380:
                    if (eventType.equals(NotificationEventType.EVENT_TYPE_CHANNEL_LENS_MASK)) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    final DeviceLockedInfo deviceLockedInfo = (DeviceLockedInfo) streamControlNotification.getResult();
                    q.f0(1).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: b.d.i.a.b.c.b
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            o.this.k(str, deviceLockedInfo, (Integer) obj);
                        }
                    });
                    return;
                case 1:
                    List<String> status = ((ChannelMotorStatus) streamControlNotification.getResult()).getStatus();
                    if (status != null && !status.isEmpty()) {
                        q.f0(status.get(0)).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: b.d.i.a.b.c.g
                            @Override // io.reactivex.g0.g
                            public final void accept(Object obj) {
                                o.this.o(str, (String) obj);
                            }
                        });
                        return;
                    }
                    return;
                case 2:
                    final StreamFinish streamFinish = (StreamFinish) streamControlNotification.getResult();
                    q.f0(1).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: b.d.i.a.b.c.i
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            o.this.q(str, streamFinish, (Integer) obj);
                        }
                    });
                    return;
                case 3:
                    q.f0(1).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: b.d.i.a.b.c.e
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            o.this.s(str, streamControlNotification, (Integer) obj);
                        }
                    });
                    return;
                case 4:
                    final boolean equals = "on".equals(((ChannelLensMaskInfo) streamControlNotification.getResult()).getEnabled());
                    q.f0(1).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: b.d.i.a.b.c.a
                        @Override // io.reactivex.g0.g
                        public final void accept(Object obj) {
                            o.this.m(str, equals, (Integer) obj);
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ DoPlayResponse i(StreamControlResponse streamControlResponse) throws Exception {
        return (DoPlayResponse) streamControlResponse.getResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(String str, DeviceLockedInfo deviceLockedInfo, Integer num) throws Exception {
        this.f489c.onReceiveDeviceLockedInfo(str, deviceLockedInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(String str, boolean z, Integer num) throws Exception {
        this.f489c.onReceiveLensMaskInfo(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(String str, String str2) throws Exception {
        MotorStatus motorStatus = MotorStatus.MOVING;
        if (motorStatus.getValue().equals(str2)) {
            this.f489c.onReceiveMotorStatus(str, motorStatus);
        } else {
            this.f489c.onReceiveMotorStatus(str, MotorStatus.IDLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void q(String str, StreamFinish streamFinish, Integer num) throws Exception {
        this.f489c.onReceiveStreamFinish(str, streamFinish.getReason());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(String str, StreamControlNotification streamControlNotification, Integer num) throws Exception {
        this.f489c.onReceiveStreamStatus(str, (StreamStatus) streamControlNotification.getResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ String w(f fVar, StreamControlRequest streamControlRequest) throws Exception {
        streamControlRequest.setSeq(g());
        String d2 = b.d(streamControlRequest);
        d.a("StreamControlClient", "" + d2);
        if (fVar != null) {
            fVar.f(d2);
        }
        d.a("StreamControlClient", "seq:: " + streamControlRequest.getSeq() + "");
        StringBuilder sb = new StringBuilder();
        sb.append("connection ");
        sb.append(fVar.a());
        d.a("StreamControlClient", sb.toString());
        return streamControlRequest.getSeq() + "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(String str, r rVar) throws Exception {
        d.a("StreamControlClient", "sssssssseq:: " + str);
        this.f488b.put(str, rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ t A(final String str) throws Exception {
        return q.m(new s() { // from class: b.d.i.a.b.c.c
            @Override // io.reactivex.s
            public final void subscribe(r rVar) {
                o.this.y(str, rVar);
            }
        });
    }

    public void E() {
        a = 1;
        d.a("StreamControlClient", "resetSequence ");
        d.a("StreamControlClient", "mObservableMap size " + this.f488b.size());
        this.f488b.clear();
    }

    public q<GetDownloadResponse> F(f fVar, String str, int i, int i2, String str2) {
        GetDownloadParams getDownloadParams = new GetDownloadParams();
        getDownloadParams.setChannels(Collections.singletonList(0));
        getDownloadParams.setClientId(i);
        getDownloadParams.setMediaType(Integer.valueOf(i2));
        getDownloadParams.setStartTime(str2);
        GetDownloadRequest getDownloadRequest = new GetDownloadRequest();
        getDownloadRequest.setDownload(getDownloadParams);
        return B(new StreamControlRequest(getDownloadRequest), GetDownloadResponse.class, "download_type", fVar, str).g0(l.f486c);
    }

    public void G(StreamNotificationCallback streamNotificationCallback) {
        this.f489c = streamNotificationCallback;
    }

    @Override // b.d.i.a.b.c.n
    public void a(String str, StreamControlNotification<Object> streamControlNotification) {
        h(str, streamControlNotification);
    }

    @Override // b.d.i.a.b.c.n
    public int b() {
        return g();
    }

    @Override // b.d.i.a.b.c.n
    public void c(CommonPayload commonPayload) {
        String str = commonPayload.getSeq() + "";
        d.a("StreamControlClient", "onReceiveResponse seq " + str);
        r<CommonPayload> rVar = this.f488b.get(str);
        if (rVar != null) {
            this.f488b.remove(str);
            rVar.onNext(commonPayload);
            rVar.onComplete();
        }
        d.a("StreamControlClient", "onReceiveResponse mObservableMap " + this.f488b.size());
    }

    public q<DoPlayResponse> d(f fVar, String str, String str2, long j, long j2) {
        DoPlayParams doPlayParams = new DoPlayParams();
        doPlayParams.setScale(str2);
        if (j <= 0) {
            return q.J(new Exception("playback start time must invalid"));
        }
        doPlayParams.setStartTime(String.valueOf(j));
        if (j2 > 0) {
            doPlayParams.setEndTime(String.valueOf(j2));
        }
        DoPlayRequest doPlayRequest = new DoPlayRequest();
        doPlayRequest.setPlay(doPlayParams);
        return B(new StreamControlRequest(doPlayRequest), DoPlayResponse.class, "playback_type", fVar, str).g0(k.f485c);
    }

    public q<Response> e(f fVar, String str, BitStreamType bitStreamType, String str2) {
        GetPreviewParams getPreviewParams = new GetPreviewParams();
        getPreviewParams.setChannels(Collections.singletonList(0));
        if (bitStreamType == null) {
            bitStreamType = b.d.d.e.a.b(str);
        }
        if (str2 == null) {
            str2 = PreviewAudio.AUDIO_DEFAULT;
        }
        getPreviewParams.setResolutions(Collections.singletonList(bitStreamType.getValue()));
        getPreviewParams.setAudio(Collections.singletonList(str2));
        DoChangeResolutionsRequest doChangeResolutionsRequest = new DoChangeResolutionsRequest();
        doChangeResolutionsRequest.setChangeResolutions(getPreviewParams);
        return C(new StreamControlRequest(doChangeResolutionsRequest), GetPreviewResponse.class, "preview_type", fVar, str, 60).g0(m.f487c);
    }
}
