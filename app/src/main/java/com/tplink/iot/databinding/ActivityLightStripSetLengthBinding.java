package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes2.dex */
public abstract class ActivityLightStripSetLengthBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextInputEditText f6596c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextInputLayout f6597d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6598f;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityLightStripSetLengthBinding(Object obj, View view, int i, TextInputEditText textInputEditText, TextInputLayout textInputLayout, TextView textView) {
        super(obj, view, i);
        this.f6596c = textInputEditText;
        this.f6597d = textInputLayout;
        this.f6598f = textView;
    }
}
