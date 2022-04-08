package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;

/* loaded from: classes2.dex */
public abstract class DialogMultiLiveDragBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f6792c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6793d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6794f;
    @NonNull
    public final View q;
    @Bindable
    protected MutableLiveData<Boolean> x;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogMultiLiveDragBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, View view2) {
        super(obj, view, i);
        this.f6792c = constraintLayout;
        this.f6793d = imageView;
        this.f6794f = imageView2;
        this.q = view2;
    }

    public abstract void h(@Nullable MutableLiveData<Boolean> mutableLiveData);
}
