package com.tplink.iot.devices.lightstrip.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBinding;
import com.tplink.iot.databinding.LayoutLightStripDetailBottomExtBinding;
import com.tplink.iot.databinding.LayoutLightStripDetailContentExtBinding;
import com.tplink.iot.databinding.LayoutLightStripGuidePageBinding;
import com.tplink.iot.devicecommon.feature.NextEventFeature;
import com.tplink.iot.devicecommon.view.DeviceLocationCheckFragment;
import com.tplink.iot.devicecommon.view.IoTDetailBaseActivity;
import com.tplink.iot.devices.lightstrip.adapter.PredefinedEffectsAdapter;
import com.tplink.iot.devices.lightstrip.view.LightStripLightSettingsFragment;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripDetailViewModel;
import com.tplink.iot.devices.lightstrip.widget.CircleEffectImageView;
import com.tplink.iot.devices.lightstrip.widget.ColorEffectPlateView;
import com.tplink.iot.devices.lightstrip.widget.ColorPaintingRingView;
import com.tplink.iot.devices.lightstrip.widget.LightStripControllerLayout;
import com.tplink.iot.devices.lightstrip.widget.LightStripDetailBgLayout;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectBaseView;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetLayout;
import com.tplink.iot.devices.lightstrip.widget.SelectableColorPointView;
import com.tplink.iot.k.c.b;
import com.tplink.iot.musicphonerhythm.activitys.MusicPhoneRhythmActivity;
import com.tplink.iot.view.colorbulb.EditAutoDialog;
import com.tplink.iot.view.feature.AwayModeActivity;
import com.tplink.iot.view.feature.ScheduleListActivity;
import com.tplink.iot.view.feature.TimerActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.widget.WaveView;
import com.tplink.iot.widget.viewgroup.MultiFeaturesGridView;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.yinglan.scrolllayout.ScrollLayout;
import java.util.List;
import java.util.Objects;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* compiled from: LightStripDetailActivity.kt */
/* loaded from: classes2.dex */
public final class LightStripDetailActivity extends IoTDetailBaseActivity<LayoutLightStripDetailContentExtBinding, LayoutLightStripDetailBottomExtBinding, LightStripDetailViewModel> implements LightStripControllerLayout.a, LightStripLightSettingsFragment.b, LightingEffectPresetLayout.b, DeviceLocationCheckFragment.b, EditAutoDialog.a, MultiFeaturesGridView.e {
    static final /* synthetic */ kotlin.reflect.j[] K3 = {kotlin.jvm.internal.m.e(new MutablePropertyReference1Impl(LightStripDetailActivity.class, "mIsSupportLightingEffectObservable", "getMIsSupportLightingEffectObservable()Z", 0))};
    public static final b L3 = new b(null);
    private final kotlin.f M3;
    private final kotlin.f N3;
    private int O3 = -1;
    private String P3;
    private IoTLightStripDevice Q3;
    private List<? extends LightStateBean> R3;
    private int S3;
    private final kotlin.f T3;
    private EditAutoDialog U3;
    private final kotlin.f V3;
    private final kotlin.t.d W3;
    private LayoutLightStripGuidePageBinding X3;
    private ViewGroup Y3;
    private View Z3;
    private View a4;
    private WaveView b4;
    private LightingEffectBaseView c4;
    private TextView d4;
    private RelativeLayout.LayoutParams e4;
    private int f4;
    private boolean g4;

