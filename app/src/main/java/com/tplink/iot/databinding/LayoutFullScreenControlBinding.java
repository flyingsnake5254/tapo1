package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

/* loaded from: classes2.dex */
public abstract class LayoutFullScreenControlBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7235c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7236d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7237f;
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
    public LayoutFullScreenControlBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5) {
        super(obj, view, i);
        this.f7235c = imageView;
        this.f7236d = imageView2;
        this.f7237f = imageView3;
        this.q = imageView4;
        this.x = imageView5;
    }

    public abstract void h(@Nullable MultiLiveVideoViewModel multiLiveVideoViewModel);

    public abstract void i(@Nullable VideoPlayViewModel videoPlayViewModel);

    public abstract void l(@Nullable g gVar);

    public abstract void m(@Nullable TalkViewModel talkViewModel);
}
