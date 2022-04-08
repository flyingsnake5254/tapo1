package com.tplink.iot.view.login;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.tplink.iot.R;
import com.tplink.iot.widget.DrawableEditText;

/* loaded from: classes2.dex */
public class LoginActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private LoginActivity f9477b;

    /* renamed from: c  reason: collision with root package name */
    private View f9478c;

    /* renamed from: d  reason: collision with root package name */
    private View f9479d;

    /* renamed from: e  reason: collision with root package name */
    private View f9480e;

    /* renamed from: f  reason: collision with root package name */
    private View f9481f;

    /* loaded from: classes2.dex */
    class a extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ LoginActivity f9482f;

        a(LoginActivity loginActivity) {
            this.f9482f = loginActivity;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f9482f.signUp();
        }
    }

    /* loaded from: classes2.dex */
    class b extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ LoginActivity f9483f;

        b(LoginActivity loginActivity) {
            this.f9483f = loginActivity;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f9483f.loginForget();
        }
    }

    /* loaded from: classes2.dex */
    class c extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ LoginActivity f9484f;

        c(LoginActivity loginActivity) {
            this.f9484f = loginActivity;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f9484f.login();
        }
    }

    /* loaded from: classes2.dex */
    class d implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ LoginActivity a;

        d(LoginActivity loginActivity) {
            this.a = loginActivity;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.a.onPolicyCheckedChanged(compoundButton, z);
        }
    }

    @UiThread
    public LoginActivity_ViewBinding(LoginActivity loginActivity, View view) {
        this.f9477b = loginActivity;
        loginActivity.mAccountEmailEditText = (DrawableEditText) butterknife.internal.c.d(view, R.id.et_account_email, "field 'mAccountEmailEditText'", DrawableEditText.class);
        loginActivity.mAccountPasswordEditText = (DrawableEditText) butterknife.internal.c.d(view, R.id.et_account_password, "field 'mAccountPasswordEditText'", DrawableEditText.class);
        View c2 = butterknife.internal.c.c(view, R.id.tv_sign_up, "field 'mSignUpTextview' and method 'signUp'");
        loginActivity.mSignUpTextview = (TextView) butterknife.internal.c.b(c2, R.id.tv_sign_up, "field 'mSignUpTextview'", TextView.class);
        this.f9478c = c2;
        c2.setOnClickListener(new a(loginActivity));
        View c3 = butterknife.internal.c.c(view, R.id.tv_login_forget, "field 'mLoginForgetTextview' and method 'loginForget'");
        loginActivity.mLoginForgetTextview = (TextView) butterknife.internal.c.b(c3, R.id.tv_login_forget, "field 'mLoginForgetTextview'", TextView.class);
        this.f9479d = c3;
        c3.setOnClickListener(new b(loginActivity));
        View c4 = butterknife.internal.c.c(view, R.id.btn_login, "field 'mLoginBtnTextview' and method 'login'");
        loginActivity.mLoginBtnTextview = (TextView) butterknife.internal.c.b(c4, R.id.btn_login, "field 'mLoginBtnTextview'", TextView.class);
        this.f9480e = c4;
        c4.setOnClickListener(new c(loginActivity));
        loginActivity.mIncorrectInfoTv = (TextView) butterknife.internal.c.d(view, R.id.tv_incorrect_info, "field 'mIncorrectInfoTv'", TextView.class);
        View c5 = butterknife.internal.c.c(view, R.id.cb_account_remember, "field 'mCbRememberMe' and method 'onPolicyCheckedChanged'");
        loginActivity.mCbRememberMe = (CheckBox) butterknife.internal.c.b(c5, R.id.cb_account_remember, "field 'mCbRememberMe'", CheckBox.class);
        this.f9481f = c5;
        ((CompoundButton) c5).setOnCheckedChangeListener(new d(loginActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        LoginActivity loginActivity = this.f9477b;
        if (loginActivity != null) {
            this.f9477b = null;
            loginActivity.mAccountEmailEditText = null;
            loginActivity.mAccountPasswordEditText = null;
            loginActivity.mSignUpTextview = null;
            loginActivity.mLoginForgetTextview = null;
            loginActivity.mLoginBtnTextview = null;
            loginActivity.mIncorrectInfoTv = null;
            loginActivity.mCbRememberMe = null;
            this.f9478c.setOnClickListener(null);
            this.f9478c = null;
            this.f9479d.setOnClickListener(null);
            this.f9479d = null;
            this.f9480e.setOnClickListener(null);
            this.f9480e = null;
            ((CompoundButton) this.f9481f).setOnCheckedChangeListener(null);
            this.f9481f = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
