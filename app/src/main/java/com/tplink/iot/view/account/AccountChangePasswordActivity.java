package com.tplink.iot.view.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.f0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.account.AccountChangePasswordViewModel;
import com.tplink.iot.widget.PassWordEditText;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public class AccountChangePasswordActivity extends BaseActivity {
    private LinearLayout y = null;
    private TPRefreshableButton z = null;
    private PassWordEditText p0 = null;
    private PassWordEditText p1 = null;
    private AccountChangePasswordViewModel p2 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements PassWordEditText.d {
        a() {
        }

        @Override // com.tplink.iot.widget.PassWordEditText.d
        public void i0(String str) {
            AccountChangePasswordActivity.this.z.setEnabled(AccountChangePasswordActivity.this.p1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements PassWordEditText.d {
        b() {
        }

        @Override // com.tplink.iot.widget.PassWordEditText.d
        public void i0(String str) {
            AccountChangePasswordActivity.this.z.setEnabled(AccountChangePasswordActivity.this.p1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.d.w.f.a.g(AccountChangePasswordActivity.this);
            AccountChangePasswordActivity.this.i1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Observer<Integer> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            AccountChangePasswordActivity.this.m1(num);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        if (p1()) {
            this.p2.m(this.p0.getText().toString());
            return;
        }
        this.z.h();
        s0.p(this, getString(R.string.account_check_pwd_passwords_not_match));
    }

    private void j1() {
        b1(R.string.common_change_password);
        this.y = (LinearLayout) findViewById(R.id.account_change_password_container);
        this.p0 = (PassWordEditText) findViewById(R.id.activity_account_change_password_new_password_et);
        this.p1 = (PassWordEditText) findViewById(R.id.activity_account_change_password_confirm_password_et);
        TPRefreshableButton tPRefreshableButton = (TPRefreshableButton) findViewById(R.id.next_bt);
        this.z = tPRefreshableButton;
        tPRefreshableButton.setEnabled(false);
        this.p0.m();
        b.d.w.f.a.j(this);
        this.p0.setOnTextChangeListener(new a());
        this.p1.setOnTextChangeListener(new b());
        this.p1.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tplink.iot.view.account.a
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                AccountChangePasswordActivity.this.l1(view, z);
            }
        });
        this.z.setOnClickListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1 */
    public /* synthetic */ void l1(View view, boolean z) {
        if (!z && !this.p1.getText().toString().isEmpty() && !q1()) {
            this.p1.setErrorText(R.string.account_check_pwd_passwords_not_match);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(Integer num) {
        if (num != null) {
            this.z.h();
            if (num.intValue() != 0) {
                s0.p(this, getString(R.string.common_operation_failed));
            } else {
                startActivityForResult(new Intent(this, AccountPasswordChangedActivity.class), 0);
            }
        }
    }

    private void n1() {
        this.p2.l().observe(this, new d());
    }

    private boolean o1(String str) {
        return f0.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p1() {
        return o1(this.p0.getText().toString()) && o1(this.p1.getText().toString()) && q1();
    }

    private boolean q1() {
        return this.p0.getText().toString().equals(this.p1.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            setResult(-1);
            finish();
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_account_change_password);
            this.p2 = (AccountChangePasswordViewModel) ViewModelProviders.of(this).get(AccountChangePasswordViewModel.class);
            j1();
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
            n1();
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        b.d.w.f.a.g(this);
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
