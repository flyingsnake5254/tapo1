package com.tplink.iot.devices.lightstrip.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ActivityLightStripSoftApResetHintBinding;
import com.tplink.iot.devicecommon.feature.LottieAnimationViewFeature;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.g.b.c.c;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: LightStripSoftApResetHintActivity.kt */
/* loaded from: classes2.dex */
public final class LightStripSoftApResetHintActivity extends IoTMVVMBaseActivity<ActivityLightStripSoftApResetHintBinding> {
    public static final a p0 = new a(null);
    private String p1;

    /* compiled from: LightStripSoftApResetHintActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context context, String str) {
            j.e(context, "context");
            Intent intent = new Intent(context, LightStripSoftApResetHintActivity.class);
            intent.putExtra("DeviceModel", str);
            context.startActivity(intent);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final void n1() {
        Intent intent = getIntent();
        this.p1 = intent != null ? intent.getStringExtra("DeviceModel") : null;
    }

    private final void o1() {
        f1().q.setText(R.string.light_strip_obd_reset_hint_l920);
        ImageView imageView = f1().f6600d;
        imageView.setImageResource(0);
        imageView.setVisibility(8);
        LottieAnimationViewFeature.a aVar = LottieAnimationViewFeature.f7383c;
        LottieAnimationView lottieAnimationView = f1().f6601f;
        j.d(lottieAnimationView, "mBinding.lottieAnimationView");
        aVar.a(this, lottieAnimationView, R.raw.light_strip_marquee_reset);
    }

    private final void p1() {
        ImageView imageView = f1().f6600d;
        j.d(imageView, "mBinding.ivReset");
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    private final void q1() {
        ImageView imageView = f1().f6600d;
        j.d(imageView, "mBinding.ivReset");
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public int e1() {
        return R.layout.activity_light_strip_soft_ap_reset_hint;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        n1();
        if (c.j(this.p1)) {
            o1();
        }
        p1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        p1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        q1();
        super.onStop();
    }
}
