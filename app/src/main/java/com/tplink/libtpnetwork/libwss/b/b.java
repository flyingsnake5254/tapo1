package com.tplink.libtpnetwork.libwss.b;

import com.tplink.libtpnetwork.libwss.bean.result.GoogleAssistantLinkInfoResult;
import io.reactivex.a;
import io.reactivex.q;
import retrofit2.x.o;
import retrofit2.x.s;

/* compiled from: GoogleSmartHomeApi.java */
/* loaded from: classes3.dex */
public interface b {
    @o("v1/public/auth/islinked/{actionType}")
    q<GoogleAssistantLinkInfoResult> a(@s("actionType") String str);

    @retrofit2.x.b("v1/public/auth/unlink/{actionType}")
    a b(@s("actionType") String str);
}
