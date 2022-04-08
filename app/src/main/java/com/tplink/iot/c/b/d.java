package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.cloudvideo.common.CloudVideo;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.cloud.bean.cloudvideo.common.HasVideoTime;
import com.tplink.iot.cloud.bean.cloudvideo.common.OrderInfo;
import com.tplink.iot.cloud.bean.cloudvideo.params.DeviceTypeParams;
import com.tplink.iot.cloud.bean.cloudvideo.params.DeviceVideoParams;
import com.tplink.iot.cloud.bean.cloudvideo.params.UnbindDeviceParams;
import com.tplink.iot.cloud.bean.cloudvideo.result.CloudVideoDevicesResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.CloudVideoPageListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.CountryCodeListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceIdListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceOrderListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DeviceVideoDateResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.DowngradeInfoResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.OrderPageListResult;
import com.tplink.iot.cloud.bean.cloudvideo.result.TapoCareUrlResult;
import io.reactivex.a;
import io.reactivex.q;
import retrofit2.x.f;
import retrofit2.x.h;
import retrofit2.x.o;
import retrofit2.x.s;
import retrofit2.x.t;

/* compiled from: CloudVideoApi.java */
/* loaded from: classes2.dex */
public interface d {
    @f("{url}/v1/service/url/secondary")
    q<TapoCareUrlResult> A0(@s(encoded = true, value = "url") String str, @t("clientType") String str2);

    @h(hasBody = true, method = "DELETE", path = "{url}/v1/videos")
    a F1(@s(encoded = true, value = "url") String str, @retrofit2.x.a DeviceVideoParams deviceVideoParams);

    @f("{url}/v1/orders/app")
    q<OrderPageListResult<OrderInfo>> G0(@s(encoded = true, value = "url") String str, @t("accountId") String str2, @t("page") int i, @t("pageSize") int i2);

    @f("{url}/v1/subscription/downgrade")
    q<DowngradeInfoResult> K0(@s(encoded = true, value = "url") String str);

    @f("{url}/v1/videos/devices")
    q<CloudVideoDevicesResult> P(@s(encoded = true, value = "url") String str, @t("page") int i, @t("pageSize") int i2);

    @h(hasBody = true, method = "DELETE", path = "{url}/v1/device/packages")
    a P1(@s(encoded = true, value = "url") String str, @retrofit2.x.a UnbindDeviceParams unbindDeviceParams);

    @f("{url}/v1/device/packages")
    q<DeviceCloudProduct> V(@s(encoded = true, value = "url") String str, @t("deviceId") String str2);

    @f("{url}/v1/service/country")
    q<CountryCodeListResult> a1(@s(encoded = true, value = "url") String str);

    @o("{url}/v1/service/tapocare")
    q<DeviceIdListResult> h1(@s(encoded = true, value = "url") String str, @retrofit2.x.a DeviceTypeParams deviceTypeParams);

    @f("{url}/v1/videos/timestamps")
    q<DeviceVideoDateResult<HasVideoTime>> n(@s(encoded = true, value = "url") String str, @t("deviceId") String str2, @t("startDate") String str3, @t("endDate") String str4);

    @f("{url}/v1/device/packages/byAccount")
    q<DeviceOrderListResult<DeviceCloudProduct>> o0(@s(encoded = true, value = "url") String str, @t("accountId") String str2, @t("page") int i, @t("pageSize") int i2);

    @f("{url}/v1/videos")
    q<CloudVideoPageListResult<CloudVideo>> q1(@s(encoded = true, value = "url") String str, @t("deviceId") String str2, @t("page") int i, @t("pageSize") int i2, @t("order") String str3, @t("uuid") String str4, @t("startTime") String str5, @t("endTime") String str6);
}
