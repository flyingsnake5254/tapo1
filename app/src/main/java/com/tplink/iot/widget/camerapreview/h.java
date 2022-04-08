package com.tplink.iot.widget.camerapreview;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import b.d.d.m.f;
import com.tplink.iot.core.p;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.widget.camerapreview.e;
import com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;

/* compiled from: StreamDisplayEngine.kt */
/* loaded from: classes3.dex */
public final class h implements StreamDisplayCommonCallback {

    /* renamed from: d  reason: collision with root package name */
    private final io.reactivex.m0.d<e> f11717d;

    /* renamed from: f  reason: collision with root package name */
    private io.reactivex.e0.c f11718f;
    private GLSurfaceViewGPU p0;
    public String x;
    private ViewGroup z;

    /* renamed from: c  reason: collision with root package name */
    private final String f11716c = "StreamDisplayEngine";
    private e q = e.a.e();
    private final boolean y = !o.h0().c("SPEED_ICON_VISIBLE", true);
    private MutableLiveData<f<String>> p1 = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StreamDisplayEngine.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f11720d;

        a(String str) {
            this.f11720d = str;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            LiveMediaAPI.previewCapture(this.f11720d, h.this.d());
            LiveMediaAPI.removeSteamDisplayCommonCallback(this.f11720d, h.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StreamDisplayEngine.kt */
    /* loaded from: classes3.dex */
    public static final class b<T> implements g<e> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f11721c;

        b(String str) {
            this.f11721c = str;
        }

        /* renamed from: a */
        public final void accept(e eVar) {
            if (!(p.c() instanceof VideoPlayActivity) && LiveMediaAPI.isPlayingProperly(this.f11721c)) {
                LiveMediaAPI.releaseStream(this.f11721c);
            }
            TPCameraDeviceContext K1 = TPIoTClientManager.K1(this.f11721c);
            j.d(K1, "TPIoTClientManager.getCameraContext(deviceIdMD5)");
            K1.getCameraDevice();
        }
    }

    /* compiled from: StreamDisplayEngine.kt */
    /* loaded from: classes3.dex */
    static final class c<T> implements g<e> {
        c() {
        }

        /* renamed from: a */
        public final void accept(e state) {
            h hVar = h.this;
            j.d(state, "state");
            hVar.q = state;
        }
    }

    /* compiled from: StreamDisplayEngine.kt */
    /* loaded from: classes3.dex */
    static final class d<T> implements g<Long> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Exception f11724d;

        d(Exception exc) {
            this.f11724d = exc;
        }

        /* renamed from: a */
        public final void accept(Long l) {
            h.this.f11717d.onNext(e.a.b(this.f11724d).B("playFatalException1"));
        }
    }

    public h() {
        io.reactivex.m0.d<e> n1 = io.reactivex.m0.d.n1();
        j.d(n1, "PublishSubject.create<DisplayViewState>()");
        this.f11717d = n1;
    }

    public final void c() {
        GLSurfaceViewGPU gLSurfaceViewGPU;
        io.reactivex.e0.c cVar = this.f11718f;
        if (cVar != null) {
            cVar.dispose();
        }
        this.f11718f = null;
        ViewGroup viewGroup = this.z;
        if (viewGroup != null && (gLSurfaceViewGPU = this.p0) != null) {
            gLSurfaceViewGPU.a(viewGroup);
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void changeVideoBitStreamType(String deviceIdMD5, BitStreamType bitStreamType, boolean z, int i) {
        j.e(deviceIdMD5, "deviceIdMD5");
        j.e(bitStreamType, "bitStreamType");
    }

    public final MutableLiveData<f<String>> d() {
        return this.p1;
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void displayDestroy() {
        this.f11717d.onNext(e.a.a().B("Display destroy"));
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void displayNetworkSpeed(float f2) {
        if (!this.y) {
            io.reactivex.m0.d<e> dVar = this.f11717d;
            e.a aVar = e.a;
            dVar.onNext(aVar.m(f2 + "/kbs"));
        }
    }

    public final q<e> e(String deviceIdMD5) {
        j.e(deviceIdMD5, "deviceIdMD5");
        q<e> E = q.f0(e.a.h().B("pausePlay")).o(600L, TimeUnit.MILLISECONDS).F(new a(deviceIdMD5)).L0(io.reactivex.l0.a.c()).E(new b(deviceIdMD5));
        j.d(E, "Observable\n            .…iceContext)\n            }");
        return E;
    }

    public final q<e> f(String deviceIdMD5, ViewGroup viewGroup, Context context) {
        j.e(deviceIdMD5, "deviceIdMD5");
        j.e(viewGroup, "viewGroup");
        j.e(context, "context");
        if (this.f11718f == null) {
            this.f11718f = this.f11717d.G0(new c());
        }
        this.z = viewGroup;
        LiveMediaAPI.addSteamDisplayCommonCallback(deviceIdMD5, this);
        LiveMediaAPI.startLiveStreamDisplay(deviceIdMD5, context, b.d.d.e.a.b(deviceIdMD5));
        return this.f11717d;
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void framePerSecond(String deviceIdMD5, int i) {
        j.e(deviceIdMD5, "deviceIdMD5");
    }

    public final void g(String str) {
        j.e(str, "<set-?>");
        this.x = str;
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void hideLoadingView() {
        this.f11717d.onNext(e.a.i().B("hideLoadingView"));
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void onRenderProgramAdd(String str, GLSurfaceViewGPU gLSurfaceViewGPU) {
        ViewGroup viewGroup = this.z;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ViewGroup viewGroup2 = this.z;
        if (viewGroup2 != null) {
            viewGroup2.addView(gLSurfaceViewGPU, 0);
        }
        this.p0 = gLSurfaceViewGPU;
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void onSnapshotComplete(String uri) {
        j.e(uri, "uri");
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void onStreamFinish() {
        String str = this.x;
        if (str == null) {
            j.t("deviceIdMD5");
        }
        e(str);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void playFatalException(Exception e2) {
        j.e(e2, "e");
        if (j.a(this.q.u(), Boolean.TRUE)) {
            q.W0(1L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).G0(new d(e2));
        } else {
            this.f11717d.onNext(e.a.b(e2).B("playFatalException2"));
        }
        String str = this.x;
        if (str == null) {
            j.t("deviceIdMD5");
        }
        e(str);
        if ((e2 instanceof CameraException) && ((CameraException) e2).getErrorCode() == -52405) {
            String str2 = this.x;
            if (str2 == null) {
                j.t("deviceIdMD5");
            }
            b.d.d.e.a.c(str2, BitStreamType.MINOR_VGA);
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordFailed(int i) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordProgress(long j) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordStart() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordStop() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordSuccess(int i, String filePath) {
        j.e(filePath, "filePath");
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void relayPreviewTimeLimit(int i) {
        this.f11717d.onNext(e.a.h().B("RelayPreview Timeout"));
        String str = this.x;
        if (str == null) {
            j.t("deviceIdMD5");
        }
        LiveMediaAPI.releaseStream(str);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void retryResolutions(BitStreamType bitStreamType) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void showLoadingView() {
        if (!j.a(this.q.u(), Boolean.TRUE)) {
            this.f11717d.onNext(e.a.f().B("showLoadingView"));
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void startHoldToTalk() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void stopHoldToTalk() {
    }
}
