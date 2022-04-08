package com.tplink.iot.devices.switches.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.google.firebase.messaging.ServiceStarter;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.q;
import com.tplink.iot.Utils.u0;
import com.tplink.iot.Utils.x0.i;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.databinding.LayoutSwitchDetailBottomExtBinding;
import com.tplink.iot.databinding.LayoutSwitchDetailContentExtBinding;
import com.tplink.iot.devicecommon.feature.NextEventFeature;
import com.tplink.iot.devicecommon.view.IoTDetailBaseActivity;
import com.tplink.iot.devices.switches.viewmodel.SwitchDetailViewModel;
import com.tplink.iot.view.feature.AwayModeActivity;
import com.tplink.iot.view.feature.ScheduleListActivity;
import com.tplink.iot.view.feature.TimerActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.IoTSubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: SwitchDetailActivity.kt */
/* loaded from: classes2.dex */
public final class SwitchDetailActivity extends IoTDetailBaseActivity<LayoutSwitchDetailContentExtBinding, LayoutSwitchDetailBottomExtBinding, SwitchDetailViewModel> {
    public static final a K3 = new a(null);
    private long L3;
    private final com.tplink.iot.devicecommon.feature.a M3 = new com.tplink.iot.devicecommon.feature.a();
    private boolean N3 = true;

    /* compiled from: SwitchDetailActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String deviceIdMD5) {
            j.e(context, "context");
            j.e(deviceIdMD5, "deviceIdMD5");
            Intent intent = new Intent(context, SwitchDetailActivity.class);
            intent.putExtra("device_id_md5", deviceIdMD5);
            context.startActivity(intent);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: SwitchDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class b implements d0.g {
        b() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public final void a() {
            SwitchDetailActivity.this.S1();
        }
    }

    /* compiled from: SwitchDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements Observer<IoTSubDevice> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(IoTSubDevice ioTSubDevice) {
            if (ioTSubDevice != null) {
                SwitchDetailActivity.M1(SwitchDetailActivity.this).X().set(ioTSubDevice.isDeviceOn());
                SwitchDetailActivity.this.U1();
            }
        }
    }

    /* compiled from: SwitchDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class d<T> implements Observer<ThingUsage> {
        d() {
        }

        /* renamed from: a */
        public final void onChanged(ThingUsage thingUsage) {
            if (thingUsage != null) {
                SwitchDetailActivity.L1(SwitchDetailActivity.this).z.o(thingUsage);
            }
        }
    }

    /* compiled from: SwitchDetailActivity.kt */
    /* loaded from: classes2.dex */
    static final class e<T> implements Observer<Integer> {
        e() {
        }

        /* renamed from: a */
        public final void onChanged(Integer num) {
            if (num != null) {
                SwitchDetailActivity.this.Q1(num.intValue());
            }
        }
    }

    public SwitchDetailActivity() {
        super(SwitchDetailViewModel.class);
    }

    public static final /* synthetic */ LayoutSwitchDetailBottomExtBinding L1(SwitchDetailActivity switchDetailActivity) {
        return switchDetailActivity.s1();
    }

    public static final /* synthetic */ SwitchDetailViewModel M1(SwitchDetailActivity switchDetailActivity) {
        return switchDetailActivity.v1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1(int i) {
        if (this.N3) {
            this.N3 = false;
        } else if (i >= 3) {
            this.M3.b(this, p1());
        }
    }

    public static final void R1(Context context, String str) {
        K3.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        j.d(supportFragmentManager, "supportFragmentManager");
        com.tplink.iot.g.c.a.b.e(supportFragmentManager, p1());
    }

    private final void T1() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.L3 >= ((long) ServiceStarter.ERROR_UNKNOWN)) {
            this.L3 = currentTimeMillis;
            boolean z = !v1().X().get();
            u0.a(this, 200L);
            if (z) {
                q.a(this, q1().p3, R.mipmap.plug_detail_bg_off, R.mipmap.plug_detail_bg_on, 800);
                t1().f7298c.b();
            } else {
                q1().p3.setBackgroundResource(R.mipmap.plug_detail_bg_off);
                t1().f7298c.c();
            }
            v1().Y(z);
            i.y(u1(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1() {
        if (v1().X().get()) {
            q1().p3.setBackgroundResource(R.mipmap.plug_detail_bg_on);
            t1().f7299d.setImageResource(R.mipmap.iot_switch_material_on);
            return;
        }
        t1().f7298c.c();
        q1().p3.setBackgroundResource(R.mipmap.plug_detail_bg_off);
        t1().f7299d.setImageResource(R.mipmap.iot_switch_material_off);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public void A1() {
        super.A1();
        t1().f7298c.setIsAutoStop(true);
        ImageView imageView = q1().p1;
        j.d(imageView, "mBinding.imgMoreLocal");
        imageView.setVisibility(8);
        NextEventFeature.f7386c.a(this, s1().y).f(v1().U());
        new com.tplink.iot.widget.i.a(0.0f, 0L, 3, null).c(t1().f7299d);
        d0.h(t1().y, getString(R.string.switch_how_to_replace_battery), ContextCompat.getColor(this, R.color.common_iot_purple), new b());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public void B1() {
        v1().Z(false);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public void J1() {
        super.J1();
        v1().O().observe(this, new c());
        v1().R().observe(this, new d());
        v1().V().observe(this, new e());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public int h1() {
        return R.layout.layout_switch_detail_bottom_ext;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public int i1() {
        LinearLayout linearLayout = s1().q;
        j.d(linearLayout, "mBottomExtBinding.llRules");
        int measuredHeight = linearLayout.getMeasuredHeight();
        LinearLayout linearLayout2 = s1().x;
        j.d(linearLayout2, "mBottomExtBinding.llRules2");
        return measuredHeight + linearLayout2.getMeasuredHeight();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public int j1() {
        return R.layout.layout_switch_detail_content_ext;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public Class<SwitchSettingsActivity> k1() {
        return SwitchSettingsActivity.class;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public String l1() {
        String string = getString(R.string.switch_param);
        j.d(string, "getString(R.string.switch_param)");
        return string;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public String m1() {
        String string = getString(R.string.iot_switches);
        j.d(string, "getString(R.string.iot_switches)");
        return string;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity
    public EnumFeedbackCategory n1(BaseALIoTDevice<?> device) {
        j.e(device, "device");
        return EnumFeedbackCategory.SWITCH;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if ((valueOf != null && valueOf.intValue() == R.id.iv_schedule) || (valueOf != null && valueOf.intValue() == R.id.tv_schedule)) {
            ScheduleListActivity.o1(this, u1(), false);
        } else if ((valueOf != null && valueOf.intValue() == R.id.iv_away) || (valueOf != null && valueOf.intValue() == R.id.tv_away)) {
            X0(AwayModeActivity.class, u1());
        } else if ((valueOf != null && valueOf.intValue() == R.id.iv_timer) || (valueOf != null && valueOf.intValue() == R.id.tv_timer)) {
            X0(TimerActivity.class, u1());
        } else if ((valueOf != null && valueOf.intValue() == R.id.iv_switch) || (valueOf != null && valueOf.intValue() == R.id.ll_tap_on)) {
            T1();
        } else if (valueOf == null || valueOf.intValue() != R.id.card_local_only) {
            super.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        v1().Z(true);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        t1().f7298c.c();
        super.onPause();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTDetailBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        v1().Q();
    }
}
