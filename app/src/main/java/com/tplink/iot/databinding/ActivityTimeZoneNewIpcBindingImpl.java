package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.TimezoneViewModel;

/* loaded from: classes2.dex */
public class ActivityTimeZoneNewIpcBindingImpl extends ActivityTimeZoneNewIpcBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p1 = null;
    @Nullable
    private static final SparseIntArray p2;
    private long H3;
    @NonNull
    private final RelativeLayout p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p2 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        sparseIntArray.put(R.id.location_title, 4);
        sparseIntArray.put(R.id.location_tips, 5);
        sparseIntArray.put(R.id.timezone_list, 6);
    }

    public ActivityTimeZoneNewIpcBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, p1, p2));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H3 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.H3;
            this.H3 = 0L;
        }
        View.OnClickListener onClickListener = this.p0;
        TimezoneViewModel timezoneViewModel = this.z;
        ObservableBoolean observableBoolean = null;
        int i = ((10 & j) > 0L ? 1 : ((10 & j) == 0L ? 0 : -1));
        boolean z = false;
        int i2 = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (timezoneViewModel != null) {
                observableBoolean = timezoneViewModel.a;
            }
            updateRegistration(0, observableBoolean);
            if (observableBoolean != null) {
                z = observableBoolean.get();
            }
            z = ViewDataBinding.safeUnbox(Boolean.valueOf(z));
        }
        if (i2 != 0) {
            b.K(this.f6726c, Boolean.valueOf(z));
        }
        if (i != 0) {
            this.q.setOnClickListener(onClickListener);
        }
    }

    @Override // com.tplink.iot.databinding.ActivityTimeZoneNewIpcBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.p0 = onClickListener;
        synchronized (this) {
            this.H3 |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.H3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityTimeZoneNewIpcBinding
    public void i(@Nullable TimezoneViewModel timezoneViewModel) {
        this.z = timezoneViewModel;
        synchronized (this) {
            this.H3 |= 4;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.H3 = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (2 == i) {
            h((View.OnClickListener) obj);
        } else if (105 != i) {
            return false;
        } else {
            i((TimezoneViewModel) obj);
        }
        return true;
    }

    private ActivityTimeZoneNewIpcBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CameraLoadingView) objArr[2], (TextView) objArr[5], (TextView) objArr[4], (Button) objArr[1], (RecyclerView) objArr[6], (Toolbar) objArr[3]);
        this.H3 = -1L;
        this.f6726c.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.p3 = relativeLayout;
        relativeLayout.setTag(null);
        this.q.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
