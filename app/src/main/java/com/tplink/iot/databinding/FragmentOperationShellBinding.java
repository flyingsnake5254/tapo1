package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes2.dex */
public abstract class FragmentOperationShellBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7038c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Guideline f7039d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Guideline f7040f;
    @NonNull
    public final MagicIndicator q;
    @NonNull
    public final ImageView x;
    @NonNull
    public final ViewPager y;
    @Bindable
    protected MutableLiveData<Boolean> z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentOperationShellBinding(Object obj, View view, int i, ImageView imageView, Guideline guideline, Guideline guideline2, MagicIndicator magicIndicator, ImageView imageView2, ViewPager viewPager) {
        super(obj, view, i);
        this.f7038c = imageView;
        this.f7039d = guideline;
        this.f7040f = guideline2;
        this.q = magicIndicator;
        this.x = imageView2;
        this.y = viewPager;
    }

    public abstract void h(@Nullable MutableLiveData<Boolean> mutableLiveData);
}
