package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CheckStatusViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public class FragmentCameraV2CheckStatusBindingImpl extends FragmentCameraV2CheckStatusBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts H3 = null;
    @Nullable
    private static final SparseIntArray I3;
    @NonNull
    private final RelativeLayout J3;
    @Nullable
    private final View.OnClickListener K3;
    @Nullable
    private final View.OnClickListener L3;
    private long M3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        sparseIntArray.put(R.id.layout_bulb_install, 4);
        sparseIntArray.put(R.id.title, 5);
        sparseIntArray.put(R.id.hint, 6);
        sparseIntArray.put(R.id.tv_hint_tip, 7);
        sparseIntArray.put(R.id.check_light_iv, 8);
    }

    public FragmentCameraV2CheckStatusBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, H3, I3));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.p3;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.p3;
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
            j = this.M3;
            this.M3 = 0L;
        }
        if ((j & 8) != 0) {
            this.q.setOnClickListener(this.K3);
            this.z.setOnClickListener(this.L3);
        }
    }

    public void h(@Nullable CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.p2 = cameraOnBoardingViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.M3 != 0;
        }
    }

    public void i(@Nullable g gVar) {
        this.p3 = gVar;
        synchronized (this) {
            this.M3 |= 1;
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

    public void l(@Nullable CheckStatusViewModel checkStatusViewModel) {
        this.p1 = checkStatusViewModel;
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
            l((CheckStatusViewModel) obj);
        }
        return true;
    }

    private FragmentCameraV2CheckStatusBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[8], (TextView) objArr[6], (RelativeLayout) objArr[4], (TPRefreshableButton) objArr[1], (TextView) objArr[5], (Toolbar) objArr[3], (TextView) objArr[2], (TextView) objArr[7]);
        this.M3 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.J3 = relativeLayout;
        relativeLayout.setTag(null);
        this.q.setTag(null);
        this.z.setTag(null);
        setRootTag(view);
        this.K3 = new a(this, 1);
        this.L3 = new a(this, 2);
        invalidateAll();
    }
}
