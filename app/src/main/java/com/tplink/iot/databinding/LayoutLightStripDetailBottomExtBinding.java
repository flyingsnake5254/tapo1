package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripDetailViewModel;
import com.tplink.iot.widget.businessview.ThingNextEventView;
import com.tplink.iot.widget.businessview.ThingUsageView;
import com.tplink.iot.widget.viewgroup.MultiFeaturesGridView;

/* loaded from: classes2.dex */
public abstract class LayoutLightStripDetailBottomExtBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final MultiFeaturesGridView f7250c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ThingNextEventView f7251d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ThingUsageView f7252f;
    @Bindable
    protected View.OnClickListener q;
    @Bindable
    protected LightStripDetailViewModel x;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutLightStripDetailBottomExtBinding(Object obj, View view, int i, MultiFeaturesGridView multiFeaturesGridView, ThingNextEventView thingNextEventView, ThingUsageView thingUsageView) {
        super(obj, view, i);
        this.f7250c = multiFeaturesGridView;
        this.f7251d = thingNextEventView;
        this.f7252f = thingUsageView;
    }
}
