package com.tplink.iot.c;

import androidx.annotation.NonNull;
import b.d.b.d.a.b;
import com.tplink.iot.c.b.c;
import com.tplink.iot.c.b.d;
import com.tplink.iot.c.b.e;
import com.tplink.iot.c.b.f;
import com.tplink.iot.c.b.g;
import com.tplink.iot.c.b.h;
import com.tplink.iot.c.b.i;
import com.tplink.iot.c.b.j;
import com.tplink.iot.cloud.bean.auth.params.AuthParams;
import com.tplink.iot.cloud.bean.auth.result.AuthResult;
import com.tplink.iot.cloud.bean.billing.params.ReceiptParams;
import com.tplink.iot.cloud.bean.billing.result.JudgeReceiptResult;
import com.tplink.iot.cloud.bean.billing.result.ProductListResult;
import com.tplink.iot.cloud.bean.billing.result.VerifyReceiptResult;
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
import com.tplink.iot.cloud.bean.common.AsyncResult;
import com.tplink.iot.cloud.bean.common.PageListResult;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.cloud.bean.family.common.RoomOrderInfo;
import com.tplink.iot.cloud.bean.family.params.FamilyCommonOrderParams;
import com.tplink.iot.cloud.bean.family.params.ThingFamilyParams;
import com.tplink.iot.cloud.bean.family.result.FamilyCommonOrderResult;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.bean.group.params.GroupThingGroupListParams;
import com.tplink.iot.cloud.bean.group.params.GroupThingListParams;
import com.tplink.iot.cloud.bean.push.params.IoTSubscribeMsgParams;
import com.tplink.iot.cloud.bean.share.device.DeviceOwnerInfoResult;
import com.tplink.iot.cloud.bean.share.device.DeviceUserListResult;
import com.tplink.iot.cloud.bean.share.params.DeviceShareActionListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceShareListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUserRoleListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceUsersParams;
import com.tplink.iot.cloud.bean.share.result.DeviceShareActionHandleListResult;
import com.tplink.iot.cloud.bean.share.result.DeviceShareLaunchResult;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceListResult;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartLog;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;
import com.tplink.iot.cloud.bean.smart.result.SmartExecResult;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingRealTimeInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleSchedule;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleTimer;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.cloud.bean.thing.params.SubThingAddListParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingCategoryScanParams;
import com.tplink.iot.cloud.bean.thing.params.SubThingQuickSetupInfoListParams;
import com.tplink.iot.cloud.bean.thing.params.ThingBatchUnbindParams;
import com.tplink.iot.cloud.bean.thing.params.ThingCommonDeviceParams;
import com.tplink.iot.cloud.bean.thing.params.ThingLightingEffectParams;
import com.tplink.iot.cloud.bean.thing.params.ThingRuleDeleteParams;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.cloud.bean.thing.params.ThingShadowUpdateParams;
import com.tplink.iot.cloud.bean.thing.result.SubThingScanListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingBatchUnbindResult;
import com.tplink.iot.cloud.bean.thing.result.ThingCommonDeviceResult;
import com.tplink.iot.cloud.bean.thing.result.ThingComponentResult;
import com.tplink.iot.cloud.bean.thing.result.ThingEventLogResult;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.iot.cloud.bean.thing.result.ThingServiceResult;
import com.tplink.iot.cloud.bean.thing.result.ThingServiceSyncResult;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowUpdateResult;
import com.tplink.iot.cloud.bean.thing.result.ThingSupportInfoResult;
import io.reactivex.q;
import java.util.List;

/* compiled from: IoTCloudClient.java */
/* loaded from: classes2.dex */
public class a extends b implements com.tplink.iot.c.b.b, e, i, j, d, com.tplink.iot.c.b.a, c, f, h, g {

    /* renamed from: d  reason: collision with root package name */
    private com.tplink.iot.c.b.b f6085d = (com.tplink.iot.c.b.b) R1(com.tplink.iot.c.b.b.class);

    /* renamed from: e  reason: collision with root package name */
    private e f6086e = (e) R1(e.class);

    /* renamed from: f  reason: collision with root package name */
    private i f6087f = (i) R1(i.class);
    private j g = (j) R1(j.class);
    private d h = (d) R1(d.class);
    private com.tplink.iot.c.b.a i = (com.tplink.iot.c.b.a) R1(com.tplink.iot.c.b.a.class);
    private c j = (c) R1(c.class);
    private f k = (f) R1(f.class);
    private h l = (h) R1(h.class);
    private g m = (g) R1(g.class);
    private com.tplink.iot.c.c.b n;

