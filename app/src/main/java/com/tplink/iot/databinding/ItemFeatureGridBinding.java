package com.tplink.iot.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public abstract class ItemFeatureGridBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7169c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f7170d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7171f;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFeatureGridBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.f7169c = imageView;
        this.f7170d = linearLayout;
        this.f7171f = textView;
    }

    @NonNull
    public static ItemFeatureGridBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemFeatureGridBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemFeatureGridBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_feature_grid, viewGroup, z, obj);
    }
}
