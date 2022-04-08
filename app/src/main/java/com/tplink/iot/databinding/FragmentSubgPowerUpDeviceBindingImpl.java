package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

/* loaded from: classes2.dex */
public class FragmentSubgPowerUpDeviceBindingImpl extends FragmentSubgPowerUpDeviceBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p1 = null;
    @Nullable
    private static final SparseIntArray p2;
    @Nullable
    private final View.OnClickListener H3;
    @Nullable
    private final View.OnClickListener I3;
    private long J3;
    @NonNull
    private final LinearLayout p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p2 = sparseIntArray;
        sparseIntArray.put(R.id.layout_bulb_install, 3);
        sparseIntArray.put(R.id.ll_info, 4);
        sparseIntArray.put(R.id.tv_guide_desc, 5);
        sparseIntArray.put(R.id.iv_power_up, 6);
    }

    public FragmentSubgPowerUpDeviceBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, p1, p2));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.p0;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.p0;
            if (gVar2 != null) {
                z = true;
            }
            if (z) {
                gVar2.onClick(view);
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.J3;
            this.J3 = 0L;
        }
        if ((j & 4) != 0) {
            this.f7099c.setOnClickListener(this.H3);
            this.f7100d.setOnClickListener(this.I3);
        }
    }

    public void h(@Nullable g gVar) {
        this.p0 = gVar;
        synchronized (this) {
            this.J3 |= 2;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.J3 != 0;
        }
    }

    public void i(@Nullable SubGViewModel subGViewModel) {
        this.z = subGViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.J3 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (94 == i) {
            i((SubGViewModel) obj);
        } else if (79 != i) {
            return false;
        } else {
            h((g) obj);
        }
        return true;
    }

    private FragmentSubgPowerUpDeviceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[2], (ImageView) objArr[1], (ImageView) objArr[6], (RelativeLayout) objArr[3], (LinearLayout) objArr[4], (TextView) objArr[5]);
        this.J3 = -1L;
        this.f7099c.setTag(null);
        this.f7100d.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.H3 = new a(this, 2);
        this.I3 = new a(this, 1);
        invalidateAll();
    }
}
