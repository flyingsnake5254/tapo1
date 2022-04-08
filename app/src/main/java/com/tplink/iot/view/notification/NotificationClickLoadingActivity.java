package com.tplink.iot.view.notification;

import android.os.Bundle;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;

/* loaded from: classes2.dex */
public class NotificationClickLoadingActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        supportRequestWindowFeature(1);
        setContentView(R.layout.activity_notification_click_loading);
        finish();
    }
}
