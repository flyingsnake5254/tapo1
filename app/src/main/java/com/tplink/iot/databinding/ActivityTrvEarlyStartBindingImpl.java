package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

/* loaded from: classes2.dex */
public class ActivityTrvEarlyStartBindingImpl extends ActivityTrvEarlyStartBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts x = null;
    @Nullable
    private static final SparseIntArray y;
    private long p0;
    @NonNull
    private final LinearLayout z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        y = sparseIntArray;
        sparseIntArray.put(R.id.iv_early_start, 1);
        sparseIntArray.put(R.id.tv_title, 2);
        sparseIntArray.put(R.id.switch_button, 3);
        sparseIntArray.put(R.id.tv_hint, 4);
    }

    public ActivityTrvEarlyStartBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, x, y));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.p0 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p0 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p0 = 1L;
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

    private ActivityTrvEarlyStartBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (TPSwitchCompat) objArr[3], (TextView) objArr[4], (TextView) objArr[2]);
        this.p0 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.z = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
