package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

/* loaded from: classes2.dex */
public class ActivityMemoriesVideoBindingImpl extends ActivityMemoriesVideoBinding {
    @Nullable
    private static final SparseIntArray H3;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3;
    private long I3;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        p3 = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"dialog_memory_bottom_operation"}, new int[]{2}, new int[]{R.layout.dialog_memory_bottom_operation});
        SparseIntArray sparseIntArray = new SparseIntArray();
        H3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar_layout, 3);
        sparseIntArray.put(R.id.toolbar, 4);
        sparseIntArray.put(R.id.toolbar_title, 5);
        sparseIntArray.put(R.id.video_play_layout, 6);
        sparseIntArray.put(R.id.video_play_time, 7);
    }

    public ActivityMemoriesVideoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p3, H3));
    }

    private boolean h(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.I3 |= 1;
        }
        return true;
    }

    private boolean i(DialogMemoryBottomOperationBinding dialogMemoryBottomOperationBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.I3 |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.I3;
            this.I3 = 0L;
        }
        ObservableBoolean observableBoolean = null;
        MemoriesViewModel memoriesViewModel = this.p2;
        g gVar = this.p1;
        boolean z = false;
        int i = ((j & 21) > 0L ? 1 : ((j & 21) == 0L ? 0 : -1));
        if (i != 0) {
            if (memoriesViewModel != null) {
                observableBoolean = memoriesViewModel.o;
            }
            updateRegistration(0, observableBoolean);
            if (observableBoolean != null) {
                z = observableBoolean.get();
            }
            if (i != 0) {
                j |= z ? 64L : 32L;
            }
        }
        int i2 = ((24 & j) > 0L ? 1 : ((24 & j) == 0L ? 0 : -1));
        if ((21 & j) != 0) {
            b.K(this.f6621c, Boolean.valueOf(z));
        }
        if (i2 != 0) {
            this.p0.i(gVar);
        }
        if ((j & 20) != 0) {
            this.p0.h(memoriesViewModel);
        }
        ViewDataBinding.executeBindingsOn(this.p0);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.I3 != 0) {
                return true;
            }
            return this.p0.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.I3 = 16L;
        }
        this.p0.invalidateAll();
        requestRebind();
    }

    public void l(@Nullable MemoriesViewModel memoriesViewModel) {
        this.p2 = memoriesViewModel;
        synchronized (this) {
            this.I3 |= 4;
        }
        notifyPropertyChanged(62);
        super.requestRebind();
    }

    public void m(@Nullable g gVar) {
        this.p1 = gVar;
        synchronized (this) {
            this.I3 |= 8;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return h((ObservableBoolean) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return i((DialogMemoryBottomOperationBinding) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.p0.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (62 == i) {
            l((MemoriesViewModel) obj);
        } else if (79 != i) {
            return false;
        } else {
            m((g) obj);
        }
        return true;
    }

    private ActivityMemoriesVideoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (CameraLoadingView) objArr[1], (RelativeLayout) objArr[0], (Toolbar) objArr[4], (AppBarLayout) objArr[3], (TextView) objArr[5], (FrameLayout) objArr[6], (TextView) objArr[7], (DialogMemoryBottomOperationBinding) objArr[2]);
        this.I3 = -1L;
        this.f6621c.setTag(null);
        this.f6622d.setTag(null);
        setContainedBinding(this.p0);
        setRootTag(view);
        invalidateAll();
    }
}
