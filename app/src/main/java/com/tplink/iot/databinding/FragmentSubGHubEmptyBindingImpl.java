package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

/* loaded from: classes2.dex */
public class FragmentSubGHubEmptyBindingImpl extends FragmentSubGHubEmptyBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts y = null;
    @Nullable
    private static final SparseIntArray z;
    @NonNull
    private final LinearLayout p0;
    @Nullable
    private final View.OnClickListener p1;
    private long p2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z = sparseIntArray;
        sparseIntArray.put(R.id.recycler_view, 2);
        sparseIntArray.put(R.id.fl_shared_hubs_hint, 3);
    }

    public FragmentSubGHubEmptyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, y, z));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.x;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.p2;
            this.p2 = 0L;
        }
        if ((j & 4) != 0) {
            this.f7064d.setOnClickListener(this.p1);
        }
    }

    public void h(@Nullable g gVar) {
        this.x = gVar;
        synchronized (this) {
            this.p2 |= 2;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p2 != 0;
        }
    }

    public void i(@Nullable SubGViewModel subGViewModel) {
        this.q = subGViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p2 = 4L;
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

    private FragmentSubGHubEmptyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[3], (ImageView) objArr[1], (RecyclerView) objArr[2]);
        this.p2 = -1L;
        this.f7064d.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.p1 = new a(this, 1);
        invalidateAll();
    }
}
