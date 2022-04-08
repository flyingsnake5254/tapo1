package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.Utils.u;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import com.tplink.libtpnetwork.cameranetwork.business.model.e;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfig;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfigInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfigRegion;
import com.tplink.libtpnetwork.cameranetwork.util.j;
import io.reactivex.g0.g;
import io.reactivex.l0.a;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PrivacyMaskRepository extends c {

    /* renamed from: d  reason: collision with root package name */
    public final MutableLiveData<e> f14316d = new MutableLiveData<>();

    public PrivacyMaskRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void B(Throwable th) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void D(List list, Boolean bool) throws Exception {
        e value = this.f14316d.getValue();
        if (value == null) {
            value = new e();
        }
        value.d(list);
        this.f14316d.setValue(value);
    }

    private void E(boolean z) {
        if (b() != null && b().getDeviceIdMD5() != null && !u.f(b().getDeviceIdMD5()) && z) {
            u.n(b().getDeviceIdMD5(), true);
        }
    }

    public static e F(CoverConfigInfo coverConfigInfo) {
        CoverConfig config = coverConfigInfo.getConfig();
        List<CoverConfigRegion> regions = coverConfigInfo.getRegions();
        e eVar = new e();
        if (config != null) {
            eVar.c("on".equals(config.getEnabled()));
        }
        if (regions != null) {
            ArrayList arrayList = new ArrayList(regions.size());
            for (CoverConfigRegion coverConfigRegion : regions) {
                d dVar = new d();
                dVar.g(j.e(coverConfigRegion.getX(), 0));
                dVar.h(j.e(coverConfigRegion.getY(), 0));
                dVar.f(j.e(coverConfigRegion.getWidth(), 0));
                dVar.e(j.e(coverConfigRegion.getHeight(), 0));
                arrayList.add(dVar);
            }
            eVar.d(arrayList);
        }
        return eVar;
    }

    private CoverConfigRegion s(d dVar) {
        return new CoverConfigRegion(dVar.c(), dVar.d(), dVar.b(), dVar.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void u(Throwable th) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void w(Throwable th) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(boolean z, Boolean bool) throws Exception {
        e value = this.f14316d.getValue();
        if (value == null) {
            value = new e();
        }
        value.c(z);
        this.f14316d.setValue(value);
        E(z);
    }

    public q<Boolean> G(final boolean z) {
        return l().r2(z).i(m.g()).L0(a.c()).l0(io.reactivex.d0.b.a.a()).C(z5.f14661c).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.y5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PrivacyMaskRepository.this.y(z, (Boolean) obj);
            }
        }).g0(x5.f14642c);
    }

    public q<Boolean> H(final List<d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (d dVar : list) {
            arrayList.add(s(dVar));
        }
        return l().c(arrayList).i(m.g()).L0(a.c()).l0(io.reactivex.d0.b.a.a()).C(s5.f14590c).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.w5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                PrivacyMaskRepository.this.D(list, (Boolean) obj);
            }
        }).g0(u5.f14611c);
    }

    public q<Boolean> t() {
        q l0 = l().G().i(m.a()).L0(a.c()).g0(d7.f14378c).l0(io.reactivex.d0.b.a.a());
        final MutableLiveData<e> mutableLiveData = this.f14316d;
        mutableLiveData.getClass();
        return l0.E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.k2
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MutableLiveData.this.setValue((e) obj);
            }
        }).C(v5.f14622c).g0(t5.f14600c);
    }
}
