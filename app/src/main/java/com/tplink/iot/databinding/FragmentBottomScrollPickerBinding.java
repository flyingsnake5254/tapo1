package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.NumberPickerView;

/* loaded from: classes2.dex */
public abstract class FragmentBottomScrollPickerBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final NumberPickerView f6825c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6826d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6827f;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentBottomScrollPickerBinding(Object obj, View view, int i, NumberPickerView numberPickerView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6825c = numberPickerView;
        this.f6826d = textView;
        this.f6827f = textView2;
    }
}
