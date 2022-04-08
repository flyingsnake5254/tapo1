package com.tplink.iot.view.quicksetup.plug;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.extension.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.base.DeviceLocationInfo;
import com.tplink.iot.view.quicksetup.bulb.SoftAPBulbSSIDEmptyActivity;
import com.tplink.iot.view.quicksetup.bulb.SoftAPBulbSSIDListActivity;
import com.tplink.iot.view.quicksetup.bulb.SoftAPConnectBulbActivity;
import com.tplink.iot.view.quicksetup.bulb.WifiLocationAllowActivity;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpwifi.TPWifiScanReceiver;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.text.v;

/* compiled from: SoftApPlugGuideActivity.kt */
/* loaded from: classes2.dex */
public final class SoftApPlugGuideActivity extends BaseActivity implements View.OnClickListener {
    public static final a y = new a(null);
    private TextView H3;
    private TextView I3;
    private String J3 = "";
    private boolean K3 = true;
    private com.tplink.iot.widget.plug.a L3;
    private com.tplink.iot.widget.plug.a M3;
    private TPMaterialDialogV2 N3;
    private Integer O3;
    private Integer P3;
    private io.reactivex.e0.c Q3;
    private io.reactivex.e0.c R3;
    private TPWifiScanReceiver S3;
    private long T3;
    private View p0;
    private ImageView p1;
    private ImageView p2;
    private TPRefreshableButton p3;
    private View z;

