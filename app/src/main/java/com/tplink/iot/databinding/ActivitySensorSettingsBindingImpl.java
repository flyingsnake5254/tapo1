package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.tplink.iot.R;
import com.tplink.iot.viewmodel.iotsensor.SensorSettingViewModel;
import com.tplink.iot.widget.ItemSettingLayout;

/* loaded from: classes2.dex */
public class ActivitySensorSettingsBindingImpl extends ActivitySensorSettingsBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts N3 = null;
    @Nullable
    private static final SparseIntArray O3;
    @NonNull
    private final LinearLayout P3;
    @NonNull
    private final View Q3;
    private long R3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O3 = sparseIntArray;
        sparseIntArray.put(R.id.ll_content, 11);
        sparseIntArray.put(R.id.item_icon_hint, 12);
        sparseIntArray.put(R.id.right_arrow, 13);
        sparseIntArray.put(R.id.right_arrow_device_info, 14);
        sparseIntArray.put(R.id.item_remote_control, 15);
        sparseIntArray.put(R.id.right_arrow_remote_control, 16);
    }

    public ActivitySensorSettingsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, N3, O3));
    }

    private boolean l(LiveData<Integer> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 16;
        }
        return true;
    }

    private boolean m(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 128;
        }
        return true;
    }

    private boolean n(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 32;
        }
        return true;
    }

    private boolean o(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 8;
        }
        return true;
    }

    private boolean p(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 1;
        }
        return true;
    }

    private boolean q(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 256;
        }
        return true;
    }

    private boolean r(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 4;
        }
        return true;
    }

    private boolean s(LiveData<Integer> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 64;
        }
        return true;
    }

    private boolean t(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 2;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0128  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 605
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivitySensorSettingsBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivitySensorSettingsBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.L3 = onClickListener;
        synchronized (this) {
            this.R3 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(69);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.R3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivitySensorSettingsBinding
    public void i(@Nullable SensorSettingViewModel sensorSettingViewModel) {
        this.M3 = sensorSettingViewModel;
        synchronized (this) {
            this.R3 |= 512;
        }
        notifyPropertyChanged(89);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.R3 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return p((ObservableBoolean) obj, i2);
            case 1:
                return t((LiveData) obj, i2);
            case 2:
                return r((LiveData) obj, i2);
            case 3:
                return o((LiveData) obj, i2);
            case 4:
                return l((LiveData) obj, i2);
            case 5:
                return n((LiveData) obj, i2);
            case 6:
                return s((LiveData) obj, i2);
            case 7:
                return m((LiveData) obj, i2);
            case 8:
                return q((LiveData) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (89 == i) {
            i((SensorSettingViewModel) obj);
        } else if (69 != i) {
            return false;
        } else {
            h((View.OnClickListener) obj);
        }
        return true;
    }

    private ActivitySensorSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (Button) objArr[10], (ConstraintLayout) objArr[1], (RelativeLayout) objArr[8], (ItemSettingLayout) objArr[9], (TextView) objArr[12], (ItemSettingLayout) objArr[4], (ItemSettingLayout) objArr[3], (RelativeLayout) objArr[15], (ItemSettingLayout) objArr[7], (ItemSettingLayout) objArr[6], (LinearLayout) objArr[11], (ImageView) objArr[2], (ImageView) objArr[13], (ImageView) objArr[14], (ImageView) objArr[16]);
        this.R3 = -1L;
        this.f6687c.setTag(null);
        this.f6688d.setTag(null);
        this.f6689f.setTag(null);
        this.q.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.p1.setTag(null);
        this.p2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.P3 = linearLayout;
        linearLayout.setTag(null);
        View view2 = (View) objArr[5];
        this.Q3 = view2;
        view2.setTag(null);
        this.H3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
