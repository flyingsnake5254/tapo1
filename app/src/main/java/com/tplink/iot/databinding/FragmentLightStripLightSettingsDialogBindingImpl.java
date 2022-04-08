package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class FragmentLightStripLightSettingsDialogBindingImpl extends FragmentLightStripLightSettingsDialogBinding {
    @Nullable
    private static final SparseIntArray p0;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts z = null;
    private long p1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p0 = sparseIntArray;
        sparseIntArray.put(R.id.ll_toolbar, 1);
        sparseIntArray.put(R.id.iv_close, 2);
        sparseIntArray.put(R.id.iv_save, 3);
        sparseIntArray.put(R.id.effects_tab_layout, 4);
        sparseIntArray.put(R.id.effects_view_pager, 5);
    }

    public FragmentLightStripLightSettingsDialogBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, z, p0));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.p1 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p1 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p1 = 1L;
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

    private FragmentLightStripLightSettingsDialogBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TabLayout) objArr[4], (ViewPager2) objArr[5], (FrameLayout) objArr[0], (ImageView) objArr[2], (ImageView) objArr[3], (LinearLayout) objArr[1]);
        this.p1 = -1L;
        this.f7028f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
