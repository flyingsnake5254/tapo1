package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.AudioInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MicroPhoneInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.SpeakerInfo;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Objects;

/* loaded from: classes3.dex */
public class VolumeRepository extends c {

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<AudioInfo> f14328d = new MutableLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<a<CameraException>> f14329e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private AudioInfo f14330f;

    public VolumeRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void G(MicroPhoneInfo microPhoneInfo, Response response) throws Exception {
        if (response.isSuccess()) {
            this.f14330f.setMicroPhoneInfo(microPhoneInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void I(SpeakerInfo speakerInfo, Response response) throws Exception {
        if (response.isSuccess()) {
            this.f14330f.setSpeakerInfo(speakerInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Throwable th) {
        if (th instanceof CameraException) {
            this.f14329e.postValue(new a<>((CameraException) th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(AudioInfo audioInfo) {
        this.f14330f = audioInfo;
        this.f14328d.postValue(audioInfo);
    }

    public boolean A(int i) {
        MicroPhoneInfo microPhoneInfo = this.f14330f.getMicroPhoneInfo();
        return (microPhoneInfo == null || i == Integer.parseInt(microPhoneInfo.getVolume())) ? false : true;
    }

    public boolean B(int i) {
        return (this.f14330f.getSpeakerInfo() == null || i == Integer.parseInt(this.f14330f.getSpeakerInfo().getVolume())) ? false : true;
    }

    public q<Boolean> J() {
        return l().z().i(m.a()).L0(io.reactivex.l0.a.c()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.a7
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VolumeRepository.this.z((AudioInfo) obj);
            }
        }).g0(z6.f14662c).C(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.x6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VolumeRepository.this.y((Throwable) obj);
            }
        });
    }

    public q<Boolean> K(int i) {
        MicroPhoneInfo microPhoneInfo = this.f14330f.getMicroPhoneInfo();
        if (microPhoneInfo == null) {
            return q.f0(Boolean.FALSE);
        }
        final MicroPhoneInfo copy = microPhoneInfo.copy(Integer.toString(i), microPhoneInfo.component2(), microPhoneInfo.component3(), microPhoneInfo.component4(), microPhoneInfo.component5());
        return l().K2(copy).L0(io.reactivex.l0.a.c()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.b7
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VolumeRepository.this.G(copy, (Response) obj);
            }
        }).g0(a.f14331c);
    }

    public q<Boolean> L(int i) {
        final SpeakerInfo speakerInfo = new SpeakerInfo(Integer.toString(i));
        return l().V2(speakerInfo).L0(io.reactivex.l0.a.c()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.y6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                VolumeRepository.this.I(speakerInfo, (Response) obj);
            }
        }).g0(a.f14331c);
    }

    public AudioInfo s() {
        return this.f14330f;
    }

    public LiveData<AudioInfo> t() {
        return this.f14328d;
    }

    public int u() {
        AudioInfo audioInfo = this.f14330f;
        if (audioInfo == null) {
            return 0;
        }
        MicroPhoneInfo microPhoneInfo = audioInfo.getMicroPhoneInfo();
        Objects.requireNonNull(microPhoneInfo);
        return Integer.parseInt(microPhoneInfo.getVolume());
    }

    public int v() {
        AudioInfo audioInfo = this.f14330f;
        if (audioInfo == null) {
            return 0;
        }
        SpeakerInfo speakerInfo = audioInfo.getSpeakerInfo();
        Objects.requireNonNull(speakerInfo);
        return Integer.parseInt(speakerInfo.getVolume());
    }

    public int w() {
        if (this.f14330f.getMicroPhoneInfo() != null) {
            try {
                return Integer.parseInt(this.f14330f.getMicroPhoneInfo().getVolume());
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public int x() {
        if (this.f14330f.getSpeakerInfo() != null) {
            try {
                return Integer.parseInt(this.f14330f.getSpeakerInfo().getVolume());
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }
}
