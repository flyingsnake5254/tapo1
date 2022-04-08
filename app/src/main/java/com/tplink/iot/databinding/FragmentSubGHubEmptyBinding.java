package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentSubGHubEmptyBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f7063c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7064d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f7065f;
    @Bindable
    protected SubGViewModel q;
    @Bindable
    protected g x;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSubGHubEmptyBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f7063c = frameLayout;
        this.f7064d = imageView;
        this.f7065f = recyclerView;
    }
}
