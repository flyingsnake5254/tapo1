package com.tplink.iot.view.colorbulb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.d;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseLocationActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.view.cloudconnect.CloudConnectGetStateActivity;
import com.tplink.iot.view.colorbulb.EditAutoDialog;
import com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog;
import com.tplink.iot.view.colorbulb.effect.LightEffectConfigActivity;
import com.tplink.iot.view.colorbulb.settings.ColorBulbSettingsActivity;
import com.tplink.iot.view.deviceshare.ShareDeviceUserListActivity;
import com.tplink.iot.view.feature.AwayModeActivity;
import com.tplink.iot.view.feature.ScheduleListActivity;
import com.tplink.iot.view.feature.TimerActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.view.feedback.HelpAndFeedbackActivity;
import com.tplink.iot.viewmodel.iotbulb.BulbDetailViewModel;
import com.tplink.iot.viewmodel.iotbulb.LightEffectViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.WaveView;
import com.tplink.iot.widget.businessview.ThingNextEventView;
import com.tplink.iot.widget.businessview.ThingUsageView;
import com.tplink.iot.widget.colorbulb.ColorPointView;
import com.tplink.iot.widget.colorbulb.ColorPresetView;
import com.tplink.iot.widget.colorbulb.DetailBottomRuleViewV2;
import com.tplink.iot.widget.colorbulb.SimpleTextSwitcher;
import com.tplink.iot.widget.colorbulb.light.LightBgAnimView;
import com.tplink.iot.widget.colorbulb.light.LightBulbView;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result.BulbNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.yinglan.scrolllayout.ScrollLayout;
import java.util.List;

