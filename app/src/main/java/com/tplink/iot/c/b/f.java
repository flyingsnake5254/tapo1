package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.bean.group.params.GroupThingGroupListParams;
import com.tplink.iot.cloud.bean.group.params.GroupThingListParams;
import io.reactivex.a;
import io.reactivex.q;
import java.util.List;
import retrofit2.x.b;
import retrofit2.x.h;
import retrofit2.x.n;
import retrofit2.x.o;
import retrofit2.x.p;
import retrofit2.x.s;
import retrofit2.x.t;

/* compiled from: GroupApi.java */
/* loaded from: classes2.dex */
public interface f {
    @b("{url}/v1/groups")
    a B0(@s(encoded = true, value = "url") String str, @t("groupIds") String... strArr);

    @h(hasBody = true, method = "DELETE", path = "{url}/v1/groups/{groupId}/things")
    a H(@s(encoded = true, value = "url") String str, @s("groupId") String str2, @retrofit2.x.a GroupThingListParams groupThingListParams);

    @retrofit2.x.f("{url}/v1/groups")
    q<PageListResult<GroupInfo>> K1(@s(encoded = true, value = "url") String str, @t("page") int i, @t("pageSize") int i2, @t("groupIds") String... strArr);

    @o("{url}/v1/groups/things")
    a N(@s(encoded = true, value = "url") String str, @retrofit2.x.a GroupThingGroupListParams groupThingGroupListParams);

    @n("{url}/v1/groups")
    a W0(@s(encoded = true, value = "url") String str, @t("groupIds") List<String> list, @retrofit2.x.a GroupInfo groupInfo);

    @p("{url}/v1/groups")
    a c1(@s(encoded = true, value = "url") String str, @retrofit2.x.a GroupInfo groupInfo);
}
