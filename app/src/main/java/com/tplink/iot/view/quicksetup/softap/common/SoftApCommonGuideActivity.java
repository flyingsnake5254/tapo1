package com.tplink.iot.view.quicksetup.softap.common;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySoftApCommonGuideBinding;
import com.tplink.iot.devices.lightstrip.view.LightStripSoftApResetHintActivity;
import com.tplink.iot.view.quicksetup.base.DeviceLocationInfo;
import com.tplink.iot.view.quicksetup.bulb.SoftAPBulbSSIDEmptyActivity;
import com.tplink.iot.view.quicksetup.bulb.SoftAPBulbSSIDListActivity;
import com.tplink.iot.view.quicksetup.bulb.SoftAPConnectBulbActivity;
import com.tplink.iot.view.quicksetup.bulb.WifiLocationAllowActivity;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpwifi.TPWifiScanReceiver;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: SoftApCommonGuideActivity.kt */
/* loaded from: classes2.dex */
public final class SoftApCommonGuideActivity extends BaseActivity implements View.OnClickListener {
    public static final a y = new a(null);
    private io.reactivex.e0.c H3;
    private io.reactivex.e0.c I3;
    private long J3;
    private ActivitySoftApCommonGuideBinding p0;
    private Integer p1;
    private Integer p2;
    private TPWifiScanReceiver p3;
    private String z;

