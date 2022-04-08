package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableLong;
import androidx.lifecycle.AndroidViewModel;
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
import com.tplink.iot.Utils.e0;
import com.tplink.iot.Utils.y0.e;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpmediaother.database.model.c;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.Utils.f0.a;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LiveVideoRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.NightVisionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.NightMode;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.g0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class MultiLiveVideoViewModel extends AndroidViewModel implements LifecycleObserver {

    /* renamed from: c  reason: collision with root package name */
    private static final String f10545c = "MultiLiveVideoViewModel";
    private io.reactivex.e0.c K3;
    private MutableLiveData<Boolean> M3;
    private io.reactivex.e0.c S3;
    private io.reactivex.e0.c V3;
    private NightVisionRepository W3;
    private io.reactivex.e0.c o4;
    @Nullable
    private String q;
    private VideoPlayViewModel q4;
    private LiveVideoRepository r4;

    /* renamed from: d  reason: collision with root package name */
    private final String f10546d = "multi_live_debut";

    /* renamed from: f  reason: collision with root package name */
    private boolean f10547f = false;
    public int x = 1;
    public MutableLiveData<Integer> y = new MutableLiveData<>();
    public final ArrayList<String> z = new ArrayList<>(32);
    public final ObservableBoolean p0 = new ObservableBoolean(false);
    public final MutableLiveData<Boolean> p1 = new MutableLiveData<>();
    private final MediatorLiveData<Boolean> p2 = new MediatorLiveData<>();
    public int p3 = 0;
    private int H3 = 0;
    public final ObservableBoolean I3 = new ObservableBoolean(false);
    public final ObservableBoolean J3 = new ObservableBoolean(false);
    public final ObservableBoolean N3 = new ObservableBoolean(true);
    public final ObservableBoolean O3 = new ObservableBoolean(false);
    public final ObservableBoolean P3 = new ObservableBoolean(false);
    public ObservableBoolean Q3 = new ObservableBoolean(false);
    private MediatorLiveData<NightMode> R3 = new MediatorLiveData<>();
    private NightMode T3 = NightMode.AUTO;
    public final ObservableBoolean U3 = new ObservableBoolean(false);
    public final ObservableBoolean X3 = new ObservableBoolean(false);
    public final ObservableBoolean Y3 = new ObservableBoolean(false);
    public final MutableLiveData<String> Z3 = new MutableLiveData<>();
    public final ObservableBoolean a4 = new ObservableBoolean(false);
    private BitStreamType b4 = BitStreamType.MINOR_VGA;
    private Map<String, Integer> c4 = new HashMap();
    private boolean d4 = o.h0().c("VideoQualityTip", false);
    public final ObservableBoolean e4 = new ObservableBoolean(false);
    public final ObservableField<String> f4 = new ObservableField<>();
    private Observable.OnPropertyChangedCallback g4 = new a();
    private long h4 = 0;
    private long i4 = 0;
    public final ObservableBoolean j4 = new ObservableBoolean(true);
    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> k4 = new MutableLiveData<>();
    public MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Bitmap>> l4 = new MutableLiveData<>();
    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> m4 = new MutableLiveData<>();
    private io.reactivex.e0.b n4 = new io.reactivex.e0.b();
    private Observer<Boolean> p4 = i0.a;
    private SimpleStreamDisplayCallback s4 = new b();
    private boolean L3 = o.h0().c("multi_live_debut", true);

    /* loaded from: classes3.dex */
    class a extends Observable.OnPropertyChangedCallback {
        a() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            MultiLiveVideoViewModel.this.f4.set(m.a(((ObservableLong) observable).get()));
        }
    }

    /* loaded from: classes3.dex */
    class b extends SimpleStreamDisplayCallback {

        /* loaded from: classes3.dex */
        class a implements e0.f {
            a() {
            }

            @Override // com.tplink.iot.Utils.e0.f
            public void a(View view) {
            }

            @Override // com.tplink.iot.Utils.e0.f
            public void b(View view) {
                MultiLiveVideoViewModel.this.z0(BitStreamType.MINOR_VGA);
            }
        }

        b() {
        }

        private void a(boolean z) {
            MultiLiveVideoViewModel.this.q4.D.set(z);
            if (!z) {
                MultiLiveVideoViewModel.this.q4.y("VideoPlay.VideoControlPanelFragment");
                MultiLiveVideoViewModel.this.a4.set(false);
                MultiLiveVideoViewModel.this.Q3.set(false);
                MultiLiveVideoViewModel.this.m4.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void c(Long l) throws Exception {
            Integer num = (Integer) MultiLiveVideoViewModel.this.c4.put(MultiLiveVideoViewModel.this.q, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void e(BitStreamType bitStreamType) {
            MultiLiveVideoViewModel.this.G0(bitStreamType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public /* synthetic */ void g(Bitmap bitmap) throws Exception {
            MultiLiveVideoViewModel.this.l4.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(bitmap));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h */
        public /* synthetic */ Boolean i(Bitmap bitmap) throws Exception {
            MultiLiveVideoViewModel.this.l4.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(bitmap));
            return Boolean.TRUE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: j */
        public /* synthetic */ void k(Long l) throws Exception {
            LiveMediaAPI.muteVolume(MultiLiveVideoViewModel.this.q, false);
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void changeVideoBitStreamType(String str, BitStreamType bitStreamType, boolean z, int i) {
            String str2 = MultiLiveVideoViewModel.f10545c;
            b.d.w.c.a.c(str2, "changeVideoBitStreamType " + str + " result " + z + " errorCode " + i);
            if (!z || !str.equals(MultiLiveVideoViewModel.this.q)) {
                if (!z) {
                    MultiLiveVideoViewModel.this.l0(R.string.general_failed);
                    b.d.d.e.a.a(str, new b.d.p.e.b() { // from class: com.tplink.iot.viewmodel.ipcamera.play.j0
                        @Override // b.d.p.e.b
                        public final void a(Object obj) {
                            MultiLiveVideoViewModel.b.this.e((BitStreamType) obj);
                        }
                    });
                }
            } else if (BitStreamType.MAIN_HD.equals(bitStreamType)) {
                MultiLiveVideoViewModel.this.c4.put(MultiLiveVideoViewModel.this.q, 0);
                MultiLiveVideoViewModel.this.q4.i.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
            } else if (BitStreamType.MINOR_VGA.equals(bitStreamType)) {
                MultiLiveVideoViewModel.this.n4.b(q.W0(5L, TimeUnit.SECONDS).E(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.n0
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        MultiLiveVideoViewModel.b.this.c((Long) obj);
                    }
                }).F0());
            }
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void framePerSecond(String str, int i) {
            if (LiveMediaAPI.isPlayingProperly(MultiLiveVideoViewModel.this.q)) {
                if (j.h(MultiLiveVideoViewModel.this.M3)) {
                    b.d.w.c.a.c(MultiLiveVideoViewModel.f10545c, "lens mask altering");
                } else if (i < 5 && str.equals(MultiLiveVideoViewModel.this.q)) {
                    Integer num = (Integer) MultiLiveVideoViewModel.this.c4.get(MultiLiveVideoViewModel.this.q);
                    if (num == null) {
                        num = -1;
                    }
                    if (num.intValue() == 0) {
                        MultiLiveVideoViewModel.this.q4.h.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(e0.d().a(MultiLiveVideoViewModel.this.getApplication(), R.string.live_video_network_unstable_suggest, MultiLiveVideoViewModel.this.getApplication().getString(R.string.onBoarding_change), "sans-serif-medium", true, ContextCompat.getColor(MultiLiveVideoViewModel.this.getApplication(), R.color.color_3742FA), ContextCompat.getColor(MultiLiveVideoViewModel.this.getApplication(), R.color.gradient_color_lighter_blue), new a())));
                    } else if (num.intValue() == 1 && LiveMediaAPI.isPlayingProperly(MultiLiveVideoViewModel.this.q)) {
                        MultiLiveVideoViewModel.this.q4.h.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(new SpannableString(MultiLiveVideoViewModel.this.getApplication().getString(R.string.live_video_network_is_unstable))));
                        MultiLiveVideoViewModel.this.c4.put(MultiLiveVideoViewModel.this.q, 2);
                    }
                }
            }
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void hideLoadingView() {
            if (!MultiLiveVideoViewModel.this.d4) {
                MultiLiveVideoViewModel.this.d4 = true;
                o.h0().h("VideoQualityTip", true);
                MultiLiveVideoViewModel.this.q4.f10584f.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(MultiLiveVideoViewModel.this.getApplication().getString(R.string.live_video_change_resolutions_tips)));
            }
            a(true);
            MultiLiveVideoViewModel.this.q4.E.set(true);
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void onSnapshotComplete(String str) {
            super.onSnapshotComplete(str);
            MultiLiveVideoViewModel.this.n4.b(e.a(MultiLiveVideoViewModel.this.getApplication(), str).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.m0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    MultiLiveVideoViewModel.b.this.g((Bitmap) obj);
                }
            }));
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void playFatalException(Exception exc) {
            if (MultiLiveVideoViewModel.this.q4.p != null) {
                MultiLiveVideoViewModel.this.p1.setValue(Boolean.FALSE);
            }
            a(false);
            MultiLiveVideoViewModel.this.q4.E.set(false);
            if ((exc instanceof CameraException) && ((CameraException) exc).getErrorCode() == -52405 && MultiLiveVideoViewModel.this.q != null) {
                String str = MultiLiveVideoViewModel.this.q;
                BitStreamType bitStreamType = BitStreamType.MINOR_VGA;
                b.d.d.e.a.c(str, bitStreamType);
                MultiLiveVideoViewModel.this.G0(bitStreamType);
            }
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void recordFailed(int i) {
            MultiLiveVideoViewModel.this.e4.set(false);
            MultiLiveVideoViewModel.this.f4.set("");
            switch (i) {
                case -3200004:
                case -3200003:
                    MultiLiveVideoViewModel.this.l0(R.string.live_video_record_insufficient_space_saved);
                    return;
                case -3200002:
                    MultiLiveVideoViewModel.this.l0(R.string.live_video_record_insufficient_space);
                    return;
                case -3200001:
                    MultiLiveVideoViewModel.this.l0(R.string.live_video_record_too_short);
                    return;
                default:
                    MultiLiveVideoViewModel.this.l0(R.string.record_error_video_damaged);
                    return;
            }
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void recordStop() {
            MultiLiveVideoViewModel multiLiveVideoViewModel = MultiLiveVideoViewModel.this;
            multiLiveVideoViewModel.q0(multiLiveVideoViewModel.q);
            MultiLiveVideoViewModel.this.e4.set(false);
            MultiLiveVideoViewModel.this.f4.set("");
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void recordSuccess(int i, String str) {
            MultiLiveVideoViewModel.this.e4.set(false);
            MultiLiveVideoViewModel.this.f4.set("");
            MultiLiveVideoViewModel.this.n4.b(e.a(MultiLiveVideoViewModel.this.getApplication(), str).g0(new io.reactivex.g0.j() { // from class: com.tplink.iot.viewmodel.ipcamera.play.k0
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return MultiLiveVideoViewModel.b.this.i((Bitmap) obj);
                }
            }).F0());
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void relayPreviewTimeLimit(int i) {
            a(false);
            MultiLiveVideoViewModel.this.q4.E.set(false);
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void retryResolutions(BitStreamType bitStreamType) {
            MultiLiveVideoViewModel.this.G0(bitStreamType);
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void showLoadingView() {
            MultiLiveVideoViewModel.this.q4.D.set(false);
            MultiLiveVideoViewModel.this.q4.E.set(false);
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void startHoldToTalk() {
            if (MultiLiveVideoViewModel.this.o4 != null) {
                MultiLiveVideoViewModel.this.o4.dispose();
            }
            LiveMediaAPI.muteVolume(MultiLiveVideoViewModel.this.q, true);
        }

        @Override // com.tplink.libmediaapi.common.apicallback.SimpleStreamDisplayCallback, com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback
        public void stopHoldToTalk() {
            if (!MultiLiveVideoViewModel.this.h0()) {
                if (MultiLiveVideoViewModel.this.o4 != null) {
                    MultiLiveVideoViewModel.this.o4.dispose();
                }
                MultiLiveVideoViewModel.this.o4 = q.W0(1L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.l0
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        MultiLiveVideoViewModel.b.this.k((Long) obj);
                    }
                });
                MultiLiveVideoViewModel.this.n4.b(MultiLiveVideoViewModel.this.o4);
            }
        }
    }

    /* loaded from: classes3.dex */
    class c extends Observable.OnPropertyChangedCallback {
        c() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (!MultiLiveVideoViewModel.this.J3.get()) {
                MultiLiveVideoViewModel.this.j0(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    class d extends Observable.OnPropertyChangedCallback {
        d() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            MultiLiveVideoViewModel.this.x(((ObservableBoolean) observable).get());
        }
    }

    public MultiLiveVideoViewModel(@NonNull Application application) {
        super(application);
    }

    private void A0() {
        if (LiveMediaAPI.isPlayingProperly(this.q)) {
            LiveMediaAPI.startRecord(this.q);
            this.e4.set(true);
            D0();
            this.f4.set(m.a(0L));
        }
    }

    private void B0() {
        LiveMediaAPI.stopRecord(this.q);
        q0(this.q);
    }

    private void D0() {
        String str = this.q;
        if (!(str != null && LiveMediaAPI.isRecording(str))) {
            this.f4.set(null);
            return;
        }
        ObservableLong recordDuration = LiveMediaAPI.getRecordDuration(this.q);
        if (recordDuration != null) {
            recordDuration.addOnPropertyChangedCallback(this.g4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public void a0(NightMode nightMode) {
        this.T3 = nightMode;
        if (NightMode.DAY == nightMode) {
            this.N3.set(false);
            this.P3.set(true);
            this.O3.set(false);
        } else if (NightMode.NIGHT == nightMode) {
            this.N3.set(false);
            this.P3.set(false);
            this.O3.set(true);
        } else {
            this.N3.set(true);
            this.P3.set(false);
            this.O3.set(false);
        }
    }

    private void G() {
        String str = this.q;
        if (str != null) {
            b.d.d.e.a.a(str, new b.d.p.e.b() { // from class: com.tplink.iot.viewmodel.ipcamera.play.y0
                @Override // b.d.p.e.b
                public final void a(Object obj) {
                    MultiLiveVideoViewModel.this.M((BitStreamType) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(BitStreamType bitStreamType) {
        this.b4 = bitStreamType;
        if (BitStreamType.MAIN_HD.equals(bitStreamType)) {
            this.X3.set(true);
            this.Y3.set(false);
            return;
        }
        this.Y3.set(true);
        this.X3.set(false);
    }

    private void H() {
        ObservableBoolean observableBoolean = this.e4;
        String str = this.q;
        observableBoolean.set(str != null && LiveMediaAPI.isRecording(str));
        ObservableField<String> observableField = this.f4;
        String str2 = this.q;
        observableField.set(str2 == null ? "" : m.a(LiveMediaAPI.getRecordDuration(str2).get()));
        D0();
    }

    private void I0() {
        if (this.q != null) {
            String str = f10545c;
            b.d.w.c.a.c(str, "deviceIdMD5: " + this.q + " unRegisterStreamDisplayCallback");
            LiveMediaAPI.removeSteamDisplayCommonCallback(this.q, this.s4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void K(Boolean bool) throws Exception {
        b.d.w.c.a.c(f10545c, "Trigger latent func timeout");
        this.J3.set(false);
        this.Q3.set(false);
        this.a4.set(false);
        this.m4.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void M(BitStreamType bitStreamType) {
        this.b4 = bitStreamType;
        if (BitStreamType.MAIN_HD.equals(bitStreamType)) {
            this.c4.put(this.q, 0);
            this.q4.i.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
        }
        G0(this.b4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void O(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void P(Boolean bool) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public /* synthetic */ void R(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            this.Z3.setValue(this.r4.t());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S */
    public /* synthetic */ t T(CameraComponent cameraComponent) throws Exception {
        if (!cameraComponent.isSupportNightVision()) {
            return q.f0(Boolean.FALSE);
        }
        NightVisionRepository nightVisionRepository = (NightVisionRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.q, NightVisionRepository.class);
        this.W3 = nightVisionRepository;
        return nightVisionRepository.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U */
    public /* synthetic */ void V(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            this.U3.set(this.W3.x());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public /* synthetic */ void X(NightMode nightMode, Boolean bool) throws Exception {
        a0(nightMode);
        this.k4.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ void Z(Throwable th) throws Exception {
        this.k4.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.FALSE));
        l0(R.string.general_failed);
        b.d.w.c.a.e(f10545c, Log.getStackTraceString(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0(Integer num) {
        if (num != null) {
            String str = num.intValue() == -1 ? null : this.z.get(num.intValue());
            u0(str);
            if (str != null && this.H3 != num.intValue()) {
                this.p3 = this.H3;
                this.H3 = num.intValue();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public /* synthetic */ void g0(Boolean bool) throws Exception {
        this.U3.set(this.W3.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h0() {
        final com.tplink.libtpnetwork.Utils.f0.a aVar = new com.tplink.libtpnetwork.Utils.f0.a(Boolean.FALSE);
        l.e(this.q, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.play.w0
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                a.this.a = Boolean.valueOf((r2 == null || r2.c() == null) ? false : ((c) obj).c().booleanValue());
            }
        });
        return ((Boolean) aVar.a).booleanValue();
    }

    private void i0() {
        String str = this.q;
        if (str != null) {
            LiveVideoRepository liveVideoRepository = (LiveVideoRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(str, LiveVideoRepository.class);
            this.r4 = liveVideoRepository;
            MutableLiveData<NightMode> s = liveVideoRepository.s();
            this.R3.removeSource(s);
            final MediatorLiveData<NightMode> mediatorLiveData = this.R3;
            mediatorLiveData.getClass();
            mediatorLiveData.addSource(s, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.r1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MediatorLiveData.this.setValue((NightMode) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(@StringRes int i) {
        this.q4.u(getApplication().getString(i));
    }

    private void m0() {
        TPCameraDeviceContext K1;
        io.reactivex.e0.c cVar = this.S3;
        if (cVar != null && !cVar.isDisposed()) {
            this.S3.dispose();
        }
        String str = this.q;
        if (str != null && (K1 = TPIoTClientManager.K1(str)) != null && K1.getCameraDevice() != null) {
            i0();
            io.reactivex.e0.c G0 = this.r4.E().l0(io.reactivex.d0.b.a.a()).G0(v0.f10662c);
            this.S3 = G0;
            this.n4.b(G0);
            if (TextUtils.isEmpty(this.r4.t())) {
                this.n4.b(this.r4.F().E(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.p0
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        MultiLiveVideoViewModel.this.R((Boolean) obj);
                    }
                }).F0());
            } else {
                this.Z3.setValue(this.r4.t());
            }
        }
    }

    private void n0() {
        TPCameraDeviceContext K1;
        io.reactivex.e0.c cVar = this.V3;
        if (cVar != null && !cVar.isDisposed()) {
            this.V3.dispose();
        }
        String str = this.q;
        if (str != null && (K1 = TPIoTClientManager.K1(str)) != null && K1.getCameraDevice() != null) {
            this.V3 = ((CommonCameraRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.q, CommonCameraRepository.class)).K0().L0(io.reactivex.l0.a.c()).N(new io.reactivex.g0.j() { // from class: com.tplink.iot.viewmodel.ipcamera.play.z0
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return MultiLiveVideoViewModel.this.T((CameraComponent) obj);
                }
            }).E(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.s0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    MultiLiveVideoViewModel.this.V((Boolean) obj);
                }
            }).l0(io.reactivex.d0.b.a.a()).F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(String str) {
        ObservableLong recordDuration;
        if (str != null && (recordDuration = LiveMediaAPI.getRecordDuration(str)) != null) {
            recordDuration.removeOnPropertyChangedCallback(this.g4);
        }
    }

    private void r0(BitStreamType bitStreamType) {
        b.d.d.e.a.c(this.q, bitStreamType);
    }

    private void u0(String str) {
        if (!d0.a(this.q, str)) {
            boolean z = false;
            if (str == null) {
                this.I3.set(false);
            }
            if (this.q != null) {
                I0();
                q0(this.q);
            }
            this.q = str;
            this.q4.D.set(str != null && LiveMediaAPI.isPlayingProperly(str));
            ObservableBoolean observableBoolean = this.q4.E;
            if (str != null && LiveMediaAPI.isPlayingProperly(str)) {
                z = true;
            }
            observableBoolean.set(z);
            o0();
            this.q4.k.setValue(this.q);
            G();
            H();
            m0();
            n0();
        }
    }

    private void w0(final NightMode nightMode) {
        this.k4.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
        this.n4.b(this.r4.G(nightMode).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.r0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MultiLiveVideoViewModel.this.X(nightMode, (Boolean) obj);
            }
        }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.q0
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MultiLiveVideoViewModel.this.Z((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        if (this.q4.G.get()) {
            this.J3.set(z);
            io.reactivex.e0.c cVar = this.K3;
            if (cVar != null && !cVar.isDisposed()) {
                this.K3.dispose();
            }
            if (z) {
                B();
                return;
            }
            this.Q3.set(false);
            this.a4.set(false);
        }
    }

    public void A() {
        io.reactivex.e0.c cVar;
        VideoPlayViewModel videoPlayViewModel = this.q4;
        if (videoPlayViewModel != null && videoPlayViewModel.G.get() && (cVar = this.K3) != null && !cVar.isDisposed()) {
            this.K3.dispose();
            b.d.w.c.a.c(f10545c, "Disable latent func timer");
        }
    }

    public void B() {
        VideoPlayViewModel videoPlayViewModel = this.q4;
        if (videoPlayViewModel != null && videoPlayViewModel.G.get() && this.J3.get()) {
            io.reactivex.e0.c cVar = this.K3;
            if (cVar == null || cVar.isDisposed()) {
                b.d.w.c.a.c(f10545c, "Enable latent func timer");
                io.reactivex.e0.c G0 = q.f0(Boolean.FALSE).o(5L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.t0
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        MultiLiveVideoViewModel.this.K((Boolean) obj);
                    }
                });
                this.K3 = G0;
                this.n4.b(G0);
            }
        }
    }

    @Nullable
    public String C() {
        return this.q;
    }

    public void C0(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().addObserver(this);
        this.R3.observe(lifecycleOwner, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.u0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MultiLiveVideoViewModel.this.b0((NightMode) obj);
            }
        });
        this.y.observe(lifecycleOwner, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.h0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MultiLiveVideoViewModel.this.d0((Integer) obj);
            }
        });
        this.J3.addOnPropertyChangedCallback(new c());
        this.p2.removeObserver(this.p4);
        this.p2.observe(lifecycleOwner, this.p4);
        this.q4.G.addOnPropertyChangedCallback(new d());
    }

    public Rect D(int i, boolean z) {
        Rect rect = new Rect(0, 0, 0, 0);
        int i2 = i & 3;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3 && TextUtils.isEmpty(this.z.get(i))) {
                        if (TextUtils.isEmpty(this.z.get(i - 1))) {
                            rect.left = 1;
                        }
                        if (TextUtils.isEmpty(this.z.get(i - 2))) {
                            rect.top = 1;
                        }
                        if (z && i != 31) {
                            rect.right = 1;
                        }
                    }
                } else if (TextUtils.isEmpty(this.z.get(i))) {
                    if (TextUtils.isEmpty(this.z.get(i - 2))) {
                        rect.left = 1;
                    }
                    if (TextUtils.isEmpty(this.z.get(i + 1))) {
                        rect.bottom = 1;
                    }
                    if (z && i != 30) {
                        rect.right = 1;
                    }
                }
            } else if (TextUtils.isEmpty(this.z.get(i))) {
                if (TextUtils.isEmpty(this.z.get(i - 1))) {
                    rect.top = 1;
                }
                if (TextUtils.isEmpty(this.z.get(i + 2))) {
                    rect.right = 1;
                }
                if (z && i != 1) {
                    rect.left = 1;
                }
            }
        } else if (TextUtils.isEmpty(this.z.get(i))) {
            if (TextUtils.isEmpty(this.z.get(i + 1))) {
                rect.right = 1;
            }
            if (TextUtils.isEmpty(this.z.get(i + 2))) {
                rect.bottom = 1;
            }
            if (z && i != 0) {
                rect.left = 1;
            }
        }
        return rect;
    }

    public int E(int i) {
        int i2 = this.x;
        return i2 == 1 ? i : (i / i2) * i2;
    }

    public void E0() {
        int intValue = ((Integer) j.e(this.y, 0)).intValue();
        int i = intValue & 3;
        if (i > 0 && i < 3) {
            this.y.setValue(Integer.valueOf((intValue + 3) - (i << 1)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
        if (r10 != 3) goto L_0x002c;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void F(android.graphics.Rect[] r7, int r8, int r9, int r10) {
        /*
            r6 = this;
            int r10 = r10 % 4
            r0 = 0
            r1 = 2
            r2 = 3
            r3 = 1
            if (r10 == r3) goto L_0x001e
            if (r10 == r1) goto L_0x000d
            if (r10 == r2) goto L_0x000d
            goto L_0x002c
        L_0x000d:
            r4 = r7[r0]
            int r5 = r4.left
            int r5 = r5 - r8
            r4.left = r5
            r4 = r7[r0]
            int r5 = r4.right
            int r5 = r5 - r8
            r4.right = r5
            if (r10 == r2) goto L_0x001e
            goto L_0x002c
        L_0x001e:
            r10 = r7[r0]
            int r4 = r10.top
            int r4 = r4 - r9
            r10.top = r4
            r10 = r7[r0]
            int r4 = r10.bottom
            int r4 = r4 - r9
            r10.bottom = r4
        L_0x002c:
            android.graphics.Rect r10 = new android.graphics.Rect
            r4 = r7[r0]
            r10.<init>(r4)
            r7[r3] = r10
            r10 = r7[r3]
            r4 = r7[r3]
            int r4 = r4.top
            int r4 = r4 + r9
            r10.top = r4
            r10 = r7[r3]
            r4 = r7[r3]
            int r4 = r4.bottom
            int r4 = r4 + r9
            r10.bottom = r4
            android.graphics.Rect r9 = new android.graphics.Rect
            r10 = r7[r0]
            r9.<init>(r10)
            r7[r1] = r9
            r9 = r7[r1]
            r10 = r7[r1]
            int r10 = r10.left
            int r10 = r10 + r8
            r9.left = r10
            r9 = r7[r1]
            r10 = r7[r1]
            int r10 = r10.right
            int r10 = r10 + r8
            r9.right = r10
            android.graphics.Rect r9 = new android.graphics.Rect
            r10 = r7[r3]
            r9.<init>(r10)
            r7[r2] = r9
            r9 = r7[r2]
            r10 = r7[r2]
            int r10 = r10.left
            int r10 = r10 + r8
            r9.left = r10
            r9 = r7[r2]
            r7 = r7[r2]
            int r7 = r7.right
            int r7 = r7 + r8
            r9.right = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel.F(android.graphics.Rect[], int, int, int):void");
    }

    public void H0() {
        TPCameraDeviceContext K1;
        String str = this.q;
        if (str != null && (K1 = TPIoTClientManager.K1(str)) != null && K1.getCameraDevice() != null) {
            NightVisionRepository nightVisionRepository = (NightVisionRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(this.q, NightVisionRepository.class);
            this.W3 = nightVisionRepository;
            nightVisionRepository.y(!this.U3.get()).C(o0.f10637c).E(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.x0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    MultiLiveVideoViewModel.this.g0((Boolean) obj);
                }
            }).L0(io.reactivex.l0.a.c()).F0();
        }
    }

    public boolean I() {
        return TextUtils.isEmpty(this.q) || !LiveMediaAPI.isPlayingProperly(this.q);
    }

    public void J0(ArrayList<String> arrayList, ArrayList<String> arrayList2, int i) {
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            int indexOf = this.z.indexOf(it.next());
            if (indexOf >= 0) {
                this.z.set(indexOf, null);
            }
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            if (!this.z.contains(next)) {
                while (!TextUtils.isEmpty(this.z.get(i))) {
                    i++;
                    if (i >= 32) {
                        i = 0;
                    }
                }
                this.z.set(i, next);
                i++;
                if (i >= 32) {
                    i = 0;
                }
            }
        }
    }

    public void K0() {
        if (!this.e4.get()) {
            if (!b.d.q.b.p.b.r()) {
                l0(R.string.live_video_record_insufficient_space);
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.i4 = currentTimeMillis;
            if (currentTimeMillis - this.h4 >= 1500) {
                A0();
                return;
            }
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        this.h4 = currentTimeMillis2;
        if (currentTimeMillis2 - this.i4 >= 1500) {
            B0();
        }
    }

    public void j0(boolean z) {
        this.Q3.set(z);
        this.a4.set(false);
    }

    public void k0(boolean z) {
        this.a4.set(z);
        this.Q3.set(false);
    }

    public void o0() {
        if (this.q != null) {
            String str = f10545c;
            b.d.w.c.a.c(str, "deviceIdMD5: " + this.q + " registerStreamDisplayCallback");
            LiveMediaAPI.addSteamDisplayCommonCallback(this.q, this.s4);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onActivityStart() {
        o0();
        if (this.f10547f) {
            m0();
            n0();
        }
        this.f10547f = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onActivityStop() {
        io.reactivex.e0.c cVar = this.S3;
        if (cVar != null) {
            cVar.dispose();
        }
        io.reactivex.e0.c cVar2 = this.V3;
        if (cVar2 != null) {
            cVar2.dispose();
        }
        I0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.n4.d();
    }

    public void p0(MutableLiveData<Boolean> mutableLiveData) {
        this.p2.removeSource(mutableLiveData);
    }

    public void s0() {
        LiveMediaAPI.snapshot(this.q);
    }

    public void t0(ArrayList<String> arrayList) {
        this.z.clear();
        this.z.addAll(arrayList);
    }

    public void v(MutableLiveData<Boolean> mutableLiveData) {
        this.p2.removeSource(mutableLiveData);
        MediatorLiveData<Boolean> mediatorLiveData = this.p2;
        final MutableLiveData<Boolean> mutableLiveData2 = this.p1;
        mutableLiveData2.getClass();
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.v2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MutableLiveData.this.setValue((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v0(MutableLiveData<Boolean> mutableLiveData) {
        this.M3 = mutableLiveData;
    }

    public void w() {
        x(!this.J3.get());
    }

    public void x0(VideoPlayViewModel videoPlayViewModel) {
        this.q4 = videoPlayViewModel;
        u0(videoPlayViewModel.j);
    }

    public boolean y() {
        if (!this.L3) {
            return false;
        }
        o.h0().h("multi_live_debut", false);
        this.L3 = false;
        return true;
    }

    public void y0(NightMode nightMode) {
        if (!nightMode.equals(this.T3)) {
            w0(nightMode);
        }
    }

    public void z() {
        this.Q3.set(false);
        this.a4.set(false);
    }

    public void z0(BitStreamType bitStreamType) {
        if (!this.b4.equals(bitStreamType) && this.q != null) {
            if (this.e4.get()) {
                B0();
            }
            G0(bitStreamType);
            b.d.w.c.a.c("viewModel", "setupVideoQuality(),change device " + this.q + " resolution to " + bitStreamType);
            LiveMediaAPI.changePreviewResolutions(this.q, bitStreamType, null);
            r0(bitStreamType);
            this.c4.put(this.q, -1);
            this.q4.h();
        }
    }
}
