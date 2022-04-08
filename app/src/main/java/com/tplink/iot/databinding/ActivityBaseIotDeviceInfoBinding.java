package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.ItemSettingLayout;

/* loaded from: classes2.dex */
public abstract class ActivityBaseIotDeviceInfoBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f6506c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ItemSettingLayout f6507d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ItemSettingLayout f6508f;
    @NonNull
    public final ItemSettingLayout p0;
    @NonNull
    public final ItemSettingLayout p1;
    @NonNull
    public final ItemSettingLayout q;
    @NonNull
    public final ItemSettingLayout x;
    @NonNull
    public final ItemSettingLayout y;
    @NonNull
    public final ImageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityBaseIotDeviceInfoBinding(Object obj, View view, int i, View view2, ItemSettingLayout itemSettingLayout, ItemSettingLayout itemSettingLayout2, ItemSettingLayout itemSettingLayout3, ItemSettingLayout itemSettingLayout4, ItemSettingLayout itemSettingLayout5, ImageView imageView, ItemSettingLayout itemSettingLayout6, ItemSettingLayout itemSettingLayout7) {
        super(obj, view, i);
        this.f6506c = view2;
        this.f6507d = itemSettingLayout;
        this.f6508f = itemSettingLayout2;
        this.q = itemSettingLayout3;
        this.x = itemSettingLayout4;
        this.y = itemSettingLayout5;
        this.z = imageView;
        this.p0 = itemSettingLayout6;
        this.p1 = itemSettingLayout7;
    }
}
