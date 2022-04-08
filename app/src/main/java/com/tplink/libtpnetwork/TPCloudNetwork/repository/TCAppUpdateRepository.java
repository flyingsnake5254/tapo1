package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import androidx.lifecycle.MutableLiveData;
import b.d.b.c.j;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.update.result.AppVersionResult;
import com.tplink.cloud.bean.webservice.params.ServiceStatusInfoParams;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class TCAppUpdateRepository extends b.d.b.f.a {

    /* renamed from: c  reason: collision with root package name */
    private static final Comparator<AppVersionResult> f13851c = new a();

    /* renamed from: d  reason: collision with root package name */
    private b.d.b.c.b f13852d;

    /* renamed from: e  reason: collision with root package name */
    private j f13853e;

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<AppVersionResult> f13854f = new MutableLiveData<>();

    /* loaded from: classes3.dex */
    static class a implements Comparator<AppVersionResult> {
        a() {
        }

        /* renamed from: a */
        public int compare(AppVersionResult appVersionResult, AppVersionResult appVersionResult2) {
            return appVersionResult2.getVersionCode() - appVersionResult.getVersionCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements io.reactivex.g0.j<CloudResult<Void>, Boolean> {
        b() {
        }

        /* renamed from: a */
        public Boolean apply(CloudResult<Void> cloudResult) throws Exception {
            return Boolean.valueOf(cloudResult != null && cloudResult.getErrorCode() == 0);
        }
    }

    public TCAppUpdateRepository(com.tplink.cloud.context.b bVar) {
        super(bVar);
        this.f13852d = bVar.d();
        this.f13853e = bVar.d();
    }

    public io.reactivex.a d(ServiceStatusInfoParams serviceStatusInfoParams) {
        return this.f13853e.X(new CloudParams<>("uploadServiceStatusInfo", serviceStatusInfoParams)).L0(io.reactivex.l0.a.c()).g0(new b()).Z();
    }
}
