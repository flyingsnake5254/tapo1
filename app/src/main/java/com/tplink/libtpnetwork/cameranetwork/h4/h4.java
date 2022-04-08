package com.tplink.libtpnetwork.cameranetwork.h4;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.cameranetwork.model.AESEncryptKey;
import com.tplink.libtpnetwork.cameranetwork.model.Account;
import com.tplink.libtpnetwork.cameranetwork.model.AccountInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmMultiInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AudioInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AutoUpdateInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BabyCryingDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BindStatus;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.CameraInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ClockStatus;
import com.tplink.libtpnetwork.cameranetwork.model.ClockTimezoneDstStatus;
import com.tplink.libtpnetwork.cameranetwork.model.ClockTimezoneInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceMoveInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerracePoint;
import com.tplink.libtpnetwork.cameranetwork.model.CloudTerraceResetInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ConnectResult;
import com.tplink.libtpnetwork.cameranetwork.model.ConnectStatus;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfigInfo;
import com.tplink.libtpnetwork.cameranetwork.model.CoverConfigRegion;
import com.tplink.libtpnetwork.cameranetwork.model.DailyPlaybackItem;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionList;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionSetting;
import com.tplink.libtpnetwork.cameranetwork.model.DiagnoseStatus;
import com.tplink.libtpnetwork.cameranetwork.model.DstInfo;
import com.tplink.libtpnetwork.cameranetwork.model.FirmwareUpdateStatus;
import com.tplink.libtpnetwork.cameranetwork.model.HomePageDeviceInfo;
import com.tplink.libtpnetwork.cameranetwork.model.HumanRecognitionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ImageFlip;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.LatestFirmwareInfo;
import com.tplink.libtpnetwork.cameranetwork.model.LensMaskInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Light;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MarkPositionConfirmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MarkedPositionListInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Method;
import com.tplink.libtpnetwork.cameranetwork.model.MicroPhoneInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Model;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.NetworkInfo;
import com.tplink.libtpnetwork.cameranetwork.model.NightMode;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionMode;
import com.tplink.libtpnetwork.cameranetwork.model.OsdConfig;
import com.tplink.libtpnetwork.cameranetwork.model.P2PSharePwd;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RecordAudioInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.ResetSupportInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardFormatProgress;
import com.tplink.libtpnetwork.cameranetwork.model.ServiceList;
import com.tplink.libtpnetwork.cameranetwork.model.SettingComposite;
import com.tplink.libtpnetwork.cameranetwork.model.SettingCompositeV2;
import com.tplink.libtpnetwork.cameranetwork.model.SpeakerInfo;
import com.tplink.libtpnetwork.cameranetwork.model.StartUpdateFirmwareInfo;
import com.tplink.libtpnetwork.cameranetwork.model.SystemInfo;
import com.tplink.libtpnetwork.cameranetwork.model.TamperDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.TargetTrackInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Timezone;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpCommStatus;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpInfo;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpMultiInfo;
import com.tplink.libtpnetwork.cameranetwork.model.UpnpPsk;
import com.tplink.libtpnetwork.cameranetwork.model.VideoQuality;
import com.tplink.libtpnetwork.cameranetwork.model.VodUserId;
import com.tplink.libtpnetwork.cameranetwork.model.Wan;
import com.tplink.libtpnetwork.cameranetwork.model.WhiteLampConfig;
import com.tplink.libtpnetwork.cameranetwork.model.WhitelampState;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import com.tplink.libtpnetwork.cameranetwork.model.WifiList;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import com.tplink.libtpnetwork.cameranetwork.model.YearlyPlaybackItem;
import io.reactivex.g0.c;
import io.reactivex.g0.j;
import io.reactivex.q;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: AbstractTransport.java */
/* loaded from: classes3.dex */
public abstract class h4 implements com.tplink.libtpnetwork.cameranetwork.net.a {
    protected boolean a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    protected final l4 f14757b = new l4();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractTransport.java */
    /* loaded from: classes3.dex */
    public class a implements c<Response, Response, Response> {
        a() {
        }

        /* renamed from: a */
        public Response apply(Response response, Response response2) throws Exception {
            return response2;
        }
    }

