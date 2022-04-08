package com.tplink.iot.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraTroubleShootingViewModel;

/* loaded from: classes2.dex */
public class FragmentCameraV2TroubleShootingBindingImpl extends FragmentCameraV2TroubleShootingBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts H3 = null;
    @Nullable
    private static final SparseIntArray I3;
    @NonNull
    private final LinearLayout J3;
    @NonNull
    private final TextView K3;
    @NonNull
    private final TextView L3;
    @NonNull
    private final ImageView M3;
    @NonNull
    private final TextView N3;
    @NonNull
    private final TextView O3;
    @NonNull
    private final ImageView P3;
    @Nullable
    private final View.OnClickListener Q3;
    private long R3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 8);
        sparseIntArray.put(R.id.ll_layout, 9);
        sparseIntArray.put(R.id.title, 10);
        sparseIntArray.put(R.id.tipsTextView, 11);
        sparseIntArray.put(R.id.dividerView1, 12);
        sparseIntArray.put(R.id.step1, 13);
        sparseIntArray.put(R.id.dividerView2, 14);
        sparseIntArray.put(R.id.step2, 15);
    }

    public FragmentCameraV2TroubleShootingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, H3, I3));
    }

    private boolean h(ObservableField<Drawable> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 2;
        }
        return true;
    }

    private boolean i(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 1;
        }
        return true;
    }

    private boolean l(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 8;
        }
        return true;
    }

    private boolean m(ObservableField<Drawable> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 32;
        }
        return true;
    }

    private boolean n(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 16;
        }
        return true;
    }

    private boolean o(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R3 |= 4;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.p3;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.FragmentCameraV2TroubleShootingBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.R3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.R3 = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return i((ObservableField) obj, i2);
        }
        if (i == 1) {
            return h((ObservableField) obj, i2);
        }
        if (i == 2) {
            return o((ObservableField) obj, i2);
        }
        if (i == 3) {
            return l((ObservableField) obj, i2);
        }
        if (i == 4) {
            return n((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return m((ObservableField) obj, i2);
    }

    public void p(@Nullable g gVar) {
        this.p3 = gVar;
        synchronized (this) {
            this.R3 |= 64;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    public void q(@Nullable CameraTroubleShootingViewModel cameraTroubleShootingViewModel) {
        this.p2 = cameraTroubleShootingViewModel;
        synchronized (this) {
            this.R3 |= 128;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 == i) {
            p((g) obj);
        } else if (103 != i) {
            return false;
        } else {
            q((CameraTroubleShootingViewModel) obj);
        }
        return true;
    }

    private FragmentCameraV2TroubleShootingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (Button) objArr[7], (FrameLayout) objArr[12], (FrameLayout) objArr[14], (RelativeLayout) objArr[9], (LinearLayout) objArr[13], (LinearLayout) objArr[15], (TextView) objArr[11], (TextView) objArr[10], (Toolbar) objArr[8]);
        this.R3 = -1L;
        this.f6951c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.J3 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.K3 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.L3 = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.M3 = imageView;
        imageView.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.N3 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.O3 = textView4;
        textView4.setTag(null);
        ImageView imageView2 = (ImageView) objArr[6];
        this.P3 = imageView2;
        imageView2.setTag(null);
        setRootTag(view);
        this.Q3 = new a(this, 1);
        invalidateAll();
    }
}
