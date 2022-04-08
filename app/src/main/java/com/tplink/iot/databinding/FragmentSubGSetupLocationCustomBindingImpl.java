package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public class FragmentSubGSetupLocationCustomBindingImpl extends FragmentSubGSetupLocationCustomBinding implements a.AbstractC0211a {
    @Nullable
    private static final SparseIntArray H3;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3 = null;
    @NonNull
    private final ScrollView I3;
    @Nullable
    private final View.OnClickListener J3;
    @Nullable
    private final View.OnClickListener K3;
    @Nullable
    private final View.OnClickListener L3;
    @Nullable
    private final View.OnClickListener M3;
    private long N3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H3 = sparseIntArray;
        sparseIntArray.put(R.id.ll_content, 5);
        sparseIntArray.put(R.id.draw_edit_text, 6);
        sparseIntArray.put(R.id.flow_tag_layout, 7);
        sparseIntArray.put(R.id.ll_bottom, 8);
    }

    public FragmentSubGSetupLocationCustomBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, p3, H3));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.p2;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.p2;
            if (gVar2 != null) {
                z = true;
            }
            if (z) {
                gVar2.onClick(view);
            }
        } else if (i == 3) {
            g gVar3 = this.p2;
            if (gVar3 != null) {
                z = true;
            }
            if (z) {
                gVar3.onClick(view);
            }
        } else if (i == 4) {
            g gVar4 = this.p2;
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
            j = this.N3;
            this.N3 = 0L;
        }
        if ((j & 4) != 0) {
            this.f7084c.setOnClickListener(this.M3);
            this.q.setOnClickListener(this.L3);
            this.z.setOnClickListener(this.K3);
            this.p0.setOnClickListener(this.J3);
        }
    }

    public void h(@Nullable g gVar) {
        this.p2 = gVar;
        synchronized (this) {
            this.N3 |= 2;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.N3 != 0;
        }
    }

    public void i(@Nullable SubGViewModel subGViewModel) {
        this.p1 = subGViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.N3 = 4L;
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

    private FragmentSubGSetupLocationCustomBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TPRefreshableButton) objArr[2], (DrawableEditText) objArr[6], (FlowTagLayout) objArr[7], (ImageView) objArr[1], (LinearLayout) objArr[8], (LinearLayout) objArr[5], (View) objArr[4], (TextView) objArr[3]);
        this.N3 = -1L;
        this.f7084c.setTag(null);
        this.q.setTag(null);
        this.z.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.I3 = scrollView;
        scrollView.setTag(null);
        this.p0.setTag(null);
        setRootTag(view);
        this.J3 = new a(this, 3);
        this.K3 = new a(this, 4);
        this.L3 = new a(this, 1);
        this.M3 = new a(this, 2);
        invalidateAll();
    }
}
