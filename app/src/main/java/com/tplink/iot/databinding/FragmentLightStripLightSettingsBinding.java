package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes2.dex */
public abstract class FragmentLightStripLightSettingsBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TabLayout f7023c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ViewPager2 f7024d;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentLightStripLightSettingsBinding(Object obj, View view, int i, TabLayout tabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f7023c = tabLayout;
        this.f7024d = viewPager2;
    }
}
