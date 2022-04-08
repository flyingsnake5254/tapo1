package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.libtpcontrols.TPRippleBackground;

/* loaded from: classes2.dex */
public class FragmentCameraV2RescanWifiBindingImpl extends FragmentCameraV2RescanWifiBinding implements a.AbstractC0211a {
    @Nullable
    private static final SparseIntArray p0;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts z = null;
    @NonNull
    private final RelativeLayout p1;
    @Nullable
    private final View.OnClickListener p2;
    private long p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p0 = sparseIntArray;
        sparseIntArray.put(R.id.image_star, 2);
        sparseIntArray.put(R.id.qs_m5_ripple_bg, 3);
        sparseIntArray.put(R.id.qs_device, 4);
        sparseIntArray.put(R.id.qs_tv_status, 5);
    }

    public FragmentCameraV2RescanWifiBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, z, p0));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.y;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.p3;
            this.p3 = 0L;
        }
        if ((j & 2) != 0) {
            this.f6928d.setOnClickListener(this.p2);
        }
    }

    public void h(@Nullable g gVar) {
        this.y = gVar;
        synchronized (this) {
            this.p3 |= 1;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
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
            this.p3 = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 != i) {
            return false;
        }
        h((g) obj);
        return true;
    }

    private FragmentCameraV2RescanWifiBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (ImageView) objArr[1], (ImageView) objArr[4], (TPRippleBackground) objArr[3], (TextView) objArr[5]);
        this.p3 = -1L;
        this.f6928d.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.p1 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        this.p2 = new a(this, 1);
        invalidateAll();
    }
}
