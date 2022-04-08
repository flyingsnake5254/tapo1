package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes2.dex */
public abstract class ActivityGuardModeBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6566c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6567d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6568f;
    @NonNull
    public final RelativeLayout q;
    @NonNull
    public final RelativeLayout x;
    @NonNull
    public final RelativeLayout y;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityGuardModeBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3) {
        super(obj, view, i);
        this.f6566c = imageView;
        this.f6567d = imageView2;
        this.f6568f = imageView3;
        this.q = relativeLayout;
        this.x = relativeLayout2;
        this.y = relativeLayout3;
    }
}
