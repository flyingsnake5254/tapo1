package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.R;
import com.tplink.iot.view.iotplug.energymonitor.chart.PowerLineChart;

/* loaded from: classes2.dex */
public class ActivityPlugPowerStatisticBindingImpl extends ActivityPlugPowerStatisticBinding {
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
        sparseIntArray.put(R.id.pem_tab_layout, 1);
        sparseIntArray.put(R.id.pem_chart_container, 2);
        sparseIntArray.put(R.id.pem_marker_view, 3);
        sparseIntArray.put(R.id.tv_power, 4);
        sparseIntArray.put(R.id.tv_time, 5);
        sparseIntArray.put(R.id.pem_line_chart, 6);
    }

    public ActivityPlugPowerStatisticBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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

    private ActivityPlugPowerStatisticBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (PowerLineChart) objArr[6], (CardView) objArr[3], (TabLayout) objArr[1], (TextView) objArr[4], (TextView) objArr[5]);
        this.p2 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p1 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
