package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.liveViewSettingButton.RippleLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

/* loaded from: classes2.dex */
public abstract class LayoutVoiceTalkPanelBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7322c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7323d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RippleLayout f7324f;
    @NonNull
    public final ImageView q;
    @NonNull
    public final ImageButton x;
    @Bindable
    protected TalkViewModel y;
    @Bindable
    protected g z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutVoiceTalkPanelBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, RippleLayout rippleLayout, ImageView imageView3, ImageButton imageButton) {
        super(obj, view, i);
        this.f7322c = imageView;
        this.f7323d = imageView2;
        this.f7324f = rippleLayout;
        this.q = imageView3;
        this.x = imageButton;
    }

    public abstract void h(@Nullable g gVar);

    public abstract void i(@Nullable TalkViewModel talkViewModel);
}
