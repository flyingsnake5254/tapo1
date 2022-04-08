package com.tplink.iot.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.liveViewSettingButton.RippleLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

/* loaded from: classes2.dex */
public class LayoutVoiceTalkPanelBindingImpl extends LayoutVoiceTalkPanelBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p0 = null;
    @Nullable
    private static final SparseIntArray p1 = null;
    @Nullable
    private final View.OnClickListener H3;
    @Nullable
    private final View.OnClickListener I3;
    @Nullable
    private final View.OnClickListener J3;
    @Nullable
    private final View.OnClickListener K3;
    private long L3;
    @NonNull
    private final RelativeLayout p2;
    @Nullable
    private final View.OnClickListener p3;

    public LayoutVoiceTalkPanelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, p0, p1));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L3 |= 1;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L3 |= 8;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L3 |= 2;
        }
        return true;
    }

    private boolean o(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L3 |= 4;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.z;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.z;
            if (gVar2 != null) {
                z = true;
            }
            if (z) {
                gVar2.onClick(view);
            }
        } else if (i == 3) {
            g gVar3 = this.z;
            if (gVar3 != null) {
                z = true;
            }
            if (z) {
                gVar3.onClick(view);
            }
        } else if (i == 4) {
            g gVar4 = this.z;
            if (gVar4 != null) {
                z = true;
            }
            if (z) {
                gVar4.onClick(view);
            }
        } else if (i == 5) {
            g gVar5 = this.z;
            if (gVar5 != null) {
                z = true;
            }
            if (z) {
                gVar5.onClick(view);
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        boolean z;
        Drawable drawable;
        boolean z2;
        int i2;
        float f2;
        int i3;
        Context context;
        long j2;
        long j3;
        int i4;
        Context context2;
        synchronized (this) {
            j = this.L3;
            this.L3 = 0L;
        }
        TalkViewModel talkViewModel = this.y;
        Drawable drawable2 = null;
        if ((111 & j) != 0) {
            int i5 = ((j & 97) > 0L ? 1 : ((j & 97) == 0L ? 0 : -1));
            if (i5 != 0) {
                ObservableBoolean observableBoolean = talkViewModel != null ? talkViewModel.j : null;
                updateRegistration(0, observableBoolean);
                z2 = observableBoolean != null ? observableBoolean.get() : false;
                if (i5 != 0) {
                    j |= z2 ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                f2 = z2 ? 1.0f : 0.3f;
            } else {
                z2 = false;
                f2 = 0.0f;
            }
            int i6 = ((j & 98) > 0L ? 1 : ((j & 98) == 0L ? 0 : -1));
            if (i6 != 0) {
                ObservableBoolean observableBoolean2 = talkViewModel != null ? talkViewModel.h : null;
                updateRegistration(1, observableBoolean2);
                boolean z3 = observableBoolean2 != null ? observableBoolean2.get() : false;
                if (i6 != 0) {
                    j |= z3 ? 256L : 128L;
                }
                if (z3) {
                    context2 = this.f7323d.getContext();
                    i4 = R.drawable.full_screen_microphone_off;
                } else {
                    context2 = this.f7323d.getContext();
                    i4 = R.drawable.full_screen_microphone_on;
                }
                drawable = AppCompatResources.getDrawable(context2, i4);
            } else {
                drawable = null;
            }
            int i7 = ((j & 100) > 0L ? 1 : ((j & 100) == 0L ? 0 : -1));
            if (i7 != 0) {
                ObservableBoolean observableBoolean3 = talkViewModel != null ? talkViewModel.m : null;
                updateRegistration(2, observableBoolean3);
                z = observableBoolean3 != null ? observableBoolean3.get() : false;
                if (i7 != 0) {
                    if (z) {
                        j3 = j | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                        j2 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    } else {
                        j3 = j | 512;
                        j2 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                    j = j3 | j2;
                }
                i2 = 8;
                i = z ? 8 : 0;
                if (z) {
                    i2 = 0;
                }
            } else {
                i2 = 0;
                z = false;
                i = 0;
            }
            int i8 = ((j & 104) > 0L ? 1 : ((j & 104) == 0L ? 0 : -1));
            if (i8 != 0) {
                ObservableBoolean observableBoolean4 = talkViewModel != null ? talkViewModel.i : null;
                updateRegistration(3, observableBoolean4);
                boolean z4 = observableBoolean4 != null ? observableBoolean4.get() : false;
                if (i8 != 0) {
                    j |= z4 ? 16384L : 8192L;
                }
                if (z4) {
                    context = this.q.getContext();
                    i3 = R.drawable.full_screen_speaker_off;
                } else {
                    context = this.q.getContext();
                    i3 = R.drawable.full_screen_speaker_on;
                }
                drawable2 = AppCompatResources.getDrawable(context, i3);
            }
        } else {
            drawable = null;
            drawable2 = null;
            f2 = 0.0f;
            i2 = 0;
            z2 = false;
            z = false;
            i = 0;
        }
        if ((j & 64) != 0) {
            this.f7322c.setOnClickListener(this.I3);
            this.f7323d.setOnClickListener(this.p3);
            this.f7324f.setOnClickListener(this.K3);
            this.q.setOnClickListener(this.J3);
            this.x.setOnClickListener(this.H3);
        }
        if ((j & 100) != 0) {
            this.f7322c.setVisibility(i2);
            b.Q(this.f7323d, z);
            this.f7324f.setVisibility(i);
            b.u(this.q, z);
        }
        if ((98 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f7323d, drawable);
        }
        if ((104 & j) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.q, drawable2);
        }
        if ((j & 97) != 0) {
            this.x.setEnabled(z2);
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.x.setAlpha(f2);
            }
        }
    }

    @Override // com.tplink.iot.databinding.LayoutVoiceTalkPanelBinding
    public void h(@Nullable g gVar) {
        this.z = gVar;
        synchronized (this) {
            this.L3 |= 16;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.L3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.LayoutVoiceTalkPanelBinding
    public void i(@Nullable TalkViewModel talkViewModel) {
        this.y = talkViewModel;
        synchronized (this) {
            this.L3 |= 32;
        }
        notifyPropertyChanged(96);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.L3 = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return l((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return n((ObservableBoolean) obj, i2);
        }
        if (i == 2) {
            return o((ObservableBoolean) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return m((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 == i) {
            h((g) obj);
        } else if (96 != i) {
            return false;
        } else {
            i((TalkViewModel) obj);
        }
        return true;
    }

    private LayoutVoiceTalkPanelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ImageView) objArr[1], (ImageView) objArr[5], (RippleLayout) objArr[2], (ImageView) objArr[4], (ImageButton) objArr[3]);
        this.L3 = -1L;
        this.f7322c.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.p2 = relativeLayout;
        relativeLayout.setTag(null);
        this.f7323d.setTag(null);
        this.f7324f.setTag(null);
        this.q.setTag(null);
        this.x.setTag(null);
        setRootTag(view);
        this.p3 = new a(this, 5);
        this.H3 = new a(this, 3);
        this.I3 = new a(this, 1);
        this.J3 = new a(this, 4);
        this.K3 = new a(this, 2);
        invalidateAll();
    }
}
