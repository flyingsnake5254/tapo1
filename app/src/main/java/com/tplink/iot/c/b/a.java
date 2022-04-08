package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.common.AsyncResult;
import io.reactivex.q;
import retrofit2.x.f;
import retrofit2.x.s;

/* compiled from: AsyncApi.java */
/* loaded from: classes2.dex */
public interface a {
    @f("{url}/v1/requests/{requestId}")
    q<AsyncResult> G1(@s(encoded = true, value = "url") String str, @s("requestId") String str2);
}
