package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.NumberPickerView;

/* loaded from: classes2.dex */
public abstract class DialogIntRangePickerBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6777c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6778d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final NumberPickerView f6779f;
    @NonNull
    public final NumberPickerView q;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogIntRangePickerBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, NumberPickerView numberPickerView, NumberPickerView numberPickerView2) {
        super(obj, view, i);
        this.f6777c = imageView;
        this.f6778d = imageView2;
        this.f6779f = numberPickerView;
        this.q = numberPickerView2;
    }
}
