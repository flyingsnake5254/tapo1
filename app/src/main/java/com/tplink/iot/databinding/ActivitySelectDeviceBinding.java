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
public abstract class ActivitySelectDeviceBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6669c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f6670d;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    protected SelectDeviceViewModel f6671f;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySelectDeviceBinding(Object obj, View view, int i, TextView textView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f6669c = textView;
        this.f6670d = recyclerView;
    }

    public abstract void h(@Nullable SelectDeviceViewModel selectDeviceViewModel);
}
