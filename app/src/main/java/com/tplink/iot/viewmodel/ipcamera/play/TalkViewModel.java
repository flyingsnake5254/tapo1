package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.e;
import com.tplink.libmediaapi.common.apicallback.DoubleTalkStreamCallback;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.cameranetwork.business.repo.VolumeRepository;
import com.tplink.libtpnetwork.cameranetwork.model.AudioInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MicroPhoneInfo;
import com.tplink.libtpnetwork.cameranetwork.model.SpeakerInfo;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TalkViewModel extends AndroidViewModel {

    /* renamed from: b  reason: collision with root package name */
    private String f10569b;

    /* renamed from: c  reason: collision with root package name */
    private VolumeRepository f10570c;
    private Timer p;
    private long q;
    private long r;
    private String s;
    private io.reactivex.e0.c u;
    private io.reactivex.e0.c v;
    private String a = TalkViewModel.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private MediatorLiveData<AudioInfo> f10571d = new MediatorLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    public final ObservableInt f10572e = new ObservableInt(50);

    /* renamed from: f  reason: collision with root package name */
    public final ObservableInt f10573f = new ObservableInt(50);
    public final ObservableField<String> g = new ObservableField<>("00:00");
    public final ObservableBoolean h = new ObservableBoolean(false);
    public final ObservableBoolean i = new ObservableBoolean(false);
    public final ObservableBoolean j = new ObservableBoolean(false);
    public final ObservableBoolean k = new ObservableBoolean(false);
    public final ObservableBoolean l = new ObservableBoolean(false);
    public final ObservableBoolean m = new ObservableBoolean(false);
    public final ObservableField<String> n = new ObservableField<>();
    public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> o = new MutableLiveData<>();
    public final ObservableBoolean t = new ObservableBoolean(false);
    private final io.reactivex.e0.b w = new io.reactivex.e0.b();
    private DoubleTalkStreamCallback x = new b();

    /* loaded from: classes3.dex */
    class a extends Observable.OnPropertyChangedCallback {
        a() {
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (TalkViewModel.this.f10569b == null) {
                return;
            }
            if (TalkViewModel.this.f10572e.get() == 0) {
                if (LiveMediaAPI.lockLiveStreamAudio()) {
                    LiveMediaAPI.muteAudio(TalkViewModel.this.f10569b, true);
                }
            } else if (LiveMediaAPI.unlockLiveStreamAudio() && !TalkViewModel.this.i.get()) {
                LiveMediaAPI.muteAudio(TalkViewModel.this.f10569b, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements DoubleTalkStreamCallback {
        b() {
        }

        @Override // com.tplink.libmediaapi.common.apicallback.DoubleTalkStreamCallback
        public void onDoubleTalkClose(String str) {
            TalkViewModel.this.n(R.string.voice_call_unable_to_connect);
        }

        @Override // com.tplink.libmediaapi.common.apicallback.DoubleTalkStreamCallback
        public void onDoubleTalkCreateFailure(String str, int i) {
            TalkViewModel.this.n(1 == i ? R.string.voice_line_is_busy : R.string.voice_call_unable_to_connect);
        }

        @Override // com.tplink.libmediaapi.common.apicallback.DoubleTalkStreamCallback
        public void onDoubleTalkCreateSuccess(String str) {
            TalkViewModel.this.j.set(true);
            TalkViewModel.this.R(System.currentTimeMillis());
            if (TalkViewModel.this.m.get()) {
                TalkViewModel.this.T();
                TalkViewModel.this.W();
                if (TalkViewModel.this.i.get()) {
                    LiveMediaAPI.muteVolume(str, false);
                    TalkViewModel.this.i.set(false);
                }
            }
        }

        @Override // com.tplink.libmediaapi.common.apicallback.DoubleTalkStreamCallback
        public void onDoubleTalkSendDataFailure(String str, int i, Exception exc) {
            TalkViewModel.this.n(R.string.voice_call_unable_to_connect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            long currentTimeMillis = (System.currentTimeMillis() - TalkViewModel.this.q) / 1000;
            TalkViewModel.this.g.set(String.format(Locale.getDefault(), "%02d:%02d", Long.valueOf((currentTimeMillis / 60) % 60), Long.valueOf(currentTimeMillis % 60)));
        }
    }

    public TalkViewModel(@NonNull Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ void B(Throwable th) throws Exception {
        String str = this.a;
        b.d.w.c.a.c(str, "Save speaker " + th.toString());
        int x = this.f10570c.x();
        if (x != -1) {
            this.f10573f.set(x);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void D(Long l) throws Exception {
        this.j.set(false);
        this.k.set(false);
        this.o.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void F(AudioInfo audioInfo) {
        if (audioInfo != null) {
            try {
                SpeakerInfo speakerInfo = audioInfo.getSpeakerInfo();
                if (speakerInfo != null) {
                    this.f10573f.set(Integer.parseInt(speakerInfo.getVolume()));
                }
                MicroPhoneInfo microPhoneInfo = audioInfo.getMicroPhoneInfo();
                if (microPhoneInfo != null) {
                    this.f10572e.set(Integer.parseInt(microPhoneInfo.getVolume()));
                }
            } catch (NumberFormatException e2) {
                b.d.w.c.a.e(this.a, Log.getStackTraceString(e2));
            }
        }
    }

    private void G(int i) {
        e.e(this.f10569b, i);
    }

    private void H(boolean z) {
        e.E(this.f10569b, z);
    }

    private void I(int i) {
        e.g(this.f10569b, i);
    }

    private void J(boolean z) {
        if (this.m.get()) {
            e.F(this.f10569b, z);
        } else {
            e.z(this.f10569b, z);
        }
    }

    private void K() {
        if (this.r != 0) {
            e.A(this.f10569b, (System.currentTimeMillis() - this.r) / 1000.0d);
            this.r = 0L;
        }
    }

    private void M(String str) {
        VolumeRepository volumeRepository = str != null ? (VolumeRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(str, VolumeRepository.class) : null;
        this.f10570c = volumeRepository;
        if (volumeRepository != null) {
            LiveData<AudioInfo> t = volumeRepository.t();
            if (this.f10570c.s() != null) {
                this.f10572e.set(this.f10570c.u());
                this.f10572e.set(this.f10570c.v());
            }
            this.f10571d.removeSource(t);
            final MediatorLiveData<AudioInfo> mediatorLiveData = this.f10571d;
            mediatorLiveData.getClass();
            mediatorLiveData.addSource(t, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.a3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MediatorLiveData.this.setValue((AudioInfo) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        LiveMediaAPI.startSendAudio(this.f10569b);
    }

    private void U() {
        io.reactivex.e0.c cVar = this.v;
        if (cVar != null && !cVar.isDisposed()) {
            this.v.dispose();
        }
        if (!this.m.get()) {
            this.v = q.W0(60L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.e2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    TalkViewModel.this.D((Long) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        if (this.p == null) {
            this.p = new Timer();
        }
        this.p.schedule(new c(), 0L, 1000L);
    }

    private void Y() {
        io.reactivex.e0.c cVar = this.v;
        if (cVar != null && !cVar.isDisposed()) {
            this.v.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@StringRes int i) {
        this.j.set(false);
        this.k.set(false);
        this.n.set(getApplication().getString(i));
        l(this.f10569b);
        this.o.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<>(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void r(Boolean bool) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t(Throwable th) throws Exception {
        b.d.w.c.a.c(this.a, th.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(Boolean bool) throws Exception {
        String str = this.a;
        b.d.w.c.a.c(str, "Save microphone successfully:" + this.f10572e.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public /* synthetic */ void x(Throwable th) throws Exception {
        String str = this.a;
        b.d.w.c.a.c(str, "Save microphone " + th.toString());
        int w = this.f10570c.w();
        if (w != -1) {
            this.f10572e.set(w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void z(Boolean bool) throws Exception {
        String str = this.a;
        b.d.w.c.a.c(str, "Save speaker successfully:" + this.f10573f.get());
    }

    public void L() {
        if (this.f10569b != null && !this.t.get() && this.f10570c != null) {
            io.reactivex.e0.c cVar = this.u;
            if (cVar != null && !cVar.isDisposed()) {
                this.u.dispose();
            }
            io.reactivex.e0.c H0 = this.f10570c.J().H0(a2.f10590c, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.b2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    TalkViewModel.this.t((Throwable) obj);
                }
            });
            this.u = H0;
            this.w.b(H0);
        }
    }

    public void N() {
        VolumeRepository volumeRepository = this.f10570c;
        if (volumeRepository != null && volumeRepository.s() != null) {
            if (this.f10570c.A(this.f10572e.get())) {
                this.w.b(this.f10570c.K(this.f10572e.get()).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.d2
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        TalkViewModel.this.v((Boolean) obj);
                    }
                }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.x1
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        TalkViewModel.this.x((Throwable) obj);
                    }
                }));
                G(this.f10572e.get());
            }
            if (this.f10570c.B(this.f10573f.get())) {
                this.w.b(this.f10570c.L(this.f10573f.get()).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.c2
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        TalkViewModel.this.z((Boolean) obj);
                    }
                }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.y1
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        TalkViewModel.this.B((Throwable) obj);
                    }
                }));
                I(this.f10573f.get());
            }
        }
    }

    public void O(String str) {
        this.k.set(false);
        this.f10569b = str;
        M(str);
        L();
    }

    public void P(boolean z, String str) {
        this.i.set(z);
        LiveMediaAPI.muteVolume(str, z);
    }

    public void Q(String str) {
        this.s = str;
    }

    public void R(long j) {
        this.q = j;
    }

    public void S(int i, int i2) {
        LiveMediaAPI.setMaxVolume(this.f10569b, i);
        LiveMediaAPI.setVolume(this.f10569b, i2);
    }

    public void V() {
        Y();
        if (this.f10569b != null) {
            this.r = System.currentTimeMillis();
            LiveMediaAPI.startHoldToTalk(this.f10569b);
            LiveMediaAPI.startSendAudio(this.f10569b);
        }
    }

    public void X() {
        U();
        if (this.f10569b != null) {
            K();
            LiveMediaAPI.stopHoldToTalk(this.f10569b);
            LiveMediaAPI.pauseSendAudio(this.f10569b);
        }
    }

    public void Z() {
        Timer timer = this.p;
        if (timer != null) {
            timer.cancel();
            this.p = null;
        }
    }

    public void a0(LifecycleOwner lifecycleOwner) {
        this.f10571d.observe(lifecycleOwner, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.play.z1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TalkViewModel.this.F((AudioInfo) obj);
            }
        });
        this.f10572e.addOnPropertyChangedCallback(new a());
    }

    public void b0() {
        boolean z = !this.i.get();
        P(z, this.f10569b);
        J(z);
    }

    public void c0() {
        boolean z = this.h.get();
        LiveMediaAPI.muteRecordAudio(this.f10569b, !z);
        this.h.set(!z);
        H(!z);
    }

    public void k(String str) {
        this.h.set(false);
        this.n.set(null);
        U();
        LiveMediaAPI.addDoubleTalkStreamCallback(this.f10569b, this.x);
        LiveMediaAPI.openDoubleTalkClient(this.f10569b, str);
    }

    public void l(String str) {
        if (this.n.get() == null && this.m.get()) {
            this.n.set(getApplication().getString(this.j.get() ? R.string.voice_call_ended : R.string.voice_call_cancelled));
        }
        this.j.set(false);
        LiveMediaAPI.destroyDoubleTalkClient(str);
    }

    public void m() {
        if (this.f10572e.get() == 0) {
            this.f10572e.set(60);
            N();
        }
    }

    public String o() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.w.d();
        io.reactivex.e0.c cVar = this.v;
        if (cVar != null && !cVar.isDisposed()) {
            this.v.dispose();
        }
    }

    public long p() {
        return this.q;
    }
}
