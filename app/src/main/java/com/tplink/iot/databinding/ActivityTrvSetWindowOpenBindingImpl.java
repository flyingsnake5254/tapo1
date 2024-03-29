package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

/* loaded from: classes2.dex */
public class ActivityTrvSetWindowOpenBindingImpl extends ActivityTrvSetWindowOpenBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p0 = null;
    @Nullable
    private static final SparseIntArray p1;
    @NonNull
    private final LinearLayout p2;
    private long p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p1 = sparseIntArray;
        sparseIntArray.put(R.id.rl_switch, 1);
        sparseIntArray.put(R.id.tv_title, 2);
        sparseIntArray.put(R.id.switch_button, 3);
        sparseIntArray.put(R.id.tv_tip, 4);
        sparseIntArray.put(R.id.ll_shutoff_duration, 5);
        sparseIntArray.put(R.id.item_shutoff_duration, 6);
        sparseIntArray.put(R.id.tv_shutoff_duration_hint, 7);
    }

    public ActivityTrvSetWindowOpenBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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

    private ActivityTrvSetWindowOpenBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ItemSettingLayout) objArr[6], (LinearLayout) objArr[5], (RelativeLayout) objArr[1], (TPSwitchCompat) objArr[3], (TextView) objArr[7], (TextView) objArr[4], (TextView) objArr[2]);
        this.p3 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p2 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
