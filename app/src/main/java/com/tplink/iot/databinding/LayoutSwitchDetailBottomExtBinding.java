package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.switches.viewmodel.SwitchDetailViewModel;
import com.tplink.iot.widget.businessview.ThingNextEventView;
import com.tplink.iot.widget.businessview.ThingUsageView;

/* loaded from: classes2.dex */
public abstract class LayoutSwitchDetailBottomExtBinding extends ViewDataBinding {
    @Bindable
    protected SwitchDetailViewModel H3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7295c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7296d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7297f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final TextView p1;
    @NonNull
    public final TextView p2;
    @Bindable
    protected View.OnClickListener p3;
    @NonNull
    public final LinearLayout q;
    @NonNull
    public final LinearLayout x;
    @NonNull
    public final ThingNextEventView y;
    @NonNull
    public final ThingUsageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutSwitchDetailBottomExtBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, ThingNextEventView thingNextEventView, ThingUsageView thingUsageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7295c = imageView;
        this.f7296d = imageView2;
        this.f7297f = imageView3;
        this.q = linearLayout;
        this.x = linearLayout2;
        this.y = thingNextEventView;
        this.z = thingUsageView;
        this.p0 = textView;
        this.p1 = textView2;
        this.p2 = textView3;
    }
}
