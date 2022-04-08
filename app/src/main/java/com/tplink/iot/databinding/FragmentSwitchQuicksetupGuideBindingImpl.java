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
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;

/* loaded from: classes2.dex */
public class FragmentSwitchQuicksetupGuideBindingImpl extends FragmentSwitchQuicksetupGuideBinding implements a.AbstractC0211a {
    @Nullable
    private static final SparseIntArray p0;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts z = null;
    private long H3;
    @NonNull
    private final LinearLayout p1;
    @Nullable
    private final View.OnClickListener p2;
    @Nullable
    private final View.OnClickListener p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p0 = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 3);
        sparseIntArray.put(R.id.tv_tip, 4);
        sparseIntArray.put(R.id.iv_button_pos, 5);
    }

    public FragmentSwitchQuicksetupGuideBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, z, p0));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z2 = false;
        if (i == 1) {
            g gVar = this.y;
            if (gVar != null) {
                z2 = true;
            }
            if (z2) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.y;
            if (gVar2 != null) {
                z2 = true;
            }
            if (z2) {
                gVar2.onClick(view);
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.H3;
            this.H3 = 0L;
        }
        if ((j & 2) != 0) {
            this.f7108c.setOnClickListener(this.p3);
            this.f7109d.setOnClickListener(this.p2);
        }
    }

    public void h(@Nullable g gVar) {
        this.y = gVar;
        synchronized (this) {
            this.H3 |= 1;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.H3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.H3 = 2L;
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

    private FragmentSwitchQuicksetupGuideBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[2], (ImageView) objArr[1], (ImageView) objArr[5], (TextView) objArr[4], (TextView) objArr[3]);
        this.H3 = -1L;
        this.f7108c.setTag(null);
        this.f7109d.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p1 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.p2 = new a(this, 1);
        this.p3 = new a(this, 2);
        invalidateAll();
    }
}
