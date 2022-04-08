package com.tplink.iot.dailysummary.network;

import com.tplink.iot.dailysummary.network.bean.common.SummaryConfig;
import com.tplink.iot.dailysummary.network.bean.params.CancelCreateSummaryParams;
import com.tplink.iot.dailysummary.network.bean.params.CreateSummaryParams;
import com.tplink.iot.dailysummary.network.bean.params.DeleteSummaryParams;
import com.tplink.iot.dailysummary.network.bean.result.RecentSummaryListResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryClipInfoResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryEventIdResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryListResult;
import com.tplink.iot.dailysummary.network.bean.result.SummaryResult;
import com.tplink.iot.dailysummary.network.bean.result.SummarySupportResult;
import io.reactivex.q;
import retrofit2.x.f;
import retrofit2.x.h;
import retrofit2.x.o;
import retrofit2.x.s;
import retrofit2.x.t;

/* compiled from: DailySummaryApi.java */
/* loaded from: classes2.dex */
public interface a {
    @f("{url}/v1/summary/config")
    q<SummaryConfig> a(@s(encoded = true, value = "url") String str, @t("deviceId") String str2);

    @o("{url}/v1/summary")
    q<SummaryEventIdResult> b(@s(encoded = true, value = "url") String str, @retrofit2.x.a CreateSummaryParams createSummaryParams);

    @f("{url}/v1/summary/recent")
    q<RecentSummaryListResult> c(@s(encoded = true, value = "url") String str, @t("deviceId") String str2, @t("size") int i);

    @f("{url}/v1/summary/metadata")
    q<SummaryClipInfoResult> d(@s(encoded = true, value = "url") String str, @t("deviceId") String str2, @t("date") String str3, @t("uuid") String str4);

    @f("{url}/v1/summary")
    q<SummaryResult> e(@s(encoded = true, value = "url") String str, @t("deviceId") String str2, @t("date") String str3);

    @f("{url}/v1/summary/version")
    q<SummarySupportResult> f(@s(encoded = true, value = "url") String str, @t("deviceId") String str2, @t("timezone") String str3, @t("deviceType") String str4);

    @f("{url}/v1/summary/list")
    q<SummaryListResult> g(@s(encoded = true, value = "url") String str, @t("deviceId") String str2, @t("page") int i, @t("pageSize") int i2);

    @h(hasBody = true, method = "DELETE", path = "{url}/v1/summary")
    io.reactivex.a h(@s(encoded = true, value = "url") String str, @retrofit2.x.a DeleteSummaryParams deleteSummaryParams);

    @o("{url}/v1/summary/cancel")
    q<SummaryEventIdResult> i(@s(encoded = true, value = "url") String str, @retrofit2.x.a CancelCreateSummaryParams cancelCreateSummaryParams);

    @o("{url}/v1/summary/config")
    io.reactivex.a j(@s(encoded = true, value = "url") String str, @retrofit2.x.a SummaryConfig summaryConfig);
}
