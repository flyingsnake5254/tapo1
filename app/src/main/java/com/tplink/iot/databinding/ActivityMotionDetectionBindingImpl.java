package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import com.tplink.iot.R;
import com.tplink.iot.viewmodel.ipcamera.setting.MotionDetectionViewModel;

/* loaded from: classes2.dex */
public class ActivityMotionDetectionBindingImpl extends ActivityMotionDetectionBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts Q3 = null;
    @Nullable
    private static final SparseIntArray R3;
    @NonNull
    private final NestedScrollView S3;
    private long T3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        R3 = sparseIntArray;
        sparseIntArray.put(R.id.mtb, 5);
        sparseIntArray.put(R.id.title, 6);
        sparseIntArray.put(R.id.ll_video_tampering, 7);
        sparseIntArray.put(R.id.video_motion_switch, 8);
        sparseIntArray.put(R.id.divider, 9);
        sparseIntArray.put(R.id.layout_motion_content, 10);
        sparseIntArray.put(R.id.setting_md_region_setting_entrance_layout, 11);
        sparseIntArray.put(R.id.setting_area_container, 12);
        sparseIntArray.put(R.id.setting_cover_iv, 13);
        sparseIntArray.put(R.id.no_preview_note, 14);
        sparseIntArray.put(R.id.ll_region_edit, 15);
        sparseIntArray.put(R.id.divider2, 16);
        sparseIntArray.put(R.id.sensitivity_text, 17);
        sparseIntArray.put(R.id.rl_sensitivity, 18);
    }

    public ActivityMotionDetectionBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, Q3, R3));
    }

    private boolean l(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        synchronized (this) {
            j = this.T3;
            this.T3 = 0L;
        }
        SeekBarBindingAdapter.OnStopTrackingTouch onStopTrackingTouch = this.P3;
        MotionDetectionViewModel motionDetectionViewModel = this.O3;
        int i4 = 0;
        int i5 = ((j & 13) > 0L ? 1 : ((j & 13) == 0L ? 0 : -1));
        if (i5 != 0) {
            ObservableInt observableInt = motionDetectionViewModel != null ? motionDetectionViewModel.f10772c : null;
            updateRegistration(0, observableInt);
            int i6 = observableInt != null ? observableInt.get() : 0;
            boolean z = i6 == 30;
            boolean z2 = i6 == 60;
            i4 = ViewDataBinding.safeUnbox(Integer.valueOf(i6));
            if (i6 == 0) {
                i4 = 1;
            }
            if (i5 != 0) {
                j |= z ? 512L : 256L;
            }
            if ((j & 13) != 0) {
                j |= z2 ? 32L : 16L;
            }
            if ((j & 13) != 0) {
                j |= i4 != 0 ? 128L : 64L;
            }
            if (z) {
                i2 = ViewDataBinding.getColorFromResource(this.H3, R.color.transparent_grey);
            } else {
                i2 = ViewDataBinding.getColorFromResource(this.H3, R.color.common_iot_dark_black);
            }
            TextView textView = this.p2;
            i = z2 ? ViewDataBinding.getColorFromResource(textView, R.color.transparent_grey) : ViewDataBinding.getColorFromResource(textView, R.color.common_iot_dark_black);
            if (i4 != 0) {
                i3 = ViewDataBinding.getColorFromResource(this.p3, R.color.transparent_grey);
            } else {
                i3 = ViewDataBinding.getColorFromResource(this.p3, R.color.common_iot_dark_black);
            }
        } else {
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((8 & j) != 0) {
            this.p1.setMax(60);
        }
        if ((13 & j) != 0) {
            SeekBarBindingAdapter.setProgress(this.p1, i4);
            this.p2.setTextColor(i);
            this.p3.setTextColor(i3);
            this.H3.setTextColor(i2);
        }
        if ((j & 10) != 0) {
            SeekBarBindingAdapter.setOnSeekBarChangeListener(this.p1, null, onStopTrackingTouch, null, null);
        }
    }

    @Override // com.tplink.iot.databinding.ActivityMotionDetectionBinding
    public void h(@Nullable SeekBarBindingAdapter.OnStopTrackingTouch onStopTrackingTouch) {
        this.P3 = onStopTrackingTouch;
        synchronized (this) {
            this.T3 |= 2;
        }
        notifyPropertyChanged(93);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.T3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityMotionDetectionBinding
    public void i(@Nullable MotionDetectionViewModel motionDetectionViewModel) {
        this.O3 = motionDetectionViewModel;
        synchronized (this) {
            this.T3 |= 4;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.T3 = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((ObservableInt) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (93 == i) {
            h((SeekBarBindingAdapter.OnStopTrackingTouch) obj);
        } else if (103 != i) {
            return false;
        } else {
            i((MotionDetectionViewModel) obj);
        }
        return true;
    }

    private ActivityMotionDetectionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[9], (TextView) objArr[16], (ConstraintLayout) objArr[10], (LinearLayout) objArr[15], (LinearLayout) objArr[7], (Toolbar) objArr[5], (TextView) objArr[14], (RelativeLayout) objArr[18], (SeekBar) objArr[4], (TextView) objArr[3], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[17], (FrameLayout) objArr[12], (ImageView) objArr[13], (LinearLayout) objArr[11], (TextView) objArr[6], (CheckBox) objArr[8]);
        this.T3 = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[0];
        this.S3 = nestedScrollView;
        nestedScrollView.setTag(null);
        this.p1.setTag(null);
        this.p2.setTag(null);
        this.p3.setTag(null);
        this.H3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
