package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;
import uk.co.senab.photoview.PhotoView;

/* loaded from: classes2.dex */
public class ActivityMemoriesImageBindingImpl extends ActivityMemoriesImageBinding implements a.AbstractC0211a {
    @Nullable
    private static final SparseIntArray H3;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3;
    @NonNull
    private final ConstraintLayout I3;
    @NonNull
    private final TextView J3;
    @NonNull
    private final FrameLayout K3;
    @NonNull
    private final RelativeLayout L3;
    @Nullable
    private final DialogMemorySlideOperationBinding M3;
    @NonNull
    private final TextView N3;
    @Nullable
    private final View.OnClickListener O3;
    private long P3;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(14);
        p3 = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"dialog_memory_bottom_operation"}, new int[]{11}, new int[]{R.layout.dialog_memory_bottom_operation});
        includedLayouts.setIncludes(6, new String[]{"dialog_memory_slide_operation"}, new int[]{10}, new int[]{R.layout.dialog_memory_slide_operation});
        SparseIntArray sparseIntArray = new SparseIntArray();
        H3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 12);
        sparseIntArray.put(R.id.snapshot_fullscreen_image, 13);
    }

    public ActivityMemoriesImageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, p3, H3));
    }

    private boolean l(ObservableField<CharSequence> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 16;
        }
        return true;
    }

    private boolean m(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 2;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 8;
        }
        return true;
    }

    private boolean o(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 1;
        }
        return true;
    }

    private boolean p(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 4;
        }
        return true;
    }

    private boolean q(DialogMemoryBottomOperationBinding dialogMemoryBottomOperationBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 32;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.p1;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0120  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityMemoriesImageBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityMemoriesImageBinding
    public void h(@Nullable MemoriesViewModel memoriesViewModel) {
        this.p2 = memoriesViewModel;
        synchronized (this) {
            this.P3 |= 64;
        }
        notifyPropertyChanged(62);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.P3 != 0) {
                return true;
            }
            return this.M3.hasPendingBindings() || this.p0.hasPendingBindings();
        }
    }

    @Override // com.tplink.iot.databinding.ActivityMemoriesImageBinding
    public void i(@Nullable g gVar) {
        this.p1 = gVar;
        synchronized (this) {
            this.P3 |= 128;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.P3 = 256L;
        }
        this.M3.invalidateAll();
        this.p0.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return m((ObservableField) obj, i2);
        }
        if (i == 2) {
            return p((ObservableBoolean) obj, i2);
        }
        if (i == 3) {
            return n((ObservableBoolean) obj, i2);
        }
        if (i == 4) {
            return l((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return q((DialogMemoryBottomOperationBinding) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.M3.setLifecycleOwner(lifecycleOwner);
        this.p0.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (62 == i) {
            h((MemoriesViewModel) obj);
        } else if (79 != i) {
            return false;
        } else {
            i((g) obj);
        }
        return true;
    }

    private ActivityMemoriesImageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (ImageView) objArr[7], (CameraLoadingView) objArr[9], (PhotoView) objArr[13], (PhotoView) objArr[4], (Toolbar) objArr[12], (AppBarLayout) objArr[1], (TextView) objArr[2], (DialogMemoryBottomOperationBinding) objArr[11]);
        this.P3 = -1L;
        this.f6618c.setTag(null);
        this.f6619d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.I3 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.J3 = textView;
        textView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[5];
        this.K3 = frameLayout;
        frameLayout.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[6];
        this.L3 = relativeLayout;
        relativeLayout.setTag(null);
        DialogMemorySlideOperationBinding dialogMemorySlideOperationBinding = (DialogMemorySlideOperationBinding) objArr[10];
        this.M3 = dialogMemorySlideOperationBinding;
        setContainedBinding(dialogMemorySlideOperationBinding);
        TextView textView2 = (TextView) objArr[8];
        this.N3 = textView2;
        textView2.setTag(null);
        this.q.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        setContainedBinding(this.p0);
        setRootTag(view);
        this.O3 = new a(this, 1);
        invalidateAll();
    }
}
