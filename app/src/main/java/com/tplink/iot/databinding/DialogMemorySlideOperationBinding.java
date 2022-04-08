package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

/* loaded from: classes2.dex */
public abstract class DialogMemorySlideOperationBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6786c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6787d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6788f;
    @NonNull
    public final ImageView q;
    @Bindable
    protected g x;
    @Bindable
    protected MemoriesViewModel y;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogMemorySlideOperationBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        super(obj, view, i);
        this.f6786c = imageView;
        this.f6787d = imageView2;
        this.f6788f = imageView3;
        this.q = imageView4;
    }

    public abstract void h(@Nullable MemoriesViewModel memoriesViewModel);

    public abstract void i(@Nullable g gVar);
}
