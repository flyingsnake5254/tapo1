package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import b.d.q.b.i;
import b.d.q.b.l;
import com.tplink.iot.R;
import com.tplink.iot.Utils.y0.e;
import com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback;
import com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback;
import com.tplink.libmediaapi.vod.VodMediaAPI;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpcommonstream.stream.control.notification.MotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;
import com.tplink.libtpmediaother.database.model.d;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;
import io.reactivex.e0.b;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.l0.a;
import io.reactivex.q;
import io.reactivex.t;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class VodViewModel extends AndroidViewModel implements StreamDisplayCommonCallback, StreamNotificationCallback {
    public ObservableField<Drawable> H3;
    public ObservableField<String> I3;
    public ObservableBoolean J3;
    public ObservableBoolean K3;
    public ObservableBoolean N3;
    public ObservableField<String> O3;
    public final ObservableField<VodPlayRate> T3;
    public final ObservableField<String> U3;

    /* renamed from: c  reason: collision with root package name */
    private PlaybackMainViewModel f10587c;

    /* renamed from: d  reason: collision with root package name */
    private PlayBackControlViewModel f10588d;

    /* renamed from: f  reason: collision with root package name */
    private String f10589f;
    public ObservableBoolean p0;
    public ObservableBoolean p1;
    public ObservableBoolean p2;
    public ObservableField<Drawable> p3;
    public ObservableBoolean q;
    public ObservableBoolean x;
    public ObservableBoolean y;
    public ObservableBoolean z;
    public ObservableBoolean L3 = new ObservableBoolean(false);
    private b M3 = new b();
    private long P3 = 0;
    private long Q3 = 0;
    public final ObservableBoolean R3 = new ObservableBoolean(true);
    public final ObservableBoolean S3 = new ObservableBoolean(false);
    public final MutableLiveData<GLSurfaceViewGPU> V3 = new MutableLiveData<>();
    private boolean W3 = false;

    public VodViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        VodPlayRate vodPlayRate = VodPlayRate.RATE_1_1;
        this.T3 = new ObservableField<>(vodPlayRate);
        this.U3 = new ObservableField<>(vodPlayRate.getDisplayValue());
        h();
    }

    private String g(long j) {
        String str;
        String str2;
        String str3;
        int i = (int) (j % 60);
        if (i < 10) {
            str = "0" + i;
        } else {
            str = String.valueOf(i);
        }
        int i2 = (int) ((j / 60) % 60);
        if (i2 < 10) {
            str2 = "0" + i2;
        } else {
            str2 = String.valueOf(i2);
        }
        int i3 = (int) (j / 3600);
        if (i3 < 10) {
            str3 = "0" + i3;
        } else {
            str3 = String.valueOf(i3);
        }
        return str3 + SSLClient.COLON + str2 + SSLClient.COLON + str;
    }

    private void h() {
        this.q = new ObservableBoolean(true);
        this.x = new ObservableBoolean(false);
        this.y = new ObservableBoolean(false);
        this.z = new ObservableBoolean(false);
        this.p0 = new ObservableBoolean(false);
        this.p1 = new ObservableBoolean(false);
        this.p2 = new ObservableBoolean(false);
        this.p3 = new ObservableField<>();
        this.H3 = new ObservableField<>();
        this.I3 = new ObservableField<>();
        this.J3 = new ObservableBoolean(false);
        this.K3 = new ObservableBoolean(false);
        this.N3 = new ObservableBoolean(false);
        this.O3 = new ObservableField<>();
        this.P3 = 0L;
        this.Q3 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ t j(Drawable drawable) throws Exception {
        this.H3.set(drawable);
        this.J3.set(true);
        this.K3.set(true);
        return q.W0(3L, TimeUnit.SECONDS).L0(a.c()).l0(io.reactivex.d0.b.a.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(Long l) throws Exception {
        this.J3.set(false);
        this.K3.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ t n(int i, Drawable drawable) throws Exception {
        this.f10587c.y(getApplication().getString(R.string.video_recording_saved));
        this.I3.set(g(i));
        this.H3.set(drawable);
        this.J3.set(true);
        this.K3.set(true);
        return q.W0(3L, TimeUnit.SECONDS).l0(a.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(Long l) throws Exception {
        this.J3.set(false);
        this.K3.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(String str, String str2, ALCameraDevice aLCameraDevice, d dVar) {
        dVar.w(str);
        dVar.q(str2);
        dVar.o(aLCameraDevice != null ? aLCameraDevice.getDeviceIdMD5() : this.f10589f);
        dVar.m(i.a());
        String str3 = "";
        dVar.n(aLCameraDevice != null ? aLCameraDevice.getDeviceAlias() : str3);
        if (aLCameraDevice != null) {
            str3 = aLCameraDevice.getModel();
        }
        dVar.p(str3);
        CameraAvatarInfo cameraAvatarInfo = aLCameraDevice != null ? aLCameraDevice.getCameraAvatarInfo() : null;
        if (cameraAvatarInfo != null) {
            if (org.apache.commons.lang.b.a(cameraAvatarInfo.getAvatarDefault())) {
                dVar.u(cameraAvatarInfo.getAvatarRemoteUrl());
            }
            dVar.t(cameraAvatarInfo.getAvatarName());
        }
    }

    private void t(@Nullable final ALCameraDevice aLCameraDevice, final String str, final String str2) {
        l.h(new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.play.r2
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                VodViewModel.this.s(str, str2, aLCameraDevice, (d) obj);
            }
        });
    }

    private void x() {
        VodMediaAPI.startRecord(this.f10589f);
    }

    private void y() {
        VodMediaAPI.stopRecord(this.f10589f);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void changeVideoBitStreamType(String str, BitStreamType bitStreamType, boolean z, int i) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void displayDestroy() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void displayNetworkSpeed(float f2) {
    }

    public void f() {
        if (this.N3.get()) {
            this.L3.set(true);
            y();
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void framePerSecond(String str, int i) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void hideLoadingView() {
        this.f10587c.g();
        this.f10587c.m.set(false);
        this.f10587c.l.set(false);
        this.f10587c.m.set(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.M3.dispose();
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback
    public void onReceiveDeviceLockedInfo(String str, DeviceLockedInfo deviceLockedInfo) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback
    public void onReceiveLensMaskInfo(String str, boolean z) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback
    public void onReceiveMotorStatus(String str, MotorStatus motorStatus) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback
    public void onReceiveStreamFinish(String str, String str2) {
        VodMediaAPI.releaseStream(str);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback
    public void onReceiveStreamStatus(String str, StreamStatus streamStatus) {
        if (StreamStatus.FINISHED.equals(streamStatus.getStatus())) {
            VodMediaAPI.releaseStream(str);
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void onRenderProgramAdd(String str, GLSurfaceViewGPU gLSurfaceViewGPU) {
        this.V3.setValue(gLSurfaceViewGPU);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void onSnapshotComplete(String str) {
        if (b.d.q.b.p.b.e(str)) {
            this.f10587c.y(getApplication().getString(R.string.video_capture_saved));
            this.I3.set("");
            t(this.f10587c.f10554d, String.valueOf(System.currentTimeMillis()), str);
            this.M3.b(e.b(getApplication(), str).N(new j() { // from class: com.tplink.iot.viewmodel.ipcamera.play.p2
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return VodViewModel.this.j((Drawable) obj);
                }
            }).G0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.q2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    VodViewModel.this.l((Long) obj);
                }
            }));
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void onStreamFinish() {
        VodMediaAPI.clearPlayerCache(this.f10589f);
        this.R3.set(false);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void playFatalException(Exception exc) {
        this.f10587c.n.set(false);
        if (exc instanceof CameraException) {
            CameraException cameraException = (CameraException) exc;
            if (cameraException.getErrorCode() == -52409) {
                this.f10587c.m(SdCardStatus.OFFLINE);
            } else if (cameraException.getErrorCode() == -52407) {
                this.f10588d.L();
                this.f10587c.n.set(true);
                if (!this.W3) {
                    com.tplink.iot.Utils.x0.e.C(this.f10589f);
                    this.W3 = true;
                }
            } else if (cameraException.getErrorCode() == -52402) {
                return;
            }
        }
        hideLoadingView();
        VodMediaAPI.stopRecord(this.f10589f);
        this.f10587c.m.set(true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordFailed(int i) {
        if (i != -1) {
            switch (i) {
                case -3200004:
                    this.f10587c.y(getApplication().getString(R.string.live_video_record_insufficient_space_saved));
                    return;
                case -3200003:
                    this.f10587c.y(getApplication().getString(R.string.live_video_record_insufficient_space_saved));
                    return;
                case -3200002:
                    this.f10587c.y(getApplication().getString(R.string.live_video_record_insufficient_space));
                    break;
                case -3200001:
                    break;
                default:
                    this.f10587c.y(getApplication().getString(R.string.record_error_video_damaged));
                    return;
            }
            this.f10587c.y(getApplication().getString(R.string.live_video_record_too_short));
            return;
        }
        this.f10587c.y(getApplication().getString(R.string.record_error_video_damaged));
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordProgress(long j) {
        this.O3.set(g(j / 1000));
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordStart() {
        this.N3.set(true);
        this.f10587c.y(getApplication().getString(R.string.video_play_recording));
        this.O3.set(g(0L));
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordStop() {
        this.N3.set(false);
        this.O3.set(null);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordSuccess(final int i, String str) {
        if (this.L3.get()) {
            this.L3.set(false);
        } else if (i <= 0 || !b.d.q.b.p.b.e(str)) {
            this.f10587c.y(getApplication().getString(R.string.record_error_video_damaged));
        } else {
            this.M3.b(e.b(getApplication(), str).l0(io.reactivex.d0.b.a.a()).N(new j() { // from class: com.tplink.iot.viewmodel.ipcamera.play.t2
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return VodViewModel.this.n(i, (Drawable) obj);
                }
            }).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.s2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    VodViewModel.this.p((Long) obj);
                }
            }));
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void relayPreviewTimeLimit(int i) {
        this.f10587c.x.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(getApplication().getString(R.string.playback_page_relay_timeout_without_operation, new Object[]{Integer.valueOf(VodMediaAPI.getSingleDeviceTimeoutSeconds() / 60)})));
        VodMediaAPI.releaseStream(this.f10589f);
        VodMediaAPI.clearPlayerCache(this.f10589f);
        this.R3.set(false);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void retryResolutions(BitStreamType bitStreamType) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void showLoadingView() {
        if (!this.f10587c.q.get()) {
            this.f10587c.l.set(true);
            this.f10587c.m.set(false);
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void startHoldToTalk() {
        this.f10587c.h.set(true);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void stopHoldToTalk() {
        this.f10587c.n();
    }

    public void u() {
        VodMediaAPI.snapshot(this.f10589f);
    }

    public void v() {
        VodMediaAPI.addSteamDisplayCommonCallback(this.f10589f, this);
        VodMediaAPI.setStreamControlNotificationCallback(this.f10589f, this);
    }

    public void w(PlaybackMainViewModel playbackMainViewModel, PlayBackControlViewModel playBackControlViewModel) {
        this.f10587c = playbackMainViewModel;
        playbackMainViewModel.m.set(false);
        this.f10589f = this.f10587c.f10555e;
        this.f10588d = playBackControlViewModel;
    }

    public void z() {
        if (this.N3.get()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.P3 = currentTimeMillis;
            if (currentTimeMillis - this.Q3 >= 1500) {
                y();
            }
        } else if (!b.d.q.b.p.b.r()) {
            this.f10587c.y(getApplication().getString(R.string.live_video_record_insufficient_space));
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.Q3 = currentTimeMillis2;
            if (currentTimeMillis2 - this.P3 >= 1500) {
                x();
            }
        }
    }
}