/* loaded from: classes2.dex */
public class ColorBulbDetailActivity extends BaseLocationActivity implements View.OnClickListener, LightBulbView.d, EditColorBulbPresetDialog.b, EditAutoDialog.a, DetailBottomRuleViewV2.a {
    private ImageView H3;
    private CardView I3;
    private CardView J3;
    private TextView K3;
    private TextView L3;
    private TextView M3;
    private TextView N3;
    private TextView O3;
    private SimpleTextSwitcher P3;
    private LightBulbView Q3;
    private ColorPresetView R3;
    private TPSwitchCompat S3;
    private ScrollLayout T3;
    private View U3;
    private View V3;
    private ThingNextEventView W3;
    private ThingUsageView X3;
    private LottieAnimationView Y3;
    private DetailBottomRuleViewV2 Z3;
    private View a4;
    private View b4;
    private View c4;
    private String d4;
    private BulbDetailViewModel e4;
    private LightEffectViewModel f4;
    private IoTBulbDevice g4;
    private BaseALIoTDevice h4;
    private List<LightStateBean> k4;
    private String m4;
    private ViewGroup o4;
    private View p0;
    private ImageView p1;
    private ImageView p2;
    private ImageView p3;
    private View p4;
    private View q4;
    private WaveView r4;
    private ColorPointView s4;
    private TextView t4;
    private RelativeLayout.LayoutParams u4;
    private LightBgAnimView z;
    private EditColorBulbPresetDialog i4 = null;
    private EditAutoDialog j4 = null;
    private boolean l4 = false;
    private ColorPresetView.a n4 = new d();
    private int v4 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<Boolean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                ColorBulbDetailActivity.this.I3.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> iVar) {
            if (iVar != null && iVar.b() == 0) {
                ColorBulbDetailActivity.this.a2(iVar.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            ColorBulbDetailActivity.this.R3.getGlobalVisibleRect(rect);
            ColorBulbDetailActivity.this.b2(rect.left + net.lucode.hackware.magicindicator.g.b.a(ColorBulbDetailActivity.this, 90.0d), rect.top - net.lucode.hackware.magicindicator.g.b.a(ColorBulbDetailActivity.this, 18.0d));
        }
    }

    /* loaded from: classes2.dex */
    class d implements ColorPresetView.a {
        d() {
        }

        @Override // com.tplink.iot.widget.colorbulb.ColorPresetView.a
        public void a(int i, LightStateBean lightStateBean) {
            ColorBulbDetailActivity.this.e4.Q(lightStateBean);
        }

        @Override // com.tplink.iot.widget.colorbulb.ColorPresetView.a
        public void b() {
            ColorBulbDetailActivity.this.c2();
        }

        @Override // com.tplink.iot.widget.colorbulb.ColorPresetView.a
        public void c(int i, int i2, LightStateBean lightStateBean) {
            ColorBulbDetailActivity.this.d2(i, lightStateBean);
            com.tplink.iot.Utils.x0.i.n(ColorBulbDetailActivity.this.d4, lightStateBean);
        }

        @Override // com.tplink.iot.widget.colorbulb.ColorPresetView.a
        public void d() {
            ColorBulbDetailActivity colorBulbDetailActivity = ColorBulbDetailActivity.this;
            colorBulbDetailActivity.f1(colorBulbDetailActivity.d4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LightStateBean f8404c;

        e(LightStateBean lightStateBean) {
            this.f8404c = lightStateBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            ColorBulbDetailActivity.this.R3.getGlobalVisibleRect(rect);
            ColorBulbDetailActivity.this.e2(rect.left + net.lucode.hackware.magicindicator.g.b.a(ColorBulbDetailActivity.this, 90.0d), rect.top - net.lucode.hackware.magicindicator.g.b.a(ColorBulbDetailActivity.this, 18.0d), com.tplink.iot.Utils.z0.i.a(this.f8404c.getHue(), this.f8404c.getSaturation()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f8407c;

        g(TextView textView) {
            this.f8407c = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ColorBulbDetailActivity.this.s4.b()) {
                this.f8407c.setText(R.string.action_got_it);
                ColorBulbDetailActivity.this.t4.setText(R.string.detail_page_guide_preset_tips2);
                ColorBulbDetailActivity.this.s4.setSelectedStatus(true);
                return;
            }
            ColorBulbDetailActivity.this.L1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f8409c;

        h(TextView textView) {
            this.f8409c = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ColorBulbDetailActivity.this.v4 == 0) {
                ColorBulbDetailActivity.this.s4.setSelectedStatus(true);
                this.f8409c.setText(R.string.action_got_it);
                ColorBulbDetailActivity.this.t4.setText(R.string.detail_page_guide_preset_tips2);
                ColorBulbDetailActivity.this.R3.b();
                ColorBulbDetailActivity.C1(ColorBulbDetailActivity.this);
                return;
            }
            ColorBulbDetailActivity.this.L1();
            ColorBulbDetailActivity.this.R3.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements ScrollLayout.g {
        i() {
        }

        @Override // com.yinglan.scrolllayout.ScrollLayout.g
        public void a(ScrollLayout.Status status) {
            if (status == ScrollLayout.Status.OPENED) {
                ColorBulbDetailActivity.this.H3.setImageResource(R.mipmap.ic_pull_up);
                ColorBulbDetailActivity.this.l4 = false;
            } else if (status == ScrollLayout.Status.CLOSED) {
                ColorBulbDetailActivity.this.H3.setImageResource(R.mipmap.ic_pull_down);
                ColorBulbDetailActivity.this.l4 = true;
            }
        }

        @Override // com.yinglan.scrolllayout.ScrollLayout.g
        public void b(float f2) {
        }

        @Override // com.yinglan.scrolllayout.ScrollLayout.g
        public void c(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements ThingNextEventView.d {
        j() {
        }

        @Override // com.tplink.iot.widget.businessview.ThingNextEventView.d
        public void a() {
            ColorBulbDetailActivity.this.e4.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class k implements TPSwitchCompat.a {
        k() {
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a
        public void c(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                ColorBulbDetailActivity.this.e4.n(z);
                com.tplink.iot.Utils.x0.i.x(ColorBulbDetailActivity.this.d4, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class l implements Observer<IoTBulbDevice> {
        l() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable IoTBulbDevice ioTBulbDevice) {
            ColorBulbDetailActivity.this.g4 = ioTBulbDevice;
            ColorBulbDetailActivity colorBulbDetailActivity = ColorBulbDetailActivity.this;
            colorBulbDetailActivity.q2(colorBulbDetailActivity.g4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class m implements Observer<List<LightStateBean>> {
        m() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<LightStateBean> list) {
            ColorBulbDetailActivity.this.p2(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class n implements Observer<BulbNextEvent> {
        n() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable BulbNextEvent bulbNextEvent) {
            ColorBulbDetailActivity.this.W3.r(bulbNextEvent, ColorBulbDetailActivity.this.e4.z());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class o implements Observer<ThingUsage> {
        o() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable ThingUsage thingUsage) {
            ColorBulbDetailActivity.this.X3.o(thingUsage);
            com.tplink.iot.Utils.x0.i.t(ColorBulbDetailActivity.this.d4, thingUsage);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class p implements Observer<BaseALIoTDevice> {
        p() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable BaseALIoTDevice baseALIoTDevice) {
            ColorBulbDetailActivity.this.o2(baseALIoTDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class q implements Observer<ThingFirmware> {
        q() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable ThingFirmware thingFirmware) {
            ColorBulbDetailActivity.this.p3.setVisibility((thingFirmware == null || !thingFirmware.isNeedToUpgrade()) ? 8 : 0);
        }
    }

    static /* synthetic */ int C1(ColorBulbDetailActivity colorBulbDetailActivity) {
        int i2 = colorBulbDetailActivity.v4;
        colorBulbDetailActivity.v4 = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1() {
        WaveView waveView = this.r4;
        if (waveView != null) {
            waveView.k();
        }
        View view = this.p4;
        if (view != null) {
            this.o4.removeView(view);
            this.p4 = null;
        }
    }

    private String M1() {
        IoTBulbDevice ioTBulbDevice = this.g4;
        return ioTBulbDevice != null ? ioTBulbDevice.getAutoMode() : AutoLightBean.MODE_LIGHT_TRACK;
    }

    private int N1() {
        BaseALIoTDevice baseALIoTDevice = this.h4;
        if (baseALIoTDevice == null || baseALIoTDevice.getDeviceManagerInfo() == null || this.h4.getDeviceManagerInfo().getUserInfo() == null || this.h4.getDeviceManagerInfo().getUserInfo().size() <= 1) {
            return 0;
        }
        return this.h4.getDeviceManagerInfo().getUserInfo().size() - 1;
    }

    private void O1() {
        if (this.h4 != null) {
            HelpAndFeedbackActivity.k1(this, "https://www.tapo.com/app/#/faqList2?categoryType=" + getString(R.string.bulb_param) + com.tplink.iot.model.about.d.a(), getString(R.string.iot_bulbs), this.h4.getDeviceType(), this.h4.getDeviceModel(), EnumFeedbackCategory.BULB);
        }
    }

    private void P1() {
        this.R3.setOnColorPresetCheckedListener(this.n4);
        this.S3.setOnSwitchCheckedChangeListener(new k());
    }

    private void Q1() {
        this.z = (LightBgAnimView) findViewById(R.id.color_bulb_bg_anim_view);
        this.O3 = (TextView) findViewById(R.id.tv_light_effect_name);
        this.p1 = (ImageView) findViewById(R.id.iv_back);
        this.p2 = (ImageView) findViewById(R.id.iv_setting);
        this.p3 = (ImageView) findViewById(R.id.iv_red_point);
        this.I3 = (CardView) findViewById(R.id.card_local_only);
        this.J3 = (CardView) findViewById(R.id.card_user_device);
        this.K3 = (TextView) findViewById(R.id.tv_name);
        this.L3 = (TextView) findViewById(R.id.tv_location);
        this.M3 = (TextView) findViewById(R.id.tv_color_temp_value);
        this.P3 = (SimpleTextSwitcher) findViewById(R.id.text_switcher);
        this.Q3 = (LightBulbView) findViewById(R.id.bulb_view);
        this.R3 = (ColorPresetView) findViewById(R.id.color_preset_view);
        this.a4 = findViewById(R.id.view_white_stub);
        this.S3 = (TPSwitchCompat) findViewById(R.id.switch_button);
        this.T3 = (ScrollLayout) findViewById(R.id.scroll_down_layout);
        this.V3 = findViewById(R.id.rl_common_device);
        this.U3 = findViewById(R.id.item_device_share);
        this.N3 = (TextView) findViewById(R.id.tv_person);
        this.H3 = (ImageView) findViewById(R.id.iv_pull_up_down);
        this.p0 = findViewById(R.id.ll_rules);
        this.Q3.m(this.z, this.R3, this.P3);
        int a2 = com.tplink.iot.Utils.k.a(this, 50.0f) + com.tplink.iot.view.quicksetup.base.d.A(this);
        ViewGroup.LayoutParams layoutParams = this.a4.getLayoutParams();
        layoutParams.height = a2;
        this.a4.setLayoutParams(layoutParams);
        this.T3.setMinOffset(a2);
        this.T3.setOnScrollChangedListener(new i());
        this.p0.post(new Runnable() { // from class: com.tplink.iot.view.colorbulb.c
            @Override // java.lang.Runnable
            public final void run() {
                ColorBulbDetailActivity.this.U1();
            }
        });
        ThingNextEventView thingNextEventView = (ThingNextEventView) findViewById(R.id.next_event_view);
        this.W3 = thingNextEventView;
        thingNextEventView.setOnNextEventCallback(new j());
        this.X3 = (ThingUsageView) findViewById(R.id.device_usage_view);
        this.b4 = findViewById(R.id.layout_light_normal);
        this.c4 = findViewById(R.id.layout_light_effect);
        this.Y3 = (LottieAnimationView) findViewById(R.id.lottie_animation_view);
        DetailBottomRuleViewV2 detailBottomRuleViewV2 = (DetailBottomRuleViewV2) findViewById(R.id.bottom_rule_view_v2);
        this.Z3 = detailBottomRuleViewV2;
        detailBottomRuleViewV2.setSupportLightEffect(this.e4.H());
        this.Z3.setOnBottomRuleClickListener(this);
        findViewById(R.id.tv_exit_light_effect).setOnClickListener(this);
        findViewById(R.id.tv_edit_light_effect_scene).setOnClickListener(this);
        this.Q3.setOnBulbOperationListener(this);
        this.p1.setOnClickListener(this);
        this.p2.setOnClickListener(this);
        this.I3.setOnClickListener(this);
        findViewById(R.id.iv_pull_up_down).setOnClickListener(this);
        this.U3.setOnClickListener(this);
        findViewById(R.id.item_faq_feedback).setOnClickListener(this);
        P1();
    }

    private boolean R1() {
        ALIoTDevice b2 = com.tplink.iot.Utils.w0.a.b(this.d4);
        return b2 != null && b2.getThingDevice() == null;
    }

    private boolean S1() {
        BaseALIoTDevice baseALIoTDevice = this.h4;
        return baseALIoTDevice != null && baseALIoTDevice.isUserRoleTypeDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T1 */
    public /* synthetic */ void U1() {
        int measuredHeight = findViewById(R.id.root).getMeasuredHeight() - this.T3.getScreenHeight();
        int measuredHeight2 = this.p0.getMeasuredHeight();
        int measuredHeight3 = this.H3.getMeasuredHeight();
        if (measuredHeight2 > 0 && measuredHeight3 > 0) {
            this.T3.setMaxOffset((measuredHeight2 + measuredHeight3) - measuredHeight);
            this.T3.r();
        }
        int i2 = measuredHeight2 + measuredHeight3;
        if (((ViewGroup.MarginLayoutParams) this.b4.getLayoutParams()).bottomMargin < i2) {
            ((ViewGroup.MarginLayoutParams) this.b4.getLayoutParams()).bottomMargin = i2;
            this.b4.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V1 */
    public /* synthetic */ void W1(List list) {
        this.O3.setText(this.f4.j(this.m4));
        this.Z3.a(this.f4.j("L1"), this.f4.j("L2"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X1 */
    public /* synthetic */ void Y1(Boolean bool) {
        if (org.apache.commons.lang.b.b(bool)) {
            this.e4.S();
        }
    }

    public static void Z1(Context context, String str) {
        Intent intent = new Intent(context, ColorBulbDetailActivity.class);
        intent.putExtra("device_id_md5", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2(CloudConnectStateResult cloudConnectStateResult) {
        if (cloudConnectStateResult != null) {
            int i2 = 8;
            if (cloudConnectStateResult.getStatus() == 0) {
                this.I3.setVisibility(8);
            } else {
                CardView cardView = this.I3;
                if (R1()) {
                    i2 = 0;
                }
                cardView.setVisibility(i2);
            }
            this.I3.post(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b2(int i2, int i3) {
        View view = this.p4;
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = this.u4;
            layoutParams.leftMargin = i2;
            layoutParams.topMargin = i3;
            this.o4.removeView(view);
            this.o4.addView(this.p4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c2() {
        if (getSupportFragmentManager().findFragmentByTag("EditAutoDialog") == null) {
            EditAutoDialog G0 = EditAutoDialog.G0(M1());
            this.j4 = G0;
            G0.show(getSupportFragmentManager(), "EditAutoDialog");
            this.j4.I0(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2(int i2, LightStateBean lightStateBean) {
        if (getSupportFragmentManager().findFragmentByTag("EditColorBulbPresetDialog") == null) {
            EditColorBulbPresetDialog I0 = EditColorBulbPresetDialog.I0(true, i2, lightStateBean);
            this.i4 = I0;
            I0.show(getSupportFragmentManager(), "EditColorBulbPresetDialog");
            this.i4.J0(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2(int i2, int i3, int i4) {
        this.o4 = (ViewGroup) findViewById(16908290);
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_color_bulb_guide_page, (ViewGroup) null);
        this.p4 = inflate;
        this.s4 = (ColorPointView) inflate.findViewById(R.id.guide_color_point);
        WaveView waveView = (WaveView) this.p4.findViewById(R.id.wave_view);
        this.r4 = waveView;
        waveView.setColor(getResources().getColor(R.color.white));
        this.q4 = this.p4.findViewById(R.id.rl_top);
        this.t4 = (TextView) this.p4.findViewById(R.id.tv_guide_tips);
        TextView textView = (TextView) this.p4.findViewById(R.id.btn_skip);
        this.s4.c(i4, -1, -1);
        this.o4.addView(this.p4, new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q4.getLayoutParams();
        this.u4 = layoutParams;
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        this.r4.setDuration(1800L);
        this.r4.j();
        this.p4.setOnTouchListener(new f());
        textView.setOnClickListener(new g(textView));
        this.s4.setOnClickListener(new h(textView));
    }

    private void f2() {
        List<LightStateBean> list;
        if (!com.tplink.libtpnetwork.Utils.o.h0().D() && !this.l4 && this.Q3.getOnStatus() && (list = this.k4) != null && list.size() >= 2) {
            com.tplink.libtpnetwork.Utils.o.h0().F0(true);
            this.R3.post(new e(this.k4.get(1)));
        }
    }

    private void g2() {
        this.z.setLightEffectOn(true);
        this.b4.setVisibility(8);
        this.c4.setVisibility(0);
        this.O3.setText(this.f4.j(this.m4));
        this.p1.setImageResource(R.mipmap.ic_white_back);
        this.p2.setImageDrawable(getResources().getDrawable(R.mipmap.ic_setting_white));
        this.K3.setTextColor(getResources().getColor(R.color.white));
        this.L3.setTextColor(getResources().getColor(R.color.white));
        this.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), R.mipmap.ic_location_gray, null), (Drawable) null, (Drawable) null, (Drawable) null);
        l2();
    }

    private void h2() {
        ThingContext k2 = TPIoTClientManager.k2(this.d4);
        if (k2 != null && k2.getIoTDevice() != null) {
            if (k2.getIoTDevice().isUserRoleTypeDevice()) {
                this.J3.setVisibility(0);
                return;
            }
            this.J3.setVisibility(8);
            i2();
        }
    }

    private void i2() {
        if (!com.tplink.iot.Utils.w0.a.d(this.d4) || !R1()) {
            this.I3.setVisibility(8);
        } else {
            this.e4.x();
        }
    }

    private void j2() {
        m2();
        this.b4.setVisibility(0);
        this.c4.setVisibility(8);
        this.p1.setImageResource(R.mipmap.ic_white_back);
        this.p2.setImageDrawable(getResources().getDrawable(R.mipmap.ic_setting_white));
        this.K3.setTextColor(getResources().getColor(R.color.white));
        this.L3.setTextColor(getResources().getColor(R.color.white));
        this.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), R.mipmap.ic_location_gray, null), (Drawable) null, (Drawable) null, (Drawable) null);
        this.M3.setVisibility(4);
    }

    private void k2(IoTBulbDevice ioTBulbDevice) {
        m2();
        this.b4.setVisibility(0);
        this.c4.setVisibility(8);
        this.p1.setImageResource(R.mipmap.ic_grey_back);
        this.p2.setImageDrawable(getResources().getDrawable(R.mipmap.ic_setting_black));
        this.K3.setTextColor(getResources().getColor(R.color.common_iot_dark_black));
        this.L3.setTextColor(getResources().getColor(R.color.common_iot_dark_black));
        this.L3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), R.mipmap.ic_location_black, null), (Drawable) null, (Drawable) null, (Drawable) null);
        if (ioTBulbDevice == null || ioTBulbDevice.getColorTemp() == 0) {
            this.M3.setVisibility(4);
            return;
        }
        this.M3.setVisibility(0);
        TextView textView = this.M3;
        textView.setText(ioTBulbDevice.getColorTemp() + "K");
    }

    private void l2() {
        try {
            this.Y3.setImageAssetsFolder("images/");
            com.airbnb.lottie.d a2 = d.a.a(this, "light_effect_data.json");
            this.Y3.g();
            this.Y3.setProgress(0.0f);
            this.Y3.setComposition(a2);
            this.Y3.o();
            this.Y3.setVisibility(0);
        } catch (Exception unused) {
            Log.e("lottie", "load local lottie anim error");
        }
    }

    private void m2() {
        this.Y3.n();
    }

    private void n2() {
        this.e4.u().observe(this, new l());
        this.e4.y().observe(this, new m());
        this.e4.F().observe(this, new n());
        this.e4.C().observe(this, new o());
        this.e4.r().observe(this, new p());
        this.e4.D().observe(this, new q());
        if (com.tplink.iot.Utils.w0.a.d(this.d4)) {
            this.e4.v().observe(this, new a());
            this.e4.w().observe(this, new b());
        }
        this.f4.l().observe(this, new Observer() { // from class: com.tplink.iot.view.colorbulb.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ColorBulbDetailActivity.this.W1((List) obj);
            }
        });
        this.f4.f10174d.observe(this, new Observer() { // from class: com.tplink.iot.view.colorbulb.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ColorBulbDetailActivity.this.Y1((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o2(BaseALIoTDevice baseALIoTDevice) {
        if (baseALIoTDevice != null) {
            this.h4 = baseALIoTDevice;
            this.K3.setText(com.tplink.iot.Utils.z0.l.d(this, baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceName()));
            String h2 = com.tplink.iot.Utils.z0.l.h(this.h4);
            int i2 = 8;
            if (TextUtils.isEmpty(h2)) {
                this.L3.setVisibility(8);
            } else {
                this.L3.setVisibility(0);
                this.L3.setText(h2);
            }
            this.S3.setChecked(this.h4.isCommonDevice());
            this.N3.setText(String.valueOf(N1()));
            View view = this.U3;
            if (!S1()) {
                i2 = 0;
            }
            view.setVisibility(i2);
            if (!this.h4.isSupportIoTCloud()) {
                this.S3.setEnabled(false);
                this.V3.setAlpha(0.5f);
            } else {
                this.S3.setEnabled(true);
                this.V3.setAlpha(1.0f);
            }
            if (!this.h4.isSupportIoTCloud() || this.h4.getCloudIoTDevice() == null || S1()) {
                this.K3.setEnabled(false);
                this.L3.setEnabled(false);
                this.U3.setEnabled(false);
                this.U3.setAlpha(0.5f);
                return;
            }
            this.K3.setEnabled(true);
            this.L3.setEnabled(true);
            this.U3.setEnabled(true);
            this.U3.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2(List<LightStateBean> list) {
        this.k4 = list;
        this.R3.setColorPresets(list);
        f2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2(IoTBulbDevice ioTBulbDevice) {
        if (ioTBulbDevice != null) {
            this.m4 = ioTBulbDevice.getDynamicLightEffectId();
            int a2 = ioTBulbDevice.getColorTemp() == 0 ? com.tplink.iot.Utils.z0.i.a(ioTBulbDevice.getHue(), ioTBulbDevice.getSaturation()) : -1;
            if (ioTBulbDevice.isDeviceOn() && ioTBulbDevice.isDynamicLightEffectEnable()) {
                g2();
                L1();
            } else if (ioTBulbDevice.isDeviceOn()) {
                this.z.setLightEffectOn(false);
                this.Q3.r(ioTBulbDevice.isDeviceOn(), ioTBulbDevice.getBrightness(), a2);
                k2(ioTBulbDevice);
                f2();
            } else {
                this.z.setLightEffectOn(false);
                this.Q3.r(ioTBulbDevice.isDeviceOn(), ioTBulbDevice.getBrightness(), a2);
                j2();
                L1();
            }
        }
    }

    @Override // com.tplink.iot.widget.colorbulb.light.LightBulbView.d
    public void J(int i2, boolean z) {
        this.e4.O(i2);
        if (z) {
            com.tplink.iot.Utils.x0.i.D(this.d4, i2);
        }
    }

    @Override // com.tplink.iot.view.colorbulb.EditAutoDialog.a
    public void J0(String str) {
        this.e4.N(new AutoLightBean(true, str));
    }

    @Override // com.tplink.iot.widget.colorbulb.light.LightBulbView.d
    public void L(int i2) {
        this.P3.a(true, i2, false);
    }

    @Override // com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog.b
    public void U(LightStateBean lightStateBean) {
        this.e4.Q(lightStateBean);
    }

    @Override // com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog.b
    public void g(int i2, LightStateBean lightStateBean) {
        EditPresetRule editPresetRule = new EditPresetRule();
        editPresetRule.setIndex(i2);
        editPresetRule.setState(lightStateBean);
        this.e4.o(editPresetRule);
        this.e4.Q(lightStateBean);
    }

    @Override // com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog.b
    public void h(LightStateBean lightStateBean) {
    }

    @Override // com.tplink.iot.base.BaseLocationActivity
    public void h1() {
        this.R3.d();
        this.e4.N(new AutoLightBean(true, M1()));
        c2();
    }

    @Override // com.tplink.iot.widget.colorbulb.DetailBottomRuleViewV2.a
    public void onBottomRuleClick(View view) {
        int id = view.getId();
        if (id == R.id.mode_schedule) {
            ScheduleListActivity.o1(this, this.d4, true);
        } else if (id != R.id.mode_timer) {
            switch (id) {
                case R.id.mode_away /* 2131363462 */:
                    X0(AwayModeActivity.class, this.d4);
                    return;
                case R.id.mode_breath /* 2131363463 */:
                    this.f4.z("L2", true);
                    return;
                case R.id.mode_direct /* 2131363464 */:
                    this.f4.z("L1", true);
                    return;
                default:
                    return;
            }
        } else {
            TimerActivity.S1(this, this.d4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card_local_only /* 2131362192 */:
                CloudConnectGetStateActivity.j1(this, this.d4);
                return;
            case R.id.item_device_share /* 2131362908 */:
                ShareDeviceUserListActivity.v1(this, this.d4);
                com.tplink.iot.Utils.x0.i.C();
                return;
            case R.id.item_faq_feedback /* 2131362913 */:
                O1();
                com.tplink.iot.Utils.x0.i.w();
                return;
            case R.id.iv_back /* 2131363002 */:
                onBackPressed();
                return;
            case R.id.iv_pull_up_down /* 2131363103 */:
                if (this.T3.getCurrentStatus() == ScrollLayout.Status.CLOSED) {
                    this.T3.r();
                    return;
                } else if (this.T3.getCurrentStatus() == ScrollLayout.Status.OPENED) {
                    this.T3.p();
                    return;
                } else {
                    return;
                }
            case R.id.iv_setting /* 2131363121 */:
                X0(ColorBulbSettingsActivity.class, this.d4);
                return;
            case R.id.tv_edit_light_effect_scene /* 2131364441 */:
                if ("L2".equals(this.m4)) {
                    LightEffectConfigActivity.o1(this, this.d4, "L2");
                    return;
                } else {
                    LightEffectConfigActivity.o1(this, this.d4, "L1");
                    return;
                }
            case R.id.tv_exit_light_effect /* 2131364455 */:
                this.f4.z(null, false);
                return;
            default:
                return;
        }
    }

    @Override // com.tplink.iot.base.BaseLocationActivity, com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_color_bulb_detail);
        com.tplink.iot.view.quicksetup.base.d.J(this, findViewById(R.id.ll_toolbar));
        String stringExtra = getIntent().getStringExtra("device_id_md5");
        this.d4 = stringExtra;
        this.e4 = (BulbDetailViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, stringExtra)).get(BulbDetailViewModel.class);
        this.f4 = (LightEffectViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, this.d4)).get(LightEffectViewModel.class);
        Q1();
        n2();
        h2();
        com.tplink.iot.Utils.x0.i.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ThingNextEventView thingNextEventView = this.W3;
        if (thingNextEventView != null) {
            thingNextEventView.e();
        }
        LightBulbView lightBulbView = this.Q3;
        if (lightBulbView != null) {
            lightBulbView.p();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.e4.U();
        this.e4.T();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.e4.S();
        this.e4.R();
        this.e4.B();
        this.e4.G();
        this.e4.s();
        if (this.e4.H()) {
            this.f4.k();
        }
    }

    @Override // com.tplink.iot.widget.colorbulb.light.LightBulbView.d
    public void w0(boolean z) {
        this.e4.P(z);
        com.tplink.iot.Utils.x0.i.e(this.d4, z);
    }
}
