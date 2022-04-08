package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.lifecycle.LiveData;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerCardView;

/* loaded from: classes2.dex */
public class ViewCloudTerraceControlSensitivityPanelBindingImpl extends ViewCloudTerraceControlSensitivityPanelBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p0 = null;
    @Nullable
    private static final SparseIntArray p1 = null;
    private OnStopTrackingTouchImpl p2;
    private long p3;

    /* loaded from: classes2.dex */
    public static class OnStopTrackingTouchImpl implements SeekBarBindingAdapter.OnStopTrackingTouch {

        /* renamed from: c  reason: collision with root package name */
        private SeekBarBindingAdapter.OnStopTrackingTouch f7349c;

        public OnStopTrackingTouchImpl a(SeekBarBindingAdapter.OnStopTrackingTouch onStopTrackingTouch) {
            this.f7349c = onStopTrackingTouch;
            if (onStopTrackingTouch == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch
        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f7349c.onStopTrackingTouch(seekBar);
        }
    }

    public ViewCloudTerraceControlSensitivityPanelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, p0, p1));
    }

    private boolean l(LiveData<Integer> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        OnStopTrackingTouchImpl onStopTrackingTouchImpl;
        synchronized (this) {
            j = this.p3;
            this.p3 = 0L;
        }
        LiveData<Integer> liveData = this.y;
        SeekBarBindingAdapter.OnStopTrackingTouch onStopTrackingTouch = this.z;
        int i4 = 0;
        int i5 = ((j & 5) > 0L ? 1 : ((j & 5) == 0L ? 0 : -1));
        if (i5 != 0) {
            i3 = ViewDataBinding.safeUnbox(liveData != null ? liveData.getValue() : null);
            boolean z = i3 == 50;
            boolean z2 = i3 == 0;
            if (i3 == 100) {
                i4 = 1;
            }
            if (i5 != 0) {
                j |= z ? 64L : 32L;
            }
            if ((j & 5) != 0) {
                j |= z2 ? 16L : 8L;
            }
            if ((j & 5) != 0) {
                j |= i4 != 0 ? 256L : 128L;
            }
            if (z) {
                i2 = ViewDataBinding.getColorFromResource(this.x, R.color.common_iot_main_blue);
            } else {
                i2 = ViewDataBinding.getColorFromResource(this.x, R.color.common_iot_light_gray);
            }
            if (z2) {
                i4 = ViewDataBinding.getColorFromResource(this.q, R.color.common_iot_main_blue);
            } else {
                i4 = ViewDataBinding.getColorFromResource(this.q, R.color.common_iot_light_gray);
            }
            if (i4 != 0) {
                i = ViewDataBinding.getColorFromResource(this.f7348f, R.color.common_iot_main_blue);
            } else {
                i = ViewDataBinding.getColorFromResource(this.f7348f, R.color.common_iot_light_gray);
            }
        } else {
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        int i6 = ((6 & j) > 0L ? 1 : ((6 & j) == 0L ? 0 : -1));
        if (i6 == 0 || onStopTrackingTouch == null) {
            onStopTrackingTouchImpl = null;
        } else {
            OnStopTrackingTouchImpl onStopTrackingTouchImpl2 = this.p2;
            if (onStopTrackingTouchImpl2 == null) {
                onStopTrackingTouchImpl2 = new OnStopTrackingTouchImpl();
                this.p2 = onStopTrackingTouchImpl2;
            }
            onStopTrackingTouchImpl = onStopTrackingTouchImpl2.a(onStopTrackingTouch);
        }
        if ((j & 5) != 0) {
            SeekBarBindingAdapter.setProgress(this.f7347d, i3);
            this.f7348f.setTextColor(i);
            this.q.setTextColor(i4);
            this.x.setTextColor(i2);
        }
        if (i6 != 0) {
            SeekBarBindingAdapter.setOnSeekBarChangeListener(this.f7347d, null, onStopTrackingTouchImpl, null, null);
        }
    }

    @Override // com.tplink.iot.databinding.ViewCloudTerraceControlSensitivityPanelBinding
    public void h(@Nullable LiveData<Integer> liveData) {
        updateLiveDataRegistration(0, liveData);
        this.y = liveData;
        synchronized (this) {
            this.p3 |= 1;
        }
        notifyPropertyChanged(88);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ViewCloudTerraceControlSensitivityPanelBinding
    public void i(@Nullable SeekBarBindingAdapter.OnStopTrackingTouch onStopTrackingTouch) {
        this.z = onStopTrackingTouch;
        synchronized (this) {
            this.p3 |= 2;
        }
        notifyPropertyChanged(93);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p3 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((LiveData) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (88 == i) {
            h((LiveData) obj);
        } else if (93 != i) {
            return false;
        } else {
            i((SeekBarBindingAdapter.OnStopTrackingTouch) obj);
        }
        return true;
    }

    private ViewCloudTerraceControlSensitivityPanelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TouchListenerCardView) objArr[0], (SeekBar) objArr[4], (TextView) objArr[3], (TextView) objArr[1], (TextView) objArr[2]);
        this.p3 = -1L;
        this.f7346c.setTag(null);
        this.f7347d.setTag(null);
        this.f7348f.setTag(null);
        this.q.setTag(null);
        this.x.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
