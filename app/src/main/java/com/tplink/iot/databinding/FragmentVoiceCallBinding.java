package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentVoiceCallBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7136c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7137d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7138f;
    @NonNull
    public final TextView p0;
    @Bindable
    protected TalkViewModel p1;
    @Bindable
    protected View.OnClickListener p2;
    @NonNull
    public final TextView q;
    @NonNull
    public final ImageView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final ImageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentVoiceCallBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, ImageView imageView3, TextView textView3, ImageView imageView4, TextView textView4) {
        super(obj, view, i);
        this.f7136c = imageView;
        this.f7137d = imageView2;
        this.f7138f = textView;
        this.q = textView2;
        this.x = imageView3;
        this.y = textView3;
        this.z = imageView4;
        this.p0 = textView4;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable TalkViewModel talkViewModel);
}
