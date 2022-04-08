package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.ScheduleWeekdayTextView;
import com.tplink.iot.viewmodel.ipcamera.setting.MsgPushViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

/* loaded from: classes2.dex */
public abstract class ActivityMsgPushBinding extends ViewDataBinding {
    @NonNull
    public final View H3;
    @NonNull
    public final ScheduleWeekdayTextView I3;
    @Bindable
    protected View.OnClickListener J3;
    @Bindable
    protected MsgPushViewModel K3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RadioButton f6633c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RadioButton f6634d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f6635f;
    @NonNull
    public final CheckBox p0;
    @NonNull
    public final NoninteractiveCheckBox p1;
    @NonNull
    public final RadioGroup p2;
    @NonNull
    public final LinearLayout p3;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final LinearLayout z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityMsgPushBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, CheckBox checkBox, NoninteractiveCheckBox noninteractiveCheckBox, RadioGroup radioGroup, LinearLayout linearLayout2, View view2, ScheduleWeekdayTextView scheduleWeekdayTextView) {
        super(obj, view, i);
        this.f6633c = radioButton;
        this.f6634d = radioButton2;
        this.f6635f = relativeLayout;
        this.q = textView;
        this.x = textView2;
        this.y = textView3;
        this.z = linearLayout;
        this.p0 = checkBox;
        this.p1 = noninteractiveCheckBox;
        this.p2 = radioGroup;
        this.p3 = linearLayout2;
        this.H3 = view2;
        this.I3 = scheduleWeekdayTextView;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable MsgPushViewModel msgPushViewModel);
}
