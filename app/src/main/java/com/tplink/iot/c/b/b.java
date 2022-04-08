package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.auth.params.AuthParams;
import com.tplink.iot.cloud.bean.auth.result.AuthResult;
import io.reactivex.q;
import retrofit2.x.a;
import retrofit2.x.k;
import retrofit2.x.o;
import retrofit2.x.s;

/* compiled from: AuthApi.java */
/* loaded from: classes2.dex */
public interface b {
    @k({"Authorization-Required:false"})
    @o("{url}/v1/auth/app")
    q<AuthResult> g1(@s(encoded = true, value = "url") String str, @a AuthParams authParams);
}
