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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraTapoCareIntroduceViewModel;

/* loaded from: classes2.dex */
public class FragmentCameraV2IntroduceTapoCareBindingImpl extends FragmentCameraV2IntroduceTapoCareBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts I3 = null;
    @Nullable
    private static final SparseIntArray J3;
    @NonNull
    private final LinearLayout K3;
    @Nullable
    private final View.OnClickListener L3;
    @Nullable
    private final View.OnClickListener M3;
    @Nullable
    private final View.OnClickListener N3;
    @Nullable
    private final View.OnClickListener O3;
    private long P3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        J3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 5);
        sparseIntArray.put(R.id.ll_content, 6);
        sparseIntArray.put(R.id.tv_title, 7);
        sparseIntArray.put(R.id.tv_tips, 8);
        sparseIntArray.put(R.id.image_introduce, 9);
    }

    public FragmentCameraV2IntroduceTapoCareBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, I3, J3));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.H3;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.H3;
            if (gVar2 != null) {
                z = true;
            }
            if (z) {
                gVar2.onClick(view);
            }
        } else if (i == 3) {
            g gVar3 = this.H3;
            if (gVar3 != null) {
                z = true;
            }
            if (z) {
                gVar3.onClick(view);
            }
        } else if (i == 4) {
            g gVar4 = this.H3;
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
            j = this.P3;
            this.P3 = 0L;
        }
        if ((j & 8) != 0) {
            this.f6900c.setOnClickListener(this.O3);
            this.f6901d.setOnClickListener(this.M3);
            this.f6902f.setOnClickListener(this.N3);
            this.q.setOnClickListener(this.L3);
        }
    }

    public void h(@Nullable CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.p3 = cameraOnBoardingViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.P3 != 0;
        }
    }

    public void i(@Nullable g gVar) {
        this.H3 = gVar;
        synchronized (this) {
            this.P3 |= 1;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.P3 = 8L;
        }
        requestRebind();
    }

    public void l(@Nullable CameraTapoCareIntroduceViewModel cameraTapoCareIntroduceViewModel) {
        this.p2 = cameraTapoCareIntroduceViewModel;
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
            l((CameraTapoCareIntroduceViewModel) obj);
        }
        return true;
    }

    private FragmentCameraV2IntroduceTapoCareBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[2], (TextView) objArr[4], (TextView) objArr[1], (TextView) objArr[3], (ImageView) objArr[9], (LinearLayout) objArr[6], (Toolbar) objArr[5], (TextView) objArr[8], (TextView) objArr[7]);
        this.P3 = -1L;
        this.f6900c.setTag(null);
        this.f6901d.setTag(null);
        this.f6902f.setTag(null);
        this.q.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.K3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.L3 = new a(this, 3);
        this.M3 = new a(this, 4);
        this.N3 = new a(this, 1);
        this.O3 = new a(this, 2);
        invalidateAll();
    }
}
