package com.tplink.iot.devices.trv.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Observer;
import com.tplink.iot.R;
import com.tplink.iot.databinding.LayoutTrvDetailBottomExtBinding;
import com.tplink.iot.databinding.LayoutTrvDetailContentExtBinding;
import com.tplink.iot.devicecommon.feature.NextEventFeature;
import com.tplink.iot.devicecommon.view.IoTDetailBaseActivity;
import com.tplink.iot.devices.trv.view.TRVSetShutdownModeActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVDetailViewModel;
import com.tplink.iot.view.feature.ScheduleListActivity;
import com.tplink.iot.view.feature.TimerActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.widget.trv.RadialGradientBackgroundView;
import com.tplink.iot.widget.trv.TemperatureSlider;
import com.tplink.iot.widget.viewgroup.ToastTipBarView;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.ChildProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.FrostProtectionBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumTRVState;
import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;

/* compiled from: TRVDetailActivity.kt */
/* loaded from: classes2.dex */
public final class TRVDetailActivity extends IoTDetailBaseActivity<LayoutTrvDetailContentExtBinding, LayoutTrvDetailBottomExtBinding, TRVDetailViewModel> implements TemperatureSlider.a {
    public static final a K3 = new a(null);
    private final kotlin.f L3;
    private final kotlin.f M3;
    private final kotlin.f N3;
    private IoTSubDevice T3;
    private IoTSubDevice U3;
    private FrostProtectionBean W3;
    private final int O3 = Color.rgb(255, 177, 51);
    private final int P3 = Color.rgb(66, 229, 247);
    private final int Q3 = (int) 4292079870L;
    private final int R3 = (int) 4294113018L;
    private final com.tplink.iot.devicecommon.feature.a S3 = new com.tplink.iot.devicecommon.feature.a();
    private EnumTemperatureUnit V3 = EnumTemperatureUnit.CELSIUS;

    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceIdMD5) {
            kotlin.jvm.internal.j.e(context, "context");
            kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
            Intent intent = new Intent(context, TRVDetailActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            context.startActivity(intent);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements kotlin.jvm.b.a<RadialGradientBackgroundView> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final RadialGradientBackgroundView invoke() {
            return new RadialGradientBackgroundView(TRVDetailActivity.this, null, 0, 6, null);
        }
    }

    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<TemperatureSlider> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final TemperatureSlider invoke() {
            return TRVDetailActivity.L1(TRVDetailActivity.this).f7312f;
        }
    }

    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements kotlin.jvm.b.a<TextView> {
        d() {
            super(0);
        }

        /* renamed from: a */
        public final TextView invoke() {
            return TRVDetailActivity.L1(TRVDetailActivity.this).y;
        }
    }

    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class e<T> implements Observer<IoTSubDevice> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(IoTSubDevice ioTSubDevice) {
            TRVDetailActivity.this.T3 = ioTSubDevice;
            TRVDetailActivity.this.U3 = com.tplink.iot.g.d.a.b.a(ioTSubDevice);
            if (ioTSubDevice != null) {
                TRVDetailActivity tRVDetailActivity = TRVDetailActivity.this;
                EnumTemperatureUnit enumTempUnit = ioTSubDevice.getEnumTempUnit();
                kotlin.jvm.internal.j.d(enumTempUnit, "it.enumTempUnit");
                tRVDetailActivity.V3 = enumTempUnit;
                TRVDetailActivity.this.l2(ioTSubDevice);
            }
            b.d.w.c.a.n("TRV", "TRV Brief Info: " + com.tplink.libtpnetwork.Utils.l.j(ioTSubDevice));
        }
    }

    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class f<T> implements Observer<ChildProtectionBean> {
        f() {
        }

        /* renamed from: a */
        public final void onChanged(ChildProtectionBean childProtectionBean) {
            ImageView imageView = TRVDetailActivity.L1(TRVDetailActivity.this).f7310c;
            kotlin.jvm.internal.j.d(imageView, "mContentExtBinding.itemChildProtection");
            int i = 0;
            if (!(childProtectionBean != null ? childProtectionBean.getEnable() : false)) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class g<T> implements Observer<FrostProtectionBean> {
        g() {
        }

        /* renamed from: a */
        public final void onChanged(FrostProtectionBean frostProtectionBean) {
            TRVDetailActivity.this.W3 = frostProtectionBean;
        }
    }

    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class h<T> implements Observer<Integer> {
        h() {
        }

        /* renamed from: a */
        public final void onChanged(Integer num) {
            if (num != null) {
                TRVDetailActivity.this.b2(num.intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            new TRVErrorTroubleShootingFragment().show(TRVDetailActivity.this.getSupportFragmentManager(), (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TRVDetailActivity tRVDetailActivity = TRVDetailActivity.this;
            tRVDetailActivity.X0(TRVSetProgressCalibrationActivity.class, tRVDetailActivity.u1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TRVDetailActivity tRVDetailActivity = TRVDetailActivity.this;
            tRVDetailActivity.X0(TRVSetRemoveScaleActivity.class, tRVDetailActivity.u1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TRVDetailActivity.L1(TRVDetailActivity.this).q.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TRVDetailActivity.this.h2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TRVDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TRVSetShutdownModeActivity.a aVar = TRVSetShutdownModeActivity.p0;
            TRVDetailActivity tRVDetailActivity = TRVDetailActivity.this;
            aVar.a(tRVDetailActivity, tRVDetailActivity.u1(), true);
        }
    }

    public TRVDetailActivity() {
        super(TRVDetailViewModel.class);
        kotlin.f b2;
        kotlin.f b3;
        kotlin.f b4;
        b2 = kotlin.i.b(new d());
        this.L3 = b2;
        b3 = kotlin.i.b(new c());
        this.M3 = b3;
        b4 = kotlin.i.b(new b());
        this.N3 = b4;
    }

    public static final /* synthetic */ LayoutTrvDetailContentExtBinding L1(TRVDetailActivity tRVDetailActivity) {
        return tRVDetailActivity.t1();
    }

    private final void U1(IoTSubDevice ioTSubDevice) {
        if (c2(ioTSubDevice, EnumTRVState.FROST_PROTECTION)) {
            V1();
        } else if (c2(ioTSubDevice, EnumTRVState.HEATING)) {
            W1(ioTSubDevice);
        } else if (!com.tplink.iot.g.d.a.b.j(ioTSubDevice)) {
            i2(this.R3, -1);
        } else if (ioTSubDevice.isFrostProtectionOn()) {
            V1();
        } else {
            W1(ioTSubDevice);
        }
    }

    private final void V1() {
        i2(this.R3, R.mipmap.icon_freeze_proofing);
    }

    private final void W1(IoTSubDevice ioTSubDevice) {
        int i2;
        int i3 = this.R3;
        float currentTemp = ioTSubDevice.getCurrentTemp();
        float targetTemp = ioTSubDevice.getTargetTemp();
        int i4 = (currentTemp > targetTemp ? 1 : (currentTemp == targetTemp ? 0 : -1));
        if (i4 < 0) {
            i3 = this.O3;
            i2 = R.mipmap.icon_heating;
        } else if (i4 == 0) {
            i3 = this.P3;
            i2 = R.mipmap.icon_temp_balance_blue;
        } else if (currentTemp > targetTemp) {
            i3 = this.P3;
            i2 = R.mipmap.icon_cooling;
        } else {
            i2 = -1;
        }
        i2(i3, i2);
    }

    private final void X1(boolean z, int i2) {
        if (z) {
            V1();
            return;
        }
        IoTSubDevice ioTSubDevice = this.U3;
        if (ioTSubDevice != null) {
            ioTSubDevice.setTargetTemp(i2);
            W1(ioTSubDevice);
        }
    }

    private final RadialGradientBackgroundView Y1() {
        return (RadialGradientBackgroundView) this.N3.getValue();
    }

    private final TemperatureSlider Z1() {
        return (TemperatureSlider) this.M3.getValue();
    }

    private final TextView a2() {
        return (TextView) this.L3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(int i2) {
        if (i2 >= 3) {
            this.S3.b(this, p1());
        }
    }

    private final boolean c2(IoTSubDevice ioTSubDevice, EnumTRVState enumTRVState) {
        List<EnumTRVState> trvStates = ioTSubDevice.getTrvStates();
        if (trvStates != null) {
            return trvStates.contains(enumTRVState);
        }
        return false;
    }

    private final boolean d2(int i2, int i3) {
        FrostProtectionBean frostProtectionBean = this.W3;
        Integer valueOf = frostProtectionBean != null ? Integer.valueOf(frostProtectionBean.getMinTemp()) : null;
        return i2 == 0 || (valueOf != null && i3 <= valueOf.intValue());
    }

    public static final void e2(Context context, String str) {
        K3.a(context, str);
    }

    private final void f2(boolean z, boolean z2, boolean z3) {
        if (z) {
            Z1().n(z3);
        }
        TemperatureSlider mTempSlider = Z1();
        kotlin.jvm.internal.j.d(mTempSlider, "mTempSlider");
        mTempSlider.setEnabled(z2);
    }

    static /* synthetic */ void g2(TRVDetailActivity tRVDetailActivity, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z3 = true;
        }
        tRVDetailActivity.f2(z, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2() {
        com.tplink.iot.g.d.a.b.o(getSupportFragmentManager(), p1());
    }

    private final void i2(int i2, int i3) {
        Y1().b(i2);
        if (i3 != -1) {
            ImageView imageView = t1().f7311d;
            kotlin.jvm.internal.j.d(imageView, "mContentExtBinding.ivStateIcon");
            imageView.setVisibility(0);
            t1().f7311d.setImageResource(i3);
            return;
        }
        ImageView imageView2 = t1().f7311d;
        kotlin.jvm.internal.j.d(imageView2, "mContentExtBinding.ivStateIcon");
        imageView2.setVisibility(4);
        t1().f7311d.setImageDrawable(null);
    }

    private final void j2(String str, String str2, boolean z) {
        TextView mTvTRVState = a2();
        kotlin.jvm.internal.j.d(mTvTRVState, "mTvTRVState");
        mTvTRVState.setText(str);
        TextView textView = t1().z;
        int i2 = 0;
        if (str2 == null || str2.length() == 0) {
            i2 = 4;
        }
        textView.setVisibility(i2);
        textView.setText(str2);
        if (z) {
            a2().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ResourcesCompat.getDrawable(getResources(), R.mipmap.plug_arrow_right, null), (Drawable) null);
        } else {
            a2().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    static /* synthetic */ void k2(TRVDetailActivity tRVDetailActivity, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        tRVDetailActivity.j2(str, str2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void l2(IoTSubDevice ioTSubDevice) {
        TextView textView = t1().x;
        kotlin.jvm.internal.j.d(textView, "mContentExtBinding.tvTemperature");
        EnumTRVState enumTRVState = EnumTRVState.SHUTDOWN;
        textView.setText(c2(ioTSubDevice, enumTRVState) ? "--" : com.tplink.iot.g.d.a.b.c(ioTSubDevice.getCurrentTemp(), ioTSubDevice.getTempUnit()));
        U1(ioTSubDevice);
        Z1().p(ioTSubDevice.getMinControlTemp(), ioTSubDevice.getMaxControlTemp());
        a2().setOnClickListener(null);
        if (c2(ioTSubDevice, enumTRVState)) {
            a2().setOnClickListener(new n());
            String string = getString(R.string.trv_sleep_mode_on);
            kotlin.jvm.internal.j.d(string, "getString(R.string.trv_sleep_mode_on)");
            k2(this, string, null, true, 2, null);
            g2(this, true, false, false, 4, null);
        } else if (c2(ioTSubDevice, EnumTRVState.WINDOW_OPEN)) {
            String string2 = getString(R.string.trv_heating_paused);
            kotlin.jvm.internal.j.d(string2, "getString(R.string.trv_heating_paused)");
            k2(this, string2, null, false, 6, null);
            g2(this, true, true, false, 4, null);
        } else if (c2(ioTSubDevice, EnumTRVState.FROST_PROTECTION)) {
            m2();
        } else if (c2(ioTSubDevice, EnumTRVState.HEATING)) {
            n2(ioTSubDevice);
        } else if (!com.tplink.iot.g.d.a.b.j(ioTSubDevice)) {
            k2(this, "", null, false, 6, null);
            g2(this, true, false, false, 4, null);
        } else if (ioTSubDevice.isFrostProtectionOn()) {
            m2();
        } else {
            n2(ioTSubDevice);
        }
        if (c2(ioTSubDevice, EnumTRVState.DEVICE_ERROR)) {
            ToastTipBarView toastTipBarView = t1().q;
            toastTipBarView.setMessage(R.string.trv_device_error_tip);
            toastTipBarView.setActionText("");
            toastTipBarView.setArrowRightVisible(true);
            toastTipBarView.setOnTipBarClickListener(new i());
            toastTipBarView.b();
        } else if (c2(ioTSubDevice, EnumTRVState.PROGRESS_CALIBRATION)) {
            ToastTipBarView toastTipBarView2 = t1().q;
            toastTipBarView2.setMessage(R.string.trv_progress_calibration_on_tip);
            toastTipBarView2.setActionText("");
            toastTipBarView2.setArrowRightVisible(true);
            toastTipBarView2.setOnTipBarClickListener(new j());
            toastTipBarView2.b();
            g2(this, true, false, false, 4, null);
        } else if (c2(ioTSubDevice, EnumTRVState.REMOVING_SCALE)) {
            ToastTipBarView toastTipBarView3 = t1().q;
            toastTipBarView3.setMessage(R.string.trv_removing_scale);
            toastTipBarView3.setActionText("");
            toastTipBarView3.setArrowRightVisible(true);
            toastTipBarView3.setOnTipBarClickListener(new k());
            toastTipBarView3.b();
            g2(this, true, false, false, 4, null);
        } else if (c2(ioTSubDevice, EnumTRVState.WINDOW_OPEN)) {
            ToastTipBarView toastTipBarView4 = t1().q;
            toastTipBarView4.setMessage(R.string.trv_window_open_tip);
            toastTipBarView4.setActionText(R.string.share_device_share_device_got_it);
            toastTipBarView4.setArrowRightVisible(false);
            toastTipBarView4.setOnActionTextClickListener(new l());
            toastTipBarView4.b();
        } else if (c2(ioTSubDevice, EnumTRVState.LOW_BATTERY)) {
            ToastTipBarView toastTipBarView5 = t1().q;
            toastTipBarView5.setMessage(R.string.trv_low_battery_tip);
            toastTipBarView5.setActionText(R.string.trv_how_to_replace_battery);
            toastTipBarView5.setArrowRightVisible(false);
            toastTipBarView5.setOnActionTextClickListener(new m());
            toastTipBarView5.b();
        } else {
            t1().q.a();
        }
    }

    private final void m2() {
        String string = getString(R.string.common_off);
        kotlin.jvm.internal.j.d(string, "getString(R.string.common_off)");
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.j.d(locale, "Locale.getDefault()");
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        String upperCase = string.toUpperCase(locale);
        kotlin.jvm.internal.j.d(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        k2(this, upperCase, getString(R.string.trv_frost_protection), false, 4, null);
        g2(this, true, true, false, 4, null);
    }

    private final void n2(IoTSubDevice ioTSubDevice) {
        String string = getString(R.string.trv_setting_to_temp, new Object[]{com.tplink.iot.g.d.a.b.e(ioTSubDevice.getTargetTemp(), ioTSubDevice.getTempUnit())});
        kotlin.jvm.internal.j.d(string, "getString(R.string.trv_setting_to_temp, tempText)");
        k2(this, string, null, false, 6, null);
        Z1().m(ioTSubDevice.getTargetTemp(), true);
        g2(this, false, true, false, 4, null);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public void A1() {
        super.A1();
        NextEventFeature.f7386c.a(this, s1().y).f(v1().U());
        ImageView imageView = q1().p1;
        kotlin.jvm.internal.j.d(imageView, "mBinding.imgMoreLocal");
        imageView.setVisibility(8);
        ImageView imageView2 = q1().p3;
        kotlin.jvm.internal.j.d(imageView2, "mBinding.ivBg");
        imageView2.setVisibility(8);
        FrameLayout frameLayout = q1().x;
        kotlin.jvm.internal.j.d(frameLayout, "mBinding.flContentExt");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.height = -1;
        frameLayout.setLayoutParams(layoutParams);
        q1().y.addView(Y1(), 0, new ViewGroup.LayoutParams(-1, -1));
        Z1().setOnSliderChangeListener(this);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public void B1() {
        v1().Q();
        if (v1().Y()) {
            v1().M();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public void J1() {
        super.J1();
        v1().X().observe(this, new e());
        v1().N().observe(this, new f());
        v1().R().observe(this, new g());
        v1().O().observe(this, new h());
    }

    @Override // com.tplink.iot.widget.trv.TemperatureSlider.a
    @SuppressLint({"SetTextI18n"})
    public void N0(int i2, int i3) {
        if (d2(i2, i3)) {
            String string = getString(R.string.common_off);
            kotlin.jvm.internal.j.d(string, "getString(R.string.common_off)");
            Locale locale = Locale.getDefault();
            kotlin.jvm.internal.j.d(locale, "Locale.getDefault()");
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            String upperCase = string.toUpperCase(locale);
            kotlin.jvm.internal.j.d(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            k2(this, upperCase, getString(R.string.trv_frost_protection), false, 4, null);
            X1(true, i3);
            return;
        }
        String string2 = getString(R.string.trv_setting_to_temp, new Object[]{com.tplink.iot.g.d.a.b.d(i3, this.V3)});
        kotlin.jvm.internal.j.d(string2, "getString(R.string.trv_setting_to_temp, tempText)");
        k2(this, string2, null, false, 6, null);
        X1(false, i3);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public int h1() {
        return R.layout.layout_trv_detail_bottom_ext;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public int i1() {
        LinearLayout linearLayout = s1().q;
        kotlin.jvm.internal.j.d(linearLayout, "mBottomExtBinding.llRules");
        int measuredHeight = linearLayout.getMeasuredHeight();
        LinearLayout linearLayout2 = s1().x;
        kotlin.jvm.internal.j.d(linearLayout2, "mBottomExtBinding.llRules2");
        return measuredHeight + linearLayout2.getMeasuredHeight();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public int j1() {
        return R.layout.layout_trv_detail_content_ext;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public Class<? extends AppCompatActivity> k1() {
        return TRVSettingsActivity.class;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public String l1() {
        String string = getString(R.string.thermostat_param);
        kotlin.jvm.internal.j.d(string, "getString(R.string.thermostat_param)");
        return string;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public String m1() {
        String string = getString(R.string.iot_thermostats);
        kotlin.jvm.internal.j.d(string, "getString(R.string.iot_thermostats)");
        return string;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public EnumFeedbackCategory n1(BaseALIoTDevice<?> device) {
        kotlin.jvm.internal.j.e(device, "device");
        return EnumFeedbackCategory.TRV;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.item_child_protection) {
            BaseALIoTDevice<?> p1 = p1();
            if (p1 != null && !p1.isUserRoleTypeDevice()) {
                X0(TRVSetChildProtectionActivity.class, u1());
            }
        } else if ((valueOf != null && valueOf.intValue() == R.id.iv_schedule) || (valueOf != null && valueOf.intValue() == R.id.tv_schedule)) {
            ScheduleListActivity.o1(this, u1(), false);
        } else if ((valueOf != null && valueOf.intValue() == R.id.iv_timer) || (valueOf != null && valueOf.intValue() == R.id.tv_timer)) {
            X0(TimerActivity.class, u1());
        } else if ((valueOf != null && valueOf.intValue() == R.id.iv_record) || (valueOf != null && valueOf.intValue() == R.id.tv_record)) {
            X0(TRVTemperatureRecordActivity.class, u1());
        } else if (valueOf == null || valueOf.intValue() != R.id.card_local_only) {
            super.onClick(view);
        }
    }

    @Override // com.tplink.iot.widget.trv.TemperatureSlider.a
    public void y(int i2, int i3) {
        if (d2(i2, i3)) {
            v1().Z(true);
            g2(this, true, true, false, 4, null);
            return;
        }
        v1().a0(i3, this.V3);
    }
}
