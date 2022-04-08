package com.tplink.iot.view.quicksetup.bulb;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.v;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.Utils.y;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.libtpcontrols.TPHookView;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.InheritInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.QuickSetupComponentResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.WirelessScanInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.u;
import com.tplink.libtpwifi.TPWifiConnectReceiver;
import com.tplink.libtpwifi.TPWifiStateReceiver;
import io.reactivex.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class SoftAPConnectBulbActivity extends BaseActivity implements View.OnClickListener {
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
    private ValueAnimator R3;
    private ValueAnimator S3;
    private ValueAnimator T3;
    private com.tplink.iot.widget.plug.b U3;
    private Bitmap V3;
    private Bitmap W3;
    private Bitmap X3;
    private Handler Y3;
    private volatile boolean Z3;
    private boolean a4;
    private QuickSetupInfoBundle c4;
    private TPWifiConnectReceiver d4;
    private TPWifiStateReceiver e4;
    private BulbQuickSetupViewModel g4;
    private io.reactivex.e0.c h4;
    private io.reactivex.e0.c i4;
    private io.reactivex.e0.c j4;
    private String k4;
    private String l4;
    private String m4;
    private boolean n4;
    private ImageView p0;
    private ImageView p1;
    private ImageView p2;
    private ImageView p3;
    private boolean p4;
    private boolean z;
    private int y = 0;
    private int b4 = 48;
    private boolean f4 = false;
    private List<WirelessScanInfoBean> o4 = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SoftAPConnectBulbActivity.this.y = 0;
            SoftAPConnectBulbActivity.this.i2();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            SoftAPConnectBulbActivity.s1(SoftAPConnectBulbActivity.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SoftAPConnectBulbActivity.this.I3.setTranslationY(((floatValue / 200.0f) * SoftAPConnectBulbActivity.this.p2.getHeight()) + 8.0f);
            SoftAPConnectBulbActivity.this.J3.setTranslationY((((-floatValue) / 200.0f) * SoftAPConnectBulbActivity.this.p2.getHeight()) - 8.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ImageView f9613c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TPHookView f9614d;

        c(ImageView imageView, TPHookView tPHookView) {
            this.f9613c = imageView;
            this.f9614d = tPHookView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (this.f9613c != null && this.f9614d != null) {
                if (floatValue < 60.0f) {
                    SoftAPConnectBulbActivity.this.K3.setTranslationY((floatValue / 60.0f) * (SoftAPConnectBulbActivity.this.p2.getHeight() + SoftAPConnectBulbActivity.this.p0.getHeight()));
                }
                if (floatValue > 45.0f && floatValue <= 100.0f) {
                    SoftAPConnectBulbActivity.this.H3.setVisibility(4);
                    SoftAPConnectBulbActivity.this.p3.setVisibility(4);
                    this.f9613c.setVisibility(0);
                }
                if (floatValue > 40.0f && floatValue <= 100.0f) {
                    this.f9613c.setTranslationY(((40.0f - floatValue) / 100.0f) * SoftAPConnectBulbActivity.this.p2.getHeight());
                    float f2 = ((floatValue - 40.0f) / 100.0f) + 1.0f;
                    this.f9613c.setScaleX(f2);
                    this.f9613c.setScaleY(f2);
                }
                if (floatValue >= 100.0f && floatValue <= 200.0f) {
                    float f3 = (floatValue - 100.0f) / 100.0f;
                    this.f9614d.setScaleX(f3);
                    this.f9614d.setScaleY(f3);
                    this.f9614d.setVisibility(0);
                }
                if (floatValue >= 200.0f && floatValue <= 300.0f && !SoftAPConnectBulbActivity.this.z) {
                    this.f9614d.h();
                    SoftAPConnectBulbActivity.this.M3.setText("");
                    SoftAPConnectBulbActivity.this.z = true;
                }
                if (floatValue > 300.0f) {
                    float f4 = 400.0f - floatValue;
                    float f5 = f4 / 110.0f;
                    this.f9614d.setScaleX(f5);
                    this.f9614d.setScaleY(f5);
                    SoftAPConnectBulbActivity.this.M3.setAlpha((f4 * 1.0f) / 100.0f);
                    float f6 = (((floatValue - 300.0f) * 8.0f) / 100.0f) + 1.6f;
                    this.f9613c.setScaleX(f6);
                    this.f9613c.setScaleY(f6);
                }
                if (floatValue >= 400.0f) {
                    this.f9614d.setVisibility(4);
                    this.f9613c.setVisibility(4);
                    SoftAPConnectBulbActivity.this.Q3.cancel();
                    SoftAPConnectBulbActivity.this.z = false;
                    SoftAPConnectBulbActivity.this.K3.e();
                    SoftAPConnectBulbActivity.this.b4 = 51;
                    SoftAPConnectBulbActivity.this.e2();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!SoftAPConnectBulbActivity.this.Z3 && !SoftAPConnectBulbActivity.this.f4) {
                SoftAPConnectBulbActivity.this.g2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements io.reactivex.g0.g<Long> {
        e() {
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            if (!SoftAPConnectBulbActivity.this.Z3) {
                SoftAPConnectBulbActivity.this.C2("total timeout, exceed 2min");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements io.reactivex.g0.g<Long> {
        f() {
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            if (SoftAPConnectBulbActivity.this.Z3) {
                if (SoftAPConnectBulbActivity.this.i4 != null) {
                    SoftAPConnectBulbActivity.this.i4.dispose();
                }
            } else if (com.tplink.iot.view.quicksetup.base.wifi.d.a(SoftAPConnectBulbActivity.this) && !TextUtils.isEmpty(SoftAPConnectBulbActivity.this.l4)) {
                if (!com.tplink.iot.view.quicksetup.base.d.V(SoftAPConnectBulbActivity.this.l4, com.tplink.libtpwifi.b.k().l())) {
                    b.d.w.c.a.d("checkSwitchWifiStateDoRetry is not SSidEquals");
                    SoftAPConnectBulbActivity.this.f4 = false;
                    SoftAPConnectBulbActivity.this.J2();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            SoftAPConnectBulbActivity.this.p0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            SoftAPConnectBulbActivity.this.k2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements com.tplink.libtpwifi.a {

        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!SoftAPConnectBulbActivity.this.Z3 && SoftAPConnectBulbActivity.this.f4) {
                    SoftAPConnectBulbActivity.this.A2();
                    r.y(SoftAPConnectBulbActivity.this.l4);
                }
            }
        }

        h() {
        }

        @Override // com.tplink.libtpwifi.a
        public void a(String str) {
            b.d.w.c.a.d("initWifiConnectReceiver connected");
            SoftAPConnectBulbActivity.this.m4 = null;
            SoftAPConnectBulbActivity.this.f4 = false;
        }

        @Override // com.tplink.libtpwifi.a
        public void b(String str, String str2) {
            if (!SoftAPConnectBulbActivity.this.f4 && !"<unknown ssid>".equals(str) && com.tplink.iot.view.quicksetup.base.d.V(SoftAPConnectBulbActivity.this.l4, str)) {
                b.d.w.c.a.d("initWifiConnectReceiver connected");
                SoftAPConnectBulbActivity.this.m4 = str2;
                SoftAPConnectBulbActivity.this.f4 = true;
                SoftAPConnectBulbActivity.this.b4 = 49;
                SoftAPConnectBulbActivity.this.Y3.postDelayed(new a(), 5000L);
            }
        }

        @Override // com.tplink.libtpwifi.a
        public void c(String str) {
            b.d.w.c.a.d("initWifiConnectReceiver disConnected 1");
            if (!TextUtils.isEmpty(str) && str.equals(SoftAPConnectBulbActivity.this.m4)) {
                b.d.w.c.a.d("initWifiConnectReceiver disConnected 2");
                SoftAPConnectBulbActivity.this.m4 = null;
                SoftAPConnectBulbActivity.this.f4 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements io.reactivex.g0.g<u> {
        i() {
        }

        /* renamed from: a */
        public void accept(u uVar) throws Exception {
            if (uVar.d()) {
                b.d.w.c.a.d("sendTDPBroadcast 3");
                SoftAPConnectBulbActivity.this.k4 = uVar.a();
                SoftAPConnectBulbActivity.this.f2();
                return;
            }
            b.d.w.c.a.d("sendTDPBroadcast 4");
            if (SoftAPConnectBulbActivity.this.f4) {
                b.d.w.c.a.d("sendTDPBroadcast 5");
                SoftAPConnectBulbActivity.this.y2("TDP scan fail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!SoftAPConnectBulbActivity.this.isDestroyed()) {
                SoftAPConnectBulbActivity.this.g4.Y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!SoftAPConnectBulbActivity.this.Z3) {
                SoftAPConnectBulbActivity.this.g4.d0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class l implements Observer<com.tplink.iot.viewmodel.quicksetup.i<QuickSetupComponentResult>> {
        l() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable com.tplink.iot.viewmodel.quicksetup.i<QuickSetupComponentResult> iVar) {
            if (iVar == null || iVar.b() != 0) {
                b.d.w.c.a.d("getQsComponentResultLiveData fail");
                SoftAPConnectBulbActivity.this.y2("get component fail");
                return;
            }
            SoftAPConnectBulbActivity.this.r2(iVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class m implements Observer<com.tplink.iot.viewmodel.quicksetup.i<List<WirelessScanInfoBean>>> {
        m() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable com.tplink.iot.viewmodel.quicksetup.i<List<WirelessScanInfoBean>> iVar) {
            if (iVar == null || iVar.b() != 0) {
                b.d.w.c.a.d("getWirelessScanInfoLiveData fail");
                SoftAPConnectBulbActivity.this.y2("get wireless list fail");
                r.o(SoftAPConnectBulbActivity.this.c4.getDeviceType(), SoftAPConnectBulbActivity.this.c4.getDeviceModel(), SoftAPConnectBulbActivity.this.k4);
                return;
            }
            SoftAPConnectBulbActivity.this.o4.clear();
            if (iVar.a() != null) {
                SoftAPConnectBulbActivity.this.o4.addAll(iVar.a());
            }
            if (SoftAPConnectBulbActivity.this.n4) {
                SoftAPConnectBulbActivity.this.n4 = false;
                SoftAPConnectBulbActivity.this.g4.V();
                return;
            }
            SoftAPConnectBulbActivity.this.s2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class n implements Observer<com.tplink.iot.viewmodel.quicksetup.i<InheritInfoResult>> {
        n() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable com.tplink.iot.viewmodel.quicksetup.i<InheritInfoResult> iVar) {
            boolean z = false;
            if (iVar == null || iVar.b() != 0) {
                SoftAPConnectBulbActivity.this.p4 = false;
            } else {
                InheritInfoResult a = iVar.a();
                SoftAPConnectBulbActivity softAPConnectBulbActivity = SoftAPConnectBulbActivity.this;
                if (a != null && a.isInheritStatus()) {
                    z = true;
                }
                softAPConnectBulbActivity.p4 = z;
            }
            SoftAPConnectBulbActivity.this.s2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class o implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RectF f9624c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f9625d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Canvas f9626f;
        final /* synthetic */ Paint q;

        o(RectF rectF, int i, Canvas canvas, Paint paint) {
            this.f9624c = rectF;
            this.f9625d = i;
            this.f9626f = canvas;
            this.q = paint;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RectF rectF = this.f9624c;
            int i = this.f9625d;
            int i2 = SoftAPConnectBulbActivity.this.y;
            int i3 = this.f9625d;
            rectF.top = ((i - (i / 12)) - ((i2 * i3) / 8)) - 3;
            this.f9624c.bottom = (i3 - ((SoftAPConnectBulbActivity.this.y * this.f9625d) / 8)) - 3;
            this.f9626f.drawRoundRect(this.f9624c, 8.0f, 8.0f, this.q);
            SoftAPConnectBulbActivity.this.p2.setImageBitmap(SoftAPConnectBulbActivity.this.X3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A2() {
        this.g4.v0().E(new io.reactivex.g0.g() { // from class: com.tplink.iot.view.quicksetup.bulb.c
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                SoftAPConnectBulbActivity.this.n2((Boolean) obj);
            }
        }).F0();
    }

    private void B2() {
        q<u> qVar;
        if (!com.tplink.iot.view.quicksetup.base.wifi.d.a(this) || TextUtils.isEmpty(this.l4)) {
            b.d.w.c.a.d("sendTDPBroadcast 2");
            qVar = this.g4.x0(com.tplink.iot.view.quicksetup.bulb.utils.b.l(this.c4.getDeviceModel()));
        } else {
            b.d.w.c.a.d("sendTDPBroadcast 1");
            qVar = this.g4.y0(this.l4, com.tplink.iot.view.quicksetup.bulb.utils.b.l(this.c4.getDeviceModel()));
        }
        this.h4 = qVar.G0(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C2(String str) {
        if (!this.Z3) {
            this.Z3 = true;
            io.reactivex.e0.c cVar = this.i4;
            if (cVar != null) {
                cVar.dispose();
            }
            io.reactivex.e0.c cVar2 = this.j4;
            if (cVar2 != null) {
                cVar2.dispose();
            }
            Handler handler = this.Y3;
            String str2 = null;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            QuickSetupInfoBundle quickSetupInfoBundle = this.c4;
            if (quickSetupInfoBundle != null) {
                str2 = quickSetupInfoBundle.getDeviceModel();
            }
            BulbNoFindActivity.n1(this, str2, 103);
            v.a(SoftAPConnectBulbActivity.class, BulbNoFindActivity.class, str);
        }
    }

    private void D2() {
        com.tplink.iot.view.quicksetup.bulb.utils.a.h(this, this.c4.getDeviceType(), this.c4.getDeviceModel(), "SearchDevicePage");
    }

    private void E2(int[] iArr, int i2) {
        if (iArr == null || iArr.length == 0) {
            this.p1.setVisibility(8);
            return;
        }
        if (iArr.length == 1) {
            this.p1.setVisibility(0);
            this.p1.setImageResource(iArr[0]);
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(i2);
            this.T3 = duration;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.iot.view.quicksetup.bulb.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SoftAPConnectBulbActivity.this.p2(valueAnimator);
                }
            });
            this.T3.setRepeatCount(-1);
            this.T3.setRepeatMode(2);
            this.T3.start();
            return;
        }
        this.p1.setVisibility(0);
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            drawableArr[i3] = getResources().getDrawable(iArr[i3]);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(drawableArr);
        this.p1.setImageDrawable(transitionDrawable);
        com.tplink.iot.widget.plug.b bVar = new com.tplink.iot.widget.plug.b(transitionDrawable, 1000L);
        this.U3 = bVar;
        bVar.d();
    }

    private void F2() {
        W1();
        E2(com.tplink.iot.view.quicksetup.bulb.utils.b.p(this.c4.getDeviceModel()), com.tplink.iot.view.quicksetup.bulb.utils.b.n(this.c4.getDeviceModel()));
    }

    private void G2() {
        W1();
        E2(com.tplink.iot.view.quicksetup.bulb.utils.b.q(this.c4.getDeviceModel()), 1000);
    }

    private void H2() {
        this.j4 = q.W0(120L, TimeUnit.SECONDS).l0(io.reactivex.d0.b.a.a()).G0(new e());
    }

    private void I2() {
        this.g4.Z().observe(this, new l());
        this.g4.e0().observe(this, new m());
        this.g4.W().observe(this, new n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2() {
        y.b(this.l4, null, null);
    }

    private void K2() {
        TPWifiConnectReceiver tPWifiConnectReceiver = this.d4;
        if (tPWifiConnectReceiver != null) {
            unregisterReceiver(tPWifiConnectReceiver);
            this.d4 = null;
        }
        TPWifiStateReceiver tPWifiStateReceiver = this.e4;
        if (tPWifiStateReceiver != null) {
            unregisterReceiver(tPWifiStateReceiver);
            this.e4 = null;
        }
    }

    private void V1() {
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
        ValueAnimator valueAnimator4 = this.Q3;
        if (valueAnimator4 != null) {
            valueAnimator4.removeAllUpdateListeners();
            this.Q3.cancel();
            this.Q3 = null;
        }
        ValueAnimator valueAnimator5 = this.R3;
        if (valueAnimator5 != null) {
            valueAnimator5.removeAllUpdateListeners();
            this.R3.cancel();
            this.R3 = null;
        }
        ValueAnimator valueAnimator6 = this.S3;
        if (valueAnimator6 != null) {
            valueAnimator6.removeAllUpdateListeners();
            this.S3.cancel();
            this.S3 = null;
        }
        TPRippleBackground tPRippleBackground = this.L3;
        if (tPRippleBackground != null) {
            tPRippleBackground.f();
        }
        TPRippleBackground tPRippleBackground2 = this.K3;
        if (tPRippleBackground2 != null) {
            tPRippleBackground2.f();
        }
        W1();
    }

    private void W1() {
        ValueAnimator valueAnimator = this.T3;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.T3.cancel();
            this.T3 = null;
        }
        com.tplink.iot.widget.plug.b bVar = this.U3;
        if (bVar != null) {
            bVar.b();
            this.U3 = null;
        }
    }

    private void X1() {
        b.d.w.c.a.d("checkSwitchWifiStateDoRetry");
        this.i4 = q.b0(5L, 3L, TimeUnit.SECONDS, io.reactivex.l0.a.c()).G0(new f());
    }

    private void Y1() {
        e2();
    }

    private void Z1() {
        ImageView imageView = (ImageView) findViewById(R.id.qs_phone_move);
        TPHookView tPHookView = (TPHookView) findViewById(R.id.hook_view_phone);
        this.p0.setVisibility(4);
        this.p0.setVisibility(0);
        this.p2.setVisibility(4);
        this.K3.setTranslationY(0.0f);
        ValueAnimator valueAnimator = this.R3;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.R3.cancel();
            this.R3 = null;
        }
        this.I3.setVisibility(4);
        this.J3.setVisibility(4);
        this.K3.f();
        this.L3.f();
        W1();
        this.z = false;
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 400.0f).setDuration(4000L);
        this.Q3 = duration;
        duration.setStartDelay(200L);
        this.Q3.addUpdateListener(new c(imageView, tPHookView));
        this.Q3.start();
    }

    private boolean a2() {
        if (this.b4 != 49 || this.a4) {
            return false;
        }
        this.a4 = true;
        j2();
        return true;
    }

    private void b2() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.l4 = extras.getString("bulb_ssid");
            this.c4 = (QuickSetupInfoBundle) extras.getSerializable("quick_setup_bundle");
        }
    }

    private void c2() {
        this.M3.setAlpha(1.0f);
        this.M3.setText(getString(R.string.quicksetup_scan_ap));
        F2();
        this.Y3.postDelayed(new k(), 2000L);
    }

    private void d2() {
        this.Y3.postDelayed(new d(), 30000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2() {
        int i2 = this.b4;
        if (i2 == 49) {
            this.b4 = 50;
            this.M3.setText(getString(R.string.quicksetup_no_bluetooth_found_m5));
            Z1();
            r.w(this.c4.getDeviceType(), this.c4.getDeviceModel(), this.k4);
        } else if (i2 == 51) {
            c2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f2() {
        if (a2()) {
            this.Y3.postDelayed(new j(), 2000L);
        } else {
            this.g4.Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g2() {
        SoftAPBulbSSIDEmptyActivity.n1(this, this.c4);
        r.x();
        finish();
    }

    private void h2() {
        this.Y3 = new Handler();
        this.p2 = (ImageView) findViewById(R.id.arrow_line);
        ImageView imageView = (ImageView) findViewById(R.id.qs_m5_move);
        this.p0 = imageView;
        if (imageView != null) {
            imageView.getViewTreeObserver().addOnGlobalLayoutListener(new g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2() {
        this.J3.setTranslationY(0.0f);
        this.I3.setTranslationY(0.0f);
        this.J3.setVisibility(0);
        this.I3.setVisibility(0);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 100.0f).setDuration(1000L);
        this.R3 = duration;
        duration.setStartDelay(200L);
        this.R3.addUpdateListener(new b());
        this.R3.setRepeatMode(1);
        this.R3.setRepeatCount(-1);
        this.R3.start();
    }

    private void j2() {
        ImageView imageView = this.p2;
        if (imageView != null) {
            int height = imageView.getHeight();
            this.p2.setImageResource(R.color.transparent);
            this.p2.setVisibility(0);
            this.X3 = Bitmap.createBitmap(this.p2.getWidth(), height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.X3);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setColor(ContextCompat.getColor(this, R.color.common_white));
            RectF rectF = new RectF();
            rectF.left = 0.0f;
            rectF.right = this.p2.getWidth();
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 100.0f).setDuration(80L);
            this.P3 = duration;
            duration.setStartDelay(200L);
            this.P3.addUpdateListener(new o(rectF, height, canvas, paint));
            this.P3.addListener(new a());
            this.P3.setRepeatMode(1);
            this.P3.setRepeatCount(8);
            this.P3.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2() {
        ((ImageView) findViewById(R.id.img_close)).setOnClickListener(this);
        this.p1 = (ImageView) findViewById(R.id.qs_m5_led);
        this.p3 = (ImageView) findViewById(R.id.qs_phone);
        this.H3 = (ImageView) findViewById(R.id.qs_phone_wifi);
        this.I3 = (ImageView) findViewById(R.id.image_arrow_down);
        this.J3 = (ImageView) findViewById(R.id.image_arrow_up);
        this.M3 = (TextView) findViewById(R.id.qs_tv_status);
        this.L3 = (TPRippleBackground) findViewById(R.id.qs_mobile_ripple_bg);
        this.K3 = (TPRippleBackground) findViewById(R.id.qs_m5_ripple_bg_move);
        this.p0.setImageResource(com.tplink.iot.view.quicksetup.bulb.utils.b.k(this.c4.getDeviceModel()));
        I2();
        z2();
    }

    private void l2() {
        if (this.d4 == null) {
            TPWifiConnectReceiver tPWifiConnectReceiver = new TPWifiConnectReceiver();
            this.d4 = tPWifiConnectReceiver;
            tPWifiConnectReceiver.b(new h());
            registerReceiver(this.d4, TPWifiConnectReceiver.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m2 */
    public /* synthetic */ void n2(Boolean bool) throws Exception {
        if (!this.Z3) {
            B2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o2 */
    public /* synthetic */ void p2(ValueAnimator valueAnimator) {
        this.p1.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static void q2(Context context, String str, QuickSetupInfoBundle quickSetupInfoBundle) {
        Intent intent = new Intent(context, SoftAPConnectBulbActivity.class);
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("bulb_ssid", str);
        }
        if (quickSetupInfoBundle != null) {
            bundle.putSerializable("quick_setup_bundle", quickSetupInfoBundle);
        }
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2(QuickSetupComponentResult quickSetupComponentResult) {
        if (com.tplink.iot.view.quicksetup.base.d.x(quickSetupComponentResult) <= 0) {
            b.d.w.c.a.d("parseComponentResult fail");
            y2("parse component fail");
            return;
        }
        if (this.c4 == null) {
            this.c4 = new QuickSetupInfoBundle();
        }
        this.c4.setComponentResult(quickSetupComponentResult);
        this.n4 = com.tplink.iot.view.quicksetup.bulb.utils.a.e(this.c4);
        Y1();
    }

    static /* synthetic */ int s1(SoftAPConnectBulbActivity softAPConnectBulbActivity) {
        int i2 = softAPConnectBulbActivity.y;
        softAPConnectBulbActivity.y = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s2() {
        if (!this.Z3) {
            Intent intent = new Intent(this, BulbAPListActivity.class);
            Bundle bundle = new Bundle();
            if (this.c4 == null) {
                this.c4 = new QuickSetupInfoBundle();
            }
            this.c4.setBulbSSID(this.l4);
            this.c4.setDeviceIdMD5(this.k4);
            QuickSetupInfoBundle quickSetupInfoBundle = this.c4;
            quickSetupInfoBundle.setOnBoardingType(com.tplink.iot.view.quicksetup.bulb.utils.b.t(quickSetupInfoBundle.getDeviceModel()));
            this.c4.setNeedDisplayInherit(this.p4);
            bundle.putSerializable("quick_setup_bundle", this.c4);
            if (!this.o4.isEmpty()) {
                bundle.putSerializable("ap_ssid_list", (Serializable) this.o4);
            }
            intent.putExtras(bundle);
            this.Z3 = true;
            startActivityForResult(intent, 102);
        }
    }

    private void t2() {
        c2();
    }

    private void u2() {
        this.a4 = false;
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
        this.p0.setVisibility(0);
        this.p0.setAlpha(1.0f);
        this.p3.setVisibility(0);
        this.p3.setAlpha(1.0f);
        this.H3.setVisibility(0);
        this.H3.setAlpha(1.0f);
        this.M3.setText(getString(R.string.quicksetup_looking_for_plug_new));
    }

    private void v2() {
        l2();
        if (com.tplink.libtpwifi.b.k().q(this.l4)) {
            b.d.w.c.a.d("realSearchDeviceAfterOpenWifiWithPermission 1");
            this.f4 = true;
            this.m4 = com.tplink.libtpwifi.b.k().j();
            this.b4 = 49;
            A2();
            r.y(this.l4);
            return;
        }
        b.d.w.c.a.d("realSearchDeviceAfterOpenWifiWithPermission 2");
        this.f4 = false;
        this.m4 = null;
        d2();
        y.a(this.l4, null, null);
        X1();
    }

    private void w2() {
        this.f4 = true;
        this.m4 = null;
        this.b4 = 49;
        A2();
    }

    private void x2() {
        Bitmap bitmap = this.V3;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.V3.recycle();
            this.V3 = null;
        }
        Bitmap bitmap2 = this.W3;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.W3.recycle();
            this.W3 = null;
        }
        Bitmap bitmap3 = this.X3;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.X3.recycle();
            this.X3 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2(String str) {
        int i2 = this.b4;
        if (i2 == 49 || i2 == 51) {
            C2(str);
        }
    }

    private void z2() {
        V1();
        u2();
        this.b4 = 48;
        this.K3.e();
        this.L3.e();
        G2();
        H2();
        if (!com.tplink.iot.view.quicksetup.base.wifi.d.a(this) || TextUtils.isEmpty(this.l4)) {
            b.d.w.c.a.d("searchDevice 2");
            w2();
            return;
        }
        b.d.w.c.a.d("searchDevice 1");
        v2();
    }

    @Override // android.app.Activity
    public void finish() {
        this.Z3 = true;
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != -1) {
            super.onActivityResult(i2, i3, intent);
        } else if (i2 == 102) {
            t2();
            r.n(this.c4.getDeviceType(), this.c4.getDeviceModel(), this.k4);
        } else if (i2 == 103) {
            z2();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        D2();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_close) {
            D2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.tplink.iot.core.o.a() != 0) {
            setContentView(R.layout.activity_softap_connect_bulb);
            com.tplink.iot.view.quicksetup.base.d.b0(this, R.color.common_colorAccent);
            b2();
            BulbQuickSetupViewModel bulbQuickSetupViewModel = (BulbQuickSetupViewModel) ViewModelProviders.of(this).get(BulbQuickSetupViewModel.class);
            this.g4 = bulbQuickSetupViewModel;
            bulbQuickSetupViewModel.B0(this.c4.getDeviceModel());
            h2();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.Z3 = true;
        Handler handler = this.Y3;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.Y3 = null;
        }
        x2();
        V1();
        K2();
        io.reactivex.e0.c cVar = this.h4;
        if (cVar != null) {
            cVar.dispose();
        }
        io.reactivex.e0.c cVar2 = this.j4;
        if (cVar2 != null) {
            cVar2.dispose();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.Z3 = false;
    }
}
