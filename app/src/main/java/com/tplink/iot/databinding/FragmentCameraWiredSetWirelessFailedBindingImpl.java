package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.widget.PointTextView;

/* loaded from: classes2.dex */
public class FragmentCameraWiredSetWirelessFailedBindingImpl extends FragmentCameraWiredSetWirelessFailedBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p1 = null;
    @Nullable
    private static final SparseIntArray p2;
    @Nullable
    private final View.OnClickListener H3;
    private long I3;
    @NonNull
    private final LinearLayout p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p2 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 2);
        sparseIntArray.put(R.id.ll_content, 3);
        sparseIntArray.put(R.id.img_ble_state, 4);
        sparseIntArray.put(R.id.point_view1, 5);
        sparseIntArray.put(R.id.point_view2, 6);
        sparseIntArray.put(R.id.tv_skip_wireless, 7);
    }

    public FragmentCameraWiredSetWirelessFailedBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p1, p2));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.p0;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.I3;
            this.I3 = 0L;
        }
        if ((j & 2) != 0) {
            this.f6966c.setOnClickListener(this.H3);
        }
    }

    public void h(@Nullable g gVar) {
        this.p0 = gVar;
        synchronized (this) {
            this.I3 |= 1;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.I3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.I3 = 2L;
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

    private FragmentCameraWiredSetWirelessFailedBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[1], (ImageView) objArr[4], (LinearLayout) objArr[3], (PointTextView) objArr[5], (PointTextView) objArr[6], (Toolbar) objArr[2], (TextView) objArr[7]);
        this.I3 = -1L;
        this.f6966c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.H3 = new a(this, 1);
        invalidateAll();
    }
}
