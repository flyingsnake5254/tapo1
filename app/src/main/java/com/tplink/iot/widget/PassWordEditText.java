package com.tplink.iot.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import com.tplink.iot.R;
import com.tplink.iot.Utils.f0;

/* loaded from: classes3.dex */
public class PassWordEditText extends DrawableEditText {
    private String R3 = "";
    private d S3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PassWordEditText passWordEditText = PassWordEditText.this;
            passWordEditText.R3 = passWordEditText.getText().toString();
            if (f0.d(PassWordEditText.this.R3)) {
                PassWordEditText.this.setHelpText((CharSequence) null);
                PassWordEditText.this.setErrorText(R.string.account_password_illegal_character);
            } else {
                PassWordEditText.this.setHelpText((CharSequence) null);
                PassWordEditText.this.setErrorText((CharSequence) null);
            }
            if (PassWordEditText.this.S3 != null) {
                PassWordEditText.this.S3.i0(PassWordEditText.this.R3);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements InputFilter {
        b() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (!f0.d(PassWordEditText.this.R3) || PassWordEditText.this.k()) {
                return null;
            }
            PassWordEditText.this.setHelpText((CharSequence) null);
            PassWordEditText.this.setErrorText(R.string.account_password_illegal_character);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements View.OnFocusChangeListener {
        c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                return;
            }
            if (!f0.e(PassWordEditText.this.R3)) {
                PassWordEditText.this.setHelpText((CharSequence) null);
                PassWordEditText.this.setErrorText(R.string.account_password_length_and_letter_limit);
                return;
            }
            PassWordEditText.this.setHelpText((CharSequence) null);
            PassWordEditText.this.setErrorText((CharSequence) null);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void i0(String str);
    }

    public PassWordEditText(Context context) {
        super(context);
        q();
    }

    public void q() {
        f(new a());
        setFilters(new InputFilter[]{new b(), new InputFilter.LengthFilter(32)});
        setOnFocusChangeListener(new c());
    }

    public void setOnTextChangeListener(d dVar) {
        this.S3 = dVar;
    }

    public PassWordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        q();
    }

    public PassWordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        q();
    }
}
