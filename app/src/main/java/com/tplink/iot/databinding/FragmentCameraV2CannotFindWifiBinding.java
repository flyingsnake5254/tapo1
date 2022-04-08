package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2CannotFindWifiBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6855c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f6856d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Toolbar f6857f;
    @NonNull
    public final TextView q;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2CannotFindWifiBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, Toolbar toolbar, TextView textView) {
        super(obj, view, i);
        this.f6855c = imageView;
        this.f6856d = linearLayout;
        this.f6857f = toolbar;
        this.q = textView;
    }
}
