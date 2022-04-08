package com.tplink.iot.view.quicksetup.lightstrip;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLightStripConnectPartsGuideBinding;
import com.tplink.iot.view.quicksetup.softap.common.SoftApCommonGuideActivity;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: LightStripConnectPartsGuideActivity.kt */
/* loaded from: classes2.dex */
public final class LightStripConnectPartsGuideActivity extends BaseActivity implements View.OnClickListener {
    public static final a y = new a(null);
    private String p0 = "";
    private ActivityLightStripConnectPartsGuideBinding z;

    /* compiled from: LightStripConnectPartsGuideActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final void a(Context activity, String str) {
            j.e(activity, "activity");
            Intent intent = new Intent(activity, LightStripConnectPartsGuideActivity.class);
            intent.putExtra("device_model", str);
            activity.startActivity(intent);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final void e1() {
        String str;
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("device_model")) == null) {
            str = "L900";
        }
        this.p0 = str;
    }

    private final void f1() {
        ActivityLightStripConnectPartsGuideBinding activityLightStripConnectPartsGuideBinding = this.z;
        if (activityLightStripConnectPartsGuideBinding == null) {
            j.t("mBinding");
        }
        activityLightStripConnectPartsGuideBinding.h(this);
    }

    public static final void g1(Context context, String str) {
        y.a(context, str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.img_back) {
            finish();
        } else if (valueOf != null && valueOf.intValue() == R.id.btn_bottom) {
            SoftApCommonGuideActivity.y.a(this, this.p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_light_strip_connect_parts_guide);
        j.d(contentView, "DataBindingUtil.setConte…trip_connect_parts_guide)");
        this.z = (ActivityLightStripConnectPartsGuideBinding) contentView;
        e1();
        f1();
    }
}
