package com.tplink.nbu.a;

import com.tplink.nbu.bean.iam.Event;
import com.tplink.nbu.bean.iam.MaterialsResult;
import com.tplink.nbu.bean.iam.ShowedTaskParams;
import com.tplink.nbu.bean.iam.ShowedTaskResult;
import io.reactivex.q;
import retrofit2.x.f;
import retrofit2.x.k;
import retrofit2.x.o;
import retrofit2.x.s;
import retrofit2.x.t;

/* compiled from: IAMApi.java */
/* loaded from: classes3.dex */
public interface a {
    @k({"Authorization-Required:false", "nbu-signature-required:true"})
    @o("{url}/v1/tasks/event")
    io.reactivex.a a(@s(encoded = true, value = "url") String str, @retrofit2.x.a Event event);

    @f("{url}/v1/materials")
    @k({"Authorization-Required:false", "nbu-signature-required:true"})
    q<MaterialsResult> b(@s(encoded = true, value = "url") String str, @t("accountId") String str2, @t("materialType") String str3);

    @k({"Authorization-Required:false", "nbu-signature-required:true"})
    @o("{url}/v1/tasks/count")
    q<ShowedTaskResult> c(@s(encoded = true, value = "url") String str, @retrofit2.x.a ShowedTaskParams showedTaskParams);
}
