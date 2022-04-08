package com.tplink.libtpnetwork.libwss.b;

import com.tplink.libtpnetwork.libwss.bean.params.SkillActiveParams;
import com.tplink.libtpnetwork.libwss.bean.result.AppToAppLinkStatusResult;
import io.reactivex.q;
import retrofit2.x.f;
import retrofit2.x.o;
import retrofit2.x.s;

/* compiled from: AlexaLinkApi.kt */
/* loaded from: classes3.dex */
public interface a {
    @o("v1/public/auth/{skillCode}")
    io.reactivex.a a(@s("skillCode") String str, @retrofit2.x.a SkillActiveParams skillActiveParams);

    @f("v1/public/auth/{skillCode}")
    q<AppToAppLinkStatusResult> b(@s("skillCode") String str);
}
