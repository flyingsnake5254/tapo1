package com.tplink.iot.view.quicksetup.bulb;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.v;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.bulb.quicksetup.BulbInheritAfterSetQsInfoActivity;
import com.tplink.iot.view.quicksetup.bulb.quicksetup.BulbNickNameInputActivity;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.view.quicksetup.discovery.DiscoveryDevicePairingFailedActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupInfoResult;
import com.tplink.libtpnetwork.Utils.e0;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class SoftAPBulbConnectAPActivity extends BaseActivity implements View.OnClickListener {
    private QuickSetupInfoBundle H3;
    private WirelessInfoParams I3;
    private BulbQuickSetupViewModel J3;
    private boolean K3;
    private long L3;
    private TPRippleBackground p0;
    private TextView p1;
    private ValueAnimator p2;
    private com.tplink.iot.widget.plug.b p3;
    private ImageView y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            SoftAPBulbConnectAPActivity.this.y.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            SoftAPBulbConnectAPActivity.this.v1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<i<QuickSetupInfoResult>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable i<QuickSetupInfoResult> iVar) {
            if (iVar != null) {
                v.b("prepare to find device");
                if (SoftAPBulbConnectAPActivity.this.H3.inNeedDisplayInherit() && SoftAPBulbConnectAPActivity.this.H3.isSelectFollowInherit()) {
                    SoftAPBulbConnectAPActivity.this.H3.setInheritAndSuccess(true);
                }
                if (SoftAPBulbConnectAPActivity.this.H3.isFromQuickDiscovery()) {
                    SoftAPBulbConnectAPActivity.this.n1();
                } else {
                    SoftAPBulbConnectAPActivity.this.m1();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<Integer> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            if (num == null || num.intValue() == 0) {
                SoftAPBulbConnectAPActivity.this.B1("find device fail");
            } else {
                SoftAPBulbConnectAPActivity.this.t1(num);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements g<Boolean> {
        d() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            e0.a(AppContext.f6185c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements g<Boolean> {
        e() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            SoftAPBulbConnectAPActivity.this.q1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements g<Boolean> {
        f() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            SoftAPBulbConnectAPActivity.this.q1();
        }
    }

    private void A1() {
        if ("H100".equals(this.H3.getDeviceModel())) {
            p1();
            ImageView imageView = this.z;
            if (imageView != null) {
                imageView.setVisibility(0);
                this.z.setAlpha(1.0f);
                this.z.setImageResource(R.mipmap.h100_animate_led_blue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1(String str) {
        QuickSetupInfoBundle quickSetupInfoBundle = this.H3;
        String deviceModel = quickSetupInfoBundle != null ? quickSetupInfoBundle.getDeviceModel() : null;
        QuickSetupInfoBundle quickSetupInfoBundle2 = this.H3;
        if (quickSetupInfoBundle2 == null || !quickSetupInfoBundle2.isFromQuickDiscovery()) {
            BulbPairingFailedActivity.n1(this, this.I3, deviceModel, 101);
            v.a(SoftAPBulbConnectAPActivity.class, BulbPairingFailedActivity.class, str);
        } else {
            DiscoveryDevicePairingFailedActivity.h1(this, deviceModel, 101);
            v.a(SoftAPBulbConnectAPActivity.class, DiscoveryDevicePairingFailedActivity.class, str);
        }
        r.v(this.H3.getDeviceType(), this.H3.getDeviceModel(), this.H3.getDeviceIdMD5(), (int) ((System.currentTimeMillis() - this.L3) / 1000));
    }

    private void C1() {
        com.tplink.iot.view.quicksetup.bulb.utils.a.h(this, this.H3.getDeviceType(), this.H3.getDeviceModel(), "ConnectingWiFiPage");
    }

    private void D1() {
        int[] o = com.tplink.iot.view.quicksetup.bulb.utils.b.o(this.H3.getDeviceModel());
        if (o == null || o.length == 0) {
            this.z.setVisibility(8);
            return;
        }
        if (o.length == 1) {
            this.z.setVisibility(0);
            this.z.setImageResource(o[0]);
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(500L);
            this.p2 = duration;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.iot.view.quicksetup.bulb.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SoftAPBulbConnectAPActivity.this.x1(valueAnimator);
                }
            });
            this.p2.setRepeatCount(-1);
            this.p2.setRepeatMode(2);
            this.p2.start();
            return;
        }
        this.z.setVisibility(0);
        Drawable[] drawableArr = new Drawable[o.length];
        for (int i = 0; i < o.length; i++) {
            drawableArr[i] = getResources().getDrawable(o[i]);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(drawableArr);
        this.z.setImageDrawable(transitionDrawable);
        com.tplink.iot.widget.plug.b bVar = new com.tplink.iot.widget.plug.b(transitionDrawable, 1000L);
        this.p3 = bVar;
        bVar.d();
    }

    private void E1() {
        this.J3.c0().observe(this, new b());
        this.J3.U().observe(this, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        Boolean bool = Boolean.TRUE;
        q f0 = q.f0(bool);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f0.o(10L, timeUnit).l0(io.reactivex.d0.b.a.a()).E(new d()).F0();
        q.f0(bool).o(20L, timeUnit).l0(io.reactivex.d0.b.a.a()).E(new e()).F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        q.f0(Boolean.TRUE).l0(io.reactivex.d0.b.a.a()).E(new f()).F0();
    }

    private void o1() {
        TPRippleBackground tPRippleBackground = this.p0;
        if (tPRippleBackground != null) {
            tPRippleBackground.f();
        }
        p1();
    }

    private void p1() {
        ValueAnimator valueAnimator = this.p2;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.p2.cancel();
            this.p2 = null;
        }
        com.tplink.iot.widget.plug.b bVar = this.p3;
        if (bVar != null) {
            bVar.b();
            this.p3 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        if (!isFinishing() && !isDestroyed()) {
            this.p1.setText(R.string.qs_pairing_device);
            A1();
            this.J3.O(this.H3.getDeviceIdMD5(), this.K3);
        }
    }

    private void r1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.H3 = (QuickSetupInfoBundle) extras.getSerializable("quick_setup_bundle");
            this.I3 = (WirelessInfoParams) extras.getSerializable("ap_ssid");
        }
    }

    private void s1() {
        BulbNickNameInputActivity.m1(this, this.H3);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(Integer num) {
        if (this.H3 != null) {
            b.d.w.c.a.n("QuickDiscovery", "handleFindDevice");
            z1();
            int currentTimeMillis = (int) ((System.currentTimeMillis() - this.L3) / 1000);
            int intValue = num.intValue();
            boolean z = true;
            if (intValue == 1 || intValue == 2) {
                r.u(this.H3.getDeviceType(), this.H3.getDeviceModel(), this.H3.getDeviceIdMD5(), currentTimeMillis);
            } else if (intValue == 3) {
                r.r(this.H3.getDeviceType(), this.H3.getDeviceModel(), this.H3.getDeviceIdMD5(), currentTimeMillis);
            }
            if (!this.K3) {
                if (num.intValue() != 1) {
                    z = false;
                }
                this.H3.setNeedDisplayInherit(z);
                if (z) {
                    BulbInheritAfterSetQsInfoActivity.l1(this, this.H3);
                } else {
                    s1();
                }
            } else if (this.H3.isSetInheritAndSuccess()) {
                com.tplink.iot.view.quicksetup.bulb.utils.a.c(this, this.H3);
            } else {
                s1();
            }
        }
    }

    private void u1() {
        ImageView imageView = (ImageView) findViewById(R.id.qs_m5);
        this.y = imageView;
        if (imageView != null) {
            imageView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        ((ImageView) findViewById(R.id.img_close)).setOnClickListener(this);
        this.z = (ImageView) findViewById(R.id.qs_m5_led);
        this.p1 = (TextView) findViewById(R.id.qs_tv_status);
        if (this.H3.isFromQuickDiscovery()) {
            this.p1.setText(R.string.qs_pairing_device);
        } else {
            this.p1.setText(getString(R.string.quicksetup_plug_connect_ap));
        }
        TPRippleBackground tPRippleBackground = (TPRippleBackground) findViewById(R.id.qs_m5_ripple_bg);
        this.p0 = tPRippleBackground;
        tPRippleBackground.e();
        this.y.setImageResource(com.tplink.iot.view.quicksetup.bulb.utils.b.k(this.H3.getDeviceModel()));
        QuickSetupInfoBundle quickSetupInfoBundle = this.H3;
        if (quickSetupInfoBundle == null || !quickSetupInfoBundle.isFromQuickDiscovery()) {
            D1();
        }
        E1();
        BulbQuickSetupViewModel bulbQuickSetupViewModel = this.J3;
        QuickSetupInfoBundle quickSetupInfoBundle2 = this.H3;
        bulbQuickSetupViewModel.C0(quickSetupInfoBundle2, bulbQuickSetupViewModel.E(this, this.I3, quickSetupInfoBundle2));
        this.L3 = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w1 */
    public /* synthetic */ void x1(ValueAnimator valueAnimator) {
        this.z.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static void y1(Context context, QuickSetupInfoBundle quickSetupInfoBundle, WirelessInfoParams wirelessInfoParams) {
        Intent intent = new Intent(context, SoftAPBulbConnectAPActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("quick_setup_bundle", quickSetupInfoBundle);
        if (wirelessInfoParams != null) {
            bundle.putSerializable("ap_ssid", wirelessInfoParams);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 101 && i2 == -1) {
            q1();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        C1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_close) {
            C1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_softap_bulb_connect_ap);
            com.tplink.iot.view.quicksetup.base.d.b0(this, R.color.common_colorAccent);
            r1();
            this.K3 = com.tplink.iot.view.quicksetup.bulb.utils.a.e(this.H3);
            QuickSetupInfoBundle quickSetupInfoBundle = this.H3;
            BulbQuickSetupViewModel bulbQuickSetupViewModel = (BulbQuickSetupViewModel) ViewModelProviders.of(this, new IoTViewModelFactory(this, quickSetupInfoBundle == null ? "" : quickSetupInfoBundle.getDeviceIdMD5())).get(BulbQuickSetupViewModel.class);
            this.J3 = bulbQuickSetupViewModel;
            QuickSetupInfoBundle quickSetupInfoBundle2 = this.H3;
            if (quickSetupInfoBundle2 != null) {
                bulbQuickSetupViewModel.B0(quickSetupInfoBundle2.getDeviceModel());
            }
            u1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.tplink.iot.base.b bVar = this.f6070c;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
        }
        BulbQuickSetupViewModel bulbQuickSetupViewModel = this.J3;
        if (bulbQuickSetupViewModel != null) {
            bulbQuickSetupViewModel.F();
        }
        o1();
        super.onDestroy();
    }

    public void z1() {
        b.d.w.c.a.n("QuickDiscovery", "onObdSuccess");
        this.J3.u0(this.H3.getDeviceIdMD5());
        this.J3.D();
    }
}
