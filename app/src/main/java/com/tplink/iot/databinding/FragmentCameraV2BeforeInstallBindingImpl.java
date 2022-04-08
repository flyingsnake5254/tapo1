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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraBeforeInstallViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

/* loaded from: classes2.dex */
public class FragmentCameraV2BeforeInstallBindingImpl extends FragmentCameraV2BeforeInstallBinding implements a.AbstractC0211a {
    @Nullable
    private static final SparseIntArray H3;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3 = null;
    @NonNull
    private final LinearLayout I3;
    @Nullable
    private final View.OnClickListener J3;
    @Nullable
    private final View.OnClickListener K3;
    private long L3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        sparseIntArray.put(R.id.ll_content, 4);
        sparseIntArray.put(R.id.tv_tip2, 5);
        sparseIntArray.put(R.id.tv_tip3_c310, 6);
        sparseIntArray.put(R.id.image_good_network, 7);
    }

    public FragmentCameraV2BeforeInstallBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p3, H3));
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
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.L3;
            this.L3 = 0L;
        }
        if ((j & 8) != 0) {
            this.f6852c.setOnClickListener(this.J3);
            this.q.setOnClickListener(this.K3);
        }
    }

    public void h(@Nullable CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.p1 = cameraOnBoardingViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.L3 != 0;
        }
    }

    public void i(@Nullable g gVar) {
        this.p2 = gVar;
        synchronized (this) {
            this.L3 |= 1;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.L3 = 8L;
        }
        requestRebind();
    }

    public void l(@Nullable CameraBeforeInstallViewModel cameraBeforeInstallViewModel) {
        this.p0 = cameraBeforeInstallViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 == i) {
            i((g) obj);
        } else if (68 == i) {
            h((CameraOnBoardingViewModel) obj);
        } else if (103 != i) {
            return false;
        } else {
            l((CameraBeforeInstallViewModel) obj);
        }
        return true;
    }

    private FragmentCameraV2BeforeInstallBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[2], (ImageView) objArr[7], (LinearLayout) objArr[4], (ImageView) objArr[1], (Toolbar) objArr[3], (TextView) objArr[5], (TextView) objArr[6]);
        this.L3 = -1L;
        this.f6852c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.I3 = linearLayout;
        linearLayout.setTag(null);
        this.q.setTag(null);
        setRootTag(view);
        this.J3 = new a(this, 2);
        this.K3 = new a(this, 1);
        invalidateAll();
    }
}
