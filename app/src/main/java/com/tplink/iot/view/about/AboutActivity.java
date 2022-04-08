package com.tplink.iot.view.about;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

/* loaded from: classes2.dex */
public class AboutActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_about);
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.activity_about_content, (AboutFragment) Fragment.instantiate(this, AboutFragment.class.getName()));
            beginTransaction.commitAllowingStateLoss();
        }
    }
}
