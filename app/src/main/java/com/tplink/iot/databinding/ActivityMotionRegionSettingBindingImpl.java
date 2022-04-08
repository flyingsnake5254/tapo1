package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.viewmodel.ipcamera.setting.MotionDetectionViewModel;

/* loaded from: classes2.dex */
public class ActivityMotionRegionSettingBindingImpl extends ActivityMotionRegionSettingBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts U3 = null;
    @Nullable
    private static final SparseIntArray V3;
    private long W3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        V3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 8);
        sparseIntArray.put(R.id.title, 9);
        sparseIntArray.put(R.id.setting_area_title_tv, 10);
        sparseIntArray.put(R.id.setting_area_container, 11);
        sparseIntArray.put(R.id.setting_cover_iv, 12);
        sparseIntArray.put(R.id.action_region, 13);
    }

    public ActivityMotionRegionSettingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, U3, V3));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.W3 |= 4;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.W3 |= 1;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.W3 |= 2;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityMotionRegionSettingBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityMotionRegionSettingBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.T3 = onClickListener;
        synchronized (this) {
            this.W3 |= 8;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.W3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityMotionRegionSettingBinding
    public void i(@Nullable MotionDetectionViewModel motionDetectionViewModel) {
        this.S3 = motionDetectionViewModel;
        synchronized (this) {
            this.W3 |= 16;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.W3 = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return n((ObservableBoolean) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return l((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (55 == i) {
            h((View.OnClickListener) obj);
        } else if (103 != i) {
            return false;
        } else {
            i((MotionDetectionViewModel) obj);
        }
        return true;
    }

    private ActivityMotionRegionSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (View) objArr[13], (View) objArr[6], null, (FrameLayout) objArr[5], null, (FrameLayout) objArr[4], null, (View) objArr[3], null, null, (FrameLayout) objArr[2], null, null, null, (ImageView) objArr[1], (View) objArr[0], (FrameLayout) objArr[11], (TextView) objArr[10], (ImageView) objArr[12], (TextView) objArr[7], (TextView) objArr[9], (Toolbar) objArr[8]);
        this.W3 = -1L;
        this.f6631d.setTag(null);
        this.q.setTag(null);
        this.y.setTag(null);
        this.p0.setTag(null);
        this.p3.setTag(null);
        this.K3.setTag(null);
        this.L3.setTag(null);
        this.P3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
