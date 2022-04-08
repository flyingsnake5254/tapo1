package com.tplink.iot.view.feedback;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

/* loaded from: classes2.dex */
public class SelectFeedbackDeviceActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.select_feedback_device_activity);
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            SelectFeedbackDeviceFragment selectFeedbackDeviceFragment = (SelectFeedbackDeviceFragment) Fragment.instantiate(this, SelectFeedbackDeviceFragment.class.getName());
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                selectFeedbackDeviceFragment.setArguments(extras);
            }
            beginTransaction.add(R.id.container, selectFeedbackDeviceFragment);
            beginTransaction.commitAllowingStateLoss();
        }
    }
}
