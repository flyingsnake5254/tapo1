package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

/* loaded from: classes2.dex */
public abstract class LayoutFullScreenBottomBarBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f7232c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7233d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7234f;
    @Bindable
    protected VideoPlayViewModel p0;
    @Bindable
    protected TalkViewModel p1;
    @NonNull
    public final ImageView q;
    @NonNull
    public final ImageView x;
    @Bindable
    protected g y;
    @Bindable
    protected MultiLiveVideoViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutFullScreenBottomBarBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        super(obj, view, i);
        this.f7232c = textView;
        this.f7233d = textView2;
        this.f7234f = imageView;
        this.q = imageView2;
        this.x = imageView3;
    }

    public abstract void h(@Nullable MultiLiveVideoViewModel multiLiveVideoViewModel);

    public abstract void i(@Nullable VideoPlayViewModel videoPlayViewModel);

    public abstract void l(@Nullable g gVar);

    public abstract void m(@Nullable TalkViewModel talkViewModel);
}