    /* compiled from: Delegates.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.t.b<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f7525b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LightStripDetailActivity f7526c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, Object obj2, LightStripDetailActivity lightStripDetailActivity) {
            super(obj2);
            this.f7525b = obj;
            this.f7526c = lightStripDetailActivity;
        }

        @Override // kotlin.t.b
        protected void c(kotlin.reflect.j<?> property, Boolean bool, Boolean bool2) {
            kotlin.jvm.internal.j.e(property, "property");
            if (bool2.booleanValue() != bool.booleanValue()) {
                this.f7526c.u2();
            }
        }
    }

    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public final void a(Context context, String deviceIdMD5) {
            kotlin.jvm.internal.j.e(context, "context");
            kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
            Intent intent = new Intent(context, LightStripDetailActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            context.startActivity(intent);
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<LightStripDetailBgLayout> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final LightStripDetailBgLayout invoke() {
            return new LightStripDetailBgLayout(LightStripDetailActivity.this, null, 0, 6, null);
        }
    }

    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements kotlin.jvm.b.a<Integer> {
        d() {
            super(0);
        }

        public final int a() {
            return LightStripDetailActivity.this.getResources().getColor(R.color.common_iot_dark_black);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(a());
        }
    }

    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements kotlin.jvm.b.a<LightStripControllerLayout> {
        e() {
            super(0);
        }

        /* renamed from: a */
        public final LightStripControllerLayout invoke() {
            return LightStripDetailActivity.Q1(LightStripDetailActivity.this).f7253c;
        }
    }

    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class f extends Lambda implements kotlin.jvm.b.a<DeviceLocationCheckFragment> {
        f() {
            super(0);
        }

        /* renamed from: a */
        public final DeviceLocationCheckFragment invoke() {
            return DeviceLocationCheckFragment.x.a(LightStripDetailActivity.this);
        }
    }

    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Pair k2 = LightStripDetailActivity.this.k2();
            LightStripDetailActivity.this.A2(((Number) k2.component1()).intValue(), ((Number) k2.component2()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class h<T> implements io.reactivex.g0.g<TDPIoTDevice> {

        /* compiled from: LightStripDetailActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a implements b.o {
            a() {
            }

            @Override // com.tplink.iot.k.c.b.o
            public void a() {
                LightStripDetailActivity.this.y2();
                LightStripDetailActivity.this.S3++;
            }

            @Override // com.tplink.iot.k.c.b.o
            public void cancel() {
                LightStripDetailActivity.this.S3 = 0;
            }
        }

        h() {
        }

        /* renamed from: a */
        public final void accept(TDPIoTDevice tdpIoTDevice) {
            s0.g();
            kotlin.jvm.internal.j.d(tdpIoTDevice, "tdpIoTDevice");
            String ip = tdpIoTDevice.getIp();
            if (!(ip == null || ip.length() == 0)) {
                BaseALIoTDevice p1 = LightStripDetailActivity.this.p1();
                if (p1 == null || !p1.isUserRoleTypeDevice()) {
                    MusicPhoneRhythmActivity.e1(LightStripDetailActivity.this, tdpIoTDevice.getDeviceIdMd5(), null);
                } else {
                    MusicPhoneRhythmActivity.e1(LightStripDetailActivity.this, tdpIoTDevice.getDeviceIdMd5(), tdpIoTDevice.getIp());
                }
            } else {
                LightStripDetailActivity lightStripDetailActivity = LightStripDetailActivity.this;
                com.tplink.iot.k.c.b.h(lightStripDetailActivity, lightStripDetailActivity.S3, new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class i<T> implements io.reactivex.g0.g<Throwable> {

        /* compiled from: LightStripDetailActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a implements b.o {
            a() {
            }

            @Override // com.tplink.iot.k.c.b.o
            public void a() {
                LightStripDetailActivity.this.y2();
                LightStripDetailActivity.this.S3++;
            }

            @Override // com.tplink.iot.k.c.b.o
            public void cancel() {
                LightStripDetailActivity.this.S3 = 0;
            }
        }

        i() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            s0.g();
            LightStripDetailActivity lightStripDetailActivity = LightStripDetailActivity.this;
            com.tplink.iot.k.c.b.h(lightStripDetailActivity, lightStripDetailActivity.S3, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class j implements View.OnTouchListener {

        /* renamed from: c  reason: collision with root package name */
        public static final j f7534c = new j();

        j() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!LightStripDetailActivity.R1(LightStripDetailActivity.this).isSelected()) {
                LightStripDetailActivity.S1(LightStripDetailActivity.this).f7256c.setText(R.string.action_got_it);
                LightStripDetailActivity.V1(LightStripDetailActivity.this).setText(R.string.detail_page_guide_preset_tips2);
                LightStripDetailActivity.R1(LightStripDetailActivity.this).j(true, true);
                LightStripDetailActivity.R1(LightStripDetailActivity.this).d(true);
                return;
            }
            LightStripDetailActivity.this.m2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (LightStripDetailActivity.this.f4 == 0) {
                LightStripDetailActivity.S1(LightStripDetailActivity.this).f7256c.setText(R.string.action_got_it);
                LightStripDetailActivity.R1(LightStripDetailActivity.this).j(true, true);
                LightStripDetailActivity.R1(LightStripDetailActivity.this).d(true);
                LightStripDetailActivity.V1(LightStripDetailActivity.this).setText(R.string.detail_page_guide_preset_tips2);
                LightStripDetailActivity.Q1(LightStripDetailActivity.this).f7254d.e(1);
                LightStripDetailActivity.this.f4++;
                return;
            }
            LightStripDetailActivity.this.m2();
            LightStripDetailActivity.Q1(LightStripDetailActivity.this).f7254d.e(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class m implements Runnable {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LightStateBean f7538d;

        m(LightStateBean lightStateBean) {
            this.f7538d = lightStateBean;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Pair k2 = LightStripDetailActivity.this.k2();
            LightStripDetailActivity.this.D2(((Number) k2.component1()).intValue(), ((Number) k2.component2()).intValue(), this.f7538d);
        }
    }

    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class n<T> implements Observer<IoTLightStripDevice> {
        n() {
        }

        /* renamed from: a */
        public final void onChanged(IoTLightStripDevice ioTLightStripDevice) {
            StringBuilder sb = new StringBuilder();
            sb.append("IoTLightStripDevice LightStripBriefInfo: ");
            sb.append(ioTLightStripDevice != null ? com.tplink.libtpnetwork.Utils.l.b(ioTLightStripDevice) : null);
            b.d.w.c.a.n("LightStrip", sb.toString());
            LightStripDetailActivity.this.Q3 = ioTLightStripDevice;
            LightStripDetailActivity.this.L2();
            LightStripDetailActivity.this.J2(false);
        }
    }

    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class o<T> implements Observer<ThingUsage> {
        o() {
        }

        /* renamed from: a */
        public final void onChanged(ThingUsage thingUsage) {
            if (thingUsage != null) {
                LightStripDetailActivity.P1(LightStripDetailActivity.this).f7252f.o(thingUsage);
            }
        }
    }

    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class p<T> implements Observer<List<LightStateBean>> {
        p() {
        }

        /* renamed from: a */
        public final void onChanged(List<LightStateBean> list) {
            LightStripDetailActivity.this.R3 = list;
            if (list != null) {
                LightStripDetailActivity.this.z2(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class q implements View.OnClickListener {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LightStripDetailActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a implements b.q {

            /* compiled from: LightStripDetailActivity.kt */
            /* renamed from: com.tplink.iot.devices.lightstrip.view.LightStripDetailActivity$q$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            static final class C0202a<T> implements io.reactivex.g0.g<Boolean> {
                C0202a() {
                }

                /* renamed from: a */
                public final void accept(Boolean bool) {
                    LightStripDetailActivity.T1(LightStripDetailActivity.this).m0();
                }
            }

            /* compiled from: LightStripDetailActivity.kt */
            /* loaded from: classes2.dex */
            static final class b<T> implements io.reactivex.g0.g<Throwable> {
                b() {
                }

                /* renamed from: a */
                public final void accept(Throwable th) {
                    LightStripDetailActivity.T1(LightStripDetailActivity.this).m0();
                }
            }

            a() {
            }

            @Override // com.tplink.iot.k.c.b.q
            public final void a() {
                io.reactivex.q<Boolean> E;
                io.reactivex.q<Boolean> C;
                LightStripDetailActivity.this.J2(true);
                io.reactivex.q<Boolean> w0 = LightStripDetailActivity.T1(LightStripDetailActivity.this).w0();
                if (w0 != null && (E = w0.E(new C0202a())) != null && (C = E.C(new b())) != null) {
                    C.F0();
                }
            }
        }

        q() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.tplink.iot.k.c.b.n(LightStripDetailActivity.this, new a());
        }
    }

    public LightStripDetailActivity() {
        super(LightStripDetailViewModel.class);
        kotlin.f b2;
        kotlin.f b3;
        kotlin.f b4;
        kotlin.f a2;
        b2 = kotlin.i.b(new c());
        this.M3 = b2;
        b3 = kotlin.i.b(new e());
        this.N3 = b3;
        b4 = kotlin.i.b(new f());
        this.T3 = b4;
        a2 = kotlin.i.a(LazyThreadSafetyMode.NONE, new d());
        this.V3 = a2;
        kotlin.t.a aVar = kotlin.t.a.a;
        Boolean bool = Boolean.TRUE;
        this.W3 = new a(bool, bool, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A2(int i2, int i3) {
        if (this.g4) {
            RelativeLayout.LayoutParams layoutParams = this.e4;
            if (layoutParams == null) {
                kotlin.jvm.internal.j.t("lp");
            }
            layoutParams.leftMargin = i2;
            RelativeLayout.LayoutParams layoutParams2 = this.e4;
            if (layoutParams2 == null) {
                kotlin.jvm.internal.j.t("lp");
            }
            layoutParams2.topMargin = i3;
            ViewGroup viewGroup = this.Y3;
            if (viewGroup == null) {
                kotlin.jvm.internal.j.t("contentView");
            }
            View view = this.Z3;
            if (view == null) {
                kotlin.jvm.internal.j.t("guideView");
            }
            viewGroup.removeView(view);
            ViewGroup viewGroup2 = this.Y3;
            if (viewGroup2 == null) {
                kotlin.jvm.internal.j.t("contentView");
            }
            View view2 = this.Z3;
            if (view2 == null) {
                kotlin.jvm.internal.j.t("guideView");
            }
            viewGroup2.addView(view2);
        }
    }

    private final void B2(boolean z) {
        this.W3.a(this, K3[0], Boolean.valueOf(z));
    }

    private final void C2() {
        if (getSupportFragmentManager().findFragmentByTag("EditAutoDialog") == null) {
            EditAutoDialog G0 = EditAutoDialog.G0(o2());
            G0.I0(this);
            G0.show(getSupportFragmentManager(), "EditAutoDialog");
            kotlin.p pVar = kotlin.p.a;
            this.U3 = G0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public final void D2(int i2, int i3, LightStateBean lightStateBean) {
        if (!this.g4) {
            View findViewById = findViewById(16908290);
            kotlin.jvm.internal.j.d(findViewById, "findViewById(android.R.id.content)");
            this.Y3 = (ViewGroup) findViewById;
            ViewDataBinding inflate = DataBindingUtil.inflate(getLayoutInflater(), R.layout.layout_light_strip_guide_page, null, false);
            kotlin.jvm.internal.j.d(inflate, "DataBindingUtil.inflate(…_guide_page, null, false)");
            LayoutLightStripGuidePageBinding layoutLightStripGuidePageBinding = (LayoutLightStripGuidePageBinding) inflate;
            this.X3 = layoutLightStripGuidePageBinding;
            if (layoutLightStripGuidePageBinding == null) {
                kotlin.jvm.internal.j.t("mPresetGuideBinding");
            }
            View root = layoutLightStripGuidePageBinding.getRoot();
            kotlin.jvm.internal.j.d(root, "mPresetGuideBinding.root");
            this.Z3 = root;
            LayoutLightStripGuidePageBinding layoutLightStripGuidePageBinding2 = this.X3;
            if (layoutLightStripGuidePageBinding2 == null) {
                kotlin.jvm.internal.j.t("mPresetGuideBinding");
            }
            WaveView waveView = layoutLightStripGuidePageBinding2.p1;
            kotlin.jvm.internal.j.d(waveView, "mPresetGuideBinding.waveView");
            this.b4 = waveView;
            if (waveView == null) {
                kotlin.jvm.internal.j.t("waveView");
            }
            waveView.setColor(getResources().getColor(R.color.white));
            LayoutLightStripGuidePageBinding layoutLightStripGuidePageBinding3 = this.X3;
            if (layoutLightStripGuidePageBinding3 == null) {
                kotlin.jvm.internal.j.t("mPresetGuideBinding");
            }
            RelativeLayout relativeLayout = layoutLightStripGuidePageBinding3.x;
            kotlin.jvm.internal.j.d(relativeLayout, "mPresetGuideBinding.rlTop");
            this.a4 = relativeLayout;
            LayoutLightStripGuidePageBinding layoutLightStripGuidePageBinding4 = this.X3;
            if (layoutLightStripGuidePageBinding4 == null) {
                kotlin.jvm.internal.j.t("mPresetGuideBinding");
            }
            TextView textView = layoutLightStripGuidePageBinding4.p0;
            kotlin.jvm.internal.j.d(textView, "mPresetGuideBinding.tvGuideTips");
            this.d4 = textView;
            ViewGroup viewGroup = this.Y3;
            if (viewGroup == null) {
                kotlin.jvm.internal.j.t("contentView");
            }
            View view = this.Z3;
            if (view == null) {
                kotlin.jvm.internal.j.t("guideView");
            }
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            View view2 = this.a4;
            if (view2 == null) {
                kotlin.jvm.internal.j.t("rlTop");
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            this.e4 = layoutParams2;
            layoutParams2.leftMargin = i2;
            if (layoutParams2 == null) {
                kotlin.jvm.internal.j.t("lp");
            }
            layoutParams2.topMargin = i3;
            WaveView waveView2 = this.b4;
            if (waveView2 == null) {
                kotlin.jvm.internal.j.t("waveView");
            }
            waveView2.setDuration(1800L);
            WaveView waveView3 = this.b4;
            if (waveView3 == null) {
                kotlin.jvm.internal.j.t("waveView");
            }
            waveView3.j();
            View view3 = this.Z3;
            if (view3 == null) {
                kotlin.jvm.internal.j.t("guideView");
            }
            view3.setOnTouchListener(j.f7534c);
            LightingEffectData lightingEffectData = lightStateBean.getLightingEffectData();
            if (lightingEffectData != null) {
                List<Integer> t = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.t(lightingEffectData);
                if (com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.r(lightingEffectData)) {
                    Pair<List<Integer>, List<Integer>> g2 = com.tplink.iot.devices.lightstrip.lightingeffect.a.f7505b.g(t);
                    List<Integer> component1 = g2.component1();
                    List<Integer> component2 = g2.component2();
                    LayoutLightStripGuidePageBinding layoutLightStripGuidePageBinding5 = this.X3;
                    if (layoutLightStripGuidePageBinding5 == null) {
                        kotlin.jvm.internal.j.t("mPresetGuideBinding");
                    }
                    ColorPaintingRingView colorPaintingRingView = layoutLightStripGuidePageBinding5.q;
                    colorPaintingRingView.k(component1, component2);
                    kotlin.jvm.internal.j.d(colorPaintingRingView, "this");
                    this.c4 = colorPaintingRingView;
                } else {
                    com.tplink.iot.g.b.b.d b2 = PredefinedEffectsAdapter.h.b(lightingEffectData.name);
                    Integer num = lightingEffectData.custom;
                    if (num == null || num.intValue() != 0 || b2 == null) {
                        LayoutLightStripGuidePageBinding layoutLightStripGuidePageBinding6 = this.X3;
                        if (layoutLightStripGuidePageBinding6 == null) {
                            kotlin.jvm.internal.j.t("mPresetGuideBinding");
                        }
                        ColorEffectPlateView colorEffectPlateView = layoutLightStripGuidePageBinding6.f7258f;
                        colorEffectPlateView.k(t);
                        kotlin.jvm.internal.j.d(colorEffectPlateView, "this");
                        this.c4 = colorEffectPlateView;
                    } else {
                        LayoutLightStripGuidePageBinding layoutLightStripGuidePageBinding7 = this.X3;
                        if (layoutLightStripGuidePageBinding7 == null) {
                            kotlin.jvm.internal.j.t("mPresetGuideBinding");
                        }
                        CircleEffectImageView circleEffectImageView = layoutLightStripGuidePageBinding7.f7257d;
                        circleEffectImageView.setImageResource(b2.d());
                        kotlin.jvm.internal.j.d(circleEffectImageView, "this");
                        this.c4 = circleEffectImageView;
                    }
                }
            } else {
                LayoutLightStripGuidePageBinding layoutLightStripGuidePageBinding8 = this.X3;
                if (layoutLightStripGuidePageBinding8 == null) {
                    kotlin.jvm.internal.j.t("mPresetGuideBinding");
                }
                SelectableColorPointView selectableColorPointView = layoutLightStripGuidePageBinding8.z;
                selectableColorPointView.setColor(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.v(lightStateBean));
                kotlin.jvm.internal.j.d(selectableColorPointView, "this");
                this.c4 = selectableColorPointView;
            }
            LightingEffectBaseView lightingEffectBaseView = this.c4;
            if (lightingEffectBaseView == null) {
                kotlin.jvm.internal.j.t("mPresetExampleView");
            }
            lightingEffectBaseView.setVisibility(0);
            LayoutLightStripGuidePageBinding layoutLightStripGuidePageBinding9 = this.X3;
            if (layoutLightStripGuidePageBinding9 == null) {
                kotlin.jvm.internal.j.t("mPresetGuideBinding");
            }
            layoutLightStripGuidePageBinding9.f7256c.setOnClickListener(new k());
            LightingEffectBaseView lightingEffectBaseView2 = this.c4;
            if (lightingEffectBaseView2 == null) {
                kotlin.jvm.internal.j.t("mPresetExampleView");
            }
            lightingEffectBaseView2.setOnClickListener(new l());
            this.g4 = true;
        }
    }

    private final void E2() {
        List<? extends LightStateBean> list;
        BaseALIoTDevice<?> p1;
        if (!this.g4 && (list = this.R3) != null) {
            ScrollLayout scrollLayout = q1().K3;
            kotlin.jvm.internal.j.d(scrollLayout, "mBinding.scrollDownLayout");
            boolean z = scrollLayout.getCurrentStatus() == ScrollLayout.Status.CLOSED;
            com.tplink.libtpnetwork.Utils.o h0 = com.tplink.libtpnetwork.Utils.o.h0();
            kotlin.jvm.internal.j.d(h0, "SP.instance()");
            if (!h0.T() && !z && (p1 = p1()) != null && p1.isDeviceOn() && list.size() >= 2) {
                com.tplink.libtpnetwork.Utils.o h02 = com.tplink.libtpnetwork.Utils.o.h0();
                kotlin.jvm.internal.j.d(h02, "SP.instance()");
                h02.Y0(true);
                t1().f7254d.post(new m((LightStateBean) list.get(1)));
            }
        }
    }

    private final void F2() {
        int color = getResources().getColor(R.color.white);
        ActivityBaseIotDeviceDetailBinding q1 = q1();
        q1.p2.setImageResource(R.mipmap.ic_white_back);
        q1.I3.setImageResource(R.mipmap.ic_setting_white);
        q1.N3.setTextColor(color);
        q1.L3.setTextColor(color);
        q1.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), R.mipmap.ic_location_gray, null), (Drawable) null, (Drawable) null, (Drawable) null);
        s2().j(false, 0, 0);
        q2().d(false, 0);
        I2(null, color, false);
    }

    private final void G2(IoTLightStripDevice ioTLightStripDevice) {
        List<Integer> b2;
        int r2 = r2();
        ActivityBaseIotDeviceDetailBinding q1 = q1();
        q1.p2.setImageResource(R.mipmap.ic_grey_back);
        q1.I3.setImageResource(R.mipmap.ic_setting_black);
        q1.N3.setTextColor(r2);
        q1.L3.setTextColor(r2);
        q1.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), R.mipmap.ic_location_black, null), (Drawable) null, (Drawable) null, (Drawable) null);
        if (v2()) {
            M2();
            return;
        }
        int v = com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.v(new LightStateBean(ioTLightStripDevice.getHue(), ioTLightStripDevice.getSaturation(), ioTLightStripDevice.getColorTemp(), ioTLightStripDevice.getBrightness()));
        I2(null, r2, false);
        int h2 = h2(ioTLightStripDevice.getColorTemp(), ioTLightStripDevice.getColorTempRange());
        b2 = kotlin.collections.m.b(Integer.valueOf(v));
        H2(b2, ioTLightStripDevice.getBrightness(), h2);
    }

    private final void H2(List<Integer> list, int i2, int i3) {
        s2().m(list);
        q2().f(list);
        s2().j(true, i2, i3);
        q2().d(true, i2);
    }

    private final void I2(String str, int i2, boolean z) {
        TextView textView = t1().z;
        textView.setVisibility(z ^ true ? 4 : 0);
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        textView.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J2(boolean z) {
        IoTLightStripDevice ioTLightStripDevice = this.Q3;
        if (!w2() || z) {
            TextView textView = q1().N3;
            kotlin.jvm.internal.j.d(textView, "mBinding.tvName");
            textView.setVisibility(0);
            TextView textView2 = q1().M3;
            kotlin.jvm.internal.j.d(textView2, "mBinding.tvMusicRhythmMode");
            textView2.setVisibility(8);
            ImageView imageView = q1().p3;
            kotlin.jvm.internal.j.d(imageView, "mBinding.ivBg");
            imageView.setVisibility(8);
            TextView textView3 = q1().N3;
            kotlin.jvm.internal.j.d(textView3, "mBinding.tvName");
            textView3.setText(v1().s().getValue());
            LinearLayout linearLayout = t1().x;
            kotlin.jvm.internal.j.d(linearLayout, "mContentExtBinding.normalLightstripDetail");
            linearLayout.setVisibility(0);
            RelativeLayout relativeLayout = t1().y;
            kotlin.jvm.internal.j.d(relativeLayout, "mContentExtBinding.rhythmingDetail");
            relativeLayout.setVisibility(8);
            if (v1().h0()) {
                s1().f7250c.c(4, 1.0f);
                return;
            }
            return;
        }
        TextView textView4 = q1().N3;
        kotlin.jvm.internal.j.d(textView4, "mBinding.tvName");
        textView4.setVisibility(8);
        TextView textView5 = q1().M3;
        kotlin.jvm.internal.j.d(textView5, "mBinding.tvMusicRhythmMode");
        textView5.setVisibility(0);
        TextView textView6 = q1().M3;
        kotlin.jvm.internal.j.d(textView6, "mBinding.tvMusicRhythmMode");
        String str = null;
        textView6.setText(com.tplink.iot.k.c.b.e(ioTLightStripDevice != null ? ioTLightStripDevice.getMusicRhythmMode() : null));
        ImageView imageView2 = q1().p3;
        kotlin.jvm.internal.j.d(imageView2, "mBinding.ivBg");
        imageView2.setVisibility(0);
        LinearLayout linearLayout2 = t1().x;
        kotlin.jvm.internal.j.d(linearLayout2, "mContentExtBinding.normalLightstripDetail");
        linearLayout2.setVisibility(8);
        RelativeLayout relativeLayout2 = t1().y;
        kotlin.jvm.internal.j.d(relativeLayout2, "mContentExtBinding.rhythmingDetail");
        relativeLayout2.setVisibility(0);
        s1().f7250c.c(4, 0.4f);
        q1().p3.setBackgroundResource(R.mipmap.music_rhythm_main_bg);
        LottieAnimationView lottieAnimationView = t1().f7255f;
        if (ioTLightStripDevice != null) {
            str = ioTLightStripDevice.getMusicRhythmMode();
        }
        com.tplink.iot.k.c.b.p(lottieAnimationView, str);
        t1().q.setOnClickListener(new q());
        F2();
    }

    private final void K2(boolean z) {
        LightingEffectPresetLayout lightingEffectPresetLayout = t1().f7254d;
        kotlin.jvm.internal.j.d(lightingEffectPresetLayout, "mContentExtBinding.lightingEffectPreset");
        lightingEffectPresetLayout.setVisibility(z ^ true ? 4 : 0);
        if (!z) {
            l2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L2() {
        IoTLightStripDevice ioTLightStripDevice = this.Q3;
        if (ioTLightStripDevice == null || !ioTLightStripDevice.isDeviceOn()) {
            F2();
            K2(false);
            m2();
            return;
        }
        G2(ioTLightStripDevice);
        K2(true);
        if (!w2()) {
            E2();
        }
    }

    private final void M2() {
        com.tplink.iot.g.b.b.d b2;
        String h2;
        List<Integer> d2;
        IoTLightStripDevice ioTLightStripDevice = this.Q3;
        LightingEffectData lightingEffectData = ioTLightStripDevice != null ? ioTLightStripDevice.getLightingEffectData() : null;
        if (lightingEffectData == null) {
            d2 = kotlin.collections.n.d();
            H2(d2, 100, 0);
            I2(null, r2(), false);
            return;
        }
        if (!kotlin.jvm.internal.j.a(lightingEffectData.id, this.P3)) {
            l2();
        }
        H2(com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.u(lightingEffectData), com.tplink.iot.devices.lightstrip.lightingeffect.fromkasa.d.p(lightingEffectData), 0);
        String str = lightingEffectData.name;
        Integer num = lightingEffectData.custom;
        if (!(num == null || num.intValue() != 0 || str == null || (b2 = PredefinedEffectsAdapter.h.b(str)) == null || (h2 = b2.h()) == null)) {
            str = h2;
        }
        I2(str, r2(), true);
    }

    public static final /* synthetic */ LayoutLightStripDetailBottomExtBinding P1(LightStripDetailActivity lightStripDetailActivity) {
        return lightStripDetailActivity.s1();
    }

    public static final /* synthetic */ LayoutLightStripDetailContentExtBinding Q1(LightStripDetailActivity lightStripDetailActivity) {
        return lightStripDetailActivity.t1();
    }

    public static final /* synthetic */ LightingEffectBaseView R1(LightStripDetailActivity lightStripDetailActivity) {
        LightingEffectBaseView lightingEffectBaseView = lightStripDetailActivity.c4;
        if (lightingEffectBaseView == null) {
            kotlin.jvm.internal.j.t("mPresetExampleView");
        }
        return lightingEffectBaseView;
    }

    public static final /* synthetic */ LayoutLightStripGuidePageBinding S1(LightStripDetailActivity lightStripDetailActivity) {
        LayoutLightStripGuidePageBinding layoutLightStripGuidePageBinding = lightStripDetailActivity.X3;
        if (layoutLightStripGuidePageBinding == null) {
            kotlin.jvm.internal.j.t("mPresetGuideBinding");
        }
        return layoutLightStripGuidePageBinding;
    }

    public static final /* synthetic */ LightStripDetailViewModel T1(LightStripDetailActivity lightStripDetailActivity) {
        return lightStripDetailActivity.v1();
    }

    public static final /* synthetic */ TextView V1(LightStripDetailActivity lightStripDetailActivity) {
        TextView textView = lightStripDetailActivity.d4;
        if (textView == null) {
            kotlin.jvm.internal.j.t("tvGuideTips");
        }
        return textView;
    }

    private final int h2(int i2, int[] iArr) {
        if (i2 == 0 || !com.tplink.iot.g.b.c.c.l(iArr, v1().f0())) {
            return i2;
        }
        I2(getString(R.string.color_temperature_daylight), r2(), true);
        return 0;
    }

    private final void i2(com.tplink.iot.g.b.b.e.a aVar) {
        if (aVar instanceof com.tplink.iot.g.b.b.c) {
            v1().t0(((com.tplink.iot.g.b.b.c) aVar).e());
        } else if (aVar instanceof com.tplink.iot.g.b.b.a) {
            LightingEffectData g2 = ((com.tplink.iot.g.b.b.a) aVar).g();
            if (g2 != null) {
                v1().u0(g2);
            }
        } else if (aVar instanceof com.tplink.iot.g.b.b.b) {
            LightingEffectData f2 = ((com.tplink.iot.g.b.b.b) aVar).f();
            if (f2 != null) {
                v1().u0(f2);
            }
        } else if (aVar instanceof com.tplink.iot.g.b.b.d) {
            com.tplink.iot.g.b.b.d dVar = (com.tplink.iot.g.b.b.d) aVar;
            if (dVar.i()) {
                LightStateBean c2 = dVar.c();
                if (c2 != null) {
                    v1().t0(c2);
                    return;
                }
                return;
            }
            LightingEffectData g3 = dVar.g();
            if (g3 != null) {
                v1().u0(g3);
            }
        }
    }

    private final List<MultiFeaturesGridView.c> j2() {
        List<MultiFeaturesGridView.c> h2;
        h2 = kotlin.collections.n.h(new MultiFeaturesGridView.c(R.mipmap.plug_ic_schedule, R.string.plug_schedule, 0), new MultiFeaturesGridView.c(R.mipmap.plug_ic_away, R.string.plug_mode_away, 1), new MultiFeaturesGridView.c(R.mipmap.plug_ic_timer, R.string.plug_timer, 2));
        if (v1().g0()) {
            h2.add(0, new MultiFeaturesGridView.c(R.mipmap.icon_effects, R.string.light_strip_effects, 3));
        }
        if (v1().h0()) {
            h2.add(0, new MultiFeaturesGridView.c(R.mipmap.music_rhythm, R.string.music_rhythm, 4));
        }
        return h2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Integer, Integer> k2() {
        Rect rect = new Rect();
        t1().f7254d.getGlobalVisibleRect(rect);
        return kotlin.n.a(Integer.valueOf((rect.left + p2(v1().e0() ? 124 : 66)) - p2(12)), Integer.valueOf(rect.top - p2(12)));
    }

    private final void l2() {
        this.P3 = null;
        t1().f7254d.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m2() {
        if (this.g4) {
            this.g4 = false;
            WaveView waveView = this.b4;
            if (waveView == null) {
                kotlin.jvm.internal.j.t("waveView");
            }
            waveView.k();
            ViewGroup viewGroup = this.Y3;
            if (viewGroup == null) {
                kotlin.jvm.internal.j.t("contentView");
            }
            View view = this.Z3;
            if (view == null) {
                kotlin.jvm.internal.j.t("guideView");
            }
            viewGroup.removeView(view);
        }
    }

    private final void n2(int i2, LightStateBean lightStateBean) {
        EditPresetRule editPresetRule = new EditPresetRule();
        editPresetRule.setIndex(i2);
        editPresetRule.setState(lightStateBean);
        v1().O(editPresetRule);
    }

    private final String o2() {
        String autoMode;
        IoTLightStripDevice ioTLightStripDevice = this.Q3;
        return (ioTLightStripDevice == null || (autoMode = ioTLightStripDevice.getAutoMode()) == null) ? AutoLightBean.MODE_LIGHT_TRACK : autoMode;
    }

    private final int p2(int i2) {
        Resources resources = getResources();
        kotlin.jvm.internal.j.d(resources, "resources");
        return (int) TypedValue.applyDimension(1, i2, resources.getDisplayMetrics());
    }

    private final LightStripDetailBgLayout q2() {
        return (LightStripDetailBgLayout) this.M3.getValue();
    }

    private final int r2() {
        return ((Number) this.V3.getValue()).intValue();
    }

    private final LightStripControllerLayout s2() {
        return (LightStripControllerLayout) this.N3.getValue();
    }

    private final DeviceLocationCheckFragment t2() {
        return (DeviceLocationCheckFragment) this.T3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u2() {
        List<MultiFeaturesGridView.c> j2 = j2();
        int i2 = 4;
        if (j2.size() != 4) {
            i2 = 3;
        }
        MultiFeaturesGridView multiFeaturesGridView = s1().f7250c;
        multiFeaturesGridView.d(i2);
        multiFeaturesGridView.setFeatureData(j2);
        multiFeaturesGridView.setOnFeatureItemClickListener(this);
    }

    private final boolean v2() {
        IoTLightStripDevice ioTLightStripDevice = this.Q3;
        return ioTLightStripDevice != null && ioTLightStripDevice.isLightingEffectEnabled();
    }

    private final boolean w2() {
        if (v1().h0() && !v1().d0()) {
            IoTLightStripDevice ioTLightStripDevice = this.Q3;
            if (kotlin.jvm.internal.j.a(ioTLightStripDevice != null ? ioTLightStripDevice.isMusicRhythmEnable() : null, Boolean.TRUE)) {
                return true;
            }
        }
        return false;
    }

    public static final void x2(Context context, String str) {
        L3.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final void y2() {
        String str;
        s0.m(this, getString(R.string.common_waiting));
        BaseALIoTDevice<?> p1 = p1();
        if (p1 != null && p1.isUserRoleTypeDevice()) {
            LightStripDetailViewModel v1 = v1();
            BaseALIoTDevice<?> p12 = p1();
            if (p12 == null || (str = p12.getDeviceIdMD5()) == null) {
                str = "";
            }
            if (!v1.i0(str)) {
                s0.g();
                com.tplink.iot.k.c.b.o(this);
                return;
            }
        }
        v1().n0(p1()).l0(io.reactivex.d0.b.a.a()).H0(new h(), new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z2(List<? extends LightStateBean> list) {
        t1().f7254d.o(com.tplink.iot.devices.lightstrip.lightingeffect.a.f7505b.f(list));
        if (!w2()) {
            E2();
        }
    }

    @Override // com.tplink.iot.devices.lightstrip.view.LightStripLightSettingsFragment.b
    public void A(LightStateBean lightState) {
        kotlin.jvm.internal.j.e(lightState, "lightState");
        LightStripLightSettingsFragment.b.a.a(this, lightState);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public void A1() {
        super.A1();
        NextEventFeature.f7386c.a(this, s1().f7251d).f(v1().b0());
        ImageView imageView = q1().p3;
        kotlin.jvm.internal.j.d(imageView, "mBinding.ivBg");
        imageView.setVisibility(8);
        q1().y.addView(q2(), 0, new ViewGroup.LayoutParams(-1, -1));
        LightStripDetailBgLayout q2 = q2();
        LightingEffectPresetLayout lightingEffectPresetLayout = t1().f7254d;
        kotlin.jvm.internal.j.d(lightingEffectPresetLayout, "mContentExtBinding.lightingEffectPreset");
        q2.b(lightingEffectPresetLayout);
        LightingEffectPresetLayout lightingEffectPresetLayout2 = t1().f7254d;
        lightingEffectPresetLayout2.setAutoLightViewVisible(v1().e0());
        lightingEffectPresetLayout2.setPresetCallback(this);
        u2();
        s2().setControllerStateListener(this);
        t2().S0(this);
    }

    @Override // com.tplink.iot.devices.lightstrip.view.LightStripLightSettingsFragment.b
    public void B0(String effectId) {
        kotlin.jvm.internal.j.e(effectId, "effectId");
        LightStripLightSettingsFragment.b.a.b(this, effectId);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public void B1() {
        if (v1().g0()) {
            v1().k0();
            v1().l0();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    protected void C1(com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> iVar) {
        super.C1(iVar);
        q1().f6500c.post(new g());
    }

    @Override // com.tplink.iot.devices.lightstrip.widget.LightStripControllerLayout.a
    public void E(int i2) {
        q2().d(true, i2);
    }

    @Override // com.tplink.iot.devices.lightstrip.view.LightStripLightSettingsFragment.b
    public void I(LightStateBean lightStateBean) {
        int i2 = this.O3;
        if (i2 != -1 && lightStateBean != null) {
            n2(i2, lightStateBean);
        }
    }

    @Override // com.tplink.iot.view.colorbulb.EditAutoDialog.a
    public void J0(String str) {
        if (str != null) {
            v1().q0(new AutoLightBean(true, str));
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public void J1() {
        super.J1();
        v1().Q().observe(this, new n());
        v1().T().observe(this, new o());
        v1().V().observe(this, new p());
    }

    @Override // com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetLayout.b
    public void V() {
        C2();
    }

    @Override // com.tplink.iot.devicecommon.view.DeviceLocationCheckFragment.b
    public void X() {
        t1().f7254d.j();
        v1().q0(new AutoLightBean(true, o2()));
        C2();
    }

    @Override // com.tplink.iot.devices.lightstrip.view.LightStripLightSettingsFragment.b
    public void c0(String predefinedEffectId) {
        kotlin.jvm.internal.j.e(predefinedEffectId, "predefinedEffectId");
        LightStripLightSettingsFragment.b.a.c(this, predefinedEffectId);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public int h1() {
        return R.layout.layout_light_strip_detail_bottom_ext;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public int i1() {
        return s1().f7250c.getFirstRowHeight();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public int j1() {
        return R.layout.layout_light_strip_detail_content_ext;
    }

    @Override // com.tplink.iot.devices.lightstrip.view.LightStripLightSettingsFragment.b
    public void k0(LightStateBean lightState) {
        kotlin.jvm.internal.j.e(lightState, "lightState");
        LightStripLightSettingsFragment.b.a.d(this, lightState);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public Class<? extends AppCompatActivity> k1() {
        return LightStripSettingsActivity.class;
    }

    @Override // com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetLayout.b
    public void l0(com.tplink.iot.g.b.b.e.a data, int i2) {
        kotlin.jvm.internal.j.e(data, "data");
        this.P3 = com.tplink.iot.g.b.b.e.b.a(data);
        if (!data.a()) {
            if (i2 != t1().f7254d.getSelectedPresetEffectPos()) {
                i2(data);
            }
            t1().f7254d.k(i2);
        } else if (getSupportFragmentManager().findFragmentByTag("LightSettingDialogFragment") == null) {
            this.O3 = i2;
            List<LightStateBean> value = v1().V().getValue();
            LightStripLightSettingsFragment a2 = LightStripLightSettingsFragment.q.a(u1(), 1, value != null ? (LightStateBean) kotlin.collections.l.z(value, i2) : null);
            a2.g1(this);
            a2.show(getSupportFragmentManager(), "LightSettingDialogFragment");
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public String l1() {
        String string = getString(R.string.bulb_param);
        kotlin.jvm.internal.j.d(string, "getString(R.string.bulb_param)");
        return string;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public String m1() {
        String string = getString(R.string.iot_light_strips);
        kotlin.jvm.internal.j.d(string, "getString(R.string.iot_light_strips)");
        return string;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public EnumFeedbackCategory n1(BaseALIoTDevice<?> device) {
        kotlin.jvm.internal.j.e(device, "device");
        return EnumFeedbackCategory.LIGHT_STRIP;
    }

    @Override // com.tplink.iot.widget.viewgroup.MultiFeaturesGridView.e
    public void o0(int i2) {
        if (i2 == 0) {
            ScheduleListActivity.o1(this, u1(), true);
        } else if (i2 == 1) {
            X0(AwayModeActivity.class, u1());
        } else if (i2 == 2) {
            X0(TimerActivity.class, u1());
        } else if (i2 == 3) {
            X0(LightStripEffectsActivity.class, u1());
        } else if (i2 == 4) {
            if (!w2()) {
                y2();
            } else {
                com.tplink.iot.k.c.b.m(this);
            }
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        v1().S();
        B2(v1().g0());
        if (v1().g0()) {
            v1().U();
        }
        if (v1().j0()) {
            v1().c0();
        }
        boolean e0 = v1().e0();
        t1().f7254d.setAutoLightViewVisible(e0);
        if (e0) {
            v1().P();
        }
    }

    @Override // com.tplink.iot.devices.lightstrip.widget.LightingEffectPresetLayout.b
    public void q() {
        t2().I0(u1());
    }

    @Override // com.tplink.iot.devices.lightstrip.widget.LightStripControllerLayout.a
    public void v0(boolean z) {
        v1().s0(z);
        com.tplink.iot.Utils.x0.i.e(u1(), z);
    }

    @Override // com.tplink.iot.devices.lightstrip.widget.LightStripControllerLayout.a
    public void w(int i2, boolean z) {
        if (v2()) {
            v1().v0(i2, z);
        } else {
            v1().r0(i2, z);
        }
        if (z) {
            com.tplink.iot.Utils.x0.i.D(u1(), i2);
        }
    }
}
