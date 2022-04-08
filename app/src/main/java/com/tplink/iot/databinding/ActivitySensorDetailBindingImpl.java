package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.tplink.iot.R;
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.yinglan.scrolllayout.ScrollLayout;

/* loaded from: classes2.dex */
public class ActivitySensorDetailBindingImpl extends ActivitySensorDetailBinding {
    @Nullable
    private static final SparseIntArray p0;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts z;
    @NonNull
    private final FrameLayout p1;
    private long p2;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        z = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"activity_sensor_detail_content"}, new int[]{2}, new int[]{R.layout.activity_sensor_detail_content});
        includedLayouts.setIncludes(1, new String[]{"activity_sensor_detail_bottom"}, new int[]{3}, new int[]{R.layout.activity_sensor_detail_bottom});
        SparseIntArray sparseIntArray = new SparseIntArray();
        p0 = sparseIntArray;
        sparseIntArray.put(R.id.iv_bg, 4);
    }

    public ActivitySensorDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, z, p0));
    }

    private boolean l(ActivitySensorDetailBottomBinding activitySensorDetailBottomBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 2;
        }
        return true;
    }

    private boolean m(ActivitySensorDetailContentBinding activitySensorDetailContentBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.p2;
            this.p2 = 0L;
        }
        SensorDetailViewModel sensorDetailViewModel = this.y;
        View.OnClickListener onClickListener = this.x;
        int i = ((j & 24) > 0L ? 1 : ((j & 24) == 0L ? 0 : -1));
        if ((20 & j) != 0) {
            this.f6674f.h(sensorDetailViewModel);
            this.q.h(sensorDetailViewModel);
        }
        if (i != 0) {
            this.f6674f.i(onClickListener);
            this.q.i(onClickListener);
        }
        ViewDataBinding.executeBindingsOn(this.q);
        ViewDataBinding.executeBindingsOn(this.f6674f);
    }

    @Override // com.tplink.iot.databinding.ActivitySensorDetailBinding
    public void h(@Nullable SensorDetailViewModel sensorDetailViewModel) {
        this.y = sensorDetailViewModel;
        synchronized (this) {
            this.p2 |= 4;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.p2 != 0) {
                return true;
            }
            return this.q.hasPendingBindings() || this.f6674f.hasPendingBindings();
        }
    }

    @Override // com.tplink.iot.databinding.ActivitySensorDetailBinding
    public void i(@Nullable View.OnClickListener onClickListener) {
        this.x = onClickListener;
        synchronized (this) {
            this.p2 |= 8;
        }
        notifyPropertyChanged(69);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p2 = 16L;
        }
        this.q.invalidateAll();
        this.f6674f.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((ActivitySensorDetailContentBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return l((ActivitySensorDetailBottomBinding) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.q.setLifecycleOwner(lifecycleOwner);
        this.f6674f.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (15 == i) {
            h((SensorDetailViewModel) obj);
        } else if (69 != i) {
            return false;
        } else {
            i((View.OnClickListener) obj);
        }
        return true;
    }

    private ActivitySensorDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[4], (ScrollLayout) objArr[1], (ActivitySensorDetailBottomBinding) objArr[3], (ActivitySensorDetailContentBinding) objArr[2]);
        this.p2 = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.p1 = frameLayout;
        frameLayout.setTag(null);
        this.f6673d.setTag(null);
        setContainedBinding(this.f6674f);
        setContainedBinding(this.q);
        setRootTag(view);
        invalidateAll();
    }
}
