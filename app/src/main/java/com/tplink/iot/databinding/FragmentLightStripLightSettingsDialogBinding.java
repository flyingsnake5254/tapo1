package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes2.dex */
public abstract class FragmentLightStripLightSettingsDialogBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TabLayout f7026c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ViewPager2 f7027d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f7028f;
    @NonNull
    public final ImageView q;
    @NonNull
    public final ImageView x;
    @NonNull
    public final LinearLayout y;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentLightStripLightSettingsDialogBinding(Object obj, View view, int i, TabLayout tabLayout, ViewPager2 viewPager2, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f7026c = tabLayout;
        this.f7027d = viewPager2;
        this.f7028f = frameLayout;
        this.q = imageView;
        this.x = imageView2;
        this.y = linearLayout;
    }
}
