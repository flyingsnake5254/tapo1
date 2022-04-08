package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes2.dex */
public abstract class ItemCameraLocationBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7144c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7145d;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCameraLocationBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f7144c = imageView;
        this.f7145d = textView;
    }
}
