package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.b;

/* loaded from: classes2.dex */
public class LayoutCameraMenuSettingsBindingImpl extends LayoutCameraMenuSettingsBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts q = null;
    @Nullable
    private static final SparseIntArray x = null;
    @NonNull
    private final RelativeLayout y;
    private long z;

    public LayoutCameraMenuSettingsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, q, x));
    }

    private boolean i(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.z |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.z;
            this.z = 0L;
        }
        ObservableBoolean observableBoolean = this.f7225f;
        boolean z = false;
        int i = ((3 & j) > 0L ? 1 : ((3 & j) == 0L ? 0 : -1));
        if (!(i == 0 || observableBoolean == null)) {
            z = observableBoolean.get();
        }
        if ((j & 2) != 0) {
            b.q(this.f7223c, Boolean.TRUE, null);
        }
        if (i != 0) {
            b.Q(this.f7224d, z);
        }
    }

    @Override // com.tplink.iot.databinding.LayoutCameraMenuSettingsBinding
    public void h(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(0, observableBoolean);
        this.f7225f = observableBoolean;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(23);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.z != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.z = 2L;
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
        if (23 != i) {
            return false;
        }
        h((ObservableBoolean) obj);
        return true;
    }

    private LayoutCameraMenuSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[1], (View) objArr[2]);
        this.z = -1L;
        this.f7223c.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.y = relativeLayout;
        relativeLayout.setTag(null);
        this.f7224d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
