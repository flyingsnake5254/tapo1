package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.AbsSpinnerBindingAdapter;
import androidx.databinding.adapters.AdapterViewBindingAdapter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tplink.iot.R;
import com.tplink.iot.view.iotcommon.DebugFwUpdateViewModel;

/* loaded from: classes2.dex */
public class ActivityDebugFwUpdateBindingImpl extends ActivityDebugFwUpdateBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts e4 = null;
    @Nullable
    private static final SparseIntArray f4;
    @NonNull
    private final LinearLayout g4;
    private InverseBindingListener h4;
    private long i4;

    /* loaded from: classes2.dex */
    class a implements InverseBindingListener {
        a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            int selectedItemPosition = ActivityDebugFwUpdateBindingImpl.this.N3.getSelectedItemPosition();
            DebugFwUpdateViewModel debugFwUpdateViewModel = ActivityDebugFwUpdateBindingImpl.this.d4;
            boolean z = true;
            if (debugFwUpdateViewModel != null) {
                ObservableInt i = debugFwUpdateViewModel.i();
                if (i == null) {
                    z = false;
                }
                if (z) {
                    i.set(selectedItemPosition);
                }
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f4 = sparseIntArray;
        sparseIntArray.put(R.id.tv_connection_title, 2);
        sparseIntArray.put(R.id.ll_connection, 3);
        sparseIntArray.put(R.id.tv_connection_type, 4);
        sparseIntArray.put(R.id.tv_fw_title, 5);
        sparseIntArray.put(R.id.til_ip, 6);
        sparseIntArray.put(R.id.et_ip, 7);
        sparseIntArray.put(R.id.til_port, 8);
        sparseIntArray.put(R.id.et_port, 9);
        sparseIntArray.put(R.id.til_file, 10);
        sparseIntArray.put(R.id.et_file, 11);
        sparseIntArray.put(R.id.ll_clip_btn, 12);
        sparseIntArray.put(R.id.btn_copy, 13);
        sparseIntArray.put(R.id.btn_paste, 14);
        sparseIntArray.put(R.id.progress_bar, 15);
        sparseIntArray.put(R.id.tv_progress, 16);
        sparseIntArray.put(R.id.btn_download, 17);
        sparseIntArray.put(R.id.tv_env_title, 18);
        sparseIntArray.put(R.id.btn_switch_env, 19);
        sparseIntArray.put(R.id.tv_wlan_title, 20);
        sparseIntArray.put(R.id.til_wlan_ssid, 21);
        sparseIntArray.put(R.id.et_wlan_ssid, 22);
        sparseIntArray.put(R.id.til_wlan_psd, 23);
        sparseIntArray.put(R.id.et_wlan_psd, 24);
        sparseIntArray.put(R.id.til_wlan_type, 25);
        sparseIntArray.put(R.id.et_wlan_type, 26);
        sparseIntArray.put(R.id.btn_change_wlan, 27);
        sparseIntArray.put(R.id.tv_time_title, 28);
        sparseIntArray.put(R.id.ll_time, 29);
        sparseIntArray.put(R.id.tv_device_time, 30);
        sparseIntArray.put(R.id.btn_get_time, 31);
        sparseIntArray.put(R.id.tv_thing_model_title, 32);
        sparseIntArray.put(R.id.btn_view_thing_model, 33);
    }

    public ActivityDebugFwUpdateBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 34, e4, f4));
    }

    private boolean i(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.i4;
            this.i4 = 0L;
        }
        DebugFwUpdateViewModel debugFwUpdateViewModel = this.d4;
        int i = 0;
        int i2 = ((7 & j) > 0L ? 1 : ((7 & j) == 0L ? 0 : -1));
        if (i2 != 0) {
            ObservableInt i3 = debugFwUpdateViewModel != null ? debugFwUpdateViewModel.i() : null;
            updateRegistration(0, i3);
            if (i3 != null) {
                i = i3.get();
            }
        }
        if ((j & 4) != 0) {
            AbsSpinnerBindingAdapter.setEntries(this.N3, DebugFwUpdateViewModel.a);
            AdapterViewBindingAdapter.setOnItemSelectedListener(this.N3, null, null, this.h4);
        }
        if (i2 != 0) {
            AdapterViewBindingAdapter.setSelectedItemPosition(this.N3, i);
        }
    }

    @Override // com.tplink.iot.databinding.ActivityDebugFwUpdateBinding
    public void h(@Nullable DebugFwUpdateViewModel debugFwUpdateViewModel) {
        this.d4 = debugFwUpdateViewModel;
        synchronized (this) {
            this.i4 |= 2;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i4 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i4 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return i((ObservableInt) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (103 != i) {
            return false;
        }
        h((DebugFwUpdateViewModel) obj);
        return true;
    }

    private ActivityDebugFwUpdateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[27], (Button) objArr[13], (Button) objArr[17], (Button) objArr[31], (Button) objArr[14], (Button) objArr[19], (Button) objArr[33], (TextInputEditText) objArr[11], (TextInputEditText) objArr[7], (TextInputEditText) objArr[9], (TextInputEditText) objArr[24], (TextInputEditText) objArr[22], (TextInputEditText) objArr[26], (LinearLayout) objArr[12], (LinearLayout) objArr[3], (LinearLayout) objArr[29], (ProgressBar) objArr[15], (Spinner) objArr[1], (TextInputLayout) objArr[10], (TextInputLayout) objArr[6], (TextInputLayout) objArr[8], (TextInputLayout) objArr[23], (TextInputLayout) objArr[21], (TextInputLayout) objArr[25], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[30], (TextView) objArr[18], (TextView) objArr[5], (TextView) objArr[16], (TextView) objArr[32], (TextView) objArr[28], (TextView) objArr[20]);
        this.h4 = new a();
        this.i4 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.g4 = linearLayout;
        linearLayout.setTag(null);
        this.N3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
