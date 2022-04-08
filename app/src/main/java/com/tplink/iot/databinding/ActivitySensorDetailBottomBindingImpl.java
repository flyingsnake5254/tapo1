package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import com.tplink.iot.R;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.yinglan.scrolllayout.content.ContentScrollView;

/* loaded from: classes2.dex */
public class ActivitySensorDetailBottomBindingImpl extends ActivitySensorDetailBottomBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts K3 = null;
    @Nullable
    private static final SparseIntArray L3;
    private long M3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L3 = sparseIntArray;
        sparseIntArray.put(R.id.arrow_smart_scene, 8);
        sparseIntArray.put(R.id.divider_line, 9);
        sparseIntArray.put(R.id.arrow_share, 10);
        sparseIntArray.put(R.id.arrow_help, 11);
    }

    public ActivitySensorDetailBottomBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, K3, L3));
    }

    private boolean l(LiveData<Integer> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 32;
        }
        return true;
    }

    private boolean m(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 16;
        }
        return true;
    }

    private boolean n(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 8;
        }
        return true;
    }

    private boolean o(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 4;
        }
        return true;
    }

    private boolean p(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 1;
        }
        return true;
    }

    private boolean q(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        float f2;
        float f3;
        float f4;
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        float f5;
        boolean z7;
        boolean z8;
        long j2;
        synchronized (this) {
            j = this.M3;
            this.M3 = 0L;
        }
        SensorDetailViewModel sensorDetailViewModel = this.J3;
        View.OnClickListener onClickListener = this.I3;
        float f6 = 0.0f;
        if ((383 & j) != 0) {
            if ((j & 321) != 0) {
                LiveData<Boolean> L = sensorDetailViewModel != null ? sensorDetailViewModel.L() : null;
                updateLiveDataRegistration(0, L);
                z5 = ViewDataBinding.safeUnbox(Boolean.valueOf(!ViewDataBinding.safeUnbox(L != null ? L.getValue() : null)));
            } else {
                z5 = false;
            }
            z4 = ((j & 320) == 0 || sensorDetailViewModel == null) ? false : sensorDetailViewModel.N();
            f6 = 1.0f;
            int i = ((j & 322) > 0L ? 1 : ((j & 322) == 0L ? 0 : -1));
            if (i != 0) {
                LiveData<Boolean> M = sensorDetailViewModel != null ? sensorDetailViewModel.M() : null;
                updateLiveDataRegistration(1, M);
                z7 = ViewDataBinding.safeUnbox(M != null ? M.getValue() : null);
                if (i != 0) {
                    j |= z7 ? 16384L : 8192L;
                }
                f5 = z7 ? 1.0f : 0.5f;
            } else {
                z7 = false;
                f5 = 0.0f;
            }
            int i2 = ((j & 324) > 0L ? 1 : ((j & 324) == 0L ? 0 : -1));
            if (i2 != 0) {
                LiveData<Boolean> K = sensorDetailViewModel != null ? sensorDetailViewModel.K() : null;
                updateLiveDataRegistration(2, K);
                boolean safeUnbox = ViewDataBinding.safeUnbox(K != null ? K.getValue() : null);
                if (i2 != 0) {
                    j |= safeUnbox ? PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : 512L;
                }
                f3 = safeUnbox ? 0.5f : 1.0f;
                z2 = ViewDataBinding.safeUnbox(Boolean.valueOf(true ^ safeUnbox));
            } else {
                z2 = false;
                f3 = 0.0f;
            }
            int i3 = ((j & 328) > 0L ? 1 : ((j & 328) == 0L ? 0 : -1));
            if (i3 != 0) {
                LiveData<Boolean> H = sensorDetailViewModel != null ? sensorDetailViewModel.H() : null;
                updateLiveDataRegistration(3, H);
                z = ViewDataBinding.safeUnbox(H != null ? H.getValue() : null);
                if (i3 != 0) {
                    j |= z ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                }
                if (!z) {
                    f6 = 0.5f;
                }
            } else {
                z = false;
            }
            if ((j & 336) != 0) {
                LiveData<Boolean> G = sensorDetailViewModel != null ? sensorDetailViewModel.G() : null;
                updateLiveDataRegistration(4, G);
                z8 = ViewDataBinding.safeUnbox(G != null ? G.getValue() : null);
                j2 = 352;
            } else {
                j2 = 352;
                z8 = false;
            }
            if ((j & j2) != 0) {
                LiveData<Integer> y = sensorDetailViewModel != null ? sensorDetailViewModel.y() : null;
                updateLiveDataRegistration(5, y);
                str = String.valueOf(ViewDataBinding.safeUnbox(y != null ? y.getValue() : null));
                z6 = z7;
                f4 = f6;
                z3 = z8;
                f2 = f5;
            } else {
                z6 = z7;
                f4 = f6;
                z3 = z8;
                f2 = f5;
                str = null;
            }
        } else {
            z6 = false;
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
            str = null;
            f4 = 0.0f;
            f3 = 0.0f;
            f2 = 0.0f;
        }
        int i4 = ((j & 384) > 0L ? 1 : ((j & 384) == 0L ? 0 : -1));
        if ((j & 336) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.x, z3);
        }
        if ((j & 328) != 0) {
            this.x.setEnabled(z);
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.p2.setAlpha(f4);
            }
        }
        if ((j & 321) != 0) {
            a.h(this.y, z5);
        }
        if ((324 & j) != 0) {
            this.y.setEnabled(z2);
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.y.setAlpha(f3);
            }
        }
        if (i4 != 0) {
            this.y.setOnClickListener(onClickListener);
            this.z.setOnClickListener(onClickListener);
            this.p0.setOnClickListener(onClickListener);
            this.p1.setOnClickListener(onClickListener);
        }
        if ((322 & j) != 0) {
            this.p0.setEnabled(z6);
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.p0.setAlpha(f2);
            }
        }
        if ((j & 320) != 0) {
            a.h(this.p2, z4);
        }
        if ((j & 352) != 0) {
            TextViewBindingAdapter.setText(this.H3, str);
        }
    }

    @Override // com.tplink.iot.databinding.ActivitySensorDetailBottomBinding
    public void h(@Nullable SensorDetailViewModel sensorDetailViewModel) {
        this.J3 = sensorDetailViewModel;
        synchronized (this) {
            this.M3 |= 64;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.M3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivitySensorDetailBottomBinding
    public void i(@Nullable View.OnClickListener onClickListener) {
        this.I3 = onClickListener;
        synchronized (this) {
            this.M3 |= 128;
        }
        notifyPropertyChanged(69);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.M3 = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((LiveData) obj, i2);
        }
        if (i == 1) {
            return q((LiveData) obj, i2);
        }
        if (i == 2) {
            return o((LiveData) obj, i2);
        }
        if (i == 3) {
            return n((LiveData) obj, i2);
        }
        if (i == 4) {
            return m((LiveData) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return l((LiveData) obj, i2);
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

    private ActivitySensorDetailBottomBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (ImageView) objArr[11], (ImageView) objArr[10], (ImageView) objArr[8], (View) objArr[9], (TPSwitchCompat) objArr[4], (RelativeLayout) objArr[5], (RelativeLayout) objArr[7], (RelativeLayout) objArr[2], (ImageView) objArr[1], (RelativeLayout) objArr[3], (ContentScrollView) objArr[0], (TextView) objArr[6]);
        this.M3 = -1L;
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        this.p2.setTag(null);
        this.p3.setTag(null);
        this.H3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
