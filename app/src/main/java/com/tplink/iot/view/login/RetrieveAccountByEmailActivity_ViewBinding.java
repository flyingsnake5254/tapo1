package com.tplink.iot.view.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.tplink.iot.R;
import com.tplink.iot.widget.DrawableEditText;

/* loaded from: classes2.dex */
public class RetrieveAccountByEmailActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private RetrieveAccountByEmailActivity f9496b;

    /* renamed from: c  reason: collision with root package name */
    private View f9497c;

    /* renamed from: d  reason: collision with root package name */
    private View f9498d;

    /* renamed from: e  reason: collision with root package name */
    private View f9499e;

    /* renamed from: f  reason: collision with root package name */
    private View f9500f;
    private TextWatcher g;

    /* loaded from: classes2.dex */
    class a implements View.OnFocusChangeListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RetrieveAccountByEmailActivity f9501c;

        a(RetrieveAccountByEmailActivity retrieveAccountByEmailActivity) {
            this.f9501c = retrieveAccountByEmailActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            this.f9501c.onResetEmailFocusChange(view, z);
        }
    }

    /* loaded from: classes2.dex */
    class b extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ RetrieveAccountByEmailActivity f9503f;

        b(RetrieveAccountByEmailActivity retrieveAccountByEmailActivity) {
            this.f9503f = retrieveAccountByEmailActivity;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f9503f.resetPwd();
        }
    }

    /* loaded from: classes2.dex */
    class c extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ RetrieveAccountByEmailActivity f9504f;

        c(RetrieveAccountByEmailActivity retrieveAccountByEmailActivity) {
            this.f9504f = retrieveAccountByEmailActivity;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f9504f.onContainerClicked();
        }
    }

    /* loaded from: classes2.dex */
    class d implements TextWatcher {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RetrieveAccountByEmailActivity f9505c;

        d(RetrieveAccountByEmailActivity retrieveAccountByEmailActivity) {
            this.f9505c = retrieveAccountByEmailActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.f9505c.EditTextChanged();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @UiThread
    public RetrieveAccountByEmailActivity_ViewBinding(RetrieveAccountByEmailActivity retrieveAccountByEmailActivity, View view) {
        this.f9496b = retrieveAccountByEmailActivity;
        View c2 = butterknife.internal.c.c(view, R.id.reset_email_et, "field 'mResetEmailEt' and method 'onResetEmailFocusChange'");
        retrieveAccountByEmailActivity.mResetEmailEt = (DrawableEditText) butterknife.internal.c.b(c2, R.id.reset_email_et, "field 'mResetEmailEt'", DrawableEditText.class);
        this.f9497c = c2;
        c2.setOnFocusChangeListener(new a(retrieveAccountByEmailActivity));
        View c3 = butterknife.internal.c.c(view, R.id.reset_pwd_button, "field 'mResetPwdButton' and method 'resetPwd'");
        retrieveAccountByEmailActivity.mResetPwdButton = (Button) butterknife.internal.c.b(c3, R.id.reset_pwd_button, "field 'mResetPwdButton'", Button.class);
        this.f9498d = c3;
        c3.setOnClickListener(new b(retrieveAccountByEmailActivity));
        View c4 = butterknife.internal.c.c(view, R.id.activity_retrieve_account_container, "method 'onContainerClicked'");
        this.f9499e = c4;
        c4.setOnClickListener(new c(retrieveAccountByEmailActivity));
        View c5 = butterknife.internal.c.c(view, R.id.edit_text, "method 'EditTextChanged'");
        this.f9500f = c5;
        d dVar = new d(retrieveAccountByEmailActivity);
        this.g = dVar;
        ((TextView) c5).addTextChangedListener(dVar);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        RetrieveAccountByEmailActivity retrieveAccountByEmailActivity = this.f9496b;
        if (retrieveAccountByEmailActivity != null) {
            this.f9496b = null;
            retrieveAccountByEmailActivity.mResetEmailEt = null;
            retrieveAccountByEmailActivity.mResetPwdButton = null;
            this.f9497c.setOnFocusChangeListener(null);
            this.f9497c = null;
            this.f9498d.setOnClickListener(null);
            this.f9498d = null;
            this.f9499e.setOnClickListener(null);
            this.f9499e = null;
            ((TextView) this.f9500f).removeTextChangedListener(this.g);
            this.g = null;
            this.f9500f = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
