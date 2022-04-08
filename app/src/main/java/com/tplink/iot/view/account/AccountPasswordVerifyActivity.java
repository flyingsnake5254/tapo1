package com.tplink.iot.view.account;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.bean.account.result.CheckPasswordV1Result;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.e;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.account.AccountPasswordVerifyViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public class AccountPasswordVerifyActivity extends BaseActivity {
    private DrawableEditText p0;
    private AccountPasswordVerifyViewModel p1;
    private LinearLayout y;
    private TPRefreshableButton z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountPasswordVerifyActivity.this.p1.g(AccountPasswordVerifyActivity.this.p0.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AccountPasswordVerifyActivity.this.z.setEnabled(AccountPasswordVerifyActivity.this.n1());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<i<CheckPasswordV1Result>> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(i<CheckPasswordV1Result> iVar) {
            AccountPasswordVerifyActivity.this.l1(iVar);
        }
    }

    private void j1() {
        this.y = (LinearLayout) findViewById(R.id.activity_account_password_verify_container);
        this.z = (TPRefreshableButton) findViewById(R.id.next_bt);
        this.p0 = (DrawableEditText) findViewById(R.id.account_password_et);
        b1(R.string.common_change_password);
        this.z.setEnabled(false);
        this.z.setOnClickListener(new a());
        this.p0.f(new b());
        this.p0.m();
    }

    private void k1() {
        s0.p(this, getString(R.string.account_check_pwd_invalid_psw));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(i<CheckPasswordV1Result> iVar) {
        if (iVar == null) {
            b.d.w.f.a.g(this);
            return;
        }
        this.z.h();
        if (iVar.b() == 0) {
            CheckPasswordV1Result a2 = iVar.a();
            if (a2 != null) {
                int errorCode = a2.getErrorCode();
                int lockedMinutes = a2.getLockedMinutes();
                if (errorCode == -20661) {
                    e.d(this, lockedMinutes, this.p1.h());
                } else if (errorCode == -20601) {
                    int remainAttempts = a2.getRemainAttempts();
                    int failedAttempts = a2.getFailedAttempts();
                    int remainAttempts2 = a2.getRemainAttempts() + a2.getFailedAttempts();
                    if (failedAttempts == remainAttempts2) {
                        e.d(this, lockedMinutes, this.p1.h());
                    } else if (remainAttempts == 1) {
                        e.e(this, remainAttempts, remainAttempts2, lockedMinutes);
                    } else {
                        k1();
                    }
                } else if (errorCode != 0) {
                    k1();
                } else {
                    startActivityForResult(new Intent(this, AccountChangePasswordActivity.class), 0);
                }
            } else {
                k1();
            }
        } else {
            k1();
        }
    }

    private void m1() {
        this.p1.i().observe(this, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n1() {
        return this.p0.getText().toString().length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            finish();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_account_password_verify);
            this.p1 = (AccountPasswordVerifyViewModel) ViewModelProviders.of(this).get(AccountPasswordVerifyViewModel.class);
            j1();
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
            m1();
        }
    }
}
