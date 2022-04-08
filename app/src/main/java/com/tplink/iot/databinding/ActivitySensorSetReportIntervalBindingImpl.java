package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.widget.ItemSettingLayout;

/* loaded from: classes2.dex */
public class ActivitySensorSetReportIntervalBindingImpl extends ActivitySensorSetReportIntervalBinding {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f6682d = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f6683f;
    @NonNull
    private final LinearLayout q;
    private long x;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6683f = sparseIntArray;
        sparseIntArray.put(R.id.item_report_interval, 1);
    }

    public ActivitySensorSetReportIntervalBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f6682d, f6683f));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.x = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.x != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.x = 1L;
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

    private ActivitySensorSetReportIntervalBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ItemSettingLayout) objArr[1]);
        this.x = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.q = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
