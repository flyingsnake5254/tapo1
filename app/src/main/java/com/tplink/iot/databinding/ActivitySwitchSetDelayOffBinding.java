package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.devices.switches.viewmodel.SwitchSetDelayOffViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

/* loaded from: classes2.dex */
public abstract class ActivitySwitchSetDelayOffBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f6714c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f6715d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TPSwitchCompat f6716f;
    @Bindable
    protected SwitchSetDelayOffViewModel q;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySwitchSetDelayOffBinding(Object obj, View view, int i, LinearLayout linearLayout, RecyclerView recyclerView, TPSwitchCompat tPSwitchCompat) {
        super(obj, view, i);
        this.f6714c = linearLayout;
        this.f6715d = recyclerView;
        this.f6716f = tPSwitchCompat;
    }

    public abstract void h(@Nullable SwitchSetDelayOffViewModel switchSetDelayOffViewModel);
}
