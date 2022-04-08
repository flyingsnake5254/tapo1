package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel;

/* loaded from: classes2.dex */
public class DialogSelectDeviceBindingImpl extends DialogSelectDeviceBinding {
    @Nullable
    private static final SparseIntArray p0;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts z = null;
    @NonNull
    private final ConstraintLayout p1;
    private long p2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p0 = sparseIntArray;
        sparseIntArray.put(R.id.select_all_btn, 2);
        sparseIntArray.put(R.id.title, 3);
        sparseIntArray.put(R.id.top_divider, 4);
        sparseIntArray.put(R.id.recycler_view, 5);
    }

    public DialogSelectDeviceBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, z, p0));
    }

    private boolean i(MutableLiveData<Integer> mutableLiveData, int i) {
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
        String str;
        synchronized (this) {
            j = this.p2;
            this.p2 = 0L;
        }
        SelectDeviceViewModel selectDeviceViewModel = this.y;
        float f2 = 0.0f;
        boolean z2 = false;
        int i = ((j & 7) > 0L ? 1 : ((j & 7) == 0L ? 0 : -1));
        if (i != 0) {
            MutableLiveData<Integer> n = selectDeviceViewModel != null ? selectDeviceViewModel.n() : null;
            updateLiveDataRegistration(0, n);
            int safeUnbox = ViewDataBinding.safeUnbox(n != null ? n.getValue() : null);
            if (safeUnbox > 32) {
                z2 = true;
            }
            if (i != 0) {
                j |= z2 ? 16L : 8L;
            }
            str = selectDeviceViewModel != null ? selectDeviceViewModel.j(safeUnbox) : null;
            f2 = z2 ? 0.4f : 1.0f;
        } else {
            str = null;
        }
        if ((j & 7) != 0) {
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.f6807c.setAlpha(f2);
            }
            TextViewBindingAdapter.setText(this.f6807c, str);
            b.c(this.f6807c, Boolean.valueOf(z2), null);
        }
    }

    @Override // com.tplink.iot.databinding.DialogSelectDeviceBinding
    public void h(@Nullable SelectDeviceViewModel selectDeviceViewModel) {
        this.y = selectDeviceViewModel;
        synchronized (this) {
            this.p2 |= 2;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
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
            this.p2 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return i((MutableLiveData) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (103 != i) {
            return false;
        }
        h((SelectDeviceViewModel) obj);
        return true;
    }

    private DialogSelectDeviceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[1], (RecyclerView) objArr[5], (TextView) objArr[2], (TextView) objArr[3], (View) objArr[4]);
        this.p2 = -1L;
        this.f6807c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.p1 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
