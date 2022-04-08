package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

/* loaded from: classes2.dex */
public abstract class DialogMemoryBottomOperationBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f6783c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6784d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6785f;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @Bindable
    protected g y;
    @Bindable
    protected MemoriesViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogMemoryBottomOperationBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f6783c = linearLayout;
        this.f6784d = textView;
        this.f6785f = textView2;
        this.q = textView3;
        this.x = textView4;
    }

    public abstract void h(@Nullable MemoriesViewModel memoriesViewModel);

    public abstract void i(@Nullable g gVar);
}
