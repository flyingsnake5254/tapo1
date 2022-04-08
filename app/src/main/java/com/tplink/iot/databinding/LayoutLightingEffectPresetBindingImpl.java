package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.devices.lightstrip.widget.AutoLightFeaturePointView;

/* loaded from: classes2.dex */
public class LayoutLightingEffectPresetBindingImpl extends LayoutLightingEffectPresetBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts q = null;
    @Nullable
    private static final SparseIntArray x;
    @NonNull
    private final FrameLayout y;
    private long z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x = sparseIntArray;
        sparseIntArray.put(R.id.rl_content, 1);
        sparseIntArray.put(R.id.auto_view, 2);
        sparseIntArray.put(R.id.rv_presets, 3);
    }

    public LayoutLightingEffectPresetBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, q, x));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.z = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.z != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.z = 1L;
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

    private LayoutLightingEffectPresetBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AutoLightFeaturePointView) objArr[2], (RelativeLayout) objArr[1], (RecyclerView) objArr[3]);
        this.z = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.y = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
