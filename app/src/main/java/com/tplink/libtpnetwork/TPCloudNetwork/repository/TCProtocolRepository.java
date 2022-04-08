package com.tplink.libtpnetwork.TPCloudNetwork.repository;

import b.d.b.c.h;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.protocol.params.HelloCloudParams;
import com.tplink.cloud.bean.protocol.result.HelloCloudResult;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;

/* loaded from: classes3.dex */
public class TCProtocolRepository extends b.d.b.f.a {

    /* renamed from: c  reason: collision with root package name */
    private h f13913c;

    /* renamed from: d  reason: collision with root package name */
    private final HelloCloudParams f13914d;

    /* renamed from: e  reason: collision with root package name */
    private io.reactivex.m0.b<Boolean> f13915e = io.reactivex.m0.b.n1();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements g<Boolean> {
        a() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            TCProtocolRepository.this.f13915e.onNext(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements j<CloudResult<HelloCloudResult>, Boolean> {
        b() {
        }

        /* renamed from: a */
        public Boolean apply(CloudResult<HelloCloudResult> cloudResult) throws Exception {
            return Boolean.valueOf(cloudResult.getResult().getTcspStatus() != 2);
        }
    }

    public TCProtocolRepository(com.tplink.cloud.context.b bVar) {
        super(bVar);
        this.f13913c = bVar.d();
        com.tplink.cloud.context.a e2 = bVar.e();
        HelloCloudParams helloCloudParams = new HelloCloudParams();
        this.f13914d = helloCloudParams;
        helloCloudParams.setTcspVer("1.1");
        helloCloudParams.setAppType(e2.b());
        helloCloudParams.setAppPackageName(e2.c());
        helloCloudParams.setTerminalUUID(e2.q());
    }

    public q<Boolean> e() {
        return this.f13913c.v(new CloudParams<>("helloCloud", this.f13914d)).g0(new b()).q0(Boolean.FALSE).E(new a());
    }

    public boolean f() {
        h hVar = this.f13913c;
        return !(hVar instanceof b.d.b.b) || ((b.d.b.b) hVar).S1();
    }
}
