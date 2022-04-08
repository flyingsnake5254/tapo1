package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class FragmentGuardModeConfigBindingImpl extends FragmentGuardModeConfigBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts J3 = null;
    @Nullable
    private static final SparseIntArray K3;
    @NonNull
    private final LinearLayout L3;
    private long M3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K3 = sparseIntArray;
        sparseIntArray.put(R.id.tv_description, 1);
        sparseIntArray.put(R.id.config_trigger_devices, 2);
        sparseIntArray.put(R.id.tv_trigger_devices, 3);
        sparseIntArray.put(R.id.arrow_share, 4);
        sparseIntArray.put(R.id.config_alarm_type, 5);
        sparseIntArray.put(R.id.tv_alarm_type, 6);
        sparseIntArray.put(R.id.arrow_alarm_type, 7);
        sparseIntArray.put(R.id.config_alarm_volume, 8);
        sparseIntArray.put(R.id.tv_alarm_volume, 9);
        sparseIntArray.put(R.id.arrow_alarm_volume, 10);
        sparseIntArray.put(R.id.config_alarm_time, 11);
        sparseIntArray.put(R.id.tv_alarm_time, 12);
        sparseIntArray.put(R.id.arrow_alarm_time, 13);
    }

    public FragmentGuardModeConfigBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, J3, K3));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.M3 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.M3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.M3 = 1L;
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

    private FragmentGuardModeConfigBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[13], (ImageView) objArr[7], (ImageView) objArr[10], (ImageView) objArr[4], (RelativeLayout) objArr[11], (RelativeLayout) objArr[5], (RelativeLayout) objArr[8], (RelativeLayout) objArr[2], (TextView) objArr[12], (TextView) objArr[6], (TextView) objArr[9], (TextView) objArr[1], (TextView) objArr[3]);
        this.M3 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.L3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
