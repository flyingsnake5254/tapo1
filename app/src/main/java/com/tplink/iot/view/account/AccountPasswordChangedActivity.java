package com.tplink.iot.view.account;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;

/* loaded from: classes2.dex */
public class AccountPasswordChangedActivity extends BaseActivity {

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountPasswordChangedActivity.this.f1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1() {
        setResult(-1);
        finish();
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        f1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_account_password_changed);
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
            findViewById(R.id.next_bt).setOnClickListener(new a());
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        f1();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
