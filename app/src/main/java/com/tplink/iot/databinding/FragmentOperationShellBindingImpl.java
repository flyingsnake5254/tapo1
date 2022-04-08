package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.base.b;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes2.dex */
public class FragmentOperationShellBindingImpl extends FragmentOperationShellBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p0 = null;
    @Nullable
    private static final SparseIntArray p1;
    @NonNull
    private final ConstraintLayout p2;
    private long p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p1 = sparseIntArray;
        sparseIntArray.put(R.id.back_tv, 2);
        sparseIntArray.put(R.id.guideline_1, 3);
        sparseIntArray.put(R.id.guideline_2, 4);
        sparseIntArray.put(R.id.magic_indicator, 5);
        sparseIntArray.put(R.id.view_pager, 6);
    }

    public FragmentOperationShellBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, p0, p1));
    }

    private boolean i(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.p3;
            this.p3 = 0L;
        }
        boolean z = false;
        Boolean bool = null;
        MutableLiveData<Boolean> mutableLiveData = this.z;
        int i = ((j & 3) > 0L ? 1 : ((j & 3) == 0L ? 0 : -1));
        if (i != 0) {
            if (mutableLiveData != null) {
                bool = mutableLiveData.getValue();
            }
            z = ViewDataBinding.safeUnbox(bool);
        }
        if (i != 0) {
            b.Q(this.x, z);
        }
    }

    @Override // com.tplink.iot.databinding.FragmentOperationShellBinding
    public void h(@Nullable MutableLiveData<Boolean> mutableLiveData) {
        updateLiveDataRegistration(0, mutableLiveData);
        this.z = mutableLiveData;
        synchronized (this) {
            this.p3 |= 1;
        }
        notifyPropertyChanged(87);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p3 = 2L;
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
        if (87 != i) {
            return false;
        }
        h((MutableLiveData) obj);
        return true;
    }

    private FragmentOperationShellBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[2], (Guideline) objArr[3], (Guideline) objArr[4], (MagicIndicator) objArr[5], (ImageView) objArr[1], (ViewPager) objArr[6]);
        this.p3 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.p2 = constraintLayout;
        constraintLayout.setTag(null);
        this.x.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
