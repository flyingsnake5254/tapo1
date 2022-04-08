package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.devices.switches.viewmodel.SwitchSetDelayOffViewModel;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

/* loaded from: classes2.dex */
public class ActivitySwitchSetDelayOffBindingImpl extends ActivitySwitchSetDelayOffBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts x = null;
    @Nullable
    private static final SparseIntArray y;
    private InverseBindingListener p0;
    private long p1;
    @NonNull
    private final LinearLayout z;

    /* loaded from: classes2.dex */
    class a implements InverseBindingListener {
        a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            boolean a = com.tplink.iot.Utils.extension.a.a(ActivitySwitchSetDelayOffBindingImpl.this.f6716f);
            SwitchSetDelayOffViewModel switchSetDelayOffViewModel = ActivitySwitchSetDelayOffBindingImpl.this.q;
            boolean z = true;
            if (switchSetDelayOffViewModel != null) {
                ObservableBoolean j = switchSetDelayOffViewModel.j();
                if (j == null) {
                    z = false;
                }
                if (z) {
                    j.set(a);
                }
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        y = sparseIntArray;
        sparseIntArray.put(R.id.rv_delay_time, 3);
    }

    public ActivitySwitchSetDelayOffBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, x, y));
    }

    private boolean i(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p1 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.p1;
            this.p1 = 0L;
        }
        ObservableBoolean observableBoolean = null;
        SwitchSetDelayOffViewModel switchSetDelayOffViewModel = this.q;
        boolean z = false;
        int i = ((7 & j) > 0L ? 1 : ((7 & j) == 0L ? 0 : -1));
        if (i != 0) {
            if (switchSetDelayOffViewModel != null) {
                observableBoolean = switchSetDelayOffViewModel.j();
            }
            updateRegistration(0, observableBoolean);
            if (observableBoolean != null) {
                z = observableBoolean.get();
            }
        }
        if (i != 0) {
            b.Q(this.f6714c, z);
            com.tplink.iot.Utils.extension.a.g(this.f6716f, z);
        }
        if ((j & 4) != 0) {
            com.tplink.iot.Utils.extension.a.b(this.f6716f, this.p0);
        }
    }

    @Override // com.tplink.iot.databinding.ActivitySwitchSetDelayOffBinding
    public void h(@Nullable SwitchSetDelayOffViewModel switchSetDelayOffViewModel) {
        this.q = switchSetDelayOffViewModel;
        synchronized (this) {
            this.p1 |= 2;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p1 != 0;
        }
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
        if (i != 0) {
            return false;
        }
        return i((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (103 != i) {
            return false;
        }
        h((SwitchSetDelayOffViewModel) obj);
        return true;
    }

    private ActivitySwitchSetDelayOffBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[2], (RecyclerView) objArr[3], (TPSwitchCompat) objArr[1]);
        this.p0 = new a();
        this.p1 = -1L;
        this.f6714c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.z = linearLayout;
        linearLayout.setTag(null);
        this.f6716f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
