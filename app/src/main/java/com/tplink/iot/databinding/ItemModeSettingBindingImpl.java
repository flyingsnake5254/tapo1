package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;

/* loaded from: classes2.dex */
public class ItemModeSettingBindingImpl extends ItemModeSettingBinding implements a.AbstractC0211a {
    @Nullable
    private static final SparseIntArray H3 = null;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3 = null;
    @NonNull
    private final ConstraintLayout I3;
    @NonNull
    private final ImageView J3;
    @Nullable
    private final View.OnClickListener K3;
    @Nullable
    private final View.OnClickListener L3;
    private long M3;

    public ItemModeSettingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, p3, H3));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            d dVar = this.p1;
            Integer num = this.p0;
            if (dVar != null) {
                z = true;
            }
            if (z) {
                dVar.a(view, ViewDataBinding.safeUnbox(num));
            }
        } else if (i == 2) {
            d dVar2 = this.p1;
            Integer num2 = this.p0;
            if (dVar2 != null) {
                z = true;
            }
            if (z) {
                dVar2.a(view, ViewDataBinding.safeUnbox(num2));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ItemModeSettingBindingImpl.executeBindings():void");
    }

    public void h(@Nullable d dVar) {
        this.p1 = dVar;
        synchronized (this) {
            this.M3 |= 16;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.M3 != 0;
        }
    }

    public void i(@Nullable CameraPreviewInfo cameraPreviewInfo) {
        this.y = cameraPreviewInfo;
        synchronized (this) {
            this.M3 |= 2;
        }
        notifyPropertyChanged(31);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.M3 = 32L;
        }
        requestRebind();
    }

    public void l(@Nullable Boolean bool) {
        this.p2 = bool;
        synchronized (this) {
            this.M3 |= 1;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    public void m(@Nullable String str) {
        this.z = str;
        synchronized (this) {
            this.M3 |= 8;
        }
        notifyPropertyChanged(58);
        super.requestRebind();
    }

    public void n(@Nullable Integer num) {
        this.p0 = num;
        synchronized (this) {
            this.M3 |= 4;
        }
        notifyPropertyChanged(76);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (37 == i) {
            l((Boolean) obj);
        } else if (31 == i) {
            i((CameraPreviewInfo) obj);
        } else if (76 == i) {
            n((Integer) obj);
        } else if (58 == i) {
            m((String) obj);
        } else if (9 != i) {
            return false;
        } else {
            h((d) obj);
        }
        return true;
    }

    private ItemModeSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[5], (ImageView) objArr[6], (ImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[4]);
        this.M3 = -1L;
        this.f7184c.setTag(null);
        this.f7185d.setTag(null);
        this.f7186f.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.I3 = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.J3 = imageView;
        imageView.setTag(null);
        this.q.setTag(null);
        this.x.setTag(null);
        setRootTag(view);
        this.K3 = new a(this, 2);
        this.L3 = new a(this, 1);
        invalidateAll();
    }
}
