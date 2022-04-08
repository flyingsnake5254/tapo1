package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.annotation.NonNull;
import com.tplink.libtpnetwork.Utils.u;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BabyCryingDetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.DetectionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.HumanRecognitionInfo;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.TamperDetectConfig;
import com.tplink.libtpnetwork.cameranetwork.model.TargetTrackInfo;
import io.reactivex.g0.j;
import io.reactivex.q;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class HomeAwayModeRepository extends c {

    /* loaded from: classes3.dex */
    class a implements j<Boolean, Boolean> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BabyCryingDetectionInfo f14243c;

        a(BabyCryingDetectionInfo babyCryingDetectionInfo) {
            this.f14243c = babyCryingDetectionInfo;
        }

        /* renamed from: a */
        public Boolean apply(@NonNull Boolean bool) throws Exception {
            HomeAwayModeRepository.this.y(this.f14243c);
            return Boolean.TRUE;
        }
    }

    public HomeAwayModeRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(BabyCryingDetectionInfo babyCryingDetectionInfo) {
        if (babyCryingDetectionInfo != null && babyCryingDetectionInfo.getEnabled() != null && b() != null && b().getDeviceIdMD5() != null && !u.a(b().getDeviceIdMD5()).booleanValue() && babyCryingDetectionInfo.getEnabled().equals("on")) {
            u.h(b().getDeviceIdMD5(), true);
        }
    }

    public q<Boolean> t(MotionDetectConfig motionDetectConfig, AlarmInfo alarmInfo, MsgPushInfo msgPushInfo, DetectionInfo detectionInfo, DetectionInfo detectionInfo2, TamperDetectConfig tamperDetectConfig, HumanRecognitionInfo humanRecognitionInfo, BabyCryingDetectionInfo babyCryingDetectionInfo, TargetTrackInfo targetTrackInfo) {
        return l().g(motionDetectConfig, alarmInfo, msgPushInfo, detectionInfo, detectionInfo2, tamperDetectConfig, humanRecognitionInfo, babyCryingDetectionInfo, targetTrackInfo).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(new a(babyCryingDetectionInfo));
    }

    public q<Boolean> u(AlarmPlanInfo alarmPlanInfo, MsgPushPlanInfo msgPushPlanInfo, ArmScheduleInfo armScheduleInfo, ArmScheduleInfo armScheduleInfo2) {
        return l().h(alarmPlanInfo, msgPushPlanInfo, armScheduleInfo, armScheduleInfo2).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(i2.f14463c);
    }

    public q<Boolean> v(List<MotionDetectRegion> list, Map<String, List<IntrusionDetectionRegion>> map, HashMap<String, List<LineCrossingDetectionRegion>> hashMap) {
        return l().i(list, map, hashMap).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(h2.f14452c);
    }
}
