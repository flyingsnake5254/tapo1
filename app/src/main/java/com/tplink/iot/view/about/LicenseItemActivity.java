package com.tplink.iot.view.about;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

/* loaded from: classes2.dex */
public class LicenseItemActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_license_item);
            String stringExtra = getIntent().getStringExtra("toolbar_title");
            int intExtra = getIntent().getIntExtra(FirebaseAnalytics.Param.CONTENT, -1);
            if (!TextUtils.isEmpty(stringExtra)) {
                c1(stringExtra);
            }
            TextView textView = (TextView) findViewById(R.id.license_item_content);
            if (intExtra != -1) {
                textView.setText(intExtra);
            }
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
        }
    }
}
