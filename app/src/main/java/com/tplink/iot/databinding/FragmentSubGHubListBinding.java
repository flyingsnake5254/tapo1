package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentSubGHubListBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f7069c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7070d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f7071f;
    @Bindable
    protected g p0;
    @NonNull
    public final RecyclerView q;
    @NonNull
    public final RecyclerView x;
    @NonNull
    public final TextView y;
    @Bindable
    protected SubGViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSubGHubListBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView) {
        super(obj, view, i);
        this.f7069c = frameLayout;
        this.f7070d = imageView;
        this.f7071f = linearLayout;
        this.q = recyclerView;
        this.x = recyclerView2;
        this.y = textView;
    }
}
