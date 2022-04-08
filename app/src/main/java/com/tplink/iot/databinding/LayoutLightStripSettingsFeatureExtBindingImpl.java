package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.tplink.iot.R;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripSettingsViewModel;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.iot.widget.viewgroup.ItemInfoLayout;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

/* loaded from: classes2.dex */
public class LayoutLightStripSettingsFeatureExtBindingImpl extends LayoutLightStripSettingsFeatureExtBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p0 = null;
    @Nullable
    private static final SparseIntArray p1;
    @NonNull
    private final LinearLayout p2;
    private long p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p1 = sparseIntArray;
        sparseIntArray.put(R.id.item_info, 5);
    }

    public LayoutLightStripSettingsFeatureExtBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, p0, p1));
    }

    private boolean h(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 2;
        }
        return true;
    }

    private boolean i(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 4;
        }
        return true;
    }

    private boolean l(LiveData<Boolean> liveData, int i) {
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
        float f2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        synchronized (this) {
            j = this.p3;
            this.p3 = 0L;
        }
        LightStripSettingsViewModel lightStripSettingsViewModel = this.z;
        View.OnClickListener onClickListener = this.y;
        if ((47 & j) != 0) {
            Boolean bool = null;
            if ((j & 41) != 0) {
                LiveData<Boolean> G = lightStripSettingsViewModel != null ? lightStripSettingsViewModel.G() : null;
                updateLiveDataRegistration(0, G);
                z = ViewDataBinding.safeUnbox(G != null ? G.getValue() : null);
            } else {
                z = false;
            }
            if ((j & 42) != 0) {
                LiveData<Boolean> F = lightStripSettingsViewModel != null ? lightStripSettingsViewModel.F() : null;
                updateLiveDataRegistration(1, F);
                z4 = ViewDataBinding.safeUnbox(F != null ? F.getValue() : null);
            } else {
                z4 = false;
            }
            int i = ((j & 44) > 0L ? 1 : ((j & 44) == 0L ? 0 : -1));
            if (i != 0) {
                LiveData<Boolean> x = lightStripSettingsViewModel != null ? lightStripSettingsViewModel.x() : null;
                updateLiveDataRegistration(2, x);
                if (x != null) {
                    bool = x.getValue();
                }
                boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
                if (i != 0) {
                    j |= safeUnbox ? 128L : 64L;
                }
                f2 = safeUnbox ? 0.5f : 1.0f;
                z3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!safeUnbox));
                z2 = z4;
            } else {
                j = j;
                f2 = 0.0f;
                z2 = z4;
                z3 = false;
            }
        } else {
            j = j;
            z3 = false;
            z2 = false;
            z = false;
            f2 = 0.0f;
        }
        int i2 = ((j & 48) > 0L ? 1 : ((j & 48) == 0L ? 0 : -1));
        if ((j & 44) != 0) {
            this.f7259c.setEnabled(z3);
            this.f7261f.setEnabled(z3);
            this.q.setEnabled(z3);
            this.x.setEnabled(z3);
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.f7259c.setAlpha(f2);
                this.f7261f.setAlpha(f2);
                this.q.setAlpha(f2);
                this.x.setAlpha(f2);
            }
        }
        if (i2 != 0) {
            this.f7259c.setOnClickListener(onClickListener);
            this.q.setOnClickListener(onClickListener);
        }
        if ((j & 41) != 0) {
            a.h(this.f7261f, z);
        }
        if ((j & 42) != 0) {
            a.g(this.x, z2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p3 = 32L;
        }
        requestRebind();
    }

    public void m(@Nullable View.OnClickListener onClickListener) {
        this.y = onClickListener;
        synchronized (this) {
            this.p3 |= 16;
        }
        notifyPropertyChanged(69);
        super.requestRebind();
    }

    public void n(@Nullable LightStripSettingsViewModel lightStripSettingsViewModel) {
        this.z = lightStripSettingsViewModel;
        synchronized (this) {
            this.p3 |= 8;
        }
        notifyPropertyChanged(89);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return l((LiveData) obj, i2);
        }
        if (i == 1) {
            return h((LiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return i((LiveData) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (89 == i) {
            n((LightStripSettingsViewModel) obj);
        } else if (69 != i) {
            return false;
        } else {
            m((View.OnClickListener) obj);
        }
        return true;
    }

    private LayoutLightStripSettingsFeatureExtBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ItemSettingLayout) objArr[1], (TextView) objArr[5], (RelativeLayout) objArr[2], (ItemInfoLayout) objArr[4], (TPSwitchCompat) objArr[3]);
        this.p3 = -1L;
        this.f7259c.setTag(null);
        this.f7261f.setTag(null);
        this.q.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p2 = linearLayout;
        linearLayout.setTag(null);
        this.x.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
