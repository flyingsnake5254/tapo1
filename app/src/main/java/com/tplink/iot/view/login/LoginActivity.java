package com.tplink.iot.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.p;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.about.AboutWebActivity;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.signup.SignUpByEmailActivity;
import com.tplink.iot.view.signup.SignUpCheckMailboxActivity;
import com.tplink.iot.viewmodel.login.LoginViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.Utils.o;

/* loaded from: classes2.dex */
public class LoginActivity extends BaseActivity implements TextWatcher {
    @BindView
    DrawableEditText mAccountEmailEditText;
    @BindView
    DrawableEditText mAccountPasswordEditText;
    @BindView
    CheckBox mCbRememberMe;
    @BindView
    TextView mIncorrectInfoTv;
    @BindView
    TextView mLoginBtnTextview;
    @BindView
    TextView mLoginForgetTextview;
    @BindView
    TextView mSignUpTextview;
    private boolean p0 = false;
    private String p1 = "";
    private String p2 = "";
    private LoginViewModel p3 = null;
    private View y;
    private TPMaterialDialogV3 z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<TCAccountBean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable TCAccountBean tCAccountBean) {
            LoginActivity.this.x1(tCAccountBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<com.tplink.iot.viewmodel.quicksetup.i<LoginV1Result>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(com.tplink.iot.viewmodel.quicksetup.i<LoginV1Result> iVar) {
            LoginActivity.this.t1(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(LoginActivity.this, SignUpByEmailActivity.class);
            intent.putExtra("SignUpEmail", LoginActivity.this.mAccountEmailEditText.getText().toString().trim());
            LoginActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements TPMaterialDialogV2.d {
        d() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            LoginActivity.this.q1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements d0.g {
        e() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            LoginActivity.this.p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements d0.f {
        f() {
        }

        @Override // com.tplink.iot.Utils.d0.f
        public void a() {
            LoginActivity.this.r1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements d0.g {
        g() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            LoginActivity.this.s1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements TPMaterialDialogV3.d {
        final /* synthetic */ CheckBox a;

        h(CheckBox checkBox) {
            this.a = checkBox;
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV3.d
        public void onClick(View view) {
            LoginActivity.this.p0 = true;
            com.tplink.iot.model.about.c.i(true);
            if (this.a.isChecked()) {
                com.tplink.iot.model.about.c.j(true);
                com.tplink.iot.model.about.c.d();
                com.tplink.iot.Utils.x0.b.c(true);
            }
            p.a(LoginActivity.this.mAccountEmailEditText.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements CompoundButton.OnCheckedChangeListener {
        i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            LoginActivity.this.z.q(-1, z, z ? R.color.common_iot_main_blue : R.color.common_tplink_light_gray);
        }
    }

    private void A1() {
        new TPMaterialDialogV2.Builder(this).i(R.string.account_login_expired, R.color.common_iot_dark_black).o(R.string.common_ok, R.color.common_iot_main_blue, null).setCancelable(false).c(false).g(8, 8).show();
    }

    private void B1() {
        this.p3.j().observe(this, new a());
        this.p3.k().observe(this, new b());
    }

    private boolean C1() {
        return this.mAccountEmailEditText.getText().toString().length() > 0;
    }

    private boolean D1() {
        return C1() && E1();
    }

    private boolean E1() {
        return this.mAccountPasswordEditText.getText().toString().length() > 0;
    }

    private void m1(Intent intent) {
        if (intent != null && intent.hasExtra("SignUpE_pwd_error") && intent.getBooleanExtra("SignUpE_pwd_error", false)) {
            A1();
        }
    }

    private String n1() {
        return C1() ? this.mAccountEmailEditText.getText().toString().trim() : "";
    }

    private String o1() {
        return this.mAccountEmailEditText.getText().toString().trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1() {
        Intent intent = new Intent(this, AboutWebActivity.class);
        intent.putExtra("toolbar_title", getString(R.string.about_item_title_privacy));
        intent.putExtra("url", "https://www.tapo.com/app/privacy/?utm_source=tapo&utm_medium=app#privacy-policy");
        startActivity(intent);
        overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        Intent intent = new Intent(this, SignUpCheckMailboxActivity.class);
        intent.putExtra("SignUpEmail", this.mAccountEmailEditText.getText().toString().trim());
        intent.putExtra("SignUpPassword", this.mAccountPasswordEditText.getText().toString());
        intent.putExtra("EmailType", 1);
        intent.putExtra("IntoType", 5);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1() {
        Intent intent = new Intent(this, AboutWebActivity.class);
        intent.putExtra("toolbar_title", getString(R.string.about_item_title_terms));
        intent.putExtra("url", "https://www.tapo.com/app/privacy/?utm_source=tapo&utm_medium=app#terms-of-use");
        startActivity(intent);
        overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1() {
        Intent intent = new Intent(this, AboutWebActivity.class);
        intent.putExtra("toolbar_title", getString(R.string.check_experience_improvement_sub_str));
        intent.putExtra("url", com.tplink.iot.model.about.d.g());
        startActivity(intent);
        overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(com.tplink.iot.viewmodel.quicksetup.i<LoginV1Result> iVar) {
        if (iVar == null) {
            s0.l(this);
            return;
        }
        s0.g();
        if (iVar.b() != 0 || iVar.a() == null) {
            s0.p(this, getString(R.string.account_login_common_failed_tip));
            return;
        }
        LoginV1Result a2 = iVar.a();
        int errorCode = a2.getErrorCode();
        int lockedMinutes = a2.getLockedMinutes();
        if (errorCode == -23003) {
            com.tplink.iot.Utils.e.g(this);
        } else if (errorCode == -20661) {
            com.tplink.iot.Utils.e.d(this, lockedMinutes, n1());
        } else if (errorCode == -20615 || errorCode == -20200) {
            y1();
            p.g(Integer.valueOf(errorCode), this.mAccountEmailEditText.getText().toString());
        } else if (errorCode != 0) {
            switch (errorCode) {
                case -20602:
                    w1();
                    return;
                case -20601:
                    int failedAttempts = a2.getFailedAttempts();
                    int remainAttempts = a2.getRemainAttempts();
                    int remainAttempts2 = a2.getRemainAttempts() + a2.getFailedAttempts();
                    if (failedAttempts == remainAttempts2) {
                        com.tplink.iot.Utils.e.d(this, lockedMinutes, n1());
                        return;
                    } else if (remainAttempts == 1) {
                        com.tplink.iot.Utils.e.e(this, remainAttempts, remainAttempts2, lockedMinutes);
                        return;
                    } else {
                        y1();
                        return;
                    }
                case -20600:
                    v1();
                    return;
                default:
                    s0.p(this, getString(R.string.account_login_common_failed_tip));
                    return;
            }
        } else {
            com.tplink.iot.model.about.c.l();
            Y0();
            p.i();
        }
    }

    private void u1() {
        if (o.h0().u()) {
            this.p1 = getIntent().getStringExtra("SignUpEmail");
            this.p2 = getIntent().getStringExtra("SignUpPassword");
            if (!TextUtils.isEmpty(this.p1)) {
                this.mAccountEmailEditText.setText(this.p1);
            }
            if (!TextUtils.isEmpty(this.p2)) {
                this.mAccountPasswordEditText.setText(this.p2);
            }
            Selection.setSelection(this.mAccountEmailEditText.getText(), this.mAccountEmailEditText.getText().length());
            Selection.setSelection(this.mAccountPasswordEditText.getText(), this.mAccountPasswordEditText.getText().length());
        }
        this.mAccountEmailEditText.f(this);
        this.mAccountPasswordEditText.f(this);
        this.mCbRememberMe.setChecked(o.h0().u());
        boolean e2 = com.tplink.iot.model.about.c.e();
        this.p0 = e2;
        if (!e2) {
            z1();
        } else {
            this.mAccountEmailEditText.m();
        }
    }

    private void v1() {
        TSnackbar.x(this, R.string.cloud_account_login_not_reg, 0).F(R.string.register_sign_up, new c()).I(getResources().getColor(R.color.common_iot_main_blue)).N();
    }

    private void w1() {
        new TPMaterialDialogV2.Builder(this).i(R.string.resend_activation_email_confirm, R.color.common_iot_dark_black).o(R.string.common_resend, R.color.common_iot_main_blue, new d()).l(R.string.common_cancel, R.color.common_iot_light_black, null).setCancelable(false).c(false).g(8, 8).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(TCAccountBean tCAccountBean) {
        if (tCAccountBean != null && o.h0().u() && TextUtils.isEmpty(this.p1) && !TextUtils.isEmpty(tCAccountBean.getCloudUserName())) {
            this.mAccountEmailEditText.setText(tCAccountBean.getCloudUserName());
            Selection.setSelection(this.mAccountEmailEditText.getText(), this.mAccountEmailEditText.getText().length());
        }
    }

    private void y1() {
        this.mIncorrectInfoTv.setVisibility(0);
    }

    private void z1() {
        if (this.y == null) {
            this.y = LayoutInflater.from(this).inflate(R.layout.privacy_policy_terms_of_use_dialog, (ViewGroup) null);
        }
        CheckBox checkBox = (CheckBox) this.y.findViewById(R.id.cb_pp_tou);
        CheckBox checkBox2 = (CheckBox) this.y.findViewById(R.id.cb_ueip);
        if (this.z == null) {
            d0.g(this, (TextView) this.y.findViewById(R.id.tv_pp_tou), R.string.check_pp_tou, getString(R.string.about_item_title_privacy), getString(R.string.about_item_title_terms), new e(), new f());
            d0.e((TextView) this.y.findViewById(R.id.tv_ueip), getString(R.string.check_experience_improvement, new Object[]{getString(R.string.check_experience_improvement_sub_str)}), getString(R.string.check_experience_improvement_sub_str), getResources().getColor(R.color.privacy_policy_dialog_link_text_color), new g());
            String string = getString(R.string.privacy_agree);
            if ("Agree".equals(string)) {
                string = getString(R.string.common_continue);
            }
            String string2 = getString(R.string.privacy_disagree);
            if ("Disagree".equals(string2)) {
                string2 = getString(R.string.privacy_disagree_and_quit);
            }
            this.z = new TPMaterialDialogV3.Builder(this).setTitle(R.string.privacy_message).setView(this.y).setCancelable(false).c(false).m(string, new h(checkBox2)).i(string2, R.color.common_iot_light_black, null).create();
            checkBox.setOnCheckedChangeListener(new i());
        }
        if (!this.z.isShowing()) {
            boolean f2 = com.tplink.iot.Utils.login.a.f(com.tplink.iot.Utils.login.a.a(getApplicationContext()));
            checkBox.setChecked(!f2);
            checkBox2.setChecked(!f2);
            this.z.show();
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.mLoginBtnTextview.setEnabled(D1());
        this.mIncorrectInfoTv.setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.p0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        z1();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void login() {
        this.mIncorrectInfoTv.setVisibility(8);
        if (!b.d.w.f.b.h(this)) {
            s0.p(this, getString(R.string.no_internet_connection_tip));
            return;
        }
        this.p3.m(o1(), this.mAccountPasswordEditText.getText().toString());
        p.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void loginForget() {
        String str;
        b.d.w.f.a.g(this);
        Intent intent = new Intent(this, RetrieveAccountByEmailActivity.class);
        if (C1()) {
            intent.putExtra("ResetAccountMail", this.mAccountEmailEditText.getText().toString().trim());
            str = b.d.w.h.a.g(this.mAccountEmailEditText.getText().toString().trim());
        } else {
            str = "";
        }
        startActivityForResult(intent, 100);
        p.e(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (intent != null) {
            if (i2 == 100 && i3 == -1) {
                String stringExtra = intent.getStringExtra("ResetAccountMail");
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.mAccountEmailEditText.setText(stringExtra);
                    this.mAccountPasswordEditText.setText("");
                    Selection.setSelection(this.mAccountEmailEditText.getText(), this.mAccountEmailEditText.getText().length());
                }
            } else if (i2 == 101 && i3 == -1) {
                String stringExtra2 = intent.getStringExtra("SignUpEmail");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    this.mAccountEmailEditText.setText(stringExtra2);
                    this.mAccountPasswordEditText.setText("");
                    Selection.setSelection(this.mAccountEmailEditText.getText(), this.mAccountEmailEditText.getText().length());
                }
            }
            super.onActivityResult(i2, i3, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (com.tplink.iot.core.o.a() != 0) {
            setContentView(R.layout.activity_login);
            ButterKnife.a(this);
            m1(getIntent());
            this.p3 = (LoginViewModel) ViewModelProviders.of(this).get(LoginViewModel.class);
            u1();
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
            B1();
            p.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null || !intent.hasExtra("SignUpEmail")) {
            this.mAccountPasswordEditText.setText("");
            this.mAccountEmailEditText.setText("");
        } else {
            this.mAccountEmailEditText.setText(intent.getStringExtra("SignUpEmail"));
            this.mAccountPasswordEditText.setText("");
            Selection.setSelection(this.mAccountPasswordEditText.getText(), this.mAccountPasswordEditText.getText().length());
        }
        m1(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnCheckedChanged
    public void onPolicyCheckedChanged(CompoundButton compoundButton, boolean z) {
        o.h0().w0(z);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        String string = bundle.getString("email");
        if (this.mAccountEmailEditText != null && string != null && !string.isEmpty()) {
            this.mAccountEmailEditText.setText(string);
            Selection.setSelection(this.mAccountEmailEditText.getText(), this.mAccountEmailEditText.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.tplink.iot.core.o.a() == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        DrawableEditText drawableEditText = this.mAccountEmailEditText;
        if (drawableEditText != null && !drawableEditText.getText().toString().isEmpty()) {
            bundle.putString("email", this.mAccountEmailEditText.getText().toString());
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void signUp() {
        b.d.w.f.a.g(this);
        startActivityForResult(new Intent(this, SignUpByEmailActivity.class), 101);
        p.k();
    }
}
