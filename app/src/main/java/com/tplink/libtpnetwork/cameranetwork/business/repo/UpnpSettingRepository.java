package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpInfo;
import io.reactivex.g0.g;
import io.reactivex.q;

/* loaded from: classes3.dex */
public class UpnpSettingRepository extends CameraSettingRepository {
    private MutableLiveData<Boolean> h = new MutableLiveData<>();
    CommonCameraRepository i;

    /* loaded from: classes3.dex */
    class a implements g<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f14326c;

        a(boolean z) {
            this.f14326c = z;
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            UpnpSettingRepository.this.h.postValue(Boolean.valueOf(this.f14326c));
            CommonCameraRepository commonCameraRepository = UpnpSettingRepository.this.i;
            if (commonCameraRepository != null) {
                commonCameraRepository.g().F0();
            }
        }
    }

    public UpnpSettingRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
        if (tPCameraDeviceContext != null) {
            this.i = (CommonCameraRepository) e.c(tPCameraDeviceContext.getDeviceIdMD5(), CommonCameraRepository.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O1 */
    public /* synthetic */ void P1(Boolean bool) throws Exception {
        this.h.postValue(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q1 */
    public /* synthetic */ void R1(boolean z, Throwable th) throws Exception {
        this.h.postValue(Boolean.valueOf(!z));
    }

    public MutableLiveData<Boolean> M1() {
        return this.h;
    }

    public q<Boolean> T1() {
        return this.f14514c.w0().i(m.a()).L0(io.reactivex.l0.a.c()).g0(v6.f14623c).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.t6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                UpnpSettingRepository.this.P1((Boolean) obj);
            }
        }).C(f7.f14400c);
    }

    public q<Boolean> U1(final boolean z) {
        return this.f14514c.a3(new UpnpInfo(z ? "on" : "off", ThingModelDefine.Property.PROPERTY_AUTO)).C(f7.f14400c).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new a(z)).C(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.u6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                UpnpSettingRepository.this.R1(z, (Throwable) obj);
            }
        }).g0(w6.f14634c);
    }
}
