package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

/* loaded from: classes2.dex */
public class FragmentDevicePasswordSettingBindingImpl extends FragmentDevicePasswordSettingBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p1 = null;
    @Nullable
    private static final SparseIntArray p2;
    private long H3;
    @NonNull
    private final FrameLayout p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p2 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        sparseIntArray.put(R.id.title, 4);
        sparseIntArray.put(R.id.username, 5);
        sparseIntArray.put(R.id.password, 6);
    }

    public FragmentDevicePasswordSettingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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
        PasswordSettingViewModel passwordSettingViewModel = this.z;
        ObservableBoolean observableBoolean = null;
        int i = ((10 & j) > 0L ? 1 : ((10 & j) == 0L ? 0 : -1));
        boolean z = false;
        int i2 = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (passwordSettingViewModel != null) {
                observableBoolean = passwordSettingViewModel.a;
            }
            updateRegistration(0, observableBoolean);
            if (observableBoolean != null) {
                z = observableBoolean.get();
            }
            z = ViewDataBinding.safeUnbox(Boolean.valueOf(z));
        }
        if (i2 != 0) {
            b.K(this.f6993c, Boolean.valueOf(z));
        }
        if (i != 0) {
            this.f6995f.setOnClickListener(onClickListener);
        }
    }

    @Override // com.tplink.iot.databinding.FragmentDevicePasswordSettingBinding
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

    @Override // com.tplink.iot.databinding.FragmentDevicePasswordSettingBinding
    public void i(@Nullable PasswordSettingViewModel passwordSettingViewModel) {
        this.z = passwordSettingViewModel;
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
            i((PasswordSettingViewModel) obj);
        }
        return true;
    }

    private FragmentDevicePasswordSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CameraLoadingView) objArr[2], (MaterialEditText) objArr[6], (Button) objArr[1], (TextView) objArr[4], (Toolbar) objArr[3], (MaterialEditText) objArr[5]);
        this.H3 = -1L;
        this.f6993c.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.p3 = frameLayout;
        frameLayout.setTag(null);
        this.f6995f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
