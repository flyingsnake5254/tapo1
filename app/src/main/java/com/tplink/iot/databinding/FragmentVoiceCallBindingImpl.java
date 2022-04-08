package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

/* loaded from: classes2.dex */
public class FragmentVoiceCallBindingImpl extends FragmentVoiceCallBinding {
    @Nullable
    private static final SparseIntArray H3 = null;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3 = null;
    @NonNull
    private final ConstraintLayout I3;
    private a J3;
    private long K3;

    /* loaded from: classes2.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        private View.OnClickListener f7139c;

        public a a(View.OnClickListener onClickListener) {
            this.f7139c = onClickListener;
            if (onClickListener == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f7139c.onClick(view);
        }
    }

    public FragmentVoiceCallBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, p3, H3));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 4;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 2;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 8;
        }
        return true;
    }

    private boolean o(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x015d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.FragmentVoiceCallBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.FragmentVoiceCallBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.p2 = onClickListener;
        synchronized (this) {
            this.K3 |= 16;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.K3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.FragmentVoiceCallBinding
    public void i(@Nullable TalkViewModel talkViewModel) {
        this.p1 = talkViewModel;
        synchronized (this) {
            this.K3 |= 32;
        }
        notifyPropertyChanged(97);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.K3 = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((ObservableField) obj, i2);
        }
        if (i == 1) {
            return m((ObservableBoolean) obj, i2);
        }
        if (i == 2) {
            return l((ObservableBoolean) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return n((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (55 == i) {
            h((View.OnClickListener) obj);
        } else if (97 != i) {
            return false;
        } else {
            i((TalkViewModel) obj);
        }
        return true;
    }

    private FragmentVoiceCallBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ImageView) objArr[2], (ImageView) objArr[3], (TextView) objArr[8], (TextView) objArr[6], (ImageView) objArr[5], (TextView) objArr[7], (ImageView) objArr[4], (TextView) objArr[1]);
        this.K3 = -1L;
        this.f7136c.setTag(null);
        this.f7137d.setTag(null);
        this.f7138f.setTag(null);
        this.q.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.I3 = constraintLayout;
        constraintLayout.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.p0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
