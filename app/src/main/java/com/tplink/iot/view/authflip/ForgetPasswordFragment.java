package com.tplink.iot.view.authflip;

import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.tplink.iot.R;
import com.tplink.iot.Utils.e;
import com.tplink.iot.Utils.f0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.widget.DrawableEditText;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public class ForgetPasswordFragment extends BaseAppFlipFragment implements View.OnClickListener, TextWatcher {
    private DrawableEditText q;
    private Button x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentActivity activity = ForgetPasswordFragment.this.getActivity();
            Objects.requireNonNull(activity);
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> aVar) {
            Integer a = aVar.a();
            if (a != null) {
                ForgetPasswordFragment.this.O0(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> aVar) {
            Integer a = aVar.a();
            if (a != null) {
                ForgetPasswordFragment.this.N0(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements s0.h {
        d() {
        }

        @Override // com.tplink.iot.Utils.s0.h
        public void onDismiss() {
            ForgetPasswordFragment forgetPasswordFragment = ForgetPasswordFragment.this;
            if (forgetPasswordFragment.f8327d != null) {
                forgetPasswordFragment.f8328f.A(forgetPasswordFragment.q.getText().toString().trim());
                ForgetPasswordFragment.this.f8327d.e0("LoginFragment", null);
            }
        }
    }

    private void I0() {
        setHasOptionsMenu(true);
        ((Toolbar) this.f8326c.findViewById(R.id.toolbar)).setNavigationOnClickListener(new a());
        this.q = (DrawableEditText) this.f8326c.findViewById(R.id.reset_email_et);
        Button button = (Button) this.f8326c.findViewById(R.id.reset_pwd_button);
        this.x = button;
        button.setOnClickListener(this);
        this.q.f(this);
        this.q.setEmailList(Arrays.asList(getResources().getStringArray(R.array.email)));
        this.x.setEnabled(false);
        this.q.setText(this.f8328f.v());
        Selection.setSelection(this.q.getText(), this.q.getText().length());
        this.q.m();
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity);
        b.d.w.f.a.j(activity);
    }

    private void J0() {
        this.f8328f.u().observe(this, new b());
        this.f8328f.p().observe(this, new c());
    }

    private void K0() {
        TSnackbar.B(this, R.string.cloud_account_login_not_reg, -1).N();
    }

    private void L0() {
        TSnackbar.B(this, R.string.email_not_activated, -1).N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(Integer num) {
        s0.g();
        int intValue = num.intValue();
        if (intValue != -20200) {
            switch (intValue) {
                case 16:
                case 17:
                    s0.m(getActivity(), getString(R.string.common_waiting));
                    this.f8328f.y(this.q.getText().toString().trim());
                    return;
                case 18:
                    K0();
                    return;
                case 19:
                    L0();
                    return;
                default:
                    s0.p(getActivity(), getString(R.string.account_check_email_common_failed_tip));
                    return;
            }
        } else {
            s0.p(getActivity(), getString(R.string.account_login_incorrect_email_or_psw_tip_v2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(Integer num) {
        if (num == null) {
            s0.m(getActivity(), getString(R.string.common_waiting));
            return;
        }
        s0.g();
        int intValue = num.intValue();
        if (intValue != -21002) {
            if (intValue == -20600) {
                K0();
            } else if (intValue != -20200) {
                if (intValue != 0) {
                    s0.p(getActivity(), getString(R.string.common_operation_failed));
                    return;
                } else {
                    s0.B(getActivity(), new d());
                    return;
                }
            }
            s0.p(getActivity(), getString(R.string.account_login_incorrect_email_or_psw_tip_v2));
            return;
        }
        e.f(getActivity());
    }

    private void P0() {
        if (TextUtils.isEmpty(this.q.getText().toString())) {
            this.x.setEnabled(false);
        } else if (!b.d.w.h.b.c(this.q.getText().toString())) {
            this.x.setEnabled(false);
        } else {
            this.x.setEnabled(true);
        }
    }

    @Override // com.tplink.iot.view.authflip.BaseAppFlipFragment
    public int A0() {
        return R.layout.fragment_forget_password;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (f0.c(this.q.getText().toString())) {
            this.q.setErrorText(R.string.account_invalid_email_address);
        } else {
            this.q.setErrorText((CharSequence) null);
        }
        P0();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.reset_pwd_button) {
            B0();
            s0.l(getActivity());
            this.f8328f.k(this.q.getText().toString().trim());
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        I0();
        J0();
    }
}
