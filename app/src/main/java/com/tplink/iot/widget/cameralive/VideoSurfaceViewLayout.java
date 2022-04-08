package com.tplink.iot.widget.cameralive;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableLong;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import b.d.q.b.l;
import b.d.q.b.m;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.x0.e;
import com.tplink.iot.core.n;
import com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.widget.cameralive.VideoSurfaceViewLayout;
import com.tplink.libmediaapi.common.apicallback.SimpleStreamNotificationCallback;
import com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpmediaother.database.model.c;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LensMaskRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import com.tplink.libtpvideorender.view.GLSurfaceViewGPU;
import io.reactivex.g0.g;
import io.reactivex.m0.d;
import io.reactivex.q;
import io.reactivex.t;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes3.dex */
public class VideoSurfaceViewLayout extends FrameLayout implements StreamDisplayCommonCallback, LifecycleObserver {
    private final ObservableBoolean H3;
    private final ObservableBoolean I3;
    private final ObservableBoolean J3;
    private final ObservableBoolean K3;
    private final ObservableBoolean L3;
    private final ObservableBoolean M3;
    private final ObservableField<String> N3;
    private final ObservableBoolean O3;
    private final ObservableField<String> P3;
    private d<Integer> Q3;
    private Observable.OnPropertyChangedCallback R3;
    LensMaskRepository S3;
    MediatorLiveData<Boolean> T3;
    CommonCameraRepository U3;
    private long V3;
    private long W3;
    private int X3;
    private boolean Y3;
    private boolean Z3;
    private GLSurfaceViewGPU a4;
    private String b4;

    /* renamed from: c  reason: collision with root package name */
    private String f11662c;

    /* renamed from: d  reason: collision with root package name */
    public ALCameraDevice f11663d;

    /* renamed from: f  reason: collision with root package name */
    boolean f11664f;
    private ViewVideoSurfaceLayoutBinding p0;
    private LifecycleOwner p1;
    public final ObservableBoolean p2;
    public final ObservableBoolean p3;
    boolean q;
    boolean x;
    private io.reactivex.e0.b y;
    private int z;

