package com.tplink.iot.view.signup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.p;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.login.LoginActivity;
import com.tplink.iot.view.login.RetrieveAccountByEmailActivity;
import com.tplink.iot.viewmodel.login.LoginViewModel;
import com.tplink.iot.viewmodel.login.RetrieveAccountViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.viewmodel.signup.SignUpCheckViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public class SignUpCheckMailboxActivity extends BaseActivity implements View.OnClickListener {
    private int H3;
    private int I3;
    private Handler J3;
    private Runnable K3;
    private int P3;
    private TPRefreshableButton p0;
    private RelativeLayout y;
    private TextView z;
    private String p1 = "";
    private String p2 = "";
    private int p3 = -1;
    private boolean L3 = false;
    private LoginViewModel M3 = null;
    private SignUpCheckViewModel N3 = null;
    private RetrieveAccountViewModel O3 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<Integer> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(Integer num) {
            if (num != null) {
                int intValue = num.intValue();
                if (intValue == -21002) {
                    com.tplink.iot.Utils.e.f(SignUpCheckMailboxActivity.this);
                } else if (intValue == -20623) {
                    SignUpCheckMailboxActivity.this.D1();
                    SignUpCheckMailboxActivity.this.t1();
                } else if (intValue != 0) {
                    SignUpCheckMailboxActivity signUpCheckMailboxActivity = SignUpCheckMailboxActivity.this;
                    s0.p(signUpCheckMailboxActivity, signUpCheckMailboxActivity.getString(R.string.common_operation_failed));
                    SignUpCheckMailboxActivity.this.t1();
                } else {
                    SignUpCheckMailboxActivity signUpCheckMailboxActivity2 = SignUpCheckMailboxActivity.this;
                    s0.C(signUpCheckMailboxActivity2, signUpCheckMailboxActivity2.getString(R.string.account_email_resend_success_tip), null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<Integer> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            SignUpCheckMailboxActivity.this.E1(num);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<Integer> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            SignUpCheckMailboxActivity.this.C1(num);
            p.n(SignUpCheckMailboxActivity.this.p1, num);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Observer<i<LoginV1Result>> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(i<LoginV1Result> iVar) {
            Integer num;
            if (iVar == null) {
                num = null;
            } else if (iVar.b() != 0 || iVar.a() == null) {
                num = 1;
            } else {
                num = Integer.valueOf(iVar.a().getErrorCode());
            }
            SignUpCheckMailboxActivity.this.x1(num);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements TPMaterialDialogV2.d {
        e() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            Intent intent = new Intent(SignUpCheckMailboxActivity.this, SignUpByEmailActivity.class);
            intent.putExtra("SignUpEmail", SignUpCheckMailboxActivity.this.p1);
            SignUpCheckMailboxActivity.this.startActivity(intent);
            SignUpCheckMailboxActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements TPMaterialDialogV2.c {
        f() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.c
        public void a(TPMaterialDialogV2 tPMaterialDialogV2, View view) {
            TextView textView = (TextView) view.findViewById(R.id.dialog_message_tv);
            textView.setText(R.string.account_not_exist_tip);
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.mipmap.ill_email_empty, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements TPMaterialDialogV2.d {
        g() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            SignUpCheckMailboxActivity.this.v1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class h implements Runnable {
        private h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SignUpCheckMailboxActivity.this.I3 > 0) {
                SignUpCheckMailboxActivity.r1(SignUpCheckMailboxActivity.this);
            } else if (SignUpCheckMailboxActivity.this.I3 == 0) {
                SignUpCheckMailboxActivity.this.p0.setEnabled(true);
                SignUpCheckMailboxActivity.r1(SignUpCheckMailboxActivity.this);
            }
            SignUpCheckMailboxActivity.g1(SignUpCheckMailboxActivity.this);
            if (SignUpCheckMailboxActivity.this.H3 < 1) {
                SignUpCheckMailboxActivity.this.t1();
                return;
            }
            TextView textView = SignUpCheckMailboxActivity.this.z;
            SignUpCheckMailboxActivity signUpCheckMailboxActivity = SignUpCheckMailboxActivity.this;
            textView.setText(signUpCheckMailboxActivity.getString(R.string.account_email_resend_countdown, new Object[]{Integer.valueOf(signUpCheckMailboxActivity.H3)}));
            SignUpCheckMailboxActivity.this.J3.postDelayed(SignUpCheckMailboxActivity.this.K3, 1000L);
        }

        /* synthetic */ h(SignUpCheckMailboxActivity signUpCheckMailboxActivity, a aVar) {
            this();
        }
    }

    private void A1() {
        new TPMaterialDialogV2.Builder(this).setView(R.layout.layout_dialog_image_and_message).x(new f()).o(R.string.common_register, R.color.common_iot_main_blue, new e()).g(8, 8).l(R.string.common_cancel, R.color.common_iot_light_black, null).show();
    }

    private void B1() {
        new TPMaterialDialogV2.Builder(this).i(R.string.activate_email_remind, R.color.common_iot_dark_black).o(R.string.common_ok, R.color.common_iot_main_blue, null).setCancelable(false).c(false).g(8, 8).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1(Integer num) {
        if (num == null) {
            this.L3 = true;
            return;
        }
        this.L3 = false;
        this.p0.h();
        int intValue = num.intValue();
        if (intValue == 16 || intValue == 17) {
            if (this.P3 == 6) {
                this.O3.h(this.p1);
                return;
            }
            v1();
            p.o(this.p1);
        } else if (intValue != 19) {
            s0.p(this, getString(R.string.account_check_email_common_failed_tip));
        } else {
            B1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        if (!this.L3) {
            new TPMaterialDialogV2.Builder(this).i(R.string.signup_use_email_already_reg, R.color.common_tplink_light_gray).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_login, R.color.common_iot_main_blue, new g()).g(8, 8).create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(Integer num) {
        if (num == null) {
            s0.m(this, getString(R.string.common_waiting));
            return;
        }
        s0.g();
        int intValue = num.intValue();
        if (intValue == -21002) {
            com.tplink.iot.Utils.e.f(this);
        } else if (intValue == -20600) {
            A1();
        } else if (intValue == -20200) {
            s0.p(this, getString(R.string.account_login_incorrect_email_or_psw_tip_v2));
        } else if (intValue != 0) {
            s0.p(this, getString(R.string.common_operation_failed));
        } else {
            w1();
        }
    }

    private void F1() {
        this.N3.j().observe(this, new a());
        this.O3.g().observe(this, new b());
        this.N3.i().observe(this, new c());
        this.M3.k().observe(this, new d());
    }

    static /* synthetic */ int g1(SignUpCheckMailboxActivity signUpCheckMailboxActivity) {
        int i = signUpCheckMailboxActivity.H3;
        signUpCheckMailboxActivity.H3 = i - 1;
        return i;
    }

    static /* synthetic */ int r1(SignUpCheckMailboxActivity signUpCheckMailboxActivity) {
        int i = signUpCheckMailboxActivity.I3;
        signUpCheckMailboxActivity.I3 = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1() {
        this.z.setEnabled(true);
        this.z.setAlpha(1.0f);
        this.z.setText(getString(R.string.common_resend));
        this.J3.removeCallbacks(this.K3);
    }

    private void u1() {
        if (getIntent() != null) {
            this.p1 = getIntent().getStringExtra("SignUpEmail");
            String stringExtra = getIntent().getStringExtra("SignUpPassword");
            this.p2 = stringExtra;
            if (this.p1 == null) {
                this.p1 = "";
            }
            if (stringExtra == null) {
                this.p2 = "";
            }
            this.p3 = getIntent().getIntExtra("EmailType", 1);
            int intExtra = getIntent().getIntExtra("IntoType", 4);
            this.P3 = intExtra;
            if ((intExtra == 5 || intExtra == 6) && !TextUtils.isEmpty(this.p1)) {
                this.N3.k(this.p1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("SignUpEmail", this.p1);
        intent.putExtra("SignUpPassword", "");
        startActivity(intent);
        finish();
    }

    private void w1() {
        Intent intent = new Intent(this, SignUpCheckMailboxActivity.class);
        intent.putExtra("SignUpEmail", this.p1);
        intent.putExtra("EmailType", 2);
        intent.addFlags(33554432);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(Integer num) {
        if (num == null) {
            s0.l(this);
            return;
        }
        s0.g();
        int intValue = num.intValue();
        if (intValue == -20615 || intValue == -20601 || intValue == -20200) {
            s0.p(this, getString(R.string.account_login_incorrect_email_or_psw_tip_v2));
        } else if (intValue != 0) {
            s0.p(this, getString(R.string.account_login_common_failed_tip));
        } else {
            com.tplink.iot.model.about.c.l();
            com.tplink.iot.core.p.b(SignUpByEmailActivity.class);
            Y0();
            finish();
        }
    }

    private void y1() {
        this.y = (RelativeLayout) findViewById(R.id.activity_check_mailbox_container);
        this.z = (TextView) findViewById(R.id.email_resend_tv);
        this.p0 = (TPRefreshableButton) findViewById(R.id.check_email_login_btn);
        TextView textView = (TextView) findViewById(R.id.check_mail_title_tv);
        TextView textView2 = (TextView) findViewById(R.id.check_email_hint);
        ((TextView) findViewById(R.id.account_info_email_tv)).setText(this.p1.trim());
        this.J3 = new Handler();
        this.K3 = new h(this, null);
        z1();
        int i = this.p3;
        if (1 == i) {
            textView.setText(R.string.cloud_account_activate_account_title);
            textView2.setText(R.string.account_email_activate_tip);
            this.p0.setText(getString(R.string.activated_and_login));
        } else if (2 == i) {
            textView.setText(R.string.check_reset_password_email);
            textView2.setText(R.string.account_reset_password_tip);
            this.p0.setText(getString(R.string.already_reset));
        }
        this.z.setOnClickListener(this);
        this.p0.setOnClickListener(this);
    }

    private void z1() {
        this.H3 = 59;
        this.I3 = 9;
        this.z.setText(getString(R.string.account_email_resend_countdown, new Object[]{59}));
        this.z.setAlpha(0.5f);
        this.z.setEnabled(false);
        this.p0.setEnabled(false);
        this.J3.postDelayed(this.K3, 1000L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.check_email_login_btn) {
            int i = this.p3;
            if (1 == i) {
                this.N3.h(this.p1);
            } else if (2 == i) {
                Intent intent = new Intent();
                intent.putExtra("ResetAccountMail", this.p1.trim());
                setResult(-1, intent);
                com.tplink.iot.core.p.b(RetrieveAccountByEmailActivity.class);
                finish();
            }
        } else if (id == R.id.email_resend_tv) {
            z1();
            int i2 = this.p3;
            if (1 == i2) {
                this.N3.k(this.p1);
            } else if (2 == i2) {
                this.N3.l(this.p1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_signup_check_mailbox);
            this.N3 = (SignUpCheckViewModel) ViewModelProviders.of(this).get(SignUpCheckViewModel.class);
            this.M3 = (LoginViewModel) ViewModelProviders.of(this).get(LoginViewModel.class);
            this.O3 = (RetrieveAccountViewModel) ViewModelProviders.of(this).get(RetrieveAccountViewModel.class);
            u1();
            y1();
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
            F1();
            p.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Runnable runnable = this.K3;
        if (runnable != null) {
            this.J3.removeCallbacks(runnable);
            this.K3 = null;
        }
        super.onDestroy();
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        b.d.w.f.a.g(this);
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