    /* compiled from: SoftApPlugGuideActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context activity, String str) {
            j.e(activity, "activity");
            Intent intent = new Intent(activity, SoftApPlugGuideActivity.class);
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
    /* compiled from: SoftApPlugGuideActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements g<Long> {
        b() {
        }

        /* renamed from: a */
        public final void accept(Long l) {
            long j = 5;
            if ((l.longValue() <= j && SoftApPlugGuideActivity.this.O3 != null && SoftApPlugGuideActivity.this.P3 != null && SoftApPlugGuideActivity.this.z1()) || ((l.longValue() > j && SoftApPlugGuideActivity.this.z1()) || l.longValue() == 15)) {
                b.d.w.c.a.d("handleCheckWifiScanResult aLong=" + l);
                SoftApPlugGuideActivity.this.q1();
                io.reactivex.e0.c cVar = SoftApPlugGuideActivity.this.Q3;
                if (cVar != null) {
                    cVar.dispose();
                }
                io.reactivex.e0.c cVar2 = SoftApPlugGuideActivity.this.R3;
                if (cVar2 != null) {
                    cVar2.dispose();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SoftApPlugGuideActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements g<DeviceLocationInfo> {
        c() {
        }

        /* renamed from: a */
        public final void accept(DeviceLocationInfo deviceLocationInfo) {
            if (deviceLocationInfo != null && deviceLocationInfo.getLatitude() != null && deviceLocationInfo.getLongitude() != null) {
                b.d.w.c.a.d("SoftApCommonGuideActivity deviceLocationInfo latitude: " + deviceLocationInfo.getLatitude() + " longitude: " + deviceLocationInfo.getLongitude());
                SoftApPlugGuideActivity.this.P3 = deviceLocationInfo.getLatitude();
                SoftApPlugGuideActivity.this.O3 = deviceLocationInfo.getLongitude();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SoftApPlugGuideActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements d0.g {
        d() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public final void a() {
            SoftApPlugGuideActivity.this.J1();
        }
    }

    private final void A1() {
        Drawable[] drawableArr = new Drawable[2];
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), com.tplink.iot.view.quicksetup.base.c.I(this.J3), null);
        if (drawable != null) {
            j.d(drawable, "ResourcesCompat.getDrawa…ceModel), null) ?: return");
            drawableArr[0] = drawable;
            Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), com.tplink.iot.view.quicksetup.base.c.B(this.J3), null);
            if (drawable2 != null) {
                j.d(drawable2, "ResourcesCompat.getDrawa…ceModel), null) ?: return");
                drawableArr[1] = drawable2;
                com.tplink.iot.widget.plug.a aVar = new com.tplink.iot.widget.plug.a(drawableArr, 1000L);
                ImageView imageView = this.p1;
                if (imageView == null) {
                    j.t("imgLedFirst");
                }
                aVar.a(imageView);
                aVar.c();
                p pVar = p.a;
                this.L3 = aVar;
            }
        }
    }

    private final void B1() {
        this.Q3 = com.tplink.iot.view.quicksetup.base.f.c.h().g(5000L).E(new c()).F0();
    }

    private final void C1() {
        Drawable[] drawableArr = new Drawable[2];
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), com.tplink.iot.view.quicksetup.base.c.R(this.J3), null);
        if (drawable != null) {
            j.d(drawable, "ResourcesCompat.getDrawa…ceModel), null) ?: return");
            drawableArr[0] = drawable;
            Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), com.tplink.iot.view.quicksetup.base.c.P(this.J3), null);
            if (drawable2 != null) {
                j.d(drawable2, "ResourcesCompat.getDrawa…ceModel), null) ?: return");
                drawableArr[1] = drawable2;
                com.tplink.iot.widget.plug.a aVar = new com.tplink.iot.widget.plug.a(drawableArr, 1000L);
                ImageView imageView = this.p2;
                if (imageView == null) {
                    j.t("imgLedSecond");
                }
                aVar.a(imageView);
                aVar.c();
                p pVar = p.a;
                this.M3 = aVar;
            }
        }
    }

    private final void D1() {
        View findViewById = findViewById(R.id.layout_first);
        j.d(findViewById, "findViewById(R.id.layout_first)");
        this.z = findViewById;
        View findViewById2 = findViewById(R.id.layout_second);
        j.d(findViewById2, "findViewById(R.id.layout_second)");
        this.p0 = findViewById2;
        View findViewById3 = findViewById(R.id.img_led_first);
        j.d(findViewById3, "findViewById(R.id.img_led_first)");
        this.p1 = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.img_led_second);
        j.d(findViewById4, "findViewById(R.id.img_led_second)");
        this.p2 = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.quicksetup_introduce_commmon_refresh_next);
        j.d(findViewById5, "findViewById(R.id.quicks…uce_commmon_refresh_next)");
        this.p3 = (TPRefreshableButton) findViewById5;
        View findViewById6 = findViewById(R.id.tv_power_up_hint);
        j.d(findViewById6, "findViewById(R.id.tv_power_up_hint)");
        this.I3 = (TextView) findViewById6;
        TPRefreshableButton tPRefreshableButton = this.p3;
        if (tPRefreshableButton == null) {
            j.t("btnRefreshNext");
        }
        tPRefreshableButton.setOnClickListener(this);
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.img_first)).setImageResource(com.tplink.iot.view.quicksetup.base.c.F(this.J3));
        ((ImageView) findViewById(R.id.img_second)).setImageResource(com.tplink.iot.view.quicksetup.base.c.Q(this.J3));
        H1();
        View findViewById7 = findViewById(R.id.tv_bottom_tip);
        j.d(findViewById7, "findViewById(R.id.tv_bottom_tip)");
        TextView textView = (TextView) findViewById7;
        this.H3 = textView;
        if (textView == null) {
            j.t("tvBottomTip");
        }
        d0.h(textView, getString(com.tplink.iot.view.quicksetup.bulb.utils.b.a(this.J3)), ContextCompat.getColor(this, R.color.common_iot_purple), new d());
        I1();
        if (com.tplink.iot.view.quicksetup.base.d.U(this)) {
            K1();
        }
    }

    private final void E1() {
        if (this.S3 == null) {
            TPWifiScanReceiver tPWifiScanReceiver = new TPWifiScanReceiver();
            this.S3 = tPWifiScanReceiver;
            registerReceiver(tPWifiScanReceiver, TPWifiScanReceiver.b());
        }
    }

    private final boolean F1() {
        return o.h0().c("has_refused_location_permission", false);
    }

    public static final void G1(Context context, String str) {
        y.a(context, str);
    }

    private final void H1() {
        boolean A;
        A = v.A(this.J3, "P115", false, 2, null);
        if (A) {
            TextView textView = this.I3;
            if (textView == null) {
                j.t("tvPowerUpHint");
            }
            textView.setText(R.string.quicksetup_first_introduce_content_pink_and_blue);
            TPRefreshableButton tPRefreshableButton = this.p3;
            if (tPRefreshableButton == null) {
                j.t("btnRefreshNext");
            }
            tPRefreshableButton.setText(getString(R.string.quicksetup_first_introduce_btn_pink_and_blue));
            h.a(findViewById(R.id.tv_led_blinking), getString(R.string.quicksetup_first_introduce_content_help_blink_blue));
            h.a(findViewById(R.id.tv_led_blinking_hint), getString(R.string.quicksetup_first_introduce_content_help_blink_pink_and_blue_do));
            h.a(findViewById(R.id.tv_led_not_blinking), getString(R.string.quicksetup_first_introduce_content_help_blink_not_blue));
            h.a(findViewById(R.id.tv_led_not_blinking_hint), getString(R.string.quicksetup_first_introduce_content_help_blink_not_pink_and_blue_do));
        }
    }

    private final void I1() {
        this.K3 = true;
        View view = this.z;
        if (view == null) {
            j.t("layoutFirst");
        }
        view.setVisibility(0);
        View view2 = this.p0;
        if (view2 == null) {
            j.t("layoutSecond");
        }
        view2.setVisibility(8);
        A1();
        p1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1() {
        this.K3 = false;
        View view = this.z;
        if (view == null) {
            j.t("layoutFirst");
        }
        view.setVisibility(8);
        View view2 = this.p0;
        if (view2 == null) {
            j.t("layoutSecond");
        }
        view2.setVisibility(0);
        C1();
        o1();
    }

    private final void K1() {
        if (this.N3 == null) {
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(this);
            builder.j(getString(R.string.quicksetup_save_mode_off));
            builder.o(R.string.common_ok, R.color.common_iot_main_blue, null);
            builder.c(false);
            builder.setCancelable(false);
            builder.g(8, 8);
            p pVar = p.a;
            this.N3 = builder.create();
        }
        TPMaterialDialogV2 tPMaterialDialogV2 = this.N3;
        if (tPMaterialDialogV2 != null) {
            tPMaterialDialogV2.show();
        }
    }

    private final void n1() {
        if (this.K3) {
            finish();
        } else {
            I1();
        }
    }

    private final void o1() {
        com.tplink.iot.widget.plug.a aVar = this.L3;
        if (aVar != null) {
            aVar.b();
            this.L3 = null;
        }
    }

    private final void p1() {
        com.tplink.iot.widget.plug.a aVar = this.M3;
        if (aVar != null) {
            aVar.b();
            this.M3 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1() {
        if (!com.tplink.iot.view.quicksetup.base.wifi.d.a(this)) {
            b.d.w.c.a.d("checkWifiScanResult is not AllWiFiPrepared");
            t1();
            return;
        }
        String p = com.tplink.iot.view.quicksetup.base.d.p();
        if (com.tplink.iot.view.quicksetup.base.d.T(p)) {
            b.d.w.c.a.d("checkWifiScanResult currentSSID isPlugSSID");
            u1(p);
            return;
        }
        TPWifiScanReceiver tPWifiScanReceiver = this.S3;
        if (tPWifiScanReceiver == null) {
            b.d.w.c.a.d("checkWifiScanResult tpWifiScanReceiver = null");
            t1();
            return;
        }
        List<ScanResult> a2 = tPWifiScanReceiver != null ? tPWifiScanReceiver.a() : null;
        if (a2 == null || a2.isEmpty()) {
            b.d.w.c.a.d("checkWifiScanResult scanResultList == null || scanResultList.isEmpty()");
            t1();
            return;
        }
        List<ScanResult> y2 = com.tplink.iot.view.quicksetup.base.d.y(a2, EnumDeviceType.PLUG, this.J3);
        if (y2 == null || y2.isEmpty()) {
            b.d.w.c.a.d("checkWifiScanResult split == null || split.isEmpty()");
            t1();
        } else if (y2.size() == 1) {
            b.d.w.c.a.d("checkWifiScanResult splitScanResultList.size() == 1");
            u1(y2.get(0).SSID);
        } else {
            b.d.w.c.a.d("checkWifiScanResult gotoBulbSSIDList");
            w1(y2);
        }
    }

    private final void r1() {
        TPRefreshableButton tPRefreshableButton = this.p3;
        if (tPRefreshableButton == null) {
            j.t("btnRefreshNext");
        }
        tPRefreshableButton.h();
        if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this)) {
            b.d.w.c.a.d("isAllWiFiPrepared startScan");
            v1();
        } else if (F1()) {
            b.d.w.c.a.d("HasDenyLocationPermission gotoBulbSSIDListEmpty");
            t1();
        } else {
            b.d.w.c.a.d("gotoWifiLocationAllowActivity");
            x1();
        }
    }

    private final void s1() {
        String str;
        Bundle extras;
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null || (str = extras.getString("device_model")) == null) {
            str = "";
        }
        this.J3 = str;
    }

    private final void t1() {
        SoftAPBulbSSIDEmptyActivity.n1(this, new QuickSetupInfoBundle(this.O3, this.P3, this.J3, this.T3));
    }

    private final void u1(String str) {
        SoftAPConnectBulbActivity.q2(this, str, new QuickSetupInfoBundle(this.O3, this.P3, this.J3, this.T3));
    }

    private final void v1() {
        B1();
        TPRefreshableButton tPRefreshableButton = this.p3;
        if (tPRefreshableButton == null) {
            j.t("btnRefreshNext");
        }
        tPRefreshableButton.g();
        TextView textView = this.H3;
        if (textView == null) {
            j.t("tvBottomTip");
        }
        textView.setEnabled(false);
        TextView textView2 = this.H3;
        if (textView2 == null) {
            j.t("tvBottomTip");
        }
        textView2.setAlpha(0.5f);
        com.tplink.libtpwifi.b.k().s();
        y1();
    }

    private final void w1(List<ScanResult> list) {
        Intent intent = new Intent(this, SoftAPBulbSSIDListActivity.class);
        if (list != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("bulb_ssid_list", (Serializable) list);
            bundle.putSerializable("quick_setup_bundle", new QuickSetupInfoBundle(this.O3, this.P3, this.J3, this.T3));
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    private final void x1() {
        WifiLocationAllowActivity.p1(this, new QuickSetupInfoBundle(this.O3, this.P3, this.J3, this.T3));
    }

    private final void y1() {
        this.R3 = q.d0(1L, 15L, 1L, 1L, TimeUnit.SECONDS).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).G0(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z1() {
        TPWifiScanReceiver tPWifiScanReceiver;
        List<ScanResult> a2;
        if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this) && (tPWifiScanReceiver = this.S3) != null && (a2 = tPWifiScanReceiver.a()) != null && !a2.isEmpty()) {
            TPWifiScanReceiver tPWifiScanReceiver2 = this.S3;
            List<ScanResult> y2 = com.tplink.iot.view.quicksetup.base.d.y(tPWifiScanReceiver2 != null ? tPWifiScanReceiver2.a() : null, EnumDeviceType.PLUG, this.J3);
            j.d(y2, "QuickSetupUtils.getSplit…ceType.PLUG, deviceModel)");
            if (!y2.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 500 && i2 == -1) {
            v1();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        n1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        j.e(v, "v");
        int id = v.getId();
        if (id == R.id.img_back) {
            n1();
        } else if (id == R.id.quicksetup_introduce_commmon_refresh_next) {
            r1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.tplink.iot.core.o.a() != 0) {
            setContentView(R.layout.activity_softap_plug_guide);
            s1();
            D1();
            E1();
            this.T3 = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (com.tplink.iot.core.o.a() != 0) {
            TPMaterialDialogV2 tPMaterialDialogV2 = this.N3;
            if (tPMaterialDialogV2 != null) {
                tPMaterialDialogV2.dismiss();
                this.N3 = null;
            }
            TPWifiScanReceiver tPWifiScanReceiver = this.S3;
            if (tPWifiScanReceiver != null) {
                unregisterReceiver(tPWifiScanReceiver);
            }
            o1();
            p1();
            io.reactivex.e0.c cVar = this.Q3;
            if (cVar != null) {
                cVar.dispose();
            }
            io.reactivex.e0.c cVar2 = this.R3;
            if (cVar2 != null) {
                cVar2.dispose();
            }
            super.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onSaveInstanceState(Bundle outState) {
        j.e(outState, "outState");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        TPRefreshableButton tPRefreshableButton = this.p3;
        if (tPRefreshableButton == null) {
            j.t("btnRefreshNext");
        }
        tPRefreshableButton.h();
        TextView textView = this.H3;
        if (textView == null) {
            j.t("tvBottomTip");
        }
        textView.setEnabled(true);
        TextView textView2 = this.H3;
        if (textView2 == null) {
            j.t("tvBottomTip");
        }
        textView2.setAlpha(1.0f);
        io.reactivex.e0.c cVar = this.Q3;
        if (cVar != null) {
            cVar.dispose();
        }
        io.reactivex.e0.c cVar2 = this.R3;
        if (cVar2 != null) {
            cVar2.dispose();
        }
        super.onStop();
    }
}
