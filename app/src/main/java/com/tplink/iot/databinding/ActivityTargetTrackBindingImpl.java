package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.targettrack.TargetTrackViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

/* loaded from: classes2.dex */
public class ActivityTargetTrackBindingImpl extends ActivityTargetTrackBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p0 = null;
    @Nullable
    private static final SparseIntArray p1;
    private long H3;
    @NonNull
    private final LinearLayout p2;
    @NonNull
    private final CameraLoadingView p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p1 = sparseIntArray;
        sparseIntArray.put(R.id.textView8, 3);
        sparseIntArray.put(R.id.target_track_tip_tv, 4);
        sparseIntArray.put(R.id.target_track_care_title_tv, 5);
        sparseIntArray.put(R.id.target_track_care_rl, 6);
        sparseIntArray.put(R.id.target_track_human_switch, 7);
    }

    public ActivityTargetTrackBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p0, p1));
    }

    private boolean i(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H3 |= 2;
        }
        return true;
    }

    private boolean l(MutableLiveData<Boolean> mutableLiveData, int i) {
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
        boolean z;
        synchronized (this) {
            j = this.H3;
            this.H3 = 0L;
        }
        TargetTrackViewModel targetTrackViewModel = this.z;
        boolean z2 = false;
        if ((15 & j) != 0) {
            Boolean bool = null;
            if ((j & 13) != 0) {
                MutableLiveData<Boolean> r = targetTrackViewModel != null ? targetTrackViewModel.r() : null;
                updateLiveDataRegistration(0, r);
                z = ViewDataBinding.safeUnbox(r != null ? r.getValue() : null);
            } else {
                z = false;
            }
            if ((j & 14) != 0) {
                MutableLiveData<Boolean> w = targetTrackViewModel != null ? targetTrackViewModel.w() : null;
                updateLiveDataRegistration(1, w);
                if (w != null) {
                    bool = w.getValue();
                }
                z2 = ViewDataBinding.safeUnbox(bool);
            }
        } else {
            z = false;
        }
        if ((14 & j) != 0) {
            b.K(this.p3, Boolean.valueOf(z2));
        }
        if ((j & 13) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.q, z);
        }
    }

    @Override // com.tplink.iot.databinding.ActivityTargetTrackBinding
    public void h(@Nullable TargetTrackViewModel targetTrackViewModel) {
        this.z = targetTrackViewModel;
        synchronized (this) {
            this.H3 |= 4;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.H3 != 0;
        }
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
        if (i == 0) {
            return l((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return i((MutableLiveData) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (103 != i) {
            return false;
        }
        h((TargetTrackViewModel) obj);
        return true;
    }

    private ActivityTargetTrackBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (RelativeLayout) objArr[6], (TextView) objArr[5], (CheckBox) objArr[7], (NoninteractiveCheckBox) objArr[1], (TextView) objArr[4], (TextView) objArr[3]);
        this.H3 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p2 = linearLayout;
        linearLayout.setTag(null);
        CameraLoadingView cameraLoadingView = (CameraLoadingView) objArr[2];
        this.p3 = cameraLoadingView;
        cameraLoadingView.setTag(null);
        this.q.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
