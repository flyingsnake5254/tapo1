package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class LayoutCameraMenuDefinitionBindingImpl extends LayoutCameraMenuDefinitionBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts q = null;
    @Nullable
    private static final SparseIntArray x = null;
    @NonNull
    private final LinearLayout y;
    private long z;

    public LayoutCameraMenuDefinitionBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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
        int i;
        long j2;
        long j3;
        synchronized (this) {
            j = this.z;
            this.z = 0L;
        }
        ObservableBoolean observableBoolean = this.f7219f;
        int i2 = 0;
        boolean z = false;
        int i3 = ((j & 3) > 0L ? 1 : ((j & 3) == 0L ? 0 : -1));
        if (i3 != 0) {
            if (observableBoolean != null) {
                z = observableBoolean.get();
            }
            if (i3 != 0) {
                if (z) {
                    j3 = j | 8;
                    j2 = 32;
                } else {
                    j3 = j | 4;
                    j2 = 16;
                }
                j = j3 | j2;
            }
            TextView textView = this.f7218d;
            i = z ? ViewDataBinding.getColorFromResource(textView, R.color.white) : ViewDataBinding.getColorFromResource(textView, R.color.camera_live_menu_selected);
            i2 = z ? ViewDataBinding.getColorFromResource(this.f7217c, R.color.camera_live_menu_selected) : ViewDataBinding.getColorFromResource(this.f7217c, R.color.white);
        } else {
            i = 0;
        }
        if ((j & 3) != 0) {
            this.f7217c.setTextColor(i2);
            this.f7218d.setTextColor(i);
        }
    }

    @Override // com.tplink.iot.databinding.LayoutCameraMenuDefinitionBinding
    public void h(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(0, observableBoolean);
        this.f7219f = observableBoolean;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(40);
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
        if (40 != i) {
            return false;
        }
        h((ObservableBoolean) obj);
        return true;
    }

    private LayoutCameraMenuDefinitionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[1], (TextView) objArr[2]);
        this.z = -1L;
        this.f7217c.setTag(null);
        this.f7218d.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.y = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
