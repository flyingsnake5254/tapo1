package com.tplink.libtpnetwork.IoTNetwork.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.cloud.bean.thing.common.ThingShadowState;
import com.tplink.iot.cloud.bean.thing.common.ThingTemperatureRecords;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ThingServiceExecResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.SubDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.result.SubDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ChildProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.FrostProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.RemoveScaleInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ShutdownInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.TRVEarlyStartBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.WindowOpenDetectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.params.TemperatureOffsetParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.params.TemperatureRangeParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.params.TemperatureUnitParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.ProgressCalibrationInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.RemoveScaleStatusResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.TRVTemperatureRecordsResult;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import com.tplink.libtpnetwork.enumerate.EnumFeatureType;
import com.tplink.libtpnetwork.enumerate.EnumTRVState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: TRVRepository.kt */
/* loaded from: classes3.dex */
public final class TRVRepository extends AbstractSubThingRepository {
    private final MutableLiveData<TRVEarlyStartBean> C = new MutableLiveData<>();
    private final MutableLiveData<ChildProtectionBean> D = new MutableLiveData<>();
    private final MutableLiveData<FrostProtectionBean> E = new MutableLiveData<>();
    private final MutableLiveData<ShutdownInfoBean> F = new MutableLiveData<>();
    private final MutableLiveData<TRVTemperatureRecordsResult> G = new MutableLiveData<>();
    private final MutableLiveData<WindowOpenDetectionBean> H = new MutableLiveData<>();
    private final MutableLiveData<RemoveScaleInfoBean> I;
    private final LiveData<RemoveScaleInfoBean> J;
    private final MutableLiveData<RemoveScaleStatusResult> K;
    private final LiveData<RemoveScaleStatusResult> L;
    private final MutableLiveData<ProgressCalibrationInfoResult> M;
    private final LiveData<ProgressCalibrationInfoResult> N;

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends ChildProtectionBean>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* renamed from: com.tplink.libtpnetwork.IoTNetwork.repository.TRVRepository$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0260a<T, R> implements io.reactivex.g0.j<com.google.gson.i, ChildProtectionBean> {

            /* renamed from: c  reason: collision with root package name */
            public static final C0260a f13051c = new C0260a();

            C0260a() {
            }

            /* renamed from: a */
            public final ChildProtectionBean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return (ChildProtectionBean) com.tplink.libtpnetwork.Utils.i.a(it, ChildProtectionBean.class);
            }
        }

        a() {
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends ChildProtectionBean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (TRVRepository.this.F0(throwable)) {
                return TRVRepository.this.t(EnumFeatureType.CHILD_PROTECTION_MODE.getValue()).g0(C0260a.f13051c);
            }
            return io.reactivex.q.J(throwable);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class a0<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TRVEarlyStartBean f13053d;

        a0(TRVEarlyStartBean tRVEarlyStartBean) {
            this.f13053d = tRVEarlyStartBean;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            TRVEarlyStartBean tRVEarlyStartBean = this.f13053d;
            if (tRVEarlyStartBean != null) {
                TRVRepository.this.C.postValue(tRVEarlyStartBean);
            }
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class b<T> implements io.reactivex.g0.g<ChildProtectionBean> {
        b() {
        }

        /* renamed from: a */
        public final void accept(ChildProtectionBean childProtectionBean) {
            TRVRepository.this.D.postValue(childProtectionBean);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class b0<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends Boolean>> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FrostProtectionBean f13056d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<com.google.gson.i, Boolean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13057c = new a();

            a() {
            }

            /* renamed from: a */
            public final Boolean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return Boolean.TRUE;
            }
        }

        b0(FrostProtectionBean frostProtectionBean) {
            this.f13056d = frostProtectionBean;
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends Boolean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (TRVRepository.this.F0(throwable)) {
                return TRVRepository.this.L0(EnumFeatureType.FROST_PROTECTION_CONFIG.getValue(), this.f13056d).g0(a.f13057c);
            }
            return io.reactivex.q.J(throwable);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class c<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends TRVEarlyStartBean>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<com.google.gson.i, TRVEarlyStartBean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13059c = new a();

            a() {
            }

            /* renamed from: a */
            public final TRVEarlyStartBean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return (TRVEarlyStartBean) com.tplink.libtpnetwork.Utils.i.a(it, TRVEarlyStartBean.class);
            }
        }

        c() {
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends TRVEarlyStartBean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (TRVRepository.this.F0(throwable)) {
                return TRVRepository.this.t(EnumFeatureType.EARLY_START.getValue()).g0(a.f13059c);
            }
            return io.reactivex.q.J(throwable);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class c0<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FrostProtectionBean f13061d;

        c0(FrostProtectionBean frostProtectionBean) {
            this.f13061d = frostProtectionBean;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            TRVRepository.this.E.postValue(this.f13061d);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class d<T> implements io.reactivex.g0.g<TRVEarlyStartBean> {
        d() {
        }

        /* renamed from: a */
        public final void accept(TRVEarlyStartBean tRVEarlyStartBean) {
            TRVRepository.this.C.postValue(tRVEarlyStartBean);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class d0<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FrostProtectionBean f13064d;

        d0(FrostProtectionBean frostProtectionBean) {
            this.f13064d = frostProtectionBean;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            FrostProtectionBean frostProtectionBean = this.f13064d;
            if (frostProtectionBean != null) {
                TRVRepository.this.E.postValue(frostProtectionBean);
            }
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class e<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends FrostProtectionBean>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<com.google.gson.i, FrostProtectionBean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13066c = new a();

            a() {
            }

            /* renamed from: a */
            public final FrostProtectionBean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return (FrostProtectionBean) com.tplink.libtpnetwork.Utils.i.a(it, FrostProtectionBean.class);
            }
        }

        e() {
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends FrostProtectionBean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (TRVRepository.this.F0(throwable)) {
                return TRVRepository.this.t(EnumFeatureType.FROST_PROTECTION_CONFIG.getValue()).g0(a.f13066c);
            }
            return io.reactivex.q.J(throwable);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class e0<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends Boolean>> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RemoveScaleInfoBean f13068d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<com.google.gson.i, Boolean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13069c = new a();

            a() {
            }

            /* renamed from: a */
            public final Boolean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return Boolean.TRUE;
            }
        }

        e0(RemoveScaleInfoBean removeScaleInfoBean) {
            this.f13068d = removeScaleInfoBean;
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends Boolean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (TRVRepository.this.F0(throwable)) {
                return TRVRepository.this.L0(EnumFeatureType.AUTO_REMOVE_SCALE.getValue(), this.f13068d).g0(a.f13069c);
            }
            return io.reactivex.q.J(throwable);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class f<T> implements io.reactivex.g0.g<FrostProtectionBean> {
        f() {
        }

        /* renamed from: a */
        public final void accept(FrostProtectionBean frostProtectionBean) {
            TRVRepository.this.E.postValue(frostProtectionBean);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class f0<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RemoveScaleInfoBean f13072d;

        f0(RemoveScaleInfoBean removeScaleInfoBean) {
            this.f13072d = removeScaleInfoBean;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            TRVRepository.this.I.postValue(this.f13072d);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class g<T, R> implements io.reactivex.g0.j<ProgressCalibrationInfoResult, io.reactivex.t<? extends ProgressCalibrationInfoResult>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<DeviceRunningInfoResult, ProgressCalibrationInfoResult> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ProgressCalibrationInfoResult f13074c;

            a(ProgressCalibrationInfoResult progressCalibrationInfoResult) {
                this.f13074c = progressCalibrationInfoResult;
            }

            /* renamed from: a */
            public final ProgressCalibrationInfoResult apply(DeviceRunningInfoResult it) {
                List<EnumTRVState> trvStates;
                kotlin.jvm.internal.j.e(it, "it");
                int status = this.f13074c.getStatus();
                if ((it instanceof SubDeviceRunningInfoResult) && (trvStates = ((SubDeviceRunningInfoResult) it).getTrvStates()) != null && trvStates.contains(EnumTRVState.DEVICE_ERROR)) {
                    status = -1;
                }
                return new ProgressCalibrationInfoResult(status);
            }
        }

        g() {
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends ProgressCalibrationInfoResult> apply(ProgressCalibrationInfoResult progressCalibrationInfo) {
            kotlin.jvm.internal.j.e(progressCalibrationInfo, "progressCalibrationInfo");
            if (progressCalibrationInfo.getStatus() == 0) {
                return TRVRepository.this.Z0().g0(new a(progressCalibrationInfo)).q0(progressCalibrationInfo);
            }
            return io.reactivex.q.f0(progressCalibrationInfo);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class g0<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RemoveScaleInfoBean f13076d;

        g0(RemoveScaleInfoBean removeScaleInfoBean) {
            this.f13076d = removeScaleInfoBean;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            RemoveScaleInfoBean removeScaleInfoBean = this.f13076d;
            if (removeScaleInfoBean != null) {
                TRVRepository.this.I.postValue(removeScaleInfoBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    public static final class h<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends ProgressCalibrationInfoResult>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<ThingShadowResult, ProgressCalibrationInfoResult> {
            a() {
            }

            /* renamed from: a */
            public final ProgressCalibrationInfoResult apply(ThingShadowResult it) {
                int i;
                kotlin.jvm.internal.j.e(it, "it");
                List J4 = TRVRepository.this.J4(it);
                if (J4.contains(EnumTRVState.PROGRESS_CALIBRATION)) {
                    i = 1;
                } else {
                    i = J4.contains(EnumTRVState.DEVICE_ERROR) ? -1 : 0;
                }
                return new ProgressCalibrationInfoResult(i);
            }
        }

        h() {
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends ProgressCalibrationInfoResult> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (!TRVRepository.this.F0(throwable)) {
                return io.reactivex.q.J(throwable);
            }
            TRVRepository tRVRepository = TRVRepository.this;
            ThingContext mThingContext = TRVRepository.o4(tRVRepository);
            kotlin.jvm.internal.j.d(mThingContext, "mThingContext");
            String thingUrl = mThingContext.getThingUrl();
            ThingContext mThingContext2 = TRVRepository.o4(TRVRepository.this);
            kotlin.jvm.internal.j.d(mThingContext2, "mThingContext");
            return tRVRepository.C(thingUrl, mThingContext2.getThingName()).g0(new a());
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class h0<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends Boolean>> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ShutdownInfoBean f13080d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<com.google.gson.i, Boolean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13081c = new a();

            a() {
            }

            /* renamed from: a */
            public final Boolean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return Boolean.TRUE;
            }
        }

        h0(ShutdownInfoBean shutdownInfoBean) {
            this.f13080d = shutdownInfoBean;
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends Boolean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (TRVRepository.this.F0(throwable)) {
                return TRVRepository.this.L0(EnumFeatureType.SHUTDOWN_MODE.getValue(), this.f13080d).g0(a.f13081c);
            }
            return io.reactivex.q.J(throwable);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class i<T> implements io.reactivex.g0.g<ProgressCalibrationInfoResult> {
        i() {
        }

        /* renamed from: a */
        public final void accept(ProgressCalibrationInfoResult progressCalibrationInfoResult) {
            TRVRepository.this.M.postValue(progressCalibrationInfoResult);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class i0<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ShutdownInfoBean f13084d;

        i0(ShutdownInfoBean shutdownInfoBean) {
            this.f13084d = shutdownInfoBean;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            TRVRepository.this.F.postValue(this.f13084d);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class j<T> implements io.reactivex.g0.g<Throwable> {
        j() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            TRVRepository.this.M.postValue(new ProgressCalibrationInfoResult(0));
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class j0 implements io.reactivex.g0.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ShutdownInfoBean f13086b;

        j0(ShutdownInfoBean shutdownInfoBean) {
            this.f13086b = shutdownInfoBean;
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            TRVRepository.this.F.postValue(this.f13086b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    public static final class k<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends RemoveScaleStatusResult>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<ThingShadowResult, RemoveScaleStatusResult> {
            a() {
            }

            /* renamed from: a */
            public final RemoveScaleStatusResult apply(ThingShadowResult it) {
                kotlin.jvm.internal.j.e(it, "it");
                return new RemoveScaleStatusResult(TRVRepository.this.J4(it).contains(EnumTRVState.REMOVING_SCALE) ? 1 : 0);
            }
        }

        k() {
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends RemoveScaleStatusResult> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (!TRVRepository.this.F0(throwable)) {
                return io.reactivex.q.J(throwable);
            }
            TRVRepository tRVRepository = TRVRepository.this;
            ThingContext mThingContext = TRVRepository.o4(tRVRepository);
            kotlin.jvm.internal.j.d(mThingContext, "mThingContext");
            String thingUrl = mThingContext.getThingUrl();
            ThingContext mThingContext2 = TRVRepository.o4(TRVRepository.this);
            kotlin.jvm.internal.j.d(mThingContext2, "mThingContext");
            return tRVRepository.C(thingUrl, mThingContext2.getThingName()).g0(new a());
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class k0<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ShutdownInfoBean f13090d;

        k0(ShutdownInfoBean shutdownInfoBean) {
            this.f13090d = shutdownInfoBean;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            ShutdownInfoBean shutdownInfoBean = this.f13090d;
            if (shutdownInfoBean != null) {
                TRVRepository.this.F.postValue(shutdownInfoBean);
            }
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class l<T> implements io.reactivex.g0.g<RemoveScaleStatusResult> {
        l() {
        }

        /* renamed from: a */
        public final void accept(RemoveScaleStatusResult removeScaleStatusResult) {
            TRVRepository.this.K.postValue(removeScaleStatusResult);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class l0<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.e> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SubDeviceInfoParams f13093d;

        l0(SubDeviceInfoParams subDeviceInfoParams) {
            this.f13093d = subDeviceInfoParams;
        }

        /* renamed from: a */
        public final io.reactivex.e apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (!TRVRepository.this.F0(throwable)) {
                return io.reactivex.a.m(throwable);
            }
            TRVRepository tRVRepository = TRVRepository.this;
            return tRVRepository.h.B(tRVRepository.o(this.f13093d));
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class m<T> implements io.reactivex.g0.g<Throwable> {
        m() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            TRVRepository.this.K.postValue(new RemoveScaleStatusResult(0));
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class m0 implements io.reactivex.g0.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SubDeviceInfoParams f13095b;

        m0(SubDeviceInfoParams subDeviceInfoParams) {
            this.f13095b = subDeviceInfoParams;
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            TRVRepository.this.R3(this.f13095b);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class n<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends ShutdownInfoBean>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<com.google.gson.i, ShutdownInfoBean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13097c = new a();

            a() {
            }

            /* renamed from: a */
            public final ShutdownInfoBean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return (ShutdownInfoBean) com.tplink.libtpnetwork.Utils.i.a(it, ShutdownInfoBean.class);
            }
        }

        n() {
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends ShutdownInfoBean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (TRVRepository.this.F0(throwable)) {
                return TRVRepository.this.t(EnumFeatureType.SHUTDOWN_MODE.getValue()).g0(a.f13097c);
            }
            return io.reactivex.q.J(throwable);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class n0<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.e> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SubDeviceInfoParams f13099d;

        n0(SubDeviceInfoParams subDeviceInfoParams) {
            this.f13099d = subDeviceInfoParams;
        }

        /* renamed from: a */
        public final io.reactivex.e apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (!TRVRepository.this.F0(throwable)) {
                return io.reactivex.a.m(throwable);
            }
            TRVRepository tRVRepository = TRVRepository.this;
            return tRVRepository.h.B(tRVRepository.o(this.f13099d));
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class o<T> implements io.reactivex.g0.g<ShutdownInfoBean> {
        o() {
        }

        /* renamed from: a */
        public final void accept(ShutdownInfoBean shutdownInfoBean) {
            TRVRepository.this.F.postValue(shutdownInfoBean);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class o0 implements io.reactivex.g0.a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SubDeviceInfoParams f13101b;

        o0(SubDeviceInfoParams subDeviceInfoParams) {
            this.f13101b = subDeviceInfoParams;
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            TRVRepository.this.R3(this.f13101b);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class p<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends TRVTemperatureRecordsResult>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<ThingUsage, io.reactivex.t<? extends TRVTemperatureRecordsResult>> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13103c = new a();

            a() {
            }

            /* renamed from: a */
            public final io.reactivex.t<? extends TRVTemperatureRecordsResult> apply(ThingUsage it) {
                kotlin.jvm.internal.j.e(it, "it");
                if (it.getTemperatureRecords() == null) {
                    return io.reactivex.q.J(new Throwable("Temperature Records is null."));
                }
                ThingTemperatureRecords temperatureRecords = it.getTemperatureRecords();
                kotlin.jvm.internal.j.d(temperatureRecords, "it.temperatureRecords");
                return io.reactivex.q.f0(new TRVTemperatureRecordsResult(temperatureRecords));
            }
        }

        p() {
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends TRVTemperatureRecordsResult> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (!TRVRepository.this.F0(throwable)) {
                return io.reactivex.q.J(throwable);
            }
            TRVRepository tRVRepository = TRVRepository.this;
            ThingCloudRepository thingCloudRepository = tRVRepository.f13137d;
            ThingContext mThingContext = TRVRepository.o4(tRVRepository);
            kotlin.jvm.internal.j.d(mThingContext, "mThingContext");
            String thingUrl = mThingContext.getThingUrl();
            ThingContext mThingContext2 = TRVRepository.o4(TRVRepository.this);
            kotlin.jvm.internal.j.d(mThingContext2, "mThingContext");
            return thingCloudRepository.v0(thingUrl, mThingContext2.getThingName()).N(a.f13103c);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class p0<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.e> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SubDeviceInfoParams f13105d;

        p0(SubDeviceInfoParams subDeviceInfoParams) {
            this.f13105d = subDeviceInfoParams;
        }

        /* renamed from: a */
        public final io.reactivex.e apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (!TRVRepository.this.F0(throwable)) {
                return io.reactivex.a.m(throwable);
            }
            TRVRepository tRVRepository = TRVRepository.this;
            return tRVRepository.h.B(tRVRepository.o(this.f13105d));
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class q<T> implements io.reactivex.g0.g<TRVTemperatureRecordsResult> {
        q() {
        }

        /* renamed from: a */
        public final void accept(TRVTemperatureRecordsResult tRVTemperatureRecordsResult) {
            TRVRepository.this.G.postValue(tRVTemperatureRecordsResult);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class q0<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SubDeviceInfoParams f13108d;

        q0(SubDeviceInfoParams subDeviceInfoParams) {
            this.f13108d = subDeviceInfoParams;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            TRVRepository.this.R3(this.f13108d);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class r<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends WindowOpenDetectionBean>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<com.google.gson.i, WindowOpenDetectionBean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13110c = new a();

            a() {
            }

            /* renamed from: a */
            public final WindowOpenDetectionBean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return (WindowOpenDetectionBean) com.tplink.libtpnetwork.Utils.i.a(it, WindowOpenDetectionBean.class);
            }
        }

        r() {
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends WindowOpenDetectionBean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (TRVRepository.this.F0(throwable)) {
                return TRVRepository.this.t(EnumFeatureType.WINDOW_OPEN_DETECTION.getValue()).g0(a.f13110c);
            }
            return io.reactivex.q.J(throwable);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class r0<T> implements io.reactivex.g0.g<Throwable> {
        r0() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            TRVRepository.this.S3(th);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class s<T> implements io.reactivex.g0.g<WindowOpenDetectionBean> {
        s() {
        }

        /* renamed from: a */
        public final void accept(WindowOpenDetectionBean windowOpenDetectionBean) {
            TRVRepository.this.H.postValue(windowOpenDetectionBean);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class s0<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends Boolean>> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ WindowOpenDetectionBean f13114d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<com.google.gson.i, Boolean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13115c = new a();

            a() {
            }

            /* renamed from: a */
            public final Boolean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return Boolean.TRUE;
            }
        }

        s0(WindowOpenDetectionBean windowOpenDetectionBean) {
            this.f13114d = windowOpenDetectionBean;
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends Boolean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (TRVRepository.this.F0(throwable)) {
                return TRVRepository.this.L0(EnumFeatureType.WINDOW_OPEN_DETECTION.getValue(), this.f13114d).g0(a.f13115c);
            }
            return io.reactivex.q.J(throwable);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class t<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends Boolean>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<ThingServiceExecResult, Boolean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13117c = new a();

            a() {
            }

            /* renamed from: a */
            public final Boolean apply(ThingServiceExecResult it) {
                kotlin.jvm.internal.j.e(it, "it");
                return Boolean.TRUE;
            }
        }

        t() {
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends Boolean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (!TRVRepository.this.F0(throwable)) {
                return io.reactivex.q.J(throwable);
            }
            ThingServiceParams thingServiceParams = new ThingServiceParams(ThingModelDefine.Service.SERVICE_REMOVE_SCALE, new com.google.gson.k());
            TRVRepository tRVRepository = TRVRepository.this;
            ThingCloudRepository thingCloudRepository = tRVRepository.f13137d;
            ThingContext mThingContext = TRVRepository.o4(tRVRepository);
            kotlin.jvm.internal.j.d(mThingContext, "mThingContext");
            String thingUrl = mThingContext.getThingUrl();
            ThingContext mThingContext2 = TRVRepository.o4(TRVRepository.this);
            kotlin.jvm.internal.j.d(mThingContext2, "mThingContext");
            String thingName = mThingContext2.getThingName();
            ThingContext mThingContext3 = TRVRepository.o4(TRVRepository.this);
            kotlin.jvm.internal.j.d(mThingContext3, "mThingContext");
            return thingCloudRepository.P(thingUrl, thingName, mThingContext3.getThingGatewayUrlV2(), thingServiceParams).g0(a.f13117c);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class t0<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ WindowOpenDetectionBean f13119d;

        t0(WindowOpenDetectionBean windowOpenDetectionBean) {
            this.f13119d = windowOpenDetectionBean;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            TRVRepository.this.H.postValue(this.f13119d);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class u<T> implements io.reactivex.g0.g<Throwable> {
        u() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            RemoveScaleStatusResult copy;
            RemoveScaleStatusResult removeScaleStatusResult = (RemoveScaleStatusResult) TRVRepository.this.K.getValue();
            if (removeScaleStatusResult != null && (copy = removeScaleStatusResult.copy(0)) != null) {
                TRVRepository.this.K.postValue(copy);
            }
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class u0<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ WindowOpenDetectionBean f13122d;

        u0(WindowOpenDetectionBean windowOpenDetectionBean) {
            this.f13122d = windowOpenDetectionBean;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            WindowOpenDetectionBean windowOpenDetectionBean = this.f13122d;
            if (windowOpenDetectionBean != null) {
                TRVRepository.this.H.postValue(windowOpenDetectionBean);
            }
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class v<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends Boolean>> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ChildProtectionBean f13124d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<com.google.gson.i, Boolean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13125c = new a();

            a() {
            }

            /* renamed from: a */
            public final Boolean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return Boolean.TRUE;
            }
        }

        v(ChildProtectionBean childProtectionBean) {
            this.f13124d = childProtectionBean;
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends Boolean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (TRVRepository.this.F0(throwable)) {
                return TRVRepository.this.L0(EnumFeatureType.CHILD_PROTECTION_MODE.getValue(), this.f13124d).g0(a.f13125c);
            }
            return io.reactivex.q.J(throwable);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class v0<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends Boolean>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<ThingServiceExecResult, Boolean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13127c = new a();

            a() {
            }

            /* renamed from: a */
            public final Boolean apply(ThingServiceExecResult it) {
                kotlin.jvm.internal.j.e(it, "it");
                return Boolean.TRUE;
            }
        }

        v0() {
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends Boolean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (!TRVRepository.this.F0(throwable)) {
                return io.reactivex.q.J(throwable);
            }
            ThingServiceParams thingServiceParams = new ThingServiceParams(ThingModelDefine.Service.SERVICE_PROGRESS_CALIBRATION, new com.google.gson.k());
            TRVRepository tRVRepository = TRVRepository.this;
            ThingCloudRepository thingCloudRepository = tRVRepository.f13137d;
            ThingContext mThingContext = TRVRepository.o4(tRVRepository);
            kotlin.jvm.internal.j.d(mThingContext, "mThingContext");
            String thingUrl = mThingContext.getThingUrl();
            ThingContext mThingContext2 = TRVRepository.o4(TRVRepository.this);
            kotlin.jvm.internal.j.d(mThingContext2, "mThingContext");
            String thingName = mThingContext2.getThingName();
            ThingContext mThingContext3 = TRVRepository.o4(TRVRepository.this);
            kotlin.jvm.internal.j.d(mThingContext3, "mThingContext");
            return thingCloudRepository.P(thingUrl, thingName, mThingContext3.getThingGatewayUrlV2(), thingServiceParams).g0(a.f13127c);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class w<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ChildProtectionBean f13129d;

        w(ChildProtectionBean childProtectionBean) {
            this.f13129d = childProtectionBean;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            TRVRepository.this.D.postValue(this.f13129d);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class w0 implements io.reactivex.g0.a {
        w0() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            TRVRepository.this.M.postValue(new ProgressCalibrationInfoResult(1));
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class x<T> implements io.reactivex.g0.g<Throwable> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ChildProtectionBean f13131d;

        x(ChildProtectionBean childProtectionBean) {
            this.f13131d = childProtectionBean;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            ChildProtectionBean childProtectionBean = this.f13131d;
            if (childProtectionBean != null) {
                TRVRepository.this.D.postValue(childProtectionBean);
            }
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class y<T, R> implements io.reactivex.g0.j<Throwable, io.reactivex.t<? extends Boolean>> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TRVEarlyStartBean f13133d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TRVRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a<T, R> implements io.reactivex.g0.j<com.google.gson.i, Boolean> {

            /* renamed from: c  reason: collision with root package name */
            public static final a f13134c = new a();

            a() {
            }

            /* renamed from: a */
            public final Boolean apply(com.google.gson.i it) {
                kotlin.jvm.internal.j.e(it, "it");
                return Boolean.TRUE;
            }
        }

        y(TRVEarlyStartBean tRVEarlyStartBean) {
            this.f13133d = tRVEarlyStartBean;
        }

        /* renamed from: a */
        public final io.reactivex.t<? extends Boolean> apply(Throwable throwable) {
            kotlin.jvm.internal.j.e(throwable, "throwable");
            if (TRVRepository.this.F0(throwable)) {
                return TRVRepository.this.L0(EnumFeatureType.EARLY_START.getValue(), this.f13133d).g0(a.f13134c);
            }
            return io.reactivex.q.J(throwable);
        }
    }

    /* compiled from: TRVRepository.kt */
    /* loaded from: classes3.dex */
    static final class z<T> implements io.reactivex.g0.g<io.reactivex.e0.c> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TRVEarlyStartBean f13136d;

        z(TRVEarlyStartBean tRVEarlyStartBean) {
            this.f13136d = tRVEarlyStartBean;
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            TRVRepository.this.C.postValue(this.f13136d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TRVRepository(ThingContext thingContext) {
        super(thingContext, IoTSubDevice.class, SubDeviceRunningInfoResult.class);
        kotlin.jvm.internal.j.e(thingContext, "thingContext");
        MutableLiveData<RemoveScaleInfoBean> mutableLiveData = new MutableLiveData<>();
        this.I = mutableLiveData;
        this.J = mutableLiveData;
        MutableLiveData<RemoveScaleStatusResult> mutableLiveData2 = new MutableLiveData<>();
        this.K = mutableLiveData2;
        this.L = mutableLiveData2;
        MutableLiveData<ProgressCalibrationInfoResult> mutableLiveData3 = new MutableLiveData<>();
        this.M = mutableLiveData3;
        this.N = mutableLiveData3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<EnumTRVState> J4(ThingShadowResult thingShadowResult) {
        List<EnumTRVState> d2;
        EnumTRVState a2;
        Map<String, Object> reported;
        ThingShadowState state = thingShadowResult.getState();
        ArrayList arrayList = null;
        Object obj = (state == null || (reported = state.getReported()) == null) ? null : reported.get(ThingModelDefine.Property.PROPERTY_TRV_STATES);
        if (obj instanceof ArrayList) {
            arrayList = obj;
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2 != null) {
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if ((next instanceof String) && (a2 = EnumTRVState.Companion.a((String) next)) != null) {
                    arrayList3.add(a2);
                }
            }
            return arrayList3;
        }
        d2 = kotlin.collections.n.d();
        return d2;
    }

    public static final /* synthetic */ ThingContext o4(TRVRepository tRVRepository) {
        return (ThingContext) tRVRepository.a;
    }

    public final io.reactivex.q<RemoveScaleStatusResult> A4() {
        io.reactivex.q<RemoveScaleStatusResult> C = x0("get_remove_scale_status", RemoveScaleStatusResult.class).o0(new k()).E(new l()).C(new m());
        kotlin.jvm.internal.j.d(C, "postRequest(IoTNetworkDe…tusResult.STATUS_IDLE)) }");
        return C;
    }

    public final LiveData<RemoveScaleStatusResult> B4() {
        return this.L;
    }

    public final io.reactivex.q<ShutdownInfoBean> C4() {
        io.reactivex.q<ShutdownInfoBean> E = x0("get_shutdown_info", ShutdownInfoBean.class).o0(new n()).E(new o());
        kotlin.jvm.internal.j.d(E, "postRequest(IoTNetworkDe…oLiveData.postValue(it) }");
        return E;
    }

    public final LiveData<ShutdownInfoBean> D4() {
        return this.F;
    }

    public final io.reactivex.q<TRVTemperatureRecordsResult> E4() {
        io.reactivex.q<TRVTemperatureRecordsResult> E = x0("get_temperature_records", TRVTemperatureRecordsResult.class).o0(new p()).E(new q());
        kotlin.jvm.internal.j.d(E, "postRequest(IoTNetworkDe…sLiveData.postValue(it) }");
        return E;
    }

    public final LiveData<TRVTemperatureRecordsResult> F4() {
        return this.G;
    }

    public final io.reactivex.q<WindowOpenDetectionBean> G4() {
        io.reactivex.q<WindowOpenDetectionBean> E = x0("get_window_open_detection", WindowOpenDetectionBean.class).o0(new r()).E(new s());
        kotlin.jvm.internal.j.d(E, "postRequest(IoTNetworkDe…oLiveData.postValue(it) }");
        return E;
    }

    public final LiveData<WindowOpenDetectionBean> H4() {
        return this.H;
    }

    public final io.reactivex.a I4() {
        io.reactivex.a j2 = y0("remove_scale", null, Boolean.class).o0(new t()).Z().j(new u());
        kotlin.jvm.internal.j.d(j2, "postRequest(IoTNetworkDe…:postValue)\n            }");
        return j2;
    }

    public final io.reactivex.a K4(ChildProtectionBean params) {
        kotlin.jvm.internal.j.e(params, "params");
        io.reactivex.a Z = y0("set_child_protection", params, Boolean.class).o0(new v(params)).F(new w(params)).C(new x(this.D.getValue())).Z();
        kotlin.jvm.internal.j.d(Z, "postRequest(IoTNetworkDe…        .ignoreElements()");
        return Z;
    }

    public final io.reactivex.a L4(SubDeviceInfoParams params) {
        kotlin.jvm.internal.j.e(params, "params");
        io.reactivex.a X3 = X3(params);
        kotlin.jvm.internal.j.d(X3, "setDeviceShadow(params)");
        return X3;
    }

    public final io.reactivex.a M4(TRVEarlyStartBean params) {
        kotlin.jvm.internal.j.e(params, "params");
        io.reactivex.a Z = y0("set_early_start", params, Boolean.class).o0(new y(params)).F(new z(params)).C(new a0(this.C.getValue())).Z();
        kotlin.jvm.internal.j.d(Z, "postRequest(IoTNetworkDe…        .ignoreElements()");
        return Z;
    }

    public final io.reactivex.a N4(FrostProtectionBean params) {
        kotlin.jvm.internal.j.e(params, "params");
        io.reactivex.a Z = y0("set_frost_protection", params, Boolean.class).o0(new b0(params)).F(new c0(params)).C(new d0(this.E.getValue())).Z();
        kotlin.jvm.internal.j.d(Z, "postRequest(IoTNetworkDe…        .ignoreElements()");
        return Z;
    }

    public final io.reactivex.a O4(RemoveScaleInfoBean params) {
        kotlin.jvm.internal.j.e(params, "params");
        io.reactivex.a j2 = y0("set_remove_scale_info", params, Boolean.class).o0(new e0(params)).Z().l(new f0(params)).j(new g0(this.I.getValue()));
        kotlin.jvm.internal.j.d(j2, "postRequest(IoTNetworkDe…nfoLiveData::postValue) }");
        return j2;
    }

    public final io.reactivex.a P4(ShutdownInfoBean params) {
        kotlin.jvm.internal.j.e(params, "params");
        io.reactivex.a Z = y0("set_shutdown_info", params, Boolean.class).o0(new h0(params)).F(new i0(params)).z(new j0(params)).C(new k0(this.F.getValue())).Z();
        kotlin.jvm.internal.j.d(Z, "postRequest(IoTNetworkDe…        .ignoreElements()");
        return Z;
    }

    public final io.reactivex.a Q4(TemperatureOffsetParams params) {
        kotlin.jvm.internal.j.e(params, "params");
        SubDeviceInfoParams subDeviceInfoParams = new SubDeviceInfoParams();
        subDeviceInfoParams.setTempUnit(params.getTempUnit());
        subDeviceInfoParams.setTempOffset(Integer.valueOf(params.getOffset()));
        io.reactivex.a i2 = y0("set_temperature_offset", params, Boolean.class).Z().u(new l0(subDeviceInfoParams)).i(new m0(subDeviceInfoParams));
        kotlin.jvm.internal.j.d(i2, "postRequest(IoTNetworkDe…InfoParams)\n            }");
        return i2;
    }

    public final io.reactivex.a R4(TemperatureRangeParams params) {
        kotlin.jvm.internal.j.e(params, "params");
        SubDeviceInfoParams subDeviceInfoParams = new SubDeviceInfoParams();
        subDeviceInfoParams.setTempUnit(params.getTempUnit());
        subDeviceInfoParams.setMinControlTemp(Integer.valueOf(params.getMinControlTemp()));
        subDeviceInfoParams.setMaxControlTemp(Integer.valueOf(params.getMaxControlTemp()));
        io.reactivex.a i2 = y0("set_temperature_range", params, Boolean.class).Z().u(new n0(subDeviceInfoParams)).i(new o0(subDeviceInfoParams));
        kotlin.jvm.internal.j.d(i2, "postRequest(IoTNetworkDe…InfoParams)\n            }");
        return i2;
    }

    public final io.reactivex.a S4(TemperatureUnitParams params) {
        kotlin.jvm.internal.j.e(params, "params");
        SubDeviceInfoParams subDeviceInfoParams = new SubDeviceInfoParams();
        subDeviceInfoParams.setTempUnit(params.getTempUnit());
        io.reactivex.a j2 = y0("set_temperature_unit", params, Boolean.class).Z().u(new p0(subDeviceInfoParams)).l(new q0(subDeviceInfoParams)).j(new r0());
        kotlin.jvm.internal.j.d(j2, "postRequest(IoTNetworkDe…lbackDeviceInfoData(it) }");
        return j2;
    }

    public final io.reactivex.a T4(WindowOpenDetectionBean params) {
        kotlin.jvm.internal.j.e(params, "params");
        io.reactivex.a Z = y0("set_window_open_detection", params, Boolean.class).o0(new s0(params)).F(new t0(params)).C(new u0(this.H.getValue())).Z();
        kotlin.jvm.internal.j.d(Z, "postRequest(IoTNetworkDe…        .ignoreElements()");
        return Z;
    }

    public final io.reactivex.a U4() {
        io.reactivex.a Z = y0(EnumTRVState.TRV_PROGRESS_CALIBRATION, null, Boolean.class).o0(new v0()).z(new w0()).Z();
        kotlin.jvm.internal.j.d(Z, "postRequest(IoTNetworkDe…        .ignoreElements()");
        return Z;
    }

    public final io.reactivex.q<ChildProtectionBean> r4() {
        io.reactivex.q<ChildProtectionBean> E = x0("get_child_protection", ChildProtectionBean.class).o0(new a()).E(new b());
        kotlin.jvm.internal.j.d(E, "postRequest(IoTNetworkDe…nLiveData.postValue(it) }");
        return E;
    }

    public final LiveData<ChildProtectionBean> s4() {
        return this.D;
    }

    public final io.reactivex.q<TRVEarlyStartBean> t4() {
        io.reactivex.q<TRVEarlyStartBean> E = x0("get_early_start", TRVEarlyStartBean.class).o0(new c()).E(new d());
        kotlin.jvm.internal.j.d(E, "postRequest(IoTNetworkDe…tLiveData.postValue(it) }");
        return E;
    }

    public final LiveData<TRVEarlyStartBean> u4() {
        return this.C;
    }

    public final io.reactivex.q<FrostProtectionBean> v4() {
        io.reactivex.q<FrostProtectionBean> E = x0("get_frost_protection", FrostProtectionBean.class).o0(new e()).E(new f());
        kotlin.jvm.internal.j.d(E, "postRequest(IoTNetworkDe…nLiveData.postValue(it) }");
        return E;
    }

    public final LiveData<FrostProtectionBean> w4() {
        return this.E;
    }

    public final io.reactivex.q<ProgressCalibrationInfoResult> x4() {
        io.reactivex.q<ProgressCalibrationInfoResult> C = x0("get_progress_calibration_info", ProgressCalibrationInfoResult.class).N(new g()).o0(new h()).E(new i()).C(new j());
        kotlin.jvm.internal.j.d(C, "postRequest(IoTNetworkDe…nfoResult.STATUS_IDLE)) }");
        return C;
    }

    public final LiveData<ProgressCalibrationInfoResult> y4() {
        return this.N;
    }

    public final LiveData<RemoveScaleInfoBean> z4() {
        return this.J;
    }
}
