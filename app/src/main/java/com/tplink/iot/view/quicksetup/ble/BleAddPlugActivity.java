package com.tplink.iot.view.quicksetup.ble;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.firebase.messaging.ServiceStarter;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

/* loaded from: classes2.dex */
public class BleAddPlugActivity extends BaseActivity implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback {
    private boolean H3 = true;
    private ValueAnimator I3;
    private boolean J3;
    private boolean K3;
    private ValueAnimator L3;
    private boolean M3;
    private boolean N3;
    private TPMaterialDialogV2 O3;
    private long P3;
    private View p0;
    private ImageView p1;
    private ImageView p2;
    private String p3;
    private TPMaterialDialogV2 y;
    private View z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends com.tplink.iot.view.quicksetup.base.a {
        a() {
        }

        @Override // com.tplink.iot.view.quicksetup.base.a
        public void a(View view) {
            BleAddPlugActivity.this.w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements d0.g {
        b() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            BleAddPlugActivity.this.G1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BleAddPlugActivity.this.p1.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (BleAddPlugActivity.this.K3) {
                BleAddPlugActivity bleAddPlugActivity = BleAddPlugActivity.this;
                bleAddPlugActivity.J3 = !bleAddPlugActivity.J3;
            }
            BleAddPlugActivity.this.p1.setImageResource(BleAddPlugActivity.this.J3 ? com.tplink.iot.view.quicksetup.base.c.B(BleAddPlugActivity.this.p3) : com.tplink.iot.view.quicksetup.base.c.I(BleAddPlugActivity.this.p3));
            BleAddPlugActivity bleAddPlugActivity2 = BleAddPlugActivity.this;
            bleAddPlugActivity2.K3 = !bleAddPlugActivity2.K3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BleAddPlugActivity.this.J3 = false;
            BleAddPlugActivity.this.K3 = false;
            BleAddPlugActivity.this.p1.setImageResource(com.tplink.iot.view.quicksetup.base.c.I(BleAddPlugActivity.this.p3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BleAddPlugActivity.this.p2.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements Animator.AnimatorListener {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (BleAddPlugActivity.this.N3) {
                BleAddPlugActivity bleAddPlugActivity = BleAddPlugActivity.this;
                bleAddPlugActivity.M3 = !bleAddPlugActivity.M3;
            }
            BleAddPlugActivity.this.p2.setImageResource(BleAddPlugActivity.this.M3 ? com.tplink.iot.view.quicksetup.base.c.P(BleAddPlugActivity.this.p3) : com.tplink.iot.view.quicksetup.base.c.R(BleAddPlugActivity.this.p3));
            BleAddPlugActivity bleAddPlugActivity2 = BleAddPlugActivity.this;
            bleAddPlugActivity2.N3 = !bleAddPlugActivity2.N3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BleAddPlugActivity.this.M3 = false;
            BleAddPlugActivity.this.N3 = false;
            BleAddPlugActivity.this.p2.setImageResource(com.tplink.iot.view.quicksetup.base.c.R(BleAddPlugActivity.this.p3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BleAddPlugActivity.this.O3 != null) {
                BleAddPlugActivity.this.O3.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BleAddPlugActivity.this.O3 != null) {
                BleAddPlugActivity.this.O3.dismiss();
            }
            BleAddPlugActivity.this.D1();
        }
    }

    private void A1() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(500L);
        this.I3 = duration;
        duration.addUpdateListener(new c());
        this.I3.addListener(new d());
        this.I3.setRepeatCount(-1);
        this.I3.setRepeatMode(2);
        this.I3.start();
    }

    private void B1() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(500L);
        this.L3 = duration;
        duration.addUpdateListener(new e());
        this.L3.addListener(new f());
        this.L3.setRepeatCount(-1);
        this.L3.setRepeatMode(2);
        this.L3.start();
    }

    public static void C1(Context context, String str) {
        Intent intent = new Intent(context, BleAddPlugActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("device_model", str);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        com.tplink.iot.view.quicksetup.base.ble.d.g(this);
    }

    private void F1() {
        this.H3 = true;
        this.z.setVisibility(0);
        this.p0.setVisibility(8);
        A1();
        v1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1() {
        this.H3 = false;
        this.z.setVisibility(8);
        this.p0.setVisibility(0);
        B1();
        u1();
    }

    private void H1() {
        if (this.y == null) {
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(this);
            builder.j(getString(R.string.quicksetup_save_mode_off));
            builder.o(R.string.common_ok, R.color.common_iot_main_blue, null);
            builder.c(false);
            builder.setCancelable(false);
            builder.g(8, 8);
            this.y = builder.create();
        }
        this.y.show();
    }

    private void t1() {
        if (this.H3) {
            finish();
        } else {
            F1();
        }
    }

    private void u1() {
        ValueAnimator valueAnimator = this.I3;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.I3.cancel();
            this.I3 = null;
        }
    }

    private void v1() {
        ValueAnimator valueAnimator = this.L3;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.L3.cancel();
            this.L3 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        if (!com.tplink.iot.view.quicksetup.base.ble.d.d(this)) {
            E1();
        } else if (com.tplink.iot.view.quicksetup.base.ble.d.b(this)) {
            y1();
        } else {
            startActivityForResult(new Intent(this, LocationAllowActivity.class), ServiceStarter.ERROR_UNKNOWN);
        }
    }

    private void x1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.p3 = extras.getString("device_model");
        }
    }

    private void y1() {
        BleConnectPlugActivity.p2(this, this.p3, this.P3);
        finish();
    }

    private void z1() {
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        this.z = findViewById(R.id.layout_first);
        this.p0 = findViewById(R.id.layout_second);
        ((Button) findViewById(R.id.btn_bottom)).setOnClickListener(new a());
        ((ImageView) findViewById(R.id.img_first)).setImageResource(com.tplink.iot.view.quicksetup.base.c.F(this.p3));
        ((ImageView) findViewById(R.id.img_second)).setImageResource(com.tplink.iot.view.quicksetup.base.c.Q(this.p3));
        this.p1 = (ImageView) findViewById(R.id.img_led_first);
        this.p2 = (ImageView) findViewById(R.id.img_led_second);
        d0.h((TextView) findViewById(R.id.tv_bottom_tip), getString(R.string.quicksetup_led_not_blinking_orange_and_green), ContextCompat.getColor(this, R.color.common_iot_purple), new b());
        F1();
        if (com.tplink.iot.view.quicksetup.base.d.U(this)) {
            H1();
        }
    }

    void E1() {
        TPMaterialDialogV2 tPMaterialDialogV2 = this.O3;
        if (tPMaterialDialogV2 == null || !tPMaterialDialogV2.isShowing()) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_ble_on, (ViewGroup) null, false);
            inflate.findViewById(R.id.tv_permission_cancel).setOnClickListener(new g());
            inflate.findViewById(R.id.tv_permission_allow).setOnClickListener(new h());
            TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(this);
            builder.e(inflate);
            builder.c(false);
            builder.setCancelable(false);
            builder.g(8, 8);
            TPMaterialDialogV2 a2 = builder.create();
            this.O3 = a2;
            a2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 500 && i2 == -1) {
            y1();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        t1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_back) {
            t1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_add_plug_introduce_ble);
            x1();
            z1();
            this.P3 = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (o.a() != 0) {
            TPMaterialDialogV2 tPMaterialDialogV2 = this.y;
            if (tPMaterialDialogV2 != null) {
                tPMaterialDialogV2.dismiss();
                this.y = null;
            }
            TPMaterialDialogV2 tPMaterialDialogV22 = this.O3;
            if (tPMaterialDialogV22 != null) {
                tPMaterialDialogV22.dismiss();
                this.O3 = null;
            }
            u1();
            v1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
    }
}
