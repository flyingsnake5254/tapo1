package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.databinding.f;
import com.tplink.iot.generated.callback.c;
import com.tplink.iot.view.ipcamera.base.b;

/* loaded from: classes2.dex */
public class ItemCameraPreviewSortBindingImpl extends ItemCameraPreviewSortBinding implements c.a {
    @Nullable
    private static final SparseIntArray H3;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3 = null;
    @NonNull
    private final ConstraintLayout I3;
    @Nullable
    private final View.OnTouchListener J3;
    private long K3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H3 = sparseIntArray;
        sparseIntArray.put(R.id.icon, 4);
    }

    public ItemCameraPreviewSortBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, p3, H3));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.K3;
            this.K3 = 0L;
        }
        String str = this.p0;
        String str2 = this.z;
        int i = ((96 & j) > 0L ? 1 : ((96 & j) == 0L ? 0 : -1));
        if ((65 & j) != 0) {
            TextViewBindingAdapter.setText(this.f7151d, str);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.f7152f, str2);
        }
        if ((j & 64) != 0) {
            b.A(this.q, this.J3);
        }
    }

    @Override // com.tplink.iot.generated.callback.c.a
    public final boolean f(int i, View view, MotionEvent motionEvent) {
        RecyclerView.ViewHolder viewHolder = this.p1;
        f fVar = this.p2;
        if (fVar != null) {
            return fVar.a(view, motionEvent, viewHolder);
        }
        return false;
    }

    public void h(@Nullable String str) {
        this.y = str;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.K3 != 0;
        }
    }

    public void i(@Nullable String str) {
        this.p0 = str;
        synchronized (this) {
            this.K3 |= 1;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.K3 = 64L;
        }
        requestRebind();
    }

    public void l(@Nullable String str) {
        this.z = str;
        synchronized (this) {
            this.K3 |= 32;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    public void m(@Nullable f fVar) {
        this.p2 = fVar;
        synchronized (this) {
            this.K3 |= 16;
        }
        notifyPropertyChanged(65);
        super.requestRebind();
    }

    public void n(@Nullable Integer num) {
        this.x = num;
    }

    public void o(@Nullable RecyclerView.ViewHolder viewHolder) {
        this.p1 = viewHolder;
        synchronized (this) {
            this.K3 |= 8;
        }
        notifyPropertyChanged(102);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (4 == i) {
            i((String) obj);
        } else if (76 == i) {
            n((Integer) obj);
        } else if (3 == i) {
            h((String) obj);
        } else if (102 == i) {
            o((RecyclerView.ViewHolder) obj);
        } else if (65 == i) {
            m((f) obj);
        } else if (5 != i) {
            return false;
        } else {
            l((String) obj);
        }
        return true;
    }

    private ItemCameraPreviewSortBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (TextView) objArr[2], (TextView) objArr[1], (ImageView) objArr[3]);
        this.K3 = -1L;
        this.f7151d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.I3 = constraintLayout;
        constraintLayout.setTag(null);
        this.f7152f.setTag(null);
        this.q.setTag(null);
        setRootTag(view);
        this.J3 = new c(this, 1);
        invalidateAll();
    }
}