    /* loaded from: classes3.dex */
    class a extends Observable.OnPropertyChangedCallback {
        a() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            VideoSurfaceViewLayout.this.N3.set(m.a(((ObservableLong) observable).get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends SimpleStreamNotificationCallback {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(View view) {
            ((Activity) VideoSurfaceViewLayout.this.getContext()).finish();
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamNotificationCallback, com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback
        public void onReceiveDeviceLockedInfo(String str, DeviceLockedInfo deviceLockedInfo) {
            VideoSurfaceViewLayout.this.a0();
            if (VideoSurfaceViewLayout.this.getContext() instanceof Activity) {
                u.g((Activity) VideoSurfaceViewLayout.this.getContext(), deviceLockedInfo.getEventMessage(), new TPMaterialDialogV2.d() { // from class: com.tplink.iot.widget.cameralive.b
                    @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
                    public final void onClick(View view) {
                        VideoSurfaceViewLayout.b.this.b(view);
                    }
                });
            }
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamNotificationCallback, com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback
        public void onReceiveLensMaskInfo(String str, boolean z) {
            VideoSurfaceViewLayout.this.i0(z);
            if (!j.b(VideoSurfaceViewLayout.this.S3.x(), Boolean.valueOf(z))) {
                VideoSurfaceViewLayout.this.S3.x().postValue(Boolean.valueOf(z));
            }
        }
    }

    public VideoSurfaceViewLayout(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C(View view) {
        h0(false);
        e.u(this.f11662c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E(Context context, View view) {
        if (i()) {
            Toast.makeText(context, (int) R.string.camera_share_tip_no_permission, 0).show();
            return;
        }
        this.I3.set(false);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void G(Context context, View view) {
        ALCameraDevice aLCameraDevice = this.f11663d;
        if (aLCameraDevice != null) {
            u.f((Activity) context, aLCameraDevice.getLockMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void I(BitStreamType bitStreamType) {
        double d2 = (this.W3 - this.V3) / 1000.0d;
        int connectType = LiveMediaAPI.getConnectType(this.f11662c);
        if (connectType == -1) {
            connectType = this.X3;
        }
        ALCameraDevice aLCameraDevice = this.f11663d;
        e.m(this.f11662c, d2, bitStreamType, com.tplink.iot.Utils.m.a(connectType), this.H3.get(), this.M3.get(), (aLCameraDevice == null || aLCameraDevice.getCameraComponent() == null || !this.f11663d.getCameraComponent().isSupportVideoQuality() || TextUtils.isEmpty(this.P3.get())) ? "" : this.P3.get());
        this.V3 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ boolean K(View view) {
        performLongClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void M(View view) {
        performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void O(BitStreamType bitStreamType) {
        LiveMediaAPI.startLiveStreamDisplay(this.f11662c, getContext(), bitStreamType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void Q(Boolean bool) {
        if (org.apache.commons.lang.b.b(bool)) {
            i0(bool.booleanValue());
            return;
        }
        this.I3.set(false);
        b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public /* synthetic */ void S(Long l) throws Exception {
        this.p2.set(false);
        this.p3.set(false);
        this.f11664f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public /* synthetic */ void U(Long l) throws Exception {
        this.p2.set(false);
        this.p3.set(true);
        this.f11664f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public /* synthetic */ void W(c cVar) {
        this.b4 = cVar.i();
    }

    private void Z() {
        if (this.V3 != 0) {
            b.d.d.e.a.a(this.f11662c, new b.d.p.e.b() { // from class: com.tplink.iot.widget.cameralive.r
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    VideoSurfaceViewLayout.this.I((BitStreamType) obj);
                }
            });
        }
    }

    private void d() {
        String str = this.f11662c;
        this.f11663d = str == null ? null : TPIoTClientManager.K1(str).getCameraDevice();
        e();
        f();
    }

    private void d0(@StringRes int i) {
        TSnackbar.x((Activity) getContext(), i, -1).N();
    }

    private void f() {
        ALCameraDevice aLCameraDevice = this.f11663d;
        if (aLCameraDevice != null) {
            this.O3.set(aLCameraDevice.isCameraLocked());
        }
    }

    private void f0(Context context) {
        if (context instanceof LifecycleOwner) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) context;
            this.p1 = lifecycleOwner;
            lifecycleOwner.getLifecycle().addObserver(this);
            this.T3.observe(this.p1, new Observer() { // from class: com.tplink.iot.widget.cameralive.v
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    VideoSurfaceViewLayout.this.Q((Boolean) obj);
                }
            });
        }
    }

    private void g() {
        d<Integer> dVar = this.Q3;
        if (dVar != null) {
            this.y.b(dVar.l0(io.reactivex.d0.b.a.a()).H0(new g() { // from class: com.tplink.iot.widget.cameralive.q
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    VideoSurfaceViewLayout.this.r((Integer) obj);
                }
            }, o.f11677c));
        }
    }

    private void g0() {
        b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "switchCameraLockedErrorStatus");
        this.y.b(q.W0(this.p2.get() ? 1L : 0L, TimeUnit.SECONDS).G0(new g() { // from class: com.tplink.iot.widget.cameralive.d
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VideoSurfaceViewLayout.this.S((Long) obj);
            }
        }));
        this.W3 = System.currentTimeMillis();
        Z();
    }

    private String getLogPrefix() {
        return "ItemPosition: " + this.z + ",DeviceIdMD5: " + this.f11662c + SSLClient.WHITE_SPACE;
    }

    private void h0(boolean z) {
        b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "switchErrorStatus: " + z);
        if (z) {
            this.y.b(q.W0(this.p2.get() ? 1L : 0L, TimeUnit.SECONDS).G0(new g() { // from class: com.tplink.iot.widget.cameralive.m
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    VideoSurfaceViewLayout.this.U((Long) obj);
                }
            }));
            b.d.w.c.a.e("VideoSurfaceViewLayout", Log.getStackTraceString(new RuntimeException("switchErrorStatus")));
            this.W3 = System.currentTimeMillis();
            Z();
            return;
        }
        this.p2.set(true);
        this.p3.set(false);
        b0();
    }

    private boolean i() {
        String str = this.f11662c;
        ALCameraDevice cameraDevice = str == null ? null : TPIoTClientManager.K1(str).getCameraDevice();
        return cameraDevice != null && cameraDevice.isUserRoleTypeDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(boolean z) {
        if (this.I3.get() != z) {
            b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "switchLensMaskStatus: " + z);
            this.I3.set(z);
            if (z) {
                a0();
            } else {
                this.p2.set(true);
                this.p3.set(false);
                b0();
            }
            if (this.S3 == null) {
                e();
                if (this.S3 == null) {
                    return;
                }
            }
            final String uri = Uri.parse("android.resource://" + n.a().a() + MqttTopic.TOPIC_LEVEL_SEPARATOR + R.mipmap.preview_privacy_mode_on).toString();
            l.e(this.f11662c, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.widget.cameralive.l
                @Override // com.tplink.libtpnetwork.Utils.f0.b
                public final void a(Object obj) {
                    VideoSurfaceViewLayout.this.W((c) obj);
                }
            });
            if (z) {
                l.r(this.f11662c, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.widget.cameralive.e
                    @Override // com.tplink.libtpnetwork.Utils.f0.b
                    public final void a(Object obj) {
                        ((c) obj).t(uri);
                    }
                });
            } else if (uri.equals(this.b4)) {
                l.r(this.f11662c, w.a);
            }
            if (!j.b(this.S3.x(), Boolean.valueOf(z))) {
                this.S3.x().postValue(Boolean.valueOf(z));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ t k(CameraComponent cameraComponent) throws Exception {
        if (cameraComponent.getComponent(ComponentType.LEN_MASK) == 2) {
            return this.S3.t(Boolean.FALSE);
        }
        return this.S3.u(Boolean.FALSE);
    }

    private void j0(boolean z) {
        if (this.p3.get() || this.p2.get() != z) {
            this.p3.set(false);
            this.p2.set(z);
            b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "switchLoadingStatus: " + z);
            if (!z) {
                if (this.p1.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                    LiveMediaAPI.muteVolume(this.f11662c, !this.q);
                }
                LiveMediaAPI.stopKeepDoubleTalk(this.f11662c);
                this.p0.executePendingBindings();
                this.V3 = System.currentTimeMillis();
                this.X3 = LiveMediaAPI.getConnectType(this.f11662c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(Boolean bool) throws Exception {
        b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(Throwable th) throws Exception {
        i0(true);
        b.d.w.c.a.e("VideoSurfaceViewLayout", getLogPrefix() + Log.getStackTraceString(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void r(Integer num) throws Exception {
        if (num.equals(-1)) {
            h0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void s(Throwable th) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ boolean u(View view) {
        performLongClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w(View view) {
        performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(View view) {
        h0(false);
        e.u(this.f11662c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(View view) {
        h0(false);
        e.u(this.f11662c);
    }

    public void a0() {
        if (!TextUtils.isEmpty(this.f11662c)) {
            LiveMediaAPI.stopRecord(this.f11662c);
            LiveMediaAPI.removeSteamDisplayCommonCallback(this.f11662c, this);
            ObservableLong recordDuration = LiveMediaAPI.getRecordDuration(this.f11662c);
            if (recordDuration != null) {
                recordDuration.removeOnPropertyChangedCallback(this.R3);
            }
            this.p0.r(null);
            this.f11664f = false;
            b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "pause play");
            LiveMediaAPI.stopNetworkStatics(this.f11662c);
            LiveMediaAPI.stopDisplay(this.f11662c);
            this.W3 = System.currentTimeMillis();
            Z();
        }
    }

    public void b0() {
        if (!this.f11664f && !TextUtils.isEmpty(this.f11662c)) {
            b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "play");
            this.f11664f = true;
            b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "registerStreamDisplayCallback");
            LiveMediaAPI.addSteamDisplayCommonCallback(this.f11662c, 0, this);
            ObservableLong recordDuration = LiveMediaAPI.getRecordDuration(this.f11662c);
            if (recordDuration != null) {
                recordDuration.addOnPropertyChangedCallback(this.R3);
            }
            this.p0.r(LiveMediaAPI.isRecordingObservable(this.f11662c));
            LiveMediaAPI.setStreamControlNotificationCallback(this.f11662c, new b());
            b.d.d.e.a.a(this.f11662c, new b.d.p.e.b() { // from class: com.tplink.iot.widget.cameralive.c
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    VideoSurfaceViewLayout.this.O((BitStreamType) obj);
                }
            });
        }
    }

    public void c() {
        this.y.b(this.U3.K0().N(new io.reactivex.g0.j() { // from class: com.tplink.iot.widget.cameralive.p
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return VideoSurfaceViewLayout.this.k((CameraComponent) obj);
            }
        }).l0(io.reactivex.d0.b.a.a()).H0(new g() { // from class: com.tplink.iot.widget.cameralive.s
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VideoSurfaceViewLayout.this.m((Boolean) obj);
            }
        }, new g() { // from class: com.tplink.iot.widget.cameralive.n
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VideoSurfaceViewLayout.this.o((Throwable) obj);
            }
        }));
    }

    public void c0() {
        this.L3.set(true);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void changeVideoBitStreamType(String str, BitStreamType bitStreamType, boolean z, int i) {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void displayDestroy() {
        b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "displayDestroy");
        this.f11664f = false;
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void displayNetworkSpeed(float f2) {
    }

    public void e() {
        if (this.f11662c != null) {
            LensMaskRepository lensMaskRepository = this.S3;
            if (lensMaskRepository != null) {
                this.T3.removeSource(lensMaskRepository.x());
            }
            LensMaskRepository lensMaskRepository2 = (LensMaskRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(TPIoTClientManager.K1(this.f11662c), LensMaskRepository.class);
            this.S3 = lensMaskRepository2;
            if (j.h(lensMaskRepository2.x())) {
                this.S3.x().setValue(null);
            }
            MediatorLiveData<Boolean> mediatorLiveData = this.T3;
            MutableLiveData<Boolean> x = this.S3.x();
            final MediatorLiveData<Boolean> mediatorLiveData2 = this.T3;
            mediatorLiveData2.getClass();
            mediatorLiveData.addSource(x, new Observer() { // from class: com.tplink.iot.widget.cameralive.x
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MediatorLiveData.this.setValue((Boolean) obj);
                }
            });
            this.U3 = (CommonCameraRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.b(TPIoTClientManager.K1(this.f11662c), CommonCameraRepository.class);
        }
    }

    public void e0() {
        if (!TextUtils.isEmpty(this.f11662c)) {
            a0();
            b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "stop play");
            LiveMediaAPI.stopDisplay(this.f11662c);
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void framePerSecond(String str, int i) {
    }

    void h(final Context context) {
        ViewVideoSurfaceLayoutBinding viewVideoSurfaceLayoutBinding = (ViewVideoSurfaceLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_video_surface_layout, this, true);
        this.p0 = viewVideoSurfaceLayoutBinding;
        viewVideoSurfaceLayoutBinding.p(this.H3);
        this.p0.o(this.I3);
        this.p0.m(this.p2);
        this.p0.n(this.p3);
        this.p0.h(this.K3);
        this.p0.q(this.L3);
        this.p0.s(this.J3);
        this.p0.u(this.N3);
        this.p0.l(this.M3);
        this.p0.t(Boolean.valueOf(o.h0().c("LIVE_ICON_VISIBLE", false)));
        this.p0.i(this.O3);
        this.p0.executePendingBindings();
        View.OnLongClickListener iVar = new View.OnLongClickListener() { // from class: com.tplink.iot.widget.cameralive.i
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return VideoSurfaceViewLayout.this.u(view);
            }
        };
        View.OnClickListener hVar = new View.OnClickListener() { // from class: com.tplink.iot.widget.cameralive.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoSurfaceViewLayout.this.w(view);
            }
        };
        this.p0.z.setOnLongClickListener(iVar);
        this.p0.z.setOnClickListener(hVar);
        this.p0.p3.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.widget.cameralive.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoSurfaceViewLayout.this.y(view);
            }
        });
        this.p0.H3.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.widget.cameralive.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoSurfaceViewLayout.this.A(view);
            }
        });
        this.p0.f7362f.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.widget.cameralive.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoSurfaceViewLayout.this.C(view);
            }
        });
        this.p0.f7362f.setOnLongClickListener(iVar);
        View.OnClickListener jVar = new View.OnClickListener() { // from class: com.tplink.iot.widget.cameralive.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoSurfaceViewLayout.this.E(context, view);
            }
        };
        View.OnClickListener tVar = new View.OnClickListener() { // from class: com.tplink.iot.widget.cameralive.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoSurfaceViewLayout.this.G(context, view);
            }
        };
        this.p0.p1.setOnClickListener(jVar);
        this.p0.p2.setOnClickListener(jVar);
        this.p0.x.setOnClickListener(tVar);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void hideLoadingView() {
        j0(false);
    }

    public void k0(boolean z) {
        this.K3.set(z);
        if (!z) {
            this.L3.set(false);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onActivityResume() {
        b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "onActivityResume");
        if (this.I3.get()) {
            i0(false);
            return;
        }
        j0(true);
        b0();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onActivityStop() {
        b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "onActivityPause");
        a0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "onAttachedToWindow");
        super.onAttachedToWindow();
        LifecycleOwner lifecycleOwner = this.p1;
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().addObserver(this);
        }
        this.I3.set(false);
        this.p3.set(false);
        d();
        g();
        String str = this.f11662c;
        if (str != null) {
            if (this.Y3) {
                this.Y3 = false;
            } else {
                e.d(str);
            }
        }
        b0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "onDetachedFromWindow");
        LifecycleOwner lifecycleOwner = this.p1;
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
        this.y.d();
        e0();
        if (this.a4 != null) {
            b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "surfaceViewGPU.release");
            this.a4.a(this.p0.q);
        }
        LensMaskRepository lensMaskRepository = this.S3;
        if (lensMaskRepository != null) {
            this.T3.removeSource(lensMaskRepository.x());
        }
        super.onDetachedFromWindow();
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void onRenderProgramAdd(String str, GLSurfaceViewGPU gLSurfaceViewGPU) {
        if (gLSurfaceViewGPU != null) {
            if (gLSurfaceViewGPU.getParent() instanceof ViewGroup) {
                ((ViewGroup) gLSurfaceViewGPU.getParent()).removeView(gLSurfaceViewGPU);
            }
            this.p0.q.removeAllViews();
            this.p0.q.addView(gLSurfaceViewGPU, 0);
            this.a4 = gLSurfaceViewGPU;
            View.OnLongClickListener uVar = new View.OnLongClickListener() { // from class: com.tplink.iot.widget.cameralive.u
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return VideoSurfaceViewLayout.this.K(view);
                }
            };
            gLSurfaceViewGPU.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.widget.cameralive.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoSurfaceViewLayout.this.M(view);
                }
            });
            this.a4.setOnLongClickListener(uVar);
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void onSnapshotComplete(String str) {
        b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "onSnapshotComplete");
        if (this.f11664f && b.d.q.b.p.b.e(str)) {
            d0(R.string.video_capture_saved);
            b.d.q.b.p.b.u(this.f11663d, String.valueOf(System.currentTimeMillis()), str, -1);
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void onStreamFinish() {
        a0();
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void playFatalException(Exception exc) {
        b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "playFatalException:" + Log.getStackTraceString(exc));
        if (!(exc instanceof CameraException) || ((CameraException) exc).getErrorCode() != -52405) {
            this.p0.H3.setText(getContext().getString(R.string.live_display_error_hint));
        } else {
            this.p0.H3.setText(getContext().getString(R.string.camera_too_many_user_tip));
            if (!this.Z3) {
                e.B(this.f11662c);
                this.Z3 = true;
            }
        }
        if (this.O3.get()) {
            g0();
        } else {
            h0(true);
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
        this.N3.set(m.a(0L));
        d0(R.string.video_play_recording);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordStop() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void recordSuccess(int i, String str) {
        if (i <= 0 || !b.d.q.b.p.b.e(str)) {
            d0(R.string.record_error_video_damaged);
        } else {
            d0(R.string.video_recording_saved);
        }
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void relayPreviewTimeLimit(int i) {
        b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "relayPreviewTimeLimit");
        a0();
        h0(true);
        this.Q3.onNext(Integer.valueOf(i));
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void retryResolutions(BitStreamType bitStreamType) {
    }

    public void setDeviceIdMD5(String str) {
        this.f11662c = str;
    }

    public void setFullScreen(boolean z) {
        this.M3.set(z);
    }

    public void setIsFocused(boolean z) {
        if (this.q != z) {
            this.q = z;
            if (this.f11662c != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(getLogPrefix());
                sb.append(z ? "get" : "lose");
                sb.append(" focus");
                b.d.w.c.a.c("VideoSurfaceViewLayout", sb.toString());
                if (!z) {
                    LiveMediaAPI.destroyDoubleTalkClient(this.f11662c);
                    LiveMediaAPI.stopRecord(this.f11662c);
                }
                if (LiveMediaAPI.isPlayingProperly(this.f11662c)) {
                    LiveMediaAPI.muteVolume(this.f11662c, !z);
                }
            }
        }
    }

    public void setIsHQ(boolean z) {
        this.x = z;
    }

    public void setItemPosition(int i) {
        b.d.w.c.a.c("VideoSurfaceViewLayout", getLogPrefix() + "new position:" + i);
        this.z = i;
    }

    public void setMultiScreen(boolean z) {
        this.H3.set(z);
    }

    public void setRelayEventSubject(d<Integer> dVar) {
        this.Q3 = dVar;
    }

    public void setVideoResolution(String str) {
        this.P3.set(str);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void showLoadingView() {
        j0(true);
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void startHoldToTalk() {
    }

    @Override // com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
    public void stopHoldToTalk() {
    }

    public VideoSurfaceViewLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11664f = false;
        this.q = false;
        this.x = false;
        this.y = new io.reactivex.e0.b();
        this.p2 = new ObservableBoolean(false);
        this.p3 = new ObservableBoolean(false);
        this.H3 = new ObservableBoolean();
        this.I3 = new ObservableBoolean(false);
        this.J3 = new ObservableBoolean(false);
        this.K3 = new ObservableBoolean(false);
        this.L3 = new ObservableBoolean(false);
        this.M3 = new ObservableBoolean(false);
        this.N3 = new ObservableField<>("");
        this.O3 = new ObservableBoolean(false);
        this.P3 = new ObservableField<>("");
        this.R3 = new a();
        this.T3 = new MediatorLiveData<>();
        this.V3 = 0L;
        this.W3 = 0L;
        this.X3 = -1;
        this.Y3 = true;
        this.Z3 = false;
        h(context);
        f0(context);
    }

    public VideoSurfaceViewLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11664f = false;
        this.q = false;
        this.x = false;
        this.y = new io.reactivex.e0.b();
        this.p2 = new ObservableBoolean(false);
        this.p3 = new ObservableBoolean(false);
        this.H3 = new ObservableBoolean();
        this.I3 = new ObservableBoolean(false);
        this.J3 = new ObservableBoolean(false);
        this.K3 = new ObservableBoolean(false);
        this.L3 = new ObservableBoolean(false);
        this.M3 = new ObservableBoolean(false);
        this.N3 = new ObservableField<>("");
        this.O3 = new ObservableBoolean(false);
        this.P3 = new ObservableField<>("");
        this.R3 = new a();
        this.T3 = new MediatorLiveData<>();
        this.V3 = 0L;
        this.W3 = 0L;
        this.X3 = -1;
        this.Y3 = true;
        this.Z3 = false;
        h(context);
        f0(context);
    }
}
