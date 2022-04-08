package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallPreviewViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.cameralive.VideoSurfaceViewLayout;
import com.tplink.iot.widget.cameralive.y;
import io.reactivex.m0.d;

/* loaded from: classes2.dex */
public class FragmentCameraV2InstallPreviewBindingImpl extends FragmentCameraV2InstallPreviewBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts J3 = null;
    @Nullable
    private static final SparseIntArray K3;
    @NonNull
    private final LinearLayout L3;
    @Nullable
    private final View.OnClickListener M3;
    @Nullable
    private final View.OnClickListener N3;
    @Nullable
    private final View.OnClickListener O3;
    private long P3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 5);
        sparseIntArray.put(R.id.ll_content, 6);
        sparseIntArray.put(R.id.tv_title, 7);
        sparseIntArray.put(R.id.tv_tip2, 8);
    }

    public FragmentCameraV2InstallPreviewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, J3, K3));
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
        } else if (i == 3) {
            g gVar3 = this.p3;
            if (gVar3 != null) {
                z = true;
            }
            if (z) {
                gVar3.onClick(view);
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.P3;
            this.P3 = 0L;
        }
        d<Integer> dVar = this.H3;
        String str = this.I3;
        int i = ((33 & j) > 0L ? 1 : ((33 & j) == 0L ? 0 : -1));
        int i2 = ((36 & j) > 0L ? 1 : ((36 & j) == 0L ? 0 : -1));
        if ((j & 32) != 0) {
            this.f6894c.setOnClickListener(this.N3);
            this.f6895d.setOnClickListener(this.M3);
            this.q.setOnClickListener(this.O3);
        }
        if (i != 0) {
            y.f(this.p0, dVar);
        }
        if (i2 != 0) {
            y.g(this.p0, str);
        }
    }

    @Override // com.tplink.iot.databinding.FragmentCameraV2InstallPreviewBinding
    public void h(@Nullable d<Integer> dVar) {
        this.H3 = dVar;
        synchronized (this) {
            this.P3 |= 1;
        }
        notifyPropertyChanged(86);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.P3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.FragmentCameraV2InstallPreviewBinding
    public void i(@Nullable String str) {
        this.I3 = str;
        synchronized (this) {
            this.P3 |= 4;
        }
        notifyPropertyChanged(101);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.P3 = 32L;
        }
        requestRebind();
    }

    public void l(@Nullable CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.p2 = cameraOnBoardingViewModel;
    }

    public void m(@Nullable g gVar) {
        this.p3 = gVar;
        synchronized (this) {
            this.P3 |= 2;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    public void n(@Nullable CameraInstallPreviewViewModel cameraInstallPreviewViewModel) {
        this.p1 = cameraInstallPreviewViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (86 == i) {
            h((d) obj);
        } else if (79 == i) {
            m((g) obj);
        } else if (101 == i) {
            i((String) obj);
        } else if (68 == i) {
            l((CameraOnBoardingViewModel) obj);
        } else if (103 != i) {
            return false;
        } else {
            n((CameraInstallPreviewViewModel) obj);
        }
        return true;
    }

    private FragmentCameraV2InstallPreviewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (TextView) objArr[3], (LinearLayout) objArr[6], (ImageView) objArr[1], (Toolbar) objArr[5], (TextView) objArr[8], (TextView) objArr[7], (VideoSurfaceViewLayout) objArr[2]);
        this.P3 = -1L;
        this.f6894c.setTag(null);
        this.f6895d.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.L3 = linearLayout;
        linearLayout.setTag(null);
        this.q.setTag(null);
        this.p0.setTag(null);
        setRootTag(view);
        this.M3 = new a(this, 2);
        this.N3 = new a(this, 3);
        this.O3 = new a(this, 1);
        invalidateAll();
    }
}
