package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripDetailViewModel;
import com.tplink.iot.widget.businessview.ThingNextEventView;
import com.tplink.iot.widget.businessview.ThingUsageView;
import com.tplink.iot.widget.viewgroup.MultiFeaturesGridView;

/* loaded from: classes2.dex */
public class LayoutLightStripDetailBottomExtBindingImpl extends LayoutLightStripDetailBottomExtBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts y = null;
    @Nullable
    private static final SparseIntArray z;
    @NonNull
    private final LinearLayout p0;
    private long p1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z = sparseIntArray;
        sparseIntArray.put(R.id.multi_features_grid, 1);
        sparseIntArray.put(R.id.thing_next_event_view, 2);
        sparseIntArray.put(R.id.thing_usage_view, 3);
    }

    public LayoutLightStripDetailBottomExtBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, y, z));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.p1 = 0L;
        }
    }

    public void h(@Nullable LightStripDetailViewModel lightStripDetailViewModel) {
        this.x = lightStripDetailViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p1 != 0;
        }
    }

    public void i(@Nullable View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p1 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (15 == i) {
            h((LightStripDetailViewModel) obj);
        } else if (69 != i) {
            return false;
        } else {
            i((View.OnClickListener) obj);
        }
        return true;
    }

    private LayoutLightStripDetailBottomExtBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MultiFeaturesGridView) objArr[1], (ThingNextEventView) objArr[2], (ThingUsageView) objArr[3]);
        this.p1 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
