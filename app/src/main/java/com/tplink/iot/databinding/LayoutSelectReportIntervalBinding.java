package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.NumberPickerView;

/* loaded from: classes2.dex */
public abstract class LayoutSelectReportIntervalBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final NumberPickerView f7289c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7290d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7291f;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutSelectReportIntervalBinding(Object obj, View view, int i, NumberPickerView numberPickerView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7289c = numberPickerView;
        this.f7290d = textView;
        this.f7291f = textView2;
    }
}
