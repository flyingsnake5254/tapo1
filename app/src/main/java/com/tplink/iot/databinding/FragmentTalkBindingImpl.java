package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.liveViewSettingButton.RippleLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

/* loaded from: classes2.dex */
public class FragmentTalkBindingImpl extends FragmentTalkBinding {
    @Nullable
    private static final SparseIntArray p0 = null;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts z = null;
    @NonNull
    private final ConstraintLayout p1;
    private a p2;
    private long p3;

    /* loaded from: classes2.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        private View.OnClickListener f7117c;

        public a a(View.OnClickListener onClickListener) {
            this.f7117c = onClickListener;
            if (onClickListener == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f7117c.onClick(view);
        }
    }

    public FragmentTalkBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, z, p0));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 1;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 2;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.FragmentTalkBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.FragmentTalkBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.y = onClickListener;
        synchronized (this) {
            this.p3 |= 4;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.FragmentTalkBinding
    public void i(@Nullable TalkViewModel talkViewModel) {
        this.x = talkViewModel;
        synchronized (this) {
            this.p3 |= 8;
        }
        notifyPropertyChanged(97);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p3 = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return l((ObservableBoolean) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return m((ObservableBoolean) obj, i2);
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

    private FragmentTalkBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[4], (TextView) objArr[1], (RippleLayout) objArr[2], (ImageButton) objArr[3]);
        this.p3 = -1L;
        this.f7114c.setTag(null);
        this.f7115d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.p1 = constraintLayout;
        constraintLayout.setTag(null);
        this.f7116f.setTag(null);
        this.q.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