    public a(@NonNull String str, @NonNull com.tplink.iot.c.c.b bVar) {
        super(str + bVar.l(), bVar.l());
        this.n = bVar;
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingServiceResult> A(String str, String str2, ThingServiceParams thingServiceParams) {
        return this.g.A(str, str2, thingServiceParams);
    }

    @Override // com.tplink.iot.c.b.d
    public q<TapoCareUrlResult> A0(String str, String str2) {
        return this.h.A0(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingCommonDeviceResult> A1(String str, ThingCommonDeviceParams thingCommonDeviceParams) {
        return this.g.A1(str, thingCommonDeviceParams);
    }

    @Override // com.tplink.iot.c.b.h
    public io.reactivex.a B(String str, String str2, DeviceUsersParams deviceUsersParams) {
        return this.l.B(str, str2, deviceUsersParams);
    }

    @Override // com.tplink.iot.c.b.f
    public io.reactivex.a B0(String str, String... strArr) {
        return this.k.B0(str, strArr);
    }

    @Override // com.tplink.iot.c.b.j
    public q<PageListResult<com.google.gson.i>> B1(String str, int i, int i2, String str2, String str3) {
        return this.g.B1(str, i, i2, str2, str3);
    }

    @Override // com.tplink.iot.c.b.j
    public io.reactivex.a C(String str, String str2) {
        return this.g.C(str, str2);
    }

    @Override // com.tplink.iot.c.b.e
    public io.reactivex.a C0(String str, ThingFamilyParams thingFamilyParams) {
        return this.f6086e.C0(str, thingFamilyParams);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleUpdateResult> D(String str, String str2, String str3, ThingRuleAwayMode thingRuleAwayMode) {
        return this.g.D(str, str2, str3, thingRuleAwayMode);
    }

    @Override // com.tplink.iot.c.b.j
    public q<List<ThingBatchUnbindResult>> D1(String str, ThingBatchUnbindParams thingBatchUnbindParams) {
        return this.g.D1(str, thingBatchUnbindParams);
    }

    @Override // com.tplink.iot.c.b.j
    public q<FirmwareDownloadState> E0(String str, String str2) {
        return this.g.E0(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public io.reactivex.a E1(String str, String str2) {
        return this.g.E1(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleListResult<ThingRuleTimer>> F(String str, String str2, int i) {
        return this.g.F(str, str2, i);
    }

    @Override // com.tplink.iot.c.b.h
    public q<DeviceOwnerInfoResult> F0(String str, String str2, boolean z) {
        return this.l.F0(str, str2, z);
    }

    @Override // com.tplink.iot.c.b.d
    public io.reactivex.a F1(String str, DeviceVideoParams deviceVideoParams) {
        return this.h.F1(str, deviceVideoParams);
    }

    @Override // com.tplink.iot.c.b.j
    public q<com.google.gson.i> G(String str, String str2, String str3) {
        return this.g.G(str, str2, str3);
    }

    @Override // com.tplink.iot.c.b.d
    public q<OrderPageListResult<OrderInfo>> G0(String str, String str2, int i, int i2) {
        return this.h.G0(str, str2, i, i2);
    }

    @Override // com.tplink.iot.c.b.a
    public q<AsyncResult> G1(String str, String str2) {
        return this.i.G1(str, str2);
    }

    @Override // com.tplink.iot.c.b.f
    public io.reactivex.a H(String str, String str2, GroupThingListParams groupThingListParams) {
        return this.k.H(str, str2, groupThingListParams);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingShadowListResult> H0(String str, String... strArr) {
        return this.g.H0(str, strArr);
    }

    @Override // com.tplink.iot.c.b.j
    public io.reactivex.a H1(String str, String str2, ThingRuleDeleteParams thingRuleDeleteParams) {
        return this.g.H1(str, str2, thingRuleDeleteParams);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleListResult<ThingRuleLightEffect>> I(String str, String str2, int i) {
        return this.g.I(str, str2, i);
    }

    @Override // com.tplink.iot.c.b.i
    public q<PageListResult<SmartTemplate>> I0(String str, String str2, int i, int i2, boolean z) {
        return this.f6087f.I0(str, str2, i, i2, z);
    }

    @Override // com.tplink.iot.c.b.e
    public io.reactivex.a J(String str, ThingFamilyParams thingFamilyParams) {
        return this.f6086e.J(str, thingFamilyParams);
    }

    @Override // com.tplink.iot.c.b.j
    public io.reactivex.a J0(String str, String str2, String str3) {
        return this.g.J0(str, str2, str3);
    }

    @Override // com.tplink.iot.c.b.j
    public q<SubThingScanListResult> K(String str, String str2) {
        return this.g.K(str, str2);
    }

    @Override // com.tplink.iot.c.b.d
    public q<DowngradeInfoResult> K0(String str) {
        return this.h.K0(str);
    }

    @Override // com.tplink.iot.c.b.f
    public q<PageListResult<GroupInfo>> K1(String str, int i, int i2, String... strArr) {
        return this.k.K1(str, i, i2, strArr);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleUpdateResult> L(String str, String str2, ThingRuleSchedule thingRuleSchedule) {
        return this.g.L(str, str2, thingRuleSchedule);
    }

    @Override // com.tplink.iot.c.b.e
    public q<FamilyCommonOrderResult> L0(String str, String str2) {
        return this.f6086e.L0(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingSetting> M0(String str, String str2) {
        return this.g.M0(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingDetail> M1(String str, String str2) {
        return this.g.M1(str, str2);
    }

    @Override // com.tplink.iot.c.b.f
    public io.reactivex.a N(String str, GroupThingGroupListParams groupThingGroupListParams) {
        return this.k.N(str, groupThingGroupListParams);
    }

    @Override // com.tplink.iot.c.b.j
    public q<com.google.gson.i> N1(String str, ThingLightingEffectParams thingLightingEffectParams) {
        return this.g.N1(str, thingLightingEffectParams);
    }

    @Override // com.tplink.iot.c.b.j
    public io.reactivex.a O(String str, String str2, Integer num, com.google.gson.i iVar) {
        return this.g.O(str, str2, num, iVar);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingShadowUpdateResult> O1(String str, String str2, ThingShadowUpdateParams thingShadowUpdateParams) {
        return this.g.O1(str, str2, thingShadowUpdateParams);
    }

    @Override // com.tplink.iot.c.b.d
    public q<CloudVideoDevicesResult> P(String str, int i, int i2) {
        return this.h.P(str, i, i2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingNextEvent> P0(String str, String str2) {
        return this.g.P0(str, str2);
    }

    @Override // com.tplink.iot.c.b.d
    public io.reactivex.a P1(String str, UnbindDeviceParams unbindDeviceParams) {
        return this.h.P1(str, unbindDeviceParams);
    }

    @Override // com.tplink.iot.c.b.e
    public io.reactivex.a Q(String str, String str2) {
        return this.f6086e.Q(str, str2);
    }

    @Override // com.tplink.iot.c.b.e
    public q<RoomInfo> R(String str, String str2, RoomInfo roomInfo) {
        return this.f6086e.R(str, str2, roomInfo);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingFirmware> R0(String str, String str2) {
        return this.g.R0(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleUpdateResult> S(String str, String str2, String str3, ThingRuleLightEffect thingRuleLightEffect) {
        return this.g.S(str, str2, str3, thingRuleLightEffect);
    }

    public com.tplink.iot.c.c.b S1() {
        return this.n;
    }

    @Override // com.tplink.iot.c.b.j
    public io.reactivex.a T0(String str, String str2, com.google.gson.i iVar) {
        return this.g.T0(str, str2, iVar);
    }

    public void T1(String str) {
        this.n.n(str);
    }

    @Override // com.tplink.iot.c.b.i
    public q<SmartExecResult> U(String str, String str2) {
        return this.f6087f.U(str, str2);
    }

    @Override // com.tplink.iot.c.b.d
    public q<DeviceCloudProduct> V(String str, String str2) {
        return this.h.V(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleUpdateResult> V0(String str, String str2, ThingRuleAwayMode thingRuleAwayMode) {
        return this.g.V0(str, str2, thingRuleAwayMode);
    }

    @Override // com.tplink.iot.c.b.j
    public io.reactivex.a W(String str, String str2, SubThingQuickSetupInfoListParams subThingQuickSetupInfoListParams) {
        return this.g.W(str, str2, subThingQuickSetupInfoListParams);
    }

    @Override // com.tplink.iot.c.b.f
    public io.reactivex.a W0(String str, List<String> list, GroupInfo groupInfo) {
        return this.k.W0(str, list, groupInfo);
    }

    @Override // com.tplink.iot.c.b.j
    public q<com.google.gson.i> X0(String str, String str2) {
        return this.g.X0(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingSupportInfoResult> Z(String str, String str2, String str3) {
        return this.g.Z(str, str2, str3);
    }

    @Override // com.tplink.iot.c.b.j
    public q<List<ThingNextEvent>> Z0(String str, String str2) {
        return this.g.Z0(str, str2);
    }

    @Override // com.tplink.iot.c.b.d
    public q<CountryCodeListResult> a1(String str) {
        return this.h.a1(str);
    }

    @Override // com.tplink.iot.c.b.h
    public q<ShareDeviceListResult> b0(String str, int i, int i2, String str2, String str3, String str4) {
        return this.l.b0(str, i, i2, str2, str3, str4);
    }

    @Override // com.tplink.iot.c.b.i
    public io.reactivex.a c0(String str, String str2) {
        return this.f6087f.c0(str, str2);
    }

    @Override // com.tplink.iot.c.b.f
    public io.reactivex.a c1(String str, GroupInfo groupInfo) {
        return this.k.c1(str, groupInfo);
    }

    @Override // com.tplink.iot.c.b.h
    public io.reactivex.a d0(String str, DeviceUserRoleListParams deviceUserRoleListParams) {
        return this.l.d0(str, deviceUserRoleListParams);
    }

    @Override // com.tplink.iot.c.b.j
    public q<PageListResult<com.google.gson.i>> e0(String str, int i, int i2, String str2, String str3) {
        return this.g.e0(str, i, i2, str2, str3);
    }

    @Override // com.tplink.iot.c.b.j
    public io.reactivex.a f1(String str, String str2) {
        return this.g.f1(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleListResult<ThingRuleSchedule>> g0(String str, String str2, int i) {
        return this.g.g0(str, str2, i);
    }

    @Override // com.tplink.iot.c.b.b
    public q<AuthResult> g1(String str, AuthParams authParams) {
        return this.f6085d.g1(str, authParams);
    }

    @Override // com.tplink.iot.c.b.j
    public io.reactivex.a h(String str, String str2, SubThingAddListParams subThingAddListParams) {
        return this.g.h(str, str2, subThingAddListParams);
    }

    @Override // com.tplink.iot.c.b.i
    public q<PageListResult<SmartInfo>> h0(String str, int i, int i2) {
        return this.f6087f.h0(str, i, i2);
    }

    @Override // com.tplink.iot.c.b.d
    public q<DeviceIdListResult> h1(String str, DeviceTypeParams deviceTypeParams) {
        return this.h.h1(str, deviceTypeParams);
    }

    @Override // com.tplink.iot.c.b.j
    public q<com.google.gson.i> i0(String str, String str2, String str3, com.google.gson.i iVar) {
        return this.g.i0(str, str2, str3, iVar);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingEventLogResult> j(String str, String str2, Long l, Long l2, int i, String str3, String str4) {
        return this.g.j(str, str2, l, l2, i, str3, str4);
    }

    @Override // com.tplink.iot.c.b.e
    public q<PageListResult<FamilyInfo>> j0(String str, int i, int i2) {
        return this.f6086e.j0(str, i, i2);
    }

    @Override // com.tplink.iot.c.b.h
    public q<DeviceShareLaunchResult> k(String str, DeviceShareListParams deviceShareListParams) {
        return this.l.k(str, deviceShareListParams);
    }

    @Override // com.tplink.iot.c.b.i
    public io.reactivex.a k1(String str, SmartInfo smartInfo) {
        return this.f6087f.k1(str, smartInfo);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingServiceSyncResult> l(String str, String str2, ThingServiceParams thingServiceParams) {
        return this.g.l(str, str2, thingServiceParams);
    }

    @Override // com.tplink.iot.c.b.j
    public q<NextEvent> l1(String str, String str2) {
        return this.g.l1(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleUpdateResult> m(String str, String str2, String str3, ThingRuleSchedule thingRuleSchedule) {
        return this.g.m(str, str2, str3, thingRuleSchedule);
    }

    @Override // com.tplink.iot.c.b.e
    public q<FamilyInfo> m0(String str, FamilyInfo familyInfo) {
        return this.f6086e.m0(str, familyInfo);
    }

    @Override // com.tplink.iot.c.b.j
    public q<com.google.gson.i> m1(String str, ThingLightingEffectParams thingLightingEffectParams) {
        return this.g.m1(str, thingLightingEffectParams);
    }

    @Override // com.tplink.iot.c.b.d
    public q<DeviceVideoDateResult<HasVideoTime>> n(String str, String str2, String str3, String str4) {
        return this.h.n(str, str2, str3, str4);
    }

    @Override // com.tplink.iot.c.b.g
    public io.reactivex.a n0(String str, IoTSubscribeMsgParams ioTSubscribeMsgParams) {
        return this.m.n0(str, ioTSubscribeMsgParams);
    }

    @Override // com.tplink.iot.c.b.c
    public q<VerifyReceiptResult> n1(String str, ReceiptParams receiptParams) {
        return this.j.n1(str, receiptParams);
    }

    @Override // com.tplink.iot.c.b.i
    public q<PageListResult<SmartLog>> o(String str, int i, int i2, Integer num, Integer num2) {
        return this.f6087f.o(str, i, i2, num, num2);
    }

    @Override // com.tplink.iot.c.b.d
    public q<DeviceOrderListResult<DeviceCloudProduct>> o0(String str, String str2, int i, int i2) {
        return this.h.o0(str, str2, i, i2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleUpdateResult> p0(String str, String str2, String str3, ThingRuleGuardMode thingRuleGuardMode) {
        return this.g.p0(str, str2, str3, thingRuleGuardMode);
    }

    @Override // com.tplink.iot.c.b.c
    public q<JudgeReceiptResult> q(String str, ReceiptParams receiptParams) {
        return this.j.q(str, receiptParams);
    }

    @Override // com.tplink.iot.c.b.j
    public io.reactivex.a q0(String str, String str2) {
        return this.g.q0(str, str2);
    }

    @Override // com.tplink.iot.c.b.d
    public q<CloudVideoPageListResult<CloudVideo>> q1(String str, String str2, int i, int i2, String str3, String str4, String str5, String str6) {
        return this.h.q1(str, str2, i, i2, str3, str4, str5, str6);
    }

    @Override // com.tplink.iot.c.b.e
    public io.reactivex.a r0(String str, String str2, RoomOrderInfo roomOrderInfo) {
        return this.f6086e.r0(str, str2, roomOrderInfo);
    }

    @Override // com.tplink.iot.c.b.j
    public q<PageListResult<com.google.gson.i>> r1(String str, int i, int i2, String str2, String str3) {
        return this.g.r1(str, i, i2, str2, str3);
    }

    @Override // com.tplink.iot.c.b.j
    public io.reactivex.a s0(String str, String str2, ThingSetting thingSetting) {
        return this.g.s0(str, str2, thingSetting);
    }

    @Override // com.tplink.iot.c.b.j
    public q<PageListResult<ThingInfo>> t(String str, int i, int i2, String str2) {
        return this.g.t(str, i, i2, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingComponentResult> t0(String str, String str2) {
        return this.g.t0(str, str2);
    }

    @Override // com.tplink.iot.c.b.h
    public q<DeviceShareActionHandleListResult> u(String str, DeviceShareActionListParams deviceShareActionListParams) {
        return this.l.u(str, deviceShareActionListParams);
    }

    @Override // com.tplink.iot.c.b.c
    public q<ProductListResult> u0(String str) {
        return this.j.u0(str);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleUpdateResult> u1(String str, String str2, String str3, ThingRuleTimer thingRuleTimer) {
        return this.g.u1(str, str2, str3, thingRuleTimer);
    }

    @Override // com.tplink.iot.c.b.e
    public io.reactivex.a v0(String str, String str2, FamilyCommonOrderParams familyCommonOrderParams) {
        return this.f6086e.v0(str, str2, familyCommonOrderParams);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingModel> v1(String str, String str2) {
        return this.g.v1(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleListResult<ThingRuleAwayMode>> w(String str, String str2, int i) {
        return this.g.w(str, str2, i);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleUpdateResult> w0(String str, String str2, ThingRuleTimer thingRuleTimer) {
        return this.g.w0(str, str2, thingRuleTimer);
    }

    @Override // com.tplink.iot.c.b.i
    public io.reactivex.a w1(String str) {
        return this.f6087f.w1(str);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRealTimeInfo> x(String str, String str2) {
        return this.g.x(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingUsage> x0(String str, String str2) {
        return this.g.x0(str, str2);
    }

    @Override // com.tplink.iot.c.b.j
    public io.reactivex.a y0(String str, String str2, SubThingCategoryScanParams subThingCategoryScanParams) {
        return this.g.y0(str, str2, subThingCategoryScanParams);
    }

    @Override // com.tplink.iot.c.b.e
    public io.reactivex.a y1(String str, String str2, String str3) {
        return this.f6086e.y1(str, str2, str3);
    }

    @Override // com.tplink.iot.c.b.j
    public q<ThingRuleListResult<ThingRuleGuardMode>> z(String str, String str2, int i) {
        return this.g.z(str, str2, i);
    }

    @Override // com.tplink.iot.c.b.h
    public q<DeviceUserListResult> z1(String str, String str2, boolean z) {
        return this.l.z1(str, str2, z);
    }
}
