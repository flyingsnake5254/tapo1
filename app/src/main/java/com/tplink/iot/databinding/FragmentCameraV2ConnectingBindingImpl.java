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
import com.tplink.libtpcontrols.TPHookView;
import com.tplink.libtpcontrols.TPRippleBackground;

/* loaded from: classes2.dex */
public class FragmentCameraV2ConnectingBindingImpl extends FragmentCameraV2ConnectingBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts M3 = null;
    @Nullable
    private static final SparseIntArray N3;
    @Nullable
    private final View.OnClickListener O3;
    private long P3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        N3 = sparseIntArray;
        sparseIntArray.put(R.id.image_star, 2);
        sparseIntArray.put(R.id.arrow_line, 3);
        sparseIntArray.put(R.id.image_arrow_down, 4);
        sparseIntArray.put(R.id.image_arrow_up, 5);
        sparseIntArray.put(R.id.qs_m5_ripple_bg_move, 6);
        sparseIntArray.put(R.id.qs_m5_move, 7);
        sparseIntArray.put(R.id.qs_mobile_ripple_bg, 8);
        sparseIntArray.put(R.id.qs_phone, 9);
        sparseIntArray.put(R.id.qs_phone_wifi, 10);
        sparseIntArray.put(R.id.qs_phone_move, 11);
        sparseIntArray.put(R.id.hook_view_phone, 12);
        sparseIntArray.put(R.id.hook_view, 13);
        sparseIntArray.put(R.id.qs_tv_status, 14);
    }

    public FragmentCameraV2ConnectingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, M3, N3));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.L3;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.P3;
            this.P3 = 0L;
        }
        if ((j & 2) != 0) {
            this.z.setOnClickListener(this.O3);
        }
    }

    public void h(@Nullable g gVar) {
        this.L3 = gVar;
        synchronized (this) {
            this.P3 |= 1;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.P3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.P3 = 2L;
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

    private FragmentCameraV2ConnectingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (TPHookView) objArr[13], (TPHookView) objArr[12], (ImageView) objArr[4], (ImageView) objArr[5], (ImageView) objArr[2], (ImageView) objArr[1], (ImageView) objArr[7], (TPRippleBackground) objArr[6], (TPRippleBackground) objArr[8], (ImageView) objArr[9], (ImageView) objArr[11], (ImageView) objArr[10], (TextView) objArr[14], (RelativeLayout) objArr[0]);
        this.P3 = -1L;
        this.z.setTag(null);
        this.K3.setTag(null);
        setRootTag(view);
        this.O3 = new a(this, 1);
        invalidateAll();
    }
}
