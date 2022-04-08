package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.q.b.l;
import com.tplink.iot.R;
import com.tplink.libmediaapi.vod.VodMediaAPI;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.f0.a;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CameraSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.b;

/* loaded from: classes3.dex */
public class PlaybackMainViewModel extends AndroidViewModel {
    private static final String a = "PlaybackMainViewModel";
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public ALCameraDevice f10554d;

    /* renamed from: e  reason: collision with root package name */
    public String f10555e;

    /* renamed from: f  reason: collision with root package name */
    public final MutableLiveData<String> f10556f;
    private CameraSettingRepository i;
    private boolean k;
    private c w;

    /* renamed from: b  reason: collision with root package name */
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> f10552b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> f10553c = new MutableLiveData<>();
    private io.reactivex.e0.b g = new io.reactivex.e0.b();
    public final ObservableBoolean h = new ObservableBoolean(false);
    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<b>> j = new MutableLiveData<>();
    public final ObservableBoolean l = new ObservableBoolean(false);
    public final ObservableBoolean m = new ObservableBoolean(false);
    public final ObservableBoolean n = new ObservableBoolean(false);
    public final ObservableBoolean o = new ObservableBoolean(false);
    public final ObservableField<VideoDisplayMode> p = new ObservableField<>(VideoDisplayMode.LIVE_STREAM);
    public final ObservableBoolean q = new ObservableBoolean(true);
    public final ObservableBoolean r = new ObservableBoolean(false);
    public final ObservableBoolean s = new ObservableBoolean(false);
    public final ObservableBoolean t = new ObservableBoolean(false);
    public final ObservableBoolean u = new ObservableBoolean(false);
    public final ObservableBoolean v = new ObservableBoolean(false);
    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> x = new MutableLiveData<>();
    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> y = new MutableLiveData<>();
    public final MutableLiveData<Integer> z = new MutableLiveData<>(null);

    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SdCardStatus.values().length];
            a = iArr;
            try {
                iArr[SdCardStatus.OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SdCardStatus.UNFORMATTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[SdCardStatus.FULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[SdCardStatus.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[SdCardStatus.INSUFFICIENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[SdCardStatus.FORMATTING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[SdCardStatus.ABNORMAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f10557b;

        public b(String str, boolean z) {
            this.a = str;
            this.f10557b = z;
        }
    }

    public PlaybackMainViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.f10556f = mutableLiveData;
        String deviceIdMD5 = tPCameraDeviceContext.getDeviceIdMD5();
        this.f10555e = deviceIdMD5;
        mutableLiveData.setValue(deviceIdMD5);
        this.f10554d = tPCameraDeviceContext.getCameraDevice();
        this.i = (CameraSettingRepository) e.c(this.f10555e, CameraSettingRepository.class);
    }

    private String k(@StringRes int i) {
        return getApplication().getResources().getString(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void r(Long l) throws Exception {
        this.v.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void u(boolean z, com.tplink.libtpmediaother.database.model.c cVar) {
        if (this.p.get() == VideoDisplayMode.PLAY_BACK) {
            cVar.o(Boolean.valueOf(z));
        } else {
            cVar.n(Boolean.valueOf(z));
        }
    }

    private boolean v() {
        final com.tplink.libtpnetwork.Utils.f0.a aVar = new com.tplink.libtpnetwork.Utils.f0.a(Boolean.FALSE);
        l.r(this.f10555e, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.play.q1
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                com.tplink.libtpmediaother.database.model.c cVar = (com.tplink.libtpmediaother.database.model.c) obj;
                a.this.a = Boolean.valueOf(r1 != null && b.b(r1.d()));
            }
        });
        return ((Boolean) aVar.a).booleanValue();
    }

    private void z(final boolean z, String str) {
        l.r(str, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.play.n1
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                PlaybackMainViewModel.this.u(z, (com.tplink.libtpmediaother.database.model.c) obj);
            }
        });
    }

    public void A(boolean z, String str) {
        this.h.set(z);
        VodMediaAPI.muteAudio(str, z);
        z(z, str);
    }

    public void B(VideoDisplayMode videoDisplayMode) {
        this.p.set(videoDisplayMode);
    }

    public void C(boolean z) {
        if (this.r.get() != z) {
            this.r.set(z);
        }
    }

    public void D(boolean z) {
        if (this.r.get() != z) {
            this.r.set(z);
            this.f10552b.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.valueOf(z)));
        }
    }

    public void E() {
        A(!this.h.get(), this.f10555e);
    }

    public void f() {
        c cVar = this.w;
        if (cVar != null && !cVar.isDisposed()) {
            this.w.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.k && this.m.get()) {
            this.j.setValue(null);
            this.k = false;
        }
    }

    public void h() {
        this.g.b(this.i.H().H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.z2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlaybackMainViewModel.this.m((SdCardStatus) obj);
            }
        }, o1.f10638c));
    }

    public void i() {
        c cVar = this.w;
        if (cVar != null && !cVar.isDisposed()) {
            this.w.dispose();
        }
        this.w = q.W0(5L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.p1
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PlaybackMainViewModel.this.r((Long) obj);
            }
        });
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> j() {
        return this.f10552b;
    }

    public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> l() {
        return this.f10553c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void m(SdCardStatus sdCardStatus) {
        if (sdCardStatus != null) {
            this.k = true;
            switch (a.a[sdCardStatus.ordinal()]) {
                case 1:
                    this.j.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(new b(k(R.string.playback_insert_sd_card), false)));
                    b.d.w.c.a.c(a, "需要插入SD卡才可以播放");
                    return;
                case 2:
                    this.j.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(new b(k(R.string.playback_initialize_sd_card), true)));
                    b.d.w.c.a.c(a, "需要格式化");
                    return;
                case 3:
                    if (!this.i.x().getSdCardInfoCache().getLoopEnable()) {
                        this.j.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(new b(k(R.string.playback_full_sd_card), true)));
                        b.d.w.c.a.c(a, "存储卡满了");
                        break;
                    }
                    break;
                case 4:
                case 5:
                    break;
                case 6:
                    this.j.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(new b(k(R.string.playback_initializing_sd_card), false)));
                    b.d.w.c.a.c(a, "格式化中");
                    return;
                default:
                    this.j.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(new b(k(R.string.playback_wrong_sd_card), true)));
                    b.d.w.c.a.c(a, "请重新插入SD卡或换一张SD卡");
                    return;
            }
            this.k = false;
        }
    }

    public void n() {
        A(v(), this.f10555e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.g.dispose();
        c cVar = this.w;
        if (cVar != null && !cVar.isDisposed()) {
            this.w.dispose();
        }
    }

    public void w() {
        c cVar = this.w;
        if (cVar != null && !cVar.isDisposed()) {
            this.w.dispose();
        }
        this.v.set(true);
    }

    public void x(boolean z) {
        this.r.set(z);
    }

    public void y(String str) {
        this.f10553c.postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(str));
    }
}
