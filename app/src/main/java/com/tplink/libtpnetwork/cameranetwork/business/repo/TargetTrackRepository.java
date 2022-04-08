package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.TargetTrackInfo;
import io.reactivex.g0.g;
import io.reactivex.l0.a;
import io.reactivex.q;

/* loaded from: classes3.dex */
public class TargetTrackRepository extends c {

    /* renamed from: d  reason: collision with root package name */
    public final MutableLiveData<Boolean> f14325d = new MutableLiveData<>();

    public TargetTrackRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void t(Throwable th) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(Response response) throws Exception {
        this.f14325d.setValue(Boolean.valueOf("on".equals(((TargetTrackInfo) response.getResult()).getEnabled())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void x(Throwable th) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void z(boolean z, Response response) throws Exception {
        this.f14325d.setValue(Boolean.valueOf(z));
    }

    public q<Boolean> B(final boolean z) {
        return l().X2(z).L0(a.c()).l0(io.reactivex.d0.b.a.a()).C(q6.f14571c).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.o6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                TargetTrackRepository.this.z(z, (Response) obj);
            }
        }).g0(n6.f14537c);
    }

    public void C(TargetTrackInfo targetTrackInfo) {
        if (targetTrackInfo != null) {
            this.f14325d.postValue(Boolean.valueOf(OptionSwitch.isOn(targetTrackInfo.getEnabled())));
        }
    }

    public q<Boolean> s() {
        return l().s0().L0(a.c()).l0(io.reactivex.d0.b.a.a()).C(p6.f14558c).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.r6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                TargetTrackRepository.this.v((Response) obj);
            }
        }).g0(s6.f14591c);
    }
}
