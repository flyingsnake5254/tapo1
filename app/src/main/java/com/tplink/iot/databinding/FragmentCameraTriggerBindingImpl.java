package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class FragmentCameraTriggerBindingImpl extends FragmentCameraTriggerBinding {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f6850d = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f6851f = null;
    private long q;

    public FragmentCameraTriggerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f6850d, f6851f));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.q = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.q != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.q = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    private FragmentCameraTriggerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[0]);
        this.q = -1L;
        this.f6849c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
