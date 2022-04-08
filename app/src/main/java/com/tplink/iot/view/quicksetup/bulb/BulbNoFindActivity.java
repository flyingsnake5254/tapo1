package com.tplink.iot.view.quicksetup.bulb;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.extension.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.devicecommon.feature.AnimationDrawableImageViewFeature;
import com.tplink.iot.devicecommon.feature.LottieAnimationViewFeature;
import com.tplink.iot.g.b.c.c;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.widget.OrderTextView;
import com.tplink.iot.widget.PointTextView;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

/* loaded from: classes2.dex */
public class BulbNoFindActivity extends BaseActivity implements View.OnClickListener {
    private String p0;
    private View p1;
    private ValueAnimator y;
    private AnimationDrawable z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: c  reason: collision with root package name */
        private boolean f9593c = false;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ImageView f9594d;

        a(ImageView imageView) {
            this.f9594d = imageView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            boolean z = !this.f9593c;
            this.f9593c = z;
            this.f9594d.setImageResource(z ? R.mipmap.bulb_configuration_on : R.mipmap.bulb_configuration_off);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumDeviceType.values().length];
            a = iArr;
            try {
                iArr[EnumDeviceType.BULB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumDeviceType.PLUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumDeviceType.HUB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void e1() {
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.y.removeAllListeners();
            this.y = null;
        }
        AnimationDrawable animationDrawable = this.z;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    private String f1(String str) {
        if ("L530".equals(str)) {
            return getResources().getString(R.string.model_bulb_l530);
        }
        if ("L520".equals(str)) {
            return getResources().getString(R.string.model_bulb_l520);
        }
        if ("L510".equals(str)) {
            return getResources().getString(R.string.model_bulb_l510);
        }
        if ("P110".equals(str)) {
            return getResources().getString(R.string.model_plug_p110);
        }
        if ("H100".equals(str)) {
            return getResources().getString(R.string.model_hub_h100);
        }
        if ("L900".equals(str)) {
            return getResources().getString(R.string.model_light_strip_l900);
        }
        if ("L920".equals(str)) {
            return getResources().getString(R.string.model_light_strip_l920);
        }
        return "L930".equals(str) ? getResources().getString(R.string.model_light_strip_l930) : str;
    }

    private void g1() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.p0 = extras.getString("device_model");
        }
    }

    private void h1() {
        ImageView imageView = (ImageView) this.p1.findViewById(R.id.iv_bulb_reset);
        if (imageView != null) {
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(1000L);
            this.y = duration;
            duration.addListener(new a(imageView));
            this.y.setRepeatCount(-1);
            this.y.setRepeatMode(1);
            this.y.start();
        }
    }

    private void i1() {
        h.a(this.p1.findViewById(R.id.tv_reset_hint), getString(R.string.onboarding_reset_hub_hint_V3, new Object[]{5}));
        ImageView imageView = (ImageView) this.p1.findViewById(R.id.iv_reset);
        if (imageView != null) {
            AnimationDrawableImageViewFeature.a(this, imageView);
        }
    }

    private void j1() {
        OrderTextView orderTextView = (OrderTextView) this.p1.findViewById(R.id.tv_reset_hint);
        if (orderTextView != null) {
            int i = R.string.light_strip_obd_reset_hint_l900;
            if (c.j(this.p0)) {
                i = R.string.light_strip_obd_reset_hint_l920;
            }
            orderTextView.setContent(getString(i));
        }
        ImageView imageView = (ImageView) this.p1.findViewById(R.id.iv_bulb_reset);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.p1.findViewById(R.id.lottie_light_strip_reset);
        if (c.g(this.p0)) {
            if (imageView != null && (imageView.getDrawable() instanceof AnimationDrawable)) {
                AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
                this.z = animationDrawable;
                animationDrawable.start();
            }
        } else if (c.j(this.p0) && imageView != null && lottieAnimationView != null) {
            imageView.setVisibility(8);
            LottieAnimationViewFeature.b(this, lottieAnimationView, R.raw.light_strip_marquee_reset);
        }
    }

    private void k1() {
        if (!TextUtils.isEmpty(this.p0)) {
            View findViewById = this.p1.findViewById(R.id.tv_reset_hint);
            if (this.p0.startsWith("P115")) {
                h.a(findViewById, getString(R.string.quicksetup_first_introduce_content_help_blink_not_pink_and_blue_do));
            }
        }
    }

    private void l1() {
        int i = b.a[com.tplink.iot.view.quicksetup.bulb.utils.b.l(this.p0).ordinal()];
        if (i != 1) {
            if (i == 2) {
                k1();
            } else if (i == 3) {
                i1();
            }
        } else if (c.i(this.p0)) {
            j1();
        } else {
            h1();
        }
    }

    private void m1() {
        d.c0(this, (TextView) findViewById(R.id.tv_contact_us), f1(this.p0));
        Button button = (Button) findViewById(R.id.btn_bottom);
        button.setText(getString(R.string.try_again));
        button.setOnClickListener(this);
        ((ImageView) findViewById(R.id.img_close)).setOnClickListener(this);
        ViewStub viewStub = (ViewStub) findViewById(R.id.softap_no_find_tips_container);
        viewStub.setLayoutResource(com.tplink.iot.view.quicksetup.bulb.utils.b.r(this.p0));
        View inflate = viewStub.inflate();
        this.p1 = inflate;
        View findViewById = inflate.findViewById(R.id.tv_device_network_content);
        if (findViewById != null) {
            String v = com.tplink.iot.view.quicksetup.bulb.utils.b.v(this.p0);
            String string = getString(R.string.qs_connect_device_network_content_check, new Object[]{v});
            if (findViewById instanceof TextView) {
                d0.a((TextView) findViewById, string, v, ContextCompat.getColor(this, R.color.common_iot_purple));
            } else if (findViewById instanceof PointTextView) {
                d0.b((PointTextView) findViewById, string, v, ContextCompat.getColor(this, R.color.common_iot_purple));
            }
        }
        l1();
    }

    public static void n1(Activity activity, String str, int i) {
        Intent intent = new Intent(activity, BulbNoFindActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("device_model", str);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i);
    }

    private void o1() {
        e1();
        com.tplink.iot.view.quicksetup.bulb.utils.a.h(this, com.tplink.iot.view.quicksetup.bulb.utils.b.l(this.p0).getDeviceType(), this.p0, "NotFindDevicePage");
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        o1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            setResult(-1);
            finish();
        } else if (id == R.id.img_close) {
            o1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_softap_bulb_no_find);
            g1();
            m1();
        }
    }
}
