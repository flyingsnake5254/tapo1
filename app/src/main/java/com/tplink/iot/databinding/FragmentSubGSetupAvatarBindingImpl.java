package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public class FragmentSubGSetupAvatarBindingImpl extends FragmentSubGSetupAvatarBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p2 = null;
    @Nullable
    private static final SparseIntArray p3;
    @NonNull
    private final RelativeLayout H3;
    @Nullable
    private final View.OnClickListener I3;
    @Nullable
    private final View.OnClickListener J3;
    @Nullable
    private final View.OnClickListener K3;
    @Nullable
    private final View.OnClickListener L3;
    private long M3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p3 = sparseIntArray;
        sparseIntArray.put(R.id.tv_select, 5);
        sparseIntArray.put(R.id.ll_bottom, 6);
        sparseIntArray.put(R.id.icon_list, 7);
    }

    public FragmentSubGSetupAvatarBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p2, p3));
    }

    private boolean h(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 1;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.p1;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.p1;
            if (gVar2 != null) {
                z = true;
            }
            if (z) {
                gVar2.onClick(view);
            }
        } else if (i == 3) {
            g gVar3 = this.p1;
            if (gVar3 != null) {
                z = true;
            }
            if (z) {
                gVar3.onClick(view);
            }
        } else if (i == 4) {
            g gVar4 = this.p1;
            if (gVar4 != null) {
                z = true;
            }
            if (z) {
                gVar4.onClick(view);
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.M3;
            this.M3 = 0L;
        }
        SubGViewModel subGViewModel = this.p0;
        ObservableInt observableInt = null;
        boolean z = false;
        int i = ((11 & j) > 0L ? 1 : ((11 & j) == 0L ? 0 : -1));
        if (i != 0) {
            if (subGViewModel != null) {
                observableInt = subGViewModel.q;
            }
            updateRegistration(0, observableInt);
            if ((observableInt != null ? observableInt.get() : 0) > 0) {
                z = true;
            }
        }
        if ((j & 8) != 0) {
            this.f7081c.setOnClickListener(this.L3);
            this.f7083f.setOnClickListener(this.K3);
            this.x.setOnClickListener(this.J3);
            this.y.setOnClickListener(this.I3);
        }
        if (i != 0) {
            b.Q(this.y, z);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.M3 != 0;
        }
    }

    public void i(@Nullable g gVar) {
        this.p1 = gVar;
        synchronized (this) {
            this.M3 |= 4;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.M3 = 8L;
        }
        requestRebind();
    }

    public void l(@Nullable SubGViewModel subGViewModel) {
        this.p0 = subGViewModel;
        synchronized (this) {
            this.M3 |= 2;
        }
        notifyPropertyChanged(94);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return h((ObservableInt) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (94 == i) {
            l((SubGViewModel) obj);
        } else if (79 != i) {
            return false;
        } else {
            i((g) obj);
        }
        return true;
    }

    private FragmentSubGSetupAvatarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TPRefreshableButton) objArr[2], (RecyclerView) objArr[7], (ImageView) objArr[1], (LinearLayout) objArr[6], (View) objArr[4], (TextView) objArr[3], (TextView) objArr[5]);
        this.M3 = -1L;
        this.f7081c.setTag(null);
        this.f7083f.setTag(null);
        this.x.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.H3 = relativeLayout;
        relativeLayout.setTag(null);
        this.y.setTag(null);
        setRootTag(view);
        this.I3 = new a(this, 3);
        this.J3 = new a(this, 4);
        this.K3 = new a(this, 1);
        this.L3 = new a(this, 2);
        invalidateAll();
    }
}
