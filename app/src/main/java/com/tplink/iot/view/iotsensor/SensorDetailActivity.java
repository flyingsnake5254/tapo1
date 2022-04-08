package com.tplink.iot.view.iotsensor;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.adapter.iotsensor.SensorTriggerLogAdapter;
import com.tplink.iot.databinding.ActivitySensorDetailBinding;
import com.tplink.iot.devices.featuredactions.view.FeaturedActionHostActivity;
import com.tplink.iot.view.deviceshare.ShareDeviceUserListActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.view.feedback.HelpAndFeedbackActivity;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.tplink.iot.widget.refreshlayout.SmartRefreshFooter;
import com.tplink.iot.widget.refreshlayout.SmartRefreshHeader;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumNotificationMsgType;
import com.yinglan.scrolllayout.ScrollLayout;
import java.util.List;
import kotlin.jvm.internal.Lambda;

/* compiled from: SensorDetailActivity.kt */
/* loaded from: classes2.dex */
public final class SensorDetailActivity extends SensorBaseActivity<SensorDetailViewModel> implements View.OnClickListener {
    public static final a p0 = new a(null);
    private final kotlin.f H3;
    private BaseALIoTDevice<?> I3;
    private SensorTriggerLogAdapter J3;
    private boolean K3;
    private String L3;
    private boolean M3;
    private ActivitySensorDetailBinding p1;
    private final kotlin.f p2;
    private final kotlin.f p3;

    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceIdMD5) {
            kotlin.jvm.internal.j.e(context, "context");
            kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
            Intent intent = new Intent(context, SensorDetailActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            context.startActivity(intent);
        }

        public final void b(Context context, String deviceIdMD5, String notificationMsgType) {
            kotlin.jvm.internal.j.e(context, "context");
            kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
            kotlin.jvm.internal.j.e(notificationMsgType, "notificationMsgType");
            Intent intent = new Intent(context, SensorDetailActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            intent.putExtra("NotificationMsgTypeExtra", notificationMsgType);
            context.startActivity(intent);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class b implements TPSwitchCompat.a {
        b() {
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a
        public final void c(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                SensorDetailActivity.this.f1().o(z);
                com.tplink.iot.Utils.x0.i.x(SensorDetailActivity.this.e1(), z);
                if (!z) {
                    SensorDetailActivity.this.I1();
                }
            }
        }
    }

    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class c implements d0.g {
        c() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public final void a() {
            SensorDetailActivity.this.L1();
        }
    }

    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements kotlin.jvm.b.a<ImageView> {
        d() {
            super(0);
        }

        /* renamed from: a */
        public final ImageView invoke() {
            return SensorDetailActivity.l1(SensorDetailActivity.this).f6674f.p1;
        }
    }

    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements kotlin.jvm.b.a<TPSmartRefreshLayout> {
        e() {
            super(0);
        }

        /* renamed from: a */
        public final TPSmartRefreshLayout invoke() {
            TPSmartRefreshLayout tPSmartRefreshLayout = SensorDetailActivity.l1(SensorDetailActivity.this).q.p3;
            kotlin.jvm.internal.j.d(tPSmartRefreshLayout, "mBinding.sensorDetailContent.refreshLayout");
            return tPSmartRefreshLayout;
        }
    }

    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class f extends Lambda implements kotlin.jvm.b.a<ScrollLayout> {
        f() {
            super(0);
        }

        /* renamed from: a */
        public final ScrollLayout invoke() {
            return SensorDetailActivity.l1(SensorDetailActivity.this).f6673d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ScrollLayout f8695c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SensorDetailActivity f8696d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f8697f;

        g(ScrollLayout scrollLayout, SensorDetailActivity sensorDetailActivity, boolean z) {
            this.f8695c = scrollLayout;
            this.f8696d = sensorDetailActivity;
            this.f8697f = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i;
            View root = SensorDetailActivity.l1(this.f8696d).getRoot();
            kotlin.jvm.internal.j.d(root, "mBinding.root");
            int measuredHeight = root.getMeasuredHeight();
            ScrollLayout scrollDownLayout = this.f8696d.z1();
            kotlin.jvm.internal.j.d(scrollDownLayout, "scrollDownLayout");
            int screenHeight = measuredHeight - scrollDownLayout.getScreenHeight();
            ImageView ivPullUpDown = this.f8696d.x1();
            kotlin.jvm.internal.j.d(ivPullUpDown, "ivPullUpDown");
            int measuredHeight2 = ivPullUpDown.getMeasuredHeight();
            if (this.f8697f) {
                RelativeLayout relativeLayout = SensorDetailActivity.l1(this.f8696d).f6674f.p0;
                kotlin.jvm.internal.j.d(relativeLayout, "mBinding.sensorDetailBottom.itemSmartScene");
                i = relativeLayout.getMeasuredHeight();
            } else {
                RelativeLayout relativeLayout2 = SensorDetailActivity.l1(this.f8696d).f6674f.p2;
                kotlin.jvm.internal.j.d(relativeLayout2, "mBinding.sensorDetailBottom.rlCommonDevice");
                i = relativeLayout2.getMeasuredHeight();
            }
            if (measuredHeight2 > 0 && i > 0) {
                this.f8695c.setMaxOffset((measuredHeight2 + i) - screenHeight);
                this.f8695c.r();
            }
        }
    }

    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class h implements ScrollLayout.g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8698b;

        h(boolean z) {
            this.f8698b = z;
        }

        @Override // com.yinglan.scrolllayout.ScrollLayout.g
        public void a(ScrollLayout.Status currentStatus) {
            kotlin.jvm.internal.j.e(currentStatus, "currentStatus");
            if (currentStatus == ScrollLayout.Status.OPENED) {
                SensorDetailActivity.this.x1().setImageResource(R.mipmap.ic_pull_up);
            } else if (currentStatus == ScrollLayout.Status.CLOSED) {
                SensorDetailActivity.this.x1().setImageResource(R.mipmap.ic_pull_down);
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
    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class i implements com.scwang.smart.refresh.layout.c.g {
        i() {
        }

        @Override // com.scwang.smart.refresh.layout.c.g
        public final void m(com.scwang.smart.refresh.layout.a.f it) {
            kotlin.jvm.internal.j.e(it, "it");
            SensorDetailActivity.this.f1().U();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class j implements com.scwang.smart.refresh.layout.c.e {
        j() {
        }

        @Override // com.scwang.smart.refresh.layout.c.e
        public final void q(com.scwang.smart.refresh.layout.a.f it) {
            kotlin.jvm.internal.j.e(it, "it");
            SensorDetailActivity.this.f1().Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class k implements TPMaterialDialogV3.d {
        k() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV3.d
        public final void onClick(View view) {
            SensorDetailActivity.this.f1().R();
        }
    }

    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class l<T> implements Observer<BaseALIoTDevice<?>> {
        l() {
        }

        /* renamed from: a */
        public final void onChanged(BaseALIoTDevice<?> baseALIoTDevice) {
            SensorDetailActivity.this.P1(baseALIoTDevice);
        }
    }

    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class m<T> implements Observer<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>> {
        m() {
        }

        /* renamed from: a */
        public final void onChanged(com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> iVar) {
            SensorDetailActivity.this.F1(iVar);
        }
    }

    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class n<T> implements Observer<List<? extends com.tplink.iot.adapter.iotsensor.a>> {
        n() {
        }

        /* renamed from: a */
        public final void onChanged(List<com.tplink.iot.adapter.iotsensor.a> list) {
            if (list != null) {
                SensorDetailActivity.m1(SensorDetailActivity.this).y(list);
            }
            SensorDetailActivity.this.O1();
        }
    }

    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class o<T> implements Observer<Boolean> {
        o() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            SensorDetailActivity.this.y1().E(bool != null ? bool.booleanValue() : false);
        }
    }

    /* compiled from: SensorDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class p<T> implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>> {
        p() {
        }

        /* renamed from: a */
        public final void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> aVar) {
            if (aVar != null && aVar.a() != null) {
                SensorDetailActivity.this.y1().q();
                SensorDetailActivity.this.y1().l();
            }
        }
    }

    public SensorDetailActivity() {
        super(SensorDetailViewModel.class);
        kotlin.f b2;
        kotlin.f b3;
        kotlin.f b4;
        b2 = kotlin.i.b(new d());
        this.p2 = b2;
        b3 = kotlin.i.b(new f());
        this.p3 = b3;
        b4 = kotlin.i.b(new e());
        this.H3 = b4;
    }

    private final void A1() {
        BaseALIoTDevice<?> baseALIoTDevice = this.I3;
        if (baseALIoTDevice != null) {
            HelpAndFeedbackActivity.k1(this, "https://www.tapo.com/app/#/faqList2?categoryType=" + v1() + com.tplink.iot.model.about.d.a(), u1(), baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceModel(), w1());
        }
    }

    private final void B1() {
        String v = f1().v();
        FeaturedActionHostActivity.a aVar = FeaturedActionHostActivity.p0;
        String e1 = e1();
        BaseALIoTDevice<?> baseALIoTDevice = this.I3;
        aVar.a(this, e1, baseALIoTDevice != null ? baseALIoTDevice.getDeviceType() : null, v);
    }

    private final boolean C1() {
        String v = f1().v();
        return kotlin.jvm.internal.j.a(v, "S200B") || kotlin.jvm.internal.j.a(v, "T100") || kotlin.jvm.internal.j.a(v, "T110");
    }

    public static final void D1(Context context, String str) {
        p0.a(context, str);
    }

    public static final void E1(Context context, String str, String str2) {
        p0.b(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1(com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> iVar) {
        CloudConnectStateResult a2;
        if (iVar != null && (a2 = iVar.a()) != null) {
            int i2 = 8;
            if (a2.getStatus() == 0) {
                ActivitySensorDetailBinding activitySensorDetailBinding = this.p1;
                if (activitySensorDetailBinding == null) {
                    kotlin.jvm.internal.j.t("mBinding");
                }
                CardView cardView = activitySensorDetailBinding.q.f6678c;
                kotlin.jvm.internal.j.d(cardView, "mBinding.sensorDetailContent.cardLocalOnly");
                cardView.setVisibility(8);
                return;
            }
            ActivitySensorDetailBinding activitySensorDetailBinding2 = this.p1;
            if (activitySensorDetailBinding2 == null) {
                kotlin.jvm.internal.j.t("mBinding");
            }
            CardView cardView2 = activitySensorDetailBinding2.q.f6678c;
            kotlin.jvm.internal.j.d(cardView2, "mBinding.sensorDetailContent.cardLocalOnly");
            if (f1().J()) {
                i2 = 0;
            }
            cardView2.setVisibility(i2);
        }
    }

    private final void G1() {
        boolean C1 = C1();
        ScrollLayout z1 = z1();
        z1.setMinOffset(com.tplink.iot.Utils.k.a(this, 50.0f) + com.tplink.iot.view.quicksetup.base.d.A(this));
        x1().post(new g(z1, this, C1));
        z1.setOnScrollChangedListener(new h(C1));
    }

    private final void H1() {
        TPSmartRefreshLayout y1 = y1();
        y1.Q(new SmartRefreshHeader(this));
        y1.O(new SmartRefreshFooter(this));
        y1.G(true);
        y1.E(true);
        y1.F(true);
        y1.N(new i());
        y1.L(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I1() {
        String str;
        TCAccountBean c2;
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        if (f2 == null || (c2 = f2.c()) == null || (str = c2.getCloudUserName()) == null) {
            str = "";
        }
        u.p(this, str);
    }

    private final void J1() {
        b.d.w.c.a.a("Sensor showLocalOnlyOrUserDeviceTips: " + f1().O());
        if (f1().O()) {
            ActivitySensorDetailBinding activitySensorDetailBinding = this.p1;
            if (activitySensorDetailBinding == null) {
                kotlin.jvm.internal.j.t("mBinding");
            }
            CardView cardView = activitySensorDetailBinding.q.f6679d;
            kotlin.jvm.internal.j.d(cardView, "mBinding.sensorDetailContent.cardUserDevice");
            cardView.setVisibility(0);
            return;
        }
        ActivitySensorDetailBinding activitySensorDetailBinding2 = this.p1;
        if (activitySensorDetailBinding2 == null) {
            kotlin.jvm.internal.j.t("mBinding");
        }
        CardView cardView2 = activitySensorDetailBinding2.q.f6679d;
        kotlin.jvm.internal.j.d(cardView2, "mBinding.sensorDetailContent.cardUserDevice");
        cardView2.setVisibility(8);
        K1();
    }

    private final void K1() {
        b.d.w.c.a.a("Sensor showLocalView: " + f1().J());
        if (f1().J()) {
            ActivitySensorDetailBinding activitySensorDetailBinding = this.p1;
            if (activitySensorDetailBinding == null) {
                kotlin.jvm.internal.j.t("mBinding");
            }
            CardView cardView = activitySensorDetailBinding.q.f6678c;
            kotlin.jvm.internal.j.d(cardView, "mBinding.sensorDetailContent.cardLocalOnly");
            cardView.setVisibility(0);
            return;
        }
        ActivitySensorDetailBinding activitySensorDetailBinding2 = this.p1;
        if (activitySensorDetailBinding2 == null) {
            kotlin.jvm.internal.j.t("mBinding");
        }
        CardView cardView2 = activitySensorDetailBinding2.q.f6678c;
        kotlin.jvm.internal.j.d(cardView2, "mBinding.sensorDetailContent.cardLocalOnly");
        cardView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1() {
        r.n(getSupportFragmentManager(), this.I3);
    }

    private final void M1() {
        BaseALIoTDevice<?> baseALIoTDevice;
        String str = this.L3;
        if (str != null && (baseALIoTDevice = this.I3) != null && EnumNotificationMsgType.fromString(str) == EnumNotificationMsgType.TAPO_SENSOR_FREQUENTLY_TRIGGERED && !this.M3) {
            this.M3 = true;
            String string = getString(R.string.sensor_trigger_frequently_desc_v2, new Object[]{com.tplink.iot.Utils.z0.l.c(this, baseALIoTDevice)});
            kotlin.jvm.internal.j.d(string, "getString(R.string.senso…DeviceName(this, device))");
            new TPMaterialDialogV3.Builder(this).f(string).j(R.string.common_ok, R.color.common_iot_main_blue, new k()).show();
        }
    }

    private final void N1() {
        ScrollLayout z1 = z1();
        if (z1.getCurrentStatus() == ScrollLayout.Status.OPENED) {
            z1.m();
        } else if (z1.getCurrentStatus() == ScrollLayout.Status.CLOSED) {
            z1.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1() {
        BaseALIoTDevice<?> baseALIoTDevice = this.I3;
        if (kotlin.jvm.internal.j.a(baseALIoTDevice != null ? baseALIoTDevice.getDeviceModel() : null, "T110")) {
            ActivitySensorDetailBinding activitySensorDetailBinding = this.p1;
            if (activitySensorDetailBinding == null) {
                kotlin.jvm.internal.j.t("mBinding");
            }
            activitySensorDetailBinding.q.p0.setImageResource(f1().V());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1(BaseALIoTDevice<?> baseALIoTDevice) {
        if (baseALIoTDevice != null) {
            SensorTriggerLogAdapter sensorTriggerLogAdapter = this.J3;
            if (sensorTriggerLogAdapter == null) {
                kotlin.jvm.internal.j.t("mTriggerLogAdapter");
            }
            String deviceRegion = baseALIoTDevice.getDeviceRegion();
            kotlin.jvm.internal.j.d(deviceRegion, "deviceRegion");
            sensorTriggerLogAdapter.I(deviceRegion);
            kotlin.p pVar = kotlin.p.a;
        } else {
            baseALIoTDevice = null;
        }
        this.I3 = baseALIoTDevice;
        M1();
        O1();
    }

    public static final /* synthetic */ ActivitySensorDetailBinding l1(SensorDetailActivity sensorDetailActivity) {
        ActivitySensorDetailBinding activitySensorDetailBinding = sensorDetailActivity.p1;
        if (activitySensorDetailBinding == null) {
            kotlin.jvm.internal.j.t("mBinding");
        }
        return activitySensorDetailBinding;
    }

    public static final /* synthetic */ SensorTriggerLogAdapter m1(SensorDetailActivity sensorDetailActivity) {
        SensorTriggerLogAdapter sensorTriggerLogAdapter = sensorDetailActivity.J3;
        if (sensorTriggerLogAdapter == null) {
            kotlin.jvm.internal.j.t("mTriggerLogAdapter");
        }
        return sensorTriggerLogAdapter;
    }

    private final String u1() {
        if (r.l(this.I3)) {
            String string = getString(R.string.iot_motion_sensors);
            kotlin.jvm.internal.j.d(string, "getString(R.string.iot_motion_sensors)");
            return string;
        } else if (r.k(this.I3)) {
            String string2 = getString(R.string.iot_contact_sensors);
            kotlin.jvm.internal.j.d(string2, "getString(R.string.iot_contact_sensors)");
            return string2;
        } else if (r.j(this.I3)) {
            String string3 = getString(R.string.iot_buttons);
            kotlin.jvm.internal.j.d(string3, "getString(R.string.iot_buttons)");
            return string3;
        } else {
            String string4 = getString(R.string.iot_sensors);
            kotlin.jvm.internal.j.d(string4, "getString(R.string.iot_sensors)");
            return string4;
        }
    }

    private final String v1() {
        if (r.l(this.I3)) {
            String string = getString(R.string.motion_sensor_param);
            kotlin.jvm.internal.j.d(string, "getString(R.string.motion_sensor_param)");
            return string;
        } else if (r.k(this.I3)) {
            String string2 = getString(R.string.contact_sensor_param);
            kotlin.jvm.internal.j.d(string2, "getString(R.string.contact_sensor_param)");
            return string2;
        } else if (r.j(this.I3)) {
            String string3 = getString(R.string.button_param);
            kotlin.jvm.internal.j.d(string3, "getString(R.string.button_param)");
            return string3;
        } else {
            String string4 = getString(R.string.motion_sensor_param);
            kotlin.jvm.internal.j.d(string4, "getString(R.string.motion_sensor_param)");
            return string4;
        }
    }

    private final EnumFeedbackCategory w1() {
        return r.l(this.I3) ? EnumFeedbackCategory.MOTION_SENSOR : r.k(this.I3) ? EnumFeedbackCategory.CONTACT_SENSOR : r.j(this.I3) ? EnumFeedbackCategory.BUTTON : EnumFeedbackCategory.MOTION_SENSOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView x1() {
        return (ImageView) this.p2.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TPSmartRefreshLayout y1() {
        return (TPSmartRefreshLayout) this.H3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScrollLayout z1() {
        return (ScrollLayout) this.p3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.view.iotsensor.SensorBaseActivity
    public void g1() {
        super.g1();
        Intent intent = getIntent();
        this.L3 = intent != null ? intent.getStringExtra("NotificationMsgTypeExtra") : null;
        M1();
    }

    @Override // com.tplink.iot.view.iotsensor.SensorBaseActivity
    public void h1() {
        List d2;
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_sensor_detail);
        kotlin.jvm.internal.j.d(contentView, "DataBindingUtil.setConte…t.activity_sensor_detail)");
        ActivitySensorDetailBinding activitySensorDetailBinding = (ActivitySensorDetailBinding) contentView;
        this.p1 = activitySensorDetailBinding;
        if (activitySensorDetailBinding == null) {
            kotlin.jvm.internal.j.t("mBinding");
        }
        activitySensorDetailBinding.h(f1());
        activitySensorDetailBinding.i(this);
        activitySensorDetailBinding.setLifecycleOwner(this);
        com.tplink.iot.view.quicksetup.base.d.J(this, findViewById(R.id.ll_toolbar));
        G1();
        J1();
        H1();
        boolean C1 = C1();
        ActivitySensorDetailBinding activitySensorDetailBinding2 = this.p1;
        if (activitySensorDetailBinding2 == null) {
            kotlin.jvm.internal.j.t("mBinding");
        }
        RelativeLayout relativeLayout = activitySensorDetailBinding2.f6674f.p0;
        kotlin.jvm.internal.j.d(relativeLayout, "mBinding.sensorDetailBottom.itemSmartScene");
        int i2 = 0;
        relativeLayout.setVisibility(C1 ? 0 : 8);
        ActivitySensorDetailBinding activitySensorDetailBinding3 = this.p1;
        if (activitySensorDetailBinding3 == null) {
            kotlin.jvm.internal.j.t("mBinding");
        }
        View view = activitySensorDetailBinding3.f6674f.q;
        kotlin.jvm.internal.j.d(view, "mBinding.sensorDetailBottom.dividerLine");
        if (!C1) {
            i2 = 8;
        }
        view.setVisibility(i2);
        ActivitySensorDetailBinding activitySensorDetailBinding4 = this.p1;
        if (activitySensorDetailBinding4 == null) {
            kotlin.jvm.internal.j.t("mBinding");
        }
        activitySensorDetailBinding4.f6674f.x.setOnSwitchCheckedChangeListener(new b());
        ActivitySensorDetailBinding activitySensorDetailBinding5 = this.p1;
        if (activitySensorDetailBinding5 == null) {
            kotlin.jvm.internal.j.t("mBinding");
        }
        d0.h(activitySensorDetailBinding5.q.J3, getString(R.string.switch_how_to_replace_battery), ContextCompat.getColor(this, R.color.common_iot_purple), new c());
        d2 = kotlin.collections.n.d();
        SensorTriggerLogAdapter sensorTriggerLogAdapter = new SensorTriggerLogAdapter(this, d2);
        ActivitySensorDetailBinding activitySensorDetailBinding6 = this.p1;
        if (activitySensorDetailBinding6 == null) {
            kotlin.jvm.internal.j.t("mBinding");
        }
        RecyclerView recyclerView = activitySensorDetailBinding6.q.H3;
        kotlin.jvm.internal.j.d(recyclerView, "mBinding.sensorDetailContent.rvTriggerLogs");
        recyclerView.setAdapter(sensorTriggerLogAdapter);
        kotlin.p pVar = kotlin.p.a;
        this.J3 = sensorTriggerLogAdapter;
    }

    @Override // com.tplink.iot.view.iotsensor.SensorBaseActivity
    public void i1() {
        com.tplink.iot.Utils.x0.i.s();
        f1().P();
    }

    @Override // com.tplink.iot.view.iotsensor.SensorBaseActivity
    public void j1() {
        f1().p().observe(this, new l());
        f1().s().observe(this, new m());
        f1().F().observe(this, new n());
        f1().r().observe(this, new o());
        f1().z().observe(this, new p());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        kotlin.jvm.internal.j.e(v, "v");
        switch (v.getId()) {
            case R.id.fl_setting /* 2131362675 */:
                X0(SensorSettingsActivity.class, e1());
                return;
            case R.id.item_device_share /* 2131362908 */:
                ShareDeviceUserListActivity.v1(this, e1());
                com.tplink.iot.Utils.x0.i.C();
                return;
            case R.id.item_faq_feedback /* 2131362913 */:
                A1();
                com.tplink.iot.Utils.x0.i.w();
                return;
            case R.id.item_smart_scene /* 2131362966 */:
                B1();
                return;
            case R.id.iv_back /* 2131363002 */:
                finish();
                return;
            case R.id.iv_pull_up_down /* 2131363103 */:
                N1();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f1().X();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        f1().W();
        if (!this.K3) {
            this.K3 = true;
            y1().j();
        }
    }
}
