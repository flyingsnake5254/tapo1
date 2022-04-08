package com.tplink.iot.view.quicksetup.discovery;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.v;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.bulb.BulbInheritBeforeSetQsInfoActivity;
import com.tplink.iot.view.quicksetup.bulb.SoftAPBulbConnectAPActivity;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.InheritInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DiscoveryDeviceConnectActivity extends BaseActivity implements View.OnClickListener {
    private ImageView H3;
    private TPRippleBackground I3;
    private TPRippleBackground J3;
    private TextView K3;
    private ValueAnimator L3;
    private com.tplink.iot.widget.plug.b M3;
    private Handler N3;
    private volatile boolean O3;
    private BulbQuickSetupViewModel P3;
    private io.reactivex.e0.c Q3;
    private QuickSetupInfoBundle R3;
    private String S3;
    private boolean T3;
    private boolean U3;
    private ImageView p0;
    private ImageView p1;
    private ImageView p2;
    private ImageView p3;
    private ImageView y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            DiscoveryDeviceConnectActivity.this.y.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            DiscoveryDeviceConnectActivity.this.v1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<i<QuickSetupComponentResult>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable i<QuickSetupComponentResult> iVar) {
            if (iVar == null || iVar.b() != 0) {
                b.d.w.c.a.d("getQsComponentResultLiveData fail");
                DiscoveryDeviceConnectActivity.this.z1("get component fail");
                return;
            }
            DiscoveryDeviceConnectActivity.this.x1(iVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<i<InheritInfoResult>> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable i<InheritInfoResult> iVar) {
            boolean z = false;
            if (iVar == null || iVar.b() != 0) {
                DiscoveryDeviceConnectActivity.this.U3 = false;
            } else {
                InheritInfoResult a = iVar.a();
                DiscoveryDeviceConnectActivity discoveryDeviceConnectActivity = DiscoveryDeviceConnectActivity.this;
                if (a != null && a.isInheritStatus()) {
                    z = true;
                }
                discoveryDeviceConnectActivity.U3 = z;
            }
            DiscoveryDeviceConnectActivity.this.o1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements g<Long> {
        d() {
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            if (!DiscoveryDeviceConnectActivity.this.O3) {
                DiscoveryDeviceConnectActivity.this.t1("total timeout, exceed 2min");
            }
        }
    }

    private void A1() {
        com.tplink.iot.view.quicksetup.bulb.utils.a.h(this, this.R3.getDeviceType(), this.R3.getDeviceModel(), "SearchDevicePage");
    }

    private void B1() {
        m1();
        y1();
        this.I3.e();
        this.J3.e();
        C1();
        this.P3.Y();
    }

    private void C1() {
        this.Q3 = q.W0(120L, TimeUnit.SECONDS).l0(io.reactivex.d0.b.a.a()).G0(new d());
    }

    private void D1() {
        this.P3.Z().observe(this, new b());
        this.P3.W().observe(this, new c());
    }

    private void m1() {
        TPRippleBackground tPRippleBackground = this.J3;
        if (tPRippleBackground != null) {
            tPRippleBackground.f();
        }
        TPRippleBackground tPRippleBackground2 = this.I3;
        if (tPRippleBackground2 != null) {
            tPRippleBackground2.f();
        }
        n1();
    }

    private void n1() {
        ValueAnimator valueAnimator = this.L3;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.L3.cancel();
            this.L3 = null;
        }
        com.tplink.iot.widget.plug.b bVar = this.M3;
        if (bVar != null) {
            bVar.b();
            this.M3 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        if (this.U3) {
            s1();
        } else {
            r1();
        }
    }

    private void p1() {
        if (this.T3) {
            this.T3 = false;
            this.P3.V();
            return;
        }
        r1();
    }

    private void q1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.R3 = (QuickSetupInfoBundle) extras.getSerializable("quick_setup_bundle");
        }
    }

    private void r1() {
        if (!this.O3) {
            this.O3 = true;
            if (this.R3 == null) {
                this.R3 = new QuickSetupInfoBundle();
            }
            this.R3.setDeviceIdMD5(this.S3);
            QuickSetupInfoBundle quickSetupInfoBundle = this.R3;
            quickSetupInfoBundle.setOnBoardingType(com.tplink.iot.view.quicksetup.bulb.utils.b.t(quickSetupInfoBundle.getDeviceModel()));
            this.R3.setNeedDisplayInherit(this.U3);
            SoftAPBulbConnectAPActivity.y1(this, this.R3, null);
        }
    }

    private void s1() {
        BulbInheritBeforeSetQsInfoActivity.h1(this, this.R3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(String str) {
        if (!this.O3) {
            this.O3 = true;
            io.reactivex.e0.c cVar = this.Q3;
            if (cVar != null) {
                cVar.dispose();
            }
            Handler handler = this.N3;
            String str2 = null;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            QuickSetupInfoBundle quickSetupInfoBundle = this.R3;
            if (quickSetupInfoBundle != null) {
                str2 = quickSetupInfoBundle.getDeviceModel();
            }
            DiscoveryDevicePairingFailedActivity.h1(this, str2, 103);
            v.a(DiscoveryDeviceConnectActivity.class, DiscoveryDevicePairingFailedActivity.class, str);
        }
    }

    private void u1() {
        this.N3 = new Handler();
        this.p0 = (ImageView) findViewById(R.id.arrow_line);
        ImageView imageView = (ImageView) findViewById(R.id.qs_m5_move);
        this.y = imageView;
        if (imageView != null) {
            imageView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        ((ImageView) findViewById(R.id.img_close)).setOnClickListener(this);
        this.z = (ImageView) findViewById(R.id.qs_m5_led);
        this.p1 = (ImageView) findViewById(R.id.qs_phone);
        this.p2 = (ImageView) findViewById(R.id.qs_phone_wifi);
        this.p3 = (ImageView) findViewById(R.id.image_arrow_down);
        this.H3 = (ImageView) findViewById(R.id.image_arrow_up);
        this.K3 = (TextView) findViewById(R.id.qs_tv_status);
        this.J3 = (TPRippleBackground) findViewById(R.id.qs_mobile_ripple_bg);
        this.I3 = (TPRippleBackground) findViewById(R.id.qs_m5_ripple_bg_move);
        this.y.setImageResource(com.tplink.iot.view.quicksetup.bulb.utils.b.k(this.R3.getDeviceModel()));
        D1();
        this.S3 = this.R3.getDeviceIdMD5();
        this.P3.f0(this.R3.getDeviceIdMD5());
        B1();
    }

    public static void w1(Context context, QuickSetupInfoBundle quickSetupInfoBundle) {
        Intent intent = new Intent(context, DiscoveryDeviceConnectActivity.class);
        Bundle bundle = new Bundle();
        if (quickSetupInfoBundle != null) {
            bundle.putSerializable("quick_setup_bundle", quickSetupInfoBundle);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(QuickSetupComponentResult quickSetupComponentResult) {
        if (com.tplink.iot.view.quicksetup.base.d.x(quickSetupComponentResult) <= 0) {
            b.d.w.c.a.d("parseComponentResult fail");
            z1("parse component fail");
            return;
        }
        if (this.R3 == null) {
            this.R3 = new QuickSetupInfoBundle();
        }
        this.R3.setComponentResult(quickSetupComponentResult);
        this.T3 = com.tplink.iot.view.quicksetup.bulb.utils.a.e(this.R3);
        p1();
    }

    private void y1() {
        this.p3.setVisibility(4);
        this.p3.setTranslationY(0.0f);
        this.H3.setVisibility(4);
        this.H3.setTranslationY(0.0f);
        this.p0.setImageResource(R.color.transparent);
        this.p0.setVisibility(0);
        this.p0.setTranslationY(0.0f);
        this.p0.setAlpha(1.0f);
        this.I3.setVisibility(0);
        this.I3.setTranslationY(0.0f);
        this.y.setVisibility(0);
        this.y.setAlpha(1.0f);
        this.p1.setVisibility(0);
        this.p1.setAlpha(1.0f);
        this.p2.setVisibility(0);
        this.p2.setAlpha(1.0f);
        this.K3.setText(getString(R.string.quicksetup_looking_for_plug_new));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1(String str) {
        t1(str);
    }

    @Override // android.app.Activity
    public void finish() {
        this.O3 = true;
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            super.onActivityResult(i, i2, intent);
        } else if (i == 103) {
            B1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        A1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_close) {
            A1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_softap_connect_bulb);
            com.tplink.iot.view.quicksetup.base.d.b0(this, R.color.common_colorAccent);
            q1();
            BulbQuickSetupViewModel bulbQuickSetupViewModel = (BulbQuickSetupViewModel) ViewModelProviders.of(this).get(BulbQuickSetupViewModel.class);
            this.P3 = bulbQuickSetupViewModel;
            bulbQuickSetupViewModel.B0(this.R3.getDeviceModel());
            u1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.O3 = true;
        Handler handler = this.N3;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.N3 = null;
        }
        m1();
        io.reactivex.e0.c cVar = this.Q3;
        if (cVar != null) {
            cVar.dispose();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.O3 = false;
    }
}
