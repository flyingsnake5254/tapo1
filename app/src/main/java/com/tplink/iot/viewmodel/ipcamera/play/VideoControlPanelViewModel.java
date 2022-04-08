package com.tplink.iot.viewmodel.ipcamera.play;

import android.app.Application;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;
import com.tplink.iot.Utils.v0.d;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.Utils.f;
import com.tplink.libtpnetwork.Utils.j;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AlarmSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.g;

/* loaded from: classes3.dex */
public class VideoControlPanelViewModel extends AndroidViewModel {

    /* renamed from: b  reason: collision with root package name */
    private c f10575b;

    /* renamed from: d  reason: collision with root package name */
    private VideoPlayViewModel f10577d;

    /* renamed from: f  reason: collision with root package name */
    private AlarmSettingRepository f10579f;
    public final MutableLiveData<Boolean> a = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: c  reason: collision with root package name */
    public ObservableBoolean f10576c = new ObservableBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private b f10578e = new b();
    public final MutableLiveData<a<String>> g = new MutableLiveData<>();
    public final MutableLiveData<a<Boolean>> h = new MutableLiveData<>();

    public VideoControlPanelViewModel(@NonNull Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(CameraComponent cameraComponent) throws Exception {
        this.f10577d.H.set(cameraComponent.hasComponent(ComponentType.AUDIO));
        this.f10577d.I.set(cameraComponent.hasComponent(ComponentType.PTZ));
        this.f10577d.J.set(cameraComponent.hasComponent(ComponentType.LEN_MASK));
        this.f10577d.K.set(cameraComponent.hasComponent(ComponentType.DETECTION));
        this.f10577d.L.set(cameraComponent.hasComponent(ComponentType.ALERT));
        this.f10577d.M.set(cameraComponent.hasComponent(ComponentType.PLAYBACK));
        this.f10577d.N.set(cameraComponent.isSupportVideoQualityChange());
        this.f10577d.O.set(cameraComponent.isSupportNightVision());
        this.h.postValue(new a<>(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(Throwable th) throws Exception {
        th.printStackTrace();
        this.h.postValue(new a<>(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(AlarmInfo alarmInfo) throws Exception {
        this.f10577d.l.set(OptionSwitch.isOn(alarmInfo.getEnabled()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void r() {
        this.g.setValue(new a<>(getApplication().getString(R.string.general_failed)));
        this.a.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t(c cVar) throws Exception {
        this.a.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v() throws Exception {
        this.a.postValue(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public /* synthetic */ void x(boolean z, Boolean bool) throws Exception {
        this.f10577d.l.set(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void z(Throwable th) throws Exception {
        this.g.setValue(new a<>(getApplication().getString(R.string.general_failed)));
    }

    public void A() {
        c cVar = this.f10575b;
        if (cVar != null && !cVar.isDisposed()) {
            this.f10575b.dispose();
        }
        String str = (String) j.e(this.f10577d.k, "");
        if (!TextUtils.isEmpty(str) && f.f(str)) {
            AlarmSettingRepository alarmSettingRepository = (AlarmSettingRepository) e.b(TPIoTClientManager.K1(str), AlarmSettingRepository.class);
            this.f10579f = alarmSettingRepository;
            this.f10577d.l.set(alarmSettingRepository.y());
            c H0 = this.f10579f.L().L0(io.reactivex.l0.a.c()).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.m2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    VideoControlPanelViewModel.this.n((AlarmInfo) obj);
                }
            }, g2.f10610c);
            this.f10575b = H0;
            this.f10578e.b(H0);
        }
    }

    public void B(final boolean z) {
        AlarmSettingRepository alarmSettingRepository = this.f10579f;
        if (alarmSettingRepository == null) {
            this.a.postValue(Boolean.TRUE);
            new Handler().postDelayed(new Runnable() { // from class: com.tplink.iot.viewmodel.ipcamera.play.j2
                @Override // java.lang.Runnable
                public final void run() {
                    VideoControlPanelViewModel.this.r();
                }
            }, 1000L);
            return;
        }
        this.f10578e.b(alarmSettingRepository.s(z).F(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.h2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VideoControlPanelViewModel.this.t((c) obj);
            }
        }).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.play.n2
            @Override // io.reactivex.g0.a
            public final void run() {
                VideoControlPanelViewModel.this.v();
            }
        }).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.l2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VideoControlPanelViewModel.this.x(z, (Boolean) obj);
            }
        }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.k2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VideoControlPanelViewModel.this.z((Throwable) obj);
            }
        }));
    }

    public void C(VideoPlayViewModel videoPlayViewModel) {
        this.f10577d = videoPlayViewModel;
    }

    public void f() {
        String str = (String) j.e(this.f10577d.k, "");
        if (!TextUtils.isEmpty(str) && f.f(str)) {
            this.f10578e.b(((CommonCameraRepository) e.c(str, CommonCameraRepository.class)).K0().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.f2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    VideoControlPanelViewModel.this.j((CameraComponent) obj);
                }
            }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.play.i2
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    VideoControlPanelViewModel.this.l((Throwable) obj);
                }
            }));
        }
    }

    public VideoPlayViewModel g() {
        return this.f10577d;
    }

    public void h() {
        this.f10576c.set(d.c((String) j.e(this.f10577d.k, "")));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f10578e.d();
    }
}
