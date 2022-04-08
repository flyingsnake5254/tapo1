package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.play.LensMaskViewModel;

/* loaded from: classes2.dex */
public class ActivityPrivacyModeBindingImpl extends ActivityPrivacyModeBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p1 = null;
    @Nullable
    private static final SparseIntArray p2;
    private long H3;
    @NonNull
    private final ConstraintLayout p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p2 = sparseIntArray;
        sparseIntArray.put(R.id.privacy_mode_item_bg, 3);
        sparseIntArray.put(R.id.textView8, 4);
        sparseIntArray.put(R.id.textView9, 5);
    }

    public ActivityPrivacyModeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, p1, p2));
    }

    private boolean l(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H3 |= 1;
        }
        return true;
    }

    private boolean m(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H3 |= 2;
        }
        return true;
    }

    private boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H3 |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        synchronized (this) {
            j = this.H3;
            this.H3 = 0L;
        }
        LensMaskViewModel lensMaskViewModel = this.y;
        boolean z2 = false;
        if ((54 & j) != 0) {
            Boolean bool = null;
            if ((j & 50) != 0) {
                MutableLiveData<Boolean> mutableLiveData = lensMaskViewModel != null ? lensMaskViewModel.f10527c : null;
                updateLiveDataRegistration(1, mutableLiveData);
                z = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            } else {
                z = false;
            }
            if ((j & 52) != 0) {
                MutableLiveData<Boolean> mutableLiveData2 = lensMaskViewModel != null ? lensMaskViewModel.f10528d : null;
                updateLiveDataRegistration(2, mutableLiveData2);
                if (mutableLiveData2 != null) {
                    bool = mutableLiveData2.getValue();
                }
                z2 = ViewDataBinding.safeUnbox(bool);
            }
        } else {
            z = false;
        }
        if ((52 & j) != 0) {
            b.K(this.f6654c, Boolean.valueOf(z2));
        }
        if ((j & 50) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.f6656f, z);
        }
    }

    @Override // com.tplink.iot.databinding.ActivityPrivacyModeBinding
    public void h(@Nullable String str) {
        this.p0 = str;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.H3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityPrivacyModeBinding
    public void i(@Nullable LensMaskViewModel lensMaskViewModel) {
        this.y = lensMaskViewModel;
        synchronized (this) {
            this.H3 |= 16;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.H3 = 32L;
        }
        requestRebind();
    }

    public void o(@Nullable LiveData<Boolean> liveData) {
        this.z = liveData;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return l((LiveData) obj, i2);
        }
        if (i == 1) {
            return m((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (57 == i) {
            o((LiveData) obj);
        } else if (60 == i) {
            h((String) obj);
        } else if (103 != i) {
            return false;
        } else {
            i((LensMaskViewModel) obj);
        }
        return true;
    }

    private ActivityPrivacyModeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (CameraLoadingView) objArr[2], (View) objArr[3], (CheckBox) objArr[1], (TextView) objArr[4], (TextView) objArr[5]);
        this.H3 = -1L;
        this.f6654c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.p3 = constraintLayout;
        constraintLayout.setTag(null);
        this.f6656f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
