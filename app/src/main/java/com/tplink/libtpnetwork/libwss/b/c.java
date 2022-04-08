package com.tplink.libtpnetwork.libwss.b;

import com.tplink.libtpnetwork.libwss.bean.params.SkillActiveParams;
import io.reactivex.a;
import retrofit2.x.b;
import retrofit2.x.o;
import retrofit2.x.s;

/* compiled from: WssApi.java */
/* loaded from: classes3.dex */
public interface c {
    @o("v1/public/skill-activation/{skillCode}")
    a a(@s("skillCode") String str, @retrofit2.x.a SkillActiveParams skillActiveParams);

    @b("/v1/public/skill-activation/{skillCode}")
    a b(@s("skillCode") String str);
}
