package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel;

/* loaded from: classes2.dex */
public class ItemCameraSelectDeviceFullScreenBindingImpl extends ItemCameraSelectDeviceFullScreenBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p1 = null;
    @Nullable
    private static final SparseIntArray p2;
    @Nullable
    private final View.OnClickListener H3;
    private long I3;
    @NonNull
    private final ConstraintLayout p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p2 = sparseIntArray;
        sparseIntArray.put(R.id.bottom_divider, 5);
    }

    public ItemCameraSelectDeviceFullScreenBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, p1, p2));
    }

    private boolean h(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.I3 |= 1;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        d dVar = this.z;
        Integer num = this.p0;
        if (dVar != null) {
            dVar.a(view, ViewDataBinding.safeUnbox(num));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ItemCameraSelectDeviceFullScreenBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.I3 != 0;
        }
    }

    public void i(@Nullable d dVar) {
        this.z = dVar;
        synchronized (this) {
            this.I3 |= 8;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.I3 = 16L;
        }
        requestRebind();
    }

    public void l(@Nullable SelectDeviceViewModel.a aVar) {
        this.y = aVar;
        synchronized (this) {
            this.I3 |= 2;
        }
        notifyPropertyChanged(31);
        super.requestRebind();
    }

    public void m(@Nullable Integer num) {
        this.p0 = num;
        synchronized (this) {
            this.I3 |= 4;
        }
        notifyPropertyChanged(76);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return h((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (31 == i) {
            l((SelectDeviceViewModel.a) obj);
        } else if (76 == i) {
            m((Integer) obj);
        } else if (9 != i) {
            return false;
        } else {
            i((d) obj);
        }
        return true;
    }

    private ItemCameraSelectDeviceFullScreenBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (View) objArr[5], (ImageView) objArr[4], (TextView) objArr[2], (ImageView) objArr[1], (TextView) objArr[3]);
        this.I3 = -1L;
        this.f7157d.setTag(null);
        this.f7158f.setTag(null);
        this.q.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.p3 = constraintLayout;
        constraintLayout.setTag(null);
        this.x.setTag(null);
        setRootTag(view);
        this.H3 = new a(this, 1);
        invalidateAll();
    }
}
