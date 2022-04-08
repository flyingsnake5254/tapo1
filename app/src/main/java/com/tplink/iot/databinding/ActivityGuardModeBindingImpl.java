package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class ActivityGuardModeBindingImpl extends ActivityGuardModeBinding {
    @Nullable
    private static final SparseIntArray p0;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts z = null;
    @NonNull
    private final LinearLayout p1;
    private long p2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p0 = sparseIntArray;
        sparseIntArray.put(R.id.item_home_mode, 1);
        sparseIntArray.put(R.id.arrow_home_mode, 2);
        sparseIntArray.put(R.id.item_away_mode, 3);
        sparseIntArray.put(R.id.arrow_away_mode, 4);
        sparseIntArray.put(R.id.item_sleep_mode, 5);
        sparseIntArray.put(R.id.arrow_sleep_mode, 6);
    }

    public ActivityGuardModeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, z, p0));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.p2 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p2 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p2 = 1L;
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

    private ActivityGuardModeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (ImageView) objArr[2], (ImageView) objArr[6], (RelativeLayout) objArr[3], (RelativeLayout) objArr[1], (RelativeLayout) objArr[5]);
        this.p2 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p1 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
