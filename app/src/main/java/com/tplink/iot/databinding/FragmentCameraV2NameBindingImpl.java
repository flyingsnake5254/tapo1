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
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSetNameViewModel;
import com.tplink.iot.widget.DrawableEditText;

/* loaded from: classes2.dex */
public class FragmentCameraV2NameBindingImpl extends FragmentCameraV2NameBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p2 = null;
    @Nullable
    private static final SparseIntArray p3;
    @NonNull
    private final LinearLayout H3;
    @Nullable
    private final View.OnClickListener I3;
    private InverseBindingListener J3;
    private long K3;

    /* loaded from: classes2.dex */
    class a implements InverseBindingListener {
        a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            String d2 = b.d(FragmentCameraV2NameBindingImpl.this.f6916d);
            CameraOnBoardingViewModel cameraOnBoardingViewModel = FragmentCameraV2NameBindingImpl.this.p0;
            boolean z = true;
            if (cameraOnBoardingViewModel != null) {
                ObservableField<String> observableField = cameraOnBoardingViewModel.f10405c;
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
        p3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        sparseIntArray.put(R.id.rl_content, 4);
        sparseIntArray.put(R.id.tv_title, 5);
        sparseIntArray.put(R.id.tv_tip, 6);
    }

    public FragmentCameraV2NameBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, p2, p3));
    }

    private boolean h(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 1;
        }
        return true;
    }

    private boolean i(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 2;
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r12 = this;
            monitor-enter(r12)
            long r0 = r12.K3     // Catch: all -> 0x0063
            r2 = 0
            r12.K3 = r2     // Catch: all -> 0x0063
            monitor-exit(r12)     // Catch: all -> 0x0063
            com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel r4 = r12.p0
            com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSetNameViewModel r5 = r12.z
            r6 = 41
            long r6 = r6 & r0
            r8 = 0
            r9 = 0
            int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r10 == 0) goto L_0x0027
            if (r4 == 0) goto L_0x001a
            androidx.databinding.ObservableField<java.lang.String> r4 = r4.f10405c
            goto L_0x001b
        L_0x001a:
            r4 = r9
        L_0x001b:
            r12.updateRegistration(r8, r4)
            if (r4 == 0) goto L_0x0027
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0028
        L_0x0027:
            r4 = r9
        L_0x0028:
            r6 = 50
            long r6 = r6 & r0
            int r11 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r11 == 0) goto L_0x003f
            if (r5 == 0) goto L_0x0034
            androidx.databinding.ObservableBoolean r5 = r5.a
            goto L_0x0035
        L_0x0034:
            r5 = r9
        L_0x0035:
            r6 = 1
            r12.updateRegistration(r6, r5)
            if (r5 == 0) goto L_0x003f
            boolean r8 = r5.get()
        L_0x003f:
            if (r11 == 0) goto L_0x0046
            android.widget.Button r5 = r12.f6915c
            r5.setEnabled(r8)
        L_0x0046:
            r5 = 32
            long r0 = r0 & r5
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x005b
            android.widget.Button r0 = r12.f6915c
            android.view.View$OnClickListener r1 = r12.I3
            r0.setOnClickListener(r1)
            com.tplink.iot.widget.DrawableEditText r0 = r12.f6916d
            androidx.databinding.InverseBindingListener r1 = r12.J3
            com.tplink.iot.view.ipcamera.base.b.I(r0, r9, r9, r9, r1)
        L_0x005b:
            if (r10 == 0) goto L_0x0062
            com.tplink.iot.widget.DrawableEditText r0 = r12.f6916d
            com.tplink.iot.view.ipcamera.base.b.J(r0, r4)
        L_0x0062:
            return
        L_0x0063:
            r0 = move-exception
            monitor-exit(r12)     // Catch: all -> 0x0063
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.FragmentCameraV2NameBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.K3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.K3 = 32L;
        }
        requestRebind();
    }

    public void l(@Nullable CameraOnBoardingViewModel cameraOnBoardingViewModel) {
        this.p0 = cameraOnBoardingViewModel;
        synchronized (this) {
            this.K3 |= 8;
        }
        notifyPropertyChanged(68);
        super.requestRebind();
    }

    public void m(@Nullable g gVar) {
        this.p1 = gVar;
        synchronized (this) {
            this.K3 |= 4;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    public void n(@Nullable CameraSetNameViewModel cameraSetNameViewModel) {
        this.z = cameraSetNameViewModel;
        synchronized (this) {
            this.K3 |= 16;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return h((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return i((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 == i) {
            m((g) obj);
        } else if (68 == i) {
            l((CameraOnBoardingViewModel) obj);
        } else if (103 != i) {
            return false;
        } else {
            n((CameraSetNameViewModel) obj);
        }
        return true;
    }

    private FragmentCameraV2NameBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (Button) objArr[2], (DrawableEditText) objArr[1], (RelativeLayout) objArr[4], (Toolbar) objArr[3], (TextView) objArr[6], (TextView) objArr[5]);
        this.J3 = new a();
        this.K3 = -1L;
        this.f6915c.setTag(null);
        this.f6916d.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.H3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        this.I3 = new com.tplink.iot.generated.callback.a(this, 1);
        invalidateAll();
    }
}