    /* compiled from: SoftApCommonGuideActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context activity, String str) {
            j.e(activity, "activity");
            Intent intent = new Intent(activity, SoftApCommonGuideActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("device_model", str);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SoftApCommonGuideActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements g<Long> {
        b() {
        }

        /* renamed from: a */
        public final void accept(Long l) {
            long j = 5;
            if ((l.longValue() <= j && SoftApCommonGuideActivity.this.p1 != null && SoftApCommonGuideActivity.this.p2 != null && SoftApCommonGuideActivity.this.w1()) || ((l.longValue() > j && SoftApCommonGuideActivity.this.w1()) || l.longValue() == 15)) {
                b.d.w.c.a.d("handleCheckWifiScanResult aLong=" + l);
                SoftApCommonGuideActivity.this.n1();
                io.reactivex.e0.c cVar = SoftApCommonGuideActivity.this.H3;
                if (cVar != null) {
                    cVar.dispose();
                }
                io.reactivex.e0.c cVar2 = SoftApCommonGuideActivity.this.I3;
                if (cVar2 != null) {
                    cVar2.dispose();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SoftApCommonGuideActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements g<DeviceLocationInfo> {
        c() {
        }

        /* renamed from: a */
        public final void accept(DeviceLocationInfo deviceLocationInfo) {
            if (deviceLocationInfo != null && deviceLocationInfo.getLatitude() != null && deviceLocationInfo.getLongitude() != null) {
                b.d.w.c.a.d("SoftApCommonGuideActivity deviceLocationInfo latitude: " + deviceLocationInfo.getLatitude() + " longitude: " + deviceLocationInfo.getLongitude());
                SoftApCommonGuideActivity.this.p2 = deviceLocationInfo.getLatitude();
                SoftApCommonGuideActivity.this.p1 = deviceLocationInfo.getLongitude();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SoftApCommonGuideActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements d0.g {
        d() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public final void a() {
            SoftApCommonGuideActivity.this.t1();
        }
    }

    private final void A1() {
        String string = getString(com.tplink.iot.view.quicksetup.bulb.utils.b.a(this.z));
        j.d(string, "getString(SoftApOnboardi…ttomTipText(deviceModel))");
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding = this.p0;
        if (activitySoftApCommonGuideBinding == null) {
            j.t("binding");
        }
        d0.h(activitySoftApCommonGuideBinding.y, string, ContextCompat.getColor(this, R.color.common_iot_purple), new d());
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding2 = this.p0;
        if (activitySoftApCommonGuideBinding2 == null) {
            j.t("binding");
        }
        activitySoftApCommonGuideBinding2.p1.setText(com.tplink.iot.view.quicksetup.bulb.utils.b.i(this.z));
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding3 = this.p0;
        if (activitySoftApCommonGuideBinding3 == null) {
            j.t("binding");
        }
        TextView textView = activitySoftApCommonGuideBinding3.z;
        j.d(textView, "binding.tvGuideDesc");
        textView.setText(com.tplink.iot.view.quicksetup.bulb.utils.b.d(this.z));
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding4 = this.p0;
        if (activitySoftApCommonGuideBinding4 == null) {
            j.t("binding");
        }
        TextView textView2 = activitySoftApCommonGuideBinding4.p0;
        j.d(textView2, "binding.tvGuideTips");
        textView2.setText(com.tplink.iot.view.quicksetup.bulb.utils.b.h(this.z));
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding5 = this.p0;
        if (activitySoftApCommonGuideBinding5 == null) {
            j.t("binding");
        }
        activitySoftApCommonGuideBinding5.f6693c.setText(getString(com.tplink.iot.view.quicksetup.bulb.utils.b.b(this.z)));
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding6 = this.p0;
        if (activitySoftApCommonGuideBinding6 == null) {
            j.t("binding");
        }
        activitySoftApCommonGuideBinding6.f6695f.setImageResource(com.tplink.iot.view.quicksetup.bulb.utils.b.c(this.z));
        F1();
    }

    private final void B1() {
        if (this.p3 == null) {
            TPWifiScanReceiver tPWifiScanReceiver = new TPWifiScanReceiver();
            this.p3 = tPWifiScanReceiver;
            registerReceiver(tPWifiScanReceiver, TPWifiScanReceiver.b());
        }
    }

    private final boolean C1() {
        return o.h0().c("has_refused_location_permission", false);
    }

    public static final void D1(Context context, String str) {
        y.a(context, str);
    }

    private final void E1() {
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding = this.p0;
        if (activitySoftApCommonGuideBinding == null) {
            j.t("binding");
        }
        LottieAnimationView it = activitySoftApCommonGuideBinding.x;
        j.d(it, "it");
        if ((it.getVisibility() == 0) && !it.m()) {
            it.q();
        }
    }

    private final void F1() {
        if (com.tplink.iot.g.b.c.c.j(this.z)) {
            ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding = this.p0;
            if (activitySoftApCommonGuideBinding == null) {
                j.t("binding");
            }
            ImageView imageView = activitySoftApCommonGuideBinding.f6695f;
            j.d(imageView, "binding.imageCheckLed");
            imageView.setVisibility(8);
            try {
                ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding2 = this.p0;
                if (activitySoftApCommonGuideBinding2 == null) {
                    j.t("binding");
                }
                LottieAnimationView lottieAnimationView = activitySoftApCommonGuideBinding2.x;
                lottieAnimationView.g();
                lottieAnimationView.setAnimation(R.raw.light_strip_marquee_ap_mode);
                lottieAnimationView.setProgress(0.0f);
                lottieAnimationView.o();
                lottieAnimationView.setVisibility(0);
            } catch (Exception unused) {
                b.d.w.c.a.e("Lottie", "Load local json lottie anim error.");
            }
        }
    }

    private final void G1() {
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding = this.p0;
        if (activitySoftApCommonGuideBinding == null) {
            j.t("binding");
        }
        ImageView imageView = activitySoftApCommonGuideBinding.f6695f;
        j.d(imageView, "binding.imageCheckLed");
        Drawable drawable = imageView.getDrawable();
        j.d(drawable, "binding.imageCheckLed.drawable");
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        H1(false);
    }

    private final void H1(boolean z) {
        if (z) {
            ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding = this.p0;
            if (activitySoftApCommonGuideBinding == null) {
                j.t("binding");
            }
            activitySoftApCommonGuideBinding.x.g();
            return;
        }
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding2 = this.p0;
        if (activitySoftApCommonGuideBinding2 == null) {
            j.t("binding");
        }
        activitySoftApCommonGuideBinding2.x.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1() {
        if (!com.tplink.iot.view.quicksetup.base.wifi.d.a(this)) {
            b.d.w.c.a.d("checkWifiScanResult is not AllWiFiPrepared");
            p1();
            return;
        }
        String p = com.tplink.iot.view.quicksetup.base.d.p();
        if (com.tplink.iot.view.quicksetup.base.d.R(p, this.z)) {
            b.d.w.c.a.d("checkWifiScanResult currentSSID isDeviceSSID");
            q1(p);
            return;
        }
        TPWifiScanReceiver tPWifiScanReceiver = this.p3;
        if (tPWifiScanReceiver == null) {
            b.d.w.c.a.d("checkWifiScanResult tpWifiScanReceiver = null");
            p1();
            return;
        }
        List<ScanResult> a2 = tPWifiScanReceiver != null ? tPWifiScanReceiver.a() : null;
        if (a2 == null || a2.isEmpty()) {
            b.d.w.c.a.d("checkWifiScanResult scanResultList == null || scanResultList.isEmpty()");
            p1();
            return;
        }
        List<ScanResult> z = com.tplink.iot.view.quicksetup.base.d.z(a2, this.z);
        if (z == null || z.isEmpty()) {
            b.d.w.c.a.d("checkWifiScanResult split == null || split.isEmpty()");
            p1();
        } else if (z.size() == 1) {
            b.d.w.c.a.d("checkWifiScanResult splitScanResultList.size() == 1");
            q1(z.get(0).SSID);
        } else {
            b.d.w.c.a.d("checkWifiScanResult gotoBulbSSIDList");
            s1(z);
        }
    }

    private final void o1() {
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding = this.p0;
        if (activitySoftApCommonGuideBinding == null) {
            j.t("binding");
        }
        activitySoftApCommonGuideBinding.f6693c.h();
        if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this)) {
            b.d.w.c.a.d("isAllWiFiPrepared startScan");
            r1();
        } else if (C1()) {
            b.d.w.c.a.d("HasDenyLocationPermission gotoBulbSSIDListEmpty");
            p1();
        } else {
            b.d.w.c.a.d("gotoWifiLocationAllowActivity");
            u1();
        }
    }

    private final void p1() {
        SoftAPBulbSSIDEmptyActivity.n1(this, new QuickSetupInfoBundle(this.p1, this.p2, this.z, this.J3));
    }

    private final void q1(String str) {
        SoftAPConnectBulbActivity.q2(this, str, new QuickSetupInfoBundle(this.p1, this.p2, this.z, this.J3));
    }

    private final void r1() {
        z1();
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding = this.p0;
        if (activitySoftApCommonGuideBinding == null) {
            j.t("binding");
        }
        activitySoftApCommonGuideBinding.f6693c.g();
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding2 = this.p0;
        if (activitySoftApCommonGuideBinding2 == null) {
            j.t("binding");
        }
        TextView textView = activitySoftApCommonGuideBinding2.y;
        j.d(textView, "binding.tvBottomTip");
        textView.setEnabled(false);
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding3 = this.p0;
        if (activitySoftApCommonGuideBinding3 == null) {
            j.t("binding");
        }
        TextView textView2 = activitySoftApCommonGuideBinding3.y;
        j.d(textView2, "binding.tvBottomTip");
        textView2.setAlpha(0.5f);
        com.tplink.libtpwifi.b.k().s();
        v1();
    }

    private final void s1(List<ScanResult> list) {
        Intent intent = new Intent(this, SoftAPBulbSSIDListActivity.class);
        if (list != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("bulb_ssid_list", (Serializable) list);
            bundle.putSerializable("quick_setup_bundle", new QuickSetupInfoBundle(this.p1, this.p2, this.z, this.J3));
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1() {
        if (this.z == null || !com.tplink.iot.view.quicksetup.base.b.d().contains(this.z)) {
            SoftApResetHintActivity.y.a(this, this.z);
        } else {
            LightStripSoftApResetHintActivity.p0.a(this, this.z);
        }
    }

    private final void u1() {
        WifiLocationAllowActivity.p1(this, new QuickSetupInfoBundle(this.p1, this.p2, this.z, this.J3));
    }

    private final void v1() {
        this.I3 = q.d0(1L, 15L, 1L, 1L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w1() {
        TPWifiScanReceiver tPWifiScanReceiver;
        List<ScanResult> a2;
        if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this) && (tPWifiScanReceiver = this.p3) != null && (a2 = tPWifiScanReceiver.a()) != null && !a2.isEmpty()) {
            TPWifiScanReceiver tPWifiScanReceiver2 = this.p3;
            List<ScanResult> z = com.tplink.iot.view.quicksetup.base.d.z(tPWifiScanReceiver2 != null ? tPWifiScanReceiver2.a() : null, this.z);
            j.d(z, "QuickSetupUtils.getSplit…nResultList, deviceModel)");
            if (!z.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private final void x1() {
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding = this.p0;
        if (activitySoftApCommonGuideBinding == null) {
            j.t("binding");
        }
        ImageView imageView = activitySoftApCommonGuideBinding.f6695f;
        j.d(imageView, "binding.imageCheckLed");
        Drawable drawable = imageView.getDrawable();
        j.d(drawable, "binding.imageCheckLed.drawable");
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    private final void y1() {
        this.z = getIntent().getStringExtra("device_model");
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding = this.p0;
        if (activitySoftApCommonGuideBinding == null) {
            j.t("binding");
        }
        activitySoftApCommonGuideBinding.h(this);
    }

    private final void z1() {
        this.H3 = com.tplink.iot.view.quicksetup.base.f.c.h().g(5000L).E(new c()).F0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 500 && i2 == -1) {
            r1();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.img_back) {
            onBackPressed();
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_refresh_next) {
            o1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_soft_ap_common_guide);
        j.d(contentView, "DataBindingUtil.setConte…ity_soft_ap_common_guide)");
        this.p0 = (ActivitySoftApCommonGuideBinding) contentView;
        y1();
        A1();
        B1();
        this.J3 = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (com.tplink.iot.core.o.a() != 0) {
            TPWifiScanReceiver tPWifiScanReceiver = this.p3;
            if (tPWifiScanReceiver != null) {
                unregisterReceiver(tPWifiScanReceiver);
            }
            H1(true);
            super.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        x1();
        E1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        G1();
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding = this.p0;
        if (activitySoftApCommonGuideBinding == null) {
            j.t("binding");
        }
        activitySoftApCommonGuideBinding.f6693c.h();
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding2 = this.p0;
        if (activitySoftApCommonGuideBinding2 == null) {
            j.t("binding");
        }
        TextView textView = activitySoftApCommonGuideBinding2.y;
        j.d(textView, "binding.tvBottomTip");
        textView.setEnabled(true);
        ActivitySoftApCommonGuideBinding activitySoftApCommonGuideBinding3 = this.p0;
        if (activitySoftApCommonGuideBinding3 == null) {
            j.t("binding");
        }
        TextView textView2 = activitySoftApCommonGuideBinding3.y;
        j.d(textView2, "binding.tvBottomTip");
        textView2.setAlpha(1.0f);
        io.reactivex.e0.c cVar = this.H3;
        if (cVar != null) {
            cVar.dispose();
        }
        io.reactivex.e0.c cVar2 = this.I3;
        if (cVar2 != null) {
            cVar2.dispose();
        }
        super.onStop();
    }
}
