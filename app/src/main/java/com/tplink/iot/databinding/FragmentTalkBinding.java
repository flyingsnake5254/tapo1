package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.liveViewSettingButton.RippleLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentTalkBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7114c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7115d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RippleLayout f7116f;
    @NonNull
    public final ImageButton q;
    @Bindable
    protected TalkViewModel x;
    @Bindable
    protected View.OnClickListener y;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTalkBinding(Object obj, View view, int i, ImageView imageView, TextView textView, RippleLayout rippleLayout, ImageButton imageButton) {
        super(obj, view, i);
        this.f7114c = imageView;
        this.f7115d = textView;
        this.f7116f = rippleLayout;
        this.q = imageButton;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable TalkViewModel talkViewModel);
}
