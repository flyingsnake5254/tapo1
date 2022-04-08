package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes2.dex */
public abstract class LayoutHubGuardModeGuideBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7241c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7242d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7243f;
    @NonNull
    public final RelativeLayout q;
    @NonNull
    public final ConstraintLayout x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutHubGuardModeGuideBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, RelativeLayout relativeLayout, ConstraintLayout constraintLayout, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7241c = imageView;
        this.f7242d = textView;
        this.f7243f = imageView2;
        this.q = relativeLayout;
        this.x = constraintLayout;
        this.y = textView2;
        this.z = textView3;
    }
}
