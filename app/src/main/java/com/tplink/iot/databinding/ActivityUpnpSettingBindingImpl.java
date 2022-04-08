package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.LiveData;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.UpnpSettingViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

/* loaded from: classes2.dex */
public class ActivityUpnpSettingBindingImpl extends ActivityUpnpSettingBinding {
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
        sparseIntArray.put(R.id.setting_record_audio_bg, 3);
        sparseIntArray.put(R.id.textView8, 4);
        sparseIntArray.put(R.id.textView9, 5);
    }

    public ActivityUpnpSettingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, p0, p1));
    }

    private boolean i(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 1;
        }
        return true;
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 2;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        synchronized (this) {
            j = this.p3;
            this.p3 = 0L;
        }
        UpnpSettingViewModel upnpSettingViewModel = this.y;
        boolean z2 = false;
        if ((30 & j) != 0) {
            ObservableBoolean observableBoolean = null;
            if ((j & 26) != 0) {
                ObservableBoolean observableBoolean2 = upnpSettingViewModel != null ? upnpSettingViewModel.f10840b : null;
                updateRegistration(1, observableBoolean2);
                z = ViewDataBinding.safeUnbox(Boolean.valueOf(observableBoolean2 != null ? observableBoolean2.get() : false));
            } else {
                z = false;
            }
            if ((j & 28) != 0) {
                if (upnpSettingViewModel != null) {
                    observableBoolean = upnpSettingViewModel.a;
                }
                updateRegistration(2, observableBoolean);
                if (observableBoolean != null) {
                    z2 = observableBoolean.get();
                }
                z2 = ViewDataBinding.safeUnbox(Boolean.valueOf(z2));
            }
        } else {
            z = false;
        }
        if ((28 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.f6759c, z2);
        }
        if ((j & 26) != 0) {
            b.K(this.f6760d, Boolean.valueOf(z));
        }
    }

    @Override // com.tplink.iot.databinding.ActivityUpnpSettingBinding
    public void h(@Nullable UpnpSettingViewModel upnpSettingViewModel) {
        this.y = upnpSettingViewModel;
        synchronized (this) {
            this.p3 |= 8;
        }
        notifyPropertyChanged(103);
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
            this.p3 = 16L;
        }
        requestRebind();
    }

    public void n(@Nullable LiveData<Boolean> liveData) {
        this.z = liveData;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return i((LiveData) obj, i2);
        }
        if (i == 1) {
            return l((ObservableBoolean) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (57 == i) {
            n((LiveData) obj);
        } else if (103 != i) {
            return false;
        } else {
            h((UpnpSettingViewModel) obj);
        }
        return true;
    }

    private ActivityUpnpSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (NoninteractiveCheckBox) objArr[1], (CameraLoadingView) objArr[2], (View) objArr[3], (TextView) objArr[4], (TextView) objArr[5]);
        this.p3 = -1L;
        this.f6759c.setTag(null);
        this.f6760d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.p2 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
