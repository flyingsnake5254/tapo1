package com.tplink.libtpcontrols;

import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;

/* loaded from: classes3.dex */
public class TPClearPswText extends TPClearEditText {
    public TPClearPswText(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpcontrols.TPClearEditText, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    public TPClearPswText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TPClearPswText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
