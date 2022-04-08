package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.widget.NumberPickerView;

/* loaded from: classes2.dex */
public class FragmentGuardModeSetAlarmTimeBindingImpl extends FragmentGuardModeSetAlarmTimeBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts x = null;
    @Nullable
    private static final SparseIntArray y;
    private long p0;
    @NonNull
    private final ScrollView z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        y = sparseIntArray;
        sparseIntArray.put(R.id.rv_config_alarm_time, 1);
        sparseIntArray.put(R.id.ll_time_picker, 2);
        sparseIntArray.put(R.id.npv_alarm_time_min, 3);
        sparseIntArray.put(R.id.npv_alarm_time_sec, 4);
    }

    public FragmentGuardModeSetAlarmTimeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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

    private FragmentGuardModeSetAlarmTimeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (NumberPickerView) objArr[3], (NumberPickerView) objArr[4], (RecyclerView) objArr[1]);
        this.p0 = -1L;
        ScrollView scrollView = (ScrollView) objArr[0];
        this.z = scrollView;
        scrollView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
