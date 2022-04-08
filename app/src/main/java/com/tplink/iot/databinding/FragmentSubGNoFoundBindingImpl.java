package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.devicecommon.widget.VariousImageViewLayout;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.widget.PointTextView;

/* loaded from: classes2.dex */
public class FragmentSubGNoFoundBindingImpl extends FragmentSubGNoFoundBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts K3 = null;
    @Nullable
    private static final SparseIntArray L3;
    @NonNull
    private final LinearLayout M3;
    @Nullable
    private final View.OnClickListener N3;
    @Nullable
    private final View.OnClickListener O3;
    private long P3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L3 = sparseIntArray;
        sparseIntArray.put(R.id.ll_content, 3);
        sparseIntArray.put(R.id.img_ble_state, 4);
        sparseIntArray.put(R.id.tv_tip1, 5);
        sparseIntArray.put(R.id.tv_tip2, 6);
        sparseIntArray.put(R.id.tv_tip3, 7);
        sparseIntArray.put(R.id.tv_tip4, 8);
        sparseIntArray.put(R.id.tv_tip5, 9);
        sparseIntArray.put(R.id.tv_reset_hint, 10);
        sparseIntArray.put(R.id.iv_reset, 11);
        sparseIntArray.put(R.id.tv_contact_us, 12);
    }

    public FragmentSubGNoFoundBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, K3, L3));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.J3;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.J3;
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
            j = this.P3;
            this.P3 = 0L;
        }
        if ((j & 4) != 0) {
            this.f7072c.setOnClickListener(this.O3);
            this.f7074f.setOnClickListener(this.N3);
        }
    }

    public void h(@Nullable g gVar) {
        this.J3 = gVar;
        synchronized (this) {
            this.P3 |= 2;
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

    public void i(@Nullable SubGViewModel subGViewModel) {
        this.I3 = subGViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.P3 = 4L;
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

    private FragmentSubGNoFoundBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[2], (ImageView) objArr[4], (ImageView) objArr[1], (VariousImageViewLayout) objArr[11], (LinearLayout) objArr[3], (TextView) objArr[12], (TextView) objArr[10], (PointTextView) objArr[5], (PointTextView) objArr[6], (PointTextView) objArr[7], (PointTextView) objArr[8], (PointTextView) objArr[9]);
        this.P3 = -1L;
        this.f7072c.setTag(null);
        this.f7074f.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.M3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.N3 = new a(this, 1);
        this.O3 = new a(this, 2);
        invalidateAll();
    }
}
