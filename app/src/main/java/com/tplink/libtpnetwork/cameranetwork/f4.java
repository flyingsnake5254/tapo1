package com.tplink.libtpnetwork.cameranetwork;

import androidx.annotation.NonNull;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceBean;
import com.tplink.libtpnetwork.Utils.z;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.common.EnumCameraTransportType;
import com.tplink.libtpnetwork.cameranetwork.h4.h4;
import com.tplink.libtpnetwork.cameranetwork.h4.i4;
import com.tplink.libtpnetwork.cameranetwork.h4.n4.b;
import com.tplink.libtpnetwork.cameranetwork.h4.n4.d;
import com.tplink.libtpnetwork.cameranetwork.h4.o4.s;
import com.tplink.libtpnetwork.cameranetwork.h4.o4.u;
import com.tplink.libtpnetwork.cameranetwork.h4.p4.e;
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
import com.tplink.libtpnetwork.cameranetwork.model.MicroPhoneInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.NetworkInfo;
import com.tplink.libtpnetwork.cameranetwork.model.NightMode;
import com.tplink.libtpnetwork.cameranetwork.model.NightVisionMode;
import com.tplink.libtpnetwork.cameranetwork.model.OsdConfig;
import com.tplink.libtpnetwork.cameranetwork.model.P2PSharePwd;
import com.tplink.libtpnetwork.cameranetwork.model.RebootInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RecordAudioInfo;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
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
import com.tplink.libtpnetwork.cameranetwork.model.YearlyPlaybackItem;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ResponseBody;

/* compiled from: TPCameraClient.java */
/* loaded from: classes3.dex */
public class f4 implements com.tplink.libtpnetwork.cameranetwork.net.a {
    private s a;

    /* renamed from: b  reason: collision with root package name */
    private e f14687b;

    /* renamed from: c  reason: collision with root package name */
    private b f14688c;

    /* renamed from: d  reason: collision with root package name */
    private g<Boolean> f14689d = io.reactivex.m0.b.n1().l1();

    /* renamed from: e  reason: collision with root package name */
    private TPCameraDeviceContext f14690e;

