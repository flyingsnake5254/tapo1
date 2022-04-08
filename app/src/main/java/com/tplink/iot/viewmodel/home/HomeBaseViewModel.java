package com.tplink.iot.viewmodel.home;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.x0.j;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.firmware.FirmwareManager;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class HomeBaseViewModel extends AndroidViewModel {

    /* renamed from: c  reason: collision with root package name */
    TPIoTClientManager f10052c;

    /* renamed from: d  reason: collision with root package name */
    FamilyManagerRepository f10053d;

    /* renamed from: f  reason: collision with root package name */
    ThingCloudRepository f10054f;
    GroupRepository q;
    r x = r.g();
    FirmwareManager y;

    /* loaded from: classes2.dex */
    class a implements io.reactivex.g0.a {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f10055b;

        a(String str, long j) {
            this.a = str;
            this.f10055b = j;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            j.c(this.a, System.currentTimeMillis() - this.f10055b, true);
        }
    }

    /* loaded from: classes2.dex */
    class b implements g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10057c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f10058d;

        b(String str, long j) {
            this.f10057c = str;
            this.f10058d = j;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (w.d(th)) {
                w.f();
            }
            j.c(this.f10057c, System.currentTimeMillis() - this.f10058d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HomeBaseViewModel(@NonNull Application application) {
        super(application);
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        this.f10052c = (TPIoTClientManager) b.d.b.f.b.a(f2, TPIoTClientManager.class);
        this.f10053d = (FamilyManagerRepository) b.d.b.f.b.a(f2, FamilyManagerRepository.class);
        this.f10054f = (ThingCloudRepository) b.d.b.f.b.a(f2, ThingCloudRepository.class);
        this.q = (GroupRepository) b.d.b.f.b.a(f2, GroupRepository.class);
        this.y = (FirmwareManager) b.d.b.f.b.a(f2, FirmwareManager.class);
    }

    private void t(List<e> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (e eVar : list) {
            if (eVar instanceof k) {
                BaseALIoTDevice g = ((k) eVar).g();
                if (g != null) {
                    g.setCommonDevice(z);
                    if (!TextUtils.isEmpty(g.getDeviceId())) {
                        arrayList.add(g.getDeviceId());
                    }
                }
            } else if (eVar instanceof com.tplink.iot.model.home.g) {
                com.tplink.iot.model.home.g gVar = (com.tplink.iot.model.home.g) eVar;
                if (!TextUtils.isEmpty(gVar.i())) {
                    arrayList2.add(gVar.i());
                }
            }
        }
        k();
        if (!arrayList.isEmpty()) {
            this.f10054f.m1(arrayList, z).F0();
        }
        if (!arrayList2.isEmpty()) {
            this.q.w0(arrayList2, z).y();
        }
    }

    public void f(List<e> list) {
        t(list, true);
    }

    public FamilyInfo g() {
        return this.f10053d.X();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(k kVar) {
        return this.f10053d.j0(kVar.w(), kVar.u(), kVar.i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(com.tplink.iot.model.home.g gVar) {
        return this.f10053d.k0(gVar.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return b.d.w.f.b.j(getApplication()) && b.d.w.f.b.i(getApplication());
    }

    public abstract void k();

    protected abstract void l(String str);

    public void m(List<e> list) {
        t(list, false);
    }

    protected abstract void n(String str);

    public void o(List<e> list) {
        if (!(list == null || list.isEmpty())) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (e eVar : list) {
                if (eVar instanceof k) {
                    k kVar = (k) eVar;
                    l(kVar.l());
                    if (kVar.g() != null) {
                        arrayList.add(kVar.g());
                    }
                } else if (eVar instanceof com.tplink.iot.model.home.g) {
                    com.tplink.iot.model.home.g gVar = (com.tplink.iot.model.home.g) eVar;
                    n(gVar.e());
                    if (!TextUtils.isEmpty(gVar.i())) {
                        arrayList2.add(gVar.i());
                    }
                }
            }
            v();
            if (!arrayList.isEmpty()) {
                this.f10052c.m1(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                this.q.K(arrayList2).y();
            }
        }
    }

    public void p(boolean z, String str) {
        this.x.l(z, str);
    }

    public void r(boolean z, String str) {
        this.x.m(z, str);
    }

    public void s(String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        p(false, str);
        this.f10052c.h2(str).i(z).r(io.reactivex.d0.b.a.a()).j(new b(str, currentTimeMillis)).i(new a(str, currentTimeMillis)).y();
    }

    public void u() {
        this.x.k();
    }

    protected abstract void v();
}
