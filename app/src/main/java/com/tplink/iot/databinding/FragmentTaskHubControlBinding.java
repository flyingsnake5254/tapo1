package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public abstract class FragmentTaskHubControlBinding extends ViewDataBinding {
    @NonNull
    public final TextView H3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7121c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7122d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7123f;
    @NonNull
    public final LinearLayout p0;
    @NonNull
    public final RecyclerView p1;
    @NonNull
    public final TextView p2;
    @NonNull
    public final TextView p3;
    @NonNull
    public final RelativeLayout q;
    @NonNull
    public final RelativeLayout x;
    @NonNull
    public final RelativeLayout y;
    @NonNull
    public final FrameLayout z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTaskHubControlBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, FrameLayout frameLayout, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7121c = imageView;
        this.f7122d = imageView2;
        this.f7123f = imageView3;
        this.q = relativeLayout;
        this.x = relativeLayout2;
        this.y = relativeLayout3;
        this.z = frameLayout;
        this.p0 = linearLayout;
        this.p1 = recyclerView;
        this.p2 = textView;
        this.p3 = textView2;
        this.H3 = textView3;
    }
}
