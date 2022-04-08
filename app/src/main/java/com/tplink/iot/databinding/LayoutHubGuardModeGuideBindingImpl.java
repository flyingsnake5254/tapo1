package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class LayoutHubGuardModeGuideBindingImpl extends LayoutHubGuardModeGuideBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p0 = null;
    @Nullable
    private static final SparseIntArray p1;
    @NonNull
    private final ConstraintLayout p2;
    private long p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p1 = sparseIntArray;
        sparseIntArray.put(R.id.layout_guard_mode_overlay, 1);
        sparseIntArray.put(R.id.arrow_gard_mode, 2);
        sparseIntArray.put(R.id.layout_guide_desc, 3);
        sparseIntArray.put(R.id.iv_guide_icon, 4);
        sparseIntArray.put(R.id.tv_guide_title, 5);
        sparseIntArray.put(R.id.tv_guide_desc, 6);
        sparseIntArray.put(R.id.btn_skip, 7);
    }

    public LayoutHubGuardModeGuideBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p0, p1));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.p3 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p3 = 1L;
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

    private LayoutHubGuardModeGuideBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (TextView) objArr[7], (ImageView) objArr[4], (RelativeLayout) objArr[1], (ConstraintLayout) objArr[3], (TextView) objArr[6], (TextView) objArr[5]);
        this.p3 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.p2 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
