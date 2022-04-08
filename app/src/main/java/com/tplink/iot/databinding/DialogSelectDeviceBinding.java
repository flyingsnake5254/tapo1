package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel;

/* loaded from: classes2.dex */
public abstract class DialogSelectDeviceBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6807c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f6808d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6809f;
    @NonNull
    public final TextView q;
    @NonNull
    public final View x;
    @Bindable
    protected SelectDeviceViewModel y;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogSelectDeviceBinding(Object obj, View view, int i, TextView textView, RecyclerView recyclerView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.f6807c = textView;
        this.f6808d = recyclerView;
        this.f6809f = textView2;
        this.q = textView3;
        this.x = view2;
    }

    public abstract void h(@Nullable SelectDeviceViewModel selectDeviceViewModel);
}
