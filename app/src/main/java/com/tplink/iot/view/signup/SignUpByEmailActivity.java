package com.tplink.iot.view.signup;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.f0;
import com.tplink.iot.Utils.login.CloudRegionCode;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.p;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.about.AboutWebActivity;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.view.login.CloudRegionChooseActivity;
import com.tplink.iot.view.login.LoginActivity;
import com.tplink.iot.viewmodel.signup.SignUpViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.PassWordEditText;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class SignUpByEmailActivity extends BaseActivity implements PassWordEditText.d {
    @BindView
    LinearLayout mLayoutContainer;
    @BindView
    CheckBox mRegisterAgreePolicyCBox;
    @BindView
    TextView mRegisterAgreePolicyText;
    @BindView
    TextView mRegisterBtnTextview;
    @BindView
    PassWordEditText mRegisterConfirmPswEditText;
    @BindView
    DrawableEditText mRegisterEmailEditText;
    @BindView
    PassWordEditText mRegisterPswEditText;
    @BindView
    TextView mRegisterTitle;
    @BindView
    CheckBox mSubscribeEmailCBox;
    private MenuItem y;
    private SignUpViewModel z = null;
    private String p0 = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements d0.g {
        a() {
        }

        @Override // com.tplink.iot.Utils.d0.g
        public void a() {
            SignUpByEmailActivity.this.l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements d0.f {
        b() {
        }

        @Override // com.tplink.iot.Utils.d0.f
        public void a() {
            SignUpByEmailActivity.this.o1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements InputFilter {
        c() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (!f0.c(SignUpByEmailActivity.this.mRegisterEmailEditText.getText().toString()) || SignUpByEmailActivity.this.mRegisterPswEditText.k()) {
                return null;
            }
            SignUpByEmailActivity.this.mRegisterEmailEditText.setHelpText((CharSequence) null);
            SignUpByEmailActivity.this.mRegisterEmailEditText.setErrorText(R.string.account_invalid_email_address);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            if (bool == null || !bool.booleanValue()) {
                SignUpByEmailActivity signUpByEmailActivity = SignUpByEmailActivity.this;
                s0.p(signUpByEmailActivity, signUpByEmailActivity.getString(R.string.no_internet_connection_tip));
                return;
            }
            SignUpByEmailActivity.this.z.j(SignUpByEmailActivity.this.mRegisterEmailEditText.getText().toString().trim(), SignUpByEmailActivity.this.mRegisterPswEditText.getText().toString(), SignUpByEmailActivity.this.p0, SignUpByEmailActivity.this.mSubscribeEmailCBox.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Observer<CloudException> {
        e() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable CloudException cloudException) {
            SignUpByEmailActivity.this.t1(cloudException);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements TPMaterialDialogV3.d {
        f() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV3.d
        public void onClick(View view) {
            SignUpByEmailActivity.this.n1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(SignUpByEmailActivity.this, LoginActivity.class);
            intent.putExtra("SignUpEmail", SignUpByEmailActivity.this.mRegisterEmailEditText.getText().toString().trim());
            SignUpByEmailActivity.this.setResult(-1, intent);
            SignUpByEmailActivity.this.finish();
        }
    }

    private boolean k1() {
        return b.d.w.h.b.c(this.mRegisterEmailEditText.getText().toString()) && f0.e(this.mRegisterPswEditText.getText().toString()) && this.mRegisterPswEditText.getText().toString().equals(this.mRegisterConfirmPswEditText.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1() {
        Intent intent = new Intent(this, AboutWebActivity.class);
        intent.putExtra("toolbar_title", getString(R.string.about_item_title_privacy));
        intent.putExtra("url", "https://www.tapo.com/app/privacy/?utm_source=tapo&utm_medium=app#privacy-policy");
        startActivity(intent);
        overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
    }

    private void m1() {
        b.d.w.f.a.g(this);
        Intent intent = new Intent(this, CloudRegionChooseActivity.class);
        if (!TextUtils.isEmpty(this.p0)) {
            intent.putExtra("REGION_CODE", this.p0);
        } else {
            intent.putExtra("REGION_CODE", com.tplink.iot.Utils.login.a.b(getApplicationContext()));
        }
        intent.putExtra("args_is_from_dashboard", false);
        startActivityForResult(intent, 1001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        s0.g();
        Intent intent = new Intent(this, SignUpCheckMailboxActivity.class);
        intent.putExtra("SignUpEmail", this.mRegisterEmailEditText.getText().toString().trim());
        intent.putExtra("SignUpPassword", this.mRegisterPswEditText.getText().toString());
        intent.putExtra("EmailType", 1);
        startActivityForResult(intent, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        Intent intent = new Intent(this, AboutWebActivity.class);
        intent.putExtra("toolbar_title", getString(R.string.about_item_title_terms));
        intent.putExtra("url", "https://www.tapo.com/app/privacy/?utm_source=tapo&utm_medium=app#terms-of-use");
        startActivity(intent);
        overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
    }

    private void p1() {
        this.mRegisterEmailEditText.m();
        b.d.w.f.a.j(this);
        this.mRegisterEmailEditText.setEmailList(Arrays.asList(getResources().getStringArray(R.array.email)));
        if (getIntent() == null || getIntent().getStringExtra("SignUpEmail") == null) {
            this.mRegisterEmailEditText.setText("");
        } else {
            this.mRegisterEmailEditText.setText(getIntent().getStringExtra("SignUpEmail"));
        }
        Selection.setSelection(this.mRegisterEmailEditText.getText(), this.mRegisterEmailEditText.getText().length());
        d0.g(this, this.mRegisterAgreePolicyText, R.string.check_pp_tou, getString(R.string.about_item_title_privacy), getString(R.string.about_item_title_terms), new a(), new b());
        this.mRegisterTitle.setFocusable(true);
        this.mRegisterTitle.setFocusableInTouchMode(true);
        v1();
    }

    private void q1() {
        this.mRegisterEmailEditText.setFilters(new InputFilter[]{new c(), new InputFilter.LengthFilter(64)});
        this.mRegisterPswEditText.setOnTextChangeListener(this);
        this.mRegisterConfirmPswEditText.setOnTextChangeListener(this);
    }

    private void r1() {
        new TPMaterialDialogV3.Builder(this).e(R.string.resend_activation_email_confirm, R.color.common_iot_dark_black).j(R.string.common_resend, R.color.common_iot_main_blue, new f()).h(R.string.common_cancel, R.color.common_iot_light_black, null).setCancelable(false).c(false).show();
    }

    private void s1() {
        TSnackbar.x(this, R.string.email_has_registered, -1).F(R.string.common_login, new g()).I(getResources().getColor(R.color.common_iot_main_blue)).N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(CloudException cloudException) {
        if (cloudException == null) {
            s0.m(this, getString(R.string.common_waiting));
            return;
        }
        s0.g();
        int errCode = cloudException.getErrCode();
        if (errCode != -20621) {
            if (errCode == -20615 || errCode == -20202 || errCode == -20200) {
                s0.p(this, getString(R.string.account_login_incorrect_email_or_psw_tip_v2));
                return;
            } else if (errCode == 0) {
                n1();
                return;
            } else if (errCode == 19) {
                r1();
                return;
            } else if (!(errCode == 16 || errCode == 17)) {
                s0.p(this, getString(R.string.account_login_common_failed_tip));
                return;
            }
        }
        s1();
    }

    private void u1() {
        this.z.h().observe(this, new d());
        this.z.i().observe(this, new e());
    }

    private void v1() {
        boolean f2 = com.tplink.iot.Utils.login.a.f(this.p0);
        this.mRegisterAgreePolicyCBox.setChecked(!f2);
        this.mSubscribeEmailCBox.setChecked(!f2);
    }

    private void w1() {
        if (!k1() || !this.mRegisterAgreePolicyCBox.isChecked()) {
            this.mRegisterBtnTextview.setEnabled(false);
        } else {
            this.mRegisterBtnTextview.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnTextChanged
    public void EditTextChanged() {
        if (f0.c(this.mRegisterEmailEditText.getText().toString())) {
            this.mRegisterEmailEditText.setErrorText(R.string.account_invalid_email_address);
        } else {
            this.mRegisterEmailEditText.setErrorText((CharSequence) null);
        }
        w1();
    }

    @Override // com.tplink.iot.widget.PassWordEditText.d
    public void i0(String str) {
        w1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            if (i == 1001 && i2 == -1) {
                String stringExtra = intent.getStringExtra("REGION_CODE");
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.p0 = stringExtra;
                    MenuItem menuItem = this.y;
                    if (menuItem != null) {
                        menuItem.setTitle(CloudRegionCode.fromSymbol(stringExtra));
                    }
                    v1();
                }
            } else if (i == 0 && i2 == -1) {
                finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnFocusChange
    public void onConfirmPswFocusChange(View view, boolean z) {
        if (!z && !this.mRegisterConfirmPswEditText.getText().toString().isEmpty() && !this.mRegisterConfirmPswEditText.getText().toString().equals(this.mRegisterPswEditText.getText().toString())) {
            this.mRegisterConfirmPswEditText.setErrorText(R.string.account_check_pwd_passwords_not_match);
        }
        w1();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void onContainerClicked() {
        b.d.w.f.a.g(this);
        this.mRegisterTitle.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_signup_by_email);
            ButterKnife.a(this);
            this.z = (SignUpViewModel) ViewModelProviders.of(this).get(SignUpViewModel.class);
            this.p0 = com.tplink.iot.Utils.login.a.a(this);
            p1();
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
            q1();
            u1();
            p.m();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_save, menu);
        this.y = menu.findItem(R.id.common_save);
        if (!TextUtils.isEmpty(this.p0)) {
            String c2 = com.tplink.iot.Utils.login.a.c(this, this.p0);
            if (!TextUtils.isEmpty(c2)) {
                this.y.setTitle(c2);
                return true;
            }
            this.y.setTitle(R.string.login_region);
            return true;
        }
        this.y.setTitle(R.string.login_region);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnFocusChange
    public void onEmailFocusChange(View view, boolean z) {
        if (!z && !this.mRegisterEmailEditText.getText().toString().isEmpty() && !b.d.w.h.b.c(this.mRegisterEmailEditText.getText().toString())) {
            this.mRegisterEmailEditText.setErrorText(R.string.account_invalid_email_address);
        }
        w1();
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            b.d.w.f.a.g(this);
            finish();
            return false;
        } else if (itemId != R.id.common_save) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            m1();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnCheckedChanged
    public void onPolicyCheckedChanged(CompoundButton compoundButton, boolean z) {
        w1();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void register() {
        b.d.w.f.a.g(this);
        this.z.k();
    }
}