    /* compiled from: AbstractTransport.java */
    /* loaded from: classes3.dex */
    class b implements j<Response<Wrappers>, Response<UpnpPsk>> {
        b() {
        }

        /* renamed from: a */
        public Response<UpnpPsk> apply(@NonNull Response<Wrappers> response) throws Exception {
            if (response.getResult() == null || response.getResult().getWrapperList().size() <= 0 || response.getResult().getWrapperList().get(0).getData() == null) {
                return null;
            }
            return new Response<>(response.getErrorCode(), response.getMethod(), i.b(response.getResult().getWrapperList().get(0).getData().toString(), UpnpPsk.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Response F0(Response response) throws Exception {
        return response;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Response K2(Response response) throws Exception {
        return response;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Response L2(Response response) throws Exception {
        return response;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Response a1(List list) throws Exception {
        Iterator it = list.iterator();
        ClockStatus clockStatus = null;
        Timezone timezone = null;
        DstInfo dstInfo = null;
        while (it.hasNext()) {
            Response response = (Response) it.next();
            if (Method.GET_CLOCK_STATUS.getValue().equals(response.getMethod())) {
                clockStatus = (ClockStatus) Model.typeCast((Wrappers) response.getResult(), ClockStatus.class);
            } else if (Method.GET_TIMEZONE.getValue().equals(response.getMethod())) {
                timezone = (Timezone) Model.typeCast((Wrappers) response.getResult(), Timezone.class);
            } else if (Method.GET_DST_RULE.getValue().equals(response.getMethod())) {
                dstInfo = (DstInfo) Model.typeCast((Wrappers) response.getResult(), DstInfo.class);
            }
        }
        return new Response(0, Method.GET_CLOCK_STATUS.getValue(), new ClockTimezoneDstStatus(clockStatus, timezone, dstInfo));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Response b1(List list) throws Exception {
        Iterator it = list.iterator();
        ClockStatus clockStatus = null;
        Timezone timezone = null;
        while (it.hasNext()) {
            Response response = (Response) it.next();
            if (Method.GET_CLOCK_STATUS.getValue().equals(response.getMethod())) {
                clockStatus = (ClockStatus) Model.typeCast((Wrappers) response.getResult(), ClockStatus.class);
            } else if (Method.GET_TIMEZONE.getValue().equals(response.getMethod())) {
                timezone = (Timezone) Model.typeCast((Wrappers) response.getResult(), Timezone.class);
            }
        }
        return new Response(0, Method.GET_CLOCK_STATUS.getValue(), new ClockTimezoneInfo(clockStatus, timezone));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Response g2(Response response) throws Exception {
        WifiList wifiList = (WifiList) Model.typeCast((Wrappers) response.getResult(), WifiList.class);
        if (wifiList == null) {
            wifiList = new WifiList(false, Collections.emptyList());
        }
        return response.repack(wifiList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean n1(Response response) throws Exception {
        return response.getResult() != null;
    }

    public q<Response<ClockTimezoneInfo>> A() {
        return c3(this.f14757b.M()).Z0().n().g0(f2.f14744c);
    }

    public q<Response> A3(ArmScheduleInfo armScheduleInfo) {
        return c3(this.f14757b.k1(armScheduleInfo)).Q0(1L).g0(x0.f14893c);
    }

    public q<Response<MarkedPositionListInfo>> B() {
        return c3(this.f14757b.N()).Q0(1L).g0(n.f14790c);
    }

    public q<Response> B3(boolean z) {
        return c3(this.f14757b.m1(z)).Q0(1L).g0(z.f14902c);
    }

    public q<Response<CameraComponent>> C() {
        return c3(this.f14757b.O()).Q0(1L).g0(d1.f14733c);
    }

    public q<Response> C3(String str) {
        return e3(this.f14757b.l1(str)).g0(i1.f14762c);
    }

    public q<Response<ConnectStatus>> D() {
        return e3(this.f14757b.P()).g0(w.f14887c);
    }

    public q<Response> D3(String str) {
        return c3(this.f14757b.n1(str)).Q0(1L).g0(l0.f14778c);
    }

    public q<Response<CoverConfigInfo>> E() {
        return c3(this.f14757b.Q()).Q0(1L).g0(w3.f14891c);
    }

    public q<Response> E3(LensMaskInfo lensMaskInfo) {
        return c3(this.f14757b.o1(lensMaskInfo)).Q0(1L).g0(d0.f14732c);
    }

    public q<Response<List<DailyPlaybackItem>>> F(int i, String str, int i2, int i3) {
        return c3(this.f14757b.R(i, str, i2, i3)).Q0(1L).g0(f.f14741c);
    }

    public q<Response> F3(LensMaskInfo lensMaskInfo) {
        return c3(this.f14757b.p1(lensMaskInfo)).Q0(1L).g0(q2.f14860c);
    }

    public q<Response<List<DailyPlaybackItem>>> G(int i, long j, long j2, int i2, int i3) {
        return c3(this.f14757b.S(i, j, j2, i2, i3)).Q0(1L).g0(t2.f14875c);
    }

    public q<Response> G3(String str) {
        return c3(this.f14757b.q1(str)).Q0(1L).g0(o3.f14810c);
    }

    public q<Response<DetectionSetting>> H(CameraComponent cameraComponent) {
        return d3(this.f14757b.T(cameraComponent)).g0(r2.f14865c);
    }

    public q<Response> H3(DetectionInfo detectionInfo) {
        return c3(this.f14757b.r1(detectionInfo)).Q0(1L).g0(f3.f14745c);
    }

    public q<Response<CameraInfo>> I() {
        return c3(this.f14757b.U()).Q0(1L).g0(i.f14760c);
    }

    public q<Response> I3(ArmScheduleInfo armScheduleInfo) {
        return c3(this.f14757b.s1(armScheduleInfo)).Q0(1L).g0(f0.f14742c);
    }

    public q<Response<SystemInfo>> J() {
        return c3(this.f14757b.V()).Q0(1L).g0(j1.f14767c);
    }

    public q<Response> J3(boolean z) {
        return c3(this.f14757b.t1(z)).Q0(1L).g0(d3.f14735c);
    }

    public q<Response<DiagnoseStatus>> K() {
        return c3(this.f14757b.s()).Q0(1L).g0(k1.f14774c);
    }

    public q<Response> K3(MicroPhoneInfo microPhoneInfo) {
        return c3(this.f14757b.u1(microPhoneInfo)).Q0(1L).g0(i3.f14764c);
    }

    public q<Response<LatestFirmwareInfo>> L() {
        return c3(this.f14757b.W()).g0(b4.f14725c).L(h3.f14756c);
    }

    public q<Response> L3(MsgPushInfo msgPushInfo) {
        return c3(this.f14757b.v1(msgPushInfo)).Q0(1L).g0(m.f14782c);
    }

    public q<Response<FirmwareUpdateStatus>> M() {
        return c3(this.f14757b.X()).Q0(1L).g0(i0.f14761c);
    }

    public q<Response> M3(MsgPushPlanInfo msgPushPlanInfo) {
        return c3(this.f14757b.w1(msgPushPlanInfo)).Q0(1L).g0(g3.f14750c);
    }

    public q<Response<ImageFlip>> N() {
        return c3(this.f14757b.Y()).Q0(1L).g0(u2.f14880c);
    }

    public q<Response> N3(NightMode nightMode) {
        return c3(this.f14757b.x1(nightMode)).Q0(1L).g0(t1.f14874c);
    }

    public q<Response<HomePageDeviceInfo>> O() {
        return d3(this.f14757b.Z()).g0(r0.f14863c);
    }

    public q<Response> O3(NightVisionMode nightVisionMode) {
        return c3(this.f14757b.y1(nightVisionMode)).Q0(1L).g0(y2.f14900c);
    }

    public q<Response<IntrusionDetectionInfo>> P() {
        return c3(this.f14757b.a0()).Q0(1L).g0(p1.f14843c);
    }

    public q<Response> P3(boolean z, boolean z2, String str, boolean z3) {
        return c3(this.f14757b.z1(z, z2, str, z3)).Q0(1L).g0(k2.f14775c);
    }

    public q<Response<List<Map<String, IntrusionDetectionRegion>>>> Q() {
        return c3(this.f14757b.b0()).Q0(1L).g0(t.f14872c);
    }

    public q<Response> Q3(boolean z) {
        return c3(this.f14757b.A1(z)).Q0(1L).g0(o2.f14809c);
    }

    public q<Response<Wan>> R() {
        return c3(this.f14757b.c0()).Q0(1L).g0(x3.f14896c);
    }

    public q<Response> R3(RebootInfo rebootInfo) {
        return c3(this.f14757b.B1(rebootInfo)).Q0(1L).g0(e0.f14737c);
    }

    public q<Response<ImageFlip>> S() {
        return c3(this.f14757b.e0()).Q0(1L).g0(o.f14806c);
    }

    public q<Response> S3(boolean z) {
        return c3(this.f14757b.C1(z)).Q0(1L).g0(c0.f14727c);
    }

    public q<Response<AlarmMultiInfo>> T(CameraComponent cameraComponent) {
        return d3(this.f14757b.d0(cameraComponent)).g0(m3.f14786c);
    }

    public q<Response> T3(RecordPlanInfo recordPlanInfo) {
        return c3(this.f14757b.D1(recordPlanInfo)).Q0(1L).g0(t3.f14876c);
    }

    public q<Response<LensMaskInfo>> U() {
        return c3(this.f14757b.f0()).Q0(1L).g0(s1.f14869c);
    }

    public q<Response> U3(ResolutionType resolutionType) {
        return c3(this.f14757b.E1(resolutionType)).Q0(1L).g0(a2.f14717c);
    }

    public q<Response<Light>> V() {
        return c3(this.f14757b.g0()).Q0(1L).g0(x.f14892c);
    }

    public q<Response> V3(SpeakerInfo speakerInfo) {
        return c3(this.f14757b.F1(speakerInfo)).Q0(1L).g0(q1.f14859c);
    }

    public q<Response<LineCrossingDetectionInfo>> W() {
        return c3(this.f14757b.h0()).Q0(1L).g0(b2.f14723c);
    }

    public q<Response> W3(TamperDetectConfig tamperDetectConfig) {
        return c3(this.f14757b.G1(tamperDetectConfig)).Q0(1L).g0(q0.f14858c);
    }

    public q<Response<List<Map<String, LineCrossingDetectionRegion>>>> X() {
        return c3(this.f14757b.i0()).Q0(1L).g0(h.f14752c);
    }

    public q<Response> X3(boolean z) {
        return c3(this.f14757b.H1(z)).g0(u3.f14881c);
    }

    public q<Response<VideoQuality>> Y() {
        return c3(this.f14757b.j0()).Q0(1L).g0(y.f14897c);
    }

    public q<Response> Y3(String str, String str2) {
        return c3(this.f14757b.I1(str, str2)).Q0(1L).g0(z0.f14903c);
    }

    public q<Response<MotionDetectionInfo>> Z() {
        return c3(this.f14757b.k0()).Q0(1L).g0(g0.f14747c);
    }

    public q<Response> Z3(UpnpCommStatus upnpCommStatus) {
        return c3(this.f14757b.J1(upnpCommStatus)).Q0(1L).g0(z1.f14904c);
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.net.a
    public q<Response<List<YearlyPlaybackItem>>> a(Date date, Date date2) {
        return c3(this.f14757b.M0(date, date2)).Q0(1L).g0(p.f14841c);
    }

    public q<Response<MsgPushInfo>> a0() {
        return c3(this.f14757b.l0()).Q0(1L).g0(e3.f14740c);
    }

    public q<Response> a4(UpnpInfo upnpInfo) {
        return c3(this.f14757b.K1(upnpInfo)).Q0(1L).g0(s.f14867c);
    }

    public q<Response<MarkPositionConfirmInfo>> b(CloudTerracePoint cloudTerracePoint) {
        return c3(this.f14757b.w(cloudTerracePoint)).Q0(1L).g0(l.f14777c);
    }

    public q<Response<MsgPushPlanInfo>> b0() {
        return c3(this.f14757b.m0()).Q0(1L).g0(s3.f14871c);
    }

    public q<Response> b4(WhiteLampConfig whiteLampConfig) {
        return c3(this.f14757b.L1(whiteLampConfig)).Q0(1L).g0(z2.f14905c);
    }

    public q<Response> c(List<CoverConfigRegion> list) {
        return c3(this.f14757b.l(list)).Q0(1L).g0(r1.f14864c);
    }

    public q<Response<NetworkInfo>> c0() {
        return c3(this.f14757b.n0()).Q0(1L).g0(r.f14862c);
    }

    protected abstract q<Response<Wrappers>> c3(Request<MultipleRequest> request);

    public q<Response<BindStatus>> c4(Account account, String str, String str2, String str3, RecordPlanInfo recordPlanInfo) {
        return c3(this.f14757b.M1(account, str, str2, str3, recordPlanInfo)).g0(a4.f14719c);
    }

    public q<Response> d(Map<String, List<IntrusionDetectionRegion>> map) {
        return c3(this.f14757b.m(map)).Q0(1L).g0(l3.f14781c);
    }

    public q<Response<OsdConfig>> d0(boolean z) {
        return c3(this.f14757b.o0(z)).Q0(1L).g0(v2.f14885c);
    }

    protected abstract q<Response<MultipleResponse>> d3(Request<MultipleRequest> request);

    public q<Response<BindStatus>> d4(Account account, String str, String str2, RecordPlanInfo recordPlanInfo) {
        return c3(this.f14757b.N1(account, str, str2, recordPlanInfo)).g0(a3.f14718c);
    }

    public q<Response> e(Map<String, List<LineCrossingDetectionRegion>> map) {
        return c3(this.f14757b.n(map)).Q0(1L).g0(y0.f14898c);
    }

    public q<Response<P2PSharePwd>> e0() {
        return c3(this.f14757b.p0()).Q0(1L).g0(d.f14731c);
    }

    protected abstract q<Response<Wrappers>> e3(Request request);

    public q<Response> e4() {
        return c3(this.f14757b.O1()).Q0(1L).g0(x2.f14895c);
    }

    public q<Response> f(List<MotionDetectRegion> list) {
        return c3(this.f14757b.o(list)).Q0(1L).g0(c1.f14728c);
    }

    public q<Response<RebootInfo>> f0() {
        return c3(this.f14757b.q0()).Q0(1L).g0(m0.f14783c);
    }

    public q<Response> f3() {
        return c3(this.f14757b.R0()).Q0(1L).g0(e2.f14739c);
    }

    public q<Response> f4() {
        return c3(this.f14757b.R1()).Q0(1L).g0(h2.f14755c);
    }

    public q<Response<?>> g(String str, String str2) {
        return c3(this.f14757b.p(str, str2)).Q0(1L).g0(v.f14882c);
    }

    public q<Response<RecordAudioInfo>> g0() {
        return c3(this.f14757b.r0()).Q0(1L).g0(l1.f14779c);
    }

    public q<Response> g3(CloudTerraceResetInfo cloudTerraceResetInfo) {
        return c3(this.f14757b.C(cloudTerraceResetInfo)).Q0(1L).g0(v1.f14884c);
    }

    public q<Response> g4(String str, String str2) {
        return c3(this.f14757b.S1(str, str2)).Q0(1L).g0(v0.f14883c);
    }

    @SuppressLint({"CheckResult"})
    public q<Response> h(MotionDetectConfig motionDetectConfig, AlarmInfo alarmInfo, MsgPushInfo msgPushInfo, DetectionInfo detectionInfo, DetectionInfo detectionInfo2, TamperDetectConfig tamperDetectConfig, HumanRecognitionInfo humanRecognitionInfo, BabyCryingDetectionInfo babyCryingDetectionInfo, TargetTrackInfo targetTrackInfo) {
        List<Request<Wrappers>> t0 = this.f14757b.t0(motionDetectConfig, alarmInfo, msgPushInfo, detectionInfo, detectionInfo2, tamperDetectConfig, humanRecognitionInfo, babyCryingDetectionInfo, targetTrackInfo);
        int size = t0.size();
        if (size <= 5) {
            return c3(this.f14757b.Q0(t0)).g0(p0.f14842c);
        }
        return q.f1(c3(this.f14757b.Q0(t0.subList(0, 5))).g0(p2.f14844c), c3(this.f14757b.Q0(t0.subList(5, size))).g0(m1.f14784c), new a());
    }

    public q<Response<RecordPlanInfo>> h0() {
        return c3(this.f14757b.s0()).Q0(1L).g0(c.f14726c);
    }

    public q<Response> h3() {
        return c3(this.f14757b.S0()).Q0(1L).g0(n3.f14794c);
    }

    public q<Response> i(AlarmPlanInfo alarmPlanInfo, MsgPushPlanInfo msgPushPlanInfo, ArmScheduleInfo armScheduleInfo, ArmScheduleInfo armScheduleInfo2) {
        return c3(this.f14757b.u0(alarmPlanInfo, msgPushPlanInfo, armScheduleInfo, armScheduleInfo2)).g0(s2.f14870c);
    }

    public q<Response<SettingComposite>> i0() {
        return d3(this.f14757b.w0()).g0(c3.f14730c);
    }

    public q<Response> i3() {
        return c3(this.f14757b.B()).Q0(1L).g0(f1.f14743c);
    }

    public q<Response> j(List<MotionDetectRegion> list, Map<String, List<IntrusionDetectionRegion>> map, HashMap<String, List<LineCrossingDetectionRegion>> hashMap) {
        return c3(this.f14757b.v0(list, map, hashMap)).g0(y3.f14901c);
    }

    public q<Response<SdCardFormatProgress>> j0() {
        return c3(this.f14757b.x0()).Q0(1L).g0(m2.f14785c);
    }

    public q<Response> j3() {
        return c3(this.f14757b.T0()).Q0(1L).g0(s0.f14868c);
    }

    public q<Response> k(MotionDetectConfig motionDetectConfig) {
        return c3(this.f14757b.q(motionDetectConfig)).Q0(1L).g0(n2.f14793c);
    }

    public q<Response<SettingComposite>> k0() {
        return d3(this.f14757b.y0()).g0(b1.f14722c);
    }

    public q<Response<WifiList>> k3() {
        return e3(this.f14757b.U0()).g0(d2.f14734c);
    }

    public q<Response> l(String str, String str2) {
        return c3(this.f14757b.r(str, str2)).Q0(1L).g0(j.f14765c);
    }

    public q<Response<ServiceList>> l0() {
        return c3(this.f14757b.z0()).Q0(1L).g0(j0.f14766c);
    }

    public q<Response> l3(AlarmInfo alarmInfo) {
        return c3(this.f14757b.V0(alarmInfo)).Q0(1L).g0(h0.f14753c);
    }

    public q<Response<ResetSupportInfo>> m() {
        return c3(this.f14757b.t()).Q0(1L).g0(j2.f14768c);
    }

    public q<Response<SettingComposite>> m0(CameraComponent cameraComponent) {
        return d3(this.f14757b.A0(cameraComponent)).g0(o1.f14808c);
    }

    public q<Response> m3(AlarmPlanInfo alarmPlanInfo) {
        return c3(this.f14757b.W0(alarmPlanInfo)).Q0(1L).g0(y1.f14899c);
    }

    public q<Response> n(boolean z) {
        return c3(this.f14757b.x(z)).Q0(1L).g0(k.f14772c);
    }

    public q<Response<SettingCompositeV2>> n0(CameraComponent cameraComponent) {
        return d3(this.f14757b.B0(cameraComponent)).g0(q3.f14861c);
    }

    public q<Response> n3(AutoUpdateInfo autoUpdateInfo) {
        return c3(this.f14757b.X0(autoUpdateInfo)).Q0(1L).g0(a1.f14716c);
    }

    public q<Response> o() {
        return c3(this.f14757b.Q1()).Q0(1L).g0(w2.f14890c);
    }

    public q<Response<DetectionList>> o0(long j, long j2, int i, int i2) {
        return c3(this.f14757b.C0(j, j2, i, i2)).Q0(1L).g0(x1.f14894c);
    }

    public void o3(boolean z) {
        this.a = z;
    }

    public q<Response> p(CloudTerraceMoveInfo cloudTerraceMoveInfo) {
        return c3(this.f14757b.y(cloudTerraceMoveInfo)).Q0(1L).g0(u0.f14878c);
    }

    public q<Response<TamperDetectConfig>> p0() {
        return c3(this.f14757b.D0()).Q0(1L).g0(z3.f14906c);
    }

    public q<Response> p3(boolean z, String str) {
        return c3(this.f14757b.Y0(z, str)).g0(l2.f14780c);
    }

    public q<Response> q(String str) {
        return c3(this.f14757b.z(str)).Q0(1L).g0(c2.f14729c);
    }

    public q<Response<TargetTrackInfo>> q0() {
        return c3(this.f14757b.E0()).Q0(1L).g0(a0.f14715c);
    }

    public q<Response> q3(String str) {
        return e3(this.f14757b.Z0(str)).g0(a.f14714c);
    }

    public q<Response<ConnectResult>> r(Wifi wifi) {
        return e3(this.f14757b.v(wifi)).g0(p3.f14845c);
    }

    public q<Response<AccountInfo>> r0() {
        return c3(this.f14757b.F0()).Q0(1L).g0(g1.f14748c);
    }

    public q<Response> r3(boolean z) {
        return c3(this.f14757b.b1(z)).Q0(1L).g0(w0.f14888c);
    }

    public q<Response<StartUpdateFirmwareInfo>> s() {
        return c3(this.f14757b.P1()).Q0(1L).g0(k3.f14776c);
    }

    public q<Response<Timezone>> s0() {
        return c3(this.f14757b.G0()).Q0(1L).g0(b0.f14721c);
    }

    public q<Response> s3(String str) {
        return c3(this.f14757b.c1(str)).Q0(1L).g0(h1.f14754c);
    }

    public q<Response> t() {
        return c3(this.f14757b.D()).Q0(1L).g0(q.f14857c);
    }

    public q<Response<UpnpInfo>> t0() {
        return c3(this.f14757b.H0()).Q0(1L).g0(g2.f14749c);
    }

    public q<Response> t3(String str, String str2) {
        return c3(this.f14757b.d1(str, str2)).g0(j3.f14769c);
    }

    public q<Response<AESEncryptKey>> u() {
        return c3(this.f14757b.G()).Q0(1L).g0(t0.f14873c);
    }

    public q<Response<UpnpMultiInfo>> u0() {
        return d3(this.f14757b.I0()).g0(o0.f14807c);
    }

    public q<Response> u3(String str) {
        return c3(this.f14757b.e1(str)).Q0(1L).g0(k0.f14773c);
    }

    public q<Response<AlarmInfo>> v() {
        return c3(this.f14757b.I()).Q0(1L).g0(r3.f14866c);
    }

    public q<Response<UpnpPsk>> v0() {
        return c3(this.f14757b.J0()).Q0(1L).g0(new b());
    }

    public q<Response> v3(boolean z) {
        return c3(this.f14757b.f1(z)).Q0(1L).g0(b3.f14724c);
    }

    public q<Response<AlarmPlanInfo>> w() {
        return c3(this.f14757b.H()).Q0(1L).g0(g.f14746c);
    }

    public q<Response<VodUserId>> w0() {
        return c3(this.f14757b.K0()).Q0(1L).g0(v3.f14886c);
    }

    public q<Response> w3(WhitelampState whitelampState) {
        return c3(this.f14757b.g1(whitelampState)).Q0(1L).g0(e1.f14738c);
    }

    public q<Response<AudioInfo>> x() {
        return c3(this.f14757b.J()).Q0(1L).g0(n1.f14792c);
    }

    public q<Response<ImageFlip>> x0() {
        return c3(this.f14757b.L0()).Q0(1L).g0(u1.f14879c);
    }

    public q<Response> x3(boolean z) {
        return c3(this.f14757b.h1(z)).g0(w1.f14889c);
    }

    public q<Response<AutoUpdateInfo>> y() {
        return c3(this.f14757b.K()).Q0(1L).g0(i2.f14763c);
    }

    public q<Response> y0(int i) {
        return c3(this.f14757b.A(i)).Q0(1L).g0(n0.f14791c);
    }

    public q<Response> y3(boolean z) {
        return c3(this.f14757b.i1(z)).Q0(1L).g0(e.f14736c);
    }

    public q<Response<ClockTimezoneDstStatus>> z() {
        return c3(this.f14757b.L()).Z0().n().g0(b.f14720c);
    }

    public boolean z0() {
        return this.a;
    }

    public q<Response> z3(DetectionInfo detectionInfo) {
        return c3(this.f14757b.j1(detectionInfo)).Q0(1L).g0(u.f14877c);
    }
}
