package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.OsdViewModel;
import com.tplink.iot.widget.ErrorBar;

/* loaded from: classes2.dex */
public class ActivityOsdNewIpcBindingImpl extends ActivityOsdNewIpcBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts I3 = null;
    @Nullable
    private static final SparseIntArray J3;
    @NonNull
    private final RelativeLayout K3;
    @NonNull
    private final LinearLayout L3;
    @NonNull
    private final LinearLayout M3;
    @NonNull
    private final LinearLayout N3;
    private InverseBindingListener O3;
    private InverseBindingListener P3;
    private InverseBindingListener Q3;
    private InverseBindingListener R3;
    private long S3;

    /* loaded from: classes2.dex */
    class a implements InverseBindingListener {
        a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(ActivityOsdNewIpcBindingImpl.this.q);
            OsdViewModel osdViewModel = ActivityOsdNewIpcBindingImpl.this.p3;
            boolean z = true;
            if (osdViewModel != null) {
                ObservableField<String> observableField = osdViewModel.f10811d;
                if (observableField == null) {
                    z = false;
                }
                if (z) {
                    observableField.set(textString);
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
            boolean isChecked = ActivityOsdNewIpcBindingImpl.this.x.isChecked();
            OsdViewModel osdViewModel = ActivityOsdNewIpcBindingImpl.this.p3;
            boolean z = true;
            if (osdViewModel != null) {
                ObservableBoolean observableBoolean = osdViewModel.f10809b;
                if (observableBoolean == null) {
                    z = false;
                }
                if (z) {
                    observableBoolean.set(isChecked);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements InverseBindingListener {
        c() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            boolean isChecked = ActivityOsdNewIpcBindingImpl.this.y.isChecked();
            OsdViewModel osdViewModel = ActivityOsdNewIpcBindingImpl.this.p3;
            boolean z = true;
            if (osdViewModel != null) {
                ObservableBoolean observableBoolean = osdViewModel.f10813f;
                if (observableBoolean == null) {
                    z = false;
                }
                if (z) {
                    observableBoolean.set(isChecked);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class d implements InverseBindingListener {
        d() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            boolean isChecked = ActivityOsdNewIpcBindingImpl.this.z.isChecked();
            OsdViewModel osdViewModel = ActivityOsdNewIpcBindingImpl.this.p3;
            boolean z = true;
            if (osdViewModel != null) {
                ObservableBoolean observableBoolean = osdViewModel.f10810c;
                if (observableBoolean == null) {
                    z = false;
                }
                if (z) {
                    observableBoolean.set(isChecked);
                }
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        J3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 10);
        sparseIntArray.put(R.id.title, 11);
        sparseIntArray.put(R.id.tv_text, 12);
        sparseIntArray.put(R.id.login_error_bar, 13);
    }

    public ActivityOsdNewIpcBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, I3, J3));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 32;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 4;
        }
        return true;
    }

    private boolean n(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 1;
        }
        return true;
    }

    private boolean o(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 2;
        }
        return true;
    }

    private boolean p(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 8;
        }
        return true;
    }

    private boolean q(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 16;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityOsdNewIpcBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityOsdNewIpcBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.H3 = onClickListener;
        synchronized (this) {
            this.S3 |= 64;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.S3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityOsdNewIpcBinding
    public void i(@Nullable OsdViewModel osdViewModel) {
        this.p3 = osdViewModel;
        synchronized (this) {
            this.S3 |= 128;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.S3 = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((ObservableField) obj, i2);
        }
        if (i == 1) {
            return o((ObservableBoolean) obj, i2);
        }
        if (i == 2) {
            return m((ObservableBoolean) obj, i2);
        }
        if (i == 3) {
            return p((ObservableBoolean) obj, i2);
        }
        if (i == 4) {
            return q((ObservableBoolean) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return l((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (2 == i) {
            h((View.OnClickListener) obj);
        } else if (105 != i) {
            return false;
        } else {
            i((OsdViewModel) obj);
        }
        return true;
    }

    private ActivityOsdNewIpcBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (ConstraintLayout) objArr[5], (CameraLoadingView) objArr[9], (ErrorBar) objArr[13], (TextView) objArr[6], (CheckBox) objArr[1], (CheckBox) objArr[8], (CheckBox) objArr[4], (TextView) objArr[11], (Toolbar) objArr[10], (TextView) objArr[12]);
        this.O3 = new a();
        this.P3 = new b();
        this.Q3 = new c();
        this.R3 = new d();
        this.S3 = -1L;
        this.f6636c.setTag(null);
        this.f6637d.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.K3 = relativeLayout;
        relativeLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.L3 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[3];
        this.M3 = linearLayout2;
        linearLayout2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[7];
        this.N3 = linearLayout3;
        linearLayout3.setTag(null);
        this.q.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
