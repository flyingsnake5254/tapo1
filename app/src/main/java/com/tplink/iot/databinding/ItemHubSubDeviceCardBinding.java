package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.RippleCardView;
import com.tplink.iot.widget.trv.MarqueeTextView;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;

/* loaded from: classes2.dex */
public abstract class ItemHubSubDeviceCardBinding extends ViewDataBinding {
    @NonNull
    public final TextView H3;
    @NonNull
    public final TextView I3;
    @NonNull
    public final MarqueeTextView J3;
    @NonNull
    public final MarqueeTextView K3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RippleCardView f7178c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TPCheckboxCompat f7179d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7180f;
    @NonNull
    public final RelativeLayout p0;
    @NonNull
    public final TextView p1;
    @NonNull
    public final TextView p2;
    @NonNull
    public final TextView p3;
    @NonNull
    public final ImageView q;
    @NonNull
    public final ImageView x;
    @NonNull
    public final RelativeLayout y;
    @NonNull
    public final RelativeLayout z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemHubSubDeviceCardBinding(Object obj, View view, int i, RippleCardView rippleCardView, TPCheckboxCompat tPCheckboxCompat, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, MarqueeTextView marqueeTextView, MarqueeTextView marqueeTextView2) {
        super(obj, view, i);
        this.f7178c = rippleCardView;
        this.f7179d = tPCheckboxCompat;
        this.f7180f = imageView;
        this.q = imageView2;
        this.x = imageView3;
        this.y = relativeLayout;
        this.z = relativeLayout2;
        this.p0 = relativeLayout3;
        this.p1 = textView;
        this.p2 = textView2;
        this.p3 = textView3;
        this.H3 = textView4;
        this.I3 = textView5;
        this.J3 = marqueeTextView;
        this.K3 = marqueeTextView2;
    }
}
