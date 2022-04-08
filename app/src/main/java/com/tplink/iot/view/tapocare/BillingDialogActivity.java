package com.tplink.iot.view.tapocare;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.ColorRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.c.a;
import com.tplink.iot.R;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.billing.BillingViewModel;

/* loaded from: classes2.dex */
public class BillingDialogActivity extends BaseActivity {
    private static final String y = BillingDialogActivity.class.getSimpleName();
    private Fragment p0;
    private String p1 = e.x();
    private BillingViewModel z;

    private void e1() {
        getLifecycle().addObserver(this.z.m());
    }

    public static void f1(Activity activity, String str) {
        Intent intent = new Intent(activity, BillingDialogActivity.class);
        intent.putExtra("url", str);
        activity.startActivityForResult(intent, 1345);
        activity.overridePendingTransition(R.anim.translate_between_interface_bottom_in, R.anim.translate_between_interface_bottom_out);
    }

    private void g1() {
        setContentView(R.layout.activity_billing_fragment);
        k1(BillingFragment.i1(false, this.p1));
        i1(R.color.automation_disable_gray);
        findViewById(R.id.fl_billing_container).setBackgroundResource(R.color.automation_disable_gray);
    }

    private void h1() {
        j1(this);
        this.z = (BillingViewModel) ViewModelProviders.of(this).get(BillingViewModel.class);
        String stringExtra = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.p1 = stringExtra;
        }
        setResult(-1);
    }

    private void i1(@ColorRes int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(i));
        }
    }

    private void j1(Activity activity) {
        WindowManager.LayoutParams attributes;
        if (activity != null && activity.getWindow() != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                View decorView = activity.getWindow().getDecorView();
                if (decorView != null) {
                    decorView.setSystemUiVisibility(1280);
                }
                if (activity.getResources() != null) {
                    activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.transparent));
                }
            } else if (i >= 19 && (attributes = activity.getWindow().getAttributes()) != null) {
                attributes.flags = 67108864 | attributes.flags;
            }
        }
    }

    private void k1(Fragment fragment) {
        if (fragment != null) {
            Fragment fragment2 = this.p0;
            if (fragment2 == null || !fragment2.getClass().equals(fragment.getClass())) {
                String str = y;
                a.c(str, "switchFragment:" + fragment.getClass().getSimpleName());
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                String canonicalName = fragment.getClass().getCanonicalName();
                if (this.p0 == null) {
                    beginTransaction.add(R.id.fl_billing_container, fragment, canonicalName);
                } else {
                    beginTransaction.replace(R.id.fl_billing_container, fragment, canonicalName);
                }
                this.p0 = fragment;
                beginTransaction.commit();
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.translate_between_interface_fade_in, R.anim.translate_between_interface_bottom_out);
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment fragment = this.p0;
        if (!(fragment instanceof k) || !((k) fragment).d()) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h1();
        g1();
        e1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
