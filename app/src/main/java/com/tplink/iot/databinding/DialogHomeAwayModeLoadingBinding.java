package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes2.dex */
public abstract class DialogHomeAwayModeLoadingBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6774c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6775d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f6776f;
    @Bindable
    protected ObservableField<String> q;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogHomeAwayModeLoadingBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f6774c = imageView;
        this.f6775d = textView;
        this.f6776f = linearLayout;
    }
}
