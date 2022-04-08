package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.calendar.WeekdayView;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

/* loaded from: classes2.dex */
public abstract class LayoutPlayBackFullscreenCalendarBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f7274c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7275d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7276f;
    @Bindable
    protected b p0;
    @Bindable
    protected PlayBackControlViewModel p1;
    @Bindable
    protected c p2;
    @NonNull
    public final TextView q;
    @NonNull
    public final ScrollCalendar x;
    @NonNull
    public final WeekdayView y;
    @Bindable
    protected g z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutPlayBackFullscreenCalendarBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, ScrollCalendar scrollCalendar, WeekdayView weekdayView) {
        super(obj, view, i);
        this.f7274c = textView;
        this.f7275d = imageView;
        this.f7276f = imageView2;
        this.q = textView2;
        this.x = scrollCalendar;
        this.y = weekdayView;
    }

    public abstract void h(@Nullable b bVar);

    public abstract void i(@Nullable c cVar);

    public abstract void l(@Nullable g gVar);

    public abstract void m(@Nullable PlayBackControlViewModel playBackControlViewModel);
}
