package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
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
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public class FragmentSubGCompleteBindingImpl extends FragmentSubGCompleteBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p2 = null;
    @Nullable
    private static final SparseIntArray p3;
    @NonNull
    private final ScrollView H3;
    @Nullable
    private final View.OnClickListener I3;
    @Nullable
    private final View.OnClickListener J3;
    private long K3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p3 = sparseIntArray;
        sparseIntArray.put(R.id.ll_content, 3);
        sparseIntArray.put(R.id.tv_title, 4);
        sparseIntArray.put(R.id.tv_tip2, 5);
        sparseIntArray.put(R.id.image_device, 6);
        sparseIntArray.put(R.id.tv_tip_check, 7);
    }

    public FragmentSubGCompleteBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p2, p3));
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
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.K3;
            this.K3 = 0L;
        }
        if ((j & 4) != 0) {
            this.f7060c.setOnClickListener(this.I3);
            this.q.setOnClickListener(this.J3);
        }
    }

    public void h(@Nullable g gVar) {
        this.p1 = gVar;
        synchronized (this) {
            this.K3 |= 2;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.K3 != 0;
        }
    }

    public void i(@Nullable SubGViewModel subGViewModel) {
        this.p0 = subGViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.K3 = 4L;
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

    private FragmentSubGCompleteBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[2], (ImageView) objArr[6], (LinearLayout) objArr[3], (TPRefreshableButton) objArr[1], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[4]);
        this.K3 = -1L;
        this.f7060c.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.H3 = scrollView;
        scrollView.setTag(null);
        this.q.setTag(null);
        setRootTag(view);
        this.I3 = new a(this, 2);
        this.J3 = new a(this, 1);
        invalidateAll();
    }
}
