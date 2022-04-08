package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.tplink.iot.R;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.yinglan.scrolllayout.ScrollLayout;

/* loaded from: classes2.dex */
public class ActivityBaseIotDeviceDetailBindingImpl extends ActivityBaseIotDeviceDetailBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts Q3;
    @Nullable
    private static final SparseIntArray R3;
    private long S3;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(18);
        Q3 = includedLayouts;
        includedLayouts.setIncludes(7, new String[]{"activity_base_iot_device_detail_bottom"}, new int[]{8}, new int[]{R.layout.activity_base_iot_device_detail_bottom});
        SparseIntArray sparseIntArray = new SparseIntArray();
        R3 = sparseIntArray;
        sparseIntArray.put(R.id.iv_bg, 9);
        sparseIntArray.put(R.id.ll_toolbar, 10);
        sparseIntArray.put(R.id.tv_music_rhythm_mode, 11);
        sparseIntArray.put(R.id.iv_setting, 12);
        sparseIntArray.put(R.id.fl_top_tip, 13);
        sparseIntArray.put(R.id.img_more_local, 14);
        sparseIntArray.put(R.id.card_user_device, 15);
        sparseIntArray.put(R.id.content_scroll_view, 16);
        sparseIntArray.put(R.id.fl_content_ext, 17);
    }

    public ActivityBaseIotDeviceDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, Q3, R3));
    }

    private boolean l(ActivityBaseIotDeviceDetailBottomBinding activityBaseIotDeviceDetailBottomBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 4;
        }
        return true;
    }

    private boolean m(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 2;
        }
        return true;
    }

    private boolean n(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 16;
        }
        return true;
    }

    private boolean o(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 1;
        }
        return true;
    }

    private boolean p(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 8;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0083  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBinding
    public void h(@Nullable IoTDetailBaseViewModel ioTDetailBaseViewModel) {
        this.O3 = ioTDetailBaseViewModel;
        synchronized (this) {
            this.S3 |= 32;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.S3 != 0) {
                return true;
            }
            return this.q.hasPendingBindings();
        }
    }

    @Override // com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBinding
    public void i(@Nullable View.OnClickListener onClickListener) {
        this.P3 = onClickListener;
        synchronized (this) {
            this.S3 |= 64;
        }
        notifyPropertyChanged(69);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.S3 = 128L;
        }
        this.q.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((LiveData) obj, i2);
        }
        if (i == 1) {
            return m((LiveData) obj, i2);
        }
        if (i == 2) {
            return l((ActivityBaseIotDeviceDetailBottomBinding) obj, i2);
        }
        if (i == 3) {
            return p((LiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return n((LiveData) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.q.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (15 == i) {
            h((IoTDetailBaseViewModel) obj);
        } else if (69 != i) {
            return false;
        } else {
            i((View.OnClickListener) obj);
        }
        return true;
    }

    private ActivityBaseIotDeviceDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (CardView) objArr[6], (CardView) objArr[15], (ScrollView) objArr[16], (ActivityBaseIotDeviceDetailBottomBinding) objArr[8], (FrameLayout) objArr[17], (FrameLayout) objArr[0], (FrameLayout) objArr[3], (FrameLayout) objArr[13], (ImageView) objArr[14], (ImageView) objArr[1], (ImageView) objArr[9], (ImageView) objArr[4], (ImageView) objArr[12], (LinearLayout) objArr[10], (ScrollLayout) objArr[7], (TextView) objArr[5], (TextView) objArr[11], (TextView) objArr[2]);
        this.S3 = -1L;
        this.f6500c.setTag(null);
        setContainedBinding(this.q);
        this.y.setTag(null);
        this.z.setTag(null);
        this.p2.setTag(null);
        this.H3.setTag(null);
        this.K3.setTag(null);
        this.L3.setTag(null);
        this.N3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