    /* renamed from: f  reason: collision with root package name */
    private c f14691f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TPCameraClient.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumCameraTransportType.values().length];
            a = iArr;
            try {
                iArr[EnumCameraTransportType.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumCameraTransportType.REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumCameraTransportType.IOT_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f4() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ t Q0(h4 h4Var) throws Exception {
        if (h4Var instanceof s) {
            return ((s) h4Var).m4();
        }
        return q.J(new UnsupportedOperationException("Unsupported in remote"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ t a1(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            return q.f0(Boolean.TRUE);
        }
        throw new Exception("NULL AVAILABLE CLIENT");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b1 */
    public /* synthetic */ h4 c1(EnumCameraTransportType enumCameraTransportType, Boolean bool) throws Exception {
        h4 k2 = k2(enumCameraTransportType);
        if (k2 != null) {
            return k2;
        }
        throw new Exception("NULL TRANSPORT");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ t f1(Account account, h4 h4Var) throws Exception {
        if (h4Var instanceof s) {
            return ((s) h4Var).S4(account);
        }
        return q.J(new UnsupportedOperationException("Unsupported in remote"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g1 */
    public /* synthetic */ void h1(TCAccountBean tCAccountBean, Response response) throws Exception {
        s sVar;
        if (!(response.getErrorCode() != 0 || (sVar = this.a) == null || sVar.n4() == null)) {
            u n4 = this.a.n4();
            n4.e(tCAccountBean.getPassword());
            this.a.W4(n4);
            this.a.U4();
        }
        b.d.w.c.a.e("BBBBBBB", "response " + response);
    }

    private void g3() {
        s sVar = this.a;
        if (sVar == null || !sVar.z0()) {
            b bVar = this.f14688c;
            if (bVar == null || !bVar.z0()) {
                e eVar = this.f14687b;
                if (eVar == null || !eVar.z0()) {
                    this.f14689d.onNext(Boolean.FALSE);
                } else {
                    this.f14689d.onNext(Boolean.TRUE);
                }
            } else {
                this.f14689d.onNext(Boolean.TRUE);
            }
        } else {
            this.f14689d.onNext(Boolean.TRUE);
        }
    }

    private h4 k2(EnumCameraTransportType enumCameraTransportType) {
        if (enumCameraTransportType == null) {
            s sVar = this.a;
            if (sVar != null && sVar.z0() && !this.a.T4()) {
                return this.a;
            }
            e eVar = this.f14687b;
            if (eVar == null || !eVar.z0()) {
                b bVar = this.f14688c;
                if (bVar == null || !bVar.z0()) {
                    return null;
                }
                return this.f14688c;
            }
            s sVar2 = this.a;
            if (sVar2 != null && sVar2.T4()) {
                e2();
            }
            return this.f14687b;
        } else if (enumCameraTransportType == EnumCameraTransportType.LOCAL) {
            s sVar3 = this.a;
            if (sVar3 == null || !sVar3.z0()) {
                return null;
            }
            return this.a;
        } else if (enumCameraTransportType == EnumCameraTransportType.REMOTE) {
            e eVar2 = this.f14687b;
            if (eVar2 == null || !eVar2.z0()) {
                return null;
            }
            return this.f14687b;
        } else if (enumCameraTransportType != EnumCameraTransportType.IOT_REMOTE) {
            return null;
        } else {
            b bVar2 = this.f14688c;
            if (bVar2 != null && bVar2.z0()) {
                return this.f14688c;
            }
            b bVar3 = this.f14688c;
            if (bVar3 == null) {
                return null;
            }
            bVar3.o3(true);
            return null;
        }
    }

    private q<h4> v0(final EnumCameraTransportType enumCameraTransportType) {
        return this.f14689d.Q0(1L).N(m1.f14939c).l0(io.reactivex.l0.a.c()).g0(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.t0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return f4.this.c1(enumCameraTransportType, (Boolean) obj);
            }
        }).T0(30L, TimeUnit.SECONDS);
    }

    public q<Response<AutoUpdateInfo>> A() {
        return v0(null).N(j.f14916c);
    }

    public q<Response<ImageFlip>> A0() {
        return v0(null).N(r.f14968c);
    }

    public q<Response> A2(final ArmScheduleInfo armScheduleInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.y2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t A3;
                A3 = ((h4) obj).A3(ArmScheduleInfo.this);
                return A3;
            }
        });
    }

    public q<Response<ClockTimezoneDstStatus>> B() {
        return v0(null).N(p3.f14961c);
    }

    public q<Response> B0(final int i) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.e0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t y0;
                y0 = ((h4) obj).y0(i);
                return y0;
            }
        });
    }

    public q<Response> B2(final boolean z) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.t2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t B3;
                B3 = ((h4) obj).B3(z);
                return B3;
            }
        });
    }

    public q<Response<ClockTimezoneInfo>> C() {
        return v0(null).N(z3.f15051c);
    }

    public q<Response> C2(final String str) {
        return v0(EnumCameraTransportType.LOCAL).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.q1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t C3;
                C3 = ((h4) obj).C3(str);
                return C3;
            }
        });
    }

    public q<Response<MarkedPositionListInfo>> D() {
        return v0(null).N(f3.f14686c);
    }

    public q<Response> D2(final String str) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.v2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t D3;
                D3 = ((h4) obj).D3(str);
                return D3;
            }
        });
    }

    public q<Response<CameraComponent>> E() {
        return v0(null).N(d3.f14674c);
    }

    public q<Response> E2(final LensMaskInfo lensMaskInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.n0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t E3;
                E3 = ((h4) obj).E3(LensMaskInfo.this);
                return E3;
            }
        });
    }

    public q<Response<ConnectStatus>> F() {
        return v0(EnumCameraTransportType.LOCAL).N(g3.f14696c);
    }

    public q<Response> F2(final LensMaskInfo lensMaskInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.p2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t F3;
                F3 = ((h4) obj).F3(LensMaskInfo.this);
                return F3;
            }
        });
    }

    public q<Response<CoverConfigInfo>> G() {
        return v0(null).N(w3.f15032c);
    }

    public q<Response> G2(final String str) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.m0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t G3;
                G3 = ((h4) obj).G3(str);
                return G3;
            }
        });
    }

    public q<Response<List<DailyPlaybackItem>>> H(final int i, final String str, final int i2, final int i3) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.j1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t F;
                F = ((h4) obj).F(i, str, i2, i3);
                return F;
            }
        });
    }

    public q<Response> H2(final DetectionInfo detectionInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.i0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t H3;
                H3 = ((h4) obj).H3(DetectionInfo.this);
                return H3;
            }
        });
    }

    public q<Response<List<DailyPlaybackItem>>> I(final int i, final long j, final long j2, final int i2, final int i3) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.i1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t G;
                G = ((h4) obj).G(i, j, j2, i2, i3);
                return G;
            }
        });
    }

    public q<Response> I2(final ArmScheduleInfo armScheduleInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.c2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t I3;
                I3 = ((h4) obj).I3(ArmScheduleInfo.this);
                return I3;
            }
        });
    }

    public q<Response<DetectionSetting>> J(final CameraComponent cameraComponent) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.d0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t H;
                H = ((h4) obj).H(CameraComponent.this);
                return H;
            }
        });
    }

    public q<Response> J2(final boolean z) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.p0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t J3;
                J3 = ((h4) obj).J3(z);
                return J3;
            }
        });
    }

    public q<Response<CameraInfo>> K() {
        return v0(null).N(l3.f14935c);
    }

    public q<Response> K2(final MicroPhoneInfo microPhoneInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.h1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t K3;
                K3 = ((h4) obj).K3(MicroPhoneInfo.this);
                return K3;
            }
        });
    }

    public q<Response<SystemInfo>> L() {
        return v0(null).N(b0.f14107c);
    }

    public q<Response> L2(final MsgPushInfo msgPushInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.l0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t L3;
                L3 = ((h4) obj).L3(MsgPushInfo.this);
                return L3;
            }
        });
    }

    public q<Response<DiagnoseStatus>> M() {
        return v0(null).N(j3.f14923c);
    }

    public q<Response> M2(final MsgPushPlanInfo msgPushPlanInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.x1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t M3;
                M3 = ((h4) obj).M3(MsgPushPlanInfo.this);
                return M3;
            }
        });
    }

    public q<Response<LatestFirmwareInfo>> N() {
        return v0(null).N(g.f14692c);
    }

    public q<Response> N2(final NightMode nightMode) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.k2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t N3;
                N3 = ((h4) obj).N3(NightMode.this);
                return N3;
            }
        });
    }

    public q<Response<FirmwareUpdateStatus>> O() {
        return v0(null).N(q.f14962c);
    }

    public q<Response> O2(final NightVisionMode nightVisionMode) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.u0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t O3;
                O3 = ((h4) obj).O3(NightVisionMode.this);
                return O3;
            }
        });
    }

    public q<Response<ImageFlip>> P() {
        return v0(null).N(e3.f14680c);
    }

    public q<Response> P2(final boolean z, final boolean z2, final String str, final boolean z3) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.z2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t P3;
                P3 = ((h4) obj).P3(z, z2, str, z3);
                return P3;
            }
        });
    }

    public q<Response<HomePageDeviceInfo>> Q() {
        return v0(null).N(d.f14670c);
    }

    public q<Response> Q2(final boolean z) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.l2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t Q3;
                Q3 = ((h4) obj).Q3(z);
                return Q3;
            }
        });
    }

    public q<Response<IntrusionDetectionInfo>> R() {
        return v0(null).N(k.f14924c);
    }

    public q<Response> R2(final RebootInfo rebootInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.h2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t R3;
                R3 = ((h4) obj).R3(RebootInfo.this);
                return R3;
            }
        });
    }

    public q<Response<List<Map<String, IntrusionDetectionRegion>>>> S() {
        return v0(null).N(q3.f14967c);
    }

    public q<Response> S2(final boolean z) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.g0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t S3;
                S3 = ((h4) obj).S3(z);
                return S3;
            }
        });
    }

    public q<Response<Wan>> T() {
        return v0(null).N(z.f15043c);
    }

    public q<Response> T2(final RecordPlanInfo recordPlanInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.r2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t T3;
                T3 = ((h4) obj).T3(RecordPlanInfo.this);
                return T3;
            }
        });
    }

    public q<Response<ImageFlip>> U() {
        return v0(null).N(n.f14942c);
    }

    public q<Response> U2(final ResolutionType resolutionType) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.g1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t U3;
                U3 = ((h4) obj).U3(ResolutionType.this);
                return U3;
            }
        });
    }

    public q<Response<AlarmMultiInfo>> V(final CameraComponent cameraComponent) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.p1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t T;
                T = ((h4) obj).T(CameraComponent.this);
                return T;
            }
        });
    }

    public q<Response> V2(final SpeakerInfo speakerInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.l1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t V3;
                V3 = ((h4) obj).V3(SpeakerInfo.this);
                return V3;
            }
        });
    }

    public q<Response<LensMaskInfo>> W() {
        return v0(null).N(e4.f14681c);
    }

    public q<Response> W2(final TamperDetectConfig tamperDetectConfig) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.y0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t W3;
                W3 = ((h4) obj).W3(TamperDetectConfig.this);
                return W3;
            }
        });
    }

    public q<Response<Light>> X() {
        return v0(null).N(a.f14099c);
    }

    public q<Response> X2(final boolean z) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.g2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t X3;
                X3 = ((h4) obj).X3(z);
                return X3;
            }
        });
    }

    public q<Response<LineCrossingDetectionInfo>> Y() {
        return v0(null).N(u3.f14989c);
    }

    public q<Response> Y2(final String str, final String str2) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.q0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t Y3;
                Y3 = ((h4) obj).Y3(str, str2);
                return Y3;
            }
        });
    }

    public q<Response<List<Map<String, LineCrossingDetectionRegion>>>> Z() {
        return v0(null).N(h3.f14713c);
    }

    public q<Response> Z2(final UpnpCommStatus upnpCommStatus) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.k0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t Z3;
                Z3 = ((h4) obj).Z3(UpnpCommStatus.this);
                return Z3;
            }
        });
    }

    @Override // com.tplink.libtpnetwork.cameranetwork.net.a
    public q<Response<List<YearlyPlaybackItem>>> a(final Date date, final Date date2) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.w1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t a2;
                a2 = ((h4) obj).a(date, date2);
                return a2;
            }
        });
    }

    public q<Response<VideoQuality>> a0() {
        return v0(null).N(u.f14984c);
    }

    public q<Response> a3(final UpnpInfo upnpInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.b1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t a4;
                a4 = ((h4) obj).a4(UpnpInfo.this);
                return a4;
            }
        });
    }

    public q<Response<MarkPositionConfirmInfo>> b(final CloudTerracePoint cloudTerracePoint) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.e1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t b2;
                b2 = ((h4) obj).b(CloudTerracePoint.this);
                return b2;
            }
        });
    }

    public q<Response<MotionDetectionInfo>> b0() {
        return v0(null).N(h.f14709c);
    }

    public q<Response> b3(final WhiteLampConfig whiteLampConfig) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.a1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t b4;
                b4 = ((h4) obj).b4(WhiteLampConfig.this);
                return b4;
            }
        });
    }

    public q<Response> c(final List<CoverConfigRegion> list) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.a2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t c2;
                c2 = ((h4) obj).c(list);
                return c2;
            }
        });
    }

    public q<Response<MsgPushInfo>> c0() {
        return v0(null).N(x3.f15037c);
    }

    public q<Response<BindStatus>> c3(final Account account, final String str, final String str2, final String str3, final RecordPlanInfo recordPlanInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.i2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t c4;
                c4 = ((h4) obj).c4(Account.this, str, str2, str3, recordPlanInfo);
                return c4;
            }
        });
    }

    public q<Response> d(final Map<String, List<IntrusionDetectionRegion>> map) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.f2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t d2;
                d2 = ((h4) obj).d(map);
                return d2;
            }
        });
    }

    public q<Response<MsgPushPlanInfo>> d0() {
        return v0(null).N(n3.f14948c);
    }

    public q<String> d2(final Account account) {
        return v0(EnumCameraTransportType.LOCAL).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.w2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return f4.f1(Account.this, (h4) obj);
            }
        });
    }

    public q<Response<BindStatus>> d3(final Account account, final String str, final String str2, final RecordPlanInfo recordPlanInfo) {
        return v0(EnumCameraTransportType.LOCAL).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.n2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t d4;
                d4 = ((h4) obj).d4(Account.this, str, str2, recordPlanInfo);
                return d4;
            }
        });
    }

    public q<Response> e(final Map<String, List<LineCrossingDetectionRegion>> map) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.z1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t e2;
                e2 = ((h4) obj).e(map);
                return e2;
            }
        });
    }

    public q<Response<NetworkInfo>> e0() {
        return v0(null).N(y3.f15042c);
    }

    public void e2() {
        if (this.f14690e.isOwner() && this.f14690e.getTcAccountContext() != null && this.f14690e.getTcAccountContext().c() != null) {
            final TCAccountBean c2 = this.f14690e.getTcAccountContext().c();
            e eVar = this.f14687b;
            if (eVar != null && eVar.z0()) {
                com.tplink.libtpnetwork.cameranetwork.h4.p4.g i4 = this.f14687b.i4();
                if (i4 != null) {
                    i4.f(c2.getToken());
                    i4.e(this.f14690e.getTcAccountContext().e());
                    this.f14687b.k4(i4);
                }
                this.f14691f = this.f14687b.g("empty", c2.getPassword()).L0(io.reactivex.l0.a.c()).H0(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.cameranetwork.w0
                    @Override // io.reactivex.g0.g
                    public final void accept(Object obj) {
                        f4.this.h1(c2, (Response) obj);
                    }
                }, s0.f14974c);
            }
        }
    }

    public q<Response> e3() {
        return v0(EnumCameraTransportType.LOCAL).N(m.f14937c);
    }

    public q<Response> f(final List<MotionDetectRegion> list) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.r1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t f2;
                f2 = ((h4) obj).f(list);
                return f2;
            }
        });
    }

    public q<Response<OsdConfig>> f0(final boolean z) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.r0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t d0;
                d0 = ((h4) obj).d0(z);
                return d0;
            }
        });
    }

    public q<Response> f2() {
        return v0(null).N(b.f14106c);
    }

    public q<Response> f3() {
        return v0(null).N(w.f15026c);
    }

    public q<Response> g(final MotionDetectConfig motionDetectConfig, final AlarmInfo alarmInfo, final MsgPushInfo msgPushInfo, final DetectionInfo detectionInfo, final DetectionInfo detectionInfo2, final TamperDetectConfig tamperDetectConfig, final HumanRecognitionInfo humanRecognitionInfo, final BabyCryingDetectionInfo babyCryingDetectionInfo, final TargetTrackInfo targetTrackInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.z0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t h;
                h = ((h4) obj).h(MotionDetectConfig.this, alarmInfo, msgPushInfo, detectionInfo, detectionInfo2, tamperDetectConfig, humanRecognitionInfo, babyCryingDetectionInfo, targetTrackInfo);
                return h;
            }
        });
    }

    public q<Response<P2PSharePwd>> g0() {
        return v0(null).N(c3.f14667c);
    }

    public q<Response> g2(final CloudTerraceResetInfo cloudTerraceResetInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.f0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t g3;
                g3 = ((h4) obj).g3(CloudTerraceResetInfo.this);
                return g3;
            }
        });
    }

    public q<Response> h(final AlarmPlanInfo alarmPlanInfo, final MsgPushPlanInfo msgPushPlanInfo, final ArmScheduleInfo armScheduleInfo, final ArmScheduleInfo armScheduleInfo2) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.k1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t i;
                i = ((h4) obj).i(AlarmPlanInfo.this, msgPushPlanInfo, armScheduleInfo, armScheduleInfo2);
                return i;
            }
        });
    }

    public q<Response<RebootInfo>> h0() {
        return v0(null).N(o3.f14956c);
    }

    public q<Response> h2() {
        return v0(null).N(i.f14907c);
    }

    public void h3(@NonNull com.tplink.cloud.context.b bVar, @NonNull String str, @NonNull String str2) {
        u(new com.tplink.libtpnetwork.cameranetwork.h4.p4.g(str2, str, bVar.e(), bVar.c().getToken()));
    }

    public q<Response> i(final List<MotionDetectRegion> list, final Map<String, List<IntrusionDetectionRegion>> map, final HashMap<String, List<LineCrossingDetectionRegion>> hashMap) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.o1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t j;
                j = ((h4) obj).j(list, map, hashMap);
                return j;
            }
        });
    }

    public q<Response<RecordAudioInfo>> i0() {
        return v0(null).N(f1.f14684c);
    }

    public q<Response> i2() {
        return v0(null).N(s.f14973c);
    }

    public void i3(@NonNull TPCameraDeviceContext tPCameraDeviceContext) {
        ALCameraDevice cameraDevice = tPCameraDeviceContext.getCameraDevice();
        com.tplink.cloud.context.b tcAccountContext = tPCameraDeviceContext.getTcAccountContext();
        if (cameraDevice != null) {
            TDPCameraDevice tdpCameraDevice = cameraDevice.getTdpCameraDevice();
            String g = b.d.w.h.a.g(tcAccountContext.c().getCloudUserName());
            if (tdpCameraDevice == null || !g.equalsIgnoreCase(tdpCameraDevice.getOwner())) {
                r(EnumCameraTransportType.LOCAL);
            } else {
                if (tdpCameraDevice.getHttpPort() <= 0) {
                    tdpCameraDevice.setHttpPort(443);
                }
                u(new u(tdpCameraDevice.getIp(), tdpCameraDevice.getHttpPort(), tcAccountContext.c().getCloudUserName(), tcAccountContext.c().getPassword(), b.d.w.h.a.g(tdpCameraDevice.getDeviceId()), tcAccountContext.c().getCloudUserName() + "_" + z.b(tdpCameraDevice.getMac())));
            }
            TCDeviceBean cloudCameraDevice = cameraDevice.getCloudCameraDevice();
            if (cloudCameraDevice == null || cloudCameraDevice.getAppServerUrl() == null || cameraDevice.getThingDevice() != null) {
                r(EnumCameraTransportType.REMOTE);
            } else {
                u(new com.tplink.libtpnetwork.cameranetwork.h4.p4.g(cloudCameraDevice.getAppServerUrl(), cloudCameraDevice.getDeviceId(), tcAccountContext.e(), tcAccountContext.c().getToken()));
            }
            if (cameraDevice.getThingDevice() == null || cameraDevice.getThingDevice().getThingUrl() == null) {
                r(EnumCameraTransportType.IOT_REMOTE);
                return;
            }
            b.d.w.c.a.c("testcamera", "iot remote");
            u(new d(cameraDevice.getDeviceId(), tPCameraDeviceContext));
        }
    }

    public q<Response> j(final MotionDetectConfig motionDetectConfig) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.d2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t k;
                k = ((h4) obj).k(MotionDetectConfig.this);
                return k;
            }
        });
    }

    public q<Response<RecordPlanInfo>> j0() {
        return v0(null).N(f.f14682c);
    }

    public q<Response> j2() {
        return v0(EnumCameraTransportType.LOCAL).N(v.f15019c);
    }

    public void j3(@NonNull TPCameraDeviceContext tPCameraDeviceContext) {
        ALCameraDevice cameraDevice = tPCameraDeviceContext.getCameraDevice();
        com.tplink.cloud.context.b tcAccountContext = tPCameraDeviceContext.getTcAccountContext();
        if (cameraDevice != null && cameraDevice.getTdpCameraDevice() != null) {
            TDPCameraDevice tdpCameraDevice = cameraDevice.getTdpCameraDevice();
            if (tdpCameraDevice.getHttpPort() <= 0) {
                tdpCameraDevice.setHttpPort(443);
            }
            u(new u(tdpCameraDevice.getIp(), tdpCameraDevice.getHttpPort(), tcAccountContext.c().getCloudUserName(), tcAccountContext.c().getPassword(), b.d.w.h.a.g(tdpCameraDevice.getDeviceId()), tcAccountContext.c().getCloudUserName() + "_" + z.b(tdpCameraDevice.getMac())));
        }
    }

    public q<Response> k(final String str, final String str2) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.u2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t l;
                l = ((h4) obj).l(str, str2);
                return l;
            }
        });
    }

    public q<Response<SettingComposite>> k0() {
        return v0(null).N(t3.f14983c);
    }

    public q<Response> k3(final String str, final String str2) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.j0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t g4;
                g4 = ((h4) obj).g4(str, str2);
                return g4;
            }
        });
    }

    public q<Response<ResetSupportInfo>> l() {
        return v0(EnumCameraTransportType.LOCAL).N(i3.f14915c);
    }

    public q<Response<SdCardFormatProgress>> l0() {
        return v0(null).N(s3.f14977c);
    }

    public q<Response<WifiList>> l2() {
        return v0(EnumCameraTransportType.LOCAL).N(v3.f15025c);
    }

    public q<Response> m(final boolean z) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.y1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t n;
                n = ((h4) obj).n(z);
                return n;
            }
        });
    }

    public q<Response<SettingComposite>> m0() {
        return v0(null).N(y.f15038c);
    }

    public q<Response> m2(final AlarmInfo alarmInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.c1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t l3;
                l3 = ((h4) obj).l3(AlarmInfo.this);
                return l3;
            }
        });
    }

    public q<Response> n() {
        return v0(null).N(t.f14978c);
    }

    public q<Response<ServiceList>> n0() {
        return v0(null).N(a4.f14105c);
    }

    public q<Response> n2(final AlarmPlanInfo alarmPlanInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.b2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t m3;
                m3 = ((h4) obj).m3(AlarmPlanInfo.this);
                return m3;
            }
        });
    }

    public q<Response> o(final CloudTerraceMoveInfo cloudTerraceMoveInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.j2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t p;
                p = ((h4) obj).p(CloudTerraceMoveInfo.this);
                return p;
            }
        });
    }

    public q<Response<SettingComposite>> o0(final CameraComponent cameraComponent) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.b3
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t m0;
                m0 = ((h4) obj).m0(CameraComponent.this);
                return m0;
            }
        });
    }

    public q<Response> o2(final AutoUpdateInfo autoUpdateInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.q2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t n3;
                n3 = ((h4) obj).n3(AutoUpdateInfo.this);
                return n3;
            }
        });
    }

    public q<Response> p(final String str) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.o0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t q;
                q = ((h4) obj).q(str);
                return q;
            }
        });
    }

    public q<Response<SettingCompositeV2>> p0(final CameraComponent cameraComponent) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.t1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t n0;
                n0 = ((h4) obj).n0(CameraComponent.this);
                return n0;
            }
        });
    }

    public q<Response> p2(final boolean z, final String str) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.a3
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t p3;
                p3 = ((h4) obj).p3(z, str);
                return p3;
            }
        });
    }

    public q<Response<ConnectResult>> q(final Wifi wifi) {
        return v0(EnumCameraTransportType.LOCAL).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.x2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t r;
                r = ((h4) obj).r(Wifi.this);
                return r;
            }
        });
    }

    public q<Response<DetectionList>> q0(final long j, final long j2, final int i, final int i2) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.v1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t o0;
                o0 = ((h4) obj).o0(j, j2, i, i2);
                return o0;
            }
        });
    }

    public q<Response> q2(final String str) {
        return v0(EnumCameraTransportType.LOCAL).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.m2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t q3;
                q3 = ((h4) obj).q3(str);
                return q3;
            }
        });
    }

    public void r(EnumCameraTransportType enumCameraTransportType) {
        b bVar;
        if (enumCameraTransportType != null) {
            int i = a.a[enumCameraTransportType.ordinal()];
            if (i == 1) {
                s sVar = this.a;
                if (sVar != null) {
                    sVar.o3(false);
                }
            } else if (i == 2) {
                e eVar = this.f14687b;
                if (eVar != null) {
                    eVar.o3(false);
                }
            } else if (i == 3 && (bVar = this.f14688c) != null) {
                bVar.o3(false);
            }
            g3();
        }
    }

    public q<Response<TamperDetectConfig>> r0() {
        return v0(null).N(l.f14931c);
    }

    public q<Response> r2(final boolean z) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.d1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t r3;
                r3 = ((h4) obj).r3(z);
                return r3;
            }
        });
    }

    public q<Response<StartUpdateFirmwareInfo>> s() {
        return v0(null).N(c.f14663c);
    }

    public q<Response<TargetTrackInfo>> s0() {
        return v0(null).N(d4.f14675c);
    }

    public q<Response> s2(final String str) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.h0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t s3;
                s3 = ((h4) obj).s3(str);
                return s3;
            }
        });
    }

    public q<ResponseBody> t() {
        return v0(EnumCameraTransportType.LOCAL).N(s1.f14975c);
    }

    public q<Response<AccountInfo>> t0() {
        return v0(null).N(k3.f14930c);
    }

    public q<Response> t2(final String str, final String str2) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.o2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t t3;
                t3 = ((h4) obj).t3(str, str2);
                return t3;
            }
        });
    }

    public void u(i4 i4Var) {
        if (i4Var != null) {
            if (i4Var instanceof u) {
                s sVar = this.a;
                if (sVar == null) {
                    this.a = new s((u) i4Var);
                } else {
                    sVar.W4((u) i4Var);
                }
                this.a.o3(true);
            } else if (i4Var instanceof com.tplink.libtpnetwork.cameranetwork.h4.p4.g) {
                e eVar = this.f14687b;
                if (eVar == null) {
                    this.f14687b = new e((com.tplink.libtpnetwork.cameranetwork.h4.p4.g) i4Var);
                } else {
                    eVar.k4((com.tplink.libtpnetwork.cameranetwork.h4.p4.g) i4Var);
                }
                this.f14687b.o3(true);
            } else if (i4Var instanceof d) {
                b bVar = this.f14688c;
                if (bVar == null) {
                    this.f14688c = new b((d) i4Var);
                } else {
                    bVar.h4((d) i4Var);
                }
                this.f14688c.o3(true);
            }
            g3();
        }
    }

    public q<Response<Timezone>> u0() {
        return v0(null).N(o.f14949c);
    }

    public q<Response> u2(final String str) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.v0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t u3;
                u3 = ((h4) obj).u3(str);
                return u3;
            }
        });
    }

    public q<Response> v() {
        return v0(null).N(r3.f14972c);
    }

    public q<Response> v2(final boolean z) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.u1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t v3;
                v3 = ((h4) obj).v3(z);
                return v3;
            }
        });
    }

    public q<Response<AESEncryptKey>> w() {
        return v0(null).N(c4.f14668c);
    }

    public q<Response<UpnpInfo>> w0() {
        return v0(null).N(p.f14957c);
    }

    public q<Response> w2(final WhitelampState whitelampState) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.n1
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t w3;
                w3 = ((h4) obj).w3(WhitelampState.this);
                return w3;
            }
        });
    }

    public q<Response<AlarmInfo>> x() {
        return v0(null).N(x.f15033c);
    }

    public q<Response<UpnpMultiInfo>> x0() {
        return v0(null).N(m3.f14941c);
    }

    public q<Response> x2(final boolean z) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.x0
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t x3;
                x3 = ((h4) obj).x3(z);
                return x3;
            }
        });
    }

    public q<Response<AlarmPlanInfo>> y() {
        return v0(null).N(a0.f14100c);
    }

    public q<Response<UpnpPsk>> y0() {
        return v0(null).N(c0.f14664c);
    }

    public q<Response> y2(final boolean z) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.e2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t y3;
                y3 = ((h4) obj).y3(z);
                return y3;
            }
        });
    }

    public q<Response<AudioInfo>> z() {
        return v0(null).N(b4.f14111c);
    }

    public q<Response<VodUserId>> z0() {
        return v0(null).N(e.f14676c);
    }

    public q<Response> z2(final DetectionInfo detectionInfo) {
        return v0(null).N(new j() { // from class: com.tplink.libtpnetwork.cameranetwork.s2
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                t z3;
                z3 = ((h4) obj).z3(DetectionInfo.this);
                return z3;
            }
        });
    }

    public f4(@NonNull TPCameraDeviceContext tPCameraDeviceContext) {
        i3(tPCameraDeviceContext);
        this.f14690e = tPCameraDeviceContext;
    }
}
