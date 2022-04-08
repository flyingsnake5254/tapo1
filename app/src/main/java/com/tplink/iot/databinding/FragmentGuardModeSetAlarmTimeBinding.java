package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.widget.NumberPickerView;

/* loaded from: classes2.dex */
public abstract class FragmentGuardModeSetAlarmTimeBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f7017c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final NumberPickerView f7018d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final NumberPickerView f7019f;
    @NonNull
    public final RecyclerView q;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentGuardModeSetAlarmTimeBinding(Object obj, View view, int i, LinearLayout linearLayout, NumberPickerView numberPickerView, NumberPickerView numberPickerView2, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f7017c = linearLayout;
        this.f7018d = numberPickerView;
        this.f7019f = numberPickerView2;
        this.q = recyclerView;
    }
}
