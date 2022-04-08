package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

/* loaded from: classes2.dex */
public abstract class ActivitySubGOnBoardingBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f6702c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    protected SubGViewModel f6703d;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySubGOnBoardingBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f6702c = frameLayout;
    }

    public abstract void h(@Nullable SubGViewModel subGViewModel);
}
