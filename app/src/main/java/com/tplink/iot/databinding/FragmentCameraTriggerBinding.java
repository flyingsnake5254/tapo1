package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public abstract class FragmentCameraTriggerBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f6849c;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraTriggerBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f6849c = recyclerView;
    }
}
