package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.iotsensor.a;
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;
import java.util.List;

/* loaded from: classes2.dex */
public class ActivitySensorDetailContentBindingImpl extends ActivitySensorDetailContentBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts O3 = null;
    @Nullable
    private static final SparseIntArray P3;
    @NonNull
    private final RelativeLayout Q3;
    @NonNull
    private final TextView R3;
    private long S3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        P3 = sparseIntArray;
        sparseIntArray.put(R.id.ll_base_info, 11);
        sparseIntArray.put(R.id.ll_toolbar, 12);
        sparseIntArray.put(R.id.iv_setting, 13);
        sparseIntArray.put(R.id.fl_top_tip, 14);
        sparseIntArray.put(R.id.card_user_device, 15);
        sparseIntArray.put(R.id.refresh_layout, 16);
        sparseIntArray.put(R.id.rv_trigger_logs, 17);
    }

    public ActivitySensorDetailContentBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, O3, P3));
    }

    private boolean l(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 2;
        }
        return true;
    }

    private boolean m(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 16;
        }
        return true;
    }

    private boolean n(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 8;
        }
        return true;
    }

    private boolean o(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 4;
        }
        return true;
    }

    private boolean p(LiveData<Integer> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 1;
        }
        return true;
    }

    private boolean q(MediatorLiveData<Boolean> mediatorLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 64;
        }
        return true;
    }

    private boolean r(LiveData<List<a>> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 32;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0170  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivitySensorDetailContentBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivitySensorDetailContentBinding
    public void h(@Nullable SensorDetailViewModel sensorDetailViewModel) {
        this.N3 = sensorDetailViewModel;
        synchronized (this) {
            this.S3 |= 128;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.S3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivitySensorDetailContentBinding
    public void i(@Nullable View.OnClickListener onClickListener) {
        this.M3 = onClickListener;
        synchronized (this) {
            this.S3 |= 256;
        }
        notifyPropertyChanged(69);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.S3 = 512L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return p((LiveData) obj, i2);
            case 1:
                return l((LiveData) obj, i2);
            case 2:
                return o((LiveData) obj, i2);
            case 3:
                return n((LiveData) obj, i2);
            case 4:
                return m((LiveData) obj, i2);
            case 5:
                return r((LiveData) obj, i2);
            case 6:
                return q((MediatorLiveData) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (15 == i) {
            h((SensorDetailViewModel) obj);
        } else if (69 != i) {
            return false;
        } else {
            i((View.OnClickListener) obj);
        }
        return true;
    }

    private ActivitySensorDetailContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (CardView) objArr[6], (CardView) objArr[15], (FrameLayout) objArr[3], (FrameLayout) objArr[14], (ImageView) objArr[1], (ImageView) objArr[4], (ImageView) objArr[13], (ImageView) objArr[7], (LinearLayout) objArr[11], (LinearLayout) objArr[12], (TPSmartRefreshLayout) objArr[16], (RecyclerView) objArr[17], (TextView) objArr[5], (TextView) objArr[9], (TextView) objArr[2], (TextView) objArr[8]);
        this.S3 = -1L;
        this.f6678c.setTag(null);
        this.f6680f.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.p0.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.Q3 = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.R3 = textView;
        textView.setTag(null);
        this.I3.setTag(null);
        this.J3.setTag(null);
        this.K3.setTag(null);
        this.L3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
