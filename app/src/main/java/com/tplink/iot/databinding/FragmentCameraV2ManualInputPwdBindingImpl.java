package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraManualInputPwdViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.DrawableEditText;

/* loaded from: classes2.dex */
public class FragmentCameraV2ManualInputPwdBindingImpl extends FragmentCameraV2ManualInputPwdBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts I3 = null;
    @Nullable
    private static final SparseIntArray J3;
    @NonNull
    private final LinearLayout K3;
    @Nullable
    private final View.OnClickListener L3;
    private InverseBindingListener M3;
    private InverseBindingListener N3;
    private long O3;

    /* loaded from: classes2.dex */
    class a implements InverseBindingListener {
        a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            String d2 = com.tplink.iot.view.ipcamera.base.b.d(FragmentCameraV2ManualInputPwdBindingImpl.this.f6913d);
            CameraOnBoardingViewModel cameraOnBoardingViewModel = FragmentCameraV2ManualInputPwdBindingImpl.this.p3;
            boolean z = true;
            if (cameraOnBoardingViewModel != null) {
                ObservableField<String> observableField = cameraOnBoardingViewModel.a;
                if (observableField == null) {
                    z = false;
                }
                if (z) {
                    observableField.set(d2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements InverseBindingListener {
        b() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            String d2 = com.tplink.iot.view.ipcamera.base.b.d(FragmentCameraV2ManualInputPwdBindingImpl.this.f6914f);
            CameraOnBoardingViewModel cameraOnBoardingViewModel = FragmentCameraV2ManualInputPwdBindingImpl.this.p3;
            boolean z = true;
            if (cameraOnBoardingViewModel != null) {
                ObservableField<String> observableField = cameraOnBoardingViewModel.f10404b;
                if (observableField == null) {
                    z = false;
                }
                if (z) {
                    observableField.set(d2);
                }
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        J3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 4);
        sparseIntArray.put(R.id.rl_content, 5);
        sparseIntArray.put(R.id.tv_title, 6);
        sparseIntArray.put(R.id.tv_tip_name, 7);
        sparseIntArray.put(R.id.tv_tip_password, 8);
        sparseIntArray.put(R.id.tv_password_tip, 9);
    }

    public FragmentCameraV2ManualInputPwdBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, I3, J3));
    }

    private boolean h(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.O3 |= 2;
        }
        return true;
    }

    private boolean i(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.O3 |= 1;
        }
        return true;
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.O3 |= 4;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.H3;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.FragmentCameraV2ManualInputPwdBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.O3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.O3 = 64L;
        }
        requestRebind();
    }

    public void m(@Nullable CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.p3 = cameraOnBoardingViewModel;
        synchronized (this) {
            this.O3 |= 16;
        }
        notifyPropertyChanged(68);
        super.requestRebind();
    }

    public void n(@Nullable g gVar) {
        this.H3 = gVar;
        synchronized (this) {
            this.O3 |= 8;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    public void o(@Nullable CameraManualInputPwdViewModel cameraManualInputPwdViewModel) {
        this.p2 = cameraManualInputPwdViewModel;
        synchronized (this) {
            this.O3 |= 32;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return i((ObservableField) obj, i2);
        }
        if (i == 1) {
            return h((ObservableField) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return l((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 == i) {
            n((g) obj);
        } else if (68 == i) {
            m((CameraOnBoardingViewModel) obj);
        } else if (103 != i) {
            return false;
        } else {
            o((CameraManualInputPwdViewModel) obj);
        }
        return true;
    }

    private FragmentCameraV2ManualInputPwdBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (Button) objArr[3], (DrawableEditText) objArr[1], (DrawableEditText) objArr[2], (RelativeLayout) objArr[5], (Toolbar) objArr[4], (TextView) objArr[9], (TextView) objArr[7], (TextView) objArr[8], (TextView) objArr[6]);
        this.M3 = new a();
        this.N3 = new b();
        this.O3 = -1L;
        this.f6912c.setTag(null);
        this.f6913d.setTag(null);
        this.f6914f.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.K3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.L3 = new com.tplink.iot.generated.callback.a(this, 1);
        invalidateAll();
    }
}
