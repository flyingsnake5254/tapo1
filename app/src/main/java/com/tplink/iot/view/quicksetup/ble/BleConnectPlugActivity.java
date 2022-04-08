package com.tplink.iot.view.quicksetup.ble;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.v;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.DeviceLocationInfo;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.common.PlugAPListActivity;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupViewModel;
import com.tplink.libtpcontrols.TPHookView;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.WirelessScanInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.u;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.tpble.z;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class BleConnectPlugActivity extends BaseActivity implements View.OnClickListener {
    private ImageView H3;
    private ImageView I3;
    private ImageView J3;
    private TPRippleBackground K3;
    private TPRippleBackground L3;
    private TextView M3;
    private ValueAnimator N3;
    private ValueAnimator O3;
    private ValueAnimator P3;
    private ValueAnimator Q3;
    private boolean R3;
    private boolean S3;
    private ValueAnimator T3;
    private Bitmap U3;
    private Handler V3;
    private boolean W3;
    private QuickSetupViewModel Y3;
    private io.reactivex.e0.c Z3;
    private QuickSetupInfoBean a4;
    private String b4;
    private int d4;
    private int e4;
    private boolean f4;
    private Integer g4;
    private Integer h4;
    private io.reactivex.e0.c i4;
    private long j4;
    private ImageView p0;
    private ImageView p1;
    private ImageView p2;
    private ImageView p3;
    private boolean z;
    private int y = 0;
    private int X3 = 48;
    private List<WirelessScanInfoBean> c4 = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<com.tplink.iot.viewmodel.quicksetup.i<List<WirelessScanInfoBean>>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable com.tplink.iot.viewmodel.quicksetup.i<List<WirelessScanInfoBean>> iVar) {
            if (iVar == null || iVar.b() != 0) {
                BleConnectPlugActivity.this.u2("get wireless list fail");
                BleConnectPlugActivity.this.n2();
                return;
            }
            BleConnectPlugActivity.this.r2(iVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BleConnectPlugActivity.this.p1.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (BleConnectPlugActivity.this.S3) {
                BleConnectPlugActivity bleConnectPlugActivity = BleConnectPlugActivity.this;
                bleConnectPlugActivity.R3 = !bleConnectPlugActivity.R3;
            }
            BleConnectPlugActivity.this.p1.setImageResource(BleConnectPlugActivity.this.R3 ? BleConnectPlugActivity.this.e4 : BleConnectPlugActivity.this.d4);
            BleConnectPlugActivity bleConnectPlugActivity2 = BleConnectPlugActivity.this;
            bleConnectPlugActivity2.S3 = !bleConnectPlugActivity2.S3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BleConnectPlugActivity.this.R3 = false;
            BleConnectPlugActivity.this.S3 = false;
            BleConnectPlugActivity.this.p1.setImageResource(BleConnectPlugActivity.this.d4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BleConnectPlugActivity.this.p1.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements TPMaterialDialogV2.d {
        e() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            BleConnectPlugActivity.this.f4 = true;
            r.g(com.tplink.iot.view.quicksetup.base.d.t(BleConnectPlugActivity.this.b4), BleConnectPlugActivity.this.b4, "SearchDevicePage");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RectF f9549c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f9550d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Canvas f9551f;
        final /* synthetic */ Paint q;

        f(RectF rectF, int i, Canvas canvas, Paint paint) {
            this.f9549c = rectF;
            this.f9550d = i;
            this.f9551f = canvas;
            this.q = paint;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RectF rectF = this.f9549c;
            int i = this.f9550d;
            int i2 = BleConnectPlugActivity.this.y;
            int i3 = this.f9550d;
            rectF.top = ((i - (i / 12)) - ((i2 * i3) / 8)) - 3;
            this.f9549c.bottom = (i3 - ((BleConnectPlugActivity.this.y * this.f9550d) / 8)) - 3;
            this.f9551f.drawRoundRect(this.f9549c, 8.0f, 8.0f, this.q);
            BleConnectPlugActivity.this.p2.setImageBitmap(BleConnectPlugActivity.this.U3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements Animator.AnimatorListener {
        g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BleConnectPlugActivity.this.y = 0;
            BleConnectPlugActivity.this.h2();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            BleConnectPlugActivity.g1(BleConnectPlugActivity.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ImageView f9553c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TPHookView f9554d;

        h(ImageView imageView, TPHookView tPHookView) {
            this.f9553c = imageView;
            this.f9554d = tPHookView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (this.f9553c != null && this.f9554d != null) {
                if (floatValue < 60.0f) {
                    BleConnectPlugActivity.this.K3.setTranslationY((floatValue / 60.0f) * (BleConnectPlugActivity.this.p2.getHeight() + BleConnectPlugActivity.this.p0.getHeight()));
                }
                if (floatValue > 45.0f && floatValue <= 100.0f) {
                    BleConnectPlugActivity.this.H3.setVisibility(4);
                    BleConnectPlugActivity.this.p3.setVisibility(4);
                    this.f9553c.setVisibility(0);
                }
                if (floatValue > 40.0f && floatValue <= 100.0f) {
                    this.f9553c.setTranslationY(((40.0f - floatValue) / 100.0f) * BleConnectPlugActivity.this.p2.getHeight());
                    float f2 = ((floatValue - 40.0f) / 100.0f) + 1.0f;
                    this.f9553c.setScaleX(f2);
                    this.f9553c.setScaleY(f2);
                }
                if (floatValue >= 100.0f && floatValue <= 200.0f) {
                    float f3 = (floatValue - 100.0f) / 100.0f;
                    this.f9554d.setScaleX(f3);
                    this.f9554d.setScaleY(f3);
                    this.f9554d.setVisibility(0);
                }
                if (floatValue >= 200.0f && floatValue <= 300.0f && !BleConnectPlugActivity.this.z) {
                    this.f9554d.h();
                    BleConnectPlugActivity.this.z = true;
                }
                if (floatValue > 300.0f) {
                    float f4 = 400.0f - floatValue;
                    float f5 = f4 / 110.0f;
                    this.f9554d.setScaleX(f5);
                    this.f9554d.setScaleY(f5);
                    BleConnectPlugActivity.this.M3.setAlpha((f4 * 1.0f) / 100.0f);
                    float f6 = (((floatValue - 300.0f) * 8.0f) / 100.0f) + 1.6f;
                    this.f9553c.setScaleX(f6);
                    this.f9553c.setScaleY(f6);
                }
                if (floatValue >= 400.0f) {
                    this.f9554d.setVisibility(4);
                    this.f9553c.setVisibility(4);
                    BleConnectPlugActivity.this.O3.cancel();
                    BleConnectPlugActivity.this.z = false;
                    BleConnectPlugActivity.this.K3.e();
                    BleConnectPlugActivity.this.X3 = 51;
                    BleConnectPlugActivity.this.M3.setAlpha(1.0f);
                    BleConnectPlugActivity.this.M3.setText(BleConnectPlugActivity.this.getString(R.string.quicksetup_scan_ap));
                    BleConnectPlugActivity.this.a2();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BleConnectPlugActivity.this.I3.setTranslationY(((floatValue / 200.0f) * BleConnectPlugActivity.this.p2.getHeight()) + 8.0f);
            BleConnectPlugActivity.this.J3.setTranslationY((((-floatValue) / 200.0f) * BleConnectPlugActivity.this.p2.getHeight()) - 8.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!BleConnectPlugActivity.this.isDestroyed()) {
                BleConnectPlugActivity.this.f2("ble disable");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class k implements io.reactivex.g0.g<DeviceLocationInfo> {
        k() {
        }

        /* renamed from: a */
        public void accept(DeviceLocationInfo deviceLocationInfo) throws Exception {
            if (deviceLocationInfo != null && deviceLocationInfo.getLatitude() != null && deviceLocationInfo.getLongitude() != null) {
                BleConnectPlugActivity.this.h4 = deviceLocationInfo.getLatitude();
                BleConnectPlugActivity.this.g4 = deviceLocationInfo.getLongitude();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class l implements io.reactivex.g0.g<u> {
        l() {
        }

        /* renamed from: a */
        public void accept(u uVar) throws Exception {
            if (uVar.b() == 0) {
                BleConnectPlugActivity.this.a4 = new QuickSetupInfoBean(uVar.a(), BleConnectPlugActivity.this.j4);
                r.d();
                BleConnectPlugActivity.this.e2();
            } else if (uVar.b() == -1500) {
                BleConnectPlugActivity.this.f2("ble scan, no find device");
            } else {
                BleConnectPlugActivity.this.y2("ble connect device fail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!BleConnectPlugActivity.this.isDestroyed()) {
                BleConnectPlugActivity.this.X1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class n implements Observer<com.tplink.iot.viewmodel.quicksetup.i<QuickSetupComponentResult>> {
        n() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable com.tplink.iot.viewmodel.quicksetup.i<QuickSetupComponentResult> iVar) {
            if (iVar == null || iVar.b() != 0) {
                BleConnectPlugActivity.this.u2("get component fail");
            } else {
                BleConnectPlugActivity.this.q2(iVar.a());
            }
        }
    }

    private void A2() {
        this.Z3 = this.Y3.D0().G0(new l());
    }

    private void R1() {
        ValueAnimator valueAnimator = this.N3;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.N3.cancel();
            this.N3 = null;
        }
        ValueAnimator valueAnimator2 = this.O3;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.O3.cancel();
            this.O3 = null;
        }
        ValueAnimator valueAnimator3 = this.P3;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
            this.P3.cancel();
            this.P3 = null;
        }
        TPRippleBackground tPRippleBackground = this.L3;
        if (tPRippleBackground != null) {
            tPRippleBackground.f();
        }
        TPRippleBackground tPRippleBackground2 = this.K3;
        if (tPRippleBackground2 != null) {
            tPRippleBackground2.f();
        }
    }

    private void S1() {
        ValueAnimator valueAnimator = this.Q3;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.Q3.cancel();
            this.Q3 = null;
        }
    }

    private void T1() {
        ValueAnimator valueAnimator = this.T3;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.T3.cancel();
            this.T3 = null;
        }
    }

    private void U1() {
        d2();
    }

    private void V1() {
        ImageView imageView = (ImageView) findViewById(R.id.qs_phone_move);
        TPHookView tPHookView = (TPHookView) findViewById(R.id.hook_view_phone);
        this.p0.setVisibility(4);
        this.p0.setVisibility(0);
        this.p2.setVisibility(4);
        this.K3.setTranslationY(0.0f);
        ValueAnimator valueAnimator = this.P3;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.K3.f();
        this.L3.f();
        this.I3.setVisibility(4);
        this.J3.setVisibility(4);
        this.z = false;
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 400.0f).setDuration(4000L);
        this.O3 = duration;
        duration.setStartDelay(200L);
        this.O3.addUpdateListener(new h(imageView, tPHookView));
        this.O3.start();
    }

    private boolean W1() {
        if (this.X3 != 49 || this.W3) {
            return false;
        }
        this.W3 = true;
        j2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X1() {
        S1();
        l2();
        this.Y3.X();
    }

    private String Y1() {
        String deviceType = EnumDeviceType.PLUG.getDeviceType();
        QuickSetupInfoBean quickSetupInfoBean = this.a4;
        return (quickSetupInfoBean == null || quickSetupInfoBean.getComponentResult() == null || this.a4.getComponentResult().getExtraInfo() == null) ? deviceType : this.a4.getComponentResult().getExtraInfo().getDeviceType();
    }

    private void Z1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.b4 = extras.getString("device_model");
            this.j4 = extras.getLong("onboarding_start_time", 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2() {
        this.Y3.j0();
    }

    private int b2() {
        return com.tplink.iot.view.quicksetup.base.c.d(this.b4);
    }

    private void c2() {
        Integer num;
        if (!(this.a4 == null || (num = this.h4) == null || this.g4 == null)) {
            int intValue = num.intValue();
            int intValue2 = this.g4.intValue();
            this.a4.setLatitude(Integer.valueOf(intValue));
            this.a4.setLongitude(Integer.valueOf(intValue2));
        }
        Intent intent = new Intent(this, PlugAPListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("device_info_bean", this.a4);
        if (!this.c4.isEmpty()) {
            bundle.putSerializable("ap_ssid_list", (Serializable) this.c4);
        }
        intent.putExtras(bundle);
        startActivityForResult(intent, 102);
        o2();
    }

    private void d2() {
        int i2 = this.X3;
        if (i2 == 49) {
            this.X3 = 50;
            this.M3.setText(getString(R.string.quicksetup_no_bluetooth_found_m5));
            V1();
            m2();
        } else if (i2 == 51) {
            this.M3.setText(getString(R.string.quicksetup_scan_ap));
            a2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2() {
        if (W1()) {
            this.V3.postDelayed(new m(), 2000L);
        } else {
            X1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f2(String str) {
        y2(str);
    }

    static /* synthetic */ int g1(BleConnectPlugActivity bleConnectPlugActivity) {
        int i2 = bleConnectPlugActivity.y;
        bleConnectPlugActivity.y = i2 + 1;
        return i2;
    }

    private void g2() {
        this.V3 = new Handler();
        this.p2 = (ImageView) findViewById(R.id.arrow_line);
        this.p0 = (ImageView) findViewById(R.id.qs_m5_move);
        this.d4 = com.tplink.iot.view.quicksetup.base.c.j(this.b4);
        this.e4 = com.tplink.iot.view.quicksetup.base.c.f(this.b4);
        ((ImageView) findViewById(R.id.img_close)).setOnClickListener(this);
        this.p3 = (ImageView) findViewById(R.id.qs_phone);
        this.H3 = (ImageView) findViewById(R.id.qs_phone_bluetooth);
        this.I3 = (ImageView) findViewById(R.id.image_arrow_down);
        this.J3 = (ImageView) findViewById(R.id.image_arrow_up);
        this.M3 = (TextView) findViewById(R.id.qs_tv_status);
        this.p1 = (ImageView) findViewById(R.id.qs_m5_led);
        this.L3 = (TPRippleBackground) findViewById(R.id.qs_mobile_ripple_bg);
        this.K3 = (TPRippleBackground) findViewById(R.id.qs_m5_ripple_bg_move);
        s2();
        x2();
        w2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h2() {
        this.J3.setTranslationY(0.0f);
        this.I3.setTranslationY(0.0f);
        this.J3.setVisibility(0);
        this.I3.setVisibility(0);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 100.0f).setDuration(1000L);
        this.P3 = duration;
        duration.setStartDelay(200L);
        this.P3.addUpdateListener(new i());
        this.P3.setRepeatMode(1);
        this.P3.setRepeatCount(-1);
        this.P3.start();
    }

    private void i2() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(500L);
        this.Q3 = duration;
        duration.addUpdateListener(new b());
        this.Q3.addListener(new c());
        this.Q3.setRepeatCount(-1);
        this.Q3.setRepeatMode(2);
        this.Q3.start();
    }

    private void j2() {
        ImageView imageView = this.p2;
        if (imageView != null) {
            int height = imageView.getHeight();
            this.p2.setImageResource(R.color.transparent);
            this.p2.setVisibility(0);
            this.U3 = Bitmap.createBitmap(this.p2.getWidth(), height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.U3);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setColor(ContextCompat.getColor(this, R.color.common_white));
            RectF rectF = new RectF();
            rectF.left = 0.0f;
            rectF.right = this.p2.getWidth();
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 100.0f).setDuration(80L);
            this.N3 = duration;
            duration.setStartDelay(200L);
            this.N3.addUpdateListener(new f(rectF, height, canvas, paint));
            this.N3.addListener(new g());
            this.N3.setRepeatMode(1);
            this.N3.setRepeatCount(8);
            this.N3.start();
        }
    }

    private void k2() {
        this.i4 = com.tplink.iot.view.quicksetup.base.f.c.h().g(5000L).E(new k()).F0();
    }

    private void l2() {
        this.p1.setImageResource(this.d4);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(1000L);
        this.T3 = duration;
        duration.addUpdateListener(new d());
        this.T3.setRepeatCount(-1);
        this.T3.setRepeatMode(2);
        this.T3.start();
    }

    private void m2() {
        String Y1 = Y1();
        String str = this.b4;
        QuickSetupInfoBean quickSetupInfoBean = this.a4;
        r.b(Y1, str, quickSetupInfoBean == null ? "" : quickSetupInfoBean.getDeviceIdMD5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2() {
        String Y1 = Y1();
        String str = this.b4;
        QuickSetupInfoBean quickSetupInfoBean = this.a4;
        r.o(Y1, str, quickSetupInfoBean == null ? "" : quickSetupInfoBean.getDeviceIdMD5());
    }

    private void o2() {
        String Y1 = Y1();
        String str = this.b4;
        QuickSetupInfoBean quickSetupInfoBean = this.a4;
        r.p(Y1, str, quickSetupInfoBean == null ? "" : quickSetupInfoBean.getDeviceIdMD5(), false);
    }

    public static void p2(Context context, String str, long j2) {
        Intent intent = new Intent(context, BleConnectPlugActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("device_model", str);
        bundle.putLong("onboarding_start_time", j2);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2(QuickSetupComponentResult quickSetupComponentResult) {
        if (com.tplink.iot.view.quicksetup.base.d.x(quickSetupComponentResult) <= 0) {
            u2("parse component fail");
            return;
        }
        QuickSetupInfoBean quickSetupInfoBean = this.a4;
        if (quickSetupInfoBean != null) {
            quickSetupInfoBean.setComponentResult(quickSetupComponentResult);
        }
        U1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2(List<WirelessScanInfoBean> list) {
        if (list == null) {
            u2("parse wireless list fail");
            return;
        }
        if (!list.isEmpty()) {
            this.c4.addAll(list);
        }
        c2();
    }

    private void s2() {
        this.W3 = false;
        this.I3.setVisibility(4);
        this.I3.setTranslationY(0.0f);
        this.J3.setVisibility(4);
        this.J3.setTranslationY(0.0f);
        this.p2.setImageResource(R.color.transparent);
        this.p2.setVisibility(0);
        this.p2.setTranslationY(0.0f);
        this.p2.setAlpha(1.0f);
        this.K3.setVisibility(0);
        this.K3.setTranslationY(0.0f);
        this.p0.setImageResource(b2());
    }

    private void t2() {
        Bitmap bitmap = this.U3;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.U3.recycle();
            this.U3 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u2(String str) {
        int i2 = this.X3;
        if (i2 != 49 && i2 != 51) {
            return;
        }
        if (!z.b(this)) {
            y2(str);
        } else if (this.Y3.l0()) {
            this.Y3.close();
            y2(str);
        } else {
            y2(str);
        }
    }

    private void v2() {
        if (com.tplink.iot.view.quicksetup.base.ble.d.b(this)) {
            k2();
            A2();
            return;
        }
        this.V3.postDelayed(new j(), 5000L);
    }

    private void w2() {
        this.X3 = 49;
        this.K3.e();
        this.L3.e();
        i2();
        v2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2(String str) {
        BleNoFindActivity.l1(this, this.b4, 100);
        r.c();
        v.a(BleConnectPlugActivity.class, BleNoFindActivity.class, str);
    }

    private void z2() {
        com.tplink.iot.view.quicksetup.base.d.e0(this, new e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != -1) {
            super.onActivityResult(i2, i3, intent);
        } else if (i2 == 100) {
            v2();
        } else if (i2 == 102) {
            this.c4.clear();
            a2();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        z2();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_close) {
            z2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_qs_connect_plug_ble);
            com.tplink.iot.view.quicksetup.base.d.b0(this, R.color.quicksetup_bg_blue);
            Z1();
            this.Y3 = (QuickSetupViewModel) ViewModelProviders.of(this).get(QuickSetupViewModel.class);
            g2();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        QuickSetupViewModel quickSetupViewModel;
        super.onDestroy();
        Handler handler = this.V3;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        io.reactivex.e0.c cVar = this.i4;
        if (cVar != null) {
            cVar.dispose();
            this.i4 = null;
        }
        if (this.f4 && (quickSetupViewModel = this.Y3) != null) {
            com.tplink.iot.view.quicksetup.base.d.h(quickSetupViewModel.e0(this.a4));
        }
        t2();
        R1();
        io.reactivex.e0.c cVar2 = this.Z3;
        if (cVar2 != null) {
            cVar2.dispose();
        }
        S1();
        T1();
    }

    public void x2() {
        this.Y3.W().observe(this, new n());
        this.Y3.i0().observe(this, new a());
    }
}
