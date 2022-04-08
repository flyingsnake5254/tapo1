package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.a.a;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.scollitem.ScrollPlayRatePicker;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerRelativeLayout;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentPlayBackVideoBinding extends ViewDataBinding {
    @NonNull
    public final LayoutPalybackFullBottomBinding H3;
    @NonNull
    public final LayoutPlayBackFullscreenCalendarBinding I3;
    @NonNull
    public final LayoutPlayBackFullscreenFilterBinding J3;
    @NonNull
    public final LayoutPlaybackToolbarBottomBinding K3;
    @NonNull
    public final LayoutPlaybackToolbarTopBinding L3;
    @NonNull
    public final LayoutPlaybackToolbarPopupBinding M3;
    @NonNull
    public final TouchListenerRelativeLayout N3;
    @Bindable
    protected g O3;
    @Bindable
    protected PlaybackMainViewModel P3;
    @Bindable
    protected VodViewModel Q3;
    @Bindable
    protected PlayBackControlViewModel R3;
    @Bindable
    protected a S3;
    @Bindable
    protected ScrollPlayRatePicker.a T3;
    @Bindable
    protected b U3;
    @Bindable
    protected TimeAxisLayout.b V3;
    @Bindable
    protected c W3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7047c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f7048d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f7049f;
    @NonNull
    public final ImageView p0;
    @NonNull
    public final FrameLayout p1;
    @NonNull
    public final ImageView p2;
    @NonNull
    public final TextView p3;
    @NonNull
    public final FrameLayout q;
    @NonNull
    public final ImageView x;
    @NonNull
    public final ConstraintLayout y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentPlayBackVideoBinding(Object obj, View view, int i, ImageView imageView, RelativeLayout relativeLayout, View view2, FrameLayout frameLayout, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView, ImageView imageView3, FrameLayout frameLayout2, ImageView imageView4, TextView textView2, LayoutPalybackFullBottomBinding layoutPalybackFullBottomBinding, LayoutPlayBackFullscreenCalendarBinding layoutPlayBackFullscreenCalendarBinding, LayoutPlayBackFullscreenFilterBinding layoutPlayBackFullscreenFilterBinding, LayoutPlaybackToolbarBottomBinding layoutPlaybackToolbarBottomBinding, LayoutPlaybackToolbarTopBinding layoutPlaybackToolbarTopBinding, LayoutPlaybackToolbarPopupBinding layoutPlaybackToolbarPopupBinding, TouchListenerRelativeLayout touchListenerRelativeLayout) {
        super(obj, view, i);
        this.f7047c = imageView;
        this.f7048d = relativeLayout;
        this.f7049f = view2;
        this.q = frameLayout;
        this.x = imageView2;
        this.y = constraintLayout;
        this.z = textView;
        this.p0 = imageView3;
        this.p1 = frameLayout2;
        this.p2 = imageView4;
        this.p3 = textView2;
        this.H3 = layoutPalybackFullBottomBinding;
        this.I3 = layoutPlayBackFullscreenCalendarBinding;
        this.J3 = layoutPlayBackFullscreenFilterBinding;
        this.K3 = layoutPlaybackToolbarBottomBinding;
        this.L3 = layoutPlaybackToolbarTopBinding;
        this.M3 = layoutPlaybackToolbarPopupBinding;
        this.N3 = touchListenerRelativeLayout;
    }

    public abstract void h(@Nullable a aVar);

    public abstract void i(@Nullable b bVar);

    public abstract void l(@Nullable c cVar);

    public abstract void m(@Nullable ScrollPlayRatePicker.a aVar);

    public abstract void n(@Nullable PlayBackControlViewModel playBackControlViewModel);

    public abstract void o(@Nullable g gVar);

    public abstract void p(@Nullable TimeAxisLayout.b bVar);

    public abstract void q(@Nullable PlaybackMainViewModel playbackMainViewModel);

    public abstract void r(@Nullable VodViewModel vodViewModel);
}
