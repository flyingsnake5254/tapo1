package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;

/* loaded from: classes2.dex */
public abstract class FragmentDialogGetLostBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f7002c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7003d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7004f;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @Bindable
    protected g y;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentDialogGetLostBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.f7002c = textView;
        this.f7003d = textView2;
        this.f7004f = textView3;
        this.q = textView4;
        this.x = textView5;
    }

    public abstract void h(@Nullable g gVar);
}
